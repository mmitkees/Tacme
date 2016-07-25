package com.app.view.beans;

import com.app.model.services.PPAppServicesImpl;
import com.app.view.utils.ADFUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import java.io.Serializable;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;

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

import org.apache.myfaces.trinidad.model.UploadedFile;

public class UCMBean implements Serializable{
    @SuppressWarnings("compatibility:4764728646473283421")
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private String url;
    private String replaceUrl;
    private IdcContext userContext;
    private IdcClient idcClient;
    private String did;    

    public UCMBean() {        
        super();
        intiateConnection();
    }
    public PPAppServicesImpl getAm() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Application app = fc.getApplication();
        ExpressionFactory elFactory = app.getExpressionFactory();
        ELContext elContext = fc.getELContext();
        ValueExpression valueExp =
            elFactory.createValueExpression(elContext, "#{data.PPAppServicesDataControl.dataProvider}",
                                            Object.class);
        return (PPAppServicesImpl)valueExp.getValue(elContext);
    }
    
    public void intiateConnection() {
        try {
//            this.username = "weblogic";
//            this.password = "welcome1";
//            this.url = "idc://192.168.3.113:4444";
//            IdcClientManager manager = new IdcClientManager();
//            this.idcClient = manager.createClient(this.url);
//            this.userContext = new IdcContext(this.username, this.password);
            ViewObject configview =
                getAm().findViewObject("UcmConfigView1");
            configview.setNamedWhereClauseParam("p_ucid", 3);
            configview.executeQuery();
            Row configrow = configview.first();
            username = (String)configrow.getAttribute("UcUsername");
            password = (String)configrow.getAttribute("UcPassword");
            String urlink = (String)configrow.getAttribute("UcUrl");
            String port = (String)configrow.getAttribute("UcPortno");
            replaceUrl = (String)configrow.getAttribute("ReplaceUrl");
            url = urlink + ":" + port;
            IdcClientManager manager = new IdcClientManager();
            this.idcClient = manager.createClient(this.url);
            this.userContext = new IdcContext(this.username, this.password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void createFolder(String folderName) {
            ServiceResponse severiceResponse = null;
            try {
                    System.out.println("Creating Folder: " + folderName);  
                String ParentCollectionID = getFolderIdFromPath("weblogic",
                                             "/Contribution Folders/eService");
                System.out.println ("Parrent collection id :: "+ParentCollectionID);
                DataBinder dataBinderReq = this.idcClient.createBinder();
                dataBinderReq.putLocal("IdcService", "COLLECTION_ADD");
                dataBinderReq.putLocal("dCollectionName", folderName);
                dataBinderReq.putLocal("hasParentCollectionID", "true");
                dataBinderReq.putLocal("dParentCollectionID", ParentCollectionID);
                dataBinderReq.putLocal("dCollectionOwner", this.username);
                dataBinderReq.putLocal("dSecurityGroup", "public");
                severiceResponse =
                        this.idcClient.sendRequest(new IdcContext(this.username),
                                                   dataBinderReq);
                DataBinder dataBinderResp = severiceResponse.getResponseAsBinder();
                System.out.println("Folder " + folderName +
                                   " successfully created");
            } catch (Exception ex) {
                System.out.println("Error creating Folder: " + ex.getMessage());
                ex.printStackTrace();
            } finally {
                if (severiceResponse != null) {
                    severiceResponse.close();
                }
            }
        }
    
    public String uploadedFile(String docname,UploadedFile uploadFile,String foldername) {
            ServiceResponse myServiceResponse = null;
            InputStream fileStream = null;
            ServiceResponse severiceResponse = null;
            try {
                //            String fileName = "C:\\Users\\yoga\\Desktop\\New folder\\UCMFileUpload.txt";
                //            fileStream = new FileInputStream(fileName);
                //            fileStream = new FileInputStream(uploadFile.getInputStream());
                fileStream = uploadFile.getInputStream();
                String fileName1 = uploadFile.getFilename();
                long fileLength = new File(fileName1).length();
                DataBinder myRequestDataBinder =
                    (DataBinder)this.idcClient.createBinder();
                myRequestDataBinder.putLocal("IdcService", "CHECKIN_UNIVERSAL");
                myRequestDataBinder.putLocal("dDocType", "Application");
//                myRequestDataBinder.putLocal("dDocName", docname);
                // Title of the Uploaded file
                myRequestDataBinder.putLocal("dDocTitle", docname);
                // Name of Author
                myRequestDataBinder.putLocal("dDocAuthor", "weblogic");
                // Security for the content (Group and Account)
                myRequestDataBinder.putLocal("dSecurityGroup", "Public");
                myRequestDataBinder.putLocal("dDocAccount", "");
                myRequestDataBinder.putLocal("dFormat", "text/html");                
                long collectionId =
                    getCollectionIdByPath("/Contribution Folders/eService/"+foldername);
                myRequestDataBinder.putLocal("xCollectionID", "" + collectionId);
                myRequestDataBinder.addFile("primaryFile",
                                            new TransferFile(fileStream, fileName1,
                                                             fileLength,
                                                             "text/html"));
                //                        myRequestDataBinder.addFile("primaryFile",
                //                                        new TransferFile(fileStream, fileName,
                //                                                         fileLength,
                //                                                         "text/html"));
                myServiceResponse =
                        idcClient.sendRequest(userContext, (DataBinder)myRequestDataBinder);
                InputStream myInputStream = myServiceResponse.getResponseStream();
                String myResponseString = myServiceResponse.getResponseAsString();
                DataBinder myResponseDataBinder =
                    (DataBinder)myServiceResponse.getResponseAsBinder();
                did = myResponseDataBinder.getLocalData().get("dDocName");
                System.out.println("Get the document id :: " + did+" get the url link ::: "+replaceUrl);                
//                System.out.println("Get the document url :: " +
//                                   getURLFromdID(did));
            } catch (IdcClientException idcce) {
                System.out.println("IDC Client Exception occurred. Unable to upload file. Message: " +
                                   idcce.getMessage() + ", Stack trace: ");
                idcce.printStackTrace();
            } catch (IOException ioe) {
                System.out.println("IO Exception occurred. Unable to upload file. Message: " +
                                   ioe.getMessage() + ", Stack trace: ");
                ioe.printStackTrace();
            } catch (Exception e) {
                System.out.println("Exception occurred. Unable to upload file. Message: " +
                                   e.getMessage() + ", Stack trace: ");
                e.printStackTrace();
            } finally {
                if (myServiceResponse != null) {
                    myServiceResponse.close();
                }
                if (fileStream != null) {
                    try {
                        fileStream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            
            return downloadAttachUrl();
        }
    
    /**
     *  download attachment url
     */
    public String downloadAttachUrl(){
        String web = null;
        if (replaceUrl != null && did != null){
        web = "http://"+replaceUrl+"/cs/idcplg?IdcService=GET_FILE&dDocName="+did+"&RevisionSelectionMethod=LatestReleased&allowInterupt=1";
        }
        return web;
    }
    
    /**
     *
     * @param path
     * @return
     */

    public Long getCollectionIdByPath(String path) {
            System.out.println ("Got the path :: "+path);
            try {

                DataBinder binder = idcClient.createBinder();
                binder.putLocal("IdcService", "COLLECTION_INFO");
                binder.putLocal("hasCollectionPath", "true");
                // Folder path for which ID is needed.
                binder.putLocal("dCollectionPath", path);
                ServiceResponse serviceResponse =
                    idcClient.sendRequest(userContext, binder);
                DataBinder myResponseDataBinder =
                    serviceResponse.getResponseAsBinder();
                DataResultSet myDataResultSet =
                    myResponseDataBinder.getResultSet("PATH");
                DataObject myDataObject =
                    myDataResultSet.getRows().get(myDataResultSet.getRows().size() -
                                                  1);
                Long myFolderId = new Long(myDataObject.get("dCollectionID"));
                System.out.println("Folder id: " + myFolderId);
                return myFolderId;
            } catch (IdcClientException idcce) {
                System.out.println("IDC Client Exception occurred. Unable to retrieve folder id from path. Message: " +
                                   idcce.getMessage() + ", Stack trace: ");
                idcce.printStackTrace();
            } catch (Exception e) {
                System.out.println("Exception occurred. Unable to retrieve folder id from path. Message: " +
                                   e.getMessage() + ", Stack trace: ");
                e.printStackTrace();
            }
            return null;
        }
    
    public String getFolderIdFromPath(String username, String path){
                String folderId=null;           
                try {                
                    DataBinder dataBinder = this.idcClient.createBinder();
                    dataBinder.putLocal("IdcService", "COLLECTION_INFO");
                    dataBinder.putLocal("hasCollectionPath", "true");
                    dataBinder.putLocal("dCollectionPath", path);
                    ServiceResponse response = this.idcClient.sendRequest(new IdcContext(username), dataBinder);
                    DataBinder serverBinder = response.getResponseAsBinder();
                    DataResultSet resultSet = serverBinder.getResultSet("PATH");
                    DataObject dataObject = resultSet.getRows().get(resultSet.getRows().size() - 1);
                    folderId = dataObject.get("dCollectionID");                    
                } catch(Exception ex) {
                    System.out.println("Error: " + ex.getMessage());  
                    ex.printStackTrace();
                }           
                return folderId;
            } 
    
//    public static void main(String [] args){         
//         UCMBean ubean = new UCMBean();
//         ubean.getFolderIdFromPath("weblogic", "/Contribution Folders/eService/");
//         ubean.createFolder("2095");
//         ubean.getCollectionIdByPath("/Contribution Folders/eService/2656");
//    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getDid() {
        return did;
    }
}
