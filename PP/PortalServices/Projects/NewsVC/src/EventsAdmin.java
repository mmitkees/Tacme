import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.io.OutputStream;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.BindingContext;

import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

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

import org.apache.commons.io.IOUtils;
import org.apache.myfaces.trinidad.model.UploadedFile;

public class EventsAdmin {
    private String username;
    private String password;
    private String url;
    private IdcClient idcClient;
    private IdcContext userContext;
    private oracle.stellent.ridc.model.DataBinder binder;
    private UploadedFile uploadFile;
    private String did;
    private String fileName = null;
    private String vid = "Y";
    private String vdate = "Y";
    private String vtime = "Y";
    private String vsubj = "Y";
    private String vdesc = "Y";
    private String vdet = "Y";
    private String b_dis = "Y";
    private RichInputText b_eid;
    private RichInputDate b_edate;
    private RichInputText b_etime;
    private RichInputText b_esubj;
    private RichInputText b_edesc;
    private RichInputText b_edet;

    public EventsAdmin() {
        intiateConnection();
    }

    public void intiateConnection() {
        try {
            ViewObject configview = this.getAm().findViewObject("UcmConfigView1");
            configview.setNamedWhereClauseParam("utype", "E");
            configview.executeQuery();
            Row configrow = configview.first();
            username = (String)configrow.getAttribute("UcUsername");
            password = (String)configrow.getAttribute("UcPassword");
            String urlink = (String)configrow.getAttribute("UcUrl");
            String port = (String)configrow.getAttribute("UcPortno");
            url = urlink+":"+port;
            IdcClientManager manager = new IdcClientManager();
            this.idcClient = manager.createClient(this.url);
            this.userContext = new IdcContext(this.username, this.password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void uploadedFile(String docname) {
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
            myRequestDataBinder.putLocal("dDocName", docname);
            // Title of the Uploaded file
            myRequestDataBinder.putLocal("dDocTitle", docname);
            // Name of Author
            myRequestDataBinder.putLocal("dDocAuthor", "weblogic");
            // Security for the content (Group and Account)
            myRequestDataBinder.putLocal("dSecurityGroup", "Public");
            myRequestDataBinder.putLocal("dDocAccount", "");
            myRequestDataBinder.putLocal("dFormat", "text/html");
            String collectionId =
                getCollectionIdByPath("/Contribution Folders/Events");
            myRequestDataBinder.putLocal("xCollectionID", "" + collectionId);
            myRequestDataBinder.addFile("primaryFile",
                                        new TransferFile(fileStream, fileName,
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
            did = myResponseDataBinder.getLocalData().get("dID");
            System.out.println("Get the document id :: " + did);
            System.out.println("Get the document url :: " +
                               getURLFromdID(did));
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
    }

    public String getCollectionIdByPath(String path) {

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
                   } 
        return folderId;               
    }

    public String getURLFromdID(String dID) {
        ServiceResponse severiceResponse = null;
        this.binder = this.idcClient.createBinder();
        try {
            this.binder.putLocal("IdcService", "DOC_INFO");
            this.binder.putLocal("dID", dID);
            ServiceResponse response =
                idcClient.sendRequest(this.userContext, this.binder);
            DataBinder respBinder = response.getResponseAsBinder();
            return respBinder.getLocal("DocUrl");
        } catch (IdcClientException ice) {
            ice.printStackTrace();
        }
        return null;
    }

    private ApplicationModule getAm() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Application app = fc.getApplication();
        ExpressionFactory elFactory = app.getExpressionFactory();
        ELContext elContext = fc.getELContext();
        ValueExpression valueExp =
            elFactory.createValueExpression(elContext, "#{data.NewsAppModuleServiceDataControl.dataProvider}",
                                            Object.class);
        return (ApplicationModule)valueExp.getValue(elContext);
    }

    public String event_publish_en_action() {
        if (this.getB_edate() != null && this.getB_edesc() != null &&
            this.getB_edet() != null && this.getB_eid() != null &&
            this.getB_esubj() != null && this.getB_etime() != null) {
            if (uploadFile != null) {
                ViewObject newsview =
                    this.getAm().findViewObject("EventDetView1");
                Row newsrow = newsview.getCurrentRow();
                Object docid = newsrow.getAttribute("EventId");
                String docids = docid.toString();
                filename(docids);
                uploadedFile(docids);
                newsrow.setAttribute("EventUcmId", did);
                BindingContext bctx = BindingContext.getCurrent();
                BindingContainer bindings = bctx.getCurrentBindingsEntry();
                OperationBinding ob = bindings.getOperationBinding("Commit");
                ob.execute();
                if (!ob.getErrors().isEmpty()) {

                } else {
                    FacesContext facesContext =
                        FacesContext.getCurrentInstance();
                    facesContext.addMessage("Events has been published",
                                            new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                             "Events has been published",
                                                             "Events has been published"));
                    facesContext.renderResponse();
                }
            }
        }

        if (this.getB_edate().getValue() == null) {
            vdate = "N";
        }
        if (this.getB_edesc().getValue() == null) {
            vdesc = "N";
        }
        if (this.getB_edet().getValue() == null) {
            vdet = "N";
        }
        if (this.getB_eid().getValue() == null) {
            vid = "N";
        }
        if (this.getB_esubj().getValue() == null) {
            vsubj = "N";
        }
        if (this.getB_etime().getValue() == null) {
            vtime = "N";
        }
        return null;
    }

    public String filename(String newfile) {
        File file = null;
        OutputStream output = null;
        file = new File(newfile);
        try {
            output = new FileOutputStream(file);
            IOUtils.copy(uploadFile.getInputStream(), output);
            fileName = file.getName() + ".jpg";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String clear_en_action() {
        this.setUploadFile(null);
        BindingContext bctx = BindingContext.getCurrent();
        BindingContainer bindings = bctx.getCurrentBindingsEntry();
        OperationBinding ob = bindings.getOperationBinding("Rollback");
        ob.execute();
        OperationBinding ob1 = bindings.getOperationBinding("CreateInsert");
        ob1.execute();
        if (vdate.equals("N")) {
            vdate = "Y";
        }
        if (vtime.equals("N")) {
            vtime = "Y";
        }
        if (vdesc.equals("N")) {
            vdesc = "Y";
        }
        if (vdet.equals("N")) {
            vdet = "Y";
        }
        if (vsubj.equals("N")) {
            vsubj = "Y";
        }
        if (vid.equals("N")) {
            vid = "Y";
        }
        return "clear";
    }

    public String clear_ar_action() {
        this.setUploadFile(null);
        BindingContext bctx = BindingContext.getCurrent();
        BindingContainer bindings = bctx.getCurrentBindingsEntry();
        OperationBinding ob = bindings.getOperationBinding("Rollback");
        ob.execute();
        OperationBinding ob1 = bindings.getOperationBinding("CreateInsert");
        ob1.execute();
        return "clear";
    }

    public void setUploadFile(UploadedFile uploadFile) {
        this.uploadFile = uploadFile;
    }

    public UploadedFile getUploadFile() {
        return uploadFile;
    }

    public String publish_ar_action() {
        if (this.getB_edate() != null && this.getB_edesc() != null &&
            this.getB_edet() != null && this.getB_eid() != null &&
            this.getB_esubj() != null && this.getB_etime() != null) {
            if (uploadFile != null) {
                ViewObject newsview =
                    this.getAm().findViewObject("EventDetArView1");
                Row newsrow = newsview.getCurrentRow();
                Object docid = newsrow.getAttribute("EventId");
                String docids = docid.toString();
                filename(docids);
                uploadedFile(docids);
                newsrow.setAttribute("EventUcmId", did);
                BindingContext bctx = BindingContext.getCurrent();
                BindingContainer bindings = bctx.getCurrentBindingsEntry();
                OperationBinding ob = bindings.getOperationBinding("Commit");
                ob.execute();
                if (!ob.getErrors().isEmpty()) {
                } else {
                    FacesContext facesContext =
                        FacesContext.getCurrentInstance();
                    facesContext.addMessage("Events has been published",
                                            new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                             "Events has been published",
                                                             "Events has been published"));
                    facesContext.renderResponse();
                    b_dis = "N";
                }
            }
            
        }
        if (this.getB_edate().getValue() == null) {
            vdate = "N";
        }
        if (this.getB_edesc().getValue() == null) {
            vdesc = "N";
        }
        if (this.getB_edet().getValue() == null) {
            vdet = "N";
        }
        if (this.getB_eid().getValue() == null) {
            vid = "N";
        }
        if (this.getB_esubj().getValue() == null) {
            vsubj = "N";
        }
        if (this.getB_etime().getValue() == null) {
            vtime = "N";
        }
        return null;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getVid() {
        return vid;
    }

    public void setVdate(String vdate) {
        this.vdate = vdate;
    }

    public String getVdate() {
        return vdate;
    }

    public void setVtime(String vtime) {
        this.vtime = vtime;
    }

    public String getVtime() {
        return vtime;
    }

    public void setVsubj(String vsubj) {
        this.vsubj = vsubj;
    }

    public String getVsubj() {
        return vsubj;
    }

    public void setVdesc(String vdesc) {
        this.vdesc = vdesc;
    }

    public String getVdesc() {
        return vdesc;
    }

    public void setVdet(String vdet) {
        this.vdet = vdet;
    }

    public String getVdet() {
        return vdet;
    }

    public void setB_eid(RichInputText b_eid) {
        this.b_eid = b_eid;
    }

    public RichInputText getB_eid() {
        return b_eid;
    }

    public void setB_edate(RichInputDate b_edate) {
        this.b_edate = b_edate;
    }

    public RichInputDate getB_edate() {
        return b_edate;
    }

    public void setB_etime(RichInputText b_etime) {
        this.b_etime = b_etime;
    }

    public RichInputText getB_etime() {
        return b_etime;
    }

    public void setB_esubj(RichInputText b_esubj) {
        this.b_esubj = b_esubj;
    }

    public RichInputText getB_esubj() {
        return b_esubj;
    }

    public void setB_edesc(RichInputText b_edesc) {
        this.b_edesc = b_edesc;
    }

    public RichInputText getB_edesc() {
        return b_edesc;
    }

    public void setB_edet(RichInputText b_edet) {
        this.b_edet = b_edet;
    }

    public RichInputText getB_edet() {
        return b_edet;
    }

    public void date_value_listner(ValueChangeEvent vce) {
        System.out.println("Value change listner :: " + vdet);
        if (vce.getNewValue() != null) {
            if (vdet.equals("Y")) {
                vdet = "N";
            }
        }
    }

    public void setB_dis(String b_dis) {
        this.b_dis = b_dis;
    }

    public String getB_dis() {
        return b_dis;
    }
}
