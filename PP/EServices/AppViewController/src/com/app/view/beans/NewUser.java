package com.app.view.beans;

import com.app.model.services.PPAppServicesImpl;

import com.tacme.pp.common.utils.ADFUtils;

import com.tacme.pp.common.utils.EmailUtils;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;

import java.sql.CallableStatement;
import java.sql.SQLException;

import java.util.Calendar;
import java.util.Date;

import java.util.Locale;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpServletRequest;

import nl.captcha.Captcha;

import oracle.adf.model.BindingContext;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.JboException;
import oracle.jbo.Row;
import oracle.jbo.domain.Number;
import oracle.jbo.server.DBTransactionImpl;

public class NewUser implements Serializable {
    @SuppressWarnings("compatibility:30144492988622173")
    private static final long serialVersionUID = 1L;
    private String _email = "N";
    private String _chpwrd = "N";
    private String _cpwrd = "N";
    private String _fname = "N";
    private String _lname = "N";
    private String _faname = "N";
    private String _mob = "N";
    private String _dob = "N";
    private String _na = "N";
    private String _eidno = "N";
    private String _edate = "N";
    private String _rlang = "N";
    private String _acepttrm = "N";
    private RichSelectBooleanCheckbox acceptterms;
    private RichInputText chgPwrdBind;
    private RichInputText email_bind;
    private String b_email;
    private String _errCnfirm = "N";
    private RichPopup loginPopupBind;
    private Date maxDateVal;
    private RichInputText captchaBind;
    private RichInputText mobile_bind;
    //    private String null;

    public NewUser() {
    }

    public Date getMaxDateVal() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, 0);
        return cal.getTime();

    }

    public oracle.jbo.domain.Date getCurrentDate() {

        oracle.jbo.domain.Date cdate =
            new oracle.jbo.domain.Date(new java.sql.Date(new java.util.Date().getTime()));

        return cdate;

    }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public String userReg() {
        String res = null;
        try {
            BindingContainer bindings = getBindings();
            OperationBinding operationBinding =
                bindings.getOperationBinding("emailExist");
            String emailexist = (String)operationBinding.execute();
            if (emailexist.equals("notexist")) {
                FacesContext fctx = FacesContext.getCurrentInstance();
                ExternalContext ectx = fctx.getExternalContext();
                HttpServletRequest request =
                    (HttpServletRequest)ectx.getRequest();
                Captcha captcha =
                    (Captcha)ectx.getSessionMap().get(Captcha.NAME);
                request.setCharacterEncoding("UTF-8");
                String myAnswer =
                    (String)ectx.getRequestMap().get("bestGuess");
                if (myAnswer != null && captcha.isCorrect(myAnswer)) {
                    String g = "N";
                    AppService aservice = new AppService();
                    String cfpwrd = aservice.getErun();
                    DCIteratorBinding dciter =
                        ADFUtils.findIterator("PuPublicuserView1Iterator");
                    Row iterrow = dciter.getCurrentRow();
                    if (cfpwrd == "Y") {
                        FacesMessage Message =
                            new FacesMessage("Password does not match.");
                        Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                        FacesContext fc = FacesContext.getCurrentInstance();
                        fc.addMessage(null, Message);
                        g = "Y";
                    }
                    if (iterrow.getAttribute("Email") == null) {
                        _email = "Y";
                        g = "Y";
                    }
                    if (iterrow.getAttribute("Password") == null) {
                        _cpwrd = "Y";
                        g = "Y";
                    }
                    if (iterrow.getAttribute("FirstName") == null) {
                        _fname = "Y";
                        g = "Y";
                    }
                    if (iterrow.getAttribute("LastName") == null) {
                        _lname = "Y";
                        g = "Y";
                    }
                    if (iterrow.getAttribute("Mobile") == null) {
                        _mob = "Y";
                        g = "Y";
                    }
                    if (iterrow.getAttribute("DateOfBirth") == null) {
                        _dob = "Y";
                        g = "Y";
                    }
                    if (iterrow.getAttribute("Nationality") == null) {
                        _na = "Y";
                        g = "Y";
                    }
                    if (iterrow.getAttribute("EmiratesId") == null) {
                        _eidno = "Y";
                        g = "Y";
                    }
                    if (iterrow.getAttribute("EmiratesIdExpiry") == null) {
                        _edate = "Y";
                        g = "Y";
                    }
                    if (iterrow.getAttribute("RegistrationLang") == null) {
                        _rlang = "Y";
                        g = "Y";
                    }
                    if (iterrow.getAttribute("chgpwrd") == null) {
                        _chpwrd = "Y";
                        g = "Y";
                    }
                    if ((this.acceptterms.getValue().equals(true)) &&
                        (g == "N")) {
                        String emailid = (String)email_bind.getValue();
                        String subj =
                            " PP E-services Registration التسجيل بالخدمات الالكترونية للنيابة العامة";
                        String txt = "";
                        txt +=
"عزيزي المستخدم تم استقبال طلب التسجيل الخاص بك و هو الأن تحت قيد التنفيذ\n" +
                                "Your registration is received and it is under approval process.\n";

                        OperationBinding copbind =
                            bindings.getOperationBinding("Commit");
                        copbind.execute();
                        res = "reg";
                        ADFUtils au = new ADFUtils();
                        EmailUtils.sendEmail(emailid, subj, txt);

                        // RichPopup.PopupHints hints = new RichPopup.PopupHints();
                        //                    this.getLoginPopupBind().show(hints);
                        executeSMSproc((String)this.mobile_bind.getValue());
                        if (!operationBinding.getErrors().isEmpty()) {
                            System.out.println("///// inside the isempty method");
                        }
                    } else {
                        _acepttrm = "Y";
                    }
                } else {
                    FacesMessage Message =
                        new FacesMessage("Please verify captcha.");
                    Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                    FacesContext fc = FacesContext.getCurrentInstance();
                    fc.addMessage(null, Message);

                }
                System.out.println("<-------------------Returning rest :: " +
                                   res);
                return res;
            } else {
                FacesMessage Message =
                    new FacesMessage("Email has been already registered");
                Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, Message);
            }


        } catch (UnsupportedEncodingException e) {
        }

        return res;
    }

    public void executeSMSproc(String p_mobno) {
        String subj = null;
        try {
            for (int i = 0; i <= 1; i++) {
                if (i == 0) {
                    subj =
"Your registration is received and it is under approval process.";
                } else if (i == 1) {
                    subj =
"عزيزي المستخدم تم استقبال طلب التسجيل الخاص بك و هو الأن تحت قيد التنفيذ";
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

    public void setEmail(String _email) {
        this._email = _email;
    }

    public String getEmail() {
        return _email;
    }

    public void setChpwrd(String _chpwrd) {
        this._chpwrd = _chpwrd;
    }

    public String getChpwrd() {
        return _chpwrd;
    }

    public void setCpwrd(String _cpwrd) {
        this._cpwrd = _cpwrd;
    }

    public String getCpwrd() {
        return _cpwrd;
    }

    public void setFname(String _fname) {
        this._fname = _fname;
    }

    public String getFname() {
        return _fname;
    }

    public void setLname(String _lname) {
        this._lname = _lname;
    }

    public String getLname() {
        return _lname;
    }

    public void setFaname(String _faname) {
        this._faname = _faname;
    }

    public String getFaname() {
        return _faname;
    }

    public void setMob(String _mob) {
        this._mob = _mob;
    }

    public String getMob() {
        return _mob;
    }

    public void setDob(String _dob) {
        this._dob = _dob;
    }

    public String getDob() {
        return _dob;
    }

    public void setNa(String _na) {
        this._na = _na;
    }

    public String getNa() {
        return _na;
    }

    public void setEidno(String _eidno) {
        this._eidno = _eidno;
    }

    public String getEidno() {
        return _eidno;
    }

    public void setEdate(String _edate) {
        this._edate = _edate;
    }

    public String getEdate() {
        return _edate;
    }

    public void setRlang(String _rlang) {
        this._rlang = _rlang;
    }

    public String getRlang() {
        return _rlang;
    }

    public void setAcceptterms(RichSelectBooleanCheckbox acceptterms) {
        this.acceptterms = acceptterms;
    }

    public RichSelectBooleanCheckbox getAcceptterms() {
        return acceptterms;
    }

    public void setAcepttrm(String _acepttrm) {
        this._acepttrm = _acepttrm;
    }

    public String getAcepttrm() {
        return _acepttrm;
    }

    public void acceptterm_vcl(ValueChangeEvent vce) {

    }

    public void setChgPwrdBind(RichInputText chgPwrdBind) {
        this.chgPwrdBind = chgPwrdBind;
    }

    public RichInputText getChgPwrdBind() {
        return chgPwrdBind;
    }

    public void PasswordValidator(ValueChangeEvent vce) {
        //        String chk = "N";
        //        String value = new String();
        //        value = (String)vce.getNewValue();
        //        if (value.length() > 8) {
        //            if (value.matches("[A-Za-z0-9]+")) {
        //                chk = "Y";
        //            }
        //        } else {
        //            chk = "Y";
        //        }
        //        if (chk.equals("Y")) {
        //            FacesMessage Message =
        //                new FacesMessage("Password should be alphanumeric and should have minimum 8 characters");
        //            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
        //            FacesContext fc = FacesContext.getCurrentInstance();
        //            fc.addMessage(null, Message);
        //        }
    }

    public void emailValidator(ValueChangeEvent vce) {
        String EMAIL_REGEX =
            "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        String email = (String)vce.getNewValue();
        Boolean b = email.matches(EMAIL_REGEX);
        if (b.equals(false)) {
            FacesMessage Message =
                new FacesMessage("Enter valid EMail address");
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public void setEmail_bind(RichInputText email_bind) {
        this.email_bind = email_bind;
    }

    public RichInputText getEmail_bind() {
        return email_bind;
    }

    public void setB_email(String b_email) {
        this.b_email = b_email;
    }

    public String getB_email() {
        return b_email;
    }

    public String submit_action() {
        if (b_email != null) {
            BindingContainer bindings = getBindings();
            OperationBinding operationBinding =
                bindings.getOperationBinding("setPassword");
            String result = (String)operationBinding.execute();
            if (result != null) {
                if (result.equals("notreg")) {
                    String locale = "";
                    String msg = "";
                    try {
                        locale =
                                ((Locale)ADFUtils.evaluateEL("#{pageFlowScope.locale}")).toString();
                    } catch (Exception e) {
                        locale = "ar";
                    }
                    if (locale == "en") {
                        msg =
                        "This email has not been registered with us before";
                    } else {
                        msg =
                        "هذا البريد الالكتروني غير مسجل لدينا يرجى التأكد من البريد الالكتروني ";
                       
                    }

                    FacesMessage Message = new FacesMessage(msg);
                    Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                    FacesContext fc = FacesContext.getCurrentInstance();
                    fc.addMessage(null, Message);
                } else {
                    ADFUtils afu = new ADFUtils();
                    String subj = "Password has been generated";
                    String txt =
                        "Password has been reset. The new password is : " +
                        result;
                    EmailUtils.sendEmail(b_email, subj, txt);
                    OperationBinding commitob =
                        bindings.getOperationBinding("Commit");
                    commitob.execute();
                    String locale = "";
                    String msg = "";
                    try {
                        locale =
                                ((Locale)ADFUtils.evaluateEL("#{pageFlowScope.locale}")).toString();
                    } catch (Exception e) {
                        locale = "ar";
                    }
                    if (locale == "en") {
                        msg =
                        "Password has been sent to the registered email id";
                    } else {
                        msg =
                        "تم ارسل كلمة السر إلى البريد الالكتروني الخاص بك المسجل لدينا ";
                       
                    }

                    FacesMessage Message = new FacesMessage(msg);
                    Message.setSeverity(FacesMessage.SEVERITY_INFO);
                    FacesContext fc = FacesContext.getCurrentInstance();
                    fc.addMessage(null, Message);
                }
            }
        } else {
            String locale = "";
            String msg = "";
            try {
                locale =
                        ((Locale)ADFUtils.evaluateEL("#{pageFlowScope.locale}")).toString();
            } catch (Exception e) {
                locale = "ar";
            }
            if (locale == "en") {
                msg = "Please enter the email address correctly";
            } else {
                
                msg = "ادخل البريد الالكتروني صحيح  ";
            }
            FacesMessage Message = new FacesMessage(msg);
            Message.setSeverity(FacesMessage.SEVERITY_INFO);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
        b_email = "";
        return null;
    }

    public void setErrCnfirm(String _errCnfirm) {
        this._errCnfirm = _errCnfirm;
    }

    public String getErrCnfirm() {
        return _errCnfirm;
    }

    public void setLoginPopupBind(RichPopup loginPopupBind) {
        this.loginPopupBind = loginPopupBind;
    }

    public RichPopup getLoginPopupBind() {
        return loginPopupBind;
    }

    public void setMaxDateVal(Date maxDateVal) {
        this.maxDateVal = maxDateVal;
    }

    public void clearAction(ActionEvent actionEvent) {
        //        CustomValidators cv = new CustomValidators();
        //        System.out.println ("Value obtained :: "+cv.getChgPwrdBind().getValue());
        //        getChgPwrdBind().resetValue();
    }

    public String refreshCaptcha() {
        this.getCaptchaBind().setValue("");
        return null;
    }

    public void setCaptchaBind(RichInputText captchaBind) {
        this.captchaBind = captchaBind;
    }

    public RichInputText getCaptchaBind() {
        return captchaBind;
    }

    public void setMobile_bind(RichInputText mobile_bind) {
        this.mobile_bind = mobile_bind;
    }

    public RichInputText getMobile_bind() {
        return mobile_bind;
    }
}

