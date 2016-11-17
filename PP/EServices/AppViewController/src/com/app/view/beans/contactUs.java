package com.app.view.beans;

import com.tacme.pp.common.utils.ADFUtils;

import com.tacme.pp.common.utils.EmailUtils;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.context.AdfFacesContext;

import java.io.File;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;

import java.net.URL;
import java.net.URLDecoder;

import java.util.Locale;
import java.util.Properties;

import java.util.Random;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import javax.servlet.http.HttpServletRequest;

import nl.captcha.Captcha;

import oracle.adf.model.BindingContext;

import oracle.adf.model.binding.DCBindingContainer;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.JboException;

import org.apache.commons.io.FileUtils;

public class contactUs implements Serializable{
    @SuppressWarnings("compatibility:1543109987320081438")
    private static final long serialVersionUID = 1L;
    private RichInputText it1;
    private RichInputText it2;
    private RichInputText it3;
    private RichInputText it4;
    private RichInputText it5;
    private RichInputText it6;
    private Object name;
    private Object email;
    private Object address;
    private Object phoneNo;
    private Object subject;
    private Object decription;
    private String _cen = "Y";
    private String _cee = "Y";
    private String _cadr = "Y";
    private String _cpn = "Y";
    private String _cs = "Y";
    private String _cdesc = "Y";
    private String capche;
    private RichInputText bind_bguess;

    public contactUs() {
    }

    public void setIt1(RichInputText it1) {
        this.it1 = it1;
    }

    public RichInputText getIt1() {
        return it1;
    }

    public void setIt2(RichInputText it2) {
        this.it2 = it2;
    }

    public RichInputText getIt2() {
        return it2;
    }

    public void setIt3(RichInputText it3) {
        this.it3 = it3;
    }

    public RichInputText getIt3() {
        return it3;
    }

    public void setIt4(RichInputText it4) {
        this.it4 = it4;
    }

    public RichInputText getIt4() {
        return it4;
    }

    public void setIt5(RichInputText it5) {
        this.it5 = it5;
    }

    public RichInputText getIt5() {
        return it5;
    }

    public void setIt6(RichInputText it6) {
        this.it6 = it6;
    }

    public RichInputText getIt6() {
        return it6;
    }

    public static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }

    public String sendMail() throws MessagingException {
        if ((name != null) && (email != null) && (address != null) &&
            (phoneNo != null) && (subject != null) && (decription != null)) {
            String[] toAdressList = null;
            // getting system properties and putting smtp details....
            Properties props = System.getProperties();
            props.put("mail.smtp.starttls.enable", "false");
            props.put("mail.smtp.host", "exmail.eim.ae");
            props.put("mail.smtp.user", "sendemail@tacme.ae");
            props.put("mail.smtp.password", "send123");
            props.put("mail.smtp.port", "25");
            props.put("mail.smtp.auth", "true");

            String toAddresses = getEmail().toString();
            //        String toAddresses = "gdataprasad@gmail.com";
            if (toAddresses.contains(",")) {
                toAdressList = toAddresses.split(",");
            } else {
                toAdressList = new String[1];
                toAdressList[0] = toAddresses;
            }

            Session session = Session.getDefaultInstance(props, null);
            MimeMessage message = new MimeMessage(session);
            InternetAddress[] toAddress =
                new InternetAddress[toAdressList.length];
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(getDecription().toString());

            try {
                // To get the array of addresses
                for (int i = 0; i < toAdressList.length; i++) {
                    toAddress[i] = new InternetAddress(toAdressList[i]);
                }

                for (int i = 0; i < toAddress.length; i++) {
                    message.addRecipient(Message.RecipientType.TO,
                                         toAddress[i]);
                }
                message.setFrom(new InternetAddress("sendemail@tacme.ae"));
                message.setSubject(getSubject().toString(), "UTF-8");
                message.setText(getDecription().toString(), "UTF-8");
            } catch (AddressException e) {
                e.printStackTrace();
            } catch (MessagingException e) {
                e.printStackTrace();
            }

            Transport transport = null;

            try {
                transport = session.getTransport("smtp");
                transport.connect("exmail.eim.ae", "sendemail@tacme.ae",
                                  "send123");
                transport.sendMessage(message, message.getAllRecipients());
                transport.close();
                ADFUtils.showInfoMessage("Mail been sent successfully........");
            } catch (NoSuchProviderException e) {
                e.printStackTrace();
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            //               ADFUtils.showInfoMessage("Mail been sent successfully........");
        }
        if (name == null) {
            _cen = "N";
        }
        if (email == null) {
            _cee = "N";
        }
        if (address == null) {
            _cadr = "N";
        }
        if (phoneNo == null) {
            _cpn = "N";
        }
        if (subject == null) {
            _cs = "N";
        }
        if (decription == null) {
            _cdesc = "N";
        }
        return null;
    }

    public String onReset() {
        // Add event code here...
        ADFUtils adfutils = new ADFUtils();
        setName(null);
        setEmail(null);
        setAddress(null);
        setDecription(null);
        setPhoneNo(null);
        setSubject(null);
        adfutils.setEL("#{requestScope.bestGuess}", "");
        FacesContext fctx = FacesContext.getCurrentInstance();
        ExternalContext ectx = fctx.getExternalContext();
        ectx.getRequestMap().put("bestGuess", null);
        AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
        adfFacesContext.getCurrentInstance().addPartialTarget(it1);
        adfFacesContext.getCurrentInstance().addPartialTarget(it2);
        adfFacesContext.getCurrentInstance().addPartialTarget(it3);
        adfFacesContext.getCurrentInstance().addPartialTarget(it4);
        adfFacesContext.getCurrentInstance().addPartialTarget(it5);
        adfFacesContext.getCurrentInstance().addPartialTarget(it6);
        return null;
    }

    /**
     *  Generate a CAPTCHA String consisting of random lowercase & uppercase letters, and numbers.
     */
    public String generateCaptchaString() {
        Random random = new Random();
        int length = 4 + (Math.abs(random.nextInt()) % 3);
        StringBuffer captchaStringBuffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int baseCharNumber = Math.abs(random.nextInt()) % 62;
            int charNumber = 0;
            if (baseCharNumber < 26) {
                charNumber = 65 + baseCharNumber;
            } else if (baseCharNumber < 52) {
                charNumber = 97 + (baseCharNumber - 26);
            } else {
                charNumber = 48 + (baseCharNumber - 52);
            }
            captchaStringBuffer.append((char)charNumber);
        }
        capche = captchaStringBuffer.toString();
        return "tosuccess";
    }

    public void verifyAnswer(ActionEvent actionEvent) {        
        ADFUtils adfutils = new ADFUtils();
        Locale loacle1 = (Locale)adfutils.evaluateEL("#{pageFlowScope.locale}");
        String locale = loacle1.toString();
//        String locale = "ar";
        try {
            if ((name != null) && (email != null)  && (subject != null) &&
                (decription != null)) {
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
                    BindingContainer bindings = getBindings();
                    OperationBinding operationBinding =
                        bindings.getOperationBinding("addContact");
                    String res = (String)operationBinding.execute();
                    if (res.equals("Y")) {
                        OperationBinding commitBinding =
                            bindings.getOperationBinding("Commit");
                        commitBinding.execute();
                      String msg="";
                       
                        if (locale.equals("en")){
                            msg="Your message has been successfully sent >>>>> "+  getDecription() ;
                        getMessage("Your message has been successfully sent");
                        }
                        if (locale.equals("ar")){
                            msg=" تم ارسال رسالتك بنجاح   >>>>"+ getDecription();
                            getMessage("تم ارسال رسالتك بنجاح");
                        }
                        
                        EmailUtils.sendEmail((String)email, (String)subject,
                                      (String)msg);
                        //                        sendMail();
                        this.setName("");
                        this.setEmail("");
                        this.setAddress("");
                        this.setPhoneNo("");
                        this.setSubject("");
                        this.setDecription("");
                        adfutils.setEL("#{requestScope.bestGuess}", "");
                    }

                } else {
                    if(locale.equals("en")){
                    getMessage("Please enter the correct data in the image");
                    }
                    if(locale.equals("ar")){
                        getMessage("ادخل البيانات كما هو في الصورة");
                    }
                    UIComponent panelLabelAndMessage =
                        ((UIComponent)actionEvent.getSource()).getParent().getParent();
                    UIComponent panelFormlayout =
                        panelLabelAndMessage.getParent();
                    AdfFacesContext.getCurrentInstance().addPartialTarget(panelFormlayout);
                    bind_bguess.setValue("");
                }
            }
            if (name == null) {
                _cen = "N";
            }
            if (email == null) {
                _cee = "N";
            }            
            if (subject == null) {
                _cs = "N";
            }
            if (decription == null) {
                _cdesc = "N";
            }
        } catch (UnsupportedEncodingException e) {
            System.out.println("UTF not supported!");
        }
        catch (Exception e) {
            JboException ex =
                new JboException("Please contact the administrator");
            BindingContext bctx = BindingContext.getCurrent();
            ((DCBindingContainer)bctx.getCurrentBindingsEntry()).reportException(ex);
        } finally {            
            
        }
    }

    private void getMessage(String myMessage) {
        FacesContext fctx = FacesContext.getCurrentInstance();
        fctx.addMessage("it1",
                        new FacesMessage(FacesMessage.SEVERITY_INFO, null,
                                         myMessage));
    }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public void setName(Object name) {
        this.name = name;
    }

    public Object getName() {
        return name;
    }

    public void setEmail(Object email) {
        this.email = email;
    }

    public Object getEmail() {
        return email;
    }

    public void setAddress(Object address) {
        this.address = address;
    }

    public Object getAddress() {
        return address;
    }

    public void setPhoneNo(Object phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Object getPhoneNo() {
        return phoneNo;
    }

    public void setSubject(Object subject) {
        this.subject = subject;
    }

    public Object getSubject() {
        return subject;
    }

    public void setDecription(Object decription) {
        this.decription = decription;
    }

    public Object getDecription() {
        return decription;
    }

    public void setCen(String _cen) {
        this._cen = _cen;
    }

    public String getCen() {
        return _cen;
    }

    public void setCee(String _cee) {
        this._cee = _cee;
    }

    public String getCee() {
        return _cee;
    }

    public void setCadr(String _cadr) {
        this._cadr = _cadr;
    }

    public String getCadr() {
        return _cadr;
    }

    public void setCpn(String _cpn) {
        this._cpn = _cpn;
    }

    public String getCpn() {
        return _cpn;
    }

    public void setCs(String _cs) {
        this._cs = _cs;
    }

    public String getCs() {
        return _cs;
    }

    public void setCdesc(String _cdesc) {
        this._cdesc = _cdesc;
    }

    public String getCdesc() {
        return _cdesc;
    }

    public void namevalidVCL(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (_cen == "Y") {
                _cen = "Y";
            }
        }
    }

    public void emailvalidVCL(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (isValidEmailAddress((String)vce.getNewValue()) == true) {
                if (_cee == "Y") {
                    _cee = "Y";
                }
            } else {
                _cee = "N";
            }
        }
    }

    public void addressvalidVCL(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (_cadr == "Y") {
                _cadr = "Y";
            }
        }
    }

    public void phoneNovalidVCL(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (_cpn == "Y") {
                _cpn = "Y";
            }
        }
    }

    public void subjvalidVCL(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (_cs == "Y") {
                _cs = "Y";
            }
        }
    }

    public void descvalidVCL(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (_cdesc == "Y") {
                _cdesc = "Y";
            }
        }
    }

    public void setCapche(String capche) {
        this.capche = capche;
    }

    public String getCapche() {
        return capche;
    }

    public void setBind_bguess(RichInputText bind_bguess) {
        this.bind_bguess = bind_bguess;
    }

    public RichInputText getBind_bguess() {
        return bind_bguess;
    }
}

