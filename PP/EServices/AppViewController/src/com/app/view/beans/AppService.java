package com.app.view.beans;

import com.app.model.services.PPAppServicesImpl;

import com.app.view.utils.ADFUtils;

import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;

import org.apache.myfaces.trinidad.util.Service;

import java.io.IOException;
import java.io.InputStream;

import java.io.OutputStream;

import java.sql.SQLException;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.ADFContext;

import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.input.RichInputFile;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;

import oracle.adf.view.rich.event.DialogEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;

import oracle.jbo.domain.BlobDomain;

import org.apache.commons.io.IOUtils;
import org.apache.myfaces.trinidad.model.UploadedFile;

import java.io.File;

import java.io.Serializable;

import java.math.BigDecimal;

import java.sql.CallableStatement;

import java.text.DecimalFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

import java.util.Locale;
import java.util.Map;

import model.services.SMSPrjServiceImpl;

import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.share.logging.ADFLogger;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.JboException;
import oracle.jbo.domain.Number;
import oracle.jbo.server.DBTransactionImpl;

import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;

public class AppService implements Serializable {
    @SuppressWarnings("compatibility:3218145749734824051")
    private static final long serialVersionUID = 1L;
    private UCMBean ubean = new UCMBean();
    private String un;
    private String pwrd;
    private String eflag = "Y";
    private String chpwrd;
    private String oldpwrd;
    private String errorType;
    private String cpwFlag = "Y";

    private RichPanelGroupLayout pgPwrd;
    private UploadedFile file;
    private String fileName;
    private String contentType;
    private BlobDomain blob;
    private RichInputFile upFileBind;
    private String fileSize;
    private RichInputFile depUpFileBind;
    private RichInputFile decUpFileBind;
    private RichInputFile disbUpFileBind;
    private RichInputFile defUpFileBind;
    private RichInputFile ecajUpFileBind;
    private RichInputFile appealUpFileBind;
    private RichInputFile fineretreqUpFileBind;
    private RichInputFile lawyerprfUpFileBind;
    private RichInputFile coldocUpFileBind;
    private RichInputFile payfineUpFileBind;
    private RichInputFile payLawFeeFileBind;
    private RichInputFile provFinPerBFileBind;
    private RichInputFile recCorpFileBind;
    private RichInputFile excBillUpFileBind;
    private RichInputFile refinmUPFilebind;
    private RichInputFile reviewUPFilebind;
    private RichInputFile Casecopy1UPFilebind;
    private RichInputFile copyJudUPFilebind;
    private RichInputFile cpynsoUPFilebind;
    private RichInputFile AdjSndUPFilebind;
    private RichInputFile DciDueUPFilebind;
    private RichInputFile ExhumationUPFilebind;
    private RichInputFile EoPCaseUPFilebind;
    private RichInputFile FdreimburUPFilebind;
    private RichInputFile MeetProcUPFilebind;
    private RichInputFile waivEnclUPFilebind;
    private RichInputFile VisitPrDUPFilebind;
    private RichInputFile WICUPFilebind;
    private RichInputFile SubSMSUPFilebind;
    private RichInputFile SubObjUPFilebind;
    private RichInputFile OpenofMemUPFilebind;
    private RichInputFile SrCclWrntUPFilebind;
    private RichInputFile RetBailAmntUPFilebind;
    private RichInputFile RehabilUPFilebind;
    private RichInputFile RecPprtUPFilebind;
    private RichInputFile PprenewalUPFilebind;
    private RichInputFile RecDocimpUPFilebind;
    private RichInputFile PpmentinsCourtUPFilebind;
    private RichInputFile PcopycasedropdecUPFilebind;
    private RichInputFile PostponeofFreeUPFilebind;
    private RichInputFile RecDepChargUPFilebind;
    private RichInputFile IntArstWrntUPFilebind;
    private RichInputFile ApCseUPFilebind;
    private RichInputFile CaseInformationUPFilebind;
    private RichInputFile Service1UPFilebind;
    private String attachUrl;

    private String log = "N";
    private String cn = "N";
    private String acn = "N";
    private String pr = "N";
    private String sd = "N";
    private String cy = "N";
    private String cd = "N";
    private String nt = "N";
    private String sb = "N";
    private String mrprt = "N";
    private String addr = "N";
    private String mob = "N";
    private String it = "N";
    private String ins = "N";
    private String pd = "N";
    private String id = "N";
    private String pcp = "N";
    private String sr = "N";
    private String vp = "N";
    private String jd = "N";
    private String spn = "N";
    private String ptm = "N";
    private String pc = "N";
    private String rc = "N";
    private String rt = "N";
    private String prid = "N";
    private String ds = "N";
    private String an = "N";
    private String mr = "N";
    private String pn = "N";
    private String mc = "N";
    private String pcn = "N";
    private String pcd = "N";
    private String vremail = "N";
    private String vrphone = "N";
    private String vrrelation = "N";
    private String dm = "N";
    private String et = "N";
    private String ap = "N";
    private String cp = "N";
    private String ln = "N";
    private String vd = "N";
    private String rs = "N";
    private String ed = "N";
    private String pid = "N";
    private String pno = "N";
    private String prn = "N";
    private String rr = "N";
    private String ia = "N";
    private String sub = "N";
    private String in = "N";
    private String sntdte = "N";
    private String fa = "N";
    private String dt = "N";
    private String wn = "N";
    private String ja = "N";
    private String ct = "N";
    private String visitInfo = "N";
    private String cbval = "N";
    private String nbval = "N";
    private String cobval = "N";
    private String tn = "N";
    private String dr = "N";
    private String cb_pwrd;
    private String nb_pwrd;
    private String cob_pwrd;
    private String dFlag = "N";
    private static DecimalFormat df2 = new DecimalFormat(".###");
    private static ADFLogger _logger =
        ADFLogger.createADFLogger(AppService.class);
    private RichPopup loginPopupBind;
    private String dob;
    private String gdob;
    private String ERR_Attach =
        ".pdf ,.gif,.jpeg,.doc,.txt <Need Input> Single File Size 2MB ; Total Of All File Size 10MB";
    private RichPanelGroupLayout cnopg;
    private UploadedFile intPhotoUpload;
    private List<UploadedFile> uploadedfile;
    private List<UploadedFile> uploadedMedfile;
    private String p_val = "AR1";
    private int p_num = 13;
    private String message;
    private String showPanel = "N";
    private RichInputText bind_username;
    private RichInputText bind_pwrd;
    private String erun = "N";
    private String erpwrd = "N";
    private ADFUtils afu = new ADFUtils();
    private RichInputText bind_efn;
    private RichInputText bind_eln;
    private ADFUtils adfUtils = new ADFUtils();
    private RichInputDate bind_edob;

    public AppService() {
    }

    public String login_action() {
        if (this.getBind_username().getValue() != null &&
            getBind_username().getValue() != "" &&
            getBind_pwrd().getValue() != "" &&
            this.getBind_pwrd().getValue() != null) {
            System.out.println("Username :: " + getBind_username().getValue() +
                               "Password : " + getBind_pwrd().getValue());
            BindingContainer bindings = getBindings();
            OperationBinding operationBinding =
                bindings.getOperationBinding("login_db");
            String res = (String)operationBinding.execute();
            if (eflag.equals("N"))
                this.setEflag("Y");
            if (res != null) {
                if (res.equals("Y")) {
                    RichPopup.PopupHints hints = new RichPopup.PopupHints();
                    this.getLoginPopupBind().show(hints);
                    dob =
(String)ADFContext.getCurrent().getSessionScope().get("dob");
                } else {
                    this.setEflag("N");
                }
            }
        }
        if (this.getBind_username().getValue() == null ||
            getBind_username().getValue() == "") {
            this.setEflag("UN");
        } else if (this.getBind_pwrd().getValue() == null ||
                   getBind_pwrd().getValue() == "") {
            this.setEflag("PWRD");
        }
        if (this.getBind_username().getValue() == null ||
            getBind_username().getValue() == "" ||
            this.getBind_pwrd().getValue() == null ||
            getBind_pwrd().getValue() == "") {
            this.setEflag("UNPWRD");
        }
        return null;
    }

    public String DobDialList() {
        String locale = "";
        Locale mylocale = (Locale)afu.evaluateEL("#{pageFlowScope.locale}");
        if (mylocale != null) {
            locale = mylocale.getLanguage();
        } else {
            locale = "en";
        }
        //        locale = "en";
        String action = null;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date gdob1;
            if (gdob != null) {
                gdob1 = formatter.parse(gdob);
                Date dob1 = formatter.parse(dob);
                if (gdob1.compareTo(dob1) == 0) {
                    if ((ADFContext.getCurrent().getSessionScope().get("login") ==
                         null) ||
                        (ADFContext.getCurrent().getSessionScope().get("login") ==
                         "")) {
                        log = "Y";
                        ADFContext.getCurrent().getSessionScope().put("login",
                                                                      log);
                        action = "mainpage";
                    } else {

                        action = "service";
                    }
                } else {
                    if (locale.equals("en")) {
                        FacesMessage Message =
                            new FacesMessage("Invalid date of birth");
                        Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                        FacesContext fc = FacesContext.getCurrentInstance();
                        fc.addMessage(null, Message);
                    }
                    if (locale.equals("ar")) {
                        FacesMessage Message =
                            new FacesMessage("تاريخ الميلاد غير صحيح");
                        Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                        FacesContext fc = FacesContext.getCurrentInstance();
                        fc.addMessage(null, Message);
                    }
                }
            } else {
                FacesMessage Message =
                    new FacesMessage("Please select the date of birth");
                Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, Message);
            }
        } catch (ParseException e) {
        }
        System.out.println("returned value is :: " + action);
        return action;
    }


    public void executeSMSproc(String p_mobno, Number reqid) {
        String subj = null;
        try {
            for (int i = 0; i <= 1; i++) {
                if (i == 0) {
                    subj =
"Dear User, Your request is now submitted and it is under processing . Your request number is : " +
 reqid;
                } else if (i == 1) {
                    subj =
"عزيزي المستخدم طلبك تحت قيد التنفيذ . رقم طلبك :" + reqid;
                }
                DBTransactionImpl dbti =
                    (DBTransactionImpl)getAm().getDBTransaction();
                CallableStatement statement =
                    dbti.createCallableStatement(("BEGIN " +
                                                  "SENDSMS_PORTAL(?,?);" +
                                                  "END;"), 0);
                try {
                    statement.setString(1, p_mobno);
                    statement.setString(2, subj);
                    statement.execute();
                } catch (SQLException sqlerr) {
                    throw new JboException(sqlerr);
                } finally {
                    try {
                        if (statement != null) {
                            statement.close();
                        }
                    } catch (SQLException closeerr) {
                        throw new JboException(closeerr);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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


    public void setUn(String un) {
        this.un = un;
    }

    public String getUn() {
        return un;
    }

    public void setPwrd(String pwrd) {
        this.pwrd = pwrd;
    }

    public String getPwrd() {
        return pwrd;
    }

    public void setEflag(String eflag) {
        this.eflag = eflag;
    }

    public String getEflag() {
        return eflag;
    }

    public void setChpwrd(String chpwrd) {
        this.chpwrd = chpwrd;
    }

    public String getChpwrd() {
        return chpwrd;
    }

    public void CheckPwrd(ValueChangeEvent vce) {
        //        String pwrd = (String)vce.getNewValue();
        //        if (!pwrd.equals(chpwrd)) {
        //            erun = "Y";
        //            FacesMessage Message =
        //                new FacesMessage("Password does not match.");
        //            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
        //            FacesContext fc = FacesContext.getCurrentInstance();
        //            fc.addMessage(null, Message);
        //        }
    }

    public void setCpwFlag(String cpwFlag) {
        this.cpwFlag = cpwFlag;
    }

    public String getCpwFlag() {
        return cpwFlag;
    }

    public void setPgPwrd(RichPanelGroupLayout pgPwrd) {
        this.pgPwrd = pgPwrd;
    }

    public RichPanelGroupLayout getPgPwrd() {
        return pgPwrd;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentType() {
        return contentType;
    }

    public void setBlob(BlobDomain blob) {
        this.blob = blob;
    }

    public BlobDomain getBlob() {
        return blob;
    }

    public void setUpFileBind(RichInputFile upFileBind) {
        this.upFileBind = upFileBind;
    }

    public RichInputFile getUpFileBind() {
        return upFileBind;
    }

    public void onFileUploadVCL(ValueChangeEvent vce) {
        System.out.println("<---Valuechange listner is executed--->");
        file = (UploadedFile)vce.getNewValue();
        fileName = file.getFilename();
        contentType = file.getContentType();
        String FileExt =
            contentType.substring(contentType.lastIndexOf("/") + 1);
        if ((FileExt.equals("jpeg")) || (FileExt.equals("plain")) ||
            (FileExt.equals("msword")) || (FileExt.equals("gif")) ||
            (FileExt.equals("pdf"))) {
            blob = getBlob(file);
            long l = file.getLength();
            long kb = l / 1024;
            long mb = kb / 1024;
            fileSize = Double.toString(mb);
            //            FileUploadaction();
        } else {
            FacesMessage Message = new FacesMessage(ERR_Attach);
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public void uploadedFile_corrmistJudge(UploadedFile file, String did) {

        if (file != null) {
            fileName = file.getFilename();
            contentType = file.getContentType();
            String FileExt =
                contentType.substring(contentType.lastIndexOf("/") + 1);
            blob = getBlob(file);
            double l = file.getLength();
            double kb = l / 1024;
            double mb = kb / 1024;
            fileSize = df2.format(kb) + " kB";
            FileUploadaction(did);
        }
    }

    public void deposit_money_onFileUploadVCL(ValueChangeEvent vce) {
        System.out.println("<---Valuechange listner is executed--->");
        file = (UploadedFile)vce.getNewValue();
        fileName = file.getFilename();
        contentType = file.getContentType();
        String FileExt =
            contentType.substring(contentType.lastIndexOf("/") + 1);
        if ((FileExt.equals("jpeg")) || (FileExt.equals("plain")) ||
            (FileExt.equals("msword")) || (FileExt.equals("gif")) ||
            (FileExt.equals("pdf"))) {
            blob = getBlob(file);
            long l = file.getLength();
            long kb = l / 1024;
            long mb = kb / 1024;
            fileSize = Double.toString(mb);
            //            deposit_money_FileUploadaction();
        } else {
            FacesMessage Message = new FacesMessage(ERR_Attach);
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public void uploadFile_depmoney(UploadedFile file, String did) {
        fileName = file.getFilename();
        contentType = file.getContentType();
        blob = getBlob(file);
        double l = file.getLength();
        double kb = l / 1024;
        double mb = kb / 1024;
        fileSize = df2.format(kb) + " kB";
        if (mb < 10) {
            deposit_money_FileUploadaction(did);
        } else {
            FacesMessage Message =
                new FacesMessage("File Size should be less than 10 MB");
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }


    public void uploadfile_decmoney(UploadedFile file, String did) {
        fileName = file.getFilename();
        contentType = file.getContentType();
        blob = getBlob(file);
        double l = file.getLength();
        double kb = l / 1024;
        double mb = kb / 1024;
        fileSize = df2.format(kb) + " kB";
        if (mb < 10) {
            decision_appeal_FileUploadaction(did);
        } else {
            FacesMessage Message =
                new FacesMessage("File Size should be less than 10 MB");
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public void disburse_interpreter_onFileUploadVCL(ValueChangeEvent vce) {
        System.out.println("<---Valuechange listner is executed--->");
        file = (UploadedFile)vce.getNewValue();
        fileName = file.getFilename();
        contentType = file.getContentType();
        String FileExt =
            contentType.substring(contentType.lastIndexOf("/") + 1);
        if ((FileExt.equals("jpeg")) || (FileExt.equals("plain")) ||
            (FileExt.equals("msword")) || (FileExt.equals("gif")) ||
            (FileExt.equals("pdf"))) {
            blob = getBlob(file);
            long l = file.getLength();
            long kb = l / 1024;
            long mb = kb / 1024;
            fileSize = Double.toString(mb);
            //            disburse_interpreter_FileUploadaction();
        } else {
            FacesMessage Message = new FacesMessage(ERR_Attach);
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public void uploadFile_disbInt(UploadedFile file, String did) {
        fileName = file.getFilename();
        contentType = file.getContentType();
        blob = getBlob(file);
        double l = file.getLength();
        double kb = l / 1024;
        double mb = kb / 1024;
        fileSize = df2.format(kb) + " kB";
        if (mb < 10) {
            disburse_interpreter_FileUploadaction(did);
        } else {
            FacesMessage Message =
                new FacesMessage("File Size should be less than 10 MB");
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public void disburse_expfee_onFileUploadVCL(ValueChangeEvent vce) {
        System.out.println("<---Valuechange listner is executed--->");
        file = (UploadedFile)vce.getNewValue();
        fileName = file.getFilename();
        contentType = file.getContentType();
        String FileExt =
            contentType.substring(contentType.lastIndexOf("/") + 1);
        if ((FileExt.equals("jpeg")) || (FileExt.equals("plain")) ||
            (FileExt.equals("msword")) || (FileExt.equals("gif")) ||
            (FileExt.equals("pdf"))) {
            blob = getBlob(file);
            long l = file.getLength();
            long kb = l / 1024;
            long mb = kb / 1024;
            fileSize = Double.toString(mb);
            //            disburse_expfee_FileUploadaction();
        } else {
            FacesMessage Message = new FacesMessage(ERR_Attach);
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public void uploadFiles_disbexp(UploadedFile file, String did) {
        fileName = file.getFilename();
        contentType = file.getContentType();
        blob = getBlob(file);
        double l = file.getLength();
        double kb = l / 1024;
        double mb = kb / 1024;
        fileSize = df2.format(kb) + " kB";
        if (mb < 10) {
            disburse_expfee_FileUploadaction(did);
        } else {
            FacesMessage Message =
                new FacesMessage("File Size should be less than 10 MB");
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    /*public void end_custody_juvenile_onFileUploadVCL(ValueChangeEvent vce) {
        System.out.println("<---Valuechange listner is executed--->");
        file = (UploadedFile)vce.getNewValue();
        fileName = file.getFilename();
        contentType = file.getContentType();
        String FileExt =
            contentType.substring(contentType.lastIndexOf("/") + 1);
        if ((FileExt.equals("jpeg")) || (FileExt.equals("plain")) ||
            (FileExt.equals("msword")) || (FileExt.equals("gif")) ||
            (FileExt.equals("pdf"))) {
            blob = getBlob(file);
            long l = file.getLength();
            long kb = l / 1024;
            long mb = kb / 1024;
            fileSize = Double.toString(mb);
            end_custody_juvenile_FileUploadaction();
        } else {
            FacesMessage Message = new FacesMessage(ERR_Attach);
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }*/

    public void upload_endCustJuve() {
        System.out.println("<---Valuechange listner is executed--->");
        List<UploadedFile> file_u = this.getUploadedfile();
        if (file_u != null) {
            for (int i = 0; i < file_u.size(); i++) {
                fileName = file_u.get(i).getFilename();
                contentType = file_u.get(i).getContentType();
                String FileExt =
                    contentType.substring(contentType.lastIndexOf("/") + 1);
                //                if ((FileExt.equals("jpeg")) || (FileExt.equals("plain")) ||
                //                    (FileExt.equals("msword")) || (FileExt.equals("gif")) ||
                //                    (FileExt.equals("pdf"))) {
                blob = getBlob(file_u.get(i));
                double l = file_u.get(i).getLength();
                double kb = l / 1024;
                double mb = kb / 1024;
                fileSize = df2.format(kb) + " kB";
                //                end_custody_juvenile_FileUploadaction();
                //                } else {
                //                    FacesMessage Message = new FacesMessage(ERR_Attach);
                //                    Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                //                    FacesContext fc = FacesContext.getCurrentInstance();
                //                    fc.addMessage(null, Message);
                //                }
            }
        }
    }

    public void upload_endCustJuve(UploadedFile file, String did) {
        fileName = file.getFilename();
        contentType = file.getContentType();
        blob = getBlob(file);
        double l = file.getLength();
        double kb = l / 1024;
        double mb = kb / 1024;
        fileSize = df2.format(kb) + " kB";
        if (mb < 10) {
            end_custody_juvenile_FileUploadaction(did);
        } else {
            FacesMessage Message =
                new FacesMessage("File Size should be less than 10 MB");
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }


    public void appeal_onFileUploadVCL(ValueChangeEvent vce) {
        System.out.println("<---Valuechange listner is executed--->");
        file = (UploadedFile)vce.getNewValue();
        fileName = file.getFilename();
        contentType = file.getContentType();
        String FileExt =
            contentType.substring(contentType.lastIndexOf("/") + 1);
        if ((FileExt.equals("jpeg")) || (FileExt.equals("plain")) ||
            (FileExt.equals("msword")) || (FileExt.equals("gif")) ||
            (FileExt.equals("pdf"))) {
            blob = getBlob(file);
            long l = file.getLength();
            long kb = l / 1024;
            long mb = kb / 1024;
            fileSize = Double.toString(mb);
            //            appeal_FileUploadaction();
        } else {
            FacesMessage Message = new FacesMessage(ERR_Attach);
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public void uploadfile_appeal(UploadedFile file, String did) {
        fileName = file.getFilename();
        contentType = file.getContentType();
        blob = getBlob(file);
        double l = file.getLength();
        double kb = l / 1024;
        double mb = kb / 1024;
        fileSize = df2.format(kb) + " kB";
        if (mb < 10) {
            appeal_FileUploadaction(did);
        } else {
            FacesMessage Message =
                new FacesMessage("File Size should be less than 10 MB");
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public void fine_ret_req_onFileUploadVCL(ValueChangeEvent vce) {
        _logger.info("Started executing file upload");
        file = (UploadedFile)vce.getNewValue();
        fileName = file.getFilename();
        contentType = file.getContentType();
        String FileExt =
            contentType.substring(contentType.lastIndexOf("/") + 1);
        if ((FileExt.equals("jpeg")) || (FileExt.equals("plain")) ||
            (FileExt.equals("msword")) || (FileExt.equals("gif")) ||
            (FileExt.equals("pdf"))) {
            blob = getBlob(file);
            long l = file.getLength();
            long kb = l / 1024;
            long mb = kb / 1024;
            System.out.println("//////////////       Get the file size :: " +
                               mb);
            fileSize = Double.toString(mb);
            if (mb < 10) {
                //                fineretreq_FileUploadaction();
            } else {
                fineretreqUpFileBind.resetValue();
                FacesMessage Message =
                    new FacesMessage("File Size should be less than 10 MB");
                Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, Message);
            }
        } else {
            FacesMessage Message = new FacesMessage(ERR_Attach);
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public void uploadedFile_fienretreq(UploadedFile file, String did) {
        fileName = file.getFilename();
        contentType = file.getContentType();
        blob = getBlob(file);
        double l = file.getLength();
        double kb = l / 1024;
        double mb = kb / 1024;
        fileSize = df2.format(kb) + " kB";
        if (mb < 10) {
            fineretreq_FileUploadaction(did);
        } else {
            FacesMessage Message =
                new FacesMessage("File Size should be less than 10 MB");
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public void lawyer_prf_onFileUploadVCL(ValueChangeEvent vce) {
        _logger.info("Started executing file upload");
        file = (UploadedFile)vce.getNewValue();
        fileName = file.getFilename();
        contentType = file.getContentType();
        String fileExt =
            contentType.substring(contentType.lastIndexOf("/") + 1);
        String FileExt =
            contentType.substring(contentType.lastIndexOf("/" + 1));
        if ((FileExt.equals("jpeg")) || (FileExt.equals("plain")) ||
            (FileExt.equals("msword")) || (FileExt.equals("gif")) ||
            (FileExt.equals("pdf"))) {
            _logger.info("Get the file extension ................... :::::  " +
                         fileExt);
            blob = getBlob(file);
            long l = file.getLength();
            long kb = l / 1024;
            long mb = kb / 1024;
            fileSize = Double.toString(mb);
            if (mb < 10) {
                //                lawyer_profile_FileUploadaction();
            } else {
                lawyerprfUpFileBind.resetValue();
                FacesMessage Message =
                    new FacesMessage("File Size should be less than 10 MB");
                Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, Message);
            }
        } else {
            FacesMessage Message = new FacesMessage(ERR_Attach);
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public void uploadFile_Lawyerprf(UploadedFile file, String did) {
        fileName = file.getFilename();
        contentType = file.getContentType();
        blob = getBlob(file);
        double l = file.getLength();
        double kb = l / 1024;
        double mb = kb / 1024;
        fileSize = df2.format(kb) + " kB";
        if (mb < 10) {
            lawyer_profile_FileUploadaction(did);
        } else {
            FacesMessage Message =
                new FacesMessage("File Size should be less than 10 MB");
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public void col_doc_onFileUploadVCL(ValueChangeEvent vce) {
        _logger.info("Started executing file upload");
        file = (UploadedFile)vce.getNewValue();
        fileName = file.getFilename();
        contentType = file.getContentType();
        String FileExt =
            contentType.substring(contentType.lastIndexOf("/") + 1);
        if ((FileExt.equals("jpeg")) || (FileExt.equals("plain")) ||
            (FileExt.equals("msword")) || (FileExt.equals("gif")) ||
            (FileExt.equals("pdf"))) {
            //            blob = getBlob(file);
            //            long l = file.getLength();
            //            long kb = l / 1024;
            //            long mb = kb / 1024;
            //            fileSize = Double.toString(mb);
            //            if (mb < 10) {
            //                coll_doc_FileUploadaction();
            //            } else {
            //                coldocUpFileBind.resetValue();
            //                FacesMessage Message =
            //                    new FacesMessage("File Size should be less than 10 MB");
            //                Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            //                FacesContext fc = FacesContext.getCurrentInstance();
            //                fc.addMessage(null, Message);
            //            }
        } else {
            FacesMessage Message = new FacesMessage(ERR_Attach);
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public void UploadFile_col_doc(UploadedFile file, String did) {
        fileName = file.getFilename();
        contentType = file.getContentType();
        blob = getBlob(file);
        double l = file.getLength();
        double kb = l / 1024;
        double mb = kb / 1024;
        fileSize = df2.format(kb) + " kB";
        if (mb < 10) {
            coll_doc_FileUploadaction(did);
        } else {
            FacesMessage Message =
                new FacesMessage("File Size should be less than 10 MB");
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }


    public void pay_fine_impc_onFileUploadVCL(ValueChangeEvent vce) {
        _logger.info("Started executing file upload");
        file = (UploadedFile)vce.getNewValue();
        fileName = file.getFilename();
        contentType = file.getContentType();
        String FileExt =
            contentType.substring(contentType.lastIndexOf("/") + 1);
        if ((FileExt.equals("jpeg")) || (FileExt.equals("plain")) ||
            (FileExt.equals("msword")) || (FileExt.equals("gif")) ||
            (FileExt.equals("pdf"))) {
            blob = getBlob(file);
            long l = file.getLength();
            long kb = l / 1024;
            long mb = kb / 1024;
            fileSize = Double.toString(mb);
            if (mb < 10) {
                //                pay_fine_impc_FileUploadaction();
            } else {
                payfineUpFileBind.resetValue();
                FacesMessage Message =
                    new FacesMessage("File Size should be less than 10 MB");
                Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, Message);
            }
        } else {
            FacesMessage Message = new FacesMessage(ERR_Attach);
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public void uploadFile_payfineimp(UploadedFile file, String did) {
        fileName = file.getFilename();
        contentType = file.getContentType();
        blob = getBlob(file);
        double l = file.getLength();
        double kb = l / 1024;
        double mb = kb / 1024;
        fileSize = df2.format(kb) + " kB";
        if (mb < 10) {
            pay_fine_impc_FileUploadaction(did);
        } else {
            FacesMessage Message =
                new FacesMessage("File Size should be less than 10 MB");
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }


    public void pay_law_fee_onFileUploadVCL(ValueChangeEvent vce) {
        _logger.info("Started executing file upload");
        file = (UploadedFile)vce.getNewValue();
        fileName = file.getFilename();
        contentType = file.getContentType();
        String FileExt =
            contentType.substring(contentType.lastIndexOf("/") + 1);
        if ((FileExt.equals("jpeg")) || (FileExt.equals("plain")) ||
            (FileExt.equals("msword")) || (FileExt.equals("gif")) ||
            (FileExt.equals("pdf"))) {
            blob = getBlob(file);
            long l = file.getLength();
            long kb = l / 1024;
            long mb = kb / 1024;
            fileSize = Double.toString(mb);
            if (mb < 10) {
                //                pay_lawyer_fee_FileUploadaction();
            } else {
                payLawFeeFileBind.resetValue();
                FacesMessage Message =
                    new FacesMessage("File Size should be less than 10 MB");
                Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, Message);
            }
        } else {
            FacesMessage Message = new FacesMessage(ERR_Attach);
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public void uploadFile_paylawfee(UploadedFile file, String did) {
        fileName = file.getFilename();
        contentType = file.getContentType();
        blob = getBlob(file);
        double l = file.getLength();
        double kb = l / 1024;
        double mb = kb / 1024;
        fileSize = df2.format(kb) + " kB";
        if (mb < 10) {
            pay_lawyer_fee_FileUploadaction(did);
        } else {
            FacesMessage Message =
                new FacesMessage("File Size should be less than 10 MB");
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }


    public void uploadedfile_fineperbail(UploadedFile file, String did) {
        fileName = file.getFilename();
        contentType = file.getContentType();
        blob = getBlob(file);
        double l = file.getLength();
        double kb = l / 1024;
        double mb = kb / 1024;
        fileSize = df2.format(kb) + " kB";
        if (mb < 10) {
            prov_fin_per_FileUploadaction(did);
        } else {
            FacesMessage Message =
                new FacesMessage("File Size should be less than 10 MB");
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public void rec_corpse_onFileUploadVCL(ValueChangeEvent vce) {
        _logger.info("Started executing file upload");
        file = (UploadedFile)vce.getNewValue();
        fileName = file.getFilename();
        contentType = file.getContentType();
        String FileExt =
            contentType.substring(contentType.lastIndexOf("/") + 1);
        if ((FileExt.equals("jpeg")) || (FileExt.equals("plain")) ||
            (FileExt.equals("msword")) || (FileExt.equals("gif")) ||
            (FileExt.equals("pdf"))) {
            blob = getBlob(file);
            long l = file.getLength();
            long kb = l / 1024;
            long mb = kb / 1024;
            fileSize = Double.toString(mb);
            if (mb < 10) {
                //                rec_corpse_FileUploadaction();
            } else {
                this.recCorpFileBind.resetValue();
                FacesMessage Message =
                    new FacesMessage("File Size should be less than 10 MB");
                Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, Message);
            }
        } else {
            FacesMessage Message = new FacesMessage(ERR_Attach);
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public void uploadedFile_recCorpse(UploadedFile file, String did) {
        fileName = file.getFilename();
        contentType = file.getContentType();
        blob = getBlob(file);
        double l = file.getLength();
        double kb = l / 1024;
        double mb = kb / 1024;
        fileSize = df2.format(kb) + " kB";
        if (mb < 10) {
            rec_corpse_FileUploadaction(did);
        } else {
            FacesMessage Message =
                new FacesMessage("File Size should be less than 10 MB");
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }


    public void uploadFile_excbail(UploadedFile file, String did) {
        fileName = file.getFilename();
        contentType = file.getContentType();
        blob = getBlob(file);
        double l = file.getLength();
        double kb = l / 1024;
        double mb = kb / 1024;
        fileSize = df2.format(kb) + " kB";
        if (mb < 10) {
            rec_Exc_Bill_FileUploadaction(did);
        } else {
            FacesMessage Message =
                new FacesMessage("File Size should be less than 10 MB");
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }


    public void uploadFile_review(UploadedFile file, String did) {
        fileName = file.getFilename();
        contentType = file.getContentType();
        blob = getBlob(file);
        double l = file.getLength();
        double kb = l / 1024;
        double mb = kb / 1024;
        fileSize = df2.format(kb) + " kB";
        if (mb < 10) {
            rec_review_FileUploadaction(did);
        } else {
            FacesMessage Message =
                new FacesMessage("File Size should be less than 10 MB");
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public void ref_inm_onFileUploadVCL(ValueChangeEvent vce) {
        _logger.info("Started executing file upload");
        file = (UploadedFile)vce.getNewValue();
        fileName = file.getFilename();
        contentType = file.getContentType();
        String FileExt =
            contentType.substring(contentType.lastIndexOf("/") + 1);
        if ((FileExt.equals("jpeg")) || (FileExt.equals("plain")) ||
            (FileExt.equals("msword")) || (FileExt.equals("gif")) ||
            (FileExt.equals("pdf"))) {
            blob = getBlob(file);
            long l = file.getLength();
            long kb = l / 1024;
            long mb = kb / 1024;
            fileSize = Double.toString(mb);
            if (mb < 10) {
                //                rec_ref_inmate_FileUploadaction();
            } else {
                refinmUPFilebind.resetValue();
                FacesMessage Message =
                    new FacesMessage("File Size should be less than 10 MB");
                Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, Message);
            }
        } else {
            FacesMessage Message = new FacesMessage(ERR_Attach);
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public void uploadedFile_refinm(UploadedFile file, String did) {
        fileName = file.getFilename();
        contentType = file.getContentType();
        blob = getBlob(file);
        double l = file.getLength();
        double kb = l / 1024;
        double mb = kb / 1024;
        fileSize = df2.format(kb) + " kB";
        if (mb < 10) {
            rec_ref_inmate_FileUploadaction(did);
        } else {
            FacesMessage Message =
                new FacesMessage("File Size should be less than 10 MB");
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }


    public void uploadFile_caseCopy(UploadedFile file, String did) {
        fileName = file.getFilename();
        contentType = file.getContentType();
        blob = getBlob(file);
        double l = file.getLength();
        double kb = l / 1024;
        double mb = kb / 1024;
        fileSize = df2.format(kb) + " kB";
        if (mb < 10) {
            Case_copy1FileUploadaction(did);
        } else {
            FacesMessage Message =
                new FacesMessage("File Size should be less than 10 MB");
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }


    public void uploadedFile_copyJudg(UploadedFile file, String did) {
        fileName = file.getFilename();
        contentType = file.getContentType();
        blob = getBlob(file);
        double l = file.getLength();
        double kb = l / 1024;
        double mb = kb / 1024;
        fileSize = df2.format(kb) + " kB";
        if (mb < 10) {
            copy_judgeFileUploadaction(did);
        } else {
            FacesMessage Message =
                new FacesMessage("File Size should be less than 10 MB");
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }


    public void uploadfile_cpynsordr(UploadedFile file, String did) {
        fileName = file.getFilename();
        contentType = file.getContentType();
        blob = getBlob(file);
        double l = file.getLength();
        double kb = l / 1024;
        double mb = kb / 1024;
        fileSize = df2.format(kb) + " kB";
        if (mb < 10) {
            cpy_ns_ordr_FileUploadaction(did);
        } else {
            FacesMessage Message =
                new FacesMessage("File Size should be less than 10 MB");
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public void adj_sess_new_dte_onFileUploadVCL(ValueChangeEvent vce) {
        _logger.info("Started executing file upload");
        file = (UploadedFile)vce.getNewValue();
        fileName = file.getFilename();
        contentType = file.getContentType();
        String FileExt =
            contentType.substring(contentType.lastIndexOf("/") + 1);
        if ((FileExt.equals("jpeg")) || (FileExt.equals("plain")) ||
            (FileExt.equals("msword")) || (FileExt.equals("gif")) ||
            (FileExt.equals("pdf"))) {
            blob = getBlob(file);
            long l = file.getLength();
            long kb = l / 1024;
            long mb = kb / 1024;
            fileSize = Double.toString(mb);
            if (mb < 10) {
                //                adj_sess_new_dte_FileUploadaction(did);
            } else {
                cpynsoUPFilebind.resetValue();
                FacesMessage Message =
                    new FacesMessage("File Size should be less than 10 MB");
                Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, Message);
            }
        } else {
            FacesMessage Message = new FacesMessage(ERR_Attach);
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public void uploadfile_AdjSessionDte(UploadedFile file, String did) {
        fileName = file.getFilename();
        contentType = file.getContentType();
        blob = getBlob(file);
        double l = file.getLength();
        double kb = l / 1024;
        double mb = kb / 1024;
        fileSize = df2.format(kb) + " kB";
        if (mb < 10) {
            adj_sess_new_dte_FileUploadaction(did);

        } else {
            FacesMessage Message =
                new FacesMessage("File Size should be less than 10 MB");
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public void uploadfile_recSeizure(UploadedFile file, String did) {
        fileName = file.getFilename();
        contentType = file.getContentType();
        blob = getBlob(file);
        double l = file.getLength();
        double kb = l / 1024;
        double mb = kb / 1024;
        fileSize = df2.format(kb) + " kB";
        if (mb < 10) {
            //            adj_sess_new_dte_FileUploadaction(did);
            rec_seizure_fileupload(did);
        } else {
            FacesMessage Message =
                new FacesMessage("File Size should be less than 10 MB");
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public void Drop_Court_Impose_onFileUploadVCL(ValueChangeEvent vce) {
        _logger.info("Started executing file upload");
        file = (UploadedFile)vce.getNewValue();
        fileName = file.getFilename();
        contentType = file.getContentType();
        String FileExt =
            contentType.substring(contentType.lastIndexOf("/") + 1);
        if ((FileExt.equals("jpeg")) || (FileExt.equals("plain")) ||
            (FileExt.equals("msword")) || (FileExt.equals("gif")) ||
            (FileExt.equals("pdf"))) {
            blob = getBlob(file);
            long l = file.getLength();
            long kb = l / 1024;
            long mb = kb / 1024;
            fileSize = Double.toString(mb);
            if (mb < 10) {
                //                Drop_Court_DueFileUploadaction();
            } else {
                this.DciDueUPFilebind.resetValue();
                FacesMessage Message =
                    new FacesMessage("File Size should be less than 10 MB");
                Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, Message);
            }
        } else {
            FacesMessage Message = new FacesMessage(ERR_Attach);
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public void uploadedFile_dropcourt() {
        _logger.info("Started executing file upload");
        List<UploadedFile> file_u = this.getUploadedfile();
        if (file_u != null) {
            for (int i = 0; i < file_u.size(); i++) {
                fileName = file_u.get(i).getFilename();
                contentType = file_u.get(i).getContentType();
                String FileExt =
                    contentType.substring(contentType.lastIndexOf("/") + 1);
                //                if ((FileExt.equals("jpeg")) || (FileExt.equals("plain")) ||
                //                    (FileExt.equals("msword")) || (FileExt.equals("gif")) ||
                //                    (FileExt.equals("pdf"))) {
                blob = getBlob(file_u.get(i));
                long l = file_u.get(i).getLength();
                long kb = l / 1024;
                long mb = kb / 1024;
                fileSize = Double.toString(mb);
                if (mb < 10) {
                    //                    Drop_Court_DueFileUploadaction();
                } else {
                    this.DciDueUPFilebind.resetValue();
                    FacesMessage Message =
                        new FacesMessage("File Size should be less than 10 MB");
                    Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                    FacesContext fc = FacesContext.getCurrentInstance();
                    fc.addMessage(null, Message);
                }
                //                } else {
                //                    FacesMessage Message = new FacesMessage(ERR_Attach);
                //                    Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                //                    FacesContext fc = FacesContext.getCurrentInstance();
                //                    fc.addMessage(null, Message);
                //                }
            }
        }
    }

    public void uploadedFile_dropcourt(UploadedFile file, String did) {
        fileName = file.getFilename();
        contentType = file.getContentType();
        blob = getBlob(file);
        double l = file.getLength();
        double kb = l / 1024;
        double mb = kb / 1024;
        fileSize = df2.format(kb) + " kB";
        if (mb < 10) {
            Drop_Court_DueFileUploadaction(did);
        } else {
            FacesMessage Message =
                new FacesMessage("File Size should be less than 10 MB");
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }


    public void uploadfile_exhaumation(UploadedFile file, String did) {
        fileName = file.getFilename();
        contentType = file.getContentType();
        blob = getBlob(file);
        double l = file.getLength();
        double kb = l / 1024;
        double mb = kb / 1024;
        fileSize = df2.format(kb) + " kB";
        if (mb < 10) {
            Exhumation_FileUploadaction(did);
        } else {
            FacesMessage Message =
                new FacesMessage("File Size should be less than 10 MB");
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public void EoPCase_onFileUploadVCL(ValueChangeEvent vce) {
        _logger.info("Started executing file upload");
        file = (UploadedFile)vce.getNewValue();
        fileName = file.getFilename();
        contentType = file.getContentType();
        String FileExt =
            contentType.substring(contentType.lastIndexOf("/") + 1);
        if ((FileExt.equals("jpeg")) || (FileExt.equals("plain")) ||
            (FileExt.equals("msword")) || (FileExt.equals("gif")) ||
            (FileExt.equals("pdf"))) {
            blob = getBlob(file);
            long l = file.getLength();
            long kb = l / 1024;
            long mb = kb / 1024;
            fileSize = Double.toString(mb);
            if (mb < 10) {
                //                EoPCase_FileUploadaction();
            } else {
                this.EoPCaseUPFilebind.resetValue();
                FacesMessage Message =
                    new FacesMessage("File Size should be less than 10 MB");
                Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, Message);
            }
        } else {
            FacesMessage Message = new FacesMessage(ERR_Attach);
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public void uploadfile_eopcase(UploadedFile file, String did) {
        fileName = file.getFilename();
        contentType = file.getContentType();
        blob = getBlob(file);
        double l = file.getLength();
        double kb = l / 1024;
        double mb = kb / 1024;
        fileSize = df2.format(kb) + " kB";
        if (mb < 10) {
            EoPCase_FileUploadaction(did);
        } else {
            FacesMessage Message =
                new FacesMessage("File Size should be less than 10 MB");
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public void FDReim_onFileUploadVCL(ValueChangeEvent vce) {
        _logger.info("Started executing file upload");
        file = (UploadedFile)vce.getNewValue();
        fileName = file.getFilename();
        contentType = file.getContentType();
        String FileExt =
            contentType.substring(contentType.lastIndexOf("/") + 1);
        if ((FileExt.equals("jpeg")) || (FileExt.equals("plain")) ||
            (FileExt.equals("msword")) || (FileExt.equals("gif")) ||
            (FileExt.equals("pdf"))) {
            blob = getBlob(file);
            long l = file.getLength();
            long kb = l / 1024;
            long mb = kb / 1024;
            fileSize = Double.toString(mb);
            if (mb < 10) {
                //                FdReimbur_FileUploadaction();
            } else {
                this.FdreimburUPFilebind.resetValue();
                FacesMessage Message =
                    new FacesMessage("File Size should be less than 10 MB");
                Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, Message);
            }
        } else {
            FacesMessage Message = new FacesMessage(ERR_Attach);
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public void uploadedfile_fdreim(UploadedFile file, String did) {
        fileName = file.getFilename();
        contentType = file.getContentType();
        blob = getBlob(file);
        double l = file.getLength();
        double kb = l / 1024;
        double mb = kb / 1024;
        fileSize = df2.format(kb) + " kB";
        if (mb < 10) {
            FdReimbur_FileUploadaction(did);
        } else {
            FacesMessage Message =
                new FacesMessage("File Size should be less than 10 MB");
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public void MeetProc_onFileUploadVCL(ValueChangeEvent vce) {
        _logger.info("Started executing file upload");
        file = (UploadedFile)vce.getNewValue();
        fileName = file.getFilename();
        contentType = file.getContentType();
        String FileExt =
            contentType.substring(contentType.lastIndexOf("/") + 1);
        if ((FileExt.equals("jpeg")) || (FileExt.equals("plain")) ||
            (FileExt.equals("msword")) || (FileExt.equals("gif")) ||
            (FileExt.equals("pdf"))) {
            blob = getBlob(file);
            long l = file.getLength();
            long kb = l / 1024;
            long mb = kb / 1024;
            fileSize = Double.toString(mb);
            if (mb < 10) {
                //                Meet_Proc_FileUploadaction();
            } else {
                this.MeetProcUPFilebind.resetValue();
                FacesMessage Message =
                    new FacesMessage("File Size should be less than 10 MB");
                Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, Message);
            }
        } else {
            FacesMessage Message = new FacesMessage(ERR_Attach);
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public void uploadfile_meetproc(UploadedFile file, String did) {
        fileName = file.getFilename();
        contentType = file.getContentType();
        blob = getBlob(file);
        double l = file.getLength();
        double kb = l / 1024;
        double mb = kb / 1024;
        fileSize = df2.format(kb) + " kB";
        if (mb < 10) {
            Meet_Proc_FileUploadaction(did);
        } else {
            FacesMessage Message =
                new FacesMessage("File Size should be less than 10 MB");
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public void OpenofMem_onFileUploadVCL(ValueChangeEvent vce) {
        _logger.info("Started executing file upload");
        file = (UploadedFile)vce.getNewValue();
        fileName = file.getFilename();
        contentType = file.getContentType();
        String FileExt =
            contentType.substring(contentType.lastIndexOf("/") + 1);
        if ((FileExt.equals("jpeg")) || (FileExt.equals("plain")) ||
            (FileExt.equals("msword")) || (FileExt.equals("gif")) ||
            (FileExt.equals("pdf"))) {
            blob = getBlob(file);
            long l = file.getLength();
            long kb = l / 1024;
            long mb = kb / 1024;
            fileSize = Double.toString(mb);
            if (mb < 10) {
                //                Openof_Mem_FileUploadaction();
            } else {
                this.OpenofMemUPFilebind.resetValue();
                FacesMessage Message =
                    new FacesMessage("File Size should be less than 10 MB");
                Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, Message);
            }
        } else {
            FacesMessage Message = new FacesMessage(ERR_Attach);
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public void uploadedFile_openmem(UploadedFile file, String did) {
        fileName = file.getFilename();
        contentType = file.getContentType();
        blob = getBlob(file);
        double l = file.getLength();
        double kb = l / 1024;
        double mb = kb / 1024;
        fileSize = df2.format(kb) + " kB";
        if (mb < 10) {
            Openof_Mem_FileUploadaction(did);
        } else {
            FacesMessage Message =
                new FacesMessage("File Size should be less than 10 MB");
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }


    public void uploadFile_PportRenewal(UploadedFile file, String did) {
        fileName = file.getFilename();
        contentType = file.getContentType();
        blob = getBlob(file);
        double l = file.getLength();
        double kb = l / 1024;
        double mb = kb / 1024;
        fileSize = df2.format(kb) + " kB";
        if (mb < 10) {
            PportRenewal_FileUploadaction(did);
        } else {
            FacesMessage Message =
                new FacesMessage("File Size should be less than 10 MB");
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public void PaymentinstanlCourt_onFileUploadVCL(ValueChangeEvent vce) {
        _logger.info("Started executing file upload");
        file = (UploadedFile)vce.getNewValue();
        fileName = file.getFilename();
        contentType = file.getContentType();
        String FileExt =
            contentType.substring(contentType.lastIndexOf("/") + 1);
        if ((FileExt.equals("jpeg")) || (FileExt.equals("plain")) ||
            (FileExt.equals("msword")) || (FileExt.equals("gif")) ||
            (FileExt.equals("pdf"))) {
            blob = getBlob(file);
            long l = file.getLength();
            long kb = l / 1024;
            long mb = kb / 1024;
            fileSize = Double.toString(mb);
            if (mb < 10) {
                //                PaymentinsCourt_FileUploadaction();
            } else {
                this.PpmentinsCourtUPFilebind.resetValue();
                FacesMessage Message =
                    new FacesMessage("File Size should be less than 10 MB");
                Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, Message);
            }
        } else {
            FacesMessage Message = new FacesMessage(ERR_Attach);
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public void uploadedfile_PaymentinstanlCourt(UploadedFile file,
                                                 String did) {
        fileName = file.getFilename();
        contentType = file.getContentType();
        blob = getBlob(file);
        double l = file.getLength();
        double kb = l / 1024;
        double mb = kb / 1024;
        fileSize = df2.format(kb) + " kB";
        if (mb < 10) {
            PaymentinsCourt_FileUploadaction(did);
        } else {
            FacesMessage Message =
                new FacesMessage("File Size should be less than 10 MB");
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public void uploadfile_Pcopycasedropdec(UploadedFile file, String did) {
        fileName = file.getFilename();
        contentType = file.getContentType();
        blob = getBlob(file);
        double l = file.getLength();
        double kb = l / 1024;
        double mb = kb / 1024;
        fileSize = df2.format(kb) + " kB";
        if (mb < 10) {
            Pcopycasedropdec_FileUploadaction(did);
        } else {
            FacesMessage Message =
                new FacesMessage("File Size should be less than 10 MB");
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public void Postpone_onFileUploadVCL(ValueChangeEvent vce) {
        _logger.info("Started executing file upload");
        file = (UploadedFile)vce.getNewValue();
        fileName = file.getFilename();
        contentType = file.getContentType();
        String FileExt =
            contentType.substring(contentType.lastIndexOf("/") + 1);
        if ((FileExt.equals("jpeg")) || (FileExt.equals("plain")) ||
            (FileExt.equals("msword")) || (FileExt.equals("gif")) ||
            (FileExt.equals("pdf"))) {
            blob = getBlob(file);
            long l = file.getLength();
            long kb = l / 1024;
            long mb = kb / 1024;
            fileSize = Double.toString(mb);
            if (mb < 10) {
                //                Postpone_FileUploadaction();
            } else {
                this.PostponeofFreeUPFilebind.resetValue();
                FacesMessage Message =
                    new FacesMessage("File Size should be less than 10 MB");
                Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, Message);
            }
        } else {
            FacesMessage Message = new FacesMessage(ERR_Attach);
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public void uplaodFile_postponefree(UploadedFile file, String did) {
        fileName = file.getFilename();
        contentType = file.getContentType();
        blob = getBlob(file);
        double l = file.getLength();
        double kb = l / 1024;
        double mb = kb / 1024;
        fileSize = df2.format(kb) + " kB";
        if (mb < 10) {
            Postpone_FileUploadaction(did);
        } else {
            FacesMessage Message =
                new FacesMessage("File Size should be less than 10 MB");
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }


    public void uploadedfile_recdepositedchrges(UploadedFile file,
                                                String did) {
        fileName = file.getFilename();
        contentType = file.getContentType();
        blob = getBlob(file);
        double l = file.getLength();
        double kb = l / 1024;
        double mb = kb / 1024;
        fileSize = df2.format(kb) + " kB";
        if (mb < 10) {
            RecDepChrg_FileUploadaction(did);
        } else {
            FacesMessage Message =
                new FacesMessage("File Size should be less than 10 MB");
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }


    private BlobDomain getBlob(UploadedFile file) {
        InputStream in = null;
        BlobDomain blobDomain = null;
        OutputStream out = null;
        try {
            in = file.getInputStream();
            blobDomain = new BlobDomain();
            out = blobDomain.getBinaryOutputStream();
            IOUtils.copy(in, out);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.fillInStackTrace();
        }
        return blobDomain;
    }

    public String FileUploadaction(String did) {
        ViewObject ravo = this.getAm().findViewObject("ReqAttachmentsView2");
        Row rar = ravo.createRow();
        rar.setAttribute("DisplayName", fileName);
        rar.setAttribute("ContentType", contentType);
        //        rar.setAttribute("Attachment", blob);
        rar.setAttribute("AttachSize", fileSize);
        rar.setAttribute("AttachDownloadUrl", ubean.downloadAttachUrl());
        ravo.insertRow(rar);
        Number attachid = (Number)rar.getAttribute("Id");
        this.insert_did(attachid, did);
        return null;
    }

    public String deposit_money_FileUploadaction(String did) {
        ViewObject ravo = this.getAm().findViewObject("ReqAttachmentsView3");
        Row rar = ravo.createRow();
        rar.setAttribute("DisplayName", fileName);
        rar.setAttribute("ContentType", contentType);
        //        rar.setAttribute("Attachment", blob);
        rar.setAttribute("AttachSize", fileSize);
        rar.setAttribute("AttachDownloadUrl", ubean.downloadAttachUrl());
        ravo.insertRow(rar);
        Number attachid = (Number)rar.getAttribute("Id");
        this.insert_did(attachid, did);
        return null;
    }

    public String decision_appeal_FileUploadaction(String did) {
        ViewObject ravo = this.getAm().findViewObject("ReqAttachmentsView4");
        Row rar = ravo.createRow();
        rar.setAttribute("DisplayName", fileName);
        rar.setAttribute("ContentType", contentType);
        //        rar.setAttribute("Attachment", blob);
        rar.setAttribute("AttachSize", fileSize);
        rar.setAttribute("AttachDownloadUrl", ubean.downloadAttachUrl());
        ravo.insertRow(rar);
        Number attachid = (Number)rar.getAttribute("Id");
        this.insert_did(attachid, did);
        return null;
    }

    public String disburse_interpreter_FileUploadaction(String did) {
        ViewObject ravo = this.getAm().findViewObject("ReqAttachmentsView5");
        Row rar = ravo.createRow();
        rar.setAttribute("DisplayName", fileName);
        rar.setAttribute("ContentType", contentType);
        //        rar.setAttribute("Attachment", blob);
        rar.setAttribute("AttachSize", fileSize);
        rar.setAttribute("AttachDownloadUrl", ubean.downloadAttachUrl());
        ravo.insertRow(rar);
        Number attachid = (Number)rar.getAttribute("Id");
        this.insert_did(attachid, did);
        return null;
    }

    public String disburse_expfee_FileUploadaction(String did) {
        ViewObject ravo = this.getAm().findViewObject("ReqAttachmentsView6");
        Row rar = ravo.createRow();
        rar.setAttribute("DisplayName", fileName);
        rar.setAttribute("ContentType", contentType);
        //        rar.setAttribute("Attachment", blob);
        rar.setAttribute("AttachSize", fileSize);
        rar.setAttribute("AttachDownloadUrl", ubean.downloadAttachUrl());
        ravo.insertRow(rar);
        Number attachid = (Number)rar.getAttribute("Id");
        this.insert_did(attachid, did);
        return null;
    }

    public String end_custody_juvenile_FileUploadaction(String did) {
        ViewObject ravo = this.getAm().findViewObject("ReqAttachmentsView7");
        Row rar = ravo.createRow();
        rar.setAttribute("DisplayName", fileName);
        rar.setAttribute("ContentType", contentType);
        //        rar.setAttribute("Attachment", blob);
        rar.setAttribute("AttachSize", fileSize);
        rar.setAttribute("AttachDownloadUrl", ubean.downloadAttachUrl());
        ravo.insertRow(rar);
        Number attachid = (Number)rar.getAttribute("Id");
        this.insert_did(attachid, did);
        //        FacesMessage Message = new FacesMessage("File Uploaded successfully");
        //        Message.setSeverity(FacesMessage.SEVERITY_INFO);
        //        FacesContext fc = FacesContext.getCurrentInstance();
        //        fc.addMessage(null, Message);
        //        System.out.println("File Uploaded successfully");
        //        ecajUpFileBind.resetValue();
        return null;
    }

    public String appeal_FileUploadaction(String did) {
        ViewObject ravo = this.getAm().findViewObject("ReqAttachmentsView8");
        Row rar = ravo.createRow();
        rar.setAttribute("DisplayName", fileName);
        rar.setAttribute("ContentType", contentType);
        //        rar.setAttribute("Attachment", blob);
        rar.setAttribute("AttachSize", fileSize);
        rar.setAttribute("AttachDownloadUrl", ubean.downloadAttachUrl());
        ravo.insertRow(rar);
        Number attachid = (Number)rar.getAttribute("Id");
        this.insert_did(attachid, did);
        return null;
    }

    public String fineretreq_FileUploadaction(String did) {
        ViewObject ravo = this.getAm().findViewObject("ReqAttachmentsView9");
        Row rar = ravo.createRow();
        rar.setAttribute("DisplayName", fileName);
        rar.setAttribute("ContentType", contentType);
        //        rar.setAttribute("Attachment", blob);
        rar.setAttribute("AttachSize", fileSize);
        rar.setAttribute("AttachDownloadUrl", ubean.downloadAttachUrl());
        ravo.insertRow(rar);
        Number attachid = (Number)rar.getAttribute("Id");
        this.insert_did(attachid, did);
        //        FacesMessage Message = new FacesMessage("File Uploaded successfully");
        //        Message.setSeverity(FacesMessage.SEVERITY_INFO);
        //        FacesContext fc = FacesContext.getCurrentInstance();
        //        fc.addMessage(null, Message);
        //        System.out.println("File Uploaded successfully");
        //        fineretreqUpFileBind.resetValue();
        return null;
    }

    public String lawyer_profile_FileUploadaction(String did) {
        ViewObject ravo = this.getAm().findViewObject("ReqAttachmentsView10");
        Row rar = ravo.createRow();
        rar.setAttribute("DisplayName", fileName);
        rar.setAttribute("ContentType", contentType);
        //        rar.setAttribute("Attachment", blob);
        rar.setAttribute("AttachSize", fileSize);
        rar.setAttribute("AttachDownloadUrl", ubean.downloadAttachUrl());
        ravo.insertRow(rar);
        Number attachid = (Number)rar.getAttribute("Id");
        this.insert_did(attachid, did);
        return null;
    }

    public String coll_doc_FileUploadaction(String did) {
        ViewObject ravo = this.getAm().findViewObject("ReqAttachmentsView11");
        Row rar = ravo.createRow();
        rar.setAttribute("DisplayName", fileName);
        rar.setAttribute("ContentType", contentType);
        //        rar.setAttribute("Attachment", blob);
        rar.setAttribute("AttachSize", fileSize);
        rar.setAttribute("AttachDownloadUrl", ubean.downloadAttachUrl());
        ravo.insertRow(rar);
        Number attachid = (Number)rar.getAttribute("Id");
        this.insert_did(attachid, did);
        return null;
    }

    public String pay_fine_impc_FileUploadaction(String did) {
        ViewObject ravo = this.getAm().findViewObject("ReqAttachmentsView12");
        Row rar = ravo.createRow();
        rar.setAttribute("DisplayName", fileName);
        rar.setAttribute("ContentType", contentType);
        //        rar.setAttribute("Attachment", blob);
        rar.setAttribute("AttachSize", fileSize);
        rar.setAttribute("AttachDownloadUrl", ubean.downloadAttachUrl());
        ravo.insertRow(rar);
        Number attachid = (Number)rar.getAttribute("Id");
        this.insert_did(attachid, did);
        return null;
    }

    public String pay_lawyer_fee_FileUploadaction(String did) {
        ViewObject ravo = this.getAm().findViewObject("ReqAttachmentsView13");
        Row rar = ravo.createRow();
        rar.setAttribute("DisplayName", fileName);
        rar.setAttribute("ContentType", contentType);
        //        rar.setAttribute("Attachment", blob);
        rar.setAttribute("AttachSize", fileSize);
        rar.setAttribute("AttachDownloadUrl", ubean.downloadAttachUrl());
        ravo.insertRow(rar);
        Number attachid = (Number)rar.getAttribute("Id");
        this.insert_did(attachid, did);
        return null;
    }

    public String prov_fin_per_FileUploadaction(String did) {
        ViewObject ravo = this.getAm().findViewObject("ReqAttachmentsView14");
        Row rar = ravo.createRow();
        rar.setAttribute("DisplayName", fileName);
        rar.setAttribute("ContentType", contentType);
        //        rar.setAttribute("Attachment", blob);
        rar.setAttribute("AttachSize", fileSize);
        rar.setAttribute("AttachDownloadUrl", ubean.downloadAttachUrl());
        ravo.insertRow(rar);
        Number attachid = (Number)rar.getAttribute("Id");
        this.insert_did(attachid, did);
        return null;
    }

    public String rec_corpse_FileUploadaction(String did) {
        ViewObject ravo = this.getAm().findViewObject("ReqAttachmentsView15");
        Row rar = ravo.createRow();
        rar.setAttribute("DisplayName", fileName);
        rar.setAttribute("ContentType", contentType);
        //        rar.setAttribute("Attachment", blob);
        rar.setAttribute("AttachSize", fileSize);
        rar.setAttribute("AttachDownloadUrl", ubean.downloadAttachUrl());
        ravo.insertRow(rar);
        Number attachid = (Number)rar.getAttribute("Id");
        this.insert_did(attachid, did);
        return null;
    }

    public String rec_Exc_Bill_FileUploadaction(String did) {
        ViewObject ravo = this.getAm().findViewObject("ReqAttachmentsView16");
        Row rar = ravo.createRow();
        rar.setAttribute("DisplayName", fileName);
        rar.setAttribute("ContentType", contentType);
        //        rar.setAttribute("Attachment", blob);
        rar.setAttribute("AttachSize", fileSize);
        rar.setAttribute("AttachDownloadUrl", ubean.downloadAttachUrl());
        ravo.insertRow(rar);
        Number attachid = (Number)rar.getAttribute("Id");
        this.insert_did(attachid, did);
        return null;
    }

    public String rec_ref_inmate_FileUploadaction(String did) {
        ViewObject ravo = this.getAm().findViewObject("ReqAttachmentsView17");
        Row rar = ravo.createRow();
        rar.setAttribute("DisplayName", fileName);
        rar.setAttribute("ContentType", contentType);
        //        rar.setAttribute("Attachment", blob);
        rar.setAttribute("AttachSize", fileSize);
        rar.setAttribute("AttachDownloadUrl", ubean.downloadAttachUrl());
        ravo.insertRow(rar);
        Number attachid = (Number)rar.getAttribute("Id");
        this.insert_did(attachid, did);
        return null;
    }

    public String rec_review_FileUploadaction(String did) {
        ViewObject ravo = this.getAm().findViewObject("ReqAttachmentsView18");
        Row rar = ravo.createRow();
        rar.setAttribute("DisplayName", fileName);
        rar.setAttribute("ContentType", contentType);
        //        rar.setAttribute("Attachment", blob);
        rar.setAttribute("AttachSize", fileSize);
        rar.setAttribute("AttachDownloadUrl", ubean.downloadAttachUrl());
        ravo.insertRow(rar);
        Number attachid = (Number)rar.getAttribute("Id");
        this.insert_did(attachid, did);
        return null;
    }

    public String Case_copy1FileUploadaction(String did) {
        ViewObject ravo = this.getAm().findViewObject("ReqAttachmentsView19");
        Row rar = ravo.createRow();
        rar.setAttribute("DisplayName", fileName);
        rar.setAttribute("ContentType", contentType);
        //        rar.setAttribute("Attachment", blob);
        rar.setAttribute("AttachSize", fileSize);
        rar.setAttribute("AttachDownloadUrl", ubean.downloadAttachUrl());
        ravo.insertRow(rar);
        Number attachid = (Number)rar.getAttribute("Id");
        this.insert_did(attachid, did);
        return null;
    }

    public String copy_judgeFileUploadaction(String did) {
        ViewObject ravo = this.getAm().findViewObject("ReqAttachmentsView20");
        Row rar = ravo.createRow();
        rar.setAttribute("DisplayName", fileName);
        rar.setAttribute("ContentType", contentType);
        //        rar.setAttribute("Attachment", blob);
        rar.setAttribute("AttachSize", fileSize);
        rar.setAttribute("AttachDownloadUrl", ubean.downloadAttachUrl());
        ravo.insertRow(rar);
        Number attachid = (Number)rar.getAttribute("Id");
        this.insert_did(attachid, did);
        return null;
    }

    public String cpy_ns_ordr_FileUploadaction(String did) {
        ViewObject ravo = this.getAm().findViewObject("ReqAttachmentsView21");
        Row rar = ravo.createRow();
        rar.setAttribute("DisplayName", fileName);
        rar.setAttribute("ContentType", contentType);
        //        rar.setAttribute("Attachment", blob);
        rar.setAttribute("AttachSize", fileSize);
        rar.setAttribute("AttachDownloadUrl", ubean.downloadAttachUrl());
        ravo.insertRow(rar);
        Number attachid = (Number)rar.getAttribute("Id");
        this.insert_did(attachid, did);
        return null;
    }

    public String adj_sess_new_dte_FileUploadaction(String did) {
        ViewObject ravo = this.getAm().findViewObject("ReqAttachmentsView22");
        Row rar = ravo.createRow();
        rar.setAttribute("DisplayName", fileName);
        rar.setAttribute("ContentType", contentType);
        //        rar.setAttribute("Attachment", blob);
        rar.setAttribute("AttachSize", fileSize);
        //        rar.setAttribute("AttachDownloadUrl", ubean.downloadAttachUrl());
        rar.setAttribute("AttachDownloadUrl", attachUrl);
        ravo.insertRow(rar);
        Number attachid = (Number)rar.getAttribute("Id");
        this.insert_did(attachid, did);
        return null;
    }

    public String rec_seizure_fileupload(String did) {
        ViewObject ravo = this.getAm().findViewObject("ReqAttachmentsView37");
        Row rar = ravo.createRow();
        rar.setAttribute("DisplayName", fileName);
        rar.setAttribute("ContentType", contentType);
        //        rar.setAttribute("Attachment", blob);
        rar.setAttribute("AttachSize", fileSize);
        //        rar.setAttribute("AttachDownloadUrl", ubean.downloadAttachUrl());
        rar.setAttribute("AttachDownloadUrl", attachUrl);
        ravo.insertRow(rar);
        Number attachid = (Number)rar.getAttribute("Id");
        this.insert_did(attachid, did);
        return null;
    }

    public String Drop_Court_DueFileUploadaction(String did) {
        ViewObject ravo = this.getAm().findViewObject("ReqAttachmentsView23");
        Row rar = ravo.createRow();
        rar.setAttribute("DisplayName", fileName);
        rar.setAttribute("ContentType", contentType);
        //        rar.setAttribute("Attachment", blob);
        rar.setAttribute("AttachSize", fileSize);
        rar.setAttribute("AttachDownloadUrl", ubean.downloadAttachUrl());
        ravo.insertRow(rar);
        Number attachid = (Number)rar.getAttribute("Id");
        this.insert_did(attachid, did);
        return null;
    }

    public String Exhumation_FileUploadaction(String did) {
        ViewObject ravo = this.getAm().findViewObject("ReqAttachmentsView24");
        Row rar = ravo.createRow();
        rar.setAttribute("DisplayName", fileName);
        rar.setAttribute("ContentType", contentType);
        //        rar.setAttribute("Attachment", blob);
        rar.setAttribute("AttachSize", fileSize);
        rar.setAttribute("AttachDownloadUrl", ubean.downloadAttachUrl());
        ravo.insertRow(rar);
        Number attachid = (Number)rar.getAttribute("Id");
        this.insert_did(attachid, did);
        return null;
    }

    public String EoPCase_FileUploadaction(String did) {
        ViewObject ravo = this.getAm().findViewObject("ReqAttachmentsView25");
        Row rar = ravo.createRow();
        rar.setAttribute("DisplayName", fileName);
        rar.setAttribute("ContentType", contentType);
        //        rar.setAttribute("Attachment", blob);
        rar.setAttribute("AttachSize", fileSize);
        rar.setAttribute("AttachDownloadUrl", ubean.downloadAttachUrl());
        ravo.insertRow(rar);
        //        FacesMessage Message = new FacesMessage("File Uploaded successfully");
        //        Message.setSeverity(FacesMessage.SEVERITY_INFO);
        //        FacesContext fc = FacesContext.getCurrentInstance();
        //        fc.addMessage(null, Message);
        //        System.out.println("File Uploaded successfully");
        //        this.EoPCaseUPFilebind.resetValue();
        Number attachid = (Number)rar.getAttribute("Id");
        this.insert_did(attachid, did);
        return null;
    }

    public String FdReimbur_FileUploadaction(String did) {
        ViewObject ravo = this.getAm().findViewObject("ReqAttachmentsView26");
        Row rar = ravo.createRow();
        rar.setAttribute("DisplayName", fileName);
        rar.setAttribute("ContentType", contentType);
        //        rar.setAttribute("Attachment", blob);
        rar.setAttribute("AttachSize", fileSize);
        rar.setAttribute("AttachDownloadUrl", ubean.downloadAttachUrl());
        ravo.insertRow(rar);
        Number attachid = (Number)rar.getAttribute("Id");
        this.insert_did(attachid, did);
        return null;
    }

    public String Meet_Proc_FileUploadaction(String did) {
        ViewObject ravo = this.getAm().findViewObject("ReqAttachmentsView27");
        Row rar = ravo.createRow();
        rar.setAttribute("DisplayName", fileName);
        rar.setAttribute("ContentType", contentType);
        //        rar.setAttribute("Attachment", blob);
        rar.setAttribute("AttachSize", fileSize);
        rar.setAttribute("AttachDownloadUrl", ubean.downloadAttachUrl());
        ravo.insertRow(rar);
        Number attachid = (Number)rar.getAttribute("Id");
        this.insert_did(attachid, did);
        return null;
    }

    public String Openof_Mem_FileUploadaction(String did) {
        ViewObject ravo = this.getAm().findViewObject("ReqAttachmentsView28");
        Row rar = ravo.createRow();
        rar.setAttribute("DisplayName", fileName);
        rar.setAttribute("ContentType", contentType);
        //        rar.setAttribute("Attachment", blob);
        rar.setAttribute("AttachSize", fileSize);
        rar.setAttribute("AttachDownloadUrl", ubean.downloadAttachUrl());
        ravo.insertRow(rar);
        Number attachid = (Number)rar.getAttribute("Id");
        this.insert_did(attachid, did);
        return null;
    }

    public String PportRenewal_FileUploadaction(String did) {
        ViewObject ravo = this.getAm().findViewObject("ReqAttachmentsView29");
        Row rar = ravo.createRow();
        rar.setAttribute("DisplayName", fileName);
        rar.setAttribute("ContentType", contentType);
        //        rar.setAttribute("Attachment", blob);
        rar.setAttribute("AttachSize", fileSize);
        rar.setAttribute("AttachDownloadUrl", ubean.downloadAttachUrl());
        ravo.insertRow(rar);
        Number attachid = (Number)rar.getAttribute("Id");
        this.insert_did(attachid, did);
        return null;
    }

    public String PaymentinsCourt_FileUploadaction(String did) {
        ViewObject ravo = getAm().findViewObject("ReqAttachmentsView30");
        Row rar = ravo.createRow();
        rar.setAttribute("DisplayName", fileName);
        rar.setAttribute("ContentType", contentType);
        //        rar.setAttribute("Attachment", blob);
        rar.setAttribute("AttachSize", fileSize);
        rar.setAttribute("AttachDownloadUrl", ubean.downloadAttachUrl());
        ravo.insertRow(rar);
        Number attachid = (Number)rar.getAttribute("Id");
        this.insert_did(attachid, did);
        return null;
    }

    public String Pcopycasedropdec_FileUploadaction(String did) {
        ViewObject ravo = this.getAm().findViewObject("ReqAttachmentsView31");
        Row rar = ravo.createRow();
        rar.setAttribute("DisplayName", fileName);
        rar.setAttribute("ContentType", contentType);
        //        rar.setAttribute("Attachment", blob);
        rar.setAttribute("AttachSize", fileSize);
        rar.setAttribute("AttachDownloadUrl", ubean.downloadAttachUrl());
        ravo.insertRow(rar);
        Number attachid = (Number)rar.getAttribute("Id");
        this.insert_did(attachid, did);
        return null;
    }

    public String Postpone_FileUploadaction(String did) {
        ViewObject ravo = this.getAm().findViewObject("ReqAttachmentsView32");
        Row rar = ravo.createRow();
        rar.setAttribute("DisplayName", fileName);
        rar.setAttribute("ContentType", contentType);
        //        rar.setAttribute("Attachment", blob);
        rar.setAttribute("AttachSize", fileSize);
        rar.setAttribute("AttachDownloadUrl", ubean.downloadAttachUrl());
        ravo.insertRow(rar);
        Number attachid = (Number)rar.getAttribute("Id");
        this.insert_did(attachid, did);
        return null;
    }

    public String RecDepChrg_FileUploadaction(String did) {
        ViewObject ravo = this.getAm().findViewObject("ReqAttachmentsView33");
        Row rar = ravo.createRow();
        rar.setAttribute("DisplayName", fileName);
        rar.setAttribute("ContentType", contentType);
        //        rar.setAttribute("Attachment", blob);
        rar.setAttribute("AttachSize", fileSize);
        rar.setAttribute("AttachDownloadUrl", ubean.downloadAttachUrl());
        ravo.insertRow(rar);
        Number attachid = (Number)rar.getAttribute("Id");
        this.insert_did(attachid, did);
        return null;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileSize() {
        return fileSize;
    }

    public String judgeMistMataction() {
        //        commit_action();
        ADFUtils afu = new ADFUtils();
        String key = (String)afu.evaluateEL("#{pageFlowScope.key}");
        Locale localel = (Locale)afu.evaluateEL("#{pageFlowScope.locale}");
        String locale = localel.toString();
        //        String locale = "en";
        String s = "Y";
        java.util.List<UploadedFile> file_u = this.getUploadedfile();
        ViewObject caseinfovo = getAm().findViewObject("ReqCaseInfoView1");
        ViewObject reqview = getAm().findViewObject("ReqRequestsView2");
        ViewObject corrmistvo =
            getAm().findViewObject("ReqCorrMistJudgMatView1");
        Row corrmistr = corrmistvo.getCurrentRow();
        if ((corrmistr.getAttribute("CaseNo") != null) &&
            (corrmistr.getAttribute("CaseYear") != null) &&
            (corrmistr.getAttribute("ProsecName") != null) &&
            (corrmistr.getAttribute("RelCase") != null) &&
            (errorType != null) &&
            (corrmistr.getAttribute("CorrectedPhrase") != null)) {
            Number cno = (Number)corrmistr.getAttribute("CaseNo");
            Number cyear = (Number)corrmistr.getAttribute("CaseYear");
            String cpname = (String)corrmistr.getAttribute("ProsecName");
            int sid = Integer.parseInt(key);
            //            int sid = 34;
            BigDecimal caseno = new BigDecimal(cno.toString());
            BigDecimal name = new BigDecimal(cpname.toString());
            BigDecimal year = new BigDecimal(cyear.toString());
            String res = this.validatingCase(sid, caseno, name, year);
            //            String res = "ok";
            if (res.equals("ok")) {
                Row casinfr = caseinfovo.createRow();
                Row reqr = reqview.createRow();
                System.err.println("<---Get the error type----->" +
                                   getErrorType());
                corrmistr.setAttribute("ErrorType", getErrorType());
                corrmistr.setAttribute("CaseInfo",
                                       casinfr.getAttribute("CaseId"));
                casinfr.setAttribute("CaseNumber",
                                     corrmistr.getAttribute("CaseNo"));
                casinfr.setAttribute("CaseYear",
                                     corrmistr.getAttribute("CaseYear"));
                casinfr.setAttribute("CaseType",
                                     corrmistr.getAttribute("ProsecName"));
                casinfr.setAttribute("Relation",
                                     corrmistr.getAttribute("RelCase"));
                reqr.setAttribute("ReqName", setServiceNames(locale, key));
                reqr.setAttribute("CaseInfoId",
                                  casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ServiceId", sid);
                corrmistr.setAttribute("CaseInfo",
                                       casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ProsecId",
                                  corrmistr.getAttribute("ProsecName"));

                if (file_u != null) {
                    String validateFile = validateFileUpload(file_u);
                    if (validateFile.equals("N")) {
                        for (int i = 0; i < file_u.size(); i++) {
                            Number foldern =
                                (Number)reqr.getAttribute("ReqId");
                            String foldername = foldern.toString();
                            if (i == 0) {
                                ubean.createFolder(foldername);
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadedFile_corrmistJudge(file_u.get(i),
                                                           ubean.getDid());
                            } else {
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadedFile_corrmistJudge(file_u.get(i),
                                                           ubean.getDid());
                            }
                        }
                    } else {
                        casinfr.remove();
                        reqr.remove();
                        s = "N";
                        FacesContext.getCurrentInstance().addMessage(upFileBind.getClientId(FacesContext.getCurrentInstance()),
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                      "File Type extension are not allowed",
                                                                                      "Kindly reload the files"));
                    }
                }
                if (s.equals("Y")) {
                    commit_action();
                    sentEmail((Number)reqr.getAttribute("ReqId"),
                              setServiceNames(locale, key), locale);
                    afu.setEL("#{pageFlowScope.casno}",
                              reqr.getAttribute("ReqId"));
                    oracle.jbo.domain.Number csid =
                        (Number)reqr.getAttribute("ReqId");
                    executeSMSproc((String)ADFContext.getCurrent().getSessionScope().get("mobile"),
                                   csid);
                    return "Y";
                }
            } else {
                return "N";
            }
        }
        if (corrmistr.getAttribute("CaseNo") == null) {
            this.setCn("Y");
        }
        if (corrmistr.getAttribute("CaseYear") == null) {
            this.setCy("Y");
        }
        if ((corrmistr.getAttribute("ProsecName") == null) ||
            (corrmistr.getAttribute("ProsecName").equals("LOV_pn_en")) ||
            (corrmistr.getAttribute("ProsecName").equals("LOV_pn_ar"))) {
            this.setPc("Y");
        }
        if ((corrmistr.getAttribute("RelCase") == null)) {
            this.setRc("Y");
        }
        if (errorType == null) {
            this.setEt("Y");
        }
        if (corrmistr.getAttribute("CorrectedPhrase") == null) {
            this.setCp("Y");
        }
        return null;
    }

    public String depositMoneyaction() {
        String key = (String)afu.evaluateEL("#{pageFlowScope.key}");
        Locale localel = (Locale)afu.evaluateEL("#{pageFlowScope.locale}");
        String locale = localel.toString();
        String s = "Y";
        ViewObject caseinfovo = getAm().findViewObject("ReqCaseInfoView1");
        ViewObject reqview = getAm().findViewObject("ReqRequestsView3");
        ViewObject corrmistvo = getAm().findViewObject("ReqDepositMoneyView1");
        Row corrmistr = corrmistvo.getCurrentRow();
        if (corrmistr.getAttribute("CaseNo") != null &&
            corrmistr.getAttribute("CaseYear") != null &&
            corrmistr.getAttribute("ProsecutionName") != null &&
            corrmistr.getAttribute("RelationWithcase") != null &&
            (!corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_en")) &&
            (!corrmistr.getAttribute("RelationWithcase").equals("LOV_RelationCase_en")) &&
            corrmistr.getAttribute("DepositAmount") != null &&
            corrmistr.getAttribute("AccusedName") != null) {
            Number cno = (Number)corrmistr.getAttribute("CaseNo");
            Number cyear = (Number)corrmistr.getAttribute("CaseYear");
            String cpname = (String)corrmistr.getAttribute("ProsecutionName");
            int sid = Integer.parseInt(key);
            BigDecimal caseno = new BigDecimal(cno.toString());
            BigDecimal name = new BigDecimal(cpname.toString());
            BigDecimal year = new BigDecimal(cyear.toString());
            String res = this.validatingCase(sid, caseno, name, year);

            if (res.equals("ok")) {
                Row casinfr = caseinfovo.createRow();
                Row reqr = reqview.createRow();
                casinfr.setAttribute("CaseNumber",
                                     corrmistr.getAttribute("CaseNo"));
                casinfr.setAttribute("CaseYear",
                                     corrmistr.getAttribute("CaseYear"));
                casinfr.setAttribute("CaseType",
                                     corrmistr.getAttribute("ProsecutionName"));
                casinfr.setAttribute("Relation",
                                     corrmistr.getAttribute("RelationWithcase"));
                reqr.setAttribute("ReqName", setServiceNames(locale, key));
                reqr.setAttribute("CaseInfoId",
                                  casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ServiceId", 11);
                corrmistr.setAttribute("CaseInfo",
                                       casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ProsecId",
                                  corrmistr.getAttribute("ProsecutionName"));
                //                uploadFile_depmoney();
                //                commit_action();
                //                sentEmail((Number)casinfr.getAttribute("CaseId"),
                //                          "Deposit Money in favor of Plaintiff");
                //                return "Y";
                java.util.List<UploadedFile> file_u = this.getUploadedfile();
                if (file_u != null) {
                    String validateFile = validateFileUpload(file_u);
                    if (validateFile.equals("N")) {
                        for (int i = 0; i < file_u.size(); i++) {
                            Number foldern =
                                (Number)reqr.getAttribute("ReqId");
                            String foldername = foldern.toString();
                            if (i == 0) {
                                ubean.createFolder(foldername);
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadFile_depmoney(file_u.get(i),
                                                    ubean.getDid());
                            } else {
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadFile_depmoney(file_u.get(i),
                                                    ubean.getDid());
                            }
                        }
                    } else {
                        casinfr.remove();
                        reqr.remove();
                        s = "N";
                        FacesContext.getCurrentInstance().addMessage(upFileBind.getClientId(FacesContext.getCurrentInstance()),
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                      "File Type extension are not allowed",
                                                                                      "Kindly reload the files"));
                    }
                }
                if (s.equals("Y")) {
                    commit_action();
                    sentEmail((Number)reqr.getAttribute("ReqId"),
                              setServiceNames(locale, key), locale);
                    afu.setEL("#{pageFlowScope.casno}",
                              reqr.getAttribute("ReqId"));
                    oracle.jbo.domain.Number csid =
                        (Number)reqr.getAttribute("ReqId");
                    executeSMSproc((String)ADFContext.getCurrent().getSessionScope().get("mobile"),
                                   csid);
                    return "Y";
                }
            } else {
                return "N";
            }
        }
        if (corrmistr.getAttribute("CaseNo") == null) {
            this.setCn("Y");
        }
        if (corrmistr.getAttribute("CaseYear") == null) {
            this.setCy("Y");
        }
        if ((corrmistr.getAttribute("ProsecutionName") == null) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_en")) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_ar"))) {
            this.setPc("Y");
        }
        if ((corrmistr.getAttribute("RelationWithcase") == null) ||
            (corrmistr.getAttribute("RelationWithcase").equals("LOV_RelationCase_en")) ||
            (corrmistr.getAttribute("RelationWithcase").equals("LOV_RelationCase_ar"))) {
            this.setRc("Y");
        }
        if ((corrmistr.getAttribute("DepositAmount") == null)) {
            this.setDm("Y");
        }
        if ((corrmistr.getAttribute("AccusedName") == null)) {
            this.setAn("Y");
        }
        return null;
    }

    public String decisionAppealaction() {
        String key = (String)afu.evaluateEL("#{pageFlowScope.key}");
        Locale localel = (Locale)afu.evaluateEL("#{pageFlowScope.locale}");
        String locale = localel.toString();
        String s = "Y";
        ViewObject caseinfovo = getAm().findViewObject("ReqCaseInfoView1");
        ViewObject reqview = getAm().findViewObject("ReqRequestsView4");
        ViewObject corrmistvo =
            getAm().findViewObject("ReqDecisionAppealView1");
        Row corrmistr = corrmistvo.getCurrentRow();
        if (corrmistr.getAttribute("CaseNo") != null &&
            corrmistr.getAttribute("CaseYear") != null &&
            corrmistr.getAttribute("ProsecutionName") != null &&
            corrmistr.getAttribute("SentenseDate") != null &&
            corrmistr.getAttribute("RelationCase") != null &&
            (!corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_en")) &&
            (!corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_en"))) {
            Number cno = (Number)corrmistr.getAttribute("CaseNo");
            Number cyear = (Number)corrmistr.getAttribute("CaseYear");
            String cpname = (String)corrmistr.getAttribute("ProsecutionName");
            int sid = Integer.parseInt(key);
            BigDecimal caseno = new BigDecimal(cno.toString());
            BigDecimal name = new BigDecimal(cpname.toString());
            BigDecimal year = new BigDecimal(cyear.toString());
            String res = this.validatingCase(sid, caseno, name, year);
            if (res.equals("ok")) {
                Row casinfr = caseinfovo.createRow();
                Row reqr = reqview.createRow();
                casinfr.setAttribute("CaseNumber",
                                     corrmistr.getAttribute("CaseNo"));
                casinfr.setAttribute("CaseYear",
                                     corrmistr.getAttribute("CaseYear"));
                casinfr.setAttribute("CaseType",
                                     corrmistr.getAttribute("ProsecutionName"));
                casinfr.setAttribute("Relation",
                                     corrmistr.getAttribute("RelationCase"));
                reqr.setAttribute("ReqName", setServiceNames(locale, key));
                reqr.setAttribute("CaseInfoId",
                                  casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ServiceId", sid);
                corrmistr.setAttribute("CaseInfo",
                                       casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ProsecId",
                                  corrmistr.getAttribute("ProsecutionName"));
                //                uploadfile_decmoney();
                //                commit_action();
                //                sentEmail((Number)casinfr.getAttribute("CaseId"),
                //                          "Decision of Appeal");
                //                return "Y";
                java.util.List<UploadedFile> file_u = this.getUploadedfile();
                if (file_u != null) {
                    String validateFile = validateFileUpload(file_u);
                    if (validateFile.equals("N")) {
                        for (int i = 0; i < file_u.size(); i++) {
                            Number foldern =
                                (Number)reqr.getAttribute("ReqId");
                            String foldername = foldern.toString();
                            if (i == 0) {
                                ubean.createFolder(foldername);
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadfile_decmoney(file_u.get(i),
                                                    ubean.getDid());
                            } else {
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadfile_decmoney(file_u.get(i),
                                                    ubean.getDid());
                            }
                        }
                    } else {
                        casinfr.remove();
                        reqr.remove();
                        s = "N";
                        FacesContext.getCurrentInstance().addMessage(upFileBind.getClientId(FacesContext.getCurrentInstance()),
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                      "File Type extension are not allowed",
                                                                                      "Kindly reload the files"));
                    }
                }
                if (s.equals("Y")) {
                    commit_action();
                    sentEmail((Number)reqr.getAttribute("ReqId"),
                              setServiceNames(locale, key), locale);
                    afu.setEL("#{pageFlowScope.casno}",
                              reqr.getAttribute("ReqId"));
                    oracle.jbo.domain.Number csid =
                        (Number)reqr.getAttribute("ReqId");
                    executeSMSproc((String)ADFContext.getCurrent().getSessionScope().get("mobile"),
                                   csid);
                    return "Y";
                }
            } else {
                if (!res.equals(""))
                    return "NotAllowed";
                else
                    return "N";
            }
        }
        if (corrmistr.getAttribute("CaseNo") == null) {
            this.setCn("Y");
        }
        if (corrmistr.getAttribute("CaseYear") == null) {
            this.setCy("Y");
        }
        if ((corrmistr.getAttribute("ProsecutionName") == null) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_en")) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_ar"))) {
            this.setPc("Y");
        }
        if ((corrmistr.getAttribute("RelationCase") == null) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_en")) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_ar"))) {
            this.setRc("Y");
        }
        if (corrmistr.getAttribute("SentenseDate") != null) {
            this.setSntdte("Y");
        }
        return null;
    }

    public String disburseInterpreteraction() {
        String key = (String)afu.evaluateEL("#{pageFlowScope.key}");
        Locale localel = (Locale)afu.evaluateEL("#{pageFlowScope.locale}");
        String locale = localel.toString();
        String s = "Y";
        ViewObject caseinfovo = getAm().findViewObject("ReqCaseInfoView1");
        ViewObject reqview = getAm().findViewObject("ReqRequestsView5");
        ViewObject corrmistvo =
            getAm().findViewObject("ReqDisburseInterpreterView1");
        Row corrmistr = corrmistvo.getCurrentRow();
        if (corrmistr.getAttribute("CaseNo") != null &&
            corrmistr.getAttribute("CaseYear") != null &&
            corrmistr.getAttribute("ProsecutionName") != null &&
            corrmistr.getAttribute("RelationCase") != null &&
            corrmistr.getAttribute("Iban") != null &&
            (!corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_en")) &&
            (!corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_en"))) {
            Number cno = (Number)corrmistr.getAttribute("CaseNo");
            Number cyear = (Number)corrmistr.getAttribute("CaseYear");
            String cpname = (String)corrmistr.getAttribute("ProsecutionName");
            int sid = Integer.parseInt(key);
            BigDecimal caseno = new BigDecimal(cno.toString());
            BigDecimal name = new BigDecimal(cpname.toString());
            BigDecimal year = new BigDecimal(cyear.toString());
            String res = this.validatingCase(sid, caseno, name, year);
            if (res.equals("ok")) {
                Row casinfr = caseinfovo.createRow();
                Row reqr = reqview.createRow();
                casinfr.setAttribute("CaseNumber",
                                     corrmistr.getAttribute("CaseNo"));
                casinfr.setAttribute("CaseYear",
                                     corrmistr.getAttribute("CaseYear"));
                casinfr.setAttribute("CaseType",
                                     corrmistr.getAttribute("ProsecutionName"));
                casinfr.setAttribute("Relation",
                                     corrmistr.getAttribute("RelationCase"));
                reqr.setAttribute("ReqName", setServiceNames(locale, key));
                reqr.setAttribute("CaseInfoId",
                                  casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ServiceId", sid);
                corrmistr.setAttribute("CaseInfo",
                                       casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ProsecId",
                                  corrmistr.getAttribute("ProsecutionName"));
                //                uploadFile_disbInt();
                //                commit_action();
                //                sentEmail((Number)casinfr.getAttribute("CaseId"),
                //                          "Disburse Interpreter Fees");
                //                return "Y";
                java.util.List<UploadedFile> file_u = this.getUploadedfile();
                UCMBean ubean = new UCMBean();
                if (file_u != null) {
                    String validateFile = validateFileUpload(file_u);
                    if (validateFile.equals("N")) {
                        for (int i = 0; i < file_u.size(); i++) {
                            Number foldern =
                                (Number)reqr.getAttribute("ReqId");
                            String foldername = foldern.toString();
                            if (i == 0) {
                                ubean.createFolder(foldername);
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadFile_disbInt(file_u.get(i),
                                                   ubean.getDid());
                            } else {
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadFile_disbInt(file_u.get(i),
                                                   ubean.getDid());
                            }
                        }
                    } else {
                        casinfr.remove();
                        reqr.remove();
                        s = "N";
                        FacesContext.getCurrentInstance().addMessage(upFileBind.getClientId(FacesContext.getCurrentInstance()),
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                      "File Type extension are not allowed",
                                                                                      "Kindly reload the files"));
                    }
                }
                if (s.equals("Y")) {
                    commit_action();
                    sentEmail((Number)reqr.getAttribute("ReqId"),
                              setServiceNames(locale, key), locale);
                    afu.setEL("#{pageFlowScope.casno}",
                              reqr.getAttribute("ReqId"));
                    oracle.jbo.domain.Number csid =
                        (Number)reqr.getAttribute("ReqId");
                    executeSMSproc((String)ADFContext.getCurrent().getSessionScope().get("mobile"),
                                   csid);
                    return "Y";
                }
            } else {
                return "N";
            }
        }
        if (corrmistr.getAttribute("CaseNo") == null) {
            this.setCn("Y");
        }
        if (corrmistr.getAttribute("CaseYear") == null) {
            this.setCy("Y");
        }
        if ((corrmistr.getAttribute("ProsecutionName") == null) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_en")) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_ar"))) {
            this.setPc("Y");
        }
        if ((corrmistr.getAttribute("RelationCase") == null) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_en")) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_ar"))) {
            this.setRc("Y");
        }
        if (corrmistr.getAttribute("Iban") == null) {
            ln = "Y";
        }
        return null;
    }

    public String disbExpFeeInterpreteraction() {
        String key = (String)afu.evaluateEL("#{pageFlowScope.key}");
        Locale localel = (Locale)afu.evaluateEL("#{pageFlowScope.locale}");
        String locale = localel.toString();
        String s = "Y";
        ViewObject caseinfovo = getAm().findViewObject("ReqCaseInfoView1");
        ViewObject reqview = getAm().findViewObject("ReqRequestsView6");
        ViewObject corrmistvo = getAm().findViewObject("ReqDisbExpFeeView1");
        Row corrmistr = corrmistvo.getCurrentRow();
        if (corrmistr.getAttribute("CaseNo") != null &&
            corrmistr.getAttribute("CaseYear") != null &&
            corrmistr.getAttribute("ProsecutionName") != null &&
            corrmistr.getAttribute("RelationCase") != null &&
            corrmistr.getAttribute("LbanNumber") != null &&
            (!corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_en")) &&
            (!corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_en"))) {
            Number cno = (Number)corrmistr.getAttribute("CaseNo");
            Number cyear = (Number)corrmistr.getAttribute("CaseYear");
            String cpname = (String)corrmistr.getAttribute("ProsecutionName");
            int sid = Integer.parseInt(key);
            BigDecimal caseno = new BigDecimal(cno.toString());
            BigDecimal name = new BigDecimal(cpname.toString());
            BigDecimal year = new BigDecimal(cyear.toString());
            String res = this.validatingCase(sid, caseno, name, year);
            if (res.equals("ok")) {
                Row casinfr = caseinfovo.createRow();
                Row reqr = reqview.createRow();
                casinfr.setAttribute("CaseNumber",
                                     corrmistr.getAttribute("CaseNo"));
                casinfr.setAttribute("CaseYear",
                                     corrmistr.getAttribute("CaseYear"));
                casinfr.setAttribute("CaseType",
                                     corrmistr.getAttribute("ProsecutionName"));
                casinfr.setAttribute("Relation",
                                     corrmistr.getAttribute("RelationCase"));
                reqr.setAttribute("ReqName", setServiceNames(locale, key));
                reqr.setAttribute("CaseInfoId",
                                  casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ServiceId", sid);
                corrmistr.setAttribute("CaseInfo",
                                       casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ProsecId",
                                  corrmistr.getAttribute("ProsecutionName"));
                //                uploadFiles_disbexp();
                //                commit_action();
                //                sentEmail((Number)casinfr.getAttribute("CaseId"),
                //                          "Correcting Mistake in Judgment Material");
                //                return "Y";
                java.util.List<UploadedFile> file_u = this.getUploadedfile();
                if (file_u != null) {
                    String validateFile = validateFileUpload(file_u);
                    if (validateFile.equals("N")) {
                        for (int i = 0; i < file_u.size(); i++) {
                            Number foldern =
                                (Number)reqr.getAttribute("ReqId");
                            String foldername = foldern.toString();
                            if (i == 0) {
                                ubean.createFolder(foldername);
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadFiles_disbexp(file_u.get(i),
                                                    ubean.getDid());
                            } else {
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadFiles_disbexp(file_u.get(i),
                                                    ubean.getDid());
                            }
                        }
                    } else {
                        casinfr.remove();
                        reqr.remove();
                        s = "N";
                        FacesContext.getCurrentInstance().addMessage(upFileBind.getClientId(FacesContext.getCurrentInstance()),
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                      "File Type extension are not allowed",
                                                                                      "Kindly reload the files"));
                    }
                }
                if (s.equals("Y")) {
                    commit_action();
                    sentEmail((Number)reqr.getAttribute("ReqId"),
                              setServiceNames(locale, key), locale);
                    afu.setEL("#{pageFlowScope.casno}",
                              reqr.getAttribute("ReqId"));
                    oracle.jbo.domain.Number csid =
                        (Number)reqr.getAttribute("ReqId");
                    executeSMSproc((String)ADFContext.getCurrent().getSessionScope().get("mobile"),
                                   csid);
                    return "Y";
                }
            } else {
                return "N";
            }
        }
        if (corrmistr.getAttribute("CaseNo") == null) {
            this.setCn("Y");
        }
        if (corrmistr.getAttribute("CaseYear") == null) {
            this.setCy("Y");
        }
        if ((corrmistr.getAttribute("ProsecutionName") == null) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_en")) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_ar"))) {
            this.setPc("Y");
        }
        if ((corrmistr.getAttribute("RelationCase") == null) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_en")) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_ar"))) {
            this.setRc("Y");
        }
        if (corrmistr.getAttribute("LbanNumber") == null) {
            this.setLn("Y");
        }
        return null;
    }

    public String endCustAgaJuveaction() {
        String key = (String)afu.evaluateEL("#{pageFlowScope.key}");
        Locale localel = (Locale)afu.evaluateEL("#{pageFlowScope.locale}");
        String locale = localel.toString();
        //        String locale = "en";
        String s = "Y";
        ViewObject caseinfovo = getAm().findViewObject("ReqCaseInfoView1");
        ViewObject reqview = getAm().findViewObject("ReqRequestsView7");
        ViewObject corrmistvo =
            getAm().findViewObject("ReqEndCustodyJuvenileView1");
        Row corrmistr = corrmistvo.getCurrentRow();
        if (corrmistr.getAttribute("CaseNo") != null &&
            corrmistr.getAttribute("CaseYear") != null &&
            corrmistr.getAttribute("ProsecutionName") != null &&
            corrmistr.getAttribute("RelationCase") != null &&
            (!corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_en")) &&
            (!corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_en"))) {
            Number cno = (Number)corrmistr.getAttribute("CaseNo");
            Number cyear = (Number)corrmistr.getAttribute("CaseYear");
            String cpname = (String)corrmistr.getAttribute("ProsecutionName");
            //            String res = check_case_info_common(cyear, cpname, cno);
            int sid = Integer.parseInt(key);
            BigDecimal caseno = new BigDecimal(cno.toString());
            BigDecimal name = new BigDecimal(cpname.toString());
            BigDecimal year = new BigDecimal(cyear.toString());
            String res = this.validatingCase(sid, caseno, name, year);
            if (res.equals("ok")) {
                Row casinfr = caseinfovo.createRow();
                Row reqr = reqview.createRow();
                casinfr.setAttribute("CaseNumber",
                                     corrmistr.getAttribute("CaseNo"));
                casinfr.setAttribute("CaseYear",
                                     corrmistr.getAttribute("CaseYear"));
                casinfr.setAttribute("CaseType",
                                     corrmistr.getAttribute("ProsecutionName"));
                casinfr.setAttribute("Relation",
                                     corrmistr.getAttribute("RelationCase"));
                reqr.setAttribute("ReqName", setServiceNames(locale, key));
                reqr.setAttribute("CaseInfoId",
                                  casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ServiceId", sid);
                corrmistr.setAttribute("CaseInfo",
                                       casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ProsecId",
                                  corrmistr.getAttribute("ProsecutionName"));
                //                upload_endCustJuve();
                /*commit_action();
                String email =
                    (String)ADFContext.getCurrent().getSessionScope().get("usermail");
                sentEmail((Number)casinfr.getAttribute("CaseId"),
                          "Ending a custody against a juvenile");
                return "Y";*/
                java.util.List<UploadedFile> file_u = this.getUploadedfile();
                if (file_u != null) {
                    String validateFile = validateFileUpload(file_u);
                    if (validateFile.equals("N")) {
                        for (int i = 0; i < file_u.size(); i++) {
                            Number foldern =
                                (Number)reqr.getAttribute("ReqId");
                            String foldername = foldern.toString();
                            if (i == 0) {
                                ubean.createFolder(foldername);
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                upload_endCustJuve(file_u.get(i),
                                                   ubean.getDid());
                            } else {
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                upload_endCustJuve(file_u.get(i),
                                                   ubean.getDid());
                            }
                        }
                    } else {
                        casinfr.remove();
                        reqr.remove();
                        s = "N";
                        FacesContext.getCurrentInstance().addMessage(upFileBind.getClientId(FacesContext.getCurrentInstance()),
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                      "File Type extension are not allowed",
                                                                                      "Kindly reload the files"));
                    }
                }
                if (s.equals("Y")) {
                    commit_action();
                    sentEmail((Number)reqr.getAttribute("ReqId"),
                              setServiceNames(locale, key), locale);
                    afu.setEL("#{pageFlowScope.casno}",
                              reqr.getAttribute("ReqId"));
                    oracle.jbo.domain.Number csid =
                        (Number)reqr.getAttribute("ReqId");
                    executeSMSproc((String)ADFContext.getCurrent().getSessionScope().get("mobile"),
                                   csid);
                    return "Y";
                }
            } else {
                /* FacesMessage Message =
                new FacesMessage("You are not Party to the Case");
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);*/
                return "N";
            }
        }
        if (corrmistr.getAttribute("CaseNo") == null) {
            this.setCn("Y");
        }
        if (corrmistr.getAttribute("CaseYear") == null) {
            this.setCy("Y");
        }
        if ((corrmistr.getAttribute("ProsecutionName") == null) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_en")) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_ar"))) {
            this.setPc("Y");
        }
        if ((corrmistr.getAttribute("RelationCase") == null) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_en")) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_ar"))) {
            this.setRc("Y");
        }
        return null;
    }

    public String appealaction() {
        String key = (String)afu.evaluateEL("#{pageFlowScope.key}");
        Locale localel = (Locale)afu.evaluateEL("#{pageFlowScope.locale}");
        String locale = localel.toString();
        String s = "Y";
        ViewObject caseinfovo = getAm().findViewObject("ReqCaseInfoView1");
        ViewObject reqview = getAm().findViewObject("ReqRequestsView8");
        ViewObject corrmistvo = getAm().findViewObject("ReqAppealView1");
        Row corrmistr = corrmistvo.getCurrentRow();
        if ((corrmistr.getAttribute("Caseno") != null) &&
            (corrmistr.getAttribute("Caseyear") != null) &&
            (corrmistr.getAttribute("Prosecutionname") != null) &&
            (corrmistr.getAttribute("Subject") != null) &&
            (corrmistr.getAttribute("Relationwithcase") != null)) {
            Number cno = (Number)corrmistr.getAttribute("Caseno");
            Number cyear = (Number)corrmistr.getAttribute("Caseyear");
            String cpname = (String)corrmistr.getAttribute("Prosecutionname");
            String crcase = (String)corrmistr.getAttribute("Subject");
            int sid = Integer.parseInt(key);
            BigDecimal caseno = new BigDecimal(cno.toString());
            BigDecimal name = new BigDecimal(cpname.toString());
            BigDecimal year = new BigDecimal(cyear.toString());
            String res = this.validatingCase(sid, caseno, name, year);
            if (res.equals("ok")) {
                Row casinfr = caseinfovo.createRow();
                Row reqr = reqview.createRow();
                casinfr.setAttribute("CaseNumber",
                                     corrmistr.getAttribute("Caseno"));
                casinfr.setAttribute("CaseYear",
                                     corrmistr.getAttribute("Caseyear"));
                casinfr.setAttribute("CaseType",
                                     corrmistr.getAttribute("Prosecutionname"));
                casinfr.setAttribute("Relation",
                                     corrmistr.getAttribute("Relationwithcase"));
                reqr.setAttribute("ReqName", setServiceNames(locale, key));
                reqr.setAttribute("CaseInfoId",
                                  casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ServiceId", sid);
                corrmistr.setAttribute("CaseInfo",
                                       casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ProsecId",
                                  corrmistr.getAttribute("Prosecutionname"));
                //                uploadfile_appeal();
                //                commit_action();
                //                sentEmail((Number)casinfr.getAttribute("CaseId"), "Appeal");
                //                return "Y";
                java.util.List<UploadedFile> file_u = this.getUploadedfile();
                if (file_u != null) {
                    String validateFile = validateFileUpload(file_u);
                    if (validateFile.equals("N")) {
                        for (int i = 0; i < file_u.size(); i++) {
                            Number foldern =
                                (Number)reqr.getAttribute("ReqId");
                            String foldername = foldern.toString();
                            if (i == 0) {
                                ubean.createFolder(foldername);
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadfile_appeal(file_u.get(i),
                                                  ubean.getDid());
                            } else {
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadfile_appeal(file_u.get(i),
                                                  ubean.getDid());
                            }
                        }
                    } else {
                        casinfr.remove();
                        reqr.remove();
                        s = "N";
                        FacesContext.getCurrentInstance().addMessage(upFileBind.getClientId(FacesContext.getCurrentInstance()),
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                      "File Type extension are not allowed",
                                                                                      "Kindly reload the files"));
                    }
                }
                if (s.equals("Y")) {
                    commit_action();
                    sentEmail((Number)reqr.getAttribute("ReqId"),
                              setServiceNames(locale, key), locale);
                    afu.setEL("#{pageFlowScope.casno}",
                              reqr.getAttribute("ReqId"));
                    oracle.jbo.domain.Number csid =
                        (Number)reqr.getAttribute("ReqId");
                    executeSMSproc((String)ADFContext.getCurrent().getSessionScope().get("mobile"),
                                   csid);
                    return "Y";
                }
            } else {
                return "N";
            }
        }
        if (corrmistr.getAttribute("Caseno") == null) {
            this.setCn("Y");
        }
        if (corrmistr.getAttribute("Caseyear") == null) {
            this.setCy("Y");
        }
        if ((corrmistr.getAttribute("Prosecutionname") == null) ||
            (corrmistr.getAttribute("Prosecutionname").equals("LOV_pn_en")) ||
            (corrmistr.getAttribute("Prosecutionname").equals("LOV_pn_ar"))) {
            this.setPc("Y");
        }
        if ((corrmistr.getAttribute("Relationwithcase") == null) ||
            (corrmistr.getAttribute("Relationwithcase").equals("LOV_Relationcase_en")) ||
            (corrmistr.getAttribute("Relationwithcase").equals("LOV_Relationcase_ar"))) {
            this.setRc("Y");
        }
        if (corrmistr.getAttribute("Subject") == null) {
            sub = "Y";
        }
        return null;
    }

    public String fine_retreive_req_action() {
        String key = (String)afu.evaluateEL("#{pageFlowScope.key}");
        Locale localel = (Locale)afu.evaluateEL("#{pageFlowScope.locale}");
        String locale = localel.toString();
        String s = "Y";
        ViewObject caseinfovo = getAm().findViewObject("ReqCaseInfoView1");
        ViewObject reqview = getAm().findViewObject("ReqRequestsView9");
        ViewObject corrmistvo =
            getAm().findViewObject("ReqFineRetreivalRequestView1");
        Row corrmistr = corrmistvo.getCurrentRow();
        if (corrmistr.getAttribute("CaseNo") != null &&
            corrmistr.getAttribute("CaseYear") != null &&
            corrmistr.getAttribute("ProsecutionName") != null &&
            corrmistr.getAttribute("RelationCase") != null &&
            (!corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_en")) &&
            (!corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_en"))) {
            Number cno = (Number)corrmistr.getAttribute("CaseNo");
            Number cyear = (Number)corrmistr.getAttribute("CaseYear");
            String cpname = (String)corrmistr.getAttribute("ProsecutionName");
            int sid = Integer.parseInt(key);
            BigDecimal caseno = new BigDecimal(cno.toString());
            BigDecimal name = new BigDecimal(cpname.toString());
            BigDecimal year = new BigDecimal(cyear.toString());
            String res = this.validatingCase(sid, caseno, name, year);
            if (res.equals("ok")) {
                Row casinfr = caseinfovo.createRow();
                Row reqr = reqview.createRow();
                casinfr.setAttribute("CaseNumber",
                                     corrmistr.getAttribute("CaseNo"));
                casinfr.setAttribute("CaseYear",
                                     corrmistr.getAttribute("CaseYear"));
                casinfr.setAttribute("CaseType",
                                     corrmistr.getAttribute("ProsecutionName"));
                casinfr.setAttribute("Relation",
                                     corrmistr.getAttribute("RelationCase"));
                reqr.setAttribute("ReqName", setServiceNames(locale, key));
                reqr.setAttribute("CaseInfoId",
                                  casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ServiceId", sid);
                corrmistr.setAttribute("CaseInfo",
                                       casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ProsecId",
                                  corrmistr.getAttribute("ProsecutionName"));
                //                uploadedFile_fienretreq();
                //                commit_action();
                //                sentEmail((Number)casinfr.getAttribute("CaseId"),
                //                          "Fine Retreival request");
                //                return "Y";
                java.util.List<UploadedFile> file_u = this.getUploadedfile();
                if (file_u != null) {
                    String validateFile = validateFileUpload(file_u);
                    if (validateFile.equals("N")) {
                        for (int i = 0; i < file_u.size(); i++) {
                            Number foldern =
                                (Number)reqr.getAttribute("ReqId");
                            String foldername = foldern.toString();
                            if (i == 0) {
                                ubean.createFolder(foldername);
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadedFile_fienretreq(file_u.get(i),
                                                        ubean.getDid());
                            } else {
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadedFile_fienretreq(file_u.get(i),
                                                        ubean.getDid());
                            }
                        }
                    } else {
                        casinfr.remove();
                        reqr.remove();
                        s = "N";
                        FacesContext.getCurrentInstance().addMessage(upFileBind.getClientId(FacesContext.getCurrentInstance()),
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                      "File Type extension are not allowed",
                                                                                      "Kindly reload the files"));
                    }
                }
                if (s.equals("Y")) {
                    commit_action();
                    sentEmail((Number)reqr.getAttribute("ReqId"),
                              setServiceNames(locale, key), locale);
                    afu.setEL("#{pageFlowScope.casno}",
                              reqr.getAttribute("ReqId"));
                    oracle.jbo.domain.Number csid =
                        (Number)reqr.getAttribute("ReqId");
                    executeSMSproc((String)ADFContext.getCurrent().getSessionScope().get("mobile"),
                                   csid);
                    return "Y";
                }
            } else {
                return "N";
            }

        }
        if (corrmistr.getAttribute("CaseNo") == null) {
            this.setCn("Y");
        }
        if (corrmistr.getAttribute("CaseYear") == null) {
            this.setCy("Y");
        }
        if ((corrmistr.getAttribute("ProsecutionName") == null) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_en")) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_ar"))) {
            this.setPc("Y");
        }
        if ((corrmistr.getAttribute("RelationCase") == null) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_en")) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_ar"))) {
            this.setRc("Y");
        }
        return null;
    }

    public String lawyer_profile_req_action() {
        String key = (String)afu.evaluateEL("#{pageFlowScope.key}");
        Locale localel = (Locale)afu.evaluateEL("#{pageFlowScope.locale}");
        String locale = localel.toString();
        String s = "Y";
        ViewObject caseinfovo = getAm().findViewObject("ReqCaseInfoView1");
        ViewObject reqview = getAm().findViewObject("ReqRequestsView10");
        ViewObject corrmistvo =
            getAm().findViewObject("ReqLawyerProfileReqView1");
        Row corrmistr = corrmistvo.getCurrentRow();
        if (corrmistr.getAttribute("CaseNo") != null &&
            corrmistr.getAttribute("CaseYear") != null &&
            corrmistr.getAttribute("ProsecutionName") != null &&
            corrmistr.getAttribute("RelationCase") != null &&
            corrmistr.getAttribute("ContractNumber") != null &&
            corrmistr.getAttribute("DefendentName") != null) {
            Number cno = (Number)corrmistr.getAttribute("CaseNo");
            Number cyear = (Number)corrmistr.getAttribute("CaseYear");
            String cpname = (String)corrmistr.getAttribute("ProsecutionName");
            int sid = Integer.parseInt(key);
            BigDecimal caseno = new BigDecimal(cno.toString());
            BigDecimal name = new BigDecimal(cpname.toString());
            BigDecimal year = new BigDecimal(cyear.toString());
            String res = this.validatingCase(sid, caseno, name, year);
            if (res.equals("ok")) {
                Row casinfr = caseinfovo.createRow();
                Row reqr = reqview.createRow();
                casinfr.setAttribute("CaseNumber",
                                     corrmistr.getAttribute("CaseNo"));
                casinfr.setAttribute("CaseYear",
                                     corrmistr.getAttribute("CaseYear"));
                casinfr.setAttribute("CaseType",
                                     corrmistr.getAttribute("ProsecutionName"));
                casinfr.setAttribute("Relation",
                                     corrmistr.getAttribute("RelationCase"));
                reqr.setAttribute("ReqName", setServiceNames(locale, key));
                reqr.setAttribute("CaseInfoId",
                                  casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ServiceId", sid);
                corrmistr.setAttribute("CaseInfo",
                                       casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ProsecId",
                                  corrmistr.getAttribute("ProsecutionName"));
                //                uploadFile_Lawyerprf();
                //                commit_action();
                //                sentEmail((Number)casinfr.getAttribute("CaseId"),
                //                          "Lawyer Profile");
                //                return "Y";
                java.util.List<UploadedFile> file_u = this.getUploadedfile();
                if (file_u != null) {
                    String validateFile = validateFileUpload(file_u);
                    if (validateFile.equals("N")) {
                        for (int i = 0; i < file_u.size(); i++) {
                            Number foldern =
                                (Number)reqr.getAttribute("ReqId");
                            String foldername = foldern.toString();
                            if (i == 0) {
                                ubean.createFolder(foldername);
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadFile_Lawyerprf(file_u.get(i),
                                                     ubean.getDid());
                            } else {
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadFile_Lawyerprf(file_u.get(i),
                                                     ubean.getDid());
                            }
                        }
                    } else {
                        casinfr.remove();
                        reqr.remove();
                        s = "N";
                        FacesContext.getCurrentInstance().addMessage(upFileBind.getClientId(FacesContext.getCurrentInstance()),
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                      "File Type extension are not allowed",
                                                                                      "Kindly reload the files"));
                    }
                }
                if (s.equals("Y")) {
                    commit_action();
                    sentEmail((Number)reqr.getAttribute("ReqId"),
                              setServiceNames(locale, key), locale);
                    afu.setEL("#{pageFlowScope.casno}",
                              reqr.getAttribute("ReqId"));
                    oracle.jbo.domain.Number csid =
                        (Number)reqr.getAttribute("ReqId");
                    executeSMSproc((String)ADFContext.getCurrent().getSessionScope().get("mobile"),
                                   csid);
                    return "Y";
                }
            } else {
                return "N";
            }
        }
        if (corrmistr.getAttribute("CaseNo") == null) {
            this.setCn("Y");
        }
        if (corrmistr.getAttribute("CaseYear") == null) {
            this.setCy("Y");
        }
        if ((corrmistr.getAttribute("ProsecutionName") == null) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_en")) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_ar"))) {
            this.setPc("Y");
        }
        if ((corrmistr.getAttribute("RelationCase") == null) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_en")) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_ar"))) {
            this.setRc("Y");
        }
        if (corrmistr.getAttribute("ContractNumber") == null) {
            this.setCn("Y");
        }
        if (corrmistr.getAttribute("DefendentName") == null) {
            this.setDm("Y");
        }
        return null;
    }

    /**
     *Fired while  submitting the document in Exchange_Bail
     * @return
     */
    public String Exe_Bill_action() {
        String key = (String)afu.evaluateEL("#{pageFlowScope.key}");
        Locale localel = (Locale)afu.evaluateEL("#{pageFlowScope.locale}");
        String locale = localel.toString();
        String s = "Y";
        ViewObject caseinfovo = getAm().findViewObject("ReqCaseInfoView1");
        ViewObject reqview = getAm().findViewObject("ReqRequestsView16");
        ViewObject corrmistvo = getAm().findViewObject("ReqExcBillView1");
        Row corrmistr = corrmistvo.getCurrentRow();
        if (corrmistr.getAttribute("CaseNo") != null &&
            corrmistr.getAttribute("CaseYear") != null &&
            corrmistr.getAttribute("ProsecutionName") != null &&
            corrmistr.getAttribute("RelationCase") != null &&
            corrmistr.getAttribute("AccusedName") != null) {
            Number cno = (Number)corrmistr.getAttribute("CaseNo");
            Number cyear = (Number)corrmistr.getAttribute("CaseYear");
            String cpname = (String)corrmistr.getAttribute("ProsecutionName");
            int sid = Integer.parseInt(key);
            BigDecimal caseno = new BigDecimal(cno.toString());
            BigDecimal name = new BigDecimal(cpname.toString());
            BigDecimal year = new BigDecimal(cyear.toString());
            String res = this.validatingCase(sid, caseno, name, year);
            if (res.equals("ok")) {
                Row casinfr = caseinfovo.createRow();
                Row reqr = reqview.createRow();
                casinfr.setAttribute("CaseNumber",
                                     corrmistr.getAttribute("CaseNo"));
                casinfr.setAttribute("CaseYear",
                                     corrmistr.getAttribute("CaseYear"));
                casinfr.setAttribute("CaseType",
                                     corrmistr.getAttribute("ProsecutionName"));
                casinfr.setAttribute("Relation",
                                     corrmistr.getAttribute("RelationCase"));
                reqr.setAttribute("ReqName", setServiceNames(locale, key));
                reqr.setAttribute("CaseInfoId",
                                  casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ServiceId", sid);
                corrmistr.setAttribute("CaseInfo",
                                       casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ProsecId",
                                  corrmistr.getAttribute("ProsecutionName"));
                //                uploadFile_excbail();
                //                commit_action();
                //                sentEmail((Number)casinfr.getAttribute("CaseId"),
                //                          "Exchange of Bill");
                //                return "Y";
                java.util.List<UploadedFile> file_u = this.getUploadedfile();
                if (file_u != null) {
                    String validateFile = validateFileUpload(file_u);
                    if (validateFile.equals("N")) {
                        for (int i = 0; i < file_u.size(); i++) {
                            Number foldern =
                                (Number)reqr.getAttribute("ReqId");
                            String foldername = foldern.toString();
                            if (i == 0) {
                                ubean.createFolder(foldername);
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadFile_excbail(file_u.get(i),
                                                   ubean.getDid());
                            } else {
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadFile_excbail(file_u.get(i),
                                                   ubean.getDid());
                            }
                        }
                    } else {
                        casinfr.remove();
                        reqr.remove();
                        s = "N";
                        FacesContext.getCurrentInstance().addMessage(upFileBind.getClientId(FacesContext.getCurrentInstance()),
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                      "File Type extension are not allowed",
                                                                                      "Kindly reload the files"));
                    }
                }
                if (s.equals("Y")) {
                    commit_action();
                    sentEmail((Number)reqr.getAttribute("ReqId"),
                              setServiceNames(locale, key), locale);
                    afu.setEL("#{pageFlowScope.casno}",
                              reqr.getAttribute("ReqId"));
                    oracle.jbo.domain.Number csid =
                        (Number)reqr.getAttribute("ReqId");
                    executeSMSproc((String)ADFContext.getCurrent().getSessionScope().get("mobile"),
                                   csid);
                    return "Y";
                }
            } else {
                return "N";
            }
        }
        if (corrmistr.getAttribute("CaseNo") == null) {
            this.setCn("Y");
        }
        if (corrmistr.getAttribute("CaseYear") == null) {
            this.setCy("Y");
        }
        if ((corrmistr.getAttribute("ProsecutionName") == null) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_en")) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_ar"))) {
            this.setPc("Y");
        }
        if ((corrmistr.getAttribute("RelationCase") == null) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_en")) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_ar"))) {
            this.setRc("Y");
        }
        if (corrmistr.getAttribute("AccusedName") == null) {
            this.setAn("Y");
        }
        return null;
    }

    /**
     *Fired while  submitting in Referral  of inmate
     * @return
     */
    public String Ref_inm_action() {
        String key = (String)afu.evaluateEL("#{pageFlowScope.key}");
        Locale localel = (Locale)afu.evaluateEL("#{pageFlowScope.locale}");
        String locale = localel.toString();
        String s = "Y";
        ViewObject caseinfovo = getAm().findViewObject("ReqCaseInfoView1");
        ViewObject reqview = getAm().findViewObject("ReqRequestsView17");
        ViewObject corrmistvo =
            getAm().findViewObject("ReqReferralInmateView1");
        Row corrmistr = corrmistvo.getCurrentRow();
        if (corrmistr.getAttribute("CaseNo") != null &&
            corrmistr.getAttribute("CaseYear") != null &&
            corrmistr.getAttribute("ProsecutionName") != null &&
            corrmistr.getAttribute("Relationcase") != null &&
            corrmistr.getAttribute("Requestreason") != null &&
            corrmistr.getAttribute("Prisonername") != null &&
            (!corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_en")) &&
            (!corrmistr.getAttribute("Relationcase").equals("LOV_RelationCase_en"))) {
            Number cno = (Number)corrmistr.getAttribute("CaseNo");
            Number cyear = (Number)corrmistr.getAttribute("CaseYear");
            String cpname = (String)corrmistr.getAttribute("ProsecutionName");
            int sid = Integer.parseInt(key);
            BigDecimal caseno = new BigDecimal(cno.toString());
            BigDecimal name = new BigDecimal(cpname.toString());
            BigDecimal year = new BigDecimal(cyear.toString());
            String res = this.validatingCase(sid, caseno, name, year);

            if (res.equals("ok")) {
                Row casinfr = caseinfovo.createRow();
                Row reqr = reqview.createRow();
                casinfr.setAttribute("CaseNumber",
                                     corrmistr.getAttribute("CaseNo"));
                casinfr.setAttribute("CaseYear",
                                     corrmistr.getAttribute("CaseYear"));
                casinfr.setAttribute("CaseType",
                                     corrmistr.getAttribute("ProsecutionName"));
                casinfr.setAttribute("Relation",
                                     corrmistr.getAttribute("Relationcase"));
                reqr.setAttribute("ReqName", setServiceNames(locale, key));
                reqr.setAttribute("CaseInfoId",
                                  casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ServiceId", sid);
                corrmistr.setAttribute("CaseInfo",
                                       casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ProsecId",
                                  corrmistr.getAttribute("ProsecutionName"));
                //                uploadedFile_refinm();
                //                commit_action();
                //                sentEmail((Number)casinfr.getAttribute("CaseId"),
                //                          "Referral of Inmate");
                //                return "Y";
                java.util.List<UploadedFile> file_u = this.getUploadedfile();
                if (file_u != null) {
                    String validateFile = validateFileUpload(file_u);
                    if (validateFile.equals("N")) {
                        for (int i = 0; i < file_u.size(); i++) {
                            Number foldern =
                                (Number)reqr.getAttribute("ReqId");
                            String foldername = foldern.toString();
                            if (i == 0) {
                                ubean.createFolder(foldername);
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadedFile_refinm(file_u.get(i),
                                                    ubean.getDid());
                            } else {
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadedFile_refinm(file_u.get(i),
                                                    ubean.getDid());
                            }
                        }
                    } else {
                        casinfr.remove();
                        reqr.remove();
                        s = "N";
                        FacesContext.getCurrentInstance().addMessage(upFileBind.getClientId(FacesContext.getCurrentInstance()),
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                      "File Type extension are not allowed",
                                                                                      "Kindly reload the files"));
                    }
                }
                if (s.equals("Y")) {
                    commit_action();
                    sentEmail((Number)reqr.getAttribute("ReqId"),
                              setServiceNames(locale, key), locale);
                    afu.setEL("#{pageFlowScope.casno}",
                              reqr.getAttribute("ReqId"));
                    oracle.jbo.domain.Number csid =
                        (Number)reqr.getAttribute("ReqId");
                    executeSMSproc((String)ADFContext.getCurrent().getSessionScope().get("mobile"),
                                   csid);
                    return "Y";
                }
            } else {
                return "N";
            }
        }
        if (corrmistr.getAttribute("CaseNo") == null) {
            this.setCn("Y");
        }
        if (corrmistr.getAttribute("CaseYear") == null) {
            this.setCy("Y");
        }
        if ((corrmistr.getAttribute("ProsecutionName") == null) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_en")) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_ar"))) {
            this.setPc("Y");
        }
        if ((corrmistr.getAttribute("Relationcase") == null) ||
            (corrmistr.getAttribute("Relationcase").equals("LOV_RelationCase_en")) ||
            (corrmistr.getAttribute("Relationcase").equals("LOV_RelationCase_ar"))) {
            this.setRc("Y");
        }
        if (corrmistr.getAttribute("Prisonername") == null) {
            this.setPrn("Y");
        }
        if (corrmistr.getAttribute("Requestreason") == null) {
            this.setRr("Y");
        }
        return null;
    }

    /**
     * Fired while submitting the document in Collecting documents
     * @return
     */
    public String collect_doc_action() {
        String key = (String)afu.evaluateEL("#{pageFlowScope.key}");
        Locale localel = (Locale)afu.evaluateEL("#{pageFlowScope.locale}");
        String locale = localel.toString();
        String s = "Y";
        ViewObject caseinfovo = getAm().findViewObject("ReqCaseInfoView1");
        ViewObject reqview = getAm().findViewObject("ReqRequestsView11");
        ViewObject corrmistvo = getAm().findViewObject("ReqCollectDocView1");
        Row corrmistr = corrmistvo.getCurrentRow();
        if (corrmistr.getAttribute("CaseNo") != null &&
            corrmistr.getAttribute("CaseYear") != null &&
            corrmistr.getAttribute("ProsecutionName") != null &&
            corrmistr.getAttribute("RelationCase") != null) {
            Number cno = (Number)corrmistr.getAttribute("CaseNo");
            Number cyear = (Number)corrmistr.getAttribute("CaseYear");
            String cpname = (String)corrmistr.getAttribute("ProsecutionName");
            int sid = Integer.parseInt(key);
            BigDecimal caseno = new BigDecimal(cno.toString());
            BigDecimal name = new BigDecimal(cpname.toString());
            BigDecimal year = new BigDecimal(cyear.toString());
            String res = this.validatingCase(sid, caseno, name, year);
            if (res.equals("ok")) {
                Row casinfr = caseinfovo.createRow();
                Row reqr = reqview.createRow();
                casinfr.setAttribute("CaseNumber",
                                     corrmistr.getAttribute("CaseNo"));
                casinfr.setAttribute("CaseYear",
                                     corrmistr.getAttribute("CaseYear"));
                casinfr.setAttribute("CaseType",
                                     corrmistr.getAttribute("ProsecutionName"));
                casinfr.setAttribute("Relation",
                                     corrmistr.getAttribute("RelationCase"));
                reqr.setAttribute("ReqName", setServiceNames(locale, key));
                reqr.setAttribute("CaseInfoId",
                                  casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ServiceId", sid);
                corrmistr.setAttribute("CaseInfo",
                                       casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ProsecId",
                                  corrmistr.getAttribute("ProsecutionName"));
                //                UploadFile_col_doc();
                //                commit_action();
                //                sentEmail((Number)casinfr.getAttribute("CaseId"),
                //                          "Collecting Documents");
                //                return "Y";
                java.util.List<UploadedFile> file_u = this.getUploadedfile();
                if (file_u != null) {
                    String validateFile = validateFileUpload(file_u);
                    if (validateFile.equals("N")) {
                        for (int i = 0; i < file_u.size(); i++) {
                            Number foldern =
                                (Number)reqr.getAttribute("ReqId");
                            String foldername = foldern.toString();
                            if (i == 0) {
                                ubean.createFolder(foldername);
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                UploadFile_col_doc(file_u.get(i),
                                                   ubean.getDid());
                            } else {
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                UploadFile_col_doc(file_u.get(i),
                                                   ubean.getDid());
                            }
                        }
                    } else {
                        casinfr.remove();
                        reqr.remove();
                        s = "N";
                        FacesContext.getCurrentInstance().addMessage(upFileBind.getClientId(FacesContext.getCurrentInstance()),
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                      "File Type extension are not allowed",
                                                                                      "Kindly reload the files"));
                    }
                }
                if (s.equals("Y")) {
                    commit_action();
                    sentEmail((Number)reqr.getAttribute("ReqId"),
                              setServiceNames(locale, key), locale);
                    afu.setEL("#{pageFlowScope.casno}",
                              reqr.getAttribute("ReqId"));
                    oracle.jbo.domain.Number csid =
                        (Number)reqr.getAttribute("ReqId");
                    executeSMSproc((String)ADFContext.getCurrent().getSessionScope().get("mobile"),
                                   csid);
                    return "Y";
                }
            } else {
                return "N";
            }
        }
        if (corrmistr.getAttribute("CaseNo") == null) {
            this.setCn("Y");
        }
        if (corrmistr.getAttribute("CaseYear") == null) {
            this.setCy("Y");
        }
        if ((corrmistr.getAttribute("ProsecutionName") == null) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_en")) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_ar"))) {
            this.setPc("Y");
        }
        if ((corrmistr.getAttribute("RelationCase") == null) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_en")) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_ar"))) {
            this.setRc("Y");
        }
        return null;
    }

    public String pay_fine_imp_court_action() {
        String s = "Y";
        String key = (String)afu.evaluateEL("#{pageFlowScope.key}");
        Locale localel = (Locale)afu.evaluateEL("#{pageFlowScope.locale}");
        String locale = localel.toString();
        ViewObject caseinfovo = getAm().findViewObject("ReqCaseInfoView1");
        ViewObject reqview = getAm().findViewObject("ReqRequestsView12");
        ViewObject corrmistvo =
            getAm().findViewObject("ReqPayFineImpcourtView1");
        Row corrmistr = corrmistvo.getCurrentRow();
        if (corrmistr.getAttribute("CaseNo") != null &&
            corrmistr.getAttribute("CaseYear") != null &&
            corrmistr.getAttribute("ProsecutionName") != null &&
            corrmistr.getAttribute("RelationCase") != null &&
            (!corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_en")) &&
            (!corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_en"))) {
            Number cno = (Number)corrmistr.getAttribute("CaseNo");
            Number cyear = (Number)corrmistr.getAttribute("CaseYear");
            String cpname = (String)corrmistr.getAttribute("ProsecutionName");
            int sid = 19;
            BigDecimal caseno = new BigDecimal(cno.toString());
            BigDecimal name = new BigDecimal(cpname.toString());
            BigDecimal year = new BigDecimal(cyear.toString());
            String res = this.validatingCase(sid, caseno, name, year);
            if (res.equals("ok")) {
                Row casinfr = caseinfovo.createRow();
                Row reqr = reqview.createRow();
                casinfr.setAttribute("CaseNumber",
                                     corrmistr.getAttribute("CaseNo"));
                casinfr.setAttribute("CaseYear",
                                     corrmistr.getAttribute("CaseYear"));
                casinfr.setAttribute("CaseType",
                                     corrmistr.getAttribute("ProsecutionName"));
                casinfr.setAttribute("Relation",
                                     corrmistr.getAttribute("RelationCase"));
                reqr.setAttribute("ReqName", "Paying fine imposed by court");
                reqr.setAttribute("CaseInfoId",
                                  casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ServiceId", 19);
                corrmistr.setAttribute("CaseInfo",
                                       casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ProsecId",
                                  corrmistr.getAttribute("ProsecutionName"));
                //                uploadFile_payfineimp();
                //                commit_action();
                //                sentEmail((Number)casinfr.getAttribute("CaseId"),
                //                          "Paying fine imposed by court");
                //                return "Y";
                java.util.List<UploadedFile> file_u = this.getUploadedfile();
                if (file_u != null) {
                    String validateFile = validateFileUpload(file_u);
                    if (validateFile.equals("N")) {
                        for (int i = 0; i < file_u.size(); i++) {
                            Number foldern =
                                (Number)reqr.getAttribute("ReqId");
                            String foldername = foldern.toString();
                            if (i == 0) {
                                ubean.createFolder(foldername);
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadFile_payfineimp(file_u.get(i),
                                                      ubean.getDid());
                            } else {
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadFile_payfineimp(file_u.get(i),
                                                      ubean.getDid());
                            }
                        }
                    } else {
                        casinfr.remove();
                        reqr.remove();
                        s = "N";
                        FacesContext.getCurrentInstance().addMessage(upFileBind.getClientId(FacesContext.getCurrentInstance()),
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                      "File Type extension are not allowed",
                                                                                      "Kindly reload the files"));
                    }
                }
                if (s.equals("Y")) {
                    commit_action();
                    sentEmail((Number)reqr.getAttribute("ReqId"),
                              setServiceNames(locale, key), locale);
                    afu.setEL("#{pageFlowScope.casno}",
                              reqr.getAttribute("ReqId"));
                    oracle.jbo.domain.Number csid =
                        (Number)reqr.getAttribute("ReqId");
                    executeSMSproc((String)ADFContext.getCurrent().getSessionScope().get("mobile"),
                                   csid);
                    return "Y";
                }
            } else {
                return "N";
            }
        }
        if (corrmistr.getAttribute("CaseNo") == null) {
            this.setCn("Y");
        }
        if (corrmistr.getAttribute("CaseYear") == null) {
            this.setCy("Y");
        }
        if ((corrmistr.getAttribute("ProsecutionName") == null) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_en")) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_ar"))) {
            this.setPc("Y");
        }
        if ((corrmistr.getAttribute("RelationCase") == null) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_en")) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_ar"))) {
            this.setRc("Y");
        }
        return null;
    }

    public String pay_lawyer_fee_action() {
        String key = (String)afu.evaluateEL("#{pageFlowScope.key}");
        Locale localel = (Locale)afu.evaluateEL("#{pageFlowScope.locale}");
        String locale = localel.toString();
        String s = "Y";
        ViewObject caseinfovo = getAm().findViewObject("ReqCaseInfoView1");
        ViewObject reqview = getAm().findViewObject("ReqRequestsView13");
        ViewObject corrmistvo = getAm().findViewObject("ReqPayLawyerFeeView1");
        Row corrmistr = corrmistvo.getCurrentRow();
        if (corrmistr.getAttribute("CaseNo") != null &&
            corrmistr.getAttribute("CaseYear") != null &&
            corrmistr.getAttribute("ProsecutionName") != null &&
            corrmistr.getAttribute("RelationCase") != null &&
            corrmistr.getAttribute("LbanNumber") != null &&
            (!corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_en")) &&
            (!corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_en"))) {
            String cno = (String)corrmistr.getAttribute("CaseNo");
            String cyear = (String)corrmistr.getAttribute("CaseYear");
            String cpname = (String)corrmistr.getAttribute("ProsecutionName");
            int sid = 17;
            BigDecimal caseno = new BigDecimal(cno.toString());
            BigDecimal name = new BigDecimal(cpname.toString());
            BigDecimal year = new BigDecimal(cyear.toString());
            String res = this.validatingCase(sid, caseno, name, year);
            if (res.equals("ok")) {
                Row casinfr = caseinfovo.createRow();
                Row reqr = reqview.createRow();
                casinfr.setAttribute("CaseNumber",
                                     corrmistr.getAttribute("CaseNo"));
                casinfr.setAttribute("CaseYear",
                                     corrmistr.getAttribute("CaseYear"));
                casinfr.setAttribute("CaseType",
                                     corrmistr.getAttribute("ProsecutionName"));
                casinfr.setAttribute("Relation",
                                     corrmistr.getAttribute("RelationCase"));
                reqr.setAttribute("ReqName", "Payment of Lawyers Fee");
                reqr.setAttribute("CaseInfoId",
                                  casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ServiceId", 17);
                corrmistr.setAttribute("CaseInfo",
                                       casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ProsecId",
                                  corrmistr.getAttribute("ProsecutionName"));
                //                uploadFile_paylawfee();
                //                commit_action();
                //                sentEmail((Number)casinfr.getAttribute("CaseId"),
                //                          "Payment of Lawyers Fee");
                //                return "Y";
                java.util.List<UploadedFile> file_u = this.getUploadedfile();
                if (file_u != null) {
                    String validateFile = validateFileUpload(file_u);
                    if (validateFile.equals("N")) {
                        for (int i = 0; i < file_u.size(); i++) {
                            Number foldern =
                                (Number)reqr.getAttribute("ReqId");
                            String foldername = foldern.toString();
                            if (i == 0) {
                                ubean.createFolder(foldername);
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadFile_paylawfee(file_u.get(i),
                                                     ubean.getDid());
                            } else {
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadFile_paylawfee(file_u.get(i),
                                                     ubean.getDid());
                            }
                        }
                    } else {
                        casinfr.remove();
                        reqr.remove();
                        s = "N";
                        FacesContext.getCurrentInstance().addMessage(upFileBind.getClientId(FacesContext.getCurrentInstance()),
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                      "File Type extension are not allowed",
                                                                                      "Kindly reload the files"));
                    }
                }
                if (s.equals("Y")) {
                    commit_action();
                    sentEmail((Number)reqr.getAttribute("ReqId"),
                              setServiceNames(locale, key), locale);
                    afu.setEL("#{pageFlowScope.casno}",
                              reqr.getAttribute("ReqId"));
                    oracle.jbo.domain.Number csid =
                        (Number)reqr.getAttribute("ReqId");
                    executeSMSproc((String)ADFContext.getCurrent().getSessionScope().get("mobile"),
                                   csid);
                    return "Y";
                }
            } else {
                return "N";
            }
        }
        if (corrmistr.getAttribute("CaseNo") == null) {
            this.setCn("Y");
        }
        if (corrmistr.getAttribute("CaseYear") == null) {
            this.setCy("Y");
        }
        if ((corrmistr.getAttribute("ProsecutionName") == null) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_en")) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_ar"))) {
            this.setPc("Y");
        }
        if ((corrmistr.getAttribute("RelationCase") == null) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_en")) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_ar"))) {
            this.setRc("Y");
        }
        if ((corrmistr.getAttribute("RelationCase") == null) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_en")) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_ar"))) {
            this.setRc("Y");
        }
        if (corrmistr.getAttribute("LbanNumber") == null) {
            this.setLn("Y");
        }
        return null;
    }

    public String prov_fin_per_bail_fee_action() {
        String key = (String)afu.evaluateEL("#{pageFlowScope.key}");
        Locale localel = (Locale)afu.evaluateEL("#{pageFlowScope.locale}");
        String locale = localel.toString();
        String s = "Y";
        ViewObject caseinfovo = getAm().findViewObject("ReqCaseInfoView1");
        ViewObject reqview = getAm().findViewObject("ReqRequestsView14");
        ViewObject corrmistvo =
            getAm().findViewObject("ReqProFinPerBailView1");
        Row corrmistr = corrmistvo.getCurrentRow();
        if (corrmistr.getAttribute("CaseNo") != null &&
            corrmistr.getAttribute("CaseYear") != null &&
            corrmistr.getAttribute("ProsecutionName") != null &&
            corrmistr.getAttribute("RelationCase") != null &&
            corrmistr.getAttribute("AccusedName") != null) {
            Number cno = (Number)corrmistr.getAttribute("CaseNo");
            Number cyear = (Number)corrmistr.getAttribute("CaseYear");
            String cpname = (String)corrmistr.getAttribute("ProsecutionName");
            int sid = Integer.parseInt(key);
            BigDecimal caseno = new BigDecimal(cno.toString());
            BigDecimal name = new BigDecimal(cpname.toString());
            BigDecimal year = new BigDecimal(cyear.toString());
            String res = this.validatingCase(sid, caseno, name, year);
            if (res.equals("ok")) {
                Row casinfr = caseinfovo.createRow();
                Row reqr = reqview.createRow();
                casinfr.setAttribute("CaseNumber",
                                     corrmistr.getAttribute("CaseNo"));
                casinfr.setAttribute("CaseYear",
                                     corrmistr.getAttribute("CaseYear"));
                casinfr.setAttribute("CaseType",
                                     corrmistr.getAttribute("ProsecutionName"));
                casinfr.setAttribute("Relation",
                                     corrmistr.getAttribute("RelationCase"));
                reqr.setAttribute("ReqName", setServiceNames(locale, key));
                reqr.setAttribute("CaseInfoId",
                                  casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ServiceId", sid);
                corrmistr.setAttribute("CaseInfo",
                                       casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ProsecId",
                                  corrmistr.getAttribute("ProsecutionName"));
                //                uploadedfile_fineperbail();
                //                commit_action();
                //                sentEmail((Number)casinfr.getAttribute("CaseId"),
                //                          "Provide Financial/Personal Bail");
                //                return "Y";
                java.util.List<UploadedFile> file_u = this.getUploadedfile();
                if (file_u != null) {
                    String validateFile = validateFileUpload(file_u);
                    if (validateFile.equals("N")) {
                        for (int i = 0; i < file_u.size(); i++) {
                            Number foldern =
                                (Number)reqr.getAttribute("ReqId");
                            String foldername = foldern.toString();
                            if (i == 0) {
                                ubean.createFolder(foldername);
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadedfile_fineperbail(file_u.get(i),
                                                         ubean.getDid());
                            } else {
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadedfile_fineperbail(file_u.get(i),
                                                         ubean.getDid());
                            }
                        }
                    } else {
                        casinfr.remove();
                        reqr.remove();
                        s = "N";
                        FacesContext.getCurrentInstance().addMessage(upFileBind.getClientId(FacesContext.getCurrentInstance()),
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                      "File Type extension are not allowed",
                                                                                      "Kindly reload the files"));
                    }
                }
                if (s.equals("Y")) {
                    commit_action();
                    sentEmail((Number)reqr.getAttribute("ReqId"),
                              setServiceNames(locale, key), locale);
                    afu.setEL("#{pageFlowScope.casno}",
                              reqr.getAttribute("ReqId"));
                    oracle.jbo.domain.Number csid =
                        (Number)reqr.getAttribute("ReqId");
                    executeSMSproc((String)ADFContext.getCurrent().getSessionScope().get("mobile"),
                                   csid);
                    return "Y";
                }
            }
            if (res.equals("N")) {
                return "N";
            }
        }
        if (corrmistr.getAttribute("CaseNo") == null) {
            this.setCn("Y");
        }
        if (corrmistr.getAttribute("CaseYear") == null) {
            this.setCy("Y");
        }
        if (corrmistr.getAttribute("AccusedName") == null) {
            this.setAn("Y");
        }
        if ((corrmistr.getAttribute("ProsecutionName") == null) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_en")) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_ar"))) {
            this.setPc("Y");
        }
        if ((corrmistr.getAttribute("RelationCase") == null) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_en")) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_ar"))) {
            this.setRc("Y");
        }
        if (corrmistr.getAttribute("AccusedName") == null) {
            this.setAn("Y");
        }
        return null;
    }

    public String rec_corpse_action() {
        String key = (String)afu.evaluateEL("#{pageFlowScope.key}");
        Locale localel = (Locale)afu.evaluateEL("#{pageFlowScope.locale}");
        String locale = localel.toString();
        String s = "Y";
        ViewObject caseinfovo = getAm().findViewObject("ReqCaseInfoView1");
        ViewObject reqview = getAm().findViewObject("ReqRequestsView15");
        ViewObject corrmistvo = getAm().findViewObject("ReqRecCorpseView1");
        Row corrmistr = corrmistvo.getCurrentRow();
        if (corrmistr.getAttribute("CaseNo") != null &&
            corrmistr.getAttribute("CaseYear") != null &&
            corrmistr.getAttribute("ProsecutionName") != null &&
            corrmistr.getAttribute("RelationCase") != null &&
            (!corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_en")) &&
            (!corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_en"))) {
            Number cno = (Number)corrmistr.getAttribute("CaseNo");
            Number cyear = (Number)corrmistr.getAttribute("CaseYear");
            String cpname = (String)corrmistr.getAttribute("ProsecutionName");
            int sid = Integer.parseInt(key);
            BigDecimal caseno = new BigDecimal(cno.toString());
            BigDecimal name = new BigDecimal(cpname.toString());
            BigDecimal year = new BigDecimal(cyear.toString());
            String res = this.validatingCase(sid, caseno, name, year);
            if (res.equals("ok")) {
                Row casinfr = caseinfovo.createRow();
                Row reqr = reqview.createRow();
                casinfr.setAttribute("CaseNumber",
                                     corrmistr.getAttribute("CaseNo"));
                casinfr.setAttribute("CaseYear",
                                     corrmistr.getAttribute("CaseYear"));
                casinfr.setAttribute("CaseType",
                                     corrmistr.getAttribute("ProsecutionName"));
                casinfr.setAttribute("Relation",
                                     corrmistr.getAttribute("RelationCase"));
                reqr.setAttribute("ReqName", setServiceNames(locale, key));
                reqr.setAttribute("CaseInfoId",
                                  casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ServiceId", sid);
                corrmistr.setAttribute("CaseInfo",
                                       casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ProsecId",
                                  corrmistr.getAttribute("ProsecutionName"));
                //                uploadedFile_recCorpse();
                //                commit_action();
                //                sentEmail((Number)casinfr.getAttribute("CaseId"),
                //                          "Receiving of Corpse");
                //                return "Y";
                java.util.List<UploadedFile> file_u = this.getUploadedfile();
                if (file_u != null) {
                    String validateFile = validateFileUpload(file_u);
                    if (validateFile.equals("N")) {
                        for (int i = 0; i < file_u.size(); i++) {
                            Number foldern =
                                (Number)reqr.getAttribute("ReqId");
                            String foldername = foldern.toString();
                            if (i == 0) {
                                ubean.createFolder(foldername);
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadedFile_recCorpse(file_u.get(i),
                                                       ubean.getDid());
                            } else {
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadedFile_recCorpse(file_u.get(i),
                                                       ubean.getDid());
                            }
                        }
                    } else {
                        casinfr.remove();
                        reqr.remove();
                        s = "N";
                        FacesContext.getCurrentInstance().addMessage(upFileBind.getClientId(FacesContext.getCurrentInstance()),
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                      "File Type extension are not allowed",
                                                                                      "Kindly reload the files"));
                    }
                }
                if (s.equals("Y")) {
                    commit_action();
                    sentEmail((Number)reqr.getAttribute("ReqId"),
                              setServiceNames(locale, key), locale);
                    afu.setEL("#{pageFlowScope.casno}",
                              reqr.getAttribute("ReqId"));
                    oracle.jbo.domain.Number csid =
                        (Number)reqr.getAttribute("ReqId");
                    executeSMSproc((String)ADFContext.getCurrent().getSessionScope().get("mobile"),
                                   csid);

                    return "Y";
                }
            } else {
                return "N";
            }
        }
        if (corrmistr.getAttribute("CaseNo") == null) {
            this.setCn("Y");
        }
        if (corrmistr.getAttribute("CaseYear") == null) {
            this.setCy("Y");
        }
        if ((corrmistr.getAttribute("ProsecutionName") == null) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_en")) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_ar"))) {
            this.setPc("Y");
        }
        if ((corrmistr.getAttribute("RelationCase") == null) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_en")) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_ar"))) {
            this.setRc("Y");
        }
        return null;
    }

    public String rec_Review_action() {
        String key = (String)afu.evaluateEL("#{pageFlowScope.key}");
        Locale localel = (Locale)afu.evaluateEL("#{pageFlowScope.locale}");
        String locale = localel.toString();
        //        String locale = "en";
        String s = "Y";
        ViewObject caseinfovo = getAm().findViewObject("ReqCaseInfoView1");
        ViewObject reqview = getAm().findViewObject("ReqRequestsView18");
        ViewObject corrmistvo = getAm().findViewObject("ReqReviewView1");
        Row corrmistr = corrmistvo.getCurrentRow();
        if (corrmistr.getAttribute("CaseNo") != null &&
            corrmistr.getAttribute("CaseYear") != null &&
            corrmistr.getAttribute("ProName") != null &&
            corrmistr.getAttribute("RelCase") != null &&
            corrmistr.getAttribute("ReqRsn") != null) {
            Number cno = (Number)corrmistr.getAttribute("CaseNo");
            Number cyear = (Number)corrmistr.getAttribute("CaseYear");
            String cpname = (String)corrmistr.getAttribute("ProName");
            int sid = Integer.parseInt(key);
            BigDecimal caseno = new BigDecimal(cno.toString());
            BigDecimal name = new BigDecimal(cpname.toString());
            BigDecimal year = new BigDecimal(cyear.toString());
            String res = this.validatingCase(sid, caseno, name, year);
            if (res.equals("ok")) {
                Row casinfr = caseinfovo.createRow();
                Row reqr = reqview.createRow();
                casinfr.setAttribute("CaseNumber",
                                     corrmistr.getAttribute("CaseNo"));
                casinfr.setAttribute("CaseYear",
                                     corrmistr.getAttribute("CaseYear"));
                casinfr.setAttribute("CaseType",
                                     corrmistr.getAttribute("ProName"));
                casinfr.setAttribute("Relation",
                                     corrmistr.getAttribute("RelCase"));
                reqr.setAttribute("ReqName", "Review");
                reqr.setAttribute("CaseInfoId",
                                  casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ServiceId", sid);
                reqr.setAttribute("ReqName", setServiceNames(locale, key));
                corrmistr.setAttribute("CaseInfo",
                                       casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ProsecId",
                                  corrmistr.getAttribute("ProName"));
                //                uploadFile_review();
                //                commit_action();
                //                sentEmail((Number)casinfr.getAttribute("CaseId"), "Review");
                //                return "Y";
                java.util.List<UploadedFile> file_u = this.getUploadedfile();
                if (file_u != null) {
                    String validateFile = validateFileUpload(file_u);
                    if (validateFile.equals("N")) {
                        for (int i = 0; i < file_u.size(); i++) {
                            Number foldern =
                                (Number)reqr.getAttribute("ReqId");
                            String foldername = foldern.toString();
                            if (i == 0) {
                                ubean.createFolder(foldername);
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadFile_review(file_u.get(i),
                                                  ubean.getDid());
                            } else {
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadFile_review(file_u.get(i),
                                                  ubean.getDid());
                            }
                        }
                    } else {
                        casinfr.remove();
                        reqr.remove();
                        s = "N";
                        FacesContext.getCurrentInstance().addMessage(upFileBind.getClientId(FacesContext.getCurrentInstance()),
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                      "File Type extension are not allowed",
                                                                                      "Kindly reload the files"));
                    }
                }
                if (s.equals("Y")) {
                    commit_action();
                    sentEmail((Number)reqr.getAttribute("ReqId"),
                              setServiceNames(locale, key), locale);
                    afu.setEL("#{pageFlowScope.casno}",
                              reqr.getAttribute("ReqId"));
                    oracle.jbo.domain.Number csid =
                        (Number)reqr.getAttribute("ReqId");
                    executeSMSproc((String)ADFContext.getCurrent().getSessionScope().get("mobile"),
                                   csid);
                    return "Y";
                }
            } else {
                return "N";
            }
        }
        if (corrmistr.getAttribute("CaseNo") == null) {
            this.setCn("Y");
        }
        if (corrmistr.getAttribute("CaseYear") == null) {
            this.setCy("Y");
        }
        if ((corrmistr.getAttribute("ProName") == null) ||
            (corrmistr.getAttribute("ProName").equals("LOV_pn_en")) ||
            (corrmistr.getAttribute("ProName").equals("LOV_pn_ar"))) {
            this.setPc("Y");
        }
        if ((corrmistr.getAttribute("RelCase") == null) ||
            (corrmistr.getAttribute("RelCase").equals("LOV_RelationCase_en")) ||
            (corrmistr.getAttribute("RelCase").equals("LOV_RelationCase_ar"))) {
            this.setRc("Y");
        }
        if (corrmistr.getAttribute("ReqRsn") == null) {
            this.setRr("Y");
        }
        return null;
    }

    public String rec_CaseCopy1_action() {
        String s = "Y";
        String key = (String)afu.evaluateEL("#{pageFlowScope.key}");
        Locale localel = (Locale)afu.evaluateEL("#{pageFlowScope.locale}");
        String locale = localel.toString();
        ViewObject caseinfovo = getAm().findViewObject("ReqCaseInfoView1");
        ViewObject reqview = getAm().findViewObject("ReqRequestsView19");
        ViewObject corrmistvo = getAm().findViewObject("ReqCasecopy1View1");
        Row corrmistr = corrmistvo.getCurrentRow();
        if (corrmistr.getAttribute("CaseNo") != null &&
            corrmistr.getAttribute("CaseYear") != null &&
            corrmistr.getAttribute("ProcName") != null &&
            corrmistr.getAttribute("RelCase") != null &&
            (!corrmistr.getAttribute("ProcName").equals("LOV_pn_en")) &&
            (!corrmistr.getAttribute("RelCase").equals("LOV_RelationCase_en"))) {
            Number cno = (Number)corrmistr.getAttribute("CaseNo");
            Number cyear = (Number)corrmistr.getAttribute("CaseYear");
            String cpname = (String)corrmistr.getAttribute("ProcName");
            int sid = Integer.parseInt(key);
            BigDecimal caseno = new BigDecimal(cno.toString());
            BigDecimal name = new BigDecimal(cpname.toString());
            BigDecimal year = new BigDecimal(cyear.toString());
            String res = this.validatingCase(sid, caseno, name, year);
            if (res.equals("ok")) {
                Row casinfr = caseinfovo.createRow();
                Row reqr = reqview.createRow();
                casinfr.setAttribute("CaseNumber",
                                     corrmistr.getAttribute("CaseNo"));
                casinfr.setAttribute("CaseYear",
                                     corrmistr.getAttribute("CaseYear"));
                casinfr.setAttribute("CaseType",
                                     corrmistr.getAttribute("ProcName"));
                casinfr.setAttribute("Relation",
                                     corrmistr.getAttribute("RelCase"));
                reqr.setAttribute("ReqName", setServiceNames(locale, key));
                reqr.setAttribute("CaseInfoId",
                                  casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ServiceId", sid);
                corrmistr.setAttribute("CaseInfo",
                                       casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ProsecId",
                                  corrmistr.getAttribute("ProcName"));
                //                uploadFile_caseCopy();
                //                commit_action();
                //                sentEmail((Number)casinfr.getAttribute("CaseId"),
                //                          "Correcting Mistake in Judgment Material");
                //                return "Y";
                java.util.List<UploadedFile> file_u = this.getUploadedfile();
                if (file_u != null) {
                    String validateFile = validateFileUpload(file_u);
                    if (validateFile.equals("N")) {
                        for (int i = 0; i < file_u.size(); i++) {
                            Number foldern =
                                (Number)reqr.getAttribute("ReqId");
                            String foldername = foldern.toString();
                            if (i == 0) {
                                ubean.createFolder(foldername);
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadFile_caseCopy(file_u.get(i),
                                                    ubean.getDid());
                            } else {
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadFile_caseCopy(file_u.get(i),
                                                    ubean.getDid());
                            }
                        }
                    } else {
                        casinfr.remove();
                        reqr.remove();
                        s = "N";
                        FacesContext.getCurrentInstance().addMessage(upFileBind.getClientId(FacesContext.getCurrentInstance()),
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                      "File Type extension are not allowed",
                                                                                      "Kindly reload the files"));
                    }
                }
                if (s.equals("Y")) {
                    commit_action();
                    sentEmail((Number)reqr.getAttribute("ReqId"),
                              setServiceNames(locale, key), locale);
                    afu.setEL("#{pageFlowScope.casno}",
                              reqr.getAttribute("ReqId"));
                    oracle.jbo.domain.Number csid =
                        (Number)reqr.getAttribute("ReqId");
                    executeSMSproc((String)ADFContext.getCurrent().getSessionScope().get("mobile"),
                                   csid);
                    return "Y";
                }
            } else {
                return "N";
            }
        }
        if (corrmistr.getAttribute("CaseNo") == null) {
            this.setCn("Y");
        }
        if (corrmistr.getAttribute("CaseYear") == null) {
            this.setCy("Y");
        }
        if ((corrmistr.getAttribute("ProcName") == null) ||
            (corrmistr.getAttribute("ProcName").equals("LOV_pn_en")) ||
            (corrmistr.getAttribute("ProcName").equals("LOV_pn_ar"))) {
            this.setPc("Y");
        }
        if ((corrmistr.getAttribute("RelCase") == null) ||
            (corrmistr.getAttribute("RelCase").equals("LOV_RelationCase_en")) ||
            (corrmistr.getAttribute("RelCase").equals("LOV_RelationCase_ar"))) {
            this.setRc("Y");
        }
        return null;
    }


    public String copy_judge_action() {
        String key = (String)afu.evaluateEL("#{pageFlowScope.key}");
        //        Locale localel = (Locale)afu.evaluateEL("#{pageFlowScope.locale}");
        //        String locale = localel.toString();
        String locale = "en";
        String s = "Y";
        ViewObject caseinfovo = getAm().findViewObject("ReqCaseInfoView1");
        ViewObject reqview = getAm().findViewObject("ReqRequestsView20");
        ViewObject corrmistvo = getAm().findViewObject("ReqCopyJudgeView1");
        Row corrmistr = corrmistvo.getCurrentRow();
        if (corrmistr.getAttribute("CaseNo") != null &&
            corrmistr.getAttribute("CaseYear") != null &&
            corrmistr.getAttribute("ProsecutionName") != null &&
            corrmistr.getAttribute("RelationCase") != null &&
            (!corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_en")) &&
            (!corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_en"))) {
            Number cno = (Number)corrmistr.getAttribute("CaseNo");
            Number cyear = (Number)corrmistr.getAttribute("CaseYear");
            String cpname = (String)corrmistr.getAttribute("ProsecutionName");
            int sid = Integer.parseInt(key);
            BigDecimal caseno = new BigDecimal(cno.toString());
            BigDecimal name = new BigDecimal(cpname.toString());
            BigDecimal year = new BigDecimal(cyear.toString());
            String res = this.validatingCase(sid, caseno, name, year);
            if (res.equals(""))
                return "N";
            else if (res.equals("ok")) {
                Row casinfr = caseinfovo.createRow();
                Row reqr = reqview.createRow();
                casinfr.setAttribute("CaseNumber",
                                     corrmistr.getAttribute("CaseNo"));
                casinfr.setAttribute("CaseYear",
                                     corrmistr.getAttribute("CaseYear"));
                casinfr.setAttribute("CaseType",
                                     corrmistr.getAttribute("ProsecutionName"));
                casinfr.setAttribute("Relation",
                                     corrmistr.getAttribute("RelationCase"));
                reqr.setAttribute("ReqName", setServiceNames(locale, key));
                reqr.setAttribute("CaseInfoId",
                                  casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ServiceId", sid);
                corrmistr.setAttribute("CaseInfo",
                                       casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ProsecId",
                                  corrmistr.getAttribute("ProsecutionName"));
                //                uploadedFile_copyJudg();
                //                commit_action();
                //                sentEmail((Number)casinfr.getAttribute("CaseId"),
                //                          "Correcting Mistake in Judgment Material");
                //                return "Y";
                java.util.List<UploadedFile> file_u = this.getUploadedfile();
                if (file_u != null) {
                    String validateFile = validateFileUpload(file_u);
                    if (validateFile.equals("N")) {
                        for (int i = 0; i < file_u.size(); i++) {
                            Number foldern =
                                (Number)reqr.getAttribute("ReqId");
                            String foldername = foldern.toString();
                            if (i == 0) {
                                ubean.createFolder(foldername);
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadedFile_copyJudg(file_u.get(i),
                                                      ubean.getDid());
                            } else {
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadedFile_copyJudg(file_u.get(i),
                                                      ubean.getDid());
                            }
                        }
                    } else {
                        casinfr.remove();
                        reqr.remove();
                        s = "N";
                        FacesContext.getCurrentInstance().addMessage(upFileBind.getClientId(FacesContext.getCurrentInstance()),
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                      "File Type extension are not allowed",
                                                                                      "Kindly reload the files"));
                    }
                }
                if (s.equals("Y")) {
                    commit_action();
                    sentEmail((Number)reqr.getAttribute("ReqId"),
                              setServiceNames(locale, key), locale);
                    afu.setEL("#{pageFlowScope.casno}",
                              reqr.getAttribute("ReqId"));
                    oracle.jbo.domain.Number csid =
                        (Number)reqr.getAttribute("ReqId");
                    executeSMSproc((String)ADFContext.getCurrent().getSessionScope().get("mobile"),
                                   csid);
                    return "Y";
                }
            } else {
                return "NotAllowed";
            }
        }
        if (corrmistr.getAttribute("CaseNo") == null) {
            this.setCn("Y");
        }
        if (corrmistr.getAttribute("CaseYear") == null) {
            this.setCy("Y");
        }
        if ((corrmistr.getAttribute("ProsecutionName") == null) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_en")) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_ar"))) {
            this.setPc("Y");
        }
        if ((corrmistr.getAttribute("RelationCase") == null) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_en")) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_ar"))) {
            this.setRc("Y");
        }
        return null;
    }

    public String cpy_ns_ordr_action() {
        String key = (String)afu.evaluateEL("#{pageFlowScope.key}");
        //        Locale localel = (Locale)afu.evaluateEL("#{pageFlowScope.locale}");
        //        String locale = localel.toString();
        String locale = "en";
        String s = "Y";
        ViewObject caseinfovo = getAm().findViewObject("ReqCaseInfoView1");
        ViewObject reqview = getAm().findViewObject("ReqRequestsView21");
        ViewObject corrmistvo = getAm().findViewObject("ReqCpyNsOrdrView1");
        Row corrmistr = corrmistvo.getCurrentRow();
        if (corrmistr.getAttribute("CaseNo") != null &&
            corrmistr.getAttribute("CaseYear") != null &&
            corrmistr.getAttribute("ProsecutionName") != null &&
            corrmistr.getAttribute("RelationCase") != null &&
            (!corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_en")) &&
            (!corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_en"))) {
            Number cno = (Number)corrmistr.getAttribute("CaseNo");
            Number cyear = (Number)corrmistr.getAttribute("CaseYear");
            String cpname = (String)corrmistr.getAttribute("ProsecutionName");
            int sid = Integer.parseInt(key);
            BigDecimal caseno = new BigDecimal(cno.toString());
            BigDecimal name = new BigDecimal(cpname.toString());
            BigDecimal year = new BigDecimal(cyear.toString());
            String res = this.validatingCase(sid, caseno, name, year);
          
            if (res.equals("ok")) {
                Row casinfr = caseinfovo.createRow();
                Row reqr = reqview.createRow();
                casinfr.setAttribute("CaseNumber",
                                     corrmistr.getAttribute("CaseNo"));
                casinfr.setAttribute("CaseYear",
                                     corrmistr.getAttribute("CaseYear"));
                casinfr.setAttribute("CaseType",
                                     corrmistr.getAttribute("ProsecutionName"));
                casinfr.setAttribute("Relation",
                                     corrmistr.getAttribute("RelationCase"));
                reqr.setAttribute("ReqName", setServiceNames(locale, key));
                reqr.setAttribute("CaseInfoId",
                                  casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ServiceId", sid);
                corrmistr.setAttribute("CaseInfo",
                                       casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ProsecId",
                                  corrmistr.getAttribute("ProsecutionName"));
                //                uploadfile_cpynsordr();
                //                commit_action();
                //                sentEmail((Number)casinfr.getAttribute("CaseId"),
                //                          "Copy NS order");
                //                return "Y";
                java.util.List<UploadedFile> file_u = this.getUploadedfile();
                if (file_u != null) {
                    String validateFile = validateFileUpload(file_u);
                    if (validateFile.equals("N")) {
                        for (int i = 0; i < file_u.size(); i++) {
                            Number foldern =
                                (Number)reqr.getAttribute("ReqId");
                            String foldername = foldern.toString();
                            if (i == 0) {
                                ubean.createFolder(foldername);
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadfile_cpynsordr(file_u.get(i),
                                                     ubean.getDid());
                            } else {
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadfile_cpynsordr(file_u.get(i),
                                                     ubean.getDid());
                            }
                        }
                    } else {
                        casinfr.remove();
                        reqr.remove();
                        s = "N";
                        FacesContext.getCurrentInstance().addMessage(upFileBind.getClientId(FacesContext.getCurrentInstance()),
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                      "File Type extension are not allowed",
                                                                                      "Kindly reload the files"));
                    }
                }
                if (s.equals("Y")) {
                    commit_action();
                    sentEmail((Number)reqr.getAttribute("ReqId"),
                              setServiceNames(locale, key), locale);
                    afu.setEL("#{pageFlowScope.casno}",
                              reqr.getAttribute("ReqId"));
                    oracle.jbo.domain.Number csid =
                        (Number)reqr.getAttribute("ReqId");
                    executeSMSproc((String)ADFContext.getCurrent().getSessionScope().get("mobile"),
                                   csid);
                    return "Y";
                }
            } else {
                if(!res.equals(""))
                    return "NotAllowed";
                else return "N";
             
            }
        }
        if (corrmistr.getAttribute("CaseNo") == null) {
            this.setCn("Y");
        }
        if (corrmistr.getAttribute("CaseYear") == null) {
            this.setCy("Y");
        }
        if ((corrmistr.getAttribute("ProsecutionName") == null) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_en")) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_ar"))) {
            this.setPc("Y");
        }
        if ((corrmistr.getAttribute("RelationCase") == null) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_en")) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_ar"))) {
            this.setRc("Y");
        }
        return null;
    }

    /**
     * Insert into UCM_COnfig info table
     * @return
     */
    public void insert_did(Number reqattach, String docid) {
        ViewObject attachucmView =
            this.getAm().findViewObject("AttachUcmInfoView1");
        Row attachUCMRow = attachucmView.createRow();
        attachUCMRow.setAttribute("RaId", reqattach);
        attachUCMRow.setAttribute("UcmDocId", docid);
    }

    /**
     * Get the description name from service id
     * @return
     */
    public String getServiceName(BigDecimal assid) {
        String serviceName = null;
        ViewObject serviceNameView =
            getAm().findViewObject("serviceNameView1");
        serviceNameView.setNamedWhereClauseParam("sid", assid);
        serviceNameView.executeQuery();
        if (serviceNameView.getEstimatedRowCount() != 0) {
            Row serviceNameRow = serviceNameView.first();
            if (serviceNameRow != null)
                serviceName = (String)serviceNameRow.getAttribute("SName");
        }
        return serviceName;
    }

    public String setServiceNames(String lang, String sid) {
        String serviceName = null;
        //        String langs = lang.toString();
        //        String langs = "en";
        BigDecimal sidb = new BigDecimal(sid);
        if (lang.equals("ar")) {
            ViewObject mojServicesArabView =
                getAm().findViewObject("MojServicesView1");
            mojServicesArabView.setNamedWhereClauseParam("p_ln", lang);
            mojServicesArabView.setNamedWhereClauseParam("p_sid", sidb);
            mojServicesArabView.executeQuery();
            if (mojServicesArabView.getEstimatedRowCount() != 0) {
                Row serviceNameRow = mojServicesArabView.first();
                if (serviceNameRow != null)
                    serviceName =
                            (String)serviceNameRow.getAttribute("RequestServiceName");
            }
        }
        if (lang.equals("en")) {
            ViewObject mojServicesEngView =
                getAm().findViewObject("MojServicesEnView1");
            mojServicesEngView.setNamedWhereClauseParam("sid", sidb);
            mojServicesEngView.setNamedWhereClauseParam("p_ln", lang);
            mojServicesEngView.executeQuery();
            if (mojServicesEngView.getEstimatedRowCount() != 0) {
                Row serviceNameRow = mojServicesEngView.first();
                if (serviceNameRow != null)
                    serviceName =
                            (String)serviceNameRow.getAttribute("RequestServiceName");
            }
        }
        return serviceName;
    }

    public String adj_sess_new_dte_action() {
        String key = (String)afu.evaluateEL("#{pageFlowScope.key}");
        Locale localel = (Locale)afu.evaluateEL("#{pageFlowScope.locale}");
        String locale = localel.toString();
        //        String locale = "en";
        String s = "Y";
        ViewObject caseinfovo = getAm().findViewObject("ReqCaseInfoView1");
        ViewObject reqview = getAm().findViewObject("ReqRequestsView22");
        ViewObject corrmistvo = getAm().findViewObject("ReqAdjSfndView1");
        UCMBean ubean = new UCMBean();
        Row corrmistr = corrmistvo.getCurrentRow();
        if ((corrmistr.getAttribute("CaseNo") != null) &&
            (corrmistr.getAttribute("CaseYear") != null) &&
            (corrmistr.getAttribute("ProsecutionName") != null) &&
            (corrmistr.getAttribute("RelationCase") != null) &&
            (corrmistr.getAttribute("PostponeReason") != null) &&
            (!corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_en")) &&
            (!corrmistr.getAttribute("PostponeReason").equals("LOV_pn_en")) &&
            (corrmistr.getAttribute("SessionDate") != null)) {
            Number cno = (Number)corrmistr.getAttribute("CaseNo");
            Number cyear = (Number)corrmistr.getAttribute("CaseYear");
            String cpname = (String)corrmistr.getAttribute("ProsecutionName");
            int sid = Integer.parseInt(key);
            BigDecimal caseno = new BigDecimal(cno.toString());
            BigDecimal name = new BigDecimal(cpname.toString());
            BigDecimal year = new BigDecimal(cyear.toString());
            String res = this.validatingCase(sid, caseno, name, year);
            if (res.equals("ok")) {
                Row casinfr = caseinfovo.createRow();
                Row reqr = reqview.createRow();
                //                corrmistr.setAttribute("ReqId", reqr.getAttribute("ReqId"));
                corrmistr.setAttribute("CaseInfo",
                                       casinfr.getAttribute("CaseId"));
                casinfr.setAttribute("CaseNumber",
                                     corrmistr.getAttribute("CaseNo"));
                casinfr.setAttribute("CaseYear",
                                     corrmistr.getAttribute("CaseYear"));
                casinfr.setAttribute("CaseType",
                                     corrmistr.getAttribute("ProsecutionName"));
                casinfr.setAttribute("Relation",
                                     corrmistr.getAttribute("RelationCase"));
                reqr.setAttribute("ReqName", setServiceNames(locale, key));
                reqr.setAttribute("CaseInfoId",
                                  casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ServiceId", sid);
                reqr.setAttribute("ProsecId",
                                  corrmistr.getAttribute("ProsecutionName"));
                //                uploadfile_AdjSessionDte();
                //                commit_action();
                //                sentEmail((Number)casinfr.getAttribute("CaseId"),
                //                          "Adjourn a Session or Fix New Date");
                //                return "Y";
                java.util.List<UploadedFile> file_u = this.getUploadedfile();
                if (file_u != null) {
                    String validateFile = validateFileUpload(file_u);
                    if (validateFile.equals("N")) {
                        for (int i = 0; i < file_u.size(); i++) {
                            Number foldern =
                                (Number)reqr.getAttribute("ReqId");
                            String foldername = foldern.toString();
                            if (i == 0) {
                                ubean.createFolder(foldername);
                                attachUrl =
                                        ubean.uploadedFile(foldername, file_u.get(i),
                                                           foldername);
                                uploadfile_AdjSessionDte(file_u.get(i),
                                                         ubean.getDid());
                            } else {
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadfile_AdjSessionDte(file_u.get(i),
                                                         ubean.getDid());
                            }
                        }
                    } else {
                        casinfr.remove();
                        reqr.remove();
                        s = "N";
                        FacesContext.getCurrentInstance().addMessage(upFileBind.getClientId(FacesContext.getCurrentInstance()),
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                      "File Type extension are not allowed",
                                                                                      "Kindly reload the files"));
                    }
                }
                if (s.equals("Y")) {
                    commit_action();
                    //                    BigDecimal bkey = new BigDecimal(key.toString());
                    sentEmail((Number)reqr.getAttribute("ReqId"),
                              setServiceNames(locale, key), locale);
                    afu.setEL("#{pageFlowScope.casno}",
                              reqr.getAttribute("ReqId"));
                    oracle.jbo.domain.Number csid =
                        (Number)reqr.getAttribute("ReqId");
                    executeSMSproc((String)ADFContext.getCurrent().getSessionScope().get("mobile"),
                                   csid);
                    return "Y";
                }
            } else {
                return "N";
            }
        }
        if (corrmistr.getAttribute("CaseNo") == null) {
            this.setCn("Y");
        }
        if (corrmistr.getAttribute("CaseYear") == null) {
            this.setCy("Y");
        }
        if ((corrmistr.getAttribute("ProsecutionName") == null) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_en")) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_ar"))) {
            this.setPc("Y");
        }
        if ((corrmistr.getAttribute("RelationCase") == null) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_en")) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_ar"))) {
            this.setRc("Y");
        }
        if (corrmistr.getAttribute("PostponeReason") == null) {
            this.setPr("Y");
        }
        if (corrmistr.getAttribute("SessionDate") == null) {
            this.setSd("Y");
        }
        return null;
    }


    public String rec_of_seizure_action() {
        String key = (String)afu.evaluateEL("#{pageFlowScope.key}");
        Locale localel = (Locale)afu.evaluateEL("#{pageFlowScope.locale}");
        String locale = localel.toString();
        //        String locale = "en";
        String s = "Y";
        ViewObject caseinfovo = getAm().findViewObject("ReqCaseInfoView1");
        ViewObject reqview = getAm().findViewObject("ReqRequestsView37");
        ViewObject corrmistvo =
            getAm().findViewObject("ReqReceiveSeizureView1");
        UCMBean ubean = new UCMBean();
        Row corrmistr = corrmistvo.getCurrentRow();
        if ((corrmistr.getAttribute("CaseNo") != null) &&
            (corrmistr.getAttribute("CaseYear") != null) &&
            (corrmistr.getAttribute("ProsecutionName") != null) &&
            (corrmistr.getAttribute("RelationCase") != null) &&
            (corrmistr.getAttribute("Description") != null) &&
            (corrmistr.getAttribute("RestraintType") != null)) {
            Number cno = (Number)corrmistr.getAttribute("CaseNo");
            Number cyear = (Number)corrmistr.getAttribute("CaseYear");
            String cpname = (String)corrmistr.getAttribute("ProsecutionName");
            int sid = Integer.parseInt(key);
            BigDecimal caseno = new BigDecimal(cno.toString());
            BigDecimal name = new BigDecimal(cpname.toString());
            BigDecimal year = new BigDecimal(cyear.toString());
            String res = this.validatingCase(sid, caseno, name, year);
            if (res.equals("ok")) {
                Row casinfr = caseinfovo.createRow();
                Row reqr = reqview.createRow();
                //                corrmistr.setAttribute("ReqId", reqr.getAttribute("ReqId"));
                corrmistr.setAttribute("CaseInfo",
                                       casinfr.getAttribute("CaseId"));
                casinfr.setAttribute("CaseNumber",
                                     corrmistr.getAttribute("CaseNo"));
                casinfr.setAttribute("CaseYear",
                                     corrmistr.getAttribute("CaseYear"));
                casinfr.setAttribute("CaseType",
                                     corrmistr.getAttribute("ProsecutionName"));
                casinfr.setAttribute("Relation",
                                     corrmistr.getAttribute("RelationCase"));
                reqr.setAttribute("ReqName", setServiceNames(locale, key));
                reqr.setAttribute("CaseInfoId",
                                  casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ServiceId", sid);
                reqr.setAttribute("ProsecId",
                                  corrmistr.getAttribute("ProsecutionName"));
                //                uploadfile_AdjSessionDte();
                //                commit_action();
                //                sentEmail((Number)casinfr.getAttribute("CaseId"),
                //                          "Adjourn a Session or Fix New Date");
                //                return "Y";
                java.util.List<UploadedFile> file_u = this.getUploadedfile();
                if (file_u != null) {
                    String validateFile = validateFileUpload(file_u);
                    if (validateFile.equals("N")) {
                        for (int i = 0; i < file_u.size(); i++) {
                            Number foldern =
                                (Number)reqr.getAttribute("ReqId");
                            String foldername = foldern.toString();
                            if (i == 0) {
                                ubean.createFolder(foldername);
                                attachUrl =
                                        ubean.uploadedFile(foldername, file_u.get(i),
                                                           foldername);
                                uploadfile_recSeizure(file_u.get(i),
                                                      ubean.getDid());
                            } else {
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadfile_recSeizure(file_u.get(i),
                                                      ubean.getDid());
                            }
                        }
                    } else {
                        casinfr.remove();
                        reqr.remove();
                        s = "N";
                        FacesContext.getCurrentInstance().addMessage(upFileBind.getClientId(FacesContext.getCurrentInstance()),
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                      "File Type extension are not allowed",
                                                                                      "Kindly reload the files"));
                    }
                }
                if (s.equals("Y")) {
                    commit_action();
                    //                    BigDecimal bkey = new BigDecimal(key.toString());
                    sentEmail((Number)reqr.getAttribute("ReqId"),
                              setServiceNames(locale, key), locale);
                    afu.setEL("#{pageFlowScope.casno}",
                              reqr.getAttribute("ReqId"));
                    oracle.jbo.domain.Number csid =
                        (Number)reqr.getAttribute("ReqId");
                    executeSMSproc((String)ADFContext.getCurrent().getSessionScope().get("mobile"),
                                   csid);
                    return "Y";
                }
            } else {
                return "N";
            }
        }
        if (corrmistr.getAttribute("CaseNo") == null) {
            this.setCn("Y");
        }
        if (corrmistr.getAttribute("CaseYear") == null) {
            this.setCy("Y");
        }
        if ((corrmistr.getAttribute("ProsecutionName") == null) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_en")) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_ar"))) {
            this.setPc("Y");
        }
        if ((corrmistr.getAttribute("RelationCase") == null) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_en")) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_ar"))) {
            this.setRc("Y");
        }
        if (corrmistr.getAttribute("Description") == null) {
            ds = "Y";
        }
        if (corrmistr.getAttribute("RestraintType") == null) {
            rt = "Y";
        }
        return null;
    }

    public String validateFileUpload(List<UploadedFile> file_u) {
        String validateFile = "N";
        int f = 0;
        if (file_u != null) {
            for (int i = 0; i < file_u.size(); i++) {
                if ((file_u.get(i).getFilename().endsWith("jpeg")) ||
                    (file_u.get(i).getFilename().endsWith("jpg")) ||
                    (file_u.get(i).getFilename().endsWith("txt")) ||
                    (file_u.get(i).getFilename().endsWith("doc")) ||
                    (file_u.get(i).getFilename().endsWith("gif")) ||
                    (file_u.get(i).getFilename().endsWith("pdf")) ||
                    (file_u.get(i).getFilename().endsWith("png")) ||
                    (file_u.get(i).getFilename().endsWith("tiff"))) {
                    if (f == 0) {
                        validateFile = "N";
                    }
                } else {
                    validateFile = "Y";
                    f++;
                }
            }
        }
        return validateFile;
    }

    public String sentEmail(Number caseid, String servicename, String locale) {
        String message = null;
        String subj = null;
        String email =
            (String)ADFContext.getCurrent().getSessionScope().get("usermail");
        ADFUtils au = new ADFUtils();
        String username =
            (String)ADFContext.getCurrent().getSessionScope().get("name");
        if (locale.equals("en")) {
            subj = "Your request has been processed successfully";
            message = "Dear User, ";
            message +=
                    "Your request has been processed successfully Request number : " +
                    caseid;
        } else if (locale.equals("ar")) {
            subj = "تعزيزي المستخدم طلب التسجيل الخاص بك تحت قيد التن�?يذ";
            message =
                    caseid + "تعزيزي المستخدم طلب التسجيل الخاص بك تحت قيد التن�?يذ :";
        }
        au.sendEmail(email, subj, message);
        return null;
    }

    public String DCIP_Due_action() {
        String key = (String)afu.evaluateEL("#{pageFlowScope.key}");
        Locale localel = (Locale)afu.evaluateEL("#{pageFlowScope.locale}");
        String locale = localel.toString();
        String s = "Y";
        ViewObject caseinfovo = getAm().findViewObject("ReqCaseInfoView1");
        ViewObject reqview = getAm().findViewObject("ReqRequestsView23");
        ViewObject corrmistvo =
            getAm().findViewObject("ReqDciPrescriptionView1");
        Row corrmistr = corrmistvo.getCurrentRow();
        if (corrmistr.getAttribute("CaseNo") != null &&
            corrmistr.getAttribute("CaseYear") != null &&
            corrmistr.getAttribute("ProsecutionName") != null &&
            corrmistr.getAttribute("RelationCase") != null &&
            corrmistr.getAttribute("JudgementDate") != null) {
            Number cno = (Number)corrmistr.getAttribute("CaseNo");
            Number cyear = (Number)corrmistr.getAttribute("CaseYear");
            String cpname = (String)corrmistr.getAttribute("ProsecutionName");
            //            String res = check_case_info_common(cyear, cpname, cno);
            int sid = Integer.parseInt(key);
            BigDecimal caseno = new BigDecimal(cno.toString());
            BigDecimal name = new BigDecimal(cpname.toString());
            BigDecimal year = new BigDecimal(cyear.toString());
            String res = this.validatingCase(sid, caseno, name, year);
            if (res.equals("ok")) {
                Row casinfr = caseinfovo.createRow();
                Row reqr = reqview.createRow();
                casinfr.setAttribute("CaseNumber",
                                     corrmistr.getAttribute("CaseNo"));
                casinfr.setAttribute("CaseYear",
                                     corrmistr.getAttribute("CaseYear"));
                casinfr.setAttribute("CaseType",
                                     corrmistr.getAttribute("ProsecutionName"));
                casinfr.setAttribute("Relation",
                                     corrmistr.getAttribute("RelationCase"));
                reqr.setAttribute("ReqName", setServiceNames(locale, key));
                reqr.setAttribute("CaseInfoId",
                                  casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ServiceId", sid);
                corrmistr.setAttribute("CaseInfo",
                                       casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ProsecId",
                                  corrmistr.getAttribute("ProsecutionName"));
                java.util.List<UploadedFile> file_u = this.getUploadedfile();
                if (file_u != null) {
                    String validateFile = validateFileUpload(file_u);
                    if (validateFile.equals("N")) {
                        for (int i = 0; i < file_u.size(); i++) {
                            Number foldern =
                                (Number)reqr.getAttribute("ReqId");
                            String foldername = foldern.toString();
                            if (i == 0) {
                                ubean.createFolder(foldername);
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadedFile_dropcourt(file_u.get(i),
                                                       ubean.getDid());
                            } else {
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadedFile_dropcourt(file_u.get(i),
                                                       ubean.getDid());
                            }
                        }
                    } else {
                        casinfr.remove();
                        reqr.remove();
                        s = "N";
                        FacesContext.getCurrentInstance().addMessage(upFileBind.getClientId(FacesContext.getCurrentInstance()),
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                      "File Type extension are not allowed",
                                                                                      "Kindly reload the files"));
                    }
                }
                if (s.equals("Y")) {
                    commit_action();
                    sentEmail((Number)reqr.getAttribute("ReqId"),
                              setServiceNames(locale, key), locale);
                    afu.setEL("#{pageFlowScope.casno}",
                              reqr.getAttribute("ReqId"));
                    oracle.jbo.domain.Number csid =
                        (Number)reqr.getAttribute("ReqId");
                    executeSMSproc((String)ADFContext.getCurrent().getSessionScope().get("mobile"),
                                   csid);
                    return "Y";
                }
            } else {
                return "N";
            }
        }
        if (corrmistr.getAttribute("CaseNo") == null) {
            this.setCn("Y");
        }
        if (corrmistr.getAttribute("CaseYear") == null) {
            this.setCy("Y");
        }
        if ((corrmistr.getAttribute("ProsecutionName") == null) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_en")) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_ar"))) {
            this.setPc("Y");
        }
        if ((corrmistr.getAttribute("RelationCase") == null) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_en")) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_ar"))) {
            this.setRc("Y");
        }
        return null;
    }

    public String Exhumation_action() {
        String key = (String)afu.evaluateEL("#{pageFlowScope.key}");
        Locale localel = (Locale)afu.evaluateEL("#{pageFlowScope.locale}");
        String locale = localel.toString();
        String s = "Y";
        ViewObject caseinfovo = getAm().findViewObject("ReqCaseInfoView1");
        ViewObject reqview = getAm().findViewObject("ReqRequestsView24");
        ViewObject corrmistvo = getAm().findViewObject("ReqExhumationView1");
        Row corrmistr = corrmistvo.getCurrentRow();
        if (corrmistr.getAttribute("Caseno") != null &&
            corrmistr.getAttribute("Caseyear") != null &&
            corrmistr.getAttribute("Prosecutionname") != null &&
            corrmistr.getAttribute("Relationcase") != null &&
            corrmistr.getAttribute("Reason") != null) {
            Number cno = (Number)corrmistr.getAttribute("Caseno");
            Number cyear = (Number)corrmistr.getAttribute("Caseyear");
            String cpname = (String)corrmistr.getAttribute("Prosecutionname");
            int sid = Integer.parseInt(key);
            BigDecimal caseno = new BigDecimal(cno.toString());
            BigDecimal name = new BigDecimal(cpname.toString());
            BigDecimal year = new BigDecimal(cyear.toString());
            String res = this.validatingCase(sid, caseno, name, year);
            if (res.equals("ok")) {
                Row casinfr = caseinfovo.createRow();
                Row reqr = reqview.createRow();
                casinfr.setAttribute("CaseNumber",
                                     corrmistr.getAttribute("Caseno"));
                casinfr.setAttribute("CaseYear",
                                     corrmistr.getAttribute("Caseyear"));
                casinfr.setAttribute("CaseType",
                                     corrmistr.getAttribute("Prosecutionname"));
                casinfr.setAttribute("Relation",
                                     corrmistr.getAttribute("Relationcase"));
                reqr.setAttribute("ReqName", setServiceNames(locale, key));
                reqr.setAttribute("CaseInfoId",
                                  casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ServiceId", sid);
                corrmistr.setAttribute("CaseInfo",
                                       casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ProsecId",
                                  corrmistr.getAttribute("Prosecutionname"));
                //                uploadfile_exhaumation();
                //                commit_action();
                //                sentEmail((Number)casinfr.getAttribute("CaseId"),
                //                          "Exhumation");
                //                return "Y";
                java.util.List<UploadedFile> file_u = this.getUploadedfile();
                if (file_u != null) {
                    String validateFile = validateFileUpload(file_u);
                    if (validateFile.equals("N")) {
                        for (int i = 0; i < file_u.size(); i++) {
                            Number foldern =
                                (Number)reqr.getAttribute("ReqId");
                            String foldername = foldern.toString();
                            if (i == 0) {
                                ubean.createFolder(foldername);
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadfile_exhaumation(file_u.get(i),
                                                       ubean.getDid());
                            } else {
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadfile_exhaumation(file_u.get(i),
                                                       ubean.getDid());
                            }
                        }
                    } else {
                        casinfr.remove();
                        reqr.remove();
                        s = "N";
                        FacesContext.getCurrentInstance().addMessage(upFileBind.getClientId(FacesContext.getCurrentInstance()),
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                      "File Type extension are not allowed",
                                                                                      "Kindly reload the files"));
                    }
                }
                if (s.equals("Y")) {
                    commit_action();
                    sentEmail((Number)reqr.getAttribute("ReqId"),
                              setServiceNames(locale, key), locale);
                    afu.setEL("#{pageFlowScope.casno}",
                              reqr.getAttribute("ReqId"));
                    oracle.jbo.domain.Number csid =
                        (Number)reqr.getAttribute("ReqId");
                    executeSMSproc((String)ADFContext.getCurrent().getSessionScope().get("mobile"),
                                   csid);
                    return "Y";
                }
            } else {
                return "N";
            }
        }
        if (corrmistr.getAttribute("Caseno") == null) {
            this.setCn("Y");
        }
        if (corrmistr.getAttribute("Caseyear") == null) {
            this.setCy("Y");
        }
        if ((corrmistr.getAttribute("Prosecutionname") == null) ||
            (corrmistr.getAttribute("Prosecutionname").equals("LOV_pn_en")) ||
            (corrmistr.getAttribute("Prosecutionname").equals("LOV_pn_ar"))) {
            this.setPc("Y");
        }
        if ((corrmistr.getAttribute("Relationcase") == null) ||
            (corrmistr.getAttribute("Relationcase").equals("LOV_RelationCase_en")) ||
            (corrmistr.getAttribute("Relationcase").equals("LOV_RelationCase_ar"))) {
            this.setRc("Y");
        }
        if (corrmistr.getAttribute("Reason") == null) {
            this.setRs("Y");
        }
        return null;
    }

    public String EoPCase_action() {
        String key = (String)afu.evaluateEL("#{pageFlowScope.key}");
        Locale localel = (Locale)afu.evaluateEL("#{pageFlowScope.locale}");
        String locale = localel.toString();
        //        String locale = "en";
        String s = "Y";
        ViewObject caseinfovo = getAm().findViewObject("ReqCaseInfoView1");
        ViewObject reqview = getAm().findViewObject("ReqRequestsView25");
        ViewObject corrmistvo = getAm().findViewObject("EopCaseView1");
        Row corrmistr = corrmistvo.getCurrentRow();
        if (corrmistr.getAttribute("CaseNo") != null &&
            corrmistr.getAttribute("CaseYear") != null &&
            corrmistr.getAttribute("ProsecutionName") != null &&
            corrmistr.getAttribute("Relationcase") != null &&
            corrmistr.getAttribute("CrimeDate") != null &&
            corrmistr.getAttribute("StopReason") != null) {
            Number cno = (Number)corrmistr.getAttribute("CaseNo");
            Number cyear = (Number)corrmistr.getAttribute("CaseYear");
            String cpname = (String)corrmistr.getAttribute("ProsecutionName");
            //            String res = check_case_info_common(cyear, cpname, cno);
            int sid = Integer.parseInt(key);
            BigDecimal caseno = new BigDecimal(cno.toString());
            BigDecimal name = new BigDecimal(cpname.toString());
            BigDecimal year = new BigDecimal(cyear.toString());
            String res = this.validatingCase(sid, caseno, name, year);
            if (res.equals("ok")) {
                Row casinfr = caseinfovo.createRow();
                Row reqr = reqview.createRow();
                corrmistr.setAttribute("CaseInfo",
                                       casinfr.getAttribute("CaseId"));
                casinfr.setAttribute("CaseNumber",
                                     corrmistr.getAttribute("CaseNo"));
                casinfr.setAttribute("CaseYear",
                                     corrmistr.getAttribute("CaseYear"));
                casinfr.setAttribute("CaseType",
                                     corrmistr.getAttribute("ProsecutionName"));
                casinfr.setAttribute("Relation",
                                     corrmistr.getAttribute("Relationcase"));
                reqr.setAttribute("ReqName", setServiceNames(locale, key));
                reqr.setAttribute("CaseInfoId",
                                  casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ServiceId", sid);
                reqr.setAttribute("ProsecId",
                                  corrmistr.getAttribute("ProsecutionName"));
                corrmistr.setAttribute("CaseInfo",
                                       casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ProsecId",
                                  corrmistr.getAttribute("ProsecutionName"));
                //                uploadfile_eopcase();
                //                commit_action();
                //                sentEmail((Number)casinfr.getAttribute("CaseId"),
                //                          "Expiration of Penal Case");
                //                return "Y";
                java.util.List<UploadedFile> file_u = this.getUploadedfile();
                if (file_u != null) {
                    String validateFile = validateFileUpload(file_u);
                    if (validateFile.equals("N")) {
                        for (int i = 0; i < file_u.size(); i++) {
                            Number foldern =
                                (Number)reqr.getAttribute("ReqId");
                            String foldername = foldern.toString();
                            if (i == 0) {
                                ubean.createFolder(foldername);
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadfile_eopcase(file_u.get(i),
                                                   ubean.getDid());
                            } else {
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadfile_eopcase(file_u.get(i),
                                                   ubean.getDid());
                            }
                        }
                    } else {
                        casinfr.remove();
                        reqr.remove();
                        s = "N";
                        FacesContext.getCurrentInstance().addMessage(upFileBind.getClientId(FacesContext.getCurrentInstance()),
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                      "File Type extension are not allowed",
                                                                                      "Kindly reload the files"));
                    }
                }
                if (s.equals("Y")) {
                    commit_action();
                    sentEmail((Number)reqr.getAttribute("ReqId"),
                              setServiceNames(locale, key), locale);
                    afu.setEL("#{pageFlowScope.casno}",
                              reqr.getAttribute("ReqId"));
                    oracle.jbo.domain.Number csid =
                        (Number)reqr.getAttribute("ReqId");
                    executeSMSproc((String)ADFContext.getCurrent().getSessionScope().get("mobile"),
                                   csid);
                    return "Y";
                }
            } else {
                return "N";
            }
        }
        if (corrmistr.getAttribute("CaseNo") == null) {
            this.setCn("Y");
        }
        if (corrmistr.getAttribute("CaseYear") == null) {
            this.setCy("Y");
        }
        if ((corrmistr.getAttribute("ProsecutionName") == null) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_en")) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_ar"))) {
            this.setPc("Y");
        }
        if ((corrmistr.getAttribute("Relationcase") == null) ||
            (corrmistr.getAttribute("Relationcase").equals("LOV_RelationCase_en")) ||
            (corrmistr.getAttribute("Relationcase").equals("LOV_RelationCase_ar"))) {
            this.setRc("Y");
        }
        if (corrmistr.getAttribute("CrimeDate") == null) {
            cd = "Y";
        }
        if (corrmistr.getAttribute("StopReason") == null) {
            sr = "Y";
        }
        return null;
    }

    public String FdReimbursement_action() {
        String key = (String)afu.evaluateEL("#{pageFlowScope.key}");
        Locale localel = (Locale)afu.evaluateEL("#{pageFlowScope.locale}");
        String locale = localel.toString();
        String s = "Y";
        ViewObject caseinfovo = getAm().findViewObject("ReqCaseInfoView1");
        ViewObject reqview = getAm().findViewObject("ReqRequestsView26");
        ViewObject corrmistvo =
            getAm().findViewObject("ReqFdReimbursementView1");
        Row corrmistr = corrmistvo.getCurrentRow();
        if (corrmistr.getAttribute("CaseNo") != null &&
            corrmistr.getAttribute("CaseYear") != null &&
            corrmistr.getAttribute("Prosecutionname") != null &&
            corrmistr.getAttribute("Relationcase") != null) {
            Number cno = (Number)corrmistr.getAttribute("CaseNo");
            Number cyear = (Number)corrmistr.getAttribute("CaseYear");
            String cpname = (String)corrmistr.getAttribute("Prosecutionname");
            int sid = Integer.parseInt(key);
            BigDecimal caseno = new BigDecimal(cno.toString());
            BigDecimal name = new BigDecimal(cpname.toString());
            BigDecimal year = new BigDecimal(cyear.toString());
            String res = this.validatingCase(sid, caseno, name, year);
            if (res.equals("ok")) {
                Row casinfr = caseinfovo.createRow();
                Row reqr = reqview.createRow();
                casinfr.setAttribute("CaseNumber",
                                     corrmistr.getAttribute("CaseNo"));
                casinfr.setAttribute("CaseYear",
                                     corrmistr.getAttribute("CaseYear"));
                casinfr.setAttribute("CaseType",
                                     corrmistr.getAttribute("Prosecutionname"));
                casinfr.setAttribute("Relation",
                                     corrmistr.getAttribute("Relationcase"));
                reqr.setAttribute("ReqName", setServiceNames(locale, key));
                reqr.setAttribute("CaseInfoId",
                                  casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ServiceId", sid);
                corrmistr.setAttribute("CaseInfo",
                                       casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ProsecId",
                                  corrmistr.getAttribute("Prosecutionname"));
                //                uploadedfile_fdreim();
                //                commit_action();
                //                sentEmail((Number)casinfr.getAttribute("CaseId"),
                //                          "Fine Difference Reimbursement");
                //                return "Y";
                java.util.List<UploadedFile> file_u = this.getUploadedfile();
                if (file_u != null) {
                    String validateFile = validateFileUpload(file_u);
                    if (validateFile.equals("N")) {
                        for (int i = 0; i < file_u.size(); i++) {
                            Number foldern =
                                (Number)reqr.getAttribute("ReqId");
                            String foldername = foldern.toString();
                            if (i == 0) {
                                ubean.createFolder(foldername);
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadedfile_fdreim(file_u.get(i),
                                                    ubean.getDid());
                            } else {
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadedfile_fdreim(file_u.get(i),
                                                    ubean.getDid());
                            }
                        }
                    } else {
                        casinfr.remove();
                        reqr.remove();
                        s = "N";
                        FacesContext.getCurrentInstance().addMessage(upFileBind.getClientId(FacesContext.getCurrentInstance()),
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                      "File Type extension are not allowed",
                                                                                      "Kindly reload the files"));
                    }
                }
                if (s.equals("Y")) {
                    commit_action();
                    sentEmail((Number)reqr.getAttribute("ReqId"),
                              setServiceNames(locale, key), locale);
                    afu.setEL("#{pageFlowScope.casno}",
                              reqr.getAttribute("ReqId"));
                    oracle.jbo.domain.Number csid =
                        (Number)reqr.getAttribute("ReqId");
                    executeSMSproc((String)ADFContext.getCurrent().getSessionScope().get("mobile"),
                                   csid);
                    return "Y";
                }
            } else {
                return "N";
            }
        }
        if (corrmistr.getAttribute("CaseNo") == null) {
            this.setCn("Y");
        }
        if (corrmistr.getAttribute("CaseYear") == null) {
            this.setCy("Y");
        }
        if ((corrmistr.getAttribute("Prosecutionname") == null) ||
            (corrmistr.getAttribute("Prosecutionname").equals("LOV_pn_en")) ||
            (corrmistr.getAttribute("Prosecutionname").equals("LOV_pn_ar"))) {
            this.setPc("Y");
        }
        if ((corrmistr.getAttribute("Relationcase") == null) ||
            (corrmistr.getAttribute("Relationcase").equals("LOV_RelationCase_en")) ||
            (corrmistr.getAttribute("Relationcase").equals("LOV_RelationCase_ar"))) {
            this.setRc("Y");
        }
        //        if (corrmistr.getAttribute("Judgeagainst") == null) {
        //            this.setJa("Y");
        //        }
        return null;
    }

    public String Req_MeetProcse_action() {
        String key = (String)afu.evaluateEL("#{pageFlowScope.key}");
        Locale localel = (Locale)afu.evaluateEL("#{pageFlowScope.locale}");
        String locale = localel.toString();
        //        String locale = "en";
        String s = "Y";
        ViewObject caseinfovo = getAm().findViewObject("ReqCaseInfoView1");
        ViewObject reqview = getAm().findViewObject("ReqRequestsView27");
        ViewObject corrmistvo = getAm().findViewObject("ReqMeetProCheifView1");
        Row corrmistr = corrmistvo.getCurrentRow();
        if (corrmistr.getAttribute("RequestSubject") != null &&
            corrmistr.getAttribute("InterviewDate") != null &&
            corrmistr.getAttribute("InterviewTime") != null &&
            corrmistr.getAttribute("PersonToMeet") != null) {
            Number cno = (Number)corrmistr.getAttribute("CaseNo");
            Number cyear = (Number)corrmistr.getAttribute("CaseYear");
            //                        String cpname = (String)corrmistr.getAttribute("Prosecutionname");
            int sid = Integer.parseInt(key);
            //            BigDecimal caseno = new BigDecimal(cno.toString());
            //            BigDecimal name =
            //                (BigDecimal)corrmistr.getAttribute("Prosecutionname");
            //            BigDecimal year = new BigDecimal(cyear.toString());
            //            String res = this.validatingCase(sid, caseno, name, year);
            String res = "ok";
            if (res.equals("ok")) {
                Row casinfr = caseinfovo.createRow();
                Row reqr = reqview.createRow();
                casinfr.setAttribute("CaseNumber",
                                     corrmistr.getAttribute("CaseNo"));
                casinfr.setAttribute("CaseYear",
                                     corrmistr.getAttribute("CaseYear"));
                casinfr.setAttribute("CaseType",
                                     corrmistr.getAttribute("Prosecutionname"));
                casinfr.setAttribute("Relation",
                                     corrmistr.getAttribute("Relationcase"));
                reqr.setAttribute("ReqName", setServiceNames(locale, key));
                reqr.setAttribute("CaseInfoId",
                                  casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ServiceId", sid);
                corrmistr.setAttribute("CaseInfo",
                                       casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ProsecId",
                                  corrmistr.getAttribute("Prosecutionname"));
                //                uploadfile_meetproc();
                //                commit_action();
                //                sentEmail((Number)casinfr.getAttribute("CaseId"),
                //                          "Meeting a Prosecutor/Chief Prosecutor");
                //                return "Y";
                java.util.List<UploadedFile> file_u = this.getUploadedfile();
                if (file_u != null) {
                    String validateFile = validateFileUpload(file_u);
                    if (validateFile.equals("N")) {
                        for (int i = 0; i < file_u.size(); i++) {
                            Number foldern =
                                (Number)reqr.getAttribute("ReqId");
                            String foldername = foldern.toString();
                            if (i == 0) {
                                ubean.createFolder(foldername);
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadfile_meetproc(file_u.get(i),
                                                    ubean.getDid());
                            } else {
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadfile_meetproc(file_u.get(i),
                                                    ubean.getDid());
                            }
                        }
                    } else {
                        casinfr.remove();
                        reqr.remove();
                        s = "N";
                        FacesContext.getCurrentInstance().addMessage(upFileBind.getClientId(FacesContext.getCurrentInstance()),
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                      "File Type extension are not allowed",
                                                                                      "Kindly reload the files"));
                    }
                }
                if (s.equals("Y")) {
                    commit_action();
                    sentEmail((Number)reqr.getAttribute("ReqId"),
                              setServiceNames(locale, key), locale);
                    afu.setEL("#{pageFlowScope.casno}",
                              reqr.getAttribute("ReqId"));
                    oracle.jbo.domain.Number csid =
                        (Number)reqr.getAttribute("ReqId");
                    executeSMSproc((String)ADFContext.getCurrent().getSessionScope().get("mobile"),
                                   csid);
                    return "Y";
                }
            } else {
                return "N";
            }
        }
        //        if (corrmistr.getAttribute("CaseNo") == null) {
        //            this.setCn("Y");
        //        }
        //        if (corrmistr.getAttribute("CaseYear") == null) {
        //            this.setCy("Y");
        //        }
        //        if ((corrmistr.getAttribute("Prosecutionname") == null) ||
        //            (corrmistr.getAttribute("Prosecutionname").equals("LOV_pn_en")) ||
        //            (corrmistr.getAttribute("Prosecutionname").equals("LOV_pn_ar"))) {
        //            this.setPc("Y");
        //        }
        //        if ((corrmistr.getAttribute("Relationcase") == null) ||
        //            (corrmistr.getAttribute("Relationcase").equals("LOV_RelationCase_en")) ||
        //            (corrmistr.getAttribute("Relationcase").equals("LOV_RelationCase_ar"))) {
        //            this.setRc("Y");
        //        }
        if (corrmistr.getAttribute("RequestSubject") == null) {
            this.setRs("Y");
        }
        //        if (corrmistr.getAttribute("InterviewTime") == null) {
        //            it = "Y";
        //        }
        if (corrmistr.getAttribute("InterviewDate") == null) {
            id = "Y";
        }
        if (corrmistr.getAttribute("InterviewTime") == null) {
            it = "Y";
        }
        if (corrmistr.getAttribute("PersonToMeet") == null) {
            ptm = "Y";
        }
        return null;
    }


    public String OpenofMem_action() {
        String key = (String)afu.evaluateEL("#{pageFlowScope.key}");
        Locale localel = (Locale)afu.evaluateEL("#{pageFlowScope.locale}");
        String locale = localel.toString();
        //        String locale = "en";
        String s = "Y";
        ViewObject caseinfovo = getAm().findViewObject("ReqCaseInfoView1");
        ViewObject reqview = getAm().findViewObject("ReqRequestsView28");
        ViewObject corrmistvo = getAm().findViewObject("ReqOpeningOdMemView1");
        Row corrmistr = corrmistvo.getCurrentRow();
        if (corrmistr.getAttribute("Prosecutionname") != null &&
            corrmistr.getAttribute("Witnessname") != null &&
            corrmistr.getAttribute("ComplainantNationality") != null &&
            corrmistr.getAttribute("MemoSubject") != null &&
            corrmistr.getAttribute("ComplainantAddress") != null &&
            corrmistr.getAttribute("ComplainantMobile") != null &&
            corrmistr.getAttribute("MemoCategory") != null) {
            Number cno = (Number)corrmistr.getAttribute("CaseNo");
            Number cyear = (Number)corrmistr.getAttribute("CaseYear");
            String cpname = (String)corrmistr.getAttribute("Prosecutionname");
            int sid = Integer.parseInt(key);
            //            BigDecimal caseno = new BigDecimal(cno.toString());
            //            BigDecimal name = new BigDecimal(cpname.toString());
            //            BigDecimal year = new BigDecimal(cyear.toString());
            //            String res = this.validatingCase(sid, caseno, name, year);
            String res = "ok";
            if (res.equals("ok")) {
                Row casinfr = caseinfovo.createRow();
                Row reqr = reqview.createRow();
                //                casinfr.setAttribute("CaseNumber",
                //                                     corrmistr.getAttribute("CaseNo"));
                casinfr.setAttribute("CaseYear",
                                     corrmistr.getAttribute("CaseYear"));
                casinfr.setAttribute("CaseType",
                                     corrmistr.getAttribute("Prosecutionname"));
                //                casinfr.setAttribute("Relation",
                //                                     corrmistr.getAttribute("Relationcase"));
                reqr.setAttribute("ReqName", setServiceNames(locale, key));
                //                reqr.setAttribute("CaseInfoId",
                //                                  casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ServiceId", sid);
                corrmistr.setAttribute("MemoCategory",
                                       corrmistr.getAttribute("Prosecutionname"));
                reqr.setAttribute("ProsecId",
                                  corrmistr.getAttribute("Prosecutionname"));
                //                uploadedFile_openmem();
                //                commit_action();
                //                sentEmail((Number)casinfr.getAttribute("CaseId"),
                //                          "Opening of Memorandums");
                //                return "Y";
                java.util.List<UploadedFile> file_u = this.getUploadedfile();
                if (file_u != null) {
                    String validateFile = validateFileUpload(file_u);
                    if (validateFile.equals("N")) {
                        for (int i = 0; i < file_u.size(); i++) {
                            Number foldern =
                                (Number)reqr.getAttribute("ReqId");
                            String foldername = foldern.toString();
                            if (i == 0) {
                                ubean.createFolder(foldername);
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadedFile_openmem(file_u.get(i),
                                                     ubean.getDid());
                            } else {
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadedFile_openmem(file_u.get(i),
                                                     ubean.getDid());
                            }
                        }
                    } else {
                        casinfr.remove();
                        reqr.remove();
                        s = "N";
                        FacesContext.getCurrentInstance().addMessage(upFileBind.getClientId(FacesContext.getCurrentInstance()),
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                      "File Type extension are not allowed",
                                                                                      "Kindly reload the files"));
                    }
                }
                if (s.equals("Y")) {
                    commit_action();
                    sentEmail((Number)reqr.getAttribute("ReqId"),
                              setServiceNames(locale, key), locale);
                    afu.setEL("#{pageFlowScope.casno}",
                              reqr.getAttribute("ReqId"));
                    oracle.jbo.domain.Number csid =
                        (Number)reqr.getAttribute("ReqId");
                    executeSMSproc((String)ADFContext.getCurrent().getSessionScope().get("mobile"),
                                   csid);
                    return "Y";
                }
            } else {
                return "N";
            }
        }
        if (corrmistr.getAttribute("CaseNo") == null) {
            this.setCn("Y");
        }
        if (corrmistr.getAttribute("CaseYear") == null) {
            this.setCy("Y");
        }
        if ((corrmistr.getAttribute("Prosecutionname") == null) ||
            (corrmistr.getAttribute("Prosecutionname").equals("LOV_pn_en")) ||
            (corrmistr.getAttribute("Prosecutionname").equals("LOV_pn_ar"))) {
            this.setPc("Y");
        }
        if ((corrmistr.getAttribute("Relationcase") == null) ||
            (corrmistr.getAttribute("Relationcase").equals("LOV_RelationCase_en")) ||
            (corrmistr.getAttribute("Relationcase").equals("LOV_RelationCase_ar"))) {
            this.setRc("Y");
        }
        if (corrmistr.getAttribute("Witnessname") == null) {
            this.setWn("Y");
        }
        if (corrmistr.getAttribute("ComplainantNationality") == null) {
            this.setNt("Y");
        }
        if (corrmistr.getAttribute("MemoSubject") == null) {
            this.setSb("Y");
        }
        if (corrmistr.getAttribute("ComplainantAddress") == null) {
            addr = "Y";
        }
        if (corrmistr.getAttribute("ComplainantMobile") == null) {
            this.setMob("Y");
        }
        if (corrmistr.getAttribute("MemoCategory") == null) {
            mc = "Y";
        }
        return null;
    }

    public String PPRenewal_action() {
        String key = (String)afu.evaluateEL("#{pageFlowScope.key}");
        Locale localel = (Locale)afu.evaluateEL("#{pageFlowScope.locale}");
        String locale = localel.toString();
        String s = "Y";
        ViewObject caseinfovo = getAm().findViewObject("ReqCaseInfoView1");
        ViewObject reqview = getAm().findViewObject("ReqRequestsView29");
        ViewObject corrmistvo = getAm().findViewObject("ReqPportrenewalView1");
        Row corrmistr = corrmistvo.getCurrentRow();
        if (corrmistr != null) {
            if ((corrmistr.getAttribute("CaseNo") != null) &&
                (corrmistr.getAttribute("CaseYear") != null) &&
                (corrmistr.getAttribute("Prosecutionname") != null) &&
                (corrmistr.getAttribute("Relationcase") != null) &&
                (corrmistr.getAttribute("PassportExpiryDate") != null) &&
                (corrmistr.getAttribute("PassportIssueDate") != null) &&
                (corrmistr.getAttribute("PassportNo") != null)) {
                Number cno = (Number)corrmistr.getAttribute("CaseNo");
                Number cyear = (Number)corrmistr.getAttribute("CaseYear");
                String cpname =
                    (String)corrmistr.getAttribute("Prosecutionname");
                int sid = Integer.parseInt(key);
                BigDecimal caseno = new BigDecimal(cno.toString());
                BigDecimal name = new BigDecimal(cpname.toString());
                BigDecimal year = new BigDecimal(cyear.toString());
                String res = this.validatingCase(sid, caseno, name, year);

                if (res.equals("ok")) {
                    Row casinfr = caseinfovo.createRow();
                    Row reqr = reqview.createRow();
                    casinfr.setAttribute("CaseNumber",
                                         corrmistr.getAttribute("CaseNo"));
                    casinfr.setAttribute("CaseYear",
                                         corrmistr.getAttribute("CaseYear"));
                    casinfr.setAttribute("CaseType",
                                         corrmistr.getAttribute("Prosecutionname"));
                    casinfr.setAttribute("Relation",
                                         corrmistr.getAttribute("Relationcase"));
                    reqr.setAttribute("ReqName", setServiceNames(locale, key));
                    reqr.setAttribute("CaseInfoId",
                                      casinfr.getAttribute("CaseId"));
                    reqr.setAttribute("ServiceId", sid);
                    corrmistr.setAttribute("CaseInfo",
                                           casinfr.getAttribute("CaseId"));
                    reqr.setAttribute("ProsecId",
                                      corrmistr.getAttribute("Prosecutionname"));
                    java.util.List<UploadedFile> file_u =
                        this.getUploadedfile();
                    if (file_u != null) {
                        String validateFile = validateFileUpload(file_u);
                        if (validateFile.equals("N")) {
                            for (int i = 0; i < file_u.size(); i++) {
                                Number foldern =
                                    (Number)reqr.getAttribute("ReqId");
                                String foldername = foldern.toString();
                                if (i == 0) {
                                    ubean.createFolder(foldername);
                                    ubean.uploadedFile(foldername,
                                                       file_u.get(i),
                                                       foldername);
                                    uploadFile_PportRenewal(file_u.get(i),
                                                            ubean.getDid());
                                } else {
                                    ubean.uploadedFile(foldername,
                                                       file_u.get(i),
                                                       foldername);
                                    uploadFile_PportRenewal(file_u.get(i),
                                                            ubean.getDid());
                                }
                            }
                        } else {
                            casinfr.remove();
                            reqr.remove();
                            s = "N";
                            FacesContext.getCurrentInstance().addMessage(upFileBind.getClientId(FacesContext.getCurrentInstance()),
                                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                          "File Type extension are not allowed",
                                                                                          "Kindly reload the files"));
                        }
                    }
                    if (s.equals("Y")) {
                        commit_action();
                        sentEmail((Number)reqr.getAttribute("ReqId"),
                                  setServiceNames(locale, key), locale);
                        afu.setEL("#{pageFlowScope.casno}",
                                  reqr.getAttribute("ReqId"));
                        oracle.jbo.domain.Number csid =
                            (Number)reqr.getAttribute("ReqId");
                        executeSMSproc((String)ADFContext.getCurrent().getSessionScope().get("mobile"),
                                       csid);
                        return "Y";
                    }
                } else {
                    return "N";
                }
            }
            if (corrmistr.getAttribute("CaseNo") == null) {
                this.setCn("Y");
            }
            if (corrmistr.getAttribute("CaseYear") == null) {
                this.setCy("Y");
            }
            if ((corrmistr.getAttribute("Prosecutionname") == null) ||
                (corrmistr.getAttribute("Prosecutionname").equals("LOV_pn_en")) ||
                (corrmistr.getAttribute("Prosecutionname").equals("LOV_pn_ar"))) {
                this.setPc("Y");
            }
            if ((corrmistr.getAttribute("Relationcase") == null) ||
                (corrmistr.getAttribute("Relationcase").equals("LOV_Relationcase_en")) ||
                (corrmistr.getAttribute("Relationcase").equals("LOV_Relationcase_ar"))) {
                this.setRc("Y");
            }
            if ((corrmistr.getAttribute("PassportExpiryDate") == null)) {
                this.ed = "Y";
            }
            if ((corrmistr.getAttribute("PassportIssueDate") == null)) {
                this.pid = "Y";
            }
            if ((corrmistr.getAttribute("PassportNo") == null))
                pno = "Y";
        }
        return null;
    }

    public String PaymentinsCourt_action() {
        String key = (String)afu.evaluateEL("#{pageFlowScope.key}");
        Locale localel = (Locale)afu.evaluateEL("#{pageFlowScope.locale}");
        String locale = localel.toString();
        //                String locale = "en";
        String s = "Y";
        ViewObject caseinfovo = getAm().findViewObject("ReqCaseInfoView1");
        ViewObject reqview = getAm().findViewObject("ReqRequestsView30");
        ViewObject corrmistvo =
            getAm().findViewObject("ReqPaymentinsCourtView1");
        Row corrmistr = corrmistvo.getCurrentRow();
        String installcheck = checkInstalAmt();
        if (corrmistr.getAttribute("CaseNo") != null &&
            corrmistr.getAttribute("CaseYear") != null &&
            corrmistr.getAttribute("Prosecutionname") != null &&
            corrmistr.getAttribute("Relationcase") != null &&
            corrmistr.getAttribute("SponsoredPersonName") != null &&
            installcheck.equals("Y")) {
            Number cno = (Number)corrmistr.getAttribute("CaseNo");
            Number cyear = (Number)corrmistr.getAttribute("CaseYear");
            String cpname = (String)corrmistr.getAttribute("Prosecutionname");
            int sid = 21;
            BigDecimal caseno = new BigDecimal(cno.toString());
            BigDecimal name = new BigDecimal(cpname.toString());
            BigDecimal year = new BigDecimal(cyear.toString());
            String res = this.validatingCase(sid, caseno, name, year);
            if (res.equals("ok")) {
                Row casinfr = caseinfovo.createRow();
                Row reqr = reqview.createRow();
                casinfr.setAttribute("CaseNumber",
                                     corrmistr.getAttribute("CaseNo"));
                casinfr.setAttribute("CaseYear",
                                     corrmistr.getAttribute("CaseYear"));
                casinfr.setAttribute("CaseType",
                                     corrmistr.getAttribute("Prosecutionname"));
                casinfr.setAttribute("Relation",
                                     corrmistr.getAttribute("Relationcase"));
                reqr.setAttribute("ReqName", "Payment installment to court");
                reqr.setAttribute("CaseInfoId",
                                  casinfr.getAttribute("CaseId"));
                corrmistr.setAttribute("CaseInfo",
                                       casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ServiceId", 21);
                //                                corrmistr.setAttribute("CaseInfo", casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ProsecId",
                                  corrmistr.getAttribute("Prosecutionname"));
                //                uploadedfile_PaymentinstanlCourt();
                //                commit_action();
                //                sentEmail((Number)casinfr.getAttribute("CaseId"),
                //                          "Payment installment to court");
                //                return "Y";
                java.util.List<UploadedFile> file_u = this.getUploadedfile();
                if (file_u != null) {
                    String validateFile = validateFileUpload(file_u);
                    if (validateFile.equals("N")) {
                        for (int i = 0; i < file_u.size(); i++) {
                            Number foldern =
                                (Number)reqr.getAttribute("ReqId");
                            String foldername = foldern.toString();
                            if (i == 0) {
                                ubean.createFolder(foldername);
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadedfile_PaymentinstanlCourt(file_u.get(i),
                                                                 ubean.getDid());
                            } else {
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadedfile_PaymentinstanlCourt(file_u.get(i),
                                                                 ubean.getDid());
                            }
                        }
                    } else {
                        casinfr.remove();
                        reqr.remove();
                        s = "N";
                        FacesContext.getCurrentInstance().addMessage(upFileBind.getClientId(FacesContext.getCurrentInstance()),
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                      "File Type extension are not allowed",
                                                                                      "Kindly reload the files"));
                    }
                }
                if (s.equals("Y")) {
                    commit_action();
                    sentEmail((Number)reqr.getAttribute("ReqId"),
                              setServiceNames(locale, key), locale);
                    afu.setEL("#{pageFlowScope.casno}",
                              reqr.getAttribute("ReqId"));
                    oracle.jbo.domain.Number csid =
                        (Number)reqr.getAttribute("ReqId");
                    executeSMSproc((String)ADFContext.getCurrent().getSessionScope().get("mobile"),
                                   csid);
                    return "Y";
                }
            } else {
                return "N";
            }
        }
        if (corrmistr.getAttribute("CaseNo") == null) {
            this.setCn("Y");
        }
        if (corrmistr.getAttribute("CaseYear") == null) {
            this.setCy("Y");
        }
        if ((corrmistr.getAttribute("Prosecutionname") == null) ||
            (corrmistr.getAttribute("Prosecutionname").equals("LOV_pn_en")) ||
            (corrmistr.getAttribute("Prosecutionname").equals("LOV_pn_ar"))) {
            this.setPc("Y");
        }
        if ((corrmistr.getAttribute("Relationcase") == null) ||
            (corrmistr.getAttribute("Relationcase").equals("LOV_Relationcase_en")) ||
            (corrmistr.getAttribute("Relationcase").equals("LOV_Relationcase_ar"))) {
            this.setRc("Y");
        }
        if (corrmistr.getAttribute("FineAmount") == null) {
            this.setFa("Y");
        }
        if (corrmistr.getAttribute("NoOfInstalls") == null) {
            this.setIa("Y");
        }
        if (corrmistr.getAttribute("SponsoredPersonName") == null) {
            spn = "Y";
        }
        if (installcheck.equals("N")) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                          "Fine amount does not match with the installment amount",
                                                                          "Fine amount does not match with the installment amount"));
        }
        return null;
    }

    public String PCopyCasedropingdec_action() {
        String key = (String)afu.evaluateEL("#{pageFlowScope.key}");
        //        Locale localel = (Locale)afu.evaluateEL("#{pageFlowScope.locale}");
        //        String locale = localel.toString();
        String locale = "en";
        String s = "Y";
        ViewObject caseinfovo = getAm().findViewObject("ReqCaseInfoView1");
        ViewObject reqview = getAm().findViewObject("ReqRequestsView31");
        ViewObject corrmistvo =
            getAm().findViewObject("ReqPcopyCasedropingDecView1");
        Row corrmistr = corrmistvo.getCurrentRow();
        if (corrmistr.getAttribute("CaseNo") != null &&
            corrmistr.getAttribute("CaseYear") != null &&
            corrmistr.getAttribute("Prosecutionname") != null &&
            corrmistr.getAttribute("Relationcase") != null) {
            Number cno = (Number)corrmistr.getAttribute("CaseNo");
            Number cyear = (Number)corrmistr.getAttribute("CaseYear");
            String cpname = (String)corrmistr.getAttribute("Prosecutionname");
            int sid = Integer.parseInt(key);
            BigDecimal caseno = new BigDecimal(cno.toString());
            BigDecimal name = new BigDecimal(cpname.toString());
            BigDecimal year = new BigDecimal(cyear.toString());
            String res = this.validatingCase(sid, caseno, name, year);
            if (res.equals("ok")) {
                Row casinfr = caseinfovo.createRow();
                Row reqr = reqview.createRow();
                casinfr.setAttribute("CaseNumber",
                                     corrmistr.getAttribute("CaseNo"));
                casinfr.setAttribute("CaseYear",
                                     corrmistr.getAttribute("CaseYear"));
                casinfr.setAttribute("CaseType",
                                     corrmistr.getAttribute("Prosecutionname"));
                casinfr.setAttribute("Relation",
                                     corrmistr.getAttribute("Relationcase"));
                reqr.setAttribute("ReqName", setServiceNames(locale, key));
                reqr.setAttribute("CaseInfoId",
                                  casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ServiceId", sid);
                corrmistr.setAttribute("CaseInfo",
                                       casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ProsecId",
                                  corrmistr.getAttribute("Prosecutionname"));
                //                uploadfile_Pcopycasedropdec();
                //                commit_action();
                //                sentEmail((Number)casinfr.getAttribute("CaseId"),
                //                          "Photocopy of Case Dropping Decision");
                //                return "Y";
                java.util.List<UploadedFile> file_u = this.getUploadedfile();
                if (file_u != null) {
                    String validateFile = validateFileUpload(file_u);
                    if (validateFile.equals("N")) {
                        for (int i = 0; i < file_u.size(); i++) {
                            Number foldern =
                                (Number)reqr.getAttribute("ReqId");
                            String foldername = foldern.toString();
                            if (i == 0) {
                                ubean.createFolder(foldername);
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadfile_Pcopycasedropdec(file_u.get(i),
                                                            ubean.getDid());
                            } else {
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadfile_Pcopycasedropdec(file_u.get(i),
                                                            ubean.getDid());
                            }
                        }
                    } else {
                        casinfr.remove();
                        reqr.remove();
                        s = "N";
                        FacesContext.getCurrentInstance().addMessage(upFileBind.getClientId(FacesContext.getCurrentInstance()),
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                      "File Type extension are not allowed",
                                                                                      "Kindly reload the files"));
                    }
                }
                if (s.equals("Y")) {
                    commit_action();
                    sentEmail((Number)reqr.getAttribute("ReqId"),
                              setServiceNames(locale, key), locale);
                    afu.setEL("#{pageFlowScope.casno}",
                              reqr.getAttribute("ReqId"));
                    oracle.jbo.domain.Number csid =
                        (Number)reqr.getAttribute("ReqId");
                    executeSMSproc((String)ADFContext.getCurrent().getSessionScope().get("mobile"),
                                   csid);
                    return "Y";
                }
            } else {
                if (!res.equals(""))
                    return "NotAllowed";
                else
                    return "N";
            }
        }
        if (corrmistr.getAttribute("CaseNo") == null) {
            this.setCn("Y");
        }
        if (corrmistr.getAttribute("CaseYear") == null) {
            this.setCy("Y");
        }
        if ((corrmistr.getAttribute("Prosecutionname") == null) ||
            (corrmistr.getAttribute("Prosecutionname").equals("LOV_pn_en")) ||
            (corrmistr.getAttribute("Prosecutionname").equals("LOV_pn_ar"))) {
            this.setPc("Y");
        }
        if ((corrmistr.getAttribute("Relationcase") == null) ||
            (corrmistr.getAttribute("Relationcase").equals("LOV_Relationcase_en")) ||
            (corrmistr.getAttribute("Relationcase").equals("LOV_Relationcase_ar"))) {
            this.setRc("Y");
        }
        return null;
    }

    public String PostponeOffreedom_action() {
        String key = (String)afu.evaluateEL("#{pageFlowScope.key}");
        Locale localel = (Locale)afu.evaluateEL("#{pageFlowScope.locale}");
        String locale = localel.toString();
        //        String locale = "en";
        String s = "Y";
        ViewObject caseinfovo = getAm().findViewObject("ReqCaseInfoView1");
        ViewObject reqview = getAm().findViewObject("ReqRequestsView32");
        ViewObject corrmistvo =
            getAm().findViewObject("ReqPostponeOfFreedomView1");
        Row corrmistr = corrmistvo.getCurrentRow();
        if (corrmistr.getAttribute("CaseNo") != null &&
            corrmistr.getAttribute("CaseYear") != null &&
            corrmistr.getAttribute("Prosecutionname") != null &&
            corrmistr.getAttribute("Relationcase") != null &&
            corrmistr.getAttribute("DelayReason") != null) {
            Number cno = (Number)corrmistr.getAttribute("CaseNo");
            Number cyear = (Number)corrmistr.getAttribute("CaseYear");
            String cpname = (String)corrmistr.getAttribute("Prosecutionname");
            int sid = Integer.parseInt(key);
            BigDecimal caseno = new BigDecimal(cno.toString());
            BigDecimal name = new BigDecimal(cpname.toString());
            BigDecimal year = new BigDecimal(cyear.toString());
            String res = this.validatingCase(sid, caseno, name, year);
            if (res.equals("ok")) {
                Row casinfr = caseinfovo.createRow();
                Row reqr = reqview.createRow();
                casinfr.setAttribute("CaseNumber",
                                     corrmistr.getAttribute("CaseNo"));
                casinfr.setAttribute("CaseYear",
                                     corrmistr.getAttribute("CaseYear"));
                casinfr.setAttribute("CaseType",
                                     corrmistr.getAttribute("Prosecutionname"));
                casinfr.setAttribute("Relation",
                                     corrmistr.getAttribute("Relationcase"));
                reqr.setAttribute("ReqName", setServiceNames(locale, key));
                reqr.setAttribute("CaseInfoId",
                                  casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ServiceId", sid);
                corrmistr.setAttribute("CaseInfo",
                                       casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ProsecId",
                                  corrmistr.getAttribute("Prosecutionname"));
                //                uplaodFile_postponefree();
                //                commit_action();
                //                sentEmail((Number)casinfr.getAttribute("CaseId"),
                //                          "Postpone the execution of restricted freedom punishment of convicts");
                //                return "Y";
                java.util.List<UploadedFile> file_u = this.getUploadedfile();
                if (file_u != null) {
                    String validateFile = validateFileUpload(file_u);
                    if (validateFile.equals("N")) {
                        for (int i = 0; i < file_u.size(); i++) {
                            Number foldern =
                                (Number)reqr.getAttribute("ReqId");
                            String foldername = foldern.toString();
                            if (i == 0) {
                                ubean.createFolder(foldername);
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uplaodFile_postponefree(file_u.get(i),
                                                        ubean.getDid());
                            } else {
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uplaodFile_postponefree(file_u.get(i),
                                                        ubean.getDid());
                            }
                        }
                    } else {
                        casinfr.remove();
                        reqr.remove();
                        s = "N";
                        FacesContext.getCurrentInstance().addMessage(upFileBind.getClientId(FacesContext.getCurrentInstance()),
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                      "File Type extension are not allowed",
                                                                                      "Kindly reload the files"));
                    }
                }
                if (s.equals("Y")) {
                    commit_action();
                    sentEmail((Number)reqr.getAttribute("ReqId"),
                              setServiceNames(locale, key), locale);
                    afu.setEL("#{pageFlowScope.casno}",
                              reqr.getAttribute("ReqId"));
                    oracle.jbo.domain.Number csid =
                        (Number)reqr.getAttribute("ReqId");
                    executeSMSproc((String)ADFContext.getCurrent().getSessionScope().get("mobile"),
                                   csid);
                    return "Y";
                }
            } else {
                return "N";
            }
        }
        if (corrmistr.getAttribute("CaseNo") == null) {
            this.setCn("Y");
        }
        if (corrmistr.getAttribute("CaseYear") == null) {
            this.setCy("Y");
        }
        if ((corrmistr.getAttribute("Prosecutionname") == null) ||
            (corrmistr.getAttribute("Prosecutionname").equals("LOV_pn_en")) ||
            (corrmistr.getAttribute("Prosecutionname").equals("LOV_pn_ar"))) {
            this.setPc("Y");
        }
        if ((corrmistr.getAttribute("Relationcase") == null) ||
            (corrmistr.getAttribute("Relationcase").equals("LOV_RelationCase_en")) ||
            (corrmistr.getAttribute("Relationcase").equals("LOV_RelationCase_ar"))) {
            this.setRc("Y");
        }
        if (corrmistr.getAttribute("DelayReason") == null) {
            this.setDr("Y");
        }
        return null;
    }

    public String receving_Deposit_action() {
        String key = (String)afu.evaluateEL("#{pageFlowScope.key}");
        Locale localel = (Locale)afu.evaluateEL("#{pageFlowScope.locale}");
        String locale = localel.toString();
        String s = "Y";
        ViewObject caseinfovo = getAm().findViewObject("ReqCaseInfoView1");
        ViewObject reqview = getAm().findViewObject("ReqRequestsView33");
        ViewObject corrmistvo =
            getAm().findViewObject("ReqRecvDepositChargesView1");
        Row corrmistr = corrmistvo.getCurrentRow();
        if (corrmistr.getAttribute("CaseNo") != null &&
            corrmistr.getAttribute("CaseYear") != null &&
            corrmistr.getAttribute("Prosecutionname") != null &&
            corrmistr.getAttribute("Relationcase") != null &&
            corrmistr.getAttribute("RestraintType") != null &&
            corrmistr.getAttribute("Description") != null) {
            Number cno = (Number)corrmistr.getAttribute("CaseNo");
            Number cyear = (Number)corrmistr.getAttribute("CaseYear");
            String cpname = (String)corrmistr.getAttribute("Prosecutionname");
            int sid = Integer.parseInt(key);
            BigDecimal caseno = new BigDecimal(cno.toString());
            BigDecimal name = new BigDecimal(cpname.toString());
            BigDecimal year = new BigDecimal(cyear.toString());
            String res = this.validatingCase(sid, caseno, name, year);
            if (res.equals("ok")) {
                Row casinfr = caseinfovo.createRow();
                Row reqr = reqview.createRow();
                casinfr.setAttribute("CaseNumber",
                                     corrmistr.getAttribute("CaseNo"));
                casinfr.setAttribute("CaseYear",
                                     corrmistr.getAttribute("CaseYear"));
                casinfr.setAttribute("CaseType",
                                     corrmistr.getAttribute("Prosecutionname"));
                casinfr.setAttribute("Relation",
                                     corrmistr.getAttribute("Relationcase"));
                reqr.setAttribute("ReqName", setServiceNames(locale, key));
                reqr.setAttribute("CaseInfoId",
                                  casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ServiceId", sid);
                corrmistr.setAttribute("CaseInfo",
                                       casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ProsecId",
                                  corrmistr.getAttribute("Prosecutionname"));
                //                uploadedfile_recdepositedchrges();
                //                commit_action();
                //                sentEmail((Number)casinfr.getAttribute("CaseId"),
                //                          "Receiving of Deposited Charges");
                //                return "Y";
                java.util.List<UploadedFile> file_u = this.getUploadedfile();
                if (file_u != null) {
                    String validateFile = validateFileUpload(file_u);
                    if (validateFile.equals("N")) {
                        for (int i = 0; i < file_u.size(); i++) {
                            Number foldern =
                                (Number)reqr.getAttribute("ReqId");
                            String foldername = foldern.toString();
                            if (i == 0) {
                                ubean.createFolder(foldername);
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadedfile_recdepositedchrges(file_u.get(i),
                                                                ubean.getDid());
                            } else {
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadedfile_recdepositedchrges(file_u.get(i),
                                                                ubean.getDid());
                            }
                        }
                    } else {
                        casinfr.remove();
                        reqr.remove();
                        s = "N";
                        FacesContext.getCurrentInstance().addMessage(upFileBind.getClientId(FacesContext.getCurrentInstance()),
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                      "File Type extension are not allowed",
                                                                                      "Kindly reload the files"));
                    }
                }
                if (s.equals("Y")) {
                    commit_action();
                    sentEmail((Number)reqr.getAttribute("ReqId"),
                              setServiceNames(locale, key), locale);
                    afu.setEL("#{pageFlowScope.casno}",
                              reqr.getAttribute("ReqId"));
                    oracle.jbo.domain.Number csid =
                        (Number)reqr.getAttribute("ReqId");
                    executeSMSproc((String)ADFContext.getCurrent().getSessionScope().get("mobile"),
                                   csid);
                    return "Y";
                }
            } else {
                return "N";
            }
        }
        if (corrmistr.getAttribute("CaseNo") == null) {
            this.setCn("Y");
        }
        if (corrmistr.getAttribute("CaseYear") == null) {
            this.setCy("Y");
        }
        if ((corrmistr.getAttribute("Prosecutionname") == null) ||
            (corrmistr.getAttribute("Prosecutionname").equals("LOV_pn_en")) ||
            (corrmistr.getAttribute("Prosecutionname").equals("LOV_pn_ar"))) {
            this.setPc("Y");
        }
        if ((corrmistr.getAttribute("Relationcase") == null) ||
            (corrmistr.getAttribute("Relationcase").equals("LOV_RelationCase_en")) ||
            (corrmistr.getAttribute("Relationcase").equals("LOV_RelationCase_ar"))) {
            this.setRc("Y");
        }
        if (corrmistr.getAttribute("RestraintType") == null) {
            this.setRt("Y");
        }
        if (corrmistr.getAttribute("Description") == null)
            ds = "Y";
        return null;
    }


    /**
     * Check the case list for appeal
     * @return
     */
    //    public String check_case_info_appeal(Number year, String name, String subj,
    //                                         Number caseno) {
    //        ViewObject clcvo = this.getAm().findViewObject("CaseListCheckVO1");
    //        clcvo.setNamedWhereClauseParam("cno", caseno);
    //        clcvo.setNamedWhereClauseParam("pname", name);
    //        clcvo.setNamedWhereClauseParam("year", year);
    //        clcvo.setNamedWhereClauseParam("subj", subj);
    //        clcvo.executeQuery();
    //        if (clcvo.getEstimatedRowCount() != 0) {
    //            return "Y";
    //        } else {
    //            return "N";
    //        }
    //    }

    /**
     * Check the case list for common
     * @return
     */
    //    public String check_case_info_common(Number year, String name,
    //                                         Number caseno) {
    //        ViewObject clcvo =
    //            this.getAm().findViewObject("CaseListCheckCommonVO1");
    //        clcvo.setNamedWhereClauseParam("cno", caseno);
    //        clcvo.setNamedWhereClauseParam("pname", name);
    //        clcvo.setNamedWhereClauseParam("year", year);
    //        clcvo.executeQuery();
    //        if (clcvo.getEstimatedRowCount() != 0) {
    //            return "Y";
    //        } else {
    //            return "N";
    //        }
    //    }

    /**
     * validating case
     * @return
     */
    public String validatingCase(int sid, BigDecimal caseno, BigDecimal name,
                                 BigDecimal year) {
        String status = "";
        ViewObject clcvo = this.getAm().findViewObject("PRC_PARTY_REQ_VIEW1");
        clcvo.setNamedWhereClauseParam("p_cno", caseno);
        clcvo.setNamedWhereClauseParam("p_prosid", name);
        clcvo.setNamedWhereClauseParam("p_cyear", year);
        clcvo.executeQuery();
        if (clcvo.getEstimatedRowCount() != 0) {
            Row clcvrow = clcvo.first();
            BigDecimal statusCode =
                (BigDecimal)clcvrow.getAttribute("EventStatusLkp");
            BigDecimal b1178 = new BigDecimal("1178");
            BigDecimal b1180 = new BigDecimal("1180");
            int res1178 = statusCode.compareTo(b1178);
            int res1180 = statusCode.compareTo(b1180);
            switch (sid) {
            case 1:
                if (res1178 == 0)
                    status = "ok";
                else
                    status = "case.type.not.mahkooma";
                break;
            case 1001:
                if (res1178 == 0)
                    status = "ok";
                else
                    status = "case.type.not.mahkooma";
                break;
            case 7:
                if (res1180 == 0)
                    status = "ok";
                else
                    status = "case.type.not.mahfooza";
                break;
            case 1007:
                if (res1180 == 0)
                    status = "ok";
                else
                    status = "case.type.not.mahfooza";
                break;
            case 8:
                if (res1180 == 0)
                    status = "ok";
                else
                    status = "case.type.not.mahfooza";
                break;
            case 1008:
                if (res1180 == 0)
                    status = "ok";
                else
                    status = "case.type.not.mahfooza";
                break;
            case 26:
                if (res1178 == 0)
                    status = "ok";
                else
                    status = "case.type.not.mahfooza";
                break;
            case 1026:
                if (res1178 == 0)
                    status = "ok";
                else
                    status = "case.type.not.mahkooma";
                break;
            case 31:
                if (res1178 == 0)
                    status = "ok";
                else
                    status = "case.type.not.mahkooma";
                break;
            case 1031:
                if (res1178 == 0)
                    status = "ok";
                else
                    status = "case.type.not.mahkooma";
                break;
            default:
                status = "ok";
                break;
            }
        }
        System.out.println("Validation status is ==>" + status);
        return status;
    }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public String commit_action() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding =
            bindings.getOperationBinding("Commit");
        operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        } else {
            dFlag = "Y";
        }
        return null;
    }

    public void setDepUpFileBind(RichInputFile depUpFileBind) {
        this.depUpFileBind = depUpFileBind;
    }

    public RichInputFile getDepUpFileBind() {
        return depUpFileBind;
    }

    public void setDecUpFileBind(RichInputFile decUpFileBind) {
        this.decUpFileBind = decUpFileBind;
    }

    public RichInputFile getDecUpFileBind() {
        return decUpFileBind;
    }

    public void setDisbUpFileBind(RichInputFile disbUpFileBind) {
        this.disbUpFileBind = disbUpFileBind;
    }

    public RichInputFile getDisbUpFileBind() {
        return disbUpFileBind;
    }

    public void setDefUpFileBind(RichInputFile defUpFileBind) {
        this.defUpFileBind = defUpFileBind;
    }

    public RichInputFile getDefUpFileBind() {
        return defUpFileBind;
    }

    public void setEcajUpFileBind(RichInputFile ecajUpFileBind) {
        this.ecajUpFileBind = ecajUpFileBind;
    }

    public RichInputFile getEcajUpFileBind() {
        return ecajUpFileBind;
    }

    public void caseNoValidation(ValueChangeEvent vce) {
        if (this.getCn().equals("Y")) {
            this.setCn("N");
            /* this.getCnopg().setRendered(false);
            AdfFacesContext adfFacesContext =
                AdfFacesContext.getCurrentInstance();
            adfFacesContext.addPartialTarget(cnopg);*/
        }
        System.out.println(".....<><><><><><>Case number validation :: " +
                           this.getCn());
        Number valn = (Number)vce.getNewValue();
        String val = String.valueOf(valn);
        if (val.length() == 6) {
            _logger.info("Case number validated");
        } else {
            String msg =
                "Enter a Valid Case Number with 6 digit Number Format";
            FacesMessage Message = new FacesMessage(msg);
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }


    public void setAppealUpFileBind(RichInputFile appealUpFileBind) {
        this.appealUpFileBind = appealUpFileBind;
    }

    public RichInputFile getAppealUpFileBind() {
        return appealUpFileBind;
    }

    public void setFineretreqUpFileBind(RichInputFile fineretreqUpFileBind) {
        this.fineretreqUpFileBind = fineretreqUpFileBind;
    }

    public RichInputFile getFineretreqUpFileBind() {
        return fineretreqUpFileBind;
    }

    public void setLawyerprfUpFileBind(RichInputFile lawyerprfUpFileBind) {
        this.lawyerprfUpFileBind = lawyerprfUpFileBind;
    }

    public RichInputFile getLawyerprfUpFileBind() {
        return lawyerprfUpFileBind;
    }

    public void setColdocUpFileBind(RichInputFile coldocUpFileBind) {
        this.coldocUpFileBind = coldocUpFileBind;
    }

    public RichInputFile getColdocUpFileBind() {
        return coldocUpFileBind;
    }

    public void setPayfineUpFileBind(RichInputFile payfineUpFileBind) {
        this.payfineUpFileBind = payfineUpFileBind;
    }

    public RichInputFile getPayfineUpFileBind() {
        return payfineUpFileBind;
    }

    public void PayFineImpCourtAL(ActionEvent actionEvent) {
        pay_fine_imp_court_action();
    }

    public void setPayLawFeeFileBind(RichInputFile payLawFeeFileBind) {
        this.payLawFeeFileBind = payLawFeeFileBind;
    }

    public RichInputFile getPayLawFeeFileBind() {
        return payLawFeeFileBind;
    }

    public void PayLawFeeAL(ActionEvent actionEvent) {
        this.pay_lawyer_fee_action();
    }

    public void setProvFinPerBFileBind(RichInputFile provFinPerBFileBind) {
        this.provFinPerBFileBind = provFinPerBFileBind;
    }

    public RichInputFile getProvFinPerBFileBind() {
        return provFinPerBFileBind;
    }

    public void setRecCorpFileBind(RichInputFile recCorpFileBind) {
        this.recCorpFileBind = recCorpFileBind;
    }

    public RichInputFile getRecCorpFileBind() {
        return recCorpFileBind;
    }

    public void setExcBillUpFileBind(RichInputFile excBillUpFileBind) {
        this.excBillUpFileBind = excBillUpFileBind;
    }

    public RichInputFile getExcBillUpFileBind() {
        return excBillUpFileBind;
    }

    public void setRefinmUPFilebind(RichInputFile refinmUPFilebind) {
        this.refinmUPFilebind = refinmUPFilebind;
    }

    public RichInputFile getRefinmUPFilebind() {
        return refinmUPFilebind;
    }

    public static void setLogger(ADFLogger _logger) {
        AppService._logger = _logger;
    }

    public static ADFLogger getLogger() {
        return _logger;
    }

    public void setReviewUPFilebind(RichInputFile reviewUPFilebind) {
        this.reviewUPFilebind = reviewUPFilebind;
    }

    public RichInputFile getReviewUPFilebind() {
        return reviewUPFilebind;
    }

    public void setCasecopy1UPFilebind(RichInputFile Casecopy1UPFilebind) {
        this.Casecopy1UPFilebind = Casecopy1UPFilebind;
    }

    public RichInputFile getCasecopy1UPFilebind() {
        return Casecopy1UPFilebind;
    }

    public void setCopyJudUPFilebind(RichInputFile copyJudUPFilebind) {
        this.copyJudUPFilebind = copyJudUPFilebind;
    }

    public RichInputFile getCopyJudUPFilebind() {
        return copyJudUPFilebind;
    }

    public void setCpynsoUPFilebind(RichInputFile cpynsoUPFilebind) {
        this.cpynsoUPFilebind = cpynsoUPFilebind;
    }

    public RichInputFile getCpynsoUPFilebind() {
        return cpynsoUPFilebind;
    }

    public void setAdjSndUPFilebind(RichInputFile AdjSndUPFilebind) {
        this.AdjSndUPFilebind = AdjSndUPFilebind;
    }

    public RichInputFile getAdjSndUPFilebind() {
        return AdjSndUPFilebind;
    }

    public void setDFlag(String dFlag) {
        this.dFlag = dFlag;
    }

    public String getDFlag() {
        return dFlag;
    }

    public String clear_action_mijm() {
        ViewObject rcmjvo =
            this.getAm().findViewObject("ReqCorrMistJudgMatView1");
        ViewObject attachvo =
            this.getAm().findViewObject("ReqAttachmentsView2");
        Row rcmjr = rcmjvo.getCurrentRow();
        System.out.println("Inserted the new rows ::   " + rcmjr);
        rcmjr.remove();
        Row rcmjr1 = rcmjvo.createRow();
        rcmjvo.insertRow(rcmjr1);
        for (int i = 0; i < attachvo.getEstimatedRowCount(); i++) {
            Row attachr = attachvo.getRowAtRangeIndex(i);
            if (attachr != null)
                attachr.remove();
        }
        return null;
    }

    public String clearDA_action() {
        ViewObject rcmjvo =
            this.getAm().findViewObject("ReqDecisionAppealView1");
        ViewObject attachvo =
            this.getAm().findViewObject("ReqAttachmentsView4");
        Row rcmjr = rcmjvo.getCurrentRow();
        System.out.println("Inserted the new rows ::   " + rcmjr);
        rcmjr.remove();
        Row rcmjr1 = rcmjvo.createRow();
        rcmjvo.insertRow(rcmjr1);
        for (int i = 0; i < attachvo.getEstimatedRowCount(); i++) {
            Row attachr = attachvo.getRowAtRangeIndex(i);
            if (attachr != null)
                attachr.remove();
        }
        return null;
    }

    public String clearDIF_action() {
        ViewObject rcmjvo =
            this.getAm().findViewObject("ReqDisburseInterpreterView1");
        ViewObject attachvo =
            this.getAm().findViewObject("ReqAttachmentsView5");
        Row rcmjr = rcmjvo.getCurrentRow();
        System.out.println("Inserted the new rows ::   " + rcmjr);
        rcmjr.remove();
        Row rcmjr1 = rcmjvo.createRow();
        rcmjvo.insertRow(rcmjr1);
        for (int i = 0; i < attachvo.getEstimatedRowCount(); i++) {
            Row attachr = attachvo.getRowAtRangeIndex(i);
            if (attachr != null)
                attachr.remove();
        }
        return null;
    }

    public String clearDM_action() {
        ViewObject rcmjvo =
            this.getAm().findViewObject("ReqDepositMoneyView1");
        ViewObject attachvo =
            this.getAm().findViewObject("ReqAttachmentsView3");
        Row rcmjr = rcmjvo.getCurrentRow();
        System.out.println("Inserted the new rows ::   " + rcmjr);
        rcmjr.remove();
        Row rcmjr1 = rcmjvo.createRow();
        rcmjvo.insertRow(rcmjr1);
        for (int i = 0; i < attachvo.getEstimatedRowCount(); i++) {
            Row attachr = attachvo.getRowAtRangeIndex(i);
            if (attachr != null)
                attachr.remove();
        }
        return null;
    }

    public String clearDEF_action() {
        ViewObject rcmjvo = this.getAm().findViewObject("ReqDisbExpFeeView1");
        ViewObject attachvo =
            this.getAm().findViewObject("ReqAttachmentsView6");
        Row rcmjr = rcmjvo.getCurrentRow();
        System.out.println("Inserted the new rows ::   " + rcmjr);
        rcmjr.remove();
        Row rcmjr1 = rcmjvo.createRow();
        rcmjvo.insertRow(rcmjr1);
        for (int i = 0; i < attachvo.getEstimatedRowCount(); i++) {
            Row attachr = attachvo.getRowAtRangeIndex(i);
            if (attachr != null)
                attachr.remove();
        }
        return null;
    }

    public String clearCD_action() {
        ViewObject rcmjvo = this.getAm().findViewObject("ReqCollectDocView1");
        ViewObject attachvo =
            this.getAm().findViewObject("ReqAttachmentsView11");
        Row rcmjr = rcmjvo.getCurrentRow();
        rcmjr.remove();
        Row rcmjr1 = rcmjvo.createRow();
        rcmjvo.insertRow(rcmjr1);
        for (int i = 0; i < attachvo.getEstimatedRowCount(); i++) {
            Row attachr = attachvo.getRowAtRangeIndex(i);
            if (attachr != null)
                attachr.remove();
        }
        return null;
    }

    public String clearECJ_action() {
        ViewObject rcmjvo =
            this.getAm().findViewObject("ReqEndCustodyJuvenileView1");
        ViewObject attachvo =
            this.getAm().findViewObject("ReqAttachmentsView7");
        Row rcmjr = rcmjvo.getCurrentRow();
        rcmjr.remove();
        Row rcmjr1 = rcmjvo.createRow();
        rcmjvo.insertRow(rcmjr1);
        for (int i = 0; i < attachvo.getEstimatedRowCount(); i++) {
            Row attachr = attachvo.getRowAtRangeIndex(i);
            if (attachr != null)
                attachr.remove();
        }
        return null;
    }

    public String clearCMJM_action() {
        ViewObject rcmjvo =
            this.getAm().findViewObject("ReqCorrMistJudgMatView1");
        ViewObject attachvo =
            this.getAm().findViewObject("ReqAttachmentsView2");
        Row rcmjr = rcmjvo.getCurrentRow();
        rcmjr.remove();
        Row rcmjr1 = rcmjvo.createRow();
        rcmjvo.insertRow(rcmjr1);
        for (int i = 0; i < attachvo.getEstimatedRowCount(); i++) {
            Row attachr = attachvo.getRowAtRangeIndex(i);
            if (attachr != null)
                attachr.remove();
        }
        return null;
    }

    public String clearRPF_action() {
        ViewObject rcmjvo =
            this.getAm().findViewObject("ReqPayFineImpcourtView1");
        ViewObject attachvo =
            this.getAm().findViewObject("ReqAttachmentsView12");
        Row rcmjr = rcmjvo.getCurrentRow();
        rcmjr.remove();
        Row rcmjr1 = rcmjvo.createRow();
        rcmjvo.insertRow(rcmjr1);
        for (int i = 0; i < attachvo.getEstimatedRowCount(); i++) {
            Row attachr = attachvo.getRowAtRangeIndex(i);
            if (attachr != null)
                attachr.remove();
        }
        return null;
    }

    public String clearRPLF_action() {
        ViewObject rcmjvo =
            this.getAm().findViewObject("ReqPayLawyerFeeView1");
        ViewObject attachvo =
            this.getAm().findViewObject("ReqAttachmentsView13");
        Row rcmjr = rcmjvo.getCurrentRow();
        rcmjr.remove();
        Row rcmjr1 = rcmjvo.createRow();
        rcmjvo.insertRow(rcmjr1);
        for (int i = 0; i < attachvo.getEstimatedRowCount(); i++) {
            Row attachr = attachvo.getRowAtRangeIndex(i);
            if (attachr != null)
                attachr.remove();
        }
        return null;
    }

    public String clearPFPB_action() {
        ViewObject rcmjvo =
            this.getAm().findViewObject("ReqProFinPerBailView1");
        ViewObject attachvo =
            this.getAm().findViewObject("ReqAttachmentsView14");
        Row rcmjr = rcmjvo.getCurrentRow();
        rcmjr.remove();
        Row rcmjr1 = rcmjvo.createRow();
        rcmjvo.insertRow(rcmjr1);
        for (int i = 0; i < attachvo.getEstimatedRowCount(); i++) {
            Row attachr = attachvo.getRowAtRangeIndex(i);
            if (attachr != null)
                attachr.remove();
        }
        return null;
    }

    public String clearRv_action() {
        ViewObject rcmjvo = this.getAm().findViewObject("ReqReviewView1");
        ViewObject attachvo =
            this.getAm().findViewObject("ReqAttachmentsView18");
        Row rcmjr = rcmjvo.getCurrentRow();
        rcmjr.remove();
        Row rcmjr1 = rcmjvo.createRow();
        rcmjvo.insertRow(rcmjr1);
        for (int i = 0; i < attachvo.getEstimatedRowCount(); i++) {
            Row attachr = attachvo.getRowAtRangeIndex(i);
            if (attachr != null)
                attachr.remove();
        }
        return null;
    }

    public String clearExBill_action() {
        ViewObject rcmjvo = this.getAm().findViewObject("ReqExcBillView1");
        ViewObject attachvo =
            this.getAm().findViewObject("ReqAttachmentsView16");
        Row rcmjr = rcmjvo.getCurrentRow();
        rcmjr.remove();
        Row rcmjr1 = rcmjvo.createRow();
        rcmjvo.insertRow(rcmjr1);
        for (int i = 0; i < attachvo.getEstimatedRowCount(); i++) {
            Row attachr = attachvo.getRowAtRangeIndex(i);
            if (attachr != null)
                attachr.remove();
        }
        return null;
    }

    public String clearRfMent_action() {
        ViewObject rcmjvo =
            this.getAm().findViewObject("ReqReferralInmateView1");
        ViewObject attachvo =
            this.getAm().findViewObject("ReqAttachmentsView17");
        Row rcmjr = rcmjvo.getCurrentRow();
        rcmjr.remove();
        Row rcmjr1 = rcmjvo.createRow();
        rcmjvo.insertRow(rcmjr1);
        for (int i = 0; i < attachvo.getEstimatedRowCount(); i++) {
            Row attachr = attachvo.getRowAtRangeIndex(i);
            if (attachr != null)
                attachr.remove();
        }
        return null;
    }

    public String clearCCopy_action() {
        ViewObject rcmjvo = this.getAm().findViewObject("ReqCasecopy1View1");
        ViewObject attachvo =
            this.getAm().findViewObject("ReqAttachmentsView19");
        Row rcmjr = rcmjvo.getCurrentRow();
        rcmjr.remove();
        Row rcmjr1 = rcmjvo.createRow();
        rcmjvo.insertRow(rcmjr1);
        for (int i = 0; i < attachvo.getEstimatedRowCount(); i++) {
            Row attachr = attachvo.getRowAtRangeIndex(i);
            if (attachr != null)
                attachr.remove();
        }
        return null;
    }

    public String clearCopyJud_action() {
        ViewObject rcmjvo = this.getAm().findViewObject("ReqCopyJudgeView1");
        ViewObject attachvo =
            this.getAm().findViewObject("ReqAttachmentsView20");
        Row rcmjr = rcmjvo.getCurrentRow();
        rcmjr.remove();
        Row rcmjr1 = rcmjvo.createRow();
        rcmjvo.insertRow(rcmjr1);
        for (int i = 0; i < attachvo.getEstimatedRowCount(); i++) {
            Row attachr = attachvo.getRowAtRangeIndex(i);
            if (attachr != null)
                attachr.remove();
        }
        return null;
    }

    public String clearCpyNsOrder_action() {
        ViewObject rcmjvo = this.getAm().findViewObject("ReqCpyNsOrdrView1");
        ViewObject attachvo =
            this.getAm().findViewObject("ReqAttachmentsView21");
        Row rcmjr = rcmjvo.getCurrentRow();
        rcmjr.remove();
        Row rcmjr1 = rcmjvo.createRow();
        rcmjvo.insertRow(rcmjr1);
        for (int i = 0; i < attachvo.getEstimatedRowCount(); i++) {
            Row attachr = attachvo.getRowAtRangeIndex(i);
            if (attachr != null)
                attachr.remove();
        }
        return null;
    }

    public String clearAdjSesNewDte_action() {
        ViewObject rcmjvo = this.getAm().findViewObject("ReqAdjSfndView1");
        ViewObject attachvo =
            this.getAm().findViewObject("ReqAttachmentsView20");
        Row rcmjr = rcmjvo.getCurrentRow();
        rcmjr.remove();
        Row rcmjr1 = rcmjvo.createRow();
        rcmjvo.insertRow(rcmjr1);
        for (int i = 0; i < attachvo.getEstimatedRowCount(); i++) {
            Row attachr = attachvo.getRowAtRangeIndex(i);
            if (attachr != null)
                attachr.remove();
        }
        return null;
    }

    public String clearApp_action() {
        try {
            ViewObject rcmjvo = this.getAm().findViewObject("ReqAppealView1");
            ViewObject attachvo =
                this.getAm().findViewObject("ReqAttachmentsView8");
            Row rcmjr = rcmjvo.getCurrentRow();
            rcmjr.remove();
            Row rcmjr1 = rcmjvo.createRow();
            rcmjvo.insertRow(rcmjr1);
            for (int i = 0; i < attachvo.getEstimatedRowCount(); i++) {
                Row attachr = attachvo.getRowAtRangeIndex(i);
                if (attachr != null)
                    attachr.remove();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String clearFRR_action() {
        ViewObject rcmjvo =
            this.getAm().findViewObject("ReqFineRetreivalRequestView1");
        ViewObject attachvo =
            this.getAm().findViewObject("ReqAttachmentsView9");
        Row rcmjr = rcmjvo.getCurrentRow();
        rcmjr.remove();
        Row rcmjr1 = rcmjvo.createRow();
        rcmjvo.insertRow(rcmjr1);
        for (int i = 0; i < attachvo.getEstimatedRowCount(); i++) {
            Row attachr = attachvo.getRowAtRangeIndex(i);
            if (attachr != null)
                attachr.remove();
        }
        return null;
    }

    public String clearLPR_action() {
        ViewObject rcmjvo =
            this.getAm().findViewObject("ReqLawyerProfileReqView1");
        ViewObject attachvo =
            this.getAm().findViewObject("ReqAttachmentsView10");
        Row rcmjr = rcmjvo.getCurrentRow();
        rcmjr.remove();
        Row rcmjr1 = rcmjvo.createRow();
        rcmjvo.insertRow(rcmjr1);
        for (int i = 0; i < attachvo.getEstimatedRowCount(); i++) {
            Row attachr = attachvo.getRowAtRangeIndex(i);
            if (attachr != null)
                attachr.remove();
        }
        return null;
    }

    public String clearRC_action() {
        ViewObject rcmjvo = this.getAm().findViewObject("ReqRecCorpseView1");
        ViewObject attachvo =
            this.getAm().findViewObject("ReqAttachmentsView15");
        Row rcmjr = rcmjvo.getCurrentRow();
        rcmjr.remove();
        Row rcmjr1 = rcmjvo.createRow();
        rcmjvo.insertRow(rcmjr1);
        for (int i = 0; i < attachvo.getEstimatedRowCount(); i++) {
            Row attachr = attachvo.getRowAtRangeIndex(i);
            if (attachr != null)
                attachr.remove();
        }
        return null;
    }

    public String clearDciDue_action() {
        ViewObject rcmjvo =
            this.getAm().findViewObject("ReqDciPrescriptionView1");
        ViewObject attachvo =
            this.getAm().findViewObject("ReqAttachmentsView23");
        Row rcmjr = rcmjvo.getCurrentRow();
        rcmjr.remove();
        Row rcmjr1 = rcmjvo.createRow();
        rcmjvo.insertRow(rcmjr1);
        for (int i = 0; i < attachvo.getEstimatedRowCount(); i++) {
            Row attachr = attachvo.getRowAtRangeIndex(i);
            if (attachr != null)
                attachr.remove();
        }
        return null;
    }

    public String clearExhumation_action() {
        ViewObject rcmjvo = this.getAm().findViewObject("ReqExhumationView1");
        ViewObject attachvo =
            this.getAm().findViewObject("ReqAttachmentsView24");
        Row rcmjr = rcmjvo.getCurrentRow();
        rcmjr.remove();
        Row rcmjr1 = rcmjvo.createRow();
        rcmjvo.insertRow(rcmjr1);
        for (int i = 0; i < attachvo.getEstimatedRowCount(); i++) {
            Row attachr = attachvo.getRowAtRangeIndex(i);
            if (attachr != null)
                attachr.remove();
        }
        return null;
    }

    public String clearEoPCase_action() {
        ViewObject rcmjvo = this.getAm().findViewObject("EopCaseView1");
        ViewObject attachvo =
            this.getAm().findViewObject("ReqAttachmentsView24");
        Row rcmjr = rcmjvo.getCurrentRow();
        rcmjr.remove();
        Row rcmjr1 = rcmjvo.createRow();
        rcmjvo.insertRow(rcmjr1);
        for (int i = 0; i < attachvo.getEstimatedRowCount(); i++) {
            Row attachr = attachvo.getRowAtRangeIndex(i);
            if (attachr != null)
                attachr.remove();
        }
        return null;
    }

    public String clearFdReimbursemen_action() {
        ViewObject rcmjvo =
            this.getAm().findViewObject("ReqFdReimbursemenView1");
        ViewObject attachvo =
            this.getAm().findViewObject("ReqAttachmentsView26" + "");
        Row rcmjr = rcmjvo.getCurrentRow();
        rcmjr.remove();
        Row rcmjr1 = rcmjvo.createRow();
        rcmjvo.insertRow(rcmjr1);
        for (int i = 0; i < attachvo.getEstimatedRowCount(); i++) {
            Row attachr = attachvo.getRowAtRangeIndex(i);
            if (attachr != null)
                attachr.remove();
        }
        return null;
    }

    public String clearMeetProc_action() {
        ViewObject rcmjvo =
            this.getAm().findViewObject("ReqMeetProCheifView1");
        ViewObject attachvo =
            this.getAm().findViewObject("ReqAttachmentsView27" + "");
        Row rcmjr = rcmjvo.getCurrentRow();
        rcmjr.remove();
        Row rcmjr1 = rcmjvo.createRow();
        rcmjvo.insertRow(rcmjr1);
        for (int i = 0; i < attachvo.getEstimatedRowCount(); i++) {
            Row attachr = attachvo.getRowAtRangeIndex(i);
            if (attachr != null)
                attachr.remove();
        }
        return null;
    }

    public String clearOpenOfMem_action() {
        ViewObject rcmjvo =
            this.getAm().findViewObject("ReqOpeningOdMemView1");
        ViewObject attachvo =
            this.getAm().findViewObject("ReqAttachmentsView28");
        Row rcmjr = rcmjvo.getCurrentRow();
        rcmjr.remove();
        Row rcmjr1 = rcmjvo.createRow();
        rcmjvo.insertRow(rcmjr1);
        for (int i = 0; i < attachvo.getEstimatedRowCount(); i++) {
            Row attachr = attachvo.getRowAtRangeIndex(i);
            if (attachr != null)
                attachr.remove();
        }
        return null;
    }

    public String clearPPRenewal_action() {
        ViewObject rcmjvo =
            this.getAm().findViewObject("ReqPportrenewalView1");
        ViewObject attachvo =
            this.getAm().findViewObject("ReqAttachmentsView29");
        Row rcmjr = rcmjvo.getCurrentRow();
        /* System.out.println("Current row obtained :: " +
                           rcmjr.getAttribute("ReqId"));
        rcmjr.setAttribute("CaseNo", "");
        rcmjr.setAttribute("CaseYear", "");
         rcmjr.setAttribute("Prosecutionname", "");
        rcmjr.setAttribute("Relationcase", "");
        rcmjr.refresh(oracle.jbo.Row.REFRESH_UNDO_CHANGES |
                      Row.REFRESH_FORGET_NEW_ROWS);*/
        rcmjr.remove();
        Row rcmjr1 = rcmjvo.createRow();
        rcmjvo.insertRow(rcmjr1);
        for (int i = 0; i < attachvo.getEstimatedRowCount(); i++) {
            Row attachr = attachvo.getRowAtRangeIndex(i);
            if (attachr != null)
                attachr.remove();
        }
        return null;
    }

    public String clearPaymentinsCourt_action() {
        ViewObject rcmjvo =
            this.getAm().findViewObject("ReqPaymentinsCourtView1");
        ViewObject attachvo =
            this.getAm().findViewObject("ReqAttachmentsView30" + "");
        Row rcmjr = rcmjvo.getCurrentRow();
        rcmjr.remove();
        Row rcmjr1 = rcmjvo.createRow();
        rcmjvo.insertRow(rcmjr1);
        for (int i = 0; i < attachvo.getEstimatedRowCount(); i++) {
            Row attachr = attachvo.getRowAtRangeIndex(i);
            if (attachr != null)
                attachr.remove();
        }
        return null;
    }

    public String clearPcopyDropDec_action() {
        ViewObject rcmjvo =
            this.getAm().findViewObject("ReqPcopyCasedropingDecView1");
        ViewObject attachvo =
            this.getAm().findViewObject("ReqAttachmentsView31" + "");
        Row rcmjr = rcmjvo.getCurrentRow();
        rcmjr.remove();
        Row rcmjr1 = rcmjvo.createRow();
        rcmjvo.insertRow(rcmjr1);
        for (int i = 0; i < attachvo.getEstimatedRowCount(); i++) {
            Row attachr = attachvo.getRowAtRangeIndex(i);
            if (attachr != null)
                attachr.remove();
        }
        return null;
    }

    public String clearPostponeFreedom_action() {
        ViewObject rcmjvo =
            this.getAm().findViewObject("ReqPostponeOfFreedomView1");
        ViewObject attachvo =
            this.getAm().findViewObject("ReqAttachmentsView32" + "");
        Row rcmjr = rcmjvo.getCurrentRow();
        rcmjr.remove();
        Row rcmjr1 = rcmjvo.createRow();
        rcmjvo.insertRow(rcmjr1);
        for (int i = 0; i < attachvo.getEstimatedRowCount(); i++) {
            Row attachr = attachvo.getRowAtRangeIndex(i);
            if (attachr != null)
                attachr.remove();
        }
        return null;
    }

    public String clearRecdeopchrg_action() {
        ViewObject rcmjvo =
            this.getAm().findViewObject("ReqRecvDepositChargesView1");
        ViewObject attachvo =
            this.getAm().findViewObject("ReqAttachmentsView33");
        Row rcmjr = rcmjvo.getCurrentRow();
        System.out.println("................////////////////////...................." +
                           rcmjr);
        rcmjr.remove();
        Row rcmjr1 = rcmjvo.createRow();
        rcmjvo.insertRow(rcmjr1);
        for (int i = 0; i < attachvo.getEstimatedRowCount(); i++) {
            Row attachr = attachvo.getRowAtRangeIndex(i);
            if (attachr != null)
                attachr.remove();
        }
        return null;
    }

    public void setDciDueUPFilebind(RichInputFile DciDueUPFilebind) {
        this.DciDueUPFilebind = DciDueUPFilebind;
    }

    public RichInputFile getDciDueUPFilebind() {
        return DciDueUPFilebind;
    }

    public void setLoginPopupBind(RichPopup loginPopupBind) {
        this.loginPopupBind = loginPopupBind;
    }

    public RichPopup getLoginPopupBind() {
        return loginPopupBind;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDob() {
        return dob;
    }

    public void setGdob(String gdob) {
        this.gdob = gdob;
    }

    public String getGdob() {
        return gdob;
    }

    public void setExhumationUPFilebind(RichInputFile ExhumationUPFilebind) {
        this.ExhumationUPFilebind = ExhumationUPFilebind;
    }

    public RichInputFile getExhumationUPFilebind() {
        return ExhumationUPFilebind;
    }

    public void setEoPCaseUPFilebind(RichInputFile EoPCaseUPFilebind) {
        this.EoPCaseUPFilebind = EoPCaseUPFilebind;
    }

    public RichInputFile getEoPCaseUPFilebind() {
        return EoPCaseUPFilebind;
    }

    public void setFdreimburUPFilebind(RichInputFile FdreimburUPFilebind) {
        this.FdreimburUPFilebind = FdreimburUPFilebind;
    }

    public RichInputFile getFdreimburUPFilebind() {
        return FdreimburUPFilebind;
    }

    public void setMeetProcUPFilebind(RichInputFile MeetProcUPFilebind) {
        this.MeetProcUPFilebind = MeetProcUPFilebind;
    }

    public RichInputFile getMeetProcUPFilebind() {
        return MeetProcUPFilebind;
    }

    public String clearWaiEncl_action() {
        ViewObject rcmjvo = this.getAm().findViewObject("ReqWaiverEnclView1");
        ViewObject attachvo =
            this.getAm().findViewObject("ReqAttachmentsViewWE");
        Row rcmjr = rcmjvo.getCurrentRow();
        rcmjr.remove();
        Row rcmjr1 = rcmjvo.createRow();
        rcmjvo.insertRow(rcmjr1);
        for (int i = 0; i < attachvo.getEstimatedRowCount(); i++) {
            Row attachr = attachvo.getRowAtRangeIndex(i);
            if (attachr != null)
                attachr.remove();
        }
        return null;
    }

    public String Waiv_Encl_action() {
        String key = (String)afu.evaluateEL("#{pageFlowScope.key}");
        Locale localel = (Locale)afu.evaluateEL("#{pageFlowScope.locale}");
        String locale = localel.toString();
        String s = "Y";
        ViewObject caseinfovo = getAm().findViewObject("ReqCaseInfoView1");
        ViewObject reqview = getAm().findViewObject("ReqRequestsViewWE");
        ViewObject corrmistvo = getAm().findViewObject("ReqWaiverEnclView1");
        Row corrmistr = corrmistvo.getCurrentRow();
        if (corrmistr.getAttribute("CaseNo") != null &&
            corrmistr.getAttribute("CaseYear") != null &&
            corrmistr.getAttribute("Prosecutionname") != null &&
            corrmistr.getAttribute("RelationCase") != null &&
            (!corrmistr.getAttribute("Prosecutionname").equals("LOV_pn_en")) &&
            (!corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_en") &&
             corrmistr.getAttribute("AccusedName") != null)) {
            Number cno = (Number)corrmistr.getAttribute("CaseNo");
            Number cyear = (Number)corrmistr.getAttribute("CaseYear");
            String cpname = (String)corrmistr.getAttribute("Prosecutionname");
            int sid = Integer.parseInt(key);
            BigDecimal caseno = new BigDecimal(cno.toString());
            BigDecimal name = new BigDecimal(cpname.toString());
            BigDecimal year = new BigDecimal(cyear.toString());
            String res = this.validatingCase(sid, caseno, name, year);

            if (res.equals("ok")) {
                Row casinfr = caseinfovo.createRow();
                Row reqr = reqview.createRow();
                casinfr.setAttribute("CaseNumber",
                                     corrmistr.getAttribute("CaseNo"));
                casinfr.setAttribute("CaseYear",
                                     corrmistr.getAttribute("CaseYear"));
                casinfr.setAttribute("CaseType",
                                     corrmistr.getAttribute("Prosecutionname"));
                casinfr.setAttribute("Relation",
                                     corrmistr.getAttribute("RelationCase"));
                reqr.setAttribute("ReqName", setServiceNames(locale, key));
                reqr.setAttribute("CaseInfoId",
                                  casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ServiceId", sid);
                corrmistr.setAttribute("CaseInfo",
                                       casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ProsecId",
                                  corrmistr.getAttribute("Prosecutionname"));
                //                uploadFilewaiEnc();
                //                commit_action();
                //                sentEmail((Number)casinfr.getAttribute("CaseId"),
                //                          "Waiver Enclosure");
                //                return "Y";
                java.util.List<UploadedFile> file_u = this.getUploadedfile();
                if (file_u != null) {
                    String validateFile = validateFileUpload(file_u);
                    if (validateFile.equals("N")) {
                        for (int i = 0; i < file_u.size(); i++) {
                            Number foldern =
                                (Number)reqr.getAttribute("ReqId");
                            String foldername = foldern.toString();
                            if (i == 0) {
                                ubean.createFolder(foldername);
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadFilewaiEnc(file_u.get(i),
                                                 ubean.getDid());
                            } else {
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadFilewaiEnc(file_u.get(i),
                                                 ubean.getDid());
                            }
                        }
                    } else {
                        casinfr.remove();
                        reqr.remove();
                        s = "N";
                        FacesContext.getCurrentInstance().addMessage(upFileBind.getClientId(FacesContext.getCurrentInstance()),
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                      "File Type extension are not allowed",
                                                                                      "Kindly reload the files"));
                    }
                }
                if (s.equals("Y")) {
                    commit_action();
                    sentEmail((Number)reqr.getAttribute("ReqId"),
                              setServiceNames(locale, key), locale);
                    afu.setEL("#{pageFlowScope.casno}",
                              reqr.getAttribute("ReqId"));
                    oracle.jbo.domain.Number csid =
                        (Number)reqr.getAttribute("ReqId");
                    executeSMSproc((String)ADFContext.getCurrent().getSessionScope().get("mobile"),
                                   csid);
                    return "Y";
                }
            } else {
                return "N";
            }
        }
        if (corrmistr.getAttribute("CaseNo") == null) {
            this.setCn("Y");
        }
        if (corrmistr.getAttribute("CaseYear") == null) {
            this.setCy("Y");
        }
        if ((corrmistr.getAttribute("Prosecutionname") == null) ||
            (corrmistr.getAttribute("Prosecutionname").equals("LOV_pn_en")) ||
            (corrmistr.getAttribute("Prosecutionname").equals("LOV_pn_ar"))) {
            this.setPc("Y");
        }
        if ((corrmistr.getAttribute("RelationCase") == null) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_en")) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_ar"))) {
            this.setRc("Y");
        }
        if (corrmistr.getAttribute("AccusedName") == null) {
            this.setAcn("Y");
        }
        return null;
    }


    public String Waiv_Encl_FileUploadaction(String did) {
        ViewObject ravo = this.getAm().findViewObject("ReqAttachmentsViewWE");
        Row rar = ravo.createRow();
        rar.setAttribute("DisplayName", fileName);
        rar.setAttribute("ContentType", contentType);
        //        rar.setAttribute("Attachment", blob);
        rar.setAttribute("AttachSize", fileSize);
        rar.setAttribute("AttachDownloadUrl", ubean.downloadAttachUrl());
        ravo.insertRow(rar);
        Number attachid = (Number)rar.getAttribute("Id");
        this.insert_did(attachid, did);
        return null;
    }

    public void wai_encl_onFileUploadVCL(ValueChangeEvent vce) {
        _logger.info("Started executing file upload");
        file = (UploadedFile)vce.getNewValue();
        fileName = file.getFilename();
        contentType = file.getContentType();
        String FileExt =
            contentType.substring(contentType.lastIndexOf("/") + 1);
        if ((FileExt.equals("jpeg")) || (FileExt.equals("plain")) ||
            (FileExt.equals("msword")) || (FileExt.equals("gif")) ||
            (FileExt.equals("pdf"))) {
            blob = getBlob(file);
            long l = file.getLength();
            long kb = l / 1024;
            long mb = kb / 1024;
            fileSize = Double.toString(mb);
            if (mb < 10) {
                //                Waiv_Encl_FileUploadaction();
            } else {
                this.waivEnclUPFilebind.resetValue();
                FacesMessage Message =
                    new FacesMessage("File Size should be less than 10 MB");
                Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, Message);
            }
        } else {
            FacesMessage Message = new FacesMessage(ERR_Attach);
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public void uploadFilewaiEnc(UploadedFile file, String did) {
        fileName = file.getFilename();
        contentType = file.getContentType();
        blob = getBlob(file);
        double l = file.getLength();
        double kb = l / 1024;
        double mb = kb / 1024;
        fileSize = df2.format(kb) + " kB";
        if (mb < 10) {
            Waiv_Encl_FileUploadaction(did);
        } else {
            FacesMessage Message =
                new FacesMessage("File Size should be less than 10 MB");
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public String clearVisitProvDet_action() {
        ViewObject rcmjvo =
            this.getAm().findViewObject("ReqVisitProvDetView1");
        ViewObject attachvo =
            this.getAm().findViewObject("ReqAttachmentsViewVPD");
        Row rcmjr = rcmjvo.getCurrentRow();
        rcmjr.remove();
        Row rcmjr1 = rcmjvo.createRow();
        rcmjvo.insertRow(rcmjr1);
        for (int i = 0; i < attachvo.getEstimatedRowCount(); i++) {
            Row attachr = attachvo.getRowAtRangeIndex(i);
            if (attachr != null)
                attachr.remove();
        }
        return null;
    }

    public String visit_prov_det_action() {
        String s = "Y";
        String key = (String)afu.evaluateEL("#{pageFlowScope.key}");
        Locale localel = (Locale)afu.evaluateEL("#{pageFlowScope.locale}");
        String locale = localel.toString();
        //        String locale = "en";
        ViewObject caseinfovo = getAm().findViewObject("ReqCaseInfoView1");
        ViewObject reqview = getAm().findViewObject("ReqRequestsViewVPD");
        ViewObject corrmistvo = getAm().findViewObject("ReqVisitProvDetView1");
        ViewObject prinfoview = getAm().findViewObject("ReqPrisonerInfoView1");
        Row corrmistr = corrmistvo.getCurrentRow();
        Row prinforrow = prinfoview.getCurrentRow();
        String visit = checkVisitorsInfo();
        if (corrmistr.getAttribute("CaseNo") != null &&
            corrmistr.getAttribute("CaseYear") != null &&
            corrmistr.getAttribute("ProsecutionName") != null &&
            corrmistr.getAttribute("RelationCase") != null &&
            corrmistr.getAttribute("VisitDate") != null &&
            corrmistr.getAttribute("VisitPurpose") != null &&
            prinforrow.getAttribute("PrPrisonId") != null &&
            prinforrow.getAttribute("PrNationality") != null &&
            prinforrow.getAttribute("PrName") != null && visit.equals("N")) {
            Number cno = (Number)corrmistr.getAttribute("CaseNo");
            Number cyear = (Number)corrmistr.getAttribute("CaseYear");
            String cpname = (String)corrmistr.getAttribute("ProsecutionName");
            int sid = Integer.parseInt(key);
            BigDecimal caseno = new BigDecimal(cno.toString());
            BigDecimal name = new BigDecimal(cpname.toString());
            BigDecimal year = new BigDecimal(cyear.toString());
            String res = this.validatingCase(sid, caseno, name, year);
            if (res.equals("ok")) {
                Row casinfr = caseinfovo.createRow();
                Row reqr = reqview.createRow();
                casinfr.setAttribute("CaseNumber",
                                     corrmistr.getAttribute("CaseNo"));
                casinfr.setAttribute("CaseYear",
                                     corrmistr.getAttribute("CaseYear"));
                casinfr.setAttribute("CaseType",
                                     corrmistr.getAttribute("ProsecutionName"));
                casinfr.setAttribute("Relation",
                                     corrmistr.getAttribute("RelationCase"));
                reqr.setAttribute("ReqName", setServiceNames(locale, key));
                reqr.setAttribute("CaseInfoId",
                                  casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ServiceId", 5);
                corrmistr.setAttribute("CaseInfo",
                                       casinfr.getAttribute("CaseId"));
                corrmistr.setAttribute("PrisonerInfo",
                                       prinforrow.getAttribute("PrisonerId"));
                reqr.setAttribute("ProsecId",
                                  corrmistr.getAttribute("ProsecutionName"));
                //                uploadedFile_VisitProv();
                //                commit_action();
                //                sentEmail((Number)casinfr.getAttribute("CaseId"),
                //                          "Visiting a Provisional Detainee");
                //                return "Y";
                java.util.List<UploadedFile> file_u = this.getUploadedfile();
                if (file_u != null) {
                    String validateFile = validateFileUpload(file_u);
                    if (validateFile.equals("N")) {
                        for (int i = 0; i < file_u.size(); i++) {
                            Number foldern =
                                (Number)reqr.getAttribute("ReqId");
                            String foldername = foldern.toString();
                            if (i == 0) {
                                ubean.createFolder(foldername);
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadedFile_VisitProv(file_u.get(i),
                                                       ubean.getDid());
                            } else {
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadedFile_VisitProv(file_u.get(i),
                                                       ubean.getDid());
                            }
                        }
                    } else {
                        casinfr.remove();
                        reqr.remove();
                        s = "N";
                        FacesContext.getCurrentInstance().addMessage(upFileBind.getClientId(FacesContext.getCurrentInstance()),
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                      "File Type extension are not allowed",
                                                                                      "Kindly reload the files"));
                    }
                }
                if (s.equals("Y")) {
                    commit_action();
                    sentEmail((Number)reqr.getAttribute("ReqId"),
                              setServiceNames(locale, key), locale);
                    afu.setEL("#{pageFlowScope.casno}",
                              reqr.getAttribute("ReqId"));
                    oracle.jbo.domain.Number csid =
                        (Number)reqr.getAttribute("ReqId");
                    executeSMSproc((String)ADFContext.getCurrent().getSessionScope().get("mobile"),
                                   csid);
                    return "Y";
                }
            } else {
                return "N";
            }
        }
        if (corrmistr.getAttribute("CaseNo") == null) {
            this.setCn("Y");
        }
        if (corrmistr.getAttribute("CaseYear") == null) {
            this.setCy("Y");
        }
        if ((corrmistr.getAttribute("ProsecutionName") == null) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_en")) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_ar"))) {
            this.setPc("Y");
        }
        if ((corrmistr.getAttribute("RelationCase") == null) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_en")) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_ar"))) {
            this.setRc("Y");
        }
        if (corrmistr.getAttribute("VisitDate") == null) {
            vd = "Y";
        }
        if (corrmistr.getAttribute("VisitPurpose") == null) {
            vp = "Y";
        }
        if (prinforrow.getAttribute("PrPrisonId") == null)
            this.setPrid("Y");
        if (prinforrow.getAttribute("PrNationality") == null)
            in = "Y";
        if (prinforrow.getAttribute("PrName") == null)
            prn = "Y";
        return null;
    }

    public String checkVisitorsInfo() {
        String finares = "N";
        ViewObject visitorview =
            this.getAm().findViewObject("ReqPrisonerVisitorsInfoView1");
        for (int i = 0; i < visitorview.getEstimatedRowCount(); i++) {
            Row visitorrow = visitorview.getRowAtRangeIndex(i);
            if (visitorrow.getAttribute("VrName") == null) {
                visitInfo = "vn";
                finares = "Y";
            }
            if (visitorrow.getAttribute("VrEmail") == null) {
                vremail = "Y";
                finares = "Y";
            }
            if (visitorrow.getAttribute("VrPhone") == null) {
                vrphone = "Y";
                finares = "Y";
            }
            if (visitorrow.getAttribute("VrRelation") == null) {
                vrrelation = "Y";
                finares = "Y";
            }
        }
        return finares;
    }


    public String visit_prd_FileUploadaction(String did) {
        ViewObject ravo = this.getAm().findViewObject("ReqAttachmentsViewVPD");
        Row rar = ravo.createRow();
        rar.setAttribute("DisplayName", fileName);
        rar.setAttribute("ContentType", contentType);
        //        rar.setAttribute("Attachment", blob);
        rar.setAttribute("AttachSize", fileSize);
        rar.setAttribute("AttachDownloadUrl", ubean.downloadAttachUrl());
        ravo.insertRow(rar);
        Number attachid = (Number)rar.getAttribute("Id");
        this.insert_did(attachid, did);
        return null;
    }

    public void visit_provd_onFileUploadVCL(ValueChangeEvent vce) {
        _logger.info("Started executing file upload");
        file = (UploadedFile)vce.getNewValue();
        fileName = file.getFilename();
        contentType = file.getContentType();
        String FileExt =
            contentType.substring(contentType.lastIndexOf("/") + 1);
        if ((FileExt.equals("jpeg")) || (FileExt.equals("plain")) ||
            (FileExt.equals("msword")) || (FileExt.equals("gif")) ||
            (FileExt.equals("pdf"))) {
            blob = getBlob(file);
            long l = file.getLength();
            long kb = l / 1024;
            long mb = kb / 1024;
            fileSize = Double.toString(mb);
            if (mb < 10) {
                //                visit_prd_FileUploadaction();
            } else {
                this.VisitPrDUPFilebind.resetValue();
                FacesMessage Message =
                    new FacesMessage("File Size should be less than 10 MB");
                Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, Message);
            }
        } else {
            FacesMessage Message = new FacesMessage(ERR_Attach);
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public void uploadedFile_VisitProv(UploadedFile file, String did) {
        fileName = file.getFilename();
        contentType = file.getContentType();
        blob = getBlob(file);
        double l = file.getLength();
        double kb = l / 1024;
        double mb = kb / 1024;
        fileSize = df2.format(kb) + " kB";
        if (mb < 10) {
            visit_prd_FileUploadaction(did);
        } else {
            FacesMessage Message =
                new FacesMessage("File Size should be less than 10 MB");
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    //<------------------------------------------------------------ Submit an Objection------------------------------------------------------>

    public String clearsub_obj_action() {
        ViewObject rcmjvo = this.getAm().findViewObject("ReqSubObjView1");
        ViewObject attachvo =
            this.getAm().findViewObject("ReqAttachmentsViewSO");
        Row rcmjr = rcmjvo.getCurrentRow();
        rcmjr.remove();
        Row rcmjr1 = rcmjvo.createRow();
        rcmjvo.insertRow(rcmjr1);
        for (int i = 0; i < attachvo.getEstimatedRowCount(); i++) {
            Row attachr = attachvo.getRowAtRangeIndex(i);
            if (attachr != null)
                attachr.remove();
        }
        return null;
    }

    public String sub_obj_action() {
        String key = (String)afu.evaluateEL("#{pageFlowScope.key}");
        Locale localel = (Locale)afu.evaluateEL("#{pageFlowScope.locale}");
        String locale = localel.toString();
        if (key.equals("38")) {
            String s = "Y";
            ViewObject caseinfovo = getAm().findViewObject("ReqCaseInfoView1");
            ViewObject reqview = getAm().findViewObject("ReqRequestsViewSO");
            ViewObject corrmistvo = getAm().findViewObject("ReqSubObjView1");
            Row corrmistr = corrmistvo.getCurrentRow();
            if (corrmistr.getAttribute("CaseNo") != null &&
                corrmistr.getAttribute("CaseYear") != null &&
                corrmistr.getAttribute("ProsecutionName") != null &&
                corrmistr.getAttribute("RelationCase") != null &&
                (!corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_en")) &&
                (!corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_en"))) {
                Number cno = (Number)corrmistr.getAttribute("CaseNo");
                Number cyear = (Number)corrmistr.getAttribute("CaseYear");
                String cpname =
                    (String)corrmistr.getAttribute("ProsecutionName");
                int sid = Integer.parseInt(key);
                BigDecimal caseno = new BigDecimal(cno.toString());
                BigDecimal name = new BigDecimal(cpname.toString());
                BigDecimal year = new BigDecimal(cyear.toString());
                String res = this.validatingCase(sid, caseno, name, year);
                if (res.equals("ok")) {
                    Row casinfr = caseinfovo.createRow();
                    Row reqr = reqview.createRow();
                    casinfr.setAttribute("CaseNumber",
                                         corrmistr.getAttribute("CaseNo"));
                    casinfr.setAttribute("CaseYear",
                                         corrmistr.getAttribute("CaseYear"));
                    casinfr.setAttribute("CaseType",
                                         corrmistr.getAttribute("ProsecutionName"));
                    casinfr.setAttribute("Relation",
                                         corrmistr.getAttribute("RelationCase"));
                    reqr.setAttribute("CaseInfoId",
                                      casinfr.getAttribute("CaseId"));
                    corrmistr.setAttribute("CaseInfo",
                                           casinfr.getAttribute("CaseId"));
                    reqr.setAttribute("ProsecId",
                                      corrmistr.getAttribute("ProsecutionName"));

                    Number keynum = new Number(Integer.parseInt(key));
                    reqr.setAttribute("ServiceId", keynum);
                    corrmistr.setAttribute("CaseInfo",
                                           casinfr.getAttribute("CaseId"));
                    reqr.setAttribute("ProsecId",
                                      corrmistr.getAttribute("ProsecutionName"));

                    reqr.setAttribute("ReqName", setServiceNames(locale, key));

                    //                uploadFile_SubmObj();
                    //                commit_action();
                    //                sentEmail((Number)casinfr.getAttribute("CaseId"),
                    //                          "Providing an objection");
                    //                return "Y";
                    BigDecimal rid =
                        (BigDecimal)corrmistr.getAttribute("ReqId");
                    java.util.List<UploadedFile> file_u =
                        this.getUploadedfile();
                    if (file_u != null) {
                        String validateFile = validateFileUpload(file_u);
                        if (validateFile.equals("N")) {
                            for (int i = 0; i < file_u.size(); i++) {
                                Number foldern =
                                    (Number)reqr.getAttribute("ReqId");
                                String foldername = foldern.toString();
                                if (i == 0) {
                                    ubean.createFolder(foldername);
                                    ubean.uploadedFile(foldername,
                                                       file_u.get(i),
                                                       foldername);
                                    uploadFile_SubmObj(file_u.get(i),
                                                       ubean.getDid(), rid);
                                } else {
                                    ubean.uploadedFile(foldername,
                                                       file_u.get(i),
                                                       foldername);
                                    uploadFile_SubmObj(file_u.get(i),
                                                       ubean.getDid(), rid);
                                }
                            }
                        } else {
                            casinfr.remove();
                            reqr.remove();
                            s = "N";
                            FacesContext.getCurrentInstance().addMessage(upFileBind.getClientId(FacesContext.getCurrentInstance()),
                                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                          "File Type extension are not allowed",
                                                                                          "Kindly reload the files"));
                        }
                    }
                    if (s.equals("Y")) {
                        commit_action();
                        sentEmail((Number)reqr.getAttribute("ReqId"),
                                  setServiceNames(locale, key), locale);
                        afu.setEL("#{pageFlowScope.casno}",
                                  reqr.getAttribute("ReqId"));
                        oracle.jbo.domain.Number csid =
                            (Number)reqr.getAttribute("ReqId");
                        executeSMSproc((String)ADFContext.getCurrent().getSessionScope().get("mobile"),
                                       csid);
                        return "Y";
                    }
                }

                else {
                    if (!res.equals(""))
                        return "NotAllowed";
                    else
                        return "N";
                }
            }
            if (corrmistr.getAttribute("CaseNo") == null) {
                this.setCn("Y");
            }
            if (corrmistr.getAttribute("CaseYear") == null) {
                this.setCy("Y");
            }
            if ((corrmistr.getAttribute("ProsecutionName") == null) ||
                (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_en")) ||
                (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_ar"))) {
                this.setPc("Y");
            }
            if ((corrmistr.getAttribute("RelationCase") == null) ||
                (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_en")) ||
                (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_ar"))) {
                this.setRc("Y");
            }
        } else {
            String ret = proAnObj(key, locale);
            System.out.println(ret);
            return ret;
        }
        return null;
    }

    public String proAnObj(String key, String locale) {
        String s = "Y";
        ViewObject caseinfovo = getAm().findViewObject("ReqCaseInfoView1");
        ViewObject reqview = getAm().findViewObject("ReqRequestsProOb");
        ViewObject provAnObjView =
            getAm().findViewObject("ReqSubmitAnObjectionView1");
        ViewObject corrmistvo = getAm().findViewObject("ReqSubObjView1");
        Row corrmistr = corrmistvo.getCurrentRow();
        if (corrmistr.getAttribute("CaseNo") != null &&
            corrmistr.getAttribute("CaseYear") != null &&
            corrmistr.getAttribute("ProsecutionName") != null &&
            corrmistr.getAttribute("RelationCase") != null &&
            (!corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_en")) &&
            (!corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_en"))) {

            Number cno = (Number)corrmistr.getAttribute("CaseNo");
            Number cyear = (Number)corrmistr.getAttribute("CaseYear");
            String cpname = (String)corrmistr.getAttribute("ProsecutionName");
            int sid = Integer.parseInt(key);
            BigDecimal caseno = new BigDecimal(cno.toString());
            BigDecimal name = new BigDecimal(cpname.toString());
            BigDecimal year = new BigDecimal(cyear.toString());
            String res = this.validatingCase(sid, caseno, name, year);
            if (res.equals("ok")) {
                Row casinfr = caseinfovo.createRow();
                Row reqr = reqview.createRow();
                Row provAnObjRow = provAnObjView.createRow();
                provAnObjRow.setAttribute("CaseInfo",
                                          casinfr.getAttribute("CaseId"));
                provAnObjRow.setAttribute("SentenseDate",
                                          corrmistr.getAttribute("SentenceDate"));
                casinfr.setAttribute("CaseNumber",
                                     corrmistr.getAttribute("CaseNo"));
                casinfr.setAttribute("CaseYear",
                                     corrmistr.getAttribute("CaseYear"));
                casinfr.setAttribute("CaseType",
                                     corrmistr.getAttribute("ProsecutionName"));
                casinfr.setAttribute("Relation",
                                     corrmistr.getAttribute("RelationCase"));
                reqr.setAttribute("CaseInfoId",
                                  casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ReqId", provAnObjRow.getAttribute("ReqId"));
                //                corrmistr.setAttribute("CaseInfo",
                //                                       casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ProsecId",
                                  corrmistr.getAttribute("ProsecutionName"));

                Number keynum = new Number(Integer.parseInt(key));
                reqr.setAttribute("ServiceId", keynum);
                //                corrmistr.setAttribute("CaseInfo",
                //                                       casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ProsecId",
                                  corrmistr.getAttribute("ProsecutionName"));

                reqr.setAttribute("ReqName", setServiceNames(locale, key));

                //                uploadFile_SubmObj();
                //                commit_action();
                //                sentEmail((Number)casinfr.getAttribute("CaseId"),
                //                          "Providing an objection");
                //                return "Y";
                System.out.println("Request ID for submit an objection :: " +
                                   provAnObjRow.getAttribute("ReqId"));
                BigDecimal rid =
                    (BigDecimal)provAnObjRow.getAttribute("ReqId");
                java.util.List<UploadedFile> file_u = this.getUploadedfile();
                if (file_u != null) {
                    String validateFile = validateFileUpload(file_u);
                    if (validateFile.equals("N")) {
                        for (int i = 0; i < file_u.size(); i++) {
                            Number foldern =
                                (Number)reqr.getAttribute("ReqId");
                            String foldername = foldern.toString();
                            if (i == 0) {
                                ubean.createFolder(foldername);
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadFile_SubmObj(file_u.get(i),
                                                   ubean.getDid(), rid);
                            } else {
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadFile_SubmObj(file_u.get(i),
                                                   ubean.getDid(), rid);
                            }
                        }
                    } else {
                        casinfr.remove();
                        reqr.remove();
                        s = "N";
                        FacesContext.getCurrentInstance().addMessage(upFileBind.getClientId(FacesContext.getCurrentInstance()),
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                      "File Type extension are not allowed",
                                                                                      "Kindly reload the files"));
                    }
                }
                if (s.equals("Y")) {
                    commit_action();
                    sentEmail((Number)reqr.getAttribute("ReqId"),
                              setServiceNames(locale, key), locale);
                    afu.setEL("#{pageFlowScope.casno}",
                              reqr.getAttribute("ReqId"));
                    oracle.jbo.domain.Number csid =
                        (Number)reqr.getAttribute("ReqId");
                    executeSMSproc((String)ADFContext.getCurrent().getSessionScope().get("mobile"),
                                   csid);
                    return "Y";
                }
            }

            else {
                return "N";
            }
        }
        if (corrmistr.getAttribute("CaseNo") == null) {
            this.setCn("Y");
        }
        if (corrmistr.getAttribute("CaseYear") == null) {
            this.setCy("Y");
        }
        if ((corrmistr.getAttribute("ProsecutionName") == null) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_en")) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_ar"))) {
            this.setPc("Y");
        }
        if ((corrmistr.getAttribute("RelationCase") == null) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_en")) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_ar"))) {
            this.setRc("Y");
        }
        return null;
    }


    public String sub_obj_FileUploadaction(String did, BigDecimal rid) {
        ViewObject ravo = this.getAm().findViewObject("ReqAttachmentsProOb");
        Row rar = ravo.createRow();
        rar.setAttribute("DisplayName", fileName);
        rar.setAttribute("ContentType", contentType);
        rar.setAttribute("AttachSize", fileSize);
        rar.setAttribute("ReqId", rid);
        rar.setAttribute("AttachDownloadUrl", ubean.downloadAttachUrl());
        ravo.insertRow(rar);
        Number attachid = (Number)rar.getAttribute("Id");
        this.insert_did(attachid, did);
        return null;
    }

    public void sub_obj_onFileUploadVCL(ValueChangeEvent vce) {
        _logger.info("Started executing file upload");
        file = (UploadedFile)vce.getNewValue();
        fileName = file.getFilename();
        contentType = file.getContentType();
        String FileExt =
            contentType.substring(contentType.lastIndexOf("/") + 1);
        if ((FileExt.equals("jpeg")) || (FileExt.equals("plain")) ||
            (FileExt.equals("msword")) || (FileExt.equals("gif")) ||
            (FileExt.equals("pdf"))) {
            blob = getBlob(file);
            long l = file.getLength();
            long kb = l / 1024;
            long mb = kb / 1024;
            fileSize = Double.toString(mb);
            if (mb < 10) {
                //                sub_obj_FileUploadaction();
            } else {
                this.SubObjUPFilebind.resetValue();
                FacesMessage Message =
                    new FacesMessage("File Size should be less than 10 MB");
                Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, Message);
            }
        } else {
            FacesMessage Message = new FacesMessage(ERR_Attach);
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public void uploadFile_SubmObj(UploadedFile file, String did,
                                   BigDecimal rid) {
        fileName = file.getFilename();
        contentType = file.getContentType();
        blob = getBlob(file);
        double l = file.getLength();
        double kb = l / 1024;
        double mb = kb / 1024;
        fileSize = df2.format(kb) + " kB";
        if (mb < 10) {
            sub_obj_FileUploadaction(did, rid);
        } else {
            FacesMessage Message =
                new FacesMessage("File Size should be less than 10 MB");
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public void uploadFile_proObj(UploadedFile file, String did,
                                  BigDecimal rid) {
        fileName = file.getFilename();
        contentType = file.getContentType();
        blob = getBlob(file);
        double l = file.getLength();
        double kb = l / 1024;
        double mb = kb / 1024;
        fileSize = df2.format(kb) + " kB";
        if (mb < 10) {
            sub_obj_FileUploadaction(did, rid);
        } else {
            FacesMessage Message =
                new FacesMessage("File Size should be less than 10 MB");
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    //<------------------------------------------------------------ Subscribing in SMS Service------------------------------------------------------>

    public String clearsub_sms_action() {
        ViewObject rcmjvo = this.getAm().findViewObject("ReqSubSmsView1");
        ViewObject attachvo =
            this.getAm().findViewObject("ReqAttachmentsViewSS");
        Row rcmjr = rcmjvo.getCurrentRow();
        rcmjr.remove();
        Row rcmjr1 = rcmjvo.createRow();
        rcmjvo.insertRow(rcmjr1);
        for (int i = 0; i < attachvo.getEstimatedRowCount(); i++) {
            Row attachr = attachvo.getRowAtRangeIndex(i);
            if (attachr != null)
                attachr.remove();
        }
        return null;
    }

    public String sub_sms_action() {
        String key = (String)afu.evaluateEL("#{pageFlowScope.key}");
        Locale localel = (Locale)afu.evaluateEL("#{pageFlowScope.locale}");
        String locale = localel.toString();
        String s = "Y";
        ViewObject caseinfovo = getAm().findViewObject("ReqCaseInfoView1");
        ViewObject reqview = getAm().findViewObject("ReqRequestsViewSS");
        ViewObject corrmistvo = getAm().findViewObject("ReqSubSmsView1");
        Row corrmistr = corrmistvo.getCurrentRow();
        if (corrmistr.getAttribute("CaseNo") != null &&
            corrmistr.getAttribute("CaseYear") != null &&
            corrmistr.getAttribute("ProsecutionName") != null &&
            corrmistr.getAttribute("RelationCase") != null &&
            (!corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_en")) &&
            (!corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_en"))) {
            Number cno = (Number)corrmistr.getAttribute("CaseNo");
            Number cyear = (Number)corrmistr.getAttribute("CaseYear");
            String cpname = (String)corrmistr.getAttribute("ProsecutionName");
            int sid = Integer.parseInt(key);
            BigDecimal caseno = new BigDecimal(cno.toString());
            BigDecimal name = new BigDecimal(cpname.toString());
            BigDecimal year = new BigDecimal(cyear.toString());
            String res = this.validatingCase(sid, caseno, name, year);
            if (res.equals("ok")) {
                Row casinfr = caseinfovo.createRow();
                Row reqr = reqview.createRow();
                casinfr.setAttribute("CaseNumber",
                                     corrmistr.getAttribute("CaseNo"));
                casinfr.setAttribute("CaseYear",
                                     corrmistr.getAttribute("CaseYear"));
                casinfr.setAttribute("CaseType",
                                     corrmistr.getAttribute("ProsecutionName"));
                casinfr.setAttribute("Relation",
                                     corrmistr.getAttribute("RelationCase"));
                reqr.setAttribute("ReqName", setServiceNames(locale, key));
                reqr.setAttribute("CaseInfoId",
                                  casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ServiceId", sid);
                corrmistr.setAttribute("CaseInfo",
                                       casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ProsecId",
                                  corrmistr.getAttribute("ProsecutionName"));
                //                uploadfile_subsms();
                //                commit_action();
                //                sentEmail((Number)casinfr.getAttribute("CaseId"),
                //                          "Subscribing in SMS Service");
                //                return "Y";
                java.util.List<UploadedFile> file_u = this.getUploadedfile();
                if (file_u != null) {
                    String validateFile = validateFileUpload(file_u);
                    if (validateFile.equals("N")) {
                        for (int i = 0; i < file_u.size(); i++) {
                            Number foldern =
                                (Number)reqr.getAttribute("ReqId");
                            String foldername = foldern.toString();
                            if (i == 0) {
                                ubean.createFolder(foldername);
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadfile_subsms(file_u.get(i),
                                                  ubean.getDid());
                            } else {
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadfile_subsms(file_u.get(i),
                                                  ubean.getDid());
                            }
                        }
                    } else {
                        casinfr.remove();
                        reqr.remove();
                        s = "N";
                        FacesContext.getCurrentInstance().addMessage(upFileBind.getClientId(FacesContext.getCurrentInstance()),
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                      "File Type extension are not allowed",
                                                                                      "Kindly reload the files"));
                    }
                }
                if (s.equals("Y")) {
                    commit_action();
                    sentEmail((Number)reqr.getAttribute("ReqId"),
                              setServiceNames(locale, key), locale);
                    afu.setEL("#{pageFlowScope.casno}",
                              reqr.getAttribute("ReqId"));
                    oracle.jbo.domain.Number csid =
                        (Number)reqr.getAttribute("ReqId");
                    executeSMSproc((String)ADFContext.getCurrent().getSessionScope().get("mobile"),
                                   csid);
                    return "Y";
                }
            } else {
                return "N";
            }
        }
        if (corrmistr.getAttribute("CaseNo") == null) {
            this.setCn("Y");
        }
        if (corrmistr.getAttribute("CaseYear") == null) {
            this.setCy("Y");
        }
        if ((corrmistr.getAttribute("ProsecutionName") == null) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_en")) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_ar"))) {
            this.setPc("Y");
        }
        if ((corrmistr.getAttribute("RelationCase") == null) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_en")) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_ar"))) {
            this.setRc("Y");
        }
        //        if (corrmistr.getAttribute("TelephoneNumber") == null) {
        //            this.setTn("Y");
        //        }
        return null;
    }


    public String sub_sms_FileUploadaction(String did) {
        ViewObject ravo = this.getAm().findViewObject("ReqAttachmentsViewSS");
        Row rar = ravo.createRow();
        rar.setAttribute("DisplayName", fileName);
        rar.setAttribute("ContentType", contentType);
        //        rar.setAttribute("Attachment", blob);
        rar.setAttribute("AttachSize", fileSize);
        rar.setAttribute("AttachDownloadUrl", ubean.downloadAttachUrl());
        ravo.insertRow(rar);
        Number attachid = (Number)rar.getAttribute("Id");
        this.insert_did(attachid, did);
        return null;
    }

    public void sub_SMS_onFileUploadVCL(ValueChangeEvent vce) {
        _logger.info("Started executing file upload");
        file = (UploadedFile)vce.getNewValue();
        fileName = file.getFilename();
        contentType = file.getContentType();
        String FileExt =
            contentType.substring(contentType.lastIndexOf("/") + 1);
        if ((FileExt.equals("jpeg")) || (FileExt.equals("plain")) ||
            (FileExt.equals("msword")) || (FileExt.equals("gif")) ||
            (FileExt.equals("pdf"))) {
            blob = getBlob(file);
            long l = file.getLength();
            long kb = l / 1024;
            long mb = kb / 1024;
            fileSize = Double.toString(mb);
            if (mb < 10) {
                //                sub_sms_FileUploadaction();
            } else {
                this.SubSMSUPFilebind.resetValue();
                FacesMessage Message =
                    new FacesMessage("File Size should be less than 10 MB");
                Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, Message);
            }
        } else {
            FacesMessage Message = new FacesMessage(ERR_Attach);
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public void uploadfile_subsms(UploadedFile file, String did) {
        fileName = file.getFilename();
        contentType = file.getContentType();
        blob = getBlob(file);
        double l = file.getLength();
        double kb = l / 1024;
        double mb = kb / 1024;
        fileSize = df2.format(kb) + " kB";
        if (mb < 10) {
            sub_sms_FileUploadaction(did);
        } else {
            FacesMessage Message =
                new FacesMessage("File Size should be less than 10 MB");
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    //<------------------------------------------------------------ To Whom ever it may concern------------------------------------------------------>

    public String clearWhomitm_action() {
        ViewObject rcmjvo =
            this.getAm().findViewObject("ReqTowhomItmcerView1");
        ViewObject attachvo =
            this.getAm().findViewObject("ReqAttachmentsViewWIC");
        Row rcmjr = rcmjvo.getCurrentRow();
        rcmjr.remove();
        Row rcmjr1 = rcmjvo.createRow();
        rcmjvo.insertRow(rcmjr1);
        for (int i = 0; i < attachvo.getEstimatedRowCount(); i++) {
            Row attachr = attachvo.getRowAtRangeIndex(i);
            if (attachr != null)
                attachr.remove();
        }
        return null;
    }

    public String whom_it_may_cncrn_action() {
        String key = (String)afu.evaluateEL("#{pageFlowScope.key}");
        Locale localel = (Locale)afu.evaluateEL("#{pageFlowScope.locale}");
        String locale = localel.toString();
        //        String locale = "en";
        String s = "Y";
        ViewObject caseinfovo = getAm().findViewObject("ReqCaseInfoView1");
        ViewObject reqview = getAm().findViewObject("ReqRequestsViewWIC");
        ViewObject corrmistvo = getAm().findViewObject("ReqTowhomItmcerView1");
        Row corrmistr = corrmistvo.getCurrentRow();
        if (corrmistr.getAttribute("CaseNo") != null &&
            corrmistr.getAttribute("CaseYear") != null &&
            corrmistr.getAttribute("ProsecutionName") != null &&
            corrmistr.getAttribute("RelationCase") != null &&
            corrmistr.getAttribute("CertificateType") != null) {
            Number cno = (Number)corrmistr.getAttribute("CaseNo");
            Number cyear = (Number)corrmistr.getAttribute("CaseYear");
            String cpname = (String)corrmistr.getAttribute("ProsecutionName");
            int sid = Integer.parseInt(key);
            BigDecimal caseno = new BigDecimal(cno.toString());
            BigDecimal name = new BigDecimal(cpname.toString());
            BigDecimal year = new BigDecimal(cyear.toString());
            String res = this.validatingCase(sid, caseno, name, year);
            if (res.equals("ok")) {
                Row casinfr = caseinfovo.createRow();
                Row reqr = reqview.createRow();
                casinfr.setAttribute("CaseNumber",
                                     corrmistr.getAttribute("CaseNo"));
                casinfr.setAttribute("CaseYear",
                                     corrmistr.getAttribute("CaseYear"));
                casinfr.setAttribute("CaseType",
                                     corrmistr.getAttribute("ProsecutionName"));
                casinfr.setAttribute("Relation",
                                     corrmistr.getAttribute("RelationCase"));
                reqr.setAttribute("ReqName", setServiceNames(locale, key));
                reqr.setAttribute("CaseInfoId",
                                  casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ServiceId", sid);
                corrmistr.setAttribute("CaseInfo",
                                       casinfr.getAttribute("CaseId"));
                corrmistr.setAttribute("CertifType",
                                       corrmistr.getAttribute("CertificateType"));
                reqr.setAttribute("ProsecId",
                                  corrmistr.getAttribute("ProsecutionName"));
                //                uploadfile_itmaycncrn();
                //                commit_action();
                //                sentEmail((Number)casinfr.getAttribute("CaseId"),
                //                          "To It May Concern Certificate");
                //                return "Y";
                java.util.List<UploadedFile> file_u = this.getUploadedfile();
                if (file_u != null) {
                    String validateFile = validateFileUpload(file_u);
                    if (validateFile.equals("N")) {
                        for (int i = 0; i < file_u.size(); i++) {
                            Number foldern =
                                (Number)reqr.getAttribute("ReqId");
                            String foldername = foldern.toString();
                            if (i == 0) {
                                ubean.createFolder(foldername);
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadfile_itmaycncrn(file_u.get(i),
                                                      ubean.getDid());
                            } else {
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadfile_itmaycncrn(file_u.get(i),
                                                      ubean.getDid());
                            }
                        }
                    } else {
                        casinfr.remove();
                        reqr.remove();
                        s = "N";
                        FacesContext.getCurrentInstance().addMessage(upFileBind.getClientId(FacesContext.getCurrentInstance()),
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                      "File Type extension are not allowed",
                                                                                      "Kindly reload the files"));
                    }
                }
                if (s.equals("Y")) {
                    commit_action();
                    sentEmail((Number)reqr.getAttribute("ReqId"),
                              setServiceNames(locale, key), locale);
                    afu.setEL("#{pageFlowScope.casno}",
                              reqr.getAttribute("ReqId"));
                    oracle.jbo.domain.Number csid =
                        (Number)reqr.getAttribute("ReqId");
                    executeSMSproc((String)ADFContext.getCurrent().getSessionScope().get("mobile"),
                                   csid);
                    return "Y";
                }
            } else {
                return "N";
            }
        }
        if (corrmistr.getAttribute("CaseNo") == null) {
            this.setCn("Y");
        }
        if (corrmistr.getAttribute("CaseYear") == null) {
            this.setCy("Y");
        }
        if ((corrmistr.getAttribute("ProsecutionName") == null) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_en")) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_ar"))) {
            this.setPc("Y");
        }
        if ((corrmistr.getAttribute("RelationCase") == null) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_en")) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_ar"))) {
            this.setRc("Y");
        }
        if (corrmistr.getAttribute("CertificateType") == null) {
            this.setCt("Y");
        }
        return null;
    }


    public String whom_it_mcnrn_FileUploadaction(String did) {
        ViewObject ravo = this.getAm().findViewObject("ReqAttachmentsViewWIC");
        Row rar = ravo.createRow();
        rar.setAttribute("DisplayName", fileName);
        rar.setAttribute("ContentType", contentType);
        //        rar.setAttribute("Attachment", blob);
        rar.setAttribute("AttachSize", fileSize);
        rar.setAttribute("AttachDownloadUrl", ubean.downloadAttachUrl());
        ravo.insertRow(rar);
        Number attachid = (Number)rar.getAttribute("Id");
        this.insert_did(attachid, did);
        return null;
    }

    public void whom_it_mcrn_onFileUploadVCL(ValueChangeEvent vce) {
        _logger.info("Started executing file upload");
        file = (UploadedFile)vce.getNewValue();
        fileName = file.getFilename();
        contentType = file.getContentType();
        String FileExt =
            contentType.substring(contentType.lastIndexOf("/") + 1);
        if ((FileExt.equals("jpeg")) || (FileExt.equals("plain")) ||
            (FileExt.equals("msword")) || (FileExt.equals("gif")) ||
            (FileExt.equals("pdf"))) {
            blob = getBlob(file);
            long l = file.getLength();
            long kb = l / 1024;
            long mb = kb / 1024;
            fileSize = Double.toString(mb);
            if (mb < 10) {
                //                whom_it_mcnrn_FileUploadaction();
            } else {
                this.WICUPFilebind.resetValue();
                FacesMessage Message =
                    new FacesMessage("File Size should be less than 10 MB");
                Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, Message);
            }
        } else {
            FacesMessage Message = new FacesMessage(ERR_Attach);
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public void uploadfile_itmaycncrn(UploadedFile file, String did) {
        fileName = file.getFilename();
        contentType = file.getContentType();
        blob = getBlob(file);
        double l = file.getLength();
        double kb = l / 1024;
        double mb = kb / 1024;
        fileSize = df2.format(kb) + " kB";
        if (mb < 10) {
            whom_it_mcnrn_FileUploadaction(did);
        } else {
            FacesMessage Message =
                new FacesMessage("File Size should be less than 10 MB");
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }
    //<------------------------------------------------------------ CaseInformation------------------------------------------------------>


    public String ClearCaseInformation_action() {
        ViewObject rcmjvo =
            this.getAm().findViewObject("ReqCaseInformation1View1");
        ViewObject attachvo =
            this.getAm().findViewObject("ReqAttachmentsView34");
        Row rcmjr = rcmjvo.getCurrentRow();
        rcmjr.remove();
        Row rcmjr1 = rcmjvo.createRow();
        rcmjvo.insertRow(rcmjr1);
        for (int i = 0; i < attachvo.getEstimatedRowCount(); i++) {
            Row attachr = attachvo.getRowAtRangeIndex(i);
            if (attachr != null)
                attachr.remove();
        }
        return null;
    }


    public String Case_Information_action() {
        String key = (String)afu.evaluateEL("#{pageFlowScope.key}");
        Locale localel = (Locale)afu.evaluateEL("#{pageFlowScope.locale}");
        String locale = localel.toString();
        //        String locale = "en";
        String s = "Y";
        ViewObject caseinfovo = getAm().findViewObject("ReqCaseInfoView1");
        ViewObject reqview = getAm().findViewObject("ReqRequestsView34");
        ViewObject corrmistvo =
            getAm().findViewObject("ReqCaseInformation1View1");
        Row corrmistr = corrmistvo.getCurrentRow();
        if (corrmistr.getAttribute("CaseNo") != null &&
            corrmistr.getAttribute("CaseYear") != null &&
            corrmistr.getAttribute("ProsecutionName") != null &&
            corrmistr.getAttribute("RelationCase") != null &&
            (!corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_en")) &&
            (!corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_en"))) {
            Number cno = (Number)corrmistr.getAttribute("CaseNo");
            Number cyear = (Number)corrmistr.getAttribute("CaseYear");
            String cpname = (String)corrmistr.getAttribute("ProsecutionName");
            int sid = Integer.parseInt(key);
            BigDecimal caseno = new BigDecimal(cno.toString());
            BigDecimal name = new BigDecimal(cpname.toString());
            BigDecimal year = new BigDecimal(cyear.toString());
            String res = this.validatingCase(sid, caseno, name, year);
            if (res.equals("ok")) {
                Row casinfr = caseinfovo.createRow();
                Row reqr = reqview.createRow();
                casinfr.setAttribute("CaseNumber",
                                     corrmistr.getAttribute("CaseNo"));
                casinfr.setAttribute("CaseYear",
                                     corrmistr.getAttribute("CaseYear"));
                casinfr.setAttribute("CaseType",
                                     corrmistr.getAttribute("ProsecutionName"));
                casinfr.setAttribute("Relation",
                                     corrmistr.getAttribute("RelationCase"));
                reqr.setAttribute("ReqName", setServiceNames(locale, key));
                reqr.setAttribute("CaseInfoId",
                                  casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ServiceId", sid);
                corrmistr.setAttribute("CaseInfo",
                                       casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ProsecId",
                                  corrmistr.getAttribute("ProsecutionName"));
                //                uploadFile_caseinfo();
                //                commit_action();
                //                String email =
                //                    (String)ADFContext.getCurrent().getSessionScope().get("usermail");
                //                ADFUtils au = new ADFUtils();
                //                Number caseno = (Number)corrmistr.getAttribute("CaseNo");
                //                String subj =
                //                    "Case details " + caseno + " has been sent and waiting for approval";
                //                String txt =
                //                    "Case details " + caseno + " has been sent and waiting for approval";
                //                au.sendEmail(email, subj, txt);
                //                return "Y";
                java.util.List<UploadedFile> file_u = this.getUploadedfile();
                if (file_u != null) {
                    String validateFile = validateFileUpload(file_u);
                    if (validateFile.equals("N")) {
                        for (int i = 0; i < file_u.size(); i++) {
                            Number foldern =
                                (Number)reqr.getAttribute("ReqId");
                            String foldername = foldern.toString();
                            if (i == 0) {
                                ubean.createFolder(foldername);
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadFile_caseinfo(file_u.get(i),
                                                    ubean.getDid());
                            } else {
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadFile_caseinfo(file_u.get(i),
                                                    ubean.getDid());
                            }
                        }
                    } else {
                        casinfr.remove();
                        reqr.remove();
                        s = "N";
                        FacesContext.getCurrentInstance().addMessage(upFileBind.getClientId(FacesContext.getCurrentInstance()),
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                      "File Type extension are not allowed",
                                                                                      "Kindly reload the files"));
                    }
                }
                if (s.equals("Y")) {
                    commit_action();
                    sentEmail((Number)reqr.getAttribute("ReqId"),
                              setServiceNames(locale, key), locale);
                    afu.setEL("#{pageFlowScope.casno}",
                              reqr.getAttribute("ReqId"));
                    oracle.jbo.domain.Number csid =
                        (Number)reqr.getAttribute("ReqId");
                    executeSMSproc((String)ADFContext.getCurrent().getSessionScope().get("mobile"),
                                   csid);
                    return "Y";
                }
            } else {
                return "N";
            }
        }
        if (corrmistr.getAttribute("CaseNo") == null) {
            this.setCn("Y");
        }
        if (corrmistr.getAttribute("CaseYear") == null) {
            this.setCy("Y");
        }
        if ((corrmistr.getAttribute("ProsecutionName") == null) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_en")) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_ar"))) {
            this.setPc("Y");
        }
        if ((corrmistr.getAttribute("RelationCase") == null) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_en")) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_ar"))) {
            this.setRc("Y");
        }
        return null;
    }

    public String Case_Information_FileUploadaction(String did) {
        ViewObject ravo = this.getAm().findViewObject("ReqAttachmentsView34");
        Row rar = ravo.createRow();
        rar.setAttribute("DisplayName", fileName);
        rar.setAttribute("ContentType", contentType);
        //        rar.setAttribute("Attachment", blob);
        rar.setAttribute("AttachSize", fileSize);
        rar.setAttribute("AttachDownloadUrl", ubean.downloadAttachUrl());
        ravo.insertRow(rar);
        Number attachid = (Number)rar.getAttribute("Id");
        this.insert_did(attachid, did);
        return null;
    }


    public void uploadFile_caseinfo(UploadedFile file, String did) {
        fileName = file.getFilename();
        contentType = file.getContentType();
        blob = getBlob(file);
        double l = file.getLength();
        double kb = l / 1024;
        double mb = kb / 1024;
        fileSize = df2.format(kb) + " kB";
        if (mb < 10) {
            Case_Information_FileUploadaction(did);
        } else {
            FacesMessage Message =
                new FacesMessage("File Size should be less than 10 MB");
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }


    //<------------------------------------------------------------ Service1------------------------------------------------------>


    public String ClearService1_action() {
        ViewObject rcmjvo = this.getAm().findViewObject("ReqService1View1");
        ViewObject attachvo =
            this.getAm().findViewObject("ReqAttachmentsView35");
        Row rcmjr = rcmjvo.getCurrentRow();
        rcmjr.remove();
        Row rcmjr1 = rcmjvo.createRow();
        rcmjvo.insertRow(rcmjr1);
        for (int i = 0; i < attachvo.getEstimatedRowCount(); i++) {
            Row attachr = attachvo.getRowAtRangeIndex(i);
            if (attachr != null)
                attachr.remove();
        }
        return null;
    }


    public String Service1_action() {
        String key = (String)afu.evaluateEL("#{pageFlowScope.key}");
        Locale localel = (Locale)afu.evaluateEL("#{pageFlowScope.locale}");
        String locale = localel.toString();
        //        String locale = "en";
        String s = "Y";
        ViewObject caseinfovo = getAm().findViewObject("ReqCaseInfoView1");
        ViewObject reqview = getAm().findViewObject("ReqRequestsView35");
        ViewObject corrmistvo = getAm().findViewObject("ReqService1View1");
        Row corrmistr = corrmistvo.getCurrentRow();
        if (corrmistr.getAttribute("CaseNo") != null &&
            corrmistr.getAttribute("CaseYear") != null &&
            corrmistr.getAttribute("Prosecutionname") != null &&
            corrmistr.getAttribute("Relationcase") != null) {
            Number cno = (Number)corrmistr.getAttribute("CaseNo");
            Number cyear = (Number)corrmistr.getAttribute("CaseYear");
            String cpname = (String)corrmistr.getAttribute("Prosecutionname");
            int sid = Integer.parseInt(key);
            BigDecimal caseno = new BigDecimal(cno.toString());
            BigDecimal name = new BigDecimal(cpname.toString());
            BigDecimal year = new BigDecimal(cyear.toString());
            String res = this.validatingCase(sid, caseno, name, year);
            if (res.equals("ok")) {
                Row casinfr = caseinfovo.createRow();
                Row reqr = reqview.createRow();
                casinfr.setAttribute("CaseNumber",
                                     corrmistr.getAttribute("CaseNo"));
                casinfr.setAttribute("CaseYear",
                                     corrmistr.getAttribute("CaseYear"));
                casinfr.setAttribute("CaseType",
                                     corrmistr.getAttribute("Prosecutionname"));
                casinfr.setAttribute("Relation",
                                     corrmistr.getAttribute("Relationcase"));
                reqr.setAttribute("ReqName", setServiceNames(locale, key));
                reqr.setAttribute("CaseInfoId",
                                  casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ServiceId", sid);
                corrmistr.setAttribute("CaseInfo",
                                       casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ProsecId",
                                  corrmistr.getAttribute("Prosecutionname"));
                java.util.List<UploadedFile> file_u = this.getUploadedfile();
                if (file_u != null) {
                    String validateFile = validateFileUpload(file_u);
                    if (validateFile.equals("N")) {
                        for (int i = 0; i < file_u.size(); i++) {
                            Number foldern =
                                (Number)reqr.getAttribute("ReqId");
                            String foldername = foldern.toString();
                            if (i == 0) {
                                ubean.createFolder(foldername);
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadFile_prosSideAppeal(file_u.get(i),
                                                          ubean.getDid());
                            } else {
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadFile_prosSideAppeal(file_u.get(i),
                                                          ubean.getDid());
                            }
                        }
                    } else {
                        casinfr.remove();
                        reqr.remove();
                        s = "N";
                        FacesContext.getCurrentInstance().addMessage(upFileBind.getClientId(FacesContext.getCurrentInstance()),
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                      "File Type extension are not allowed",
                                                                                      "Kindly reload the files"));
                    }
                }
                if (s.equals("Y")) {
                    commit_action();
                    sentEmail((Number)reqr.getAttribute("ReqId"),
                              setServiceNames(locale, key), locale);
                    afu.setEL("#{pageFlowScope.casno}",
                              reqr.getAttribute("ReqId"));
                    oracle.jbo.domain.Number csid =
                        (Number)reqr.getAttribute("ReqId");
                    executeSMSproc((String)ADFContext.getCurrent().getSessionScope().get("mobile"),
                                   csid);
                    return "Y";
                }
            } else {
                return "N";
            }
        }
        if (corrmistr.getAttribute("CaseNo") == null) {
            this.setCn("Y");
        }
        if (corrmistr.getAttribute("CaseYear") == null) {
            this.setCy("Y");
        }
        if ((corrmistr.getAttribute("Prosecutionname") == null)) {
            this.setPc("Y");
        }
        if ((corrmistr.getAttribute("Relationcase") == null)) {
            this.setRc("Y");
        }
        return null;
    }


    public String prosSideAppeal_FileUploadaction(String did) {
        ViewObject ravo = this.getAm().findViewObject("ReqAttachmentsView35");
        Row rar = ravo.createRow();
        rar.setAttribute("DisplayName", fileName);
        rar.setAttribute("ContentType", contentType);
        rar.setAttribute("AttachSize", fileSize);
        rar.setAttribute("AttachDownloadUrl", ubean.downloadAttachUrl());
        ravo.insertRow(rar);
        Number attachid = (Number)rar.getAttribute("Id");
        this.insert_did(attachid, did);
        return null;
    }


    public void uploadFile_prosSideAppeal(UploadedFile file, String did) {
        fileName = file.getFilename();
        contentType = file.getContentType();
        blob = getBlob(file);
        double l = file.getLength();
        double kb = l / 1024;
        double mb = kb / 1024;
        fileSize = df2.format(kb) + " kB";
        if (mb < 10) {
            prosSideAppeal_FileUploadaction(did);
        } else {
            FacesMessage Message =
                new FacesMessage("File Size should be less than 10 MB");
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }


    public String Service1_FileUploadaction() {
        ViewObject ravo = this.getAm().findViewObject("ReqAttachmentsView35");
        Row rar = ravo.createRow();
        rar.setAttribute("DisplayName", fileName);
        rar.setAttribute("ContentType", contentType);
        //        rar.setAttribute("Attachment", blob);
        rar.setAttribute("AttachSize", fileSize);
        ravo.insertRow(rar);
        FacesMessage Message = new FacesMessage("File Uploaded successfully");
        Message.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage(null, Message);
        System.out.println("File Uploaded successfully");
        this.Service1UPFilebind.resetValue();
        return null;
    }

    public void Services1_onFileUploadVCL(ValueChangeEvent vce) {
        _logger.info("Started executing file upload");
        file = (UploadedFile)vce.getNewValue();
        fileName = file.getFilename();
        contentType = file.getContentType();
        String FileExt =
            contentType.substring(contentType.lastIndexOf("/") + 1);
        if ((FileExt.equals("jpeg")) || (FileExt.equals("plain")) ||
            (FileExt.equals("msword")) || (FileExt.equals("gif")) ||
            (FileExt.equals("pdf"))) {
            blob = getBlob(file);
            long l = file.getLength();
            long kb = l / 1024;
            long mb = kb / 1024;
            fileSize = Double.toString(mb);
            if (mb < 10) {
                Service1_FileUploadaction();
            } else {
                this.Service1UPFilebind.resetValue();
                FacesMessage Message =
                    new FacesMessage("File Size should be less than 10 MB");
                Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, Message);
            }
        } else {
            FacesMessage Message = new FacesMessage(ERR_Attach);
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }


    public void setWaivEnclUPFilebind(RichInputFile waivEnclUPFilebind) {
        this.waivEnclUPFilebind = waivEnclUPFilebind;
    }

    public RichInputFile getWaivEnclUPFilebind() {
        return waivEnclUPFilebind;
    }

    public void setVisitPrDUPFilebind(RichInputFile VisitPrDUPFilebind) {
        this.VisitPrDUPFilebind = VisitPrDUPFilebind;
    }

    public RichInputFile getVisitPrDUPFilebind() {
        return VisitPrDUPFilebind;
    }

    public void setWICUPFilebind(RichInputFile WICUPFilebind) {
        this.WICUPFilebind = WICUPFilebind;
    }

    public RichInputFile getWICUPFilebind() {
        return WICUPFilebind;
    }

    public void setSubSMSUPFilebind(RichInputFile SubSMSUPFilebind) {
        this.SubSMSUPFilebind = SubSMSUPFilebind;
    }

    public RichInputFile getSubSMSUPFilebind() {
        return SubSMSUPFilebind;
    }

    public void setSubObjUPFilebind(RichInputFile SubObjUPFilebind) {
        this.SubObjUPFilebind = SubObjUPFilebind;
    }

    public RichInputFile getSubObjUPFilebind() {
        return SubObjUPFilebind;
    }

    public void setOpenofMemUPFilebind(RichInputFile OpenofMemUPFilebind) {
        this.OpenofMemUPFilebind = OpenofMemUPFilebind;
    }

    public RichInputFile getOpenofMemUPFilebind() {
        return OpenofMemUPFilebind;
    }

    //  <----------------------Stop Searching/Cancellation of Arrest Warrant--------------------------------->

    public void setSrCclWrntUPFilebind(RichInputFile SrCclWrntUPFilebind) {
        this.SrCclWrntUPFilebind = SrCclWrntUPFilebind;
    }

    public RichInputFile getSrCclWrntUPFilebind() {
        return SrCclWrntUPFilebind;
    }

    public String clearSrchCnclWrnt_action() {
        ViewObject rcmjvo =
            this.getAm().findViewObject("ReqSrchCnclAwrntView1");
        ViewObject attachvo =
            this.getAm().findViewObject("ReqAttachmentsViewSCA");
        Row rcmjr = rcmjvo.getCurrentRow();
        rcmjr.remove();
        Row rcmjr1 = rcmjvo.createRow();
        rcmjvo.insertRow(rcmjr1);
        for (int i = 0; i < attachvo.getEstimatedRowCount(); i++) {
            Row attachr = attachvo.getRowAtRangeIndex(i);
            if (attachr != null)
                attachr.remove();
        }
        return null;
    }

    public String srch_cncl_wrnt_action() {
        String key = (String)afu.evaluateEL("#{pageFlowScope.key}");
        Locale localel = (Locale)afu.evaluateEL("#{pageFlowScope.locale}");
        String locale = localel.toString();
        //        String locale = "en";
        String s = "Y";
        ViewObject caseinfovo = getAm().findViewObject("ReqCaseInfoView1");
        ViewObject reqview = getAm().findViewObject("ReqRequestsViewSCA");
        ViewObject corrmistvo =
            getAm().findViewObject("ReqSrchCnclAwrntView1");
        Row corrmistr = corrmistvo.getCurrentRow();
        if (corrmistr.getAttribute("CaseNo") != null &&
            corrmistr.getAttribute("CaseYear") != null &&
            corrmistr.getAttribute("ProsecutionName") != null &&
            corrmistr.getAttribute("RelationCase") != null) {
            Number cno = (Number)corrmistr.getAttribute("CaseNo");
            Number cyear = (Number)corrmistr.getAttribute("CaseYear");
            String cpname = (String)corrmistr.getAttribute("ProsecutionName");
            int sid = Integer.parseInt(key);
            BigDecimal caseno = new BigDecimal(cno.toString());
            BigDecimal name = new BigDecimal(cpname.toString());
            BigDecimal year = new BigDecimal(cyear.toString());
            String res = this.validatingCase(sid, caseno, name, year);
            if (res.equals("ok")) {
                Row casinfr = caseinfovo.createRow();
                Row reqr = reqview.createRow();
                casinfr.setAttribute("CaseNumber",
                                     corrmistr.getAttribute("CaseNo"));
                casinfr.setAttribute("CaseYear",
                                     corrmistr.getAttribute("CaseYear"));
                casinfr.setAttribute("CaseType",
                                     corrmistr.getAttribute("ProsecutionName"));
                casinfr.setAttribute("Relation",
                                     corrmistr.getAttribute("RelationCase"));
                reqr.setAttribute("ReqName", setServiceNames(locale, key));
                reqr.setAttribute("CaseInfoId",
                                  casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ServiceId", sid);
                corrmistr.setAttribute("CaseInfo",
                                       casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ProsecId",
                                  corrmistr.getAttribute("ProsecutionName"));
                //                uploadfile_srchconclwrnt();
                //                commit_action();
                //                sentEmail((Number)casinfr.getAttribute("CaseId"),
                //                          "Stop Searching/Cancellation of Arrest Warrant");
                //                return "Y";
                java.util.List<UploadedFile> file_u = this.getUploadedfile();
                if (file_u != null) {
                    String validateFile = validateFileUpload(file_u);
                    if (validateFile.equals("N")) {
                        for (int i = 0; i < file_u.size(); i++) {
                            Number foldern =
                                (Number)reqr.getAttribute("ReqId");
                            String foldername = foldern.toString();
                            if (i == 0) {
                                ubean.createFolder(foldername);
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadfile_srchconclwrnt(file_u.get(i),
                                                         ubean.getDid());
                            } else {
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadfile_srchconclwrnt(file_u.get(i),
                                                         ubean.getDid());
                            }
                        }
                    } else {
                        casinfr.remove();
                        reqr.remove();
                        s = "N";
                        FacesContext.getCurrentInstance().addMessage(upFileBind.getClientId(FacesContext.getCurrentInstance()),
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                      "File Type extension are not allowed",
                                                                                      "Kindly reload the files"));
                    }
                }
                if (s.equals("Y")) {
                    commit_action();
                    sentEmail((Number)reqr.getAttribute("ReqId"),
                              setServiceNames(locale, key), locale);
                    afu.setEL("#{pageFlowScope.casno}",
                              reqr.getAttribute("ReqId"));
                    oracle.jbo.domain.Number csid =
                        (Number)reqr.getAttribute("ReqId");
                    executeSMSproc((String)ADFContext.getCurrent().getSessionScope().get("mobile"),
                                   csid);
                    return "Y";
                }
            } else {
                return "N";
            }
        }
        if (corrmistr.getAttribute("CaseNo") == null) {
            this.setCn("Y");
        }
        if (corrmistr.getAttribute("CaseYear") == null) {
            this.setCy("Y");
        }
        if ((corrmistr.getAttribute("ProsecutionName") == null) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_en")) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_ar"))) {
            this.setPc("Y");
        }
        if ((corrmistr.getAttribute("RelationCase") == null) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_en")) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_ar"))) {
            this.setRc("Y");
        }
        return null;
    }


    public String srch_cncl_wrnt_FileUploadaction(String did) {
        ViewObject ravo = this.getAm().findViewObject("ReqAttachmentsViewSCA");
        Row rar = ravo.createRow();
        rar.setAttribute("DisplayName", fileName);
        rar.setAttribute("ContentType", contentType);
        //        rar.setAttribute("Attachment", blob);
        rar.setAttribute("AttachSize", fileSize);
        rar.setAttribute("AttachDownloadUrl", ubean.downloadAttachUrl());
        ravo.insertRow(rar);
        Number attachid = (Number)rar.getAttribute("Id");
        this.insert_did(attachid, did);
        return null;
    }


    public void uploadfile_srchconclwrnt(UploadedFile file, String did) {
        fileName = file.getFilename();
        contentType = file.getContentType();
        blob = getBlob(file);
        double l = file.getLength();
        double kb = l / 1024;
        double mb = kb / 1024;
        fileSize = df2.format(kb) + " kB";
        if (mb < 10) {
            srch_cncl_wrnt_FileUploadaction(did);
        } else {
            FacesMessage Message =
                new FacesMessage("File Size should be less than 10 MB");
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    //  <----------------------Return of Bail Amount--------------------------------->

    public void setRetBailAmntUPFilebind(RichInputFile RetBailAmntUPFilebind) {
        this.RetBailAmntUPFilebind = RetBailAmntUPFilebind;
    }

    public RichInputFile getRetBailAmntUPFilebind() {
        return RetBailAmntUPFilebind;
    }

    public String clearRetBailAmnt_action() {
        ViewObject rcmjvo = this.getAm().findViewObject("ReqRetBailAmntView1");
        ViewObject attachvo =
            this.getAm().findViewObject("ReqAttachmentsViewRBA");
        Row rcmjr = rcmjvo.getCurrentRow();
        rcmjr.remove();
        Row rcmjr1 = rcmjvo.createRow();
        rcmjvo.insertRow(rcmjr1);
        for (int i = 0; i < attachvo.getEstimatedRowCount(); i++) {
            Row attachr = attachvo.getRowAtRangeIndex(i);
            if (attachr != null)
                attachr.remove();
        }
        return null;
    }

    public String ret_bail_amnt_action() {
        String key = (String)afu.evaluateEL("#{pageFlowScope.key}");
        Locale localel = (Locale)afu.evaluateEL("#{pageFlowScope.locale}");
        String locale = localel.toString();
        //        String locale = "en";
        String s = "Y";
        ViewObject caseinfovo = getAm().findViewObject("ReqCaseInfoView1");
        ViewObject reqview = getAm().findViewObject("ReqRequestsViewRBA");
        ViewObject corrmistvo = getAm().findViewObject("ReqRetBailAmntView1");
        Row corrmistr = corrmistvo.getCurrentRow();
        if (corrmistr.getAttribute("CaseNo") != null &&
            corrmistr.getAttribute("CaseYear") != null &&
            corrmistr.getAttribute("ProsecutionName") != null &&
            corrmistr.getAttribute("RelationCase") != null) {
            Number cno = (Number)corrmistr.getAttribute("CaseNo");
            Number cyear = (Number)corrmistr.getAttribute("CaseYear");
            String cpname = (String)corrmistr.getAttribute("ProsecutionName");
            int sid = 12;
            BigDecimal caseno = new BigDecimal(cno.toString());
            BigDecimal name = new BigDecimal(cpname.toString());
            BigDecimal year = new BigDecimal(cyear.toString());
            String res = this.validatingCase(sid, caseno, name, year);
            if (res.equals("ok")) {
                Row casinfr = caseinfovo.createRow();
                Row reqr = reqview.createRow();
                casinfr.setAttribute("CaseNumber",
                                     corrmistr.getAttribute("CaseNo"));
                casinfr.setAttribute("CaseYear",
                                     corrmistr.getAttribute("CaseYear"));
                casinfr.setAttribute("CaseType",
                                     corrmistr.getAttribute("ProsecutionName"));
                casinfr.setAttribute("Relation",
                                     corrmistr.getAttribute("RelationCase"));
                reqr.setAttribute("ReqName", "Return of Bail Amount");
                reqr.setAttribute("CaseInfoId",
                                  casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ServiceId", 12);
                corrmistr.setAttribute("CaseInfo",
                                       casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ProsecId",
                                  corrmistr.getAttribute("ProsecutionName"));
                //                uploadfile_retBail();
                //                commit_action();
                //                sentEmail((Number)casinfr.getAttribute("CaseId"),
                //                          "Return of Bail Amount");
                //                return "Y";
                java.util.List<UploadedFile> file_u = this.getUploadedfile();
                if (file_u != null) {
                    String validateFile = validateFileUpload(file_u);
                    if (validateFile.equals("N")) {
                        for (int i = 0; i < file_u.size(); i++) {
                            Number foldern =
                                (Number)reqr.getAttribute("ReqId");
                            String foldername = foldern.toString();
                            if (i == 0) {
                                ubean.createFolder(foldername);
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadfile_retBail(file_u.get(i),
                                                   ubean.getDid());
                            } else {
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadfile_retBail(file_u.get(i),
                                                   ubean.getDid());
                            }
                        }
                    } else {
                        casinfr.remove();
                        reqr.remove();
                        s = "N";
                        FacesContext.getCurrentInstance().addMessage(upFileBind.getClientId(FacesContext.getCurrentInstance()),
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                      "File Type extension are not allowed",
                                                                                      "Kindly reload the files"));
                    }
                }
                if (s.equals("Y")) {
                    commit_action();
                    sentEmail((Number)reqr.getAttribute("ReqId"),
                              setServiceNames(locale, key), locale);
                    afu.setEL("#{pageFlowScope.casno}",
                              reqr.getAttribute("ReqId"));
                    oracle.jbo.domain.Number csid =
                        (Number)reqr.getAttribute("ReqId");
                    executeSMSproc((String)ADFContext.getCurrent().getSessionScope().get("mobile"),
                                   csid);
                    return "Y";
                }
            } else {
                return "N";
            }
        }
        if (corrmistr.getAttribute("CaseNo") == null) {
            this.setCn("Y");
        }
        if (corrmistr.getAttribute("CaseYear") == null) {
            this.setCy("Y");
        }
        if ((corrmistr.getAttribute("ProsecutionName") == null) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_en")) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_ar"))) {
            this.setPc("Y");
        }
        if ((corrmistr.getAttribute("RelationCase") == null) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_en")) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_ar"))) {
            this.setRc("Y");
        }
        return null;
    }


    public String ret_bail_amnt_FileUploadaction(String did) {
        ViewObject ravo = this.getAm().findViewObject("ReqAttachmentsViewRBA");
        Row rar = ravo.createRow();
        rar.setAttribute("DisplayName", fileName);
        rar.setAttribute("ContentType", contentType);
        //        rar.setAttribute("Attachment", blob);
        rar.setAttribute("AttachSize", fileSize);
        rar.setAttribute("AttachDownloadUrl", ubean.downloadAttachUrl());
        ravo.insertRow(rar);
        Number attachid = (Number)rar.getAttribute("Id");
        this.insert_did(attachid, did);
        return null;
    }

    public void ret_bail_amnt_onFileUploadVCL(ValueChangeEvent vce) {
        _logger.info("Started executing file upload");
        file = (UploadedFile)vce.getNewValue();
        fileName = file.getFilename();
        contentType = file.getContentType();
        String FileExt =
            contentType.substring(contentType.lastIndexOf("/") + 1);
        if ((FileExt.equals("jpeg")) || (FileExt.equals("plain")) ||
            (FileExt.equals("msword")) || (FileExt.equals("gif")) ||
            (FileExt.equals("pdf"))) {
            blob = getBlob(file);
            long l = file.getLength();
            long kb = l / 1024;
            long mb = kb / 1024;
            fileSize = Double.toString(mb);
            if (mb < 10) {
                //                ret_bail_amnt_FileUploadaction();
            } else {
                this.RetBailAmntUPFilebind.resetValue();
                FacesMessage Message =
                    new FacesMessage("File Size should be less than 10 MB");
                Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, Message);
            }
        } else {
            FacesMessage Message = new FacesMessage(ERR_Attach);
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public void uploadfile_retBail(UploadedFile file, String did) {
        fileName = file.getFilename();
        contentType = file.getContentType();
        blob = getBlob(file);
        double l = file.getLength();
        double kb = l / 1024;
        double mb = kb / 1024;
        fileSize = df2.format(kb) + " kB";
        if (mb < 10) {
            ret_bail_amnt_FileUploadaction(did);
        } else {
            FacesMessage Message =
                new FacesMessage("File Size should be less than 10 MB");
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    //  <----------------------Rehabiliation--------------------------------->

    public void setRehabilUPFilebind(RichInputFile RehabilUPFilebind) {
        this.RehabilUPFilebind = RehabilUPFilebind;
    }

    public RichInputFile getRehabilUPFilebind() {
        return RehabilUPFilebind;
    }

    public String clearRehabil_action() {
        ViewObject rcmjvo = this.getAm().findViewObject("ReqRehabilView1");
        ViewObject attachvo =
            this.getAm().findViewObject("ReqAttachmentsViewR");
        Row rcmjr = rcmjvo.getCurrentRow();
        rcmjr.remove();
        Row rcmjr1 = rcmjvo.createRow();
        rcmjvo.insertRow(rcmjr1);
        for (int i = 0; i < attachvo.getEstimatedRowCount(); i++) {
            Row attachr = attachvo.getRowAtRangeIndex(i);
            if (attachr != null)
                attachr.remove();
        }
        return null;
    }

    public String rehabil_action() {
        String key = (String)afu.evaluateEL("#{pageFlowScope.key}");
        Locale localel = (Locale)afu.evaluateEL("#{pageFlowScope.locale}");
        String locale = localel.toString();
        String s = "Y";
        ViewObject caseinfovo = getAm().findViewObject("ReqCaseInfoView1");
        ViewObject reqview = getAm().findViewObject("ReqRequestsViewR");
        ViewObject corrmistvo = getAm().findViewObject("ReqRehabilView1");
        Row corrmistr = corrmistvo.getCurrentRow();
        if (corrmistr.getAttribute("CaseNo") != null &&
            corrmistr.getAttribute("CaseYear") != null &&
            corrmistr.getAttribute("ProsecutionName") != null &&
            corrmistr.getAttribute("RelationCase") != null &&
            corrmistr.getAttribute("JudgmentDate") != null) {
            Number cno = (Number)corrmistr.getAttribute("CaseNo");
            Number cyear = (Number)corrmistr.getAttribute("CaseYear");
            String cpname = (String)corrmistr.getAttribute("ProsecutionName");
            int sid = Integer.parseInt(key);
            BigDecimal caseno = new BigDecimal(cno.toString());
            BigDecimal name = new BigDecimal(cpname.toString());
            BigDecimal year = new BigDecimal(cyear.toString());
            String res = this.validatingCase(sid, caseno, name, year);

            if (res.equals("ok")) {
                Row casinfr = caseinfovo.createRow();
                Row reqr = reqview.createRow();
                casinfr.setAttribute("CaseNumber",
                                     corrmistr.getAttribute("CaseNo"));
                casinfr.setAttribute("CaseYear",
                                     corrmistr.getAttribute("CaseYear"));
                casinfr.setAttribute("CaseType",
                                     corrmistr.getAttribute("ProsecutionName"));
                casinfr.setAttribute("Relation",
                                     corrmistr.getAttribute("RelationCase"));
                reqr.setAttribute("ReqName", setServiceNames(locale, key));
                reqr.setAttribute("CaseInfoId",
                                  casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ServiceId", sid);
                corrmistr.setAttribute("CaseInfo",
                                       casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ProsecId",
                                  corrmistr.getAttribute("ProsecutionName"));
                java.util.List<UploadedFile> file_u = this.getUploadedfile();
                if (file_u != null) {
                    String validateFile = validateFileUpload(file_u);
                    if (validateFile.equals("N")) {
                        for (int i = 0; i < file_u.size(); i++) {
                            Number foldern =
                                (Number)reqr.getAttribute("ReqId");
                            String foldername = foldern.toString();
                            if (i == 0) {
                                ubean.createFolder(foldername);
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                upload_rehabil(file_u.get(i), ubean.getDid());
                            } else {
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                upload_rehabil(file_u.get(i), ubean.getDid());
                            }
                        }
                    } else {
                        casinfr.remove();
                        reqr.remove();
                        s = "N";
                        FacesContext.getCurrentInstance().addMessage(upFileBind.getClientId(FacesContext.getCurrentInstance()),
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                      "File Type extension are not allowed",
                                                                                      "Kindly reload the files"));
                    }
                }
                if (s.equals("Y")) {
                    commit_action();
                    sentEmail((Number)reqr.getAttribute("ReqId"),
                              setServiceNames(locale, key), locale);
                    afu.setEL("#{pageFlowScope.casno}",
                              reqr.getAttribute("ReqId"));
                    oracle.jbo.domain.Number csid =
                        (Number)reqr.getAttribute("ReqId");
                    executeSMSproc((String)ADFContext.getCurrent().getSessionScope().get("mobile"),
                                   csid);
                    return "Y";
                }
            } else {
                return "N";
            }
        }
        if (corrmistr.getAttribute("CaseNo") == null) {
            this.setCn("Y");
        }
        if (corrmistr.getAttribute("CaseYear") == null) {
            this.setCy("Y");
        }
        if ((corrmistr.getAttribute("ProsecutionName") == null) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_en")) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_ar"))) {
            this.setPc("Y");
        }
        if ((corrmistr.getAttribute("RelationCase") == null) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_en")) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_ar"))) {
            this.setRc("Y");
        }
        if (corrmistr.getAttribute("JudgmentDate") == null) {
            jd = "Y";
        }
        return null;
    }


    public String rehabil_FileUploadaction(String did) {
        ViewObject ravo = this.getAm().findViewObject("ReqAttachmentsViewR");
        Row rar = ravo.createRow();
        rar.setAttribute("DisplayName", fileName);
        rar.setAttribute("ContentType", contentType);
        //        rar.setAttribute("Attachment", blob);
        rar.setAttribute("AttachSize", fileSize);
        rar.setAttribute("AttachDownloadUrl", ubean.downloadAttachUrl());
        ravo.insertRow(rar);
        Number attachid = (Number)rar.getAttribute("Id");
        this.insert_did(attachid, did);
        //        FacesMessage Message = new FacesMessage("File Uploaded successfully");
        //        Message.setSeverity(FacesMessage.SEVERITY_INFO);
        //        FacesContext fc = FacesContext.getCurrentInstance();
        //        fc.addMessage(null, Message);
        //        System.out.println("File Uploaded successfully");
        //        this.RehabilUPFilebind.resetValue();
        return null;
    }

    public void rehabil_onFileUploadVCL(ValueChangeEvent vce) {
        _logger.info("Started executing file upload");
        file = (UploadedFile)vce.getNewValue();
        fileName = file.getFilename();
        contentType = file.getContentType();
        String FileExt =
            contentType.substring(contentType.lastIndexOf("/") + 1);
        if ((FileExt.equals("jpeg")) || (FileExt.equals("plain")) ||
            (FileExt.equals("msword")) || (FileExt.equals("gif")) ||
            (FileExt.equals("pdf"))) {
            blob = getBlob(file);
            long l = file.getLength();
            long kb = l / 1024;
            long mb = kb / 1024;
            fileSize = Double.toString(mb);
            if (mb < 10) {
                //                rehabil_FileUploadaction();
            } else {
                this.RehabilUPFilebind.resetValue();
                FacesMessage Message =
                    new FacesMessage("File Size should be less than 10 MB");
                Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, Message);
            }
        } else {
            FacesMessage Message = new FacesMessage(ERR_Attach);
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public void upload_rehabil(UploadedFile file, String did) {
        fileName = file.getFilename();
        contentType = file.getContentType();
        blob = getBlob(file);
        double l = file.getLength();
        double kb = l / 1024;
        double mb = kb / 1024;
        fileSize = df2.format(kb) + " kB";
        if (mb < 10) {
            rehabil_FileUploadaction(did);
        } else {
            FacesMessage Message =
                new FacesMessage("File Size should be less than 10 MB");
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    //  <----------------------Receiving of Passport--------------------------------->

    public void setRecPprtUPFilebind(RichInputFile RecPprtUPFilebind) {
        this.RecPprtUPFilebind = RecPprtUPFilebind;
    }

    public RichInputFile getRecPprtUPFilebind() {
        return RecPprtUPFilebind;
    }

    public String clearRc_pprt_action() {
        ViewObject rcmjvo = this.getAm().findViewObject("ReqRecPassportView1");
        ViewObject attachvo =
            this.getAm().findViewObject("ReqAttachmentsViewRP");
        Row rcmjr = rcmjvo.getCurrentRow();
        rcmjr.remove();
        Row rcmjr1 = rcmjvo.createRow();
        rcmjvo.insertRow(rcmjr1);
        for (int i = 0; i < attachvo.getEstimatedRowCount(); i++) {
            Row attachr = attachvo.getRowAtRangeIndex(i);
            if (attachr != null)
                attachr.remove();
        }
        return null;
    }

    public String rec_pprt_action() {
        String key = (String)afu.evaluateEL("#{pageFlowScope.key}");
        Locale localel = (Locale)afu.evaluateEL("#{pageFlowScope.locale}");
        String locale = localel.toString();
        //        String locale = "en";
        String s = "Y";
        int sid = Integer.parseInt(key);
        ViewObject caseinfovo = getAm().findViewObject("ReqCaseInfoView1");
        ViewObject reqview = getAm().findViewObject("ReqRequestsViewRP");
        ViewObject corrmistvo = getAm().findViewObject("ReqRecPassportView1");
        Row corrmistr = corrmistvo.getCurrentRow();
        if (corrmistr.getAttribute("CaseNo") != null &&
            corrmistr.getAttribute("CaseYear") != null &&
            corrmistr.getAttribute("ProsecutionName") != null &&
            corrmistr.getAttribute("RelationCase") != null) {
            Number cno = (Number)corrmistr.getAttribute("CaseNo");
            Number cyear = (Number)corrmistr.getAttribute("CaseYear");
            String cpname = (String)corrmistr.getAttribute("ProsecutionName");
            //            String res = check_case_info_common(cyear, cpname, cno);
            String res = "Y";
            if (res.equals("Y")) {
                Row casinfr = caseinfovo.createRow();
                Row reqr = reqview.createRow();
                casinfr.setAttribute("CaseNumber",
                                     corrmistr.getAttribute("CaseNo"));
                casinfr.setAttribute("CaseYear",
                                     corrmistr.getAttribute("CaseYear"));
                casinfr.setAttribute("CaseType",
                                     corrmistr.getAttribute("ProsecutionName"));
                casinfr.setAttribute("Relation",
                                     corrmistr.getAttribute("RelationCase"));
                reqr.setAttribute("ReqName", setServiceNames(locale, key));
                reqr.setAttribute("CaseInfoId",
                                  casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ServiceId", sid);
                corrmistr.setAttribute("CaseInfo",
                                       casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ProsecId",
                                  corrmistr.getAttribute("ProsecutionName"));
                //                uploadFile_recpprt();
                //                commit_action();
                //                sentEmail((Number)casinfr.getAttribute("CaseId"),
                //                          "Receiving of Passport");
                //                return "Y";
                //                UCMBean ubean = new UCMBean();
                //                Number foldern = (Number)reqr.getAttribute("ReqId");
                //
                //                String foldername = foldern.toString();
                java.util.List<UploadedFile> file_u = this.getUploadedfile();
                if (file_u != null) {
                    String validateFile = validateFileUpload(file_u);
                    if (validateFile.equals("N")) {
                        for (int i = 0; i < file_u.size(); i++) {
                            Number foldern =
                                (Number)reqr.getAttribute("ReqId");
                            String foldername = foldern.toString();
                            if (i == 0) {
                                ubean.createFolder(foldername);
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadFile_recpprt(file_u.get(i),
                                                   ubean.getDid());
                            } else {
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadFile_recpprt(file_u.get(i),
                                                   ubean.getDid());
                            }
                        }
                    } else {
                        casinfr.remove();
                        reqr.remove();
                        s = "N";
                        FacesContext.getCurrentInstance().addMessage(upFileBind.getClientId(FacesContext.getCurrentInstance()),
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                      "File Type extension are not allowed",
                                                                                      "Kindly reload the files"));
                    }
                }
                if (s.equals("Y")) {
                    commit_action();
                    sentEmail((Number)reqr.getAttribute("ReqId"),
                              setServiceNames(locale, key), locale);
                    afu.setEL("#{pageFlowScope.casno}",
                              reqr.getAttribute("ReqId"));
                    oracle.jbo.domain.Number csid =
                        (Number)reqr.getAttribute("ReqId");
                    executeSMSproc((String)ADFContext.getCurrent().getSessionScope().get("mobile"),
                                   csid);
                    return "Y";
                }
            } else {
                return "N";
            }
        }
        if (corrmistr.getAttribute("CaseNo") == null) {
            this.setCn("Y");
        }
        if (corrmistr.getAttribute("CaseYear") == null) {
            this.setCy("Y");
        }
        if ((corrmistr.getAttribute("ProsecutionName") == null) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_en")) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_ar"))) {
            this.setPc("Y");
        }
        if ((corrmistr.getAttribute("RelationCase") == null) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_en")) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_ar"))) {
            this.setRc("Y");
        }
        return null;
    }


    public String rec_pprt_FileUploadaction(String did) {
        ViewObject ravo = this.getAm().findViewObject("ReqAttachmentsViewRP");
        Row rar = ravo.createRow();
        rar.setAttribute("DisplayName", fileName);
        rar.setAttribute("ContentType", contentType);
        //        rar.setAttribute("Attachment", blob);
        rar.setAttribute("AttachSize", fileSize);
        rar.setAttribute("AttachDownloadUrl", ubean.downloadAttachUrl());
        ravo.insertRow(rar);
        Number attachid = (Number)rar.getAttribute("Id");
        this.insert_did(attachid, did);
        return null;
    }

    public void rec_pprt_onFileUploadVCL(ValueChangeEvent vce) {
        _logger.info("Started executing file upload");
        file = (UploadedFile)vce.getNewValue();
        fileName = file.getFilename();
        contentType = file.getContentType();
        String FileExt =
            contentType.substring(contentType.lastIndexOf("/") + 1);
        if ((FileExt.equals("jpeg")) || (FileExt.equals("plain")) ||
            (FileExt.equals("msword")) || (FileExt.equals("gif")) ||
            (FileExt.equals("pdf"))) {
            blob = getBlob(file);
            long l = file.getLength();
            long kb = l / 1024;
            long mb = kb / 1024;
            fileSize = Double.toString(mb);
            if (mb < 10) {
                //                rec_pprt_FileUploadaction();
            } else {
                this.RecPprtUPFilebind.resetValue();
                FacesMessage Message =
                    new FacesMessage("File Size should be less than 10 MB");
                Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, Message);
            }
        } else {
            FacesMessage Message = new FacesMessage(ERR_Attach);
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public void uploadFile_recpprt(UploadedFile file, String did) {
        fileName = file.getFilename();
        contentType = file.getContentType();
        blob = getBlob(file);
        double l = file.getLength();
        double kb = l / 1024;
        double mb = kb / 1024;
        fileSize = df2.format(kb) + " kB";
        if (mb < 10) {
            rec_pprt_FileUploadaction(did);
        } else {
            FacesMessage Message =
                new FacesMessage("File Size should be less than 10 MB");
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public RichInputFile getPprenewalUPFilebind() {
        return PprenewalUPFilebind;
    }
    //  <----------------------Receiving of Deposits, Impoundment, Documents, or Passports--------------------------------->

    public void setRecDocimpUPFilebind(RichInputFile RecDocimpUPFilebind) {
        this.RecDocimpUPFilebind = RecDocimpUPFilebind;
    }

    public RichInputFile getRecDocimpUPFilebind() {
        return RecDocimpUPFilebind;
    }

    public String clearrec_dep_in_action() {
        ViewObject rcmjvo =
            this.getAm().findViewObject("ReqRecDepImpDocPprtView1");
        ViewObject attachvo =
            this.getAm().findViewObject("ReqAttachmentsViewRDIPD");
        Row rcmjr = rcmjvo.getCurrentRow();
        rcmjr.remove();
        Row rcmjr1 = rcmjvo.createRow();
        rcmjvo.insertRow(rcmjr1);
        for (int i = 0; i < attachvo.getEstimatedRowCount(); i++) {
            Row attachr = attachvo.getRowAtRangeIndex(i);
            if (attachr != null)
                attachr.remove();
        }
        return null;
    }

    public String rec_dep_in_action() {
        ViewObject caseinfovo = getAm().findViewObject("ReqCaseInfoView1");
        ViewObject reqview = getAm().findViewObject("ReqRequestsViewRDIPD");
        ViewObject corrmistvo =
            getAm().findViewObject("ReqRecDepImpDocPprtView1");
        Row corrmistr = corrmistvo.getCurrentRow();
        Number cno = (Number)corrmistr.getAttribute("CaseNo");
        Number cyear = (Number)corrmistr.getAttribute("CaseYear");
        String cpname = (String)corrmistr.getAttribute("ProsecutionName");
        //        String res = check_case_info_common(cyear, cpname, cno);
        String res = "Y";
        if (res.equals("Y")) {
            Row casinfr = caseinfovo.createRow();
            Row reqr = reqview.createRow();
            casinfr.setAttribute("CaseNumber",
                                 corrmistr.getAttribute("CaseNo"));
            casinfr.setAttribute("CaseYear",
                                 corrmistr.getAttribute("CaseYear"));
            casinfr.setAttribute("CaseType",
                                 corrmistr.getAttribute("ProsecutionName"));
            casinfr.setAttribute("Relation",
                                 corrmistr.getAttribute("RelationCase"));
            reqr.setAttribute("ReqName", "Rehabiliation");
            reqr.setAttribute("CaseInfoId", casinfr.getAttribute("CaseId"));
            commit_action();
            /*    String email =
                        (String)ADFContext.getCurrent().getSessionScope().get("usermail");
                    ADFUtils au = new ADFUtils();
                Number caseno = (Number)corrmistr.getAttribute("CaseNo");
                String subj = "Case details "+caseno+" has been sent and waiting for approval";
                String txt = "Case details "+caseno+" has been sent and waiting for approval";
                au.sendEmail(email, subj, txt);*/
            return "Y";
        } else {
            return "N";
        }
    }


    public String rec_doc_in_FileUploadaction() {
        ViewObject ravo =
            this.getAm().findViewObject("ReqAttachmentsViewRDIPD");
        Row rar = ravo.createRow();
        rar.setAttribute("DisplayName", fileName);
        rar.setAttribute("ContentType", contentType);
        //        rar.setAttribute("Attachment", blob);
        rar.setAttribute("AttachSize", fileSize);
        ravo.insertRow(rar);
        FacesMessage Message = new FacesMessage("File Uploaded successfully");
        Message.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage(null, Message);
        System.out.println("File Uploaded successfully");
        this.RecDocimpUPFilebind.resetValue();
        return null;
    }

    public void rec_doc_in_onFileUploadVCL(ValueChangeEvent vce) {
        _logger.info("Started executing file upload");
        file = (UploadedFile)vce.getNewValue();
        fileName = file.getFilename();
        contentType = file.getContentType();
        String FileExt =
            contentType.substring(contentType.lastIndexOf("/") + 1);
        if ((FileExt.equals("jpeg")) || (FileExt.equals("plain")) ||
            (FileExt.equals("msword")) || (FileExt.equals("gif")) ||
            (FileExt.equals("pdf"))) {
            blob = getBlob(file);
            long l = file.getLength();
            long kb = l / 1024;
            long mb = kb / 1024;
            fileSize = Double.toString(mb);
            if (mb < 10) {
                rec_doc_in_FileUploadaction();
            } else {
                this.RecDocimpUPFilebind.resetValue();
                FacesMessage Message =
                    new FacesMessage("File Size should be less than 10 MB");
                Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, Message);
            }
        } else {
            FacesMessage Message = new FacesMessage(ERR_Attach);
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public void setPprenewalUPFilebind(RichInputFile PprenewalUPFilebind) {
        this.PprenewalUPFilebind = PprenewalUPFilebind;
    }

    public void setPcopycasedropdecUPFilebind(RichInputFile PcopycasedropdecUPFilebind) {
        this.PcopycasedropdecUPFilebind = PcopycasedropdecUPFilebind;
    }

    public RichInputFile getPcopycasedropdecUPFilebind() {
        return PcopycasedropdecUPFilebind;
    }

    public void setPpmentinsCourtUPFilebind(RichInputFile PpmentinsCourtUPFilebind) {
        this.PpmentinsCourtUPFilebind = PpmentinsCourtUPFilebind;
    }

    public RichInputFile getPpmentinsCourtUPFilebind() {
        return PpmentinsCourtUPFilebind;
    }

    public void setPostponeofFreeUPFilebind(RichInputFile PostponeofFreeUPFilebind) {
        this.PostponeofFreeUPFilebind = PostponeofFreeUPFilebind;
    }

    public RichInputFile getPostponeofFreeUPFilebind() {
        return PostponeofFreeUPFilebind;
    }

    public void setRecDepChargUPFilebind(RichInputFile RecDepChargUPFilebind) {
        this.RecDepChargUPFilebind = RecDepChargUPFilebind;
    }

    public RichInputFile getRecDepChargUPFilebind() {
        return RecDepChargUPFilebind;
    }

    //<----------------------------------------International arrest warrant--------------------------------------------------------->

    public void setIntArstWrntUPFilebind(RichInputFile IntArstWrntUPFilebind) {
        this.IntArstWrntUPFilebind = IntArstWrntUPFilebind;
    }

    public RichInputFile getIntArstWrntUPFilebind() {
        return IntArstWrntUPFilebind;
    }

    public String clearIntarstWrnt_action() {
        ViewObject rcmjvo = this.getAm().findViewObject("ReqIntArstWrntView1");
        ViewObject attachvo =
            this.getAm().findViewObject("ReqAttachmentsViewIAW");
        Row rcmjr = rcmjvo.getCurrentRow();
        rcmjr.remove();
        Row rcmjr1 = rcmjvo.createRow();
        rcmjvo.insertRow(rcmjr1);
        for (int i = 0; i < attachvo.getEstimatedRowCount(); i++) {
            Row attachr = attachvo.getRowAtRangeIndex(i);
            if (attachr != null)
                attachr.remove();
        }
        return null;
    }

    public String int_arst_wrnt_action() {
        String key = (String)afu.evaluateEL("#{pageFlowScope.key}");
        Locale localel = (Locale)afu.evaluateEL("#{pageFlowScope.locale}");
        String locale = localel.toString();
        //        String locale = "en";
        String s = "Y";
        String photoUpload = "N";
        ViewObject caseinfovo = getAm().findViewObject("ReqCaseInfoView1");
        ViewObject reqview = getAm().findViewObject("ReqRequestsViewIAW");
        ViewObject corrmistvo = getAm().findViewObject("ReqIntArstWrntView1");
        Row corrmistr = corrmistvo.getCurrentRow();
        java.util.List<UploadedFile> file_u = this.getUploadedfile();
        if (corrmistr.getAttribute("CaseNo") != null &&
            corrmistr.getAttribute("CaseYear") != null &&
            corrmistr.getAttribute("ProsecutionName") != null &&
            corrmistr.getAttribute("RelationCase") != null &&
            corrmistr.getAttribute("PersonCaptName") != null &&
            corrmistr.getAttribute("PersonCaptData") != null &&
            file_u != null) {
            Number cno = (Number)corrmistr.getAttribute("CaseNo");
            Number cyear = (Number)corrmistr.getAttribute("CaseYear");
            String cpname = (String)corrmistr.getAttribute("ProsecutionName");
            //
            //String res = check_case_info_common(cyear, cpname, cno);
            int sid = Integer.parseInt(key);
            BigDecimal caseno = new BigDecimal(cno.toString());
            BigDecimal name = new BigDecimal(cpname.toString());
            BigDecimal year = new BigDecimal(cyear.toString());
            String res = this.validatingCase(sid, caseno, name, year);
            if (res.equals("ok")) {
                Row casinfr = caseinfovo.createRow();
                Row reqr = reqview.createRow();
                casinfr.setAttribute("CaseNumber",
                                     corrmistr.getAttribute("CaseNo"));
                casinfr.setAttribute("CaseYear",
                                     corrmistr.getAttribute("CaseYear"));
                casinfr.setAttribute("CaseType",
                                     corrmistr.getAttribute("ProsecutionName"));
                casinfr.setAttribute("Relation",
                                     corrmistr.getAttribute("RelationCase"));
                reqr.setAttribute("ReqName", setServiceNames(locale, key));
                reqr.setAttribute("CaseInfoId",
                                  casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ServiceId", sid);
                corrmistr.setAttribute("CaseInfo",
                                       casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ProsecId",
                                  corrmistr.getAttribute("ProsecutionName"));
                //                uploadfile_intarstwrnt();
                //                commit_action();
                //                sentEmail((Number)casinfr.getAttribute("CaseId"),
                //                          "International arrest warrant");
                //                return "Y";

                if (this.intPhotoUpload != null) {
                    if (intPhotoUpload.getFilename().endsWith("gif") ||
                        intPhotoUpload.getFilename().endsWith("jpeg") ||
                        intPhotoUpload.getFilename().endsWith("bmp")) {
                        UCMBean ubean = new UCMBean();
                        Number foldern = (Number)reqr.getAttribute("ReqId");
                        String foldername = foldern.toString();
                        ubean.createFolder(foldername);
                        ubean.uploadedFile(foldername, intPhotoUpload,
                                           foldername);
                        uploadfile_intarstwrnt(intPhotoUpload, ubean.getDid());
                        photoUpload = "Y";
                    } else {
                        casinfr.remove();
                        reqr.remove();
                        s = "N";

                        FacesContext.getCurrentInstance().addMessage(IntArstWrntUPFilebind.getClientId(FacesContext.getCurrentInstance()),
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                      "File Type extension are not allowed",
                                                                                      "This file (" +
                                                                                      intPhotoUpload.getFilename() +
                                                                                      ") is not allowed;Kindly reload the files"));
                    }
                }
                if (file_u != null) {
                    String validateFile = validateFileUpload(file_u);
                    if (validateFile.equals("N")) {
                        for (int i = 0; i < file_u.size(); i++) {
                            Number foldern =
                                (Number)reqr.getAttribute("ReqId");
                            String foldername = foldern.toString();
                            if (i == 0) {
                                ubean.createFolder(foldername);
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadfile_intarstwrnt(file_u.get(i),
                                                       ubean.getDid());
                            } else {
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadfile_intarstwrnt(file_u.get(i),
                                                       ubean.getDid());
                            }
                        }
                    } else {
                        casinfr.remove();
                        reqr.remove();
                        s = "N";
                        FacesContext.getCurrentInstance().addMessage(upFileBind.getClientId(FacesContext.getCurrentInstance()),
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                      "File Type extension are not allowed",
                                                                                      "Kindly reload the files"));
                    }
                }
                if (s.equals("Y")) {
                    commit_action();
                    sentEmail((Number)reqr.getAttribute("ReqId"),
                              setServiceNames(locale, key), locale);
                    afu.setEL("#{pageFlowScope.casno}",
                              reqr.getAttribute("ReqId"));
                    oracle.jbo.domain.Number csid =
                        (Number)reqr.getAttribute("ReqId");
                    executeSMSproc((String)ADFContext.getCurrent().getSessionScope().get("mobile"),
                                   csid);
                    return "Y";
                }
            } else {
                return "N";
            }
        }
        if (corrmistr.getAttribute("CaseNo") == null) {
            this.setCn("Y");
        }
        if (corrmistr.getAttribute("CaseYear") == null) {
            this.setCy("Y");
        }
        if ((corrmistr.getAttribute("ProsecutionName") == null) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_en")) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_ar"))) {
            this.setPc("Y");
        }
        if ((corrmistr.getAttribute("RelationCase") == null) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_en")) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_ar"))) {
            this.setRc("Y");
        }
        if ((corrmistr.getAttribute("PersonCaptName") == null)) {
            this.setPcn("Y");
        }
        if ((corrmistr.getAttribute("PersonCaptData") == null)) {
            this.setPcd("Y");
        }
        if (file_u == null) {
            pcp = "Y";
        }
        return null;
    }


    public String int_arst_wrnt_FileUploadaction(String did) {
        ViewObject ravo = this.getAm().findViewObject("ReqAttachmentsViewIAW");
        Row rar = ravo.createRow();
        rar.setAttribute("DisplayName", fileName);
        rar.setAttribute("ContentType", contentType);
        //        rar.setAttribute("Attachment", blob);
        rar.setAttribute("AttachSize", fileSize);
        rar.setAttribute("AttachDownloadUrl", ubean.downloadAttachUrl());
        ravo.insertRow(rar);
        Number attachid = (Number)rar.getAttribute("Id");
        this.insert_did(attachid, did);
        return null;
    }

    public void int_arst_wrnt_onFileUploadVCL(ValueChangeEvent vce) {
        _logger.info("Started executing file upload");
        file = (UploadedFile)vce.getNewValue();
        fileName = file.getFilename();
        contentType = file.getContentType();
        String FileExt =
            contentType.substring(contentType.lastIndexOf("/") + 1);
        if ((FileExt.equals("jpeg")) || (FileExt.equals("plain")) ||
            (FileExt.equals("msword")) || (FileExt.equals("gif")) ||
            (FileExt.equals("pdf"))) {
            blob = getBlob(file);
            long l = file.getLength();
            long kb = l / 1024;
            long mb = kb / 1024;
            fileSize = Double.toString(mb);
            if (mb < 10) {
                //                int_arst_wrnt_FileUploadaction();
            } else {
                IntArstWrntUPFilebind.resetValue();
                FacesMessage Message =
                    new FacesMessage("File Size should be less than 10 MB");
                Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, Message);
            }
        } else {
            FacesMessage Message = new FacesMessage(ERR_Attach);
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public void uploadfile_intarstwrnt(UploadedFile file, String did) {
        fileName = file.getFilename();
        contentType = file.getContentType();
        blob = getBlob(file);
        double l = file.getLength();
        double kb = l / 1024;
        double mb = kb / 1024;
        fileSize = df2.format(kb) + " kB";
        if (mb < 10) {
            int_arst_wrnt_FileUploadaction(did);
        } else {
            FacesMessage Message =
                new FacesMessage("File Size should be less than 10 MB");
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public void iaw_photo_onFileUploadVCL(ValueChangeEvent vce) {
        _logger.info("Started executing file upload");
        file = (UploadedFile)vce.getNewValue();
        fileName = file.getFilename();
        contentType = file.getContentType();
        String FileExt =
            contentType.substring(contentType.lastIndexOf("/") + 1);
        if ((FileExt.equals("jpeg")) || (FileExt.equals("bmp")) ||
            (FileExt.equals("gif")) || (FileExt.equals("jpg"))) {
            blob = getBlob(file);
            iaw_photo_FileUploadaction();

        } else {
            FacesMessage Message =
                new FacesMessage(".bmp,.gif,.jpeg, Single File Size 2MB");
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public String iaw_photo_FileUploadaction() {
        ViewObject ravo = this.getAm().findViewObject("ReqIntArstWrntView1");
        Row rar = ravo.getCurrentRow();
        rar.setAttribute("PersonCapturePhoto", blob);
        FacesMessage Message = new FacesMessage("File Uploaded successfully");
        Message.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage(null, Message);
        return null;
    }

    //<----------------------------------------Request for appeal in cassation--------------------------------------------------------->

    public void setApCseUPFilebind(RichInputFile ApCseUPFilebind) {
        this.ApCseUPFilebind = ApCseUPFilebind;
    }

    public RichInputFile getApCseUPFilebind() {
        return ApCseUPFilebind;
    }

    public String clearApcse_action() {
        ViewObject rcmjvo = this.getAm().findViewObject("ReqAppealCasView1");
        ViewObject attachvo =
            this.getAm().findViewObject("ReqAttachmentsViewAC");
        Row rcmjr = rcmjvo.getCurrentRow();
        rcmjr.remove();
        Row rcmjr1 = rcmjvo.createRow();
        rcmjvo.insertRow(rcmjr1);
        for (int i = 0; i < attachvo.getEstimatedRowCount(); i++) {
            Row attachr = attachvo.getRowAtRangeIndex(i);
            if (attachr != null)
                attachr.remove();
        }
        return null;
    }

    public String appeal_cassation_action() {
        String key = (String)afu.evaluateEL("#{pageFlowScope.key}");
        Locale localel = (Locale)afu.evaluateEL("#{pageFlowScope.locale}");
        String locale = localel.toString();
        String s = "Y";
        ViewObject caseinfovo = getAm().findViewObject("ReqCaseInfoView1");
        ViewObject reqview = getAm().findViewObject("ReqRequestsViewAC");
        ViewObject corrmistvo = getAm().findViewObject("ReqAppealCasView1");
        Row corrmistr = corrmistvo.getCurrentRow();
        if (corrmistr.getAttribute("CaseNo") != null &&
            corrmistr.getAttribute("CaseYear") != null &&
            corrmistr.getAttribute("ProsecutionName") != null &&
            corrmistr.getAttribute("RelationCase") != null &&
            corrmistr.getAttribute("Apeal") != null) {
            Number cno = (Number)corrmistr.getAttribute("CaseNo");
            Number cyear = (Number)corrmistr.getAttribute("CaseYear");
            String cpname = (String)corrmistr.getAttribute("ProsecutionName");
            int sid = Integer.parseInt(key);
            BigDecimal caseno = new BigDecimal(cno.toString());
            BigDecimal name = new BigDecimal(cpname.toString());
            BigDecimal year = new BigDecimal(cyear.toString());
            String res = this.validatingCase(sid, caseno, name, year);
            if (res.equals("ok")) {
                Row casinfr = caseinfovo.createRow();
                Row reqr = reqview.createRow();
                casinfr.setAttribute("CaseNumber",
                                     corrmistr.getAttribute("CaseNo"));
                casinfr.setAttribute("CaseYear",
                                     corrmistr.getAttribute("CaseYear"));
                casinfr.setAttribute("CaseType",
                                     corrmistr.getAttribute("ProsecutionName"));
                casinfr.setAttribute("Relation",
                                     corrmistr.getAttribute("RelationCase"));
                reqr.setAttribute("ReqName", setServiceNames(locale, key));
                reqr.setAttribute("CaseInfoId",
                                  casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ServiceId", sid);
                corrmistr.setAttribute("CaseInfo",
                                       casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ProsecId",
                                  corrmistr.getAttribute("ProsecutionName"));
                //                uploadedfile_appealcase();
                //                commit_action();
                //                sentEmail((Number)casinfr.getAttribute("CaseId"),
                //                          "Request for appeal in cassation\n");
                //                return "Y";
                java.util.List<UploadedFile> file_u = this.getUploadedfile();
                if (file_u != null) {
                    for (int i = 0; i < file_u.size(); i++) {
                        if ((file_u.get(i).getFilename().endsWith("jpeg")) ||
                            (file_u.get(i).getFilename().endsWith("jpg")) ||
                            (file_u.get(i).getFilename().endsWith("txt")) ||
                            (file_u.get(i).getFilename().endsWith("doc")) ||
                            (file_u.get(i).getFilename().endsWith("gif")) ||
                            (file_u.get(i).getFilename().endsWith("pdf"))) {
                            //                            uploadedfile_appealcase(file_u.get(i));
                            UCMBean ubean = new UCMBean();
                            Number foldern =
                                (Number)reqr.getAttribute("ReqId");

                            String foldername = foldern.toString();
                            if (i == 0) {
                                ubean.createFolder(foldername);
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadedfile_appealcase(file_u.get(i),
                                                        ubean.getDid());
                            } else {
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadedfile_appealcase(file_u.get(i),
                                                        ubean.getDid());
                            }
                        } else {
                            casinfr.remove();
                            reqr.remove();
                            s = "N";
                            FacesContext.getCurrentInstance().addMessage(upFileBind.getClientId(FacesContext.getCurrentInstance()),
                                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                          "File Type extension are not allowed",
                                                                                          "This file (" +
                                                                                          file_u.get(i).getFilename() +
                                                                                          ") is not allowed;Kindly reload the files"));
                        }
                    }
                }
                if (s.equals("Y")) {
                    commit_action();
                    sentEmail((Number)reqr.getAttribute("ReqId"),
                              setServiceNames(locale, key), locale);
                    afu.setEL("#{pageFlowScope.casno}",
                              reqr.getAttribute("ReqId"));
                    oracle.jbo.domain.Number csid =
                        (Number)reqr.getAttribute("ReqId");
                    executeSMSproc((String)ADFContext.getCurrent().getSessionScope().get("mobile"),
                                   csid);
                    return "Y";
                }
            } else {
                return "N";
            }
        }
        if (corrmistr.getAttribute("CaseNo") == null) {
            this.setCn("Y");
        }
        if (corrmistr.getAttribute("CaseYear") == null) {
            this.setCy("Y");
        }
        if ((corrmistr.getAttribute("ProsecutionName") == null) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_en")) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_ar"))) {
            this.setPc("Y");
        }
        if ((corrmistr.getAttribute("RelationCase") == null) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_en")) ||
            (corrmistr.getAttribute("RelationCase").equals("LOV_RelationCase_ar"))) {
            this.setRc("Y");
        }
        if (corrmistr.getAttribute("Apeal") == null) {
            this.setAp("Y");
        }
        return null;
    }


    public String appeal_cassation_FileUploadaction(String did) {
        ViewObject ravo = this.getAm().findViewObject("ReqAttachmentsViewAC");
        Row rar = ravo.createRow();
        rar.setAttribute("DisplayName", fileName);
        rar.setAttribute("ContentType", contentType);
        //        rar.setAttribute("Attachment", blob);
        rar.setAttribute("AttachSize", fileSize);
        rar.setAttribute("AttachDownloadUrl", ubean.downloadAttachUrl());
        ravo.insertRow(rar);
        Number attachid = (Number)rar.getAttribute("Id");
        this.insert_did(attachid, did);
        return null;
    }

    public void uploadedfile_appealcase(UploadedFile file, String did) {
        fileName = file.getFilename();
        contentType = file.getContentType();
        blob = getBlob(file);
        double l = file.getLength();
        double kb = l / 1024;
        double mb = kb / 1024;
        fileSize = df2.format(kb) + " kB";
        if (mb < 10) {
            appeal_cassation_FileUploadaction(did);
        } else {
            FacesMessage Message =
                new FacesMessage("File Size should be less than 10 MB");
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public void setCaseInformationUPFilebind(RichInputFile CaseInformationUPFilebind) {
        this.CaseInformationUPFilebind = CaseInformationUPFilebind;
    }

    public RichInputFile getCaseInformationUPFilebind() {
        return CaseInformationUPFilebind;
    }

    public void setService1UPFilebind(RichInputFile Service1UPFilebind) {
        this.Service1UPFilebind = Service1UPFilebind;
    }

    public RichInputFile getService1UPFilebind() {
        return Service1UPFilebind;
    }

    public String Submit_action() {
        Locale localel = (Locale)afu.evaluateEL("#{pageFlowScope.locale}");
        String locale = localel.toString();
        //        String locale = "en";
        if (this.getBind_efn().getValue() != null &&
            this.getBind_eln().getValue() != null &&
            bind_edob.getValue() != null) {
            try {
                commit_action();
                String emailId =
                    (String)ADFContext.getCurrent().getSessionScope().get("eid");

                if (locale.equals("en")) {
                    FacesMessage Message =
                        new FacesMessage("Your Profile details have been successfully updated.");
                    Message.setSeverity(FacesMessage.SEVERITY_INFO);
                    FacesContext fc = FacesContext.getCurrentInstance();
                    fc.addMessage(null, Message);
                    adfUtils.sendEmail(emailId,
                                       "Your Profile details have been successfully updated.",
                                       "Your Profile details have been successfully updated.");
                }
                if (locale.equals("ar")) {
                    FacesMessage Message =
                        new FacesMessage("تم تحديث حسابك بنجاح");
                    Message.setSeverity(FacesMessage.SEVERITY_INFO);
                    FacesContext fc = FacesContext.getCurrentInstance();
                    fc.addMessage(null, Message);
                    adfUtils.sendEmail(emailId, "تم تحديث حسابك بنجاح",
                                       "تم تحديث حسابك بنجاح");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            if (locale.equals("en")) {
                FacesMessage Message =
                    new FacesMessage("Please enter all details");
                Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, Message);
            }
            if (locale.equals("ar")) {
                FacesMessage Message = new FacesMessage("ادخل جميع البيانات");
                Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, Message);
            }
        }
        return null;
    }

    public void setCb_pwrd(String cb_pwrd) {
        this.cb_pwrd = cb_pwrd;
    }

    public String getCb_pwrd() {
        return cb_pwrd;
    }

    public void setNb_pwrd(String nb_pwrd) {
        this.nb_pwrd = nb_pwrd;
    }

    public String getNb_pwrd() {
        return nb_pwrd;
    }

    public void setCob_pwrd(String cob_pwrd) {
        this.cob_pwrd = cob_pwrd;
    }

    public String getCob_pwrd() {
        return cob_pwrd;
    }

    public String chg_wprd_action() {
        try {
            if (oldpwrd != null && nb_pwrd != null && cob_pwrd != null) {
                BindingContainer bindings = getBindings();
                OperationBinding operationBinding =
                    bindings.getOperationBinding("change_pwrd");
                String result = (String)operationBinding.execute();
                if (result != null) {
                    if (result.equals("Y")) {
                        commit_action();
                        String email =
                            (String)ADFContext.getCurrent().getSessionScope().get("usermail");
                        this.afu.sendEmail(email, "Password has been changed",
                                           "Password has been changed");
                        FacesMessage Message =
                            new FacesMessage("Your password has been changed successfully");
                        Message.setSeverity(FacesMessage.SEVERITY_INFO);
                        FacesContext fc = FacesContext.getCurrentInstance();
                        fc.addMessage(null, Message);
                    }
                    if (result.equals("N")) {
                        FacesMessage Message =
                            new FacesMessage("Cannot able to submit the request. Please get in touch with the administrator");
                        Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                        FacesContext fc = FacesContext.getCurrentInstance();
                        fc.addMessage(null, Message);
                    }
                    if (result.equals("nomatchpwrd")) {
                        FacesMessage Message =
                            new FacesMessage("Confirm password does not match the New Pasword");
                        Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                        FacesContext fc = FacesContext.getCurrentInstance();
                        fc.addMessage(null, Message);
                    }
                    if (result.equals("wrongcurrpwrd")) {
                        FacesMessage Message =
                            new FacesMessage("Current password is wrong");
                        Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                        FacesContext fc = FacesContext.getCurrentInstance();
                        fc.addMessage(null, Message);
                    }
                }

            }
            if (oldpwrd == null)
                cbval = "Y";
            if (nb_pwrd == null)
                nbval = "Y";
            if (cob_pwrd == null)
                cobval = "Y";
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*finally {
            this.setCb_pwrd(null);
            this.setNb_pwrd(null);
            this.setCob_pwrd(null);
        }*/
        return null;
    }

    public String clear_login_action() {
        this.setUn("");
        this.setPwrd("");
        this.showPanel = "N";
        if (!eflag.equals("Y")) {
            this.setEflag("Y");
        }
        return null;

    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    public String getCn() {
        return cn;
    }

    public void setCy(String cy) {
        this.cy = cy;
    }

    public String getCy() {
        return cy;
    }

    public void setPc(String pc) {
        this.pc = pc;
    }

    public String getPc() {
        return pc;
    }

    public void setRc(String rc) {
        this.rc = rc;
    }

    public String getRc() {
        return rc;
    }

    public void setCnopg(RichPanelGroupLayout cnopg) {
        this.cnopg = cnopg;
    }

    public RichPanelGroupLayout getCnopg() {
        return cnopg;
    }

    public void setUploadedfile(List<UploadedFile> uploadedfile) {
        this.uploadedfile = uploadedfile;
    }

    public List<UploadedFile> getUploadedfile() {
        return uploadedfile;
    }

    public void setAn(String an) {
        this.an = an;
    }

    public String getAn() {
        return an;
    }

    public void setPcn(String pcn) {
        this.pcn = pcn;
    }

    public String getPcn() {
        return pcn;
    }

    public void setPcd(String pcd) {
        this.pcd = pcd;
    }

    public String getPcd() {
        return pcd;
    }

    public void setDm(String dm) {
        this.dm = dm;
    }

    public String getDm() {
        return dm;
    }

    public void setLn(String ln) {
        this.ln = ln;
    }

    public String getLn() {
        return ln;
    }

    public void setRs(String rs) {
        this.rs = rs;
    }

    public String getRs() {
        return rs;
    }

    public void setPrn(String prn) {
        this.prn = prn;
    }

    public String getPrn() {
        return prn;
    }

    public void setRr(String rr) {
        this.rr = rr;
    }

    public String getRr() {
        return rr;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getSub() {
        return sub;
    }

    public void setJa(String ja) {
        this.ja = ja;
    }

    public String getJa() {
        return ja;
    }

    public void setCt(String ct) {
        this.ct = ct;
    }

    public String getCt() {
        return ct;
    }

    public void setPn(String pn) {
        this.pn = pn;
    }

    public String getPn() {
        return pn;
    }

    public void setTn(String tn) {
        this.tn = tn;
    }

    public String getTn() {
        return tn;
    }

    public void setRt(String rt) {
        this.rt = rt;
    }

    public String getRt() {
        return rt;
    }

    public void setEt(String et) {
        this.et = et;
    }

    public String getEt() {
        return et;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getCp() {
        return cp;
    }

    public String submitAction() {
        String key = (String)afu.evaluateEL("#{pageFlowScope.key}");
        Locale localel = (Locale)afu.evaluateEL("#{pageFlowScope.locale}");
        String locale = localel.toString();
        //        String locale = "en";
        String s = "Y";
        ViewObject caseinfovo = getAm().findViewObject("ReqCaseInfoView1");
        ViewObject reqview = getAm().findViewObject("ReqRequestsView36");
        ViewObject corrmistvo = getAm().findViewObject("ReqMedicalTrmntView1");
        java.util.List<UploadedFile> file_u = this.getUploadedfile();
        Row corrmistr = corrmistvo.getCurrentRow();
        if (corrmistr.getAttribute("CaseNo") != null &&
            corrmistr.getAttribute("CaseYear") != null &&
            corrmistr.getAttribute("ProsecutionName") != null &&
            corrmistr.getAttribute("RelationWithcase") != null &&
            corrmistr.getAttribute("Inmate") != null &&
            corrmistr.getAttribute("DiseasesType") != null && file_u != null) {
            Number cno = (Number)corrmistr.getAttribute("CaseNo");
            Number cyear = (Number)corrmistr.getAttribute("CaseYear");
            String cpname = (String)corrmistr.getAttribute("ProsecutionName");
            //            String res = check_case_info_common(cyear, cpname, cno);
            int sid = Integer.parseInt(key);
            BigDecimal caseno = new BigDecimal(cno.toString());
            BigDecimal name = new BigDecimal(cpname.toString());
            BigDecimal year = new BigDecimal(cyear.toString());
            String res = this.validatingCase(sid, caseno, name, year);
            if (res.equals("ok")) {
                Row casinfr = caseinfovo.createRow();
                Row reqr = reqview.createRow();
                casinfr.setAttribute("CaseNumber",
                                     corrmistr.getAttribute("CaseNo"));
                casinfr.setAttribute("CaseYear",
                                     corrmistr.getAttribute("CaseYear"));
                casinfr.setAttribute("CaseType",
                                     corrmistr.getAttribute("ProsecutionName"));
                casinfr.setAttribute("Relation",
                                     corrmistr.getAttribute("RelationWithcase"));
                reqr.setAttribute("ReqName", setServiceNames(locale, key));
                reqr.setAttribute("CaseInfoId",
                                  casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ServiceId", sid);
                corrmistr.setAttribute("CaseInfo",
                                       casinfr.getAttribute("CaseId"));
                reqr.setAttribute("ProsecId",
                                  corrmistr.getAttribute("ProsecutionName"));
                uploadFile_medrprtfile();
                /*uploadFile_medtrmnt();
                commit_action();
                sentEmail((Number)casinfr.getAttribute("CaseId"),
                          "Medical Treatment Release");
                return "Y";*/
                if (file_u != null) {
                    String validateFile = validateFileUpload(file_u);
                    if (validateFile.equals("N")) {
                        for (int i = 0; i < file_u.size(); i++) {
                            Number foldern =
                                (Number)reqr.getAttribute("ReqId");
                            String foldername = foldern.toString();
                            if (i == 0) {
                                ubean.createFolder(foldername);
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadFile_medtrmnt(file_u.get(i),
                                                    ubean.getDid());
                            } else {
                                ubean.uploadedFile(foldername, file_u.get(i),
                                                   foldername);
                                uploadFile_medtrmnt(file_u.get(i),
                                                    ubean.getDid());
                            }
                        }
                    } else {
                        casinfr.remove();
                        reqr.remove();
                        s = "N";
                        FacesContext.getCurrentInstance().addMessage(upFileBind.getClientId(FacesContext.getCurrentInstance()),
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                      "File Type extension are not allowed",
                                                                                      "Kindly reload the files"));
                    }
                }
                if (s.equals("Y")) {
                    commit_action();
                    sentEmail((Number)reqr.getAttribute("ReqId"),
                              setServiceNames(locale, key), locale);
                    afu.setEL("#{pageFlowScope.casno}",
                              reqr.getAttribute("ReqId"));
                    oracle.jbo.domain.Number csid =
                        (Number)reqr.getAttribute("ReqId");
                    executeSMSproc((String)ADFContext.getCurrent().getSessionScope().get("mobile"),
                                   csid);
                    return "Y";
                }
            } else {
                return "N";
            }
        }
        if (corrmistr.getAttribute("CaseNo") == null) {
            this.setCn("Y");
        }
        if (corrmistr.getAttribute("CaseYear") == null) {
            this.setCy("Y");
        }
        if ((corrmistr.getAttribute("ProsecutionName") == null) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_en")) ||
            (corrmistr.getAttribute("ProsecutionName").equals("LOV_pn_ar"))) {
            this.setPc("Y");
        }
        if ((corrmistr.getAttribute("RelationWithcase") == null) ||
            (corrmistr.getAttribute("RelationWithcase").equals("LOV_RelationCase_en")) ||
            (corrmistr.getAttribute("RelationWithcase").equals("LOV_RelationCase_ar"))) {
            this.setRc("Y");
        }
        if (corrmistr.getAttribute("Inmate") == null) {
            this.setIn("Y");
        }
        if (corrmistr.getAttribute("DiseasesType") == null) {
            this.setDt("Y");
        }
        if (corrmistr.getAttribute("MedicalReport") == null) {
            this.setMr("Y");
        }
        if (file_u == null) {
            mrprt = "Y";
        }
        return null;
    }

    public void uploadFile_medtrmnt(UploadedFile file, String did) {
        fileName = file.getFilename();
        contentType = file.getContentType();
        blob = getBlob(file);
        double l = file.getLength();
        double kb = l / 1024;
        double mb = kb / 1024;
        fileSize = df2.format(kb) + " kB";
        if (mb < 10) {
            medtrmnt_FileUploadaction(did);
        } else {
            FacesMessage Message =
                new FacesMessage("File Size should be less than 10 MB");
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public String medtrmnt_FileUploadaction(String did) {
        ViewObject ravo = this.getAm().findViewObject("ReqAttachmentsView36");
        Row rar = ravo.createRow();
        rar.setAttribute("DisplayName", fileName);
        rar.setAttribute("ContentType", contentType);
        //        rar.setAttribute("Attachment", blob);
        rar.setAttribute("AttachSize", fileSize);
        rar.setAttribute("AttachDownloadUrl", ubean.downloadAttachUrl());
        ravo.insertRow(rar);
        //        FacesMessage Message = new FacesMessage("File Uploaded successfully");
        //        Message.setSeverity(FacesMessage.SEVERITY_INFO);
        //        FacesContext fc = FacesContext.getCurrentInstance();
        //        fc.addMessage(null, Message);
        //        System.out.println("File Uploaded successfully");
        //        this.excBillUpFileBind.resetValue();
        Number attachid = (Number)rar.getAttribute("Id");
        this.insert_did(attachid, did);
        return null;
    }

    public void uploadFile_medrprtfile() {
        _logger.info("Started executing file upload");
        List<UploadedFile> file_u = this.getUploadedMedfile();
        if (file_u != null) {
            for (int i = 0; i < file_u.size(); i++) {
                blob = getBlob(file_u.get(i));
                medrprt_FileUploadaction();
            }
        }
    }

    public String medrprt_FileUploadaction() {
        ViewObject ravo = this.getAm().findViewObject("ReqMedicalRprtView2");
        Row rar = ravo.createRow();
        rar.setAttribute("MedicalReport", blob);
        ravo.insertRow(rar);
        return null;
    }


    public void setIn(String in) {
        this.in = in;
    }

    public String getIn() {
        return in;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public String getDt() {
        return dt;
    }

    public void setUploadedMedfile(List<UploadedFile> uploadedMedfile) {
        this.uploadedMedfile = uploadedMedfile;
    }

    public List<UploadedFile> getUploadedMedfile() {
        return uploadedMedfile;
    }

    public void DropCourtClearActionList(ActionEvent actionEvent) {
        ViewObject vo = this.getAm().findViewObject("ReqCaseInfoView1");
        ViewObject vo2 = this.getAm().findViewObject("ReqRequestsView23");
        clearViewObjects(vo, vo2);
    }

    public oracle.jbo.domain.Date currentDate() {

        oracle.jbo.domain.Date cdate =
            new oracle.jbo.domain.Date(new java.sql.Date(new java.util.Date().getTime()));

        return cdate;

    }

    public void clearViewObjects(ViewObject vo1, ViewObject vo2) {
        /*Row row1 = vo1.getCurrentRow();
        row1.remove();
        Row row2 = vo2.getCurrentRow();
        row2.remove();*/
    }

    public void setPr(String pr) {
        this.pr = pr;
    }

    public String getPr() {
        return pr;
    }

    public void setSd(String sd) {
        this.sd = sd;
    }

    public String getSd() {
        return sd;
    }

    public void ProsNameCheckVCL(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (this.getPc().equals("N")) {
                this.setPc("N");
            }
        }
    }

    public void CaseYearCheckVCL(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (this.getCy().equals("N")) {
                this.setCy("N");
            }
        }
    }

    public void CaseNoCheckVCL(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (this.getCn().equals("N")) {
                this.setCn("N");
            }
        }
    }

    public void RelationCaseCheckVCL(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (this.getRc().equals("N")) {
                this.setRc("N");
            }
        }
    }

    public void PostponeReasonCheckVCL(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (this.getPr().equals("N")) {
                this.setPr("N");
            }
        }
    }

    public void SessionDateCheckVCL(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (this.getSd().equals("N")) {
                this.setSd("N");
            }
        }
    }

    public void ErrorTypeCheckVCL(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (this.getEt().equals("N")) {
                this.setEt("N");
            }
        }
    }

    public void CorrectedPhaseCheckVCL(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (this.getSd().equals("N")) {
                this.setSd("N");
            }
        }
    }

    public void PersCaptureNameCheckVCL(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (this.getPcn().equals("N")) {
                this.setPcn("N");
            }
        }
    }

    public void PersCaptureDataCheckVCL(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (this.getPcd().equals("N")) {
                this.setPcd("N");
            }
        }
    }

    public void InmateCheckVCL(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (this.getIn().equals("N")) {
                this.setIn("N");
            }
        }
    }

    public void DiseaseTypeCheckVCL(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (this.getDt().equals("N")) {
                this.setDt("N");
            }
        }
    }

    public void DepositMoneyCheckVCL(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (this.getDm().equals("N")) {
                this.setDm("N");
            }
        }
    }

    public void AccusedNameCheckVCL(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (this.getAn().equals("N")) {
                this.setAn("N");
            }
        }
    }

    public void lbanNumberCheckVCL(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (this.getLn().equals("N")) {
                this.setLn("N");
            }
        }
    }

    public void judgementAgainstCheckVCL(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (this.getJa().equals("N")) {
                this.setJa("N");
            }
        }
    }

    public void FineamountCheckVCL(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (this.getRc().equals("N")) {
                this.setRc("N");
            }
        }
    }

    public void installAmountCheckVCL(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (this.getIa().equals("N")) {
                this.setIa("N");
            }
        }
    }

    public void setIa(String ia) {
        this.ia = ia;
    }

    public String getIa() {
        return ia;
    }

    public void ReasonCheckVCL(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (this.getRs().equals("N")) {
                this.setRs("N");
            }
        }
    }

    public void contractNumberVCL(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (this.getCn().equals("N")) {
                this.setCn("N");
            }
        }
    }

    public void defendentNameVCL(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (this.getDm().equals("N")) {
                this.setDm("N");
            }
        }
    }

    public void requestSubjectVCL(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (this.getRr().equals("N")) {
                this.setRr("N");
            }
        }
    }

    public void prisonerNameVCL(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (this.getPrn().equals("N")) {
                this.setPrn("N");
            }
        }
    }

    public void requestReasonVCL(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (this.getRs().equals("N")) {
                this.setRs("N");
            }
        }
    }

    public void certificateTypeVCL(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (this.getRc().equals("N")) {
                this.setRc("N");
            }
        }
    }

    public void prisonNameVCL(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (this.getPn().equals("N")) {
                this.setPn("N");
            }
        }
    }

    public void telephoneNumberVCL(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (this.getTn().equals("N")) {
                this.setTn("N");
            }
        }
    }

    public void subjectVCL(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (this.getSub().equals("N")) {
                this.setSub("N");
            }
        }
    }

    public void setWn(String wn) {
        this.wn = wn;
    }

    public String getWn() {
        return wn;
    }

    public void witnessNameVCL(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (this.getWn().equals("N")) {
                this.setWn("N");
            }
        }
    }

    public void setAp(String ap) {
        this.ap = ap;
    }

    public String getAp() {
        return ap;
    }

    public void appealVCL(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (this.getAp().equals("N")) {
                this.setAp("N");
            }
        }
    }

    public void restraintTypeVCL(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (this.getRt().equals("N")) {
                this.setRt("N");
            }
        }
    }

    public void setFa(String fa) {
        this.fa = fa;
    }

    public String getFa() {
        return fa;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public String getLog() {
        return log;
    }

    public void setP_val(String p_val) {
        this.p_val = p_val;
    }

    public String getP_val() {
        return p_val;
    }

    public void setP_num(int p_num) {
        this.p_num = p_num;
    }

    public int getP_num() {
        return p_num;
    }

    public String printAction() {
        String javascriptCode = "window.print();";
        FacesContext facesCtx = FacesContext.getCurrentInstance();
        ExtendedRenderKitService service =
            Service.getRenderKitService(facesCtx,
                                        ExtendedRenderKitService.class);
        service.addScript(facesCtx, javascriptCode);
        return null;
    }

    public oracle.jbo.domain.Date getCurrentDate() {

        oracle.jbo.domain.Date cdate =
            new oracle.jbo.domain.Date(new java.sql.Date(new java.util.Date().getTime()));

        return cdate;

    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void logOutAction(ActionEvent actionEvent) {
        this.setLog("");
        ADFContext.getCurrent().getSessionScope().put("login", "");
    }

    public void setShowPanel(String showPanel) {
        this.showPanel = showPanel;
    }

    public String getShowPanel() {
        return showPanel;
    }

    public void setCd(String cd) {
        this.cd = cd;
    }

    public String getCd() {
        return cd;
    }

    public void setSr(String sr) {
        this.sr = sr;
    }

    public String getSr() {
        return sr;
    }

    public void setDr(String dr) {
        this.dr = dr;
    }

    public String getDr() {
        return dr;
    }

    public void setAcn(String acn) {
        this.acn = acn;
    }

    public String getAcn() {
        return acn;
    }

    public void setNt(String nt) {
        this.nt = nt;
    }

    public String getNt() {
        return nt;
    }

    public void setSb(String sb) {
        this.sb = sb;
    }

    public String getSb() {
        return sb;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getAddr() {
        return addr;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getMob() {
        return mob;
    }

    public void setSntdte(String sntdte) {
        this.sntdte = sntdte;
    }

    public String getSntdte() {
        return sntdte;
    }

    public void setIt(String it) {
        this.it = it;
    }

    public String getIt() {
        return it;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setBind_username(RichInputText bind_username) {
        this.bind_username = bind_username;
    }

    public RichInputText getBind_username() {
        return bind_username;
    }

    public void setBind_pwrd(RichInputText bind_pwrd) {
        this.bind_pwrd = bind_pwrd;
    }

    public RichInputText getBind_pwrd() {
        return bind_pwrd;
    }

    public void setErun(String erun) {
        this.erun = erun;
    }

    public String getErun() {
        return erun;
    }

    public void setErpwrd(String erpwrd) {
        this.erpwrd = erpwrd;
    }

    public String getErpwrd() {
        return erpwrd;
    }

    public void setEd(String ed) {
        this.ed = ed;
    }

    public String getEd() {
        return ed;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPid() {
        return pid;
    }

    public void setPno(String pno) {
        this.pno = pno;
    }

    public String getPno() {
        return pno;
    }

    public void setDs(String ds) {
        this.ds = ds;
    }

    public String getDs() {
        return ds;
    }

    public void setVd(String vd) {
        this.vd = vd;
    }

    public String getVd() {
        return vd;
    }

    public void setPrid(String prid) {
        this.prid = prid;
    }

    public String getPrid() {
        return prid;
    }

    public void setVp(String vp) {
        this.vp = vp;
    }

    public String getVp() {
        return vp;
    }

    public void setVisitInfo(String visitInfo) {
        this.visitInfo = visitInfo;
    }

    public String getVisitInfo() {
        return visitInfo;
    }

    public void setVremail(String vremail) {
        this.vremail = vremail;
    }

    public String getVremail() {
        return vremail;
    }

    public void setVrphone(String vrphone) {
        this.vrphone = vrphone;
    }

    public String getVrphone() {
        return vrphone;
    }

    public void setVrrelation(String vrrelation) {
        this.vrrelation = vrrelation;
    }

    public String getVrrelation() {
        return vrrelation;
    }

    /**
     *  Delete the current row from visiting a provisional detainee.
     */
    public String deleteRow() {
        //        BindingContext bindingctx = BindingContext.getCurrent();
        //                BindingContainer binding = bindingctx.getCurrentBindingsEntry();
        //                DCBindingContainer bindingsImpl = (DCBindingContainer)binding;
        //                DCIteratorBinding dciter = bindingsImpl.findIteratorBinding("ReqPrisonerVisitorsInfoView1Iterator");
        //                Row currentRow = dciter.getCurrentRow();
        //                currentRow.remove();
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding =
            bindings.getOperationBinding("getRowDelete");
        operationBinding.execute();
        return null;
    }


    public void setCbval(String cbval) {
        this.cbval = cbval;
    }

    public String getCbval() {
        return cbval;
    }

    public void setNbval(String nbval) {
        this.nbval = nbval;
    }

    public String getNbval() {
        return nbval;
    }

    public void setCobval(String cobval) {
        this.cobval = cobval;
    }

    public String getCobval() {
        return cobval;
    }

    public void setBind_efn(RichInputText bind_efn) {
        this.bind_efn = bind_efn;
    }

    public RichInputText getBind_efn() {
        return bind_efn;
    }

    public void setBind_eln(RichInputText bind_eln) {
        this.bind_eln = bind_eln;
    }

    public RichInputText getBind_eln() {
        return bind_eln;
    }

    public void setBind_edob(RichInputDate bind_edob) {
        this.bind_edob = bind_edob;
    }

    public RichInputDate getBind_edob() {
        return bind_edob;
    }

    public void setMr(String mr) {
        this.mr = mr;
    }

    public String getMr() {
        return mr;
    }

    public void setOldpwrd(String oldpwrd) {
        this.oldpwrd = oldpwrd;
    }

    public String getOldpwrd() {
        return oldpwrd;
    }

    public void setIntPhotoUpload(UploadedFile intPhotoUpload) {
        this.intPhotoUpload = intPhotoUpload;
    }

    public UploadedFile getIntPhotoUpload() {
        return intPhotoUpload;
    }

    public void setJd(String jd) {
        this.jd = jd;
    }

    public String getJd() {
        return jd;
    }

    public void setPcp(String pcp) {
        this.pcp = pcp;
    }

    public String getPcp() {
        return pcp;
    }

    public void setMrprt(String mrprt) {
        this.mrprt = mrprt;
    }

    public String getMrprt() {
        return mrprt;
    }

    public void setSpn(String spn) {
        this.spn = spn;
    }

    public String getSpn() {
        return spn;
    }

    public void installmentVCL(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            ViewObject ravo =
                getAm().findViewObject("ReqFinebalanceInstallmentsView1");
            ravo.executeQuery();
            int vnewvalue = (Integer)vce.getNewValue();
            for (int i = 0; i < vnewvalue + 1; i++) {
                //                BindingContainer bindings = BindingContext.getCurrent().getCurrentBindingsEntry();
                //                OperationBinding method = bindings.getOperationBinding("CreateInsert");
                //                method.execute();
                ViewObject finbalinstallview =
                    getAm().findViewObject("ReqFinebalanceInstallmentsView1");
                Row finbalinstallRow = finbalinstallview.createRow();
                finbalinstallview.insertRow(finbalinstallRow);
            }
        }
    }

    public String checkInstalAmt() {
        String check = "N";
        BigDecimal finamt = new BigDecimal("0");
        BigDecimal instamt = new BigDecimal("0");
        ViewObject finbalinstallview =
            getAm().findViewObject("ReqFinebalanceInstallmentsView1");
        ViewObject payinscourtview =
            getAm().findViewObject("ReqPaymentinsCourtView1");
        if (payinscourtview != null && finbalinstallview != null) {
            Row payinscourtrow = payinscourtview.getCurrentRow();
            if (payinscourtrow != null) {
                finamt = (BigDecimal)payinscourtrow.getAttribute("FineAmount");
                for (int finbal = 0;
                     finbal < finbalinstallview.getEstimatedRowCount();
                     finbal++) {
                    Row finbalinstallrow =
                        finbalinstallview.getRowAtRangeIndex(finbal);
                    if (finbalinstallrow != null) {
                        //                    instamt = (BigDecimal)finbalinstallrow.getAttribute("PayAmount");
                        if (finbalinstallrow.getAttribute("PayAmount") !=
                            null) {
                            instamt =
                                    instamt.add((BigDecimal)finbalinstallrow.getAttribute("PayAmount"));
                        }
                        if (instamt == null) {
                            ins = "Y";
                        }
                        if (finbalinstallrow.getAttribute("PayDate") == null) {
                            pd = "Y";
                        }
                    }
                }
                if (instamt != null && finamt != null) {
                    if (instamt.equals(finamt)) {
                        check = "Y";
                    }
                }
            }
        }
        return check;
    }

    public void setIns(String ins) {
        this.ins = ins;
    }

    public String getIns() {
        return ins;
    }

    public void setPd(String pd) {
        this.pd = pd;
    }

    public String getPd() {
        return pd;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setPtm(String ptm) {
        this.ptm = ptm;
    }

    public String getPtm() {
        return ptm;
    }

    public void setMc(String mc) {
        this.mc = mc;
    }

    public String getMc() {
        return mc;
    }
}

