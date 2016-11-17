package com.app.view.beans;

import com.tacme.pp.common.utils.ADFUtils; 

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Iterator;

import java.util.Locale;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.validator.ValidatorException;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.jbo.JboException;
import oracle.jbo.ViewObject;

import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

public class CustomValidators implements Serializable {
    @SuppressWarnings("compatibility:5958497688751937115")
    private static final long serialVersionUID = 1L;
    private ADFUtils afu = new ADFUtils();
    private RichInputText chgPwrdBind;

    public CustomValidators() {
        super();
    }

    //******************************Number validator*********************************************

    public void numberValidator(FacesContext facesContext,
                                UIComponent uIComponent, Object object) {
        if (object instanceof Number) {

        } else
            onSetFocus("it1");
        onSetFocus("it2");
        throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                      "Entered object is not number",
                                                      "Please enter the number"));

    }

    //******************************String validator*********************************************

    public void chkStringValidator(FacesContext facesContext,
                                   UIComponent uIComponent, Object object) {
        if (object.getClass() == Number.class) {
            onSetFocus("csvt1");
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                          "Entered object is not String",
                                                          "Please enter the String"));
        }
    }    
   

    // **************************** Case No Validator ********************************************

    public void caseNoValidator(FacesContext facesContext,
                                UIComponent uIComponent, Object object) {
//        Locale localel = (Locale)afu.evaluateEL("#{pageFlowScope.locale}");
//        String locale = localel.toString();
        String locale = "en";
        try {
            String s = object.toString(); 
            System.out.println ("<----------Get the length--------->"+this.isNumeric(s));
            if (s.length() > 6) {
                onSetFocus("it1");
                if (locale.equals("en")){
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                              "Case no not valid",
                                                              "Enter the valid 6 digit case number"));
                }else if(locale.equals("ar")){
                    throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                  "رقم القضية غير صحيح",
                                                                  "ادخل 6 ارقام صحيحة"));
                }
            }
        } catch (Exception e) {
            onSetFocus("it1");
            if (locale.equals("en")){
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                          "Case no not valid",
                                                          "Enter the valid 6 digit case number"));
            }else if(locale.equals("ar")){
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                              "رقم القضية غير صحيح",
                                                              "ادخل 6 ارقام صحيحة"));
            }
        }
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

    // **************************** Password Validator ********************************************

    public void passwordValidator(FacesContext facesContext,
                                  UIComponent uIComponent, Object object) {
        String chgpwrd = (String)getChgPwrdBind().getValue();
        String pwrd = object.toString();
        if (!pwrd.equals(chgpwrd)) {
            onSetFocus("cp1");
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                          "Password does not match the criteria",
                                                          "Password does not match with the confirm password"));
        }
    }

    //*****************************Passowrd condition validator ********************************************

    public void passwordCondValidator(FacesContext facesContext,
                                      UIComponent uIComponent, Object object) {
        String chk = "N";
        String pwrd = object.toString();
        if (isNumeric(pwrd) == false) {
            chk = "Y";
        }
        if (pwrd.length() >= 8) {
            if (isAlphaNumeric(pwrd) == true) {
                chk = "Y";
            }else{
                chk = "N";
            }
        }else{
            chk = "N";
        }
            if (chk.equals("N")) {
                onSetFocus("itp1");
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                              "Not a valid password",
                                                              "The passowrd must contains a combination of numeric and alphanumeric characters and should be atleast 8 characters in length"));
            }
       
    }


    public boolean isAlphaNumeric(String s) {
        String pattern = "^(?=.*[0-9])[A-Za-z0-9]+$";
        String alphaNum = "[a-zA-Z0-9]+";
        String compWord= "[a-zA-Z0-9]*";
        System.err.println("<----Check special character ---->"+s.matches(compWord));
        if ((s.matches(pattern) && s.matches(alphaNum)) || (s.matches(compWord) == false)) {
            return true;
        }
        return false;
    }

    public static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
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

    // **************************** Phone number validation ********************************************

    public void emiratesIDValidator(FacesContext facesContext,
                                    UIComponent uIComponent, Object object) {
        try {
            String chk = "N";
            ADFUtils adfutils = new ADFUtils();
            ViewObject emiratesView =
                adfutils.getApplicationModuleForDataControl("PPAppServicesDataControl").findViewObject("EmiratesListView1");
            //BigDecimal eidbig = new BigDecimal(object.toString());
            emiratesView.setNamedWhereClauseParam("eid", object.toString());
            emiratesView.executeQuery();
            if (emiratesView.getEstimatedRowCount() != 0)
                chk = "Y";
            if (chk.equals("N")) {
                onSetFocus("ite1");
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                              "Not a valid emirates ID",
                                                              "Emirates ID is not valid"));
            }
        } catch (Exception e) {
            //            JboException ex = new JboException("Emirates ID is not valid");
            //            BindingContext bctx = BindingContext.getCurrent();
            //            ((DCBindingContainer)bctx.getCurrentBindingsEntry()).reportException(ex);
            onSetFocus("ite1");
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                          "Not a valid emirates ID",
                                                          "Emirates ID is not valid"));
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

    public void setChgPwrdBind(RichInputText chgPwrdBind) {
        this.chgPwrdBind = chgPwrdBind;
    }

    public RichInputText getChgPwrdBind() {
        return chgPwrdBind;
    }

    public void lbanValidator(FacesContext facesContext,
                              UIComponent uIComponent, Object object) {
        String lban = object.toString();        
        if (lban.length() > 34){
            onSetFocus("lbanNo");
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                          "IBAN not valid",
                                                          "Enter valid IBAN number with 34 character max"));
        }
    }
}
