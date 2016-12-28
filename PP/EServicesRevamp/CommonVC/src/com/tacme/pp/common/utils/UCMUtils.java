package com.tacme.pp.common.utils;

import com.tacme.pp.common.beans.UCMDocument;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import oracle.adf.share.logging.ADFLogger;
import oracle.jbo.ApplicationModule;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.stellent.ridc.IdcClient;
import oracle.stellent.ridc.IdcClientException;
import oracle.stellent.ridc.IdcClientManager;
import oracle.stellent.ridc.IdcContext;
import oracle.stellent.ridc.model.DataBinder;
import oracle.stellent.ridc.model.DataObject;
import oracle.stellent.ridc.model.DataResultSet;
import oracle.stellent.ridc.model.TransferFile;
import oracle.stellent.ridc.protocol.ServiceResponse;

public class UCMUtils
{
  private static String username;
  private static String password;
  private static String url;
  private static String replaceUrl;
  private static IdcContext userContext;
  private static IdcClient idcClient;
  private static ADFLogger _logger = ADFLogger.createADFLogger(UCMUtils.class);
  
  public UCMUtils()
  {
    intiateConnection();
  }
  
  private void intiateConnection()
  {
    try
    {
      _logger.entering(UCMUtils.class.toString(), "intiateConnection");
      
      _logger.info("Creating a UCMUtilities instance");
      
      _logger.info("getting viewobject with database configuration ");
      ViewObject configview = ADFUtils.getApplicationModuleForDataControl("PPAppServicesDataControl").findViewObject("UcmConfigView1");
      
      configview.setNamedWhereClauseParam("p_ucid", Integer.valueOf(3));
      configview.executeQuery();
      Row configrow = configview.first();
      username = (String)configrow.getAttribute("UcUsername");
      password = (String)configrow.getAttribute("UcPassword");
      String urlink = (String)configrow.getAttribute("UcUrl");
      String port = (String)configrow.getAttribute("UcPortno");
      replaceUrl = (String)configrow.getAttribute("ReplaceUrl");
      url = urlink + ":" + port;
      IdcClientManager manager = new IdcClientManager();
      idcClient = manager.createClient(url);
      userContext = new IdcContext(username, password);
      _logger.info("finished getting ucm configuration from database with >>  " + username + "," + password + "," + replaceUrl + "," + url);
    }
    catch (Exception e)
    {
      _logger.severe("Exception in intiateConnection ", e);
    }
    finally
    {
      _logger.exiting(UCMUtils.class.toString(), "intiateConnection");
    }
  }
  
  public static void createFolder(String folderName)
  {
    _logger.entering(UCMUtils.class.toString(), "createFolder");
    ServiceResponse severiceResponse = null;
    try
    {
      _logger.info("Creating Folder: " + folderName);
      long ParentCollectionID = getCollectionIdByPath("/Contribution Folders/eService").longValue();
      
      _logger.info("Parrent collection id :: " + ParentCollectionID);
      DataBinder dataBinderReq = idcClient.createBinder();
      dataBinderReq.putLocal("IdcService", "COLLECTION_ADD");
      dataBinderReq.putLocal("dCollectionName", folderName);
      dataBinderReq.putLocal("hasParentCollectionID", "true");
      dataBinderReq.putLocal("dParentCollectionID", "" + ParentCollectionID);
      
      dataBinderReq.putLocal("dCollectionOwner", username);
      dataBinderReq.putLocal("dSecurityGroup", "public");
      severiceResponse = idcClient.sendRequest(new IdcContext(username), dataBinderReq);
      
      _logger.info("Folder " + folderName + " successfully created");
    }
    catch (Exception ex)
    {
      _logger.severe("Error creating Folder: ", ex);
    }
    finally
    {
      if (severiceResponse != null) {
        severiceResponse.close();
      }
      _logger.exiting(UCMUtils.class.toString(), "createFolder");
    }
  }
  
  public static UCMDocument checkinFile(UCMDocument uploadFile)
  {
    _logger.entering(UCMUtils.class.toString(), "checkinFile");
    ServiceResponse myServiceResponse = null;
    InputStream fileStream = null;
    try
    {
      fileStream = uploadFile.getInputStream();
      String fileName1 = uploadFile.getFileName();
      String foldername = uploadFile.getParentFolderName();
      long fileLength = new File(fileName1).length();
      DataBinder myRequestDataBinder = idcClient.createBinder();
      _logger.info(" filling the binder ");
      myRequestDataBinder.putLocal("IdcService", "CHECKIN_UNIVERSAL");
      myRequestDataBinder.putLocal("dDocType", "Application");
      
      myRequestDataBinder.putLocal("dDocTitle", fileName1);
      
      myRequestDataBinder.putLocal("dDocAuthor", "weblogic");
      
      myRequestDataBinder.putLocal("dSecurityGroup", "Public");
      myRequestDataBinder.putLocal("dDocAccount", "");
      myRequestDataBinder.putLocal("dFormat", "text/html");
      _logger.info(" uploading file under this folder: /Contribution Folders/eService/" + foldername);
      
      long collectionId = getCollectionIdByPath("/Contribution Folders/eService/" + foldername).longValue();
      
      _logger.info("collection id of this folder: /Contribution Folders/eService/" + foldername + " is : " + collectionId);
      
      myRequestDataBinder.putLocal("xCollectionID", "" + collectionId);
      myRequestDataBinder.addFile("primaryFile", new TransferFile(fileStream, fileName1, fileLength, "text/html"));
      
      myServiceResponse = idcClient.sendRequest(userContext, myRequestDataBinder);
      
      DataBinder myResponseDataBinder = myServiceResponse.getResponseAsBinder();
      
      uploadFile.setDDocname((String)myResponseDataBinder.getLocalData().get("dDocName"));
      uploadFile.setDID((String)myResponseDataBinder.getLocalData().get("dID"));
      _logger.info("Get the document id :: " + uploadFile.getDID() + " get the url link ::: " + replaceUrl);
    }
    catch (IdcClientException idcce)
    {
      _logger.info("IDC Client Exception occurred. Unable to upload file. Message: " + idcce.getMessage());
      
      _logger.severe("Error creating Folder: ", idcce);
    }
    catch (Exception e)
    {
      _logger.info("Exception occurred. Unable to upload file. Message: " + e.getMessage());
      
      _logger.severe("Error creating Folder: ", e);
    }
    finally
    {
      if (myServiceResponse != null) {
        myServiceResponse.close();
      }
      if (fileStream != null) {
        try
        {
          fileStream.close();
        }
        catch (Exception e)
        {
          _logger.severe("Error creating Folder: ", e);
        }
      }
      _logger.exiting(UCMUtils.class.toString(), "checkinFile");
    }
    uploadFile.setDocURI(downloadAttachUrl(uploadFile.getDDocname()));
    return uploadFile;
  }
  
  public static String downloadAttachUrl(String ddocname)
  {
    _logger.entering(UCMUtils.class.toString(), "downloadAttachUrl");
    String web = "";
    if ((replaceUrl != null) && (ddocname != null))
    {
      _logger.info(" Replace URl not null & did not Null");
      web = "http://" + replaceUrl + "/cs/idcplg?IdcService=GET_FILE&dDocName=" + ddocname + "&RevisionSelectionMethod=LatestReleased&allowInterupt=1";
      
      _logger.info(" download url : " + web);
    }
    else
    {
      _logger.info(" Replace URl  null or did  Null");
    }
    _logger.exiting(UCMUtils.class.toString(), "downloadAttachUrl");
    return web;
  }
  
  public static Long getCollectionIdByPath(String path)
  {
    _logger.entering(UCMUtils.class.toString(), "getCollectionIdByPath");
    
    _logger.info("getting collection id of path :: " + path);
    try
    {
      DataBinder binder = idcClient.createBinder();
      binder.putLocal("IdcService", "COLLECTION_INFO");
      binder.putLocal("hasCollectionPath", "true");
      
      binder.putLocal("dCollectionPath", path);
      ServiceResponse serviceResponse = idcClient.sendRequest(userContext, binder);
      
      DataBinder myResponseDataBinder = serviceResponse.getResponseAsBinder();
      
      DataResultSet myDataResultSet = myResponseDataBinder.getResultSet("PATH");
      
      DataObject myDataObject = (DataObject)myDataResultSet.getRows().get(myDataResultSet.getRows().size() - 1);
      
      Long collectionId = new Long((String)myDataObject.get("dCollectionID"));
      _logger.info("collection id: " + collectionId);
      return collectionId;
    }
    catch (IdcClientException idcce)
    {
      _logger.info("IDC Client Exception occurred. Unable to retrieve folder id from path. Message: " + idcce.getMessage() + ", Stack trace: ");
      
      _logger.severe("Error creating Folder: ", idcce);
    }
    catch (Exception e)
    {
      _logger.info("Exception occurred. Unable to retrieve folder id from path. Message: " + e.getMessage() + ", Stack trace: ");
      
      _logger.severe("Error creating Folder: ", e);
    }
    return null;
  }
}
