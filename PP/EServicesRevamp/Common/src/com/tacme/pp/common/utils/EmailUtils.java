package com.tacme.pp.common.utils;

import javax.swing.JPanel;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;

import java.util.Properties;

import javax.faces.application.FacesMessage;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;

import oracle.adf.share.logging.ADFLogger;

public class EmailUtils {
    public EmailUtils() {
    }
    private static ADFLogger _logger =
        ADFLogger.createADFLogger(EmailUtils.class);

    static private String _host;
    static private String _user;
    static private String _pwrd;
    static private String _senduser;
    static private String _port;

    public static void intiateConnection() {
        _logger.entering(EmailUtils.class.toString(), "intiateConnection");
        _logger.info("Creating a EmailUtilities instance");
        try{
        _logger.info("getting viewobject with database configuration fro email");
        ViewObject emailView =
            ADFUtils.getApplicationModuleForDataControl("PPAppServicesDataControl").findViewObject("EmailConfigView1");
        emailView.setNamedWhereClauseParam("ecid", "PP1");
        emailView.executeQuery();
        Row emailRow = emailView.first();
        _host = ((String)emailRow.getAttribute("EcHost"));
        _pwrd = ((String)emailRow.getAttribute("EcUser"));
        _user = ((String)emailRow.getAttribute("EcPwrd"));
        _senduser = ((String)emailRow.getAttribute("EcSndMail"));
        _port = ((String)emailRow.getAttribute("EcPort"));
        _logger.info("finished getting email configuration from database with >>  " +
                     _host + "," + _user + "," + _pwrd + "," + _senduser +
                     "," + _port);
            } catch (Exception e) {
                // _logger.severe("Error creating Folder: " , e);

                _logger.severe("Exception in intiateConnection ", e);
            } finally {
                _logger.exiting(EmailUtils.class.toString(),
                                "intiateConnection");
            }
    }

    public static void sendEmail(String to, String subj, String txt) {
        _logger.entering(EmailUtils.class.toString(), "sendEmail");
        _logger.info("starting sending email to : "+ to+ "with subject :" +subj + " body :"+ txt);
        intiateConnection();
        String[] toAdressList = null;
        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "false");
        props.put("mail.smtp.host", _host);
        props.put("mail.smtp.user", _user);
        props.put("mail.smtp.password", _pwrd);
        props.put("mail.smtp.port", _port);
        props.put("mail.smtp.auth", "true");
        _logger.info("splitting addresses");
        String toAddresses = to;
        if (toAddresses.contains(",")) {
            toAdressList = toAddresses.split(",");
        } else {
            toAdressList = new String[1];
            toAdressList[0] = toAddresses;
        }
        _logger.info("start sending email");
        Session session = Session.getDefaultInstance(props, null);
        MimeMessage message = new MimeMessage(session);
        InternetAddress[] toAddress = new InternetAddress[toAdressList.length];
        BodyPart messageBodyPart = new MimeBodyPart();
        try {
            messageBodyPart.setText("This is message body");
        } catch (MessagingException e) {
            e.printStackTrace();
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
            message.setSubject(subj, "UTF-8");
            message.setText(txt, "UTF-8");
            //                    message.setSubject(subj);
            //                    message.setContent(txt, "UTF-8");
            //                    message.setText(txt, "text/html");
        } catch (AddressException e) {
            _logger.severe("Exception in sendemail of type AddressException", e);
            e.printStackTrace();
        } catch (MessagingException e) {
            _logger.severe("Exception in sendemail of type MessagingException", e);
            e.printStackTrace();
        }
        Transport transport = null;

        try {
            transport = session.getTransport("smtp");
            transport.connect(_host, _user, _pwrd);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (NoSuchProviderException e) {
            _logger.severe("Exception in sendemail of type NoSuchProviderException", e);
            e.printStackTrace();
        } catch (MessagingException e) {
            _logger.severe("Exception in sendemail of type MessagingException", e);
            e.printStackTrace();
        }         catch (Exception e) {
            _logger.severe("Exception in sendemail of type General", e);
            e.printStackTrace();
        }
        _logger.exiting(EmailUtils.class.toString(),
                        "sendEmail");
    }


}
