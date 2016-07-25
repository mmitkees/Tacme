import java.util.Calendar;

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

import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

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
import oracle.stellent.ridc.protocol.ServiceResponse;

public class carrers_bean {

    private String username;
    private String _pid = "Y";
    private String _cdate = "Y";
    private String _jtitle = "Y";
    private String _jresp = "Y";
    private String _jreq = "Y";
    private String _sts = "Y";
    private String password;
    private String url;
    private IdcClient idcClient;
    private IdcContext userContext;
    private String securityGroup = "Public";
    private RichInputText b_pid;
    private RichInputDate b_cdate;
    private RichInputText b_jtitle;
    private RichInputText b_jresp;
    private RichInputText b_jreq;
    private RichSelectOneChoice b_jsts;

    public carrers_bean() {
        intiateConnection();
    }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public void intiateConnection() {
        try {
//            this.username = "weblogic";
//            this.password = "welcome1";
//            this.url = "idc://192.168.3.113:4444";
            ViewObject configview = this.getAm().findViewObject("UcmConfigView1");
            configview.setNamedWhereClauseParam("utype", "C");
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

    public String publish_action() {
        String ret = null;
        if ((b_pid.getValue() != null) && (b_cdate.getValue() != null) && (b_jtitle.getValue() != null) &&
            (b_jresp.getValue() != null) && (b_jreq.getValue() != null) && (b_jsts.getValue() != null)) {
            ViewObject carrerview = getAm().findViewObject("PpCarrersView1");
            Row carrerrow = carrerview.getCurrentRow();
            String fname = (String)carrerrow.getAttribute("PositionId");
//            createFolder(username, fname, "true",
//                         getFolderIdFromPath("weblogic",
//                                             "/Contribution Folders/Carrers"),
//                         securityGroup);
            createFolder(username, fname, "true",
                         getFolderIdFromPath("weblogic",
                                             "/Contribution Folders/Carrers"),
                         securityGroup);
            String ucmid =
                getFolderIdFromPath("weblogic", "/Contribution Folders/Carrers/" +
                                    fname);
            System.out.println(ucmid);
            carrerrow.setAttribute("CarrersUcmId", ucmid);
            BindingContainer bindings = getBindings();
            OperationBinding operationBinding =
                bindings.getOperationBinding("Commit");
            Object result = operationBinding.execute();
            if (!operationBinding.getErrors().isEmpty()) {
                FacesMessage fm =
                    new FacesMessage("Publish has been failed! Contact administrator");
                fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, fm);
            } else {
                FacesMessage fm =
                    new FacesMessage("Job has been published in carrers");
                fm.setSeverity(FacesMessage.SEVERITY_INFO);
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, fm);
                ret = "success";
            }
        }
        if (b_pid.getValue() == null){
            _pid = "N";
        }
        if (b_cdate.getValue() == null){
            _cdate = "N";
        }
        if (b_jtitle.getValue() == null){
            _jtitle = "N";
        }
        if (b_jresp.getValue() == null){
            _jresp = "N";
        }
        if (b_jreq.getValue() == null){
            _jreq = "N";
        }
        if (b_jsts.getValue() == null){
            _sts = "N";
        }
        return ret;
    }


    public void createFolder(String folderOwner, String folderName,
                             String Has_Parent, String ParentCollectionID,
                             String securityGroup) {
        ServiceResponse severiceResponse = null;
        try {
                System.out.println("Creating Folder: " + folderName);            
//                            IdcClient client = getIdcClient();
            DataBinder dataBinderReq = this.idcClient.createBinder();
            dataBinderReq.putLocal("IdcService", "COLLECTION_ADD");
            dataBinderReq.putLocal("dCollectionName", folderName);
            dataBinderReq.putLocal("hasParentCollectionID", Has_Parent);
            dataBinderReq.putLocal("dParentCollectionID", ParentCollectionID);
            dataBinderReq.putLocal("dCollectionOwner", folderOwner);
            dataBinderReq.putLocal("dSecurityGroup", securityGroup);
            severiceResponse =
                    this.idcClient.sendRequest(new IdcContext(folderOwner),
                                               dataBinderReq);
            //Below lines commented for using framework folder
//            DataBinder dataBinderReq = this.idcClient.createBinder();
//            dataBinderReq.putLocal("IdcService", "FLD_CREATE_FOLDER");
//            dataBinderReq.putLocal("fParentGUID",ParentCollectionID);
//            dataBinderReq.putLocal("fFolderName",folderName);
//            dataBinderReq.putLocal("fSecurityGroup","Public");
//            dataBinderReq.putLocal("fOwner","weblogic");
//            severiceResponse =
//                                this.idcClient.sendRequest(new IdcContext(folderOwner),
//                                                           dataBinderReq);
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

    //Returns Folder ID

//    public String getFolderIdFromPath(String username, String path) {
//        String folderId = null;
//        try {
////            DataBinder dataBinder = this.idcClient.createBinder();
////            dataBinder.putLocal("IdcService", "COLLECTION_INFO");
////            dataBinder.putLocal("hasCollectionPath", "true");
////            dataBinder.putLocal("dCollectionPath", path);
////            ServiceResponse response =
////                this.idcClient.sendRequest(new IdcContext(username),
////                                           dataBinder);
////            DataBinder serverBinder = response.getResponseAsBinder();
////            DataResultSet resultSet = serverBinder.getResultSet("PATH");
////            DataObject dataObject =
////                resultSet.getRows().get(resultSet.getRows().size() - 1);
////            folderId = dataObject.get("dCollectionID");
//            System.out.println("Invoking service FLD_INFO (path=\"" + path + "\")");
//
//        // Set service request parameters
//        DataBinder requestData = this.idcClient.createBinder();
//        requestData.putLocal("IdcService", "FLD_INFO");
//        requestData.putLocal("path", path);
//
//        // Execute service request
//            ServiceResponse response =
//                            this.idcClient.sendRequest(new IdcContext(username),
//                                                       requestData);
//        DataResultSet result = response.getResponseAsBinder().getResultSet("FolderInfo");
//
//        // Retrieve folder GUID
//        String folderGUID = result.getRows().get(0).get("fFolderGUID").toString();
//        if (folderGUID.isEmpty()) {
//            System.out.println("Folderpath " + path + " not found");
//        } else {
//            System.out.println("Folder " + path + " has GUID: " + folderGUID);
//        }
//
//        // Return the first folder, there is only one.
//        return folderGUID;
//        } catch (Exception ex) {
//            System.out.println("Error: " + ex.getMessage());
//        }
//        return folderId;
//    }
    
    //Returns Folder ID
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
                }           
                return folderId;
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

    public void setPid(String _pid) {
        this._pid = _pid;
    }

    public String getPid() {
        return _pid;
    }

    public void setCdate(String _cdate) {
        this._cdate = _cdate;
    }

    public String getCdate() {
        return _cdate;
    }

    public void setJtitle(String _jtitle) {
        this._jtitle = _jtitle;
    }

    public String getJtitle() {
        return _jtitle;
    }

    public void setJresp(String _jresp) {
        this._jresp = _jresp;
    }

    public String getJresp() {
        return _jresp;
    }

    public void setJreq(String _jreq) {
        this._jreq = _jreq;
    }

    public String getJreq() {
        return _jreq;
    }

    public void setSts(String _sts) {
        this._sts = _sts;
    }

    public String getSts() {
        return _sts;
    }

    public void setB_pid(RichInputText b_pid) {
        this.b_pid = b_pid;
    }

    public RichInputText getB_pid() {
        return b_pid;
    }

    public void setB_cdate(RichInputDate b_cdate) {
        this.b_cdate = b_cdate;
    }

    public RichInputDate getB_cdate() {
        return b_cdate;
    }

    public void setB_jtitle(RichInputText b_jtitle) {
        this.b_jtitle = b_jtitle;
    }

    public RichInputText getB_jtitle() {
        return b_jtitle;
    }

    public void setB_jresp(RichInputText b_jresp) {
        this.b_jresp = b_jresp;
    }

    public RichInputText getB_jresp() {
        return b_jresp;
    }

    public void setB_jreq(RichInputText b_jreq) {
        this.b_jreq = b_jreq;
    }

    public RichInputText getB_jreq() {
        return b_jreq;
    }

    public void setB_jsts(RichSelectOneChoice b_jsts) {
        this.b_jsts = b_jsts;
    }

    public RichSelectOneChoice getB_jsts() {
        return b_jsts;
    }

    public void checkBoxVCL(ValueChangeEvent vce) {
        System.out.println("get the value from checkbox"+vce.getNewValue());
        if (vce.getNewValue().equals(true)){
            ViewObject carrersvo = this.getAm().findViewObject("PpCarrersView1");
            Row carrersvr = carrersvo.getCurrentRow();
            oracle.jbo.domain.Date closedate= new oracle.jbo.domain.Date();
            carrersvr.setAttribute("CloseDate", closedate.getCurrentDate());
        }
    }
}
