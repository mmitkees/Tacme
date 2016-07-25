import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.io.OutputStream;

import java.util.Iterator;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import javax.faces.event.ValueChangeEvent;

import javax.faces.validator.ValidatorException;

import oracle.adf.model.BindingContext;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.event.DialogEvent;

import oracle.binding.BindingContainer;

import oracle.binding.OperationBinding;

import oracle.jbo.ApplicationModule;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;

import oracle.jbo.domain.Number;

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
import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

public class carrersPortal {
    private UploadedFile upFilePopup;    
    private String username;
    private String password;
    private String url;
    private IdcClient idcClient;
    private IdcContext userContext;
    private String fileName;
    private DataBinder binder;
    private String _upfile = "Y";
    private String ucmdid;
    private String did;
    private String replaceUrl;

    public carrersPortal() {
        super();
        intiateConnection();
    }

    public void intiateConnection() {
        try {
            //                this.username = "weblogic";
            //                this.password = "welcome1";
            //                this.url = "idc://192.168.3.113:4444";
            ViewObject configview =
                this.getAm().findViewObject("UcmConfigView1");
            configview.setNamedWhereClauseParam("utype", "C");
            configview.executeQuery();
            Row configrow = configview.first();
            username = (String)configrow.getAttribute("UcUsername");
            password = (String)configrow.getAttribute("UcPassword");
            String urlink = (String)configrow.getAttribute("UcUrl");
            String port = (String)configrow.getAttribute("UcPortno");
            url = urlink + ":" + port;
            replaceUrl = (String)configrow.getAttribute("ReplaceUrl");
            IdcClientManager manager = new IdcClientManager();
            this.idcClient = manager.createClient(this.url);
            this.userContext = new IdcContext(this.username, this.password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void uploadedFile(String docname) {
        if (docname != null){
        ServiceResponse myServiceResponse = null;
        InputStream fileStream = null;
        ServiceResponse severiceResponse = null;
        try {            
            fileStream = upFilePopup.getInputStream();
            String format = upFilePopup.getContentType();
            String fileName1 = upFilePopup.getFilename();
            long fileLength = new File(fileName1).length();
            DataBinder myRequestDataBinder =
                (DataBinder)this.idcClient.createBinder();
            myRequestDataBinder.putLocal("IdcService", "CHECKIN_UNIVERSAL");
            myRequestDataBinder.putLocal("dDocType", "Application");
//            myRequestDataBinder.putLocal("dDocName", fileName1);
            // Title of the Uploaded file
            myRequestDataBinder.putLocal("dDocTitle", fileName1);
            // Name of Author
            myRequestDataBinder.putLocal("dDocAuthor", "weblogic");
            // Security for the content (Group and Account)
            myRequestDataBinder.putLocal("dSecurityGroup", "Public");
            myRequestDataBinder.putLocal("dDocAccount", "");
            myRequestDataBinder.putLocal("dFormat", format);            
            String collectionId =
                getCollectionIdByPath(username, "/Contribution Folders/Carrers/" +
                                      docname);
//                        String collectionId =
//                getCollectionIdByPath(username, "/Contribution Folders/Carrers/");
            myRequestDataBinder.putLocal("xCollectionID", "" + collectionId);
            myRequestDataBinder.addFile("primaryFile",
                                        new TransferFile(fileStream, fileName1,
                                                         fileLength, format));            
            myServiceResponse =
                    idcClient.sendRequest(userContext, (DataBinder)myRequestDataBinder);
            InputStream myInputStream = myServiceResponse.getResponseStream();
            String myResponseString = myServiceResponse.getResponseAsString();
            DataBinder myResponseDataBinder =
                (DataBinder)myServiceResponse.getResponseAsBinder();
            ucmdid = myResponseDataBinder.getLocalData().get("dID");
            did = myResponseDataBinder.getLocalData().get("dDocName");
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
    }


    //Returns Folder ID

    public String getCollectionIdByPath(String username, String path) {
        String folderId = null;
        try {
            DataBinder dataBinder = this.idcClient.createBinder();
            dataBinder.putLocal("IdcService", "COLLECTION_INFO");
            dataBinder.putLocal("hasCollectionPath", "true");
            dataBinder.putLocal("dCollectionPath", path);
            ServiceResponse response =
                this.idcClient.sendRequest(new IdcContext(username),
                                           dataBinder);
            DataBinder serverBinder = response.getResponseAsBinder();
            DataResultSet resultSet = serverBinder.getResultSet("PATH");
            DataObject dataObject =
                resultSet.getRows().get(resultSet.getRows().size() - 1);
            folderId = dataObject.get("dCollectionID");
        } catch (Exception ex) {
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


    public String apply_action() {
        String res = "N";        
        if (this.upFilePopup != null) {
            ViewObject carrersPortalview =
                this.getAm().findViewObject("PpCarrersDefView1");
            Row carrersPortalrow = carrersPortalview.getCurrentRow();
            String fname = (String)carrersPortalrow.getAttribute("PositionId");
            filename(fname);
            uploadedFile(fname);
            if (ucmdid != null) {
                res = "Y";
            }
        }        
        return res;
    }
    
    // **************************** EMail Validator ********************************************

    public void eMailValidator(FacesContext facesContext,
                               UIComponent uIComponent, Object object) {        
        String EMAIL_REGEX =
            "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        String email = object.toString();
        String specialChars = "/*!@#$%^&*()\"{}_[]|\\?/<>,.";
        Boolean spb = specialChars.contains(email.substring(0, 1));
        Boolean b = email.matches(EMAIL_REGEX);
        if (b.equals(false) || spb.equals(true)) {
            onSetFocus("em1");
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                          "Email not valid",
                                                          "Enter valid email address"));
        }
    }
    
    public void onSetFocus(String component) {
        RichInputText rit = (RichInputText)findComponentInRoot(component);
        if (rit != null) {
            // Use client id to ensure component is found if located in naming container
            FacesContext fctx = FacesContext.getCurrentInstance();
            String clientId = rit.getClientId(fctx);
            StringBuilder script = new StringBuilder();

            script.append("var textInput = ");
            script.append("AdfPage.PAGE.findComponentByAbsoluteId");
            script.append("('" + clientId + "');");
            script.append("if(textInput != null){");
            script.append("textInput.focus();");
            script.append("}");

            ExtendedRenderKitService erks = null;
            erks =
    Service.getRenderKitService(fctx, ExtendedRenderKitService.class);
            erks.addScript(fctx, script.toString());
        }
    }
    
    private RichInputText findComponentInRoot(String componentId) {
        UIComponent component = null;
        FacesContext facesContext = FacesContext.getCurrentInstance();
        if (facesContext != null) {
            UIComponent root = facesContext.getViewRoot();
            component = findComponent(root, componentId);
        }
        return (RichInputText)component;
    }
    
    private UIComponent findComponent(UIComponent base, String id) {
        if (id.equals(base.getId()))
            return base;

        UIComponent kid = null;
        UIComponent result = null;
        Iterator kids = base.getFacetsAndChildren();
        while (kids.hasNext() && (result == null)) {
            kid = (UIComponent)kids.next();
            if (id.equals(kid.getId())) {
                result = kid;
                break;
            }
            result = findComponent(kid, id);
            if (result != null) {
                break;
            }
        }
        return result;
    }
    
    public String vacanciesApplyAction() {
        String res = "N";        
        if (this.upFilePopup != null) {
            ViewObject carrersPortalview =
                this.getAm().findViewObject("VacanciesAdminView1");
            Row carrersPortalrow = carrersPortalview.getCurrentRow();
            Number fname = (Number)carrersPortalrow.getAttribute("VadminId");
//            String filename = fname.toString();
            String filename = (String)carrersPortalrow.getAttribute("PositionId");
            filename(filename);
            uploadedFile(filename);
            if (ucmdid != null) {
                res = "Y";
            }
            carrersPortalrow.setAttribute("VadminAttachUrl", downloadAttachUrl());
            BindingContainer bindings = BindingContext.getCurrent().getCurrentBindingsEntry(); 
            OperationBinding commit = bindings.getOperationBinding("Commit");  
            commit.execute();  
        }        
        return res;
    }

    public String filename(String newfile) {
        if (newfile != null){
        File file = null;
        OutputStream output = null;
        file = new File(newfile);
        try {
            output = new FileOutputStream(file);
            IOUtils.copy(upFilePopup.getInputStream(), output);
            fileName = file.getName() + ".jpg";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
        return null;
    }
    
    // **************************** Phone number validation ********************************************

    public void phonenoValidator(FacesContext facesContext,
                                 UIComponent uIComponent, Object object) {
        String pno = object.toString();
        boolean vpno = validatePhoneNumber(pno);
        if (vpno == false) {
            onSetFocus("phn1");
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                          "Invalid phone number",
                                                          "Please enter the valid phone number, Format should be 05xxxxxxxx"));
        }
    }
    
    private static boolean validatePhoneNumber(String phoneNo) {
        //validate phone numbers of format "1234567890"
        if(phoneNo.startsWith("0")){
        if (phoneNo.matches("\\d{10}"))
            return true;
        //validating phone number with -, . or spaces
        else if (phoneNo.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}"))
            return true;
        //validating phone number with extension length from 3 to 5
        else if (phoneNo.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}"))
            return true;
        //validating phone number where area code is in braces ()
        else if (phoneNo.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}"))
            return true;
        //return false if nothing matches the input
        }
        else{
            return false;
        }
        return false;
    }

    private ApplicationModule getAm() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Application app = fc.getApplication();
        ExpressionFactory elFactory = app.getExpressionFactory();
        ELContext elContext = fc.getELContext();
        ValueExpression valueExp =
            elFactory.createValueExpression(elContext, "#{data.ppCarrersServiceDataControl.dataProvider}",
                                            Object.class);
        return (ApplicationModule)valueExp.getValue(elContext);
    }

    public void PopupListener(DialogEvent dialogEvent) {
        if (dialogEvent.getOutcome() == DialogEvent.Outcome.ok) {
            //            upFilePopup = this.uploadFile;
            //            uploadFile = upFilePopup;
        }
    }

    public void setUpFilePopup(UploadedFile upFilePopup) {        
        this.upFilePopup = upFilePopup;
    }

    public UploadedFile getUpFilePopup() {
        return upFilePopup;
    }

    public String upload_action() {
        _upfile = "N";
        return null;
    }

    public void setUpfile(String _upfile) {
        this._upfile = _upfile;
    }

    public String getUpfile() {
        return _upfile;
   }
   
}
