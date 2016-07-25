import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import java.util.Properties;

import javax.mail.Message;

import javax.el.ELContext;
import javax.el.ExpressionFactory;

import javax.el.ValueExpression;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.mail.BodyPart;
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

import oracle.adf.model.BindingContext;

import oracle.binding.BindingContainer;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.uicli.binding.JUCtrlListBinding;

import org.apache.myfaces.trinidad.model.UploadedFile;

import view.com.pp.newsletter.InputStreamMimeBodyPart;

public class newsSubAdminBean {
    private List l = new ArrayList();
    private String _host;
    private String _user;
    private String _pwrd;
    private String _senduser;
    private String _port;
    private String _subj;
    private String _txt;
    private List<UploadedFile> uploadFile;

    public newsSubAdminBean() {
    }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public String send_action() {
        String sa = "N";
//        try {
            List<String> emailList = new ArrayList<String>();
            //        List emailList;
            JUCtrlListBinding listBindings =
                (JUCtrlListBinding)getBindings().get("CategoriesView1");
            Object str[] = listBindings.getSelectedValues();
            for (int i = 0; i < str.length; i++) {
                l.add(str[i]);
                ViewObject emailView =
                    this.getApplicationModuleForDataControl("newsLetterAMDataControl").findViewObject("newsSubCateg1");
                emailView.setNamedWhereClauseParam("p_categories", str[i]);
                emailView.executeQuery();
                for (int emailCount = 0;
                     emailCount < emailView.getEstimatedRowCount();
                     emailCount++) {
                    Row emailRow = emailView.getRowAtRangeIndex(emailCount);
                    if (emailRow != null) {
                        String email =
                            (String)emailRow.getAttribute("Email");
                        emailList.add(email);
                    }
                }
            }
            emailList =
                    new ArrayList<String>(new LinkedHashSet<String>(emailList));
            for (int sendemailCount = 0; sendemailCount < emailList.size();
                 sendemailCount++) {
                String mailid = emailList.get(sendemailCount);
//                if (uploadFile != null) {
//                    if (uploadFile.size() != 0 && uploadFile != null) {
//                        for (int attachCount = 0;
//                             attachCount < uploadFile.size(); attachCount++) {
//                            InputStream attach;
//
//                            //                            attach =
//                            //                                    uploadFile.get(attachCount);
//
//                            String fileName =
//                                uploadFile.get(attachCount).getName();
//                            this.sendEmail(mailid, _subj, _txt, attach,
//                                           fileName);
//                            FacesMessage Message =
//                                new FacesMessage("Mail has been sent successfully");
//                            Message.setSeverity(FacesMessage.SEVERITY_INFO);
//                            FacesContext fc =
//                                FacesContext.getCurrentInstance();
//                            fc.addMessage(null, Message);
//                        }
//                    }
//                } else {
//                    this.sendEmail(mailid, _subj, _txt, null, null);
//                    FacesMessage Message =
//                        new FacesMessage("Mail has been sent successfully");
//                    Message.setSeverity(FacesMessage.SEVERITY_INFO);
//                    FacesContext fc = FacesContext.getCurrentInstance();
//                    fc.addMessage(null, Message);
//                }
                System.out.println ("Obtained mail id :: "+mailid);
                this.sendEmail(mailid, _subj, _txt);
                sa = "Y";
            }
//        } catch (IOException e) {
//        }
        return sa;
    }

    public void executeEmailView() {
        ViewObject emailView =
            this.getApplicationModuleForDataControl("newsLetterAMDataControl").findViewObject("EmailConfigView1");
        emailView.setNamedWhereClauseParam("ecid", "PP1");
        emailView.executeQuery();
        Row emailRow = emailView.first();
        this.setHost((String)emailRow.getAttribute("EcHost"));
        this.setUser((String)emailRow.getAttribute("EcUser"));
        this.setPwrd((String)emailRow.getAttribute("EcPwrd"));
        this.setSenduser((String)emailRow.getAttribute("EcSndMail"));
        this.setPort((String)emailRow.getAttribute("EcPort"));
    }

    /**
     * Get application module for an application module data control by name.
     * @param name application module data control name
     * @return ApplicationModule
     */
    public static ApplicationModule getApplicationModuleForDataControl(String name) {
        return (ApplicationModule)resolveExpression("#{data." + name +
                                                    ".dataProvider}");
    }

    /**
     * Get FacesContext.
     * @return FacesContext
     */
    public static FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    /**
     * Method for taking a reference to a JSF binding expression and returning
     * the matching object (or creating it).
     * @param expression EL expression
     * @return Managed object
     */
    public static Object resolveExpression(String expression) {
        FacesContext facesContext = getFacesContext();
        Application app = facesContext.getApplication();
        ExpressionFactory elFactory = app.getExpressionFactory();
        ELContext elContext = facesContext.getELContext();
        ValueExpression valueExp =
            elFactory.createValueExpression(elContext, expression,
                                            Object.class);
        return valueExp.getValue(elContext);
    }

    /**
     * Function to send the email
     */
    public void sendEmail(String emailid, String subj, String txt) {

        executeEmailView();
        String[] toAdressList = null;
        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "false");
        props.put("mail.smtp.host", _host);
        props.put("mail.smtp.user", _user);
        props.put("mail.smtp.password", _pwrd);
        props.put("mail.smtp.port", _port);
        props.put("mail.smtp.auth", "true");

        String toAddresses = emailid;
        if (toAddresses.contains(",")) {
            toAdressList = toAddresses.split(",");
        } else {
            toAdressList = new String[1];
            toAdressList[0] = toAddresses;
        }
        Session session = Session.getDefaultInstance(props, null);
        MimeMessage message = new MimeMessage(session);
        InternetAddress[] toAddress = new InternetAddress[toAdressList.length];
        BodyPart messageBodyPart = new MimeBodyPart();
        try {
            messageBodyPart.setText("This is message body");
        } catch (MessagingException e) {
        }
        try {
            // To get the array of addresses
            for (int i = 0; i < toAdressList.length; i++) {
                toAddress[i] = new InternetAddress(toAdressList[i]);
            }

            for (int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }
            message.setFrom(new InternetAddress(_senduser));
            //                       message.setSubject(subj, "UTF-8");
            //                       message.setText(txt, "UTF-8");
            Multipart multipart = new MimeMultipart();
            if (uploadFile != null) {
                if (uploadFile.size() > 0) {
                    for (int fileCount=0;fileCount<uploadFile.size();fileCount++) {
                        MimeBodyPart attachPart = new MimeBodyPart();
                        try {
                            InputStreamReader reader = new InputStreamReader(uploadFile.get(fileCount).getInputStream());
                            int partition = 1024;
                            int length = 0;
                            int position = 0;
                            char[] buffer = new char[partition];
                            FileWriter fstream = new FileWriter("out.tmp");
                            do{
                                length = reader.read(buffer, position, partition);
                                fstream.write(buffer, position, length);
                            }while(length > 0);
                            File file = new File("out.tmp");
                            attachPart.attachFile(file);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        multipart.addBodyPart(attachPart);
                    }
                }
            }
            message.setSubject(subj);
            message.setContent(txt, "text/html");
            //                    message.setText(txt, "text/html");
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        Transport transport = null;

        try {
            transport = session.getTransport("smtp");
            transport.connect(_host, _user, _pwrd);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void setHost(String _host) {
        this._host = _host;
    }

    public String getHost() {
        return _host;
    }

    public void setUser(String _user) {
        this._user = _user;
    }

    public String getUser() {
        return _user;
    }

    public void setPwrd(String _pwrd) {
        this._pwrd = _pwrd;
    }

    public String getPwrd() {
        return _pwrd;
    }

    public void setSenduser(String _senduser) {
        this._senduser = _senduser;
    }

    public String getSenduser() {
        return _senduser;
    }

    public void setPort(String _port) {
        this._port = _port;
    }

    public String getPort() {
        return _port;
    }

    public void setSubj(String _subj) {
        this._subj = _subj;
    }

    public String getSubj() {
        return _subj;
    }

    public void setTxt(String _txt) {
        this._txt = _txt;
    }

    public String getTxt() {
        return _txt;
    }

    public void setUploadFile(List<UploadedFile> uploadFile) {
        this.uploadFile = uploadFile;
    }

    public List<UploadedFile> getUploadFile() {
        return uploadFile;
    }
}
