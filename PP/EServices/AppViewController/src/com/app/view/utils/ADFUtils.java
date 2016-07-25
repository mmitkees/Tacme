package com.app.view.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import java.util.Map;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;
import javax.el.ValueExpression;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import oracle.adf.controller.ControllerContext;
import oracle.adf.controller.TaskFlowId;
import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.model.binding.DCParameter;
import oracle.adf.share.logging.ADFLogger;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.layout.RichPanelTabbed;
import oracle.adf.view.rich.component.rich.layout.RichShowDetailItem;
import oracle.adf.view.rich.context.AdfFacesContext;

import com.app.view.utils.JSFUtils;

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

import oracle.binding.AttributeBinding;
import oracle.binding.BindingContainer;
import oracle.binding.ControlBinding;
import oracle.binding.OperationBinding;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.uicli.binding.JUCtrlValueBinding;

import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

public class ADFUtils {
    public static final ADFLogger LOGGER =
           ADFLogger.createADFLogger(ADFUtils.class);
    private String _host;
    private String _user;
    private String _pwrd;
    private String _senduser;
    private String _port;
    public ADFUtils(){
        
    }
    
    public void executeEmailView(){
        ViewObject emailView = this.getApplicationModuleForDataControl("PPAppServicesDataControl").findViewObject("EmailConfigView1");
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
           return (ApplicationModule)JSFUtils.resolveExpression("#{data." + name +
                                                                ".dataProvider}");
       }
    public static void setEL(String el, Object val)
    {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ELContext elContext = facesContext.getELContext();
        ExpressionFactory expressionFactory = facesContext.getApplication().getExpressionFactory();
        ValueExpression exp = expressionFactory.createValueExpression(elContext, el, Object.class);

        exp.setValue(elContext, val);
    }
       /**
        * Function to send the email
        */
       public void sendEmail(String emailid,String subj,String txt) {               
//               String to = emailid;                already commented
           /*    String to = "prasadpravya@gmail.com";               
               String from = "asadrina@gmail.com";
               final String username = "asadrina";
               final String password = "Asadrina89";               
               String host = "smtp.gmail.com";
               Properties props = new Properties();
               props.put("mail.smtp.starttls.enable", "true");               
               props.put("mail.smtp.auth", "false");               
               props.put("mail.smtp.host", host);
               props.put("mail.smtp.port", "587"); 
               //Modification in code 
//               props.put("mail.smtp.ssl.checkserveridentity", "false"); already commented
//               props.put("mail.smtp.ssl.trust", "*"); already commented
               Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                       protected PasswordAuthentication getPasswordAuthentication() {
                           return new PasswordAuthentication(username, password);
                       }
                   });
               try {                   
                   Message message = new MimeMessage(session);                   
                   message.setFrom(new InternetAddress(from));                   
                   message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));                   
                   message.setSubject(subj);                   
                   message.setText(txt);                   
                   Transport.send(message);
                   FacesMessage Message = new FacesMessage("Mail has been sent.");   
                         Message.setSeverity(FacesMessage.SEVERITY_INFO);   
                         FacesContext fc = FacesContext.getCurrentInstance();   
                         fc.addMessage(null, Message);
               } catch (MessagingException e) {
                   throw new RuntimeException(e);
               }*/
           executeEmailView();
           String[] toAdressList = null;
                   Properties props = System.getProperties();
                   props.put("mail.smtp.starttls.enable", "false");
                   props.put("mail.smtp.host", _host);
                   props.put("mail.smtp.user",_user);
                   props.put("mail.smtp.password",_pwrd);
                   props.put("mail.smtp.port",_port);
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
                       message.setSubject(subj, "UTF-8");
                       message.setText(txt, "UTF-8");
//                    message.setSubject(subj);
//                    message.setContent(txt, "UTF-8");
//                    message.setText(txt, "text/html");
                   } catch (AddressException e) {
                      e.printStackTrace();
                   } catch (MessagingException e) {
                       e.printStackTrace();
                   }
                   Transport transport = null;

                   try {
                       transport = session.getTransport("smtp");
                       transport.connect(_host,
                                         _user,
                                         _pwrd);
                       transport.sendMessage(message, message.getAllRecipients());
                       transport.close();
                   } catch (NoSuchProviderException e) {
                      e.printStackTrace();
                   } catch (MessagingException e) {
                       e.printStackTrace();
                   }
           }


       /**
        * A convenience method for getting the value of a bound attribute in the
        * current page context programatically.
        * @param attributeName of the bound value in the pageDef
        * @return value of the attribute
        */
       public static Object getBoundAttributeValue(String attributeName) {
           return findControlBinding(attributeName).getInputValue();
       }

       /**
        * A convenience method for setting the value of a bound attribute in the
        * context of the current page.
        * @param attributeName of the bound value in the pageDef
        * @param value to set
        */
       public static void setBoundAttributeValue(String attributeName,
                                                 Object value) {
           findControlBinding(attributeName).setInputValue(value);
       }

       /**
        * Returns the evaluated value of a pageDef parameter.
        * @param pageDefName reference to the page definition file of the page with the parameter
        * @param parameterName name of the pagedef parameter
        * @return evaluated value of the parameter as a String
        */
       public static Object getPageDefParameterValue(String pageDefName,
                                                     String parameterName) {
           BindingContainer bindings = findBindingContainer(pageDefName);
           DCParameter param =
               ((DCBindingContainer)bindings).findParameter(parameterName);
           return param.getValue();
       }

       /**
        * Convenience method to find a DCControlBinding as an AttributeBinding
        * to get able to then call getInputValue() or setInputValue() on it.
        * @param bindingContainer binding container
        * @param attributeName name of the attribute binding.
        * @return the control value binding with the name passed in.
        *
        */
       public static AttributeBinding findControlBinding(BindingContainer bindingContainer,
                                                         String attributeName) {
           if (attributeName != null) {
               if (bindingContainer != null) {
                   ControlBinding ctrlBinding =
                       bindingContainer.getControlBinding(attributeName);
                   if (ctrlBinding instanceof AttributeBinding) {
                       return (AttributeBinding)ctrlBinding;
                   }
               }
           }
           return null;
       }

       /**
        * Convenience method to find a DCControlBinding as a JUCtrlValueBinding
        * to get able to then call getInputValue() or setInputValue() on it.
        * @param attributeName name of the attribute binding.
        * @return the control value binding with the name passed in.
        *
        */
       public static AttributeBinding findControlBinding(String attributeName) {
           return findControlBinding(getBindingContainer(), attributeName);
       }

       /**
        * Return the current page's binding container.
        * @return the current page's binding container
        */
       public static BindingContainer getBindingContainer() {
           // return (BindingContainer)JSFUtils.resolveExpression("#{bindings}");
           FacesContext fc = FacesContext.getCurrentInstance();
           BindingContainer bindings =
               (BindingContainer)fc.getApplication().evaluateExpressionGet(fc,
                                                                           "#{bindings}",
                                                                           BindingContainer.class);
           return bindings;
       }

       /**
        * Return the Binding Container as a DCBindingContainer.
        * @return current binding container as a DCBindingContainer
        */
       public static DCBindingContainer getDCBindingContainer() {
           return (DCBindingContainer)getBindingContainer();
       }

       /**
        * Get List of ADF Faces SelectItem for an iterator binding.
        *
        * Uses the value of the 'valueAttrName' attribute as the key for
        * the SelectItem key.
        *
        * @param iteratorName ADF iterator binding name
        * @param valueAttrName name of the value attribute to use
        * @param displayAttrName name of the attribute from iterator rows to display
        * @return ADF Faces SelectItem for an iterator binding
        */
       public static List<SelectItem> selectItemsForIterator(String iteratorName,
                                                             String valueAttrName,
                                                             String displayAttrName) {
           return selectItemsForIterator(findIterator(iteratorName),
                                         valueAttrName, displayAttrName);
       }

       /**
        * Get List of ADF Faces SelectItem for an iterator binding.
        *
        * Uses the value of the 'valueAttrName' attribute as the key for
        * the SelectItem key.
        *
        * @param iteratorName ADF iterator binding name
        * @param valueAttrName name of the value attribute to use
        * @param displayAttrNames array of attribute names from iterator rows to display
        * @return ADF Faces SelectItem for an iterator binding
        */
       public static List<SelectItem> selectItemsForIterator(String iteratorName,
                                                             String valueAttrName,
                                                             String[] displayAttrNames)  {
           return selectItemsForIterator(findIterator(iteratorName),
                                         valueAttrName, displayAttrNames);
       }

       /**
        * Get a List of attributes as a Map (of name, value) for an iterator.
        * @param iter iterator binding
        * @param attrNames array of attribute names for attributes to be retrieved
        * @return List of attribute values
        */
       public static List<Map<String, Object>> attributesListForIterator(DCIteratorBinding iter,
                                                                         String[] attrNames) {
           List<Map<String, Object>> attributeList =
               new ArrayList<Map<String, Object>>();
           for (Row r : iter.getAllRowsInRange()) {
               Map<String, Object> alist = new HashMap<String, Object>();
               for (String aName : attrNames) {
                   alist.put(aName, r.getAttribute(aName));
               }
               attributeList.add(alist);
           }
           return attributeList;
       }

       /**
        * Get a List of attributes as a Map (of name, value) for an iterator.
        * @param iteratorName ADF iterator binding name
        * @param attrNames array of attribute names for attributes to be retrieved
        * @return List of attribute values for an iterator
        */
       public static List<Map<String, Object>> attributeListForIterator(String iteratorName,
                                                                        String[] attrNames) {
           return attributesListForIterator(findIterator(iteratorName),
                                            attrNames);
       }

       /**
        * Get List of ADF Faces SelectItem for an iterator binding with description.
        *
        * Uses the value of the 'valueAttrName' attribute as the key for
        * the SelectItem key.
        *
        * @param iteratorName ADF iterator binding name
        * @param valueAttrName name of the value attribute to use
        * @param displayAttrName name of the attribute from iterator rows to display
        * @param descriptionAttrName name of the attribute to use for description
        * @return ADF Faces SelectItem for an iterator binding with description
        */
       public static List<SelectItem> selectItemsForIterator(String iteratorName,
                                                             String valueAttrName,
                                                             String displayAttrName,
                                                             String descriptionAttrName)  {
           return selectItemsForIterator(findIterator(iteratorName),
                                         valueAttrName, displayAttrName,
                                         descriptionAttrName);
       }

       /**
        * Get List of attribute values for an iterator.
        * @param iteratorName ADF iterator binding name
        * @param valueAttrName value attribute to use
        * @return List of attribute values for an iterator
        */
       public static List attributeListForIterator(String iteratorName,
                                                   String valueAttrName) {
           return attributeListForIterator(findIterator(iteratorName),
                                           valueAttrName);
       }

       /**
        * Get List of Key objects for rows in an iterator.
        * @param iteratorName iterabot binding name
        * @return List of Key objects for rows
        */
       public static List<Key> keyListForIterator(String iteratorName)  {
           return keyListForIterator(findIterator(iteratorName));
       }

       /**
        * Get List of Key objects for rows in an iterator.
        * @param iter iterator binding
        * @return List of Key objects for rows
        */
       public static List<Key> keyListForIterator(DCIteratorBinding iter) {
           List<Key> attributeList = new ArrayList<Key>();
           for (Row r : iter.getAllRowsInRange()) {
               attributeList.add(r.getKey());
           }
           return attributeList;
       }

       /**
        * Get List of Key objects for rows in an iterator using key attribute.
        * @param iteratorName iterator binding name
        * @param keyAttrName name of key attribute to use
        * @return List of Key objects for rows
        */
       public static List<Key> keyAttrListForIterator(String iteratorName,
                                                      String keyAttrName) {
           return keyAttrListForIterator(findIterator(iteratorName), keyAttrName);
       }

       /**
        * Get List of Key objects for rows in an iterator using key attribute.
        *
        * @param iter iterator binding
        * @param keyAttrName name of key attribute to use
        * @return List of Key objects for rows
        */
       public static List<Key> keyAttrListForIterator(DCIteratorBinding iter,
                                                      String keyAttrName) {
           List<Key> attributeList = new ArrayList<Key>();
           for (Row r : iter.getAllRowsInRange()) {
               attributeList.add(new Key(new Object[] { r.getAttribute(keyAttrName) }));
           }
           return attributeList;
       }

       /**
        * Get a List of attribute values for an iterator.
        *
        * @param iter iterator binding
        * @param valueAttrName name of value attribute to use
        * @return List of attribute values
        */
       public static List attributeListForIterator(DCIteratorBinding iter,
                                                   String valueAttrName) {
           List attributeList = new ArrayList();
           for (Row r : iter.getAllRowsInRange()) {
               attributeList.add(r.getAttribute(valueAttrName));
           }
           return attributeList;
       }

       /**
        * Find an iterator binding in the current binding container by name.
        *
        * @param name iterator binding name
        * @return iterator binding
        */
       public static DCIteratorBinding findIterator(String name) {
           DCIteratorBinding iter =
               getDCBindingContainer().findIteratorBinding(name);
           if (iter == null) {
              // throw new IteratorNotFound("Iterator '" + name + "' not found");
           }
           return iter;
       }

       public static DCIteratorBinding findIterator(String bindingContainer,
                                                    String iterator) {
           DCBindingContainer bindings =
               (DCBindingContainer)JSFUtils.resolveExpression("#{" +
                                                              bindingContainer +
                                                              "}");
           if (bindings == null) {
               throw new RuntimeException("Binding container '" +
                                          bindingContainer + "' not found");
           }
           DCIteratorBinding iter = bindings.findIteratorBinding(iterator);
           if (iter == null) {
               throw new RuntimeException("Iterator '" + iterator +
                                          "' not found");
           }
           return iter;
       }

       public static JUCtrlValueBinding findCtrlBinding(String name) {
           JUCtrlValueBinding rowBinding =
               (JUCtrlValueBinding)getDCBindingContainer().findCtrlBinding(name);
           if (rowBinding == null) {
               throw new RuntimeException("CtrlBinding " + name + "' not found");
           }
           return rowBinding;
       }

       /**
        * Find an operation binding in the current binding container by name.
        *
        * @param name operation binding name
        * @return operation binding
        */
       public static OperationBinding findOperation(String name) {
           OperationBinding op =
               getDCBindingContainer().getOperationBinding(name);
           if (op == null) {
               throw new RuntimeException("Operation '" + name + "' not found");
           }
           return op;
       }

       /**
        * Find an operation binding in the current binding container by name.
        *
        * @param bindingContianer binding container name
        * @param opName operation binding name
        * @return operation binding
        */
       public static OperationBinding findOperation(String bindingContianer,
                                                    String opName) {
           DCBindingContainer bindings =
               (DCBindingContainer)JSFUtils.resolveExpression("#{" +
                                                              bindingContianer +
                                                              "}");
           if (bindings == null) {
               throw new RuntimeException("Binding container '" +
                                          bindingContianer + "' not found");
           }
           OperationBinding op = bindings.getOperationBinding(opName);
           if (op == null) {
               throw new RuntimeException("Operation '" + opName + "' not found");
           }
           return op;
       }

       /**
        * Get List of ADF Faces SelectItem for an iterator binding with description.
        *
        * Uses the value of the 'valueAttrName' attribute as the key for
        * the SelectItem key.
        *
        * @param iter ADF iterator binding
        * @param valueAttrName name of value attribute to use for key
        * @param displayAttrName name of the attribute from iterator rows to display
        * @param descriptionAttrName name of the attribute for description
        * @return ADF Faces SelectItem for an iterator binding with description
        */
       public static List<SelectItem> selectItemsForIterator(DCIteratorBinding iter,
                                                             String valueAttrName,
                                                             String displayAttrName,
                                                             String descriptionAttrName) {
           List<SelectItem> selectItems = new ArrayList<SelectItem>();
           for (Row r : iter.getAllRowsInRange()) {
               selectItems.add(new SelectItem(r.getAttribute(valueAttrName),
                                              (String)r.getAttribute(displayAttrName),
                                              (String)r.getAttribute(descriptionAttrName)));
           }
           return selectItems;
       }

       /**
        * Get List of ADF Faces SelectItem for an iterator binding.
        *
        * Uses the value of the 'valueAttrName' attribute as the key for
        * the SelectItem key.
        *
        * @param iter ADF iterator binding
        * @param valueAttrName name of value attribute to use for key
        * @param displayAttrName name of the attribute from iterator rows to display
        * @return ADF Faces SelectItem for an iterator binding
        */
       public static List<SelectItem> selectItemsForIterator(DCIteratorBinding iter,
                                                             String valueAttrName,
                                                             String displayAttrName) {
           List<SelectItem> selectItems = new ArrayList<SelectItem>();
           for (Row r : iter.getAllRowsInRange()) {
               selectItems.add(new SelectItem(r.getAttribute(valueAttrName),
                                              (String)r.getAttribute(displayAttrName)));
           }
           return selectItems;
       }

       /**
        * Get List of ADF Faces SelectItem for an iterator binding.
        *
        * Uses the value of the 'valueAttrName' attribute as the key for
        * the SelectItem key.
        *
        * @param iter ADF iterator binding
        * @param valueAttrName name of value attribute to use for key
        * @param displayAttrNames array of attribute names from iterator rows to display
        * @return ADF Faces SelectItem for an iterator binding
        */
       public static List<SelectItem> selectItemsForIterator(DCIteratorBinding iter,
                                                             String valueAttrName,
                                                             String[] displayAttrNames) {
           List<SelectItem> selectItems = new ArrayList<SelectItem>();
           for (Row r : iter.getAllRowsInRange()) {
               StringBuilder buf = new StringBuilder();
               for (int idx = 0; idx < displayAttrNames.length; idx++) {
                   buf.append((String)r.getAttribute(displayAttrNames[idx]));
                   if (idx < (displayAttrNames.length - 1)) {
                       buf.append("-");
                   }
               }
               selectItems.add(new SelectItem(r.getAttribute(valueAttrName),
                                              buf.toString()));
           }
           return selectItems;
       }

       /**
        * Get List of ADF Faces SelectItem for an iterator binding.
        *
        * Uses the rowKey of each row as the SelectItem key.
        *
        * @param iteratorName ADF iterator binding name
        * @param displayAttrName name of the attribute from iterator rows to display
        * @return ADF Faces SelectItem for an iterator binding
        */
       public static List<SelectItem> selectItemsByKeyForIterator(String iteratorName,
                                                                  String displayAttrName)  {
           return selectItemsByKeyForIterator(findIterator(iteratorName),
                                              displayAttrName);
       }

       /**
        * Get List of ADF Faces SelectItem for an iterator binding with discription.
        *
        * Uses the rowKey of each row as the SelectItem key.
        *
        * @param iteratorName ADF iterator binding name
        * @param displayAttrName name of the attribute from iterator rows to display
        * @param descriptionAttrName name of the attribute for description
        * @return ADF Faces SelectItem for an iterator binding with discription
        */
       public static List<SelectItem> selectItemsByKeyForIterator(String iteratorName,
                                                                  String displayAttrName,
                                                                  String descriptionAttrName)  {
           return selectItemsByKeyForIterator(findIterator(iteratorName),
                                              displayAttrName,
                                              descriptionAttrName);
       }

       /**
        * Get List of ADF Faces SelectItem for an iterator binding with discription.
        *
        * Uses the rowKey of each row as the SelectItem key.
        *
        * @param iter ADF iterator binding
        * @param displayAttrName name of the attribute from iterator rows to display
        * @param descriptionAttrName name of the attribute for description
        * @return ADF Faces SelectItem for an iterator binding with discription
        */
       public static List<SelectItem> selectItemsByKeyForIterator(DCIteratorBinding iter,
                                                                  String displayAttrName,
                                                                  String descriptionAttrName) {
           List<SelectItem> selectItems = new ArrayList<SelectItem>();
           for (Row r : iter.getAllRowsInRange()) {
               selectItems.add(new SelectItem(r.getKey(),
                                              (String)r.getAttribute(displayAttrName),
                                              (String)r.getAttribute(descriptionAttrName)));
           }
           return selectItems;
       }

       /**
        * Get List of ADF Faces SelectItem for an iterator binding.
        *
        * Uses the rowKey of each row as the SelectItem key.
        *
        * @param iter ADF iterator binding
        * @param displayAttrName name of the attribute from iterator rows to display
        * @return List of ADF Faces SelectItem for an iterator binding
        */
       public static List<SelectItem> selectItemsByKeyForIterator(DCIteratorBinding iter,
                                                                  String displayAttrName) {
           List<SelectItem> selectItems = new ArrayList<SelectItem>();
           for (Row r : iter.getAllRowsInRange()) {
               selectItems.add(new SelectItem(r.getKey(),
                                              (String)r.getAttribute(displayAttrName)));
           }
           return selectItems;
       }

       /**
        * Find the BindingContainer for a page definition by name.
        *
        * Typically used to refer eagerly to page definition parameters. It is
        * not best practice to reference or set bindings in binding containers
        * that are not the one for the current page.
        *
        * @param pageDefName name of the page defintion XML file to use
        * @return BindingContainer ref for the named definition
        */
       private static BindingContainer findBindingContainer(String pageDefName) {
           BindingContext bctx = getDCBindingContainer().getBindingContext();
           BindingContainer foundContainer =
               bctx.findBindingContainer(pageDefName);
           return foundContainer;
       }

       public static void printOperationBindingExceptions(List opList) {
           if (opList != null && !opList.isEmpty()) {
               for (Object error : opList) {
                   LOGGER.severe(error.toString());
               }
           }
       }

       /**
        * Get the page flow scope
        * @return
        */
       public static Map getPageFlowScope() {
           return AdfFacesContext.getCurrentInstance().getPageFlowScope();
       }

       /**
        * Open a new browser tab/window starting a new bounded task flow.
        *
        * @param taskFlowId - id of bounded task flow to show in new window
        * @param taskFlowParams - params for the task flow (if any)
        * @param windowName - name of browser tab/window (window.name)
        * @param openInWindow - true will open a browser window (if settings of the browser
        *     allow this), false will open a new browser tab.
        */
       public static void launchTaskFlowInNewWindow(TaskFlowId taskFlowId,
                                                    Map taskFlowParams,
                                                    String windowName,
                                                    boolean openInWindow) {
           launchTaskFlowInNewWindow(taskFlowId, taskFlowParams, windowName,
                                     openInWindow, 1000, 750);

       }


       /**
        * Open a new browser tab/window starting a new bounded task flow.
        *
        * @param taskFlowId - id of bounded task flow to show in new window
        * @param taskFlowParams - params for the task flow (if any)
        * @param windowName - name of browser tab/window (window.name)
        * @param openInWindow - true will open a browser window (if settings of the browser
        *     allow this), false will open a new browser tab.
        * @param width
        * @param height
        */

       public static void launchTaskFlowInNewWindow(TaskFlowId taskFlowId,
                                                    Map taskFlowParams,
                                                    String windowName,
                                                    boolean openInWindow,
                                                    int width, int height) {

           String url =
               ControllerContext.getInstance().getTaskFlowURL(false, taskFlowId,
                                                              taskFlowParams);

           if (url == null) {
               throw new Error("Unable to launch window for task flow id " +
                               taskFlowId);
           }

           FacesContext context = FacesContext.getCurrentInstance();
           ExtendedRenderKitService extendedRenderKitService =
               Service.getService(context.getRenderKit(),
                                  ExtendedRenderKitService.class);

           // Build javascript to open a new browser tab/window
           StringBuilder script = new StringBuilder();

           // Unable to get a named firefox tab to gain focus.  To workaround
           // issue we close the tab first, then open it.
           if (!openInWindow && windowName != null) {

               script.append("var hWinx = window.open(\"");
               script.append("about:blank"); // the URL
               script.append("\",\"");
               script.append(windowName);
               script.append("\"");
               script.append(");");
               script.append("\n");
               script.append("hWinx.close();\n");
           }

           // Set a variable with the window properties
           script.append("var winProps = \"status=yes,toolbar=no,copyhistory=no,width=" +
                         width + ",height=" + height + "\";");
           // If we aren't going to open in a new window, then clear the window properties
           if (!openInWindow) {
               script.append("winProps = '';");
           }
           // Set isOpenerValid to true if window.opener (a parent window) is defined and open
           script.append("var isOpenerValid = (typeof(window.opener) != 'undefined' && window.opener != undefined && !window.opener.closed);");
           // Set useProps to true if openInWindow is true or isOpenerValid is true
           script.append("var useProps = (" + openInWindow +
                         " || isOpenerValid);");
           // Set win to the current window, unless we need to use the parent, then set to window.opener (the parent window)
           script.append("var win = window; if (typeof(isChildWindow) != 'undefined' && isChildWindow != undefined && isChildWindow == true && isOpenerValid) {win = window.opener;}");
           // Set hWin to the window returned by calling open on win
           script.append("var hWin = win.open(\"");
           script.append(url); // the URL
           script.append("\",\"");
           script.append(windowName);
           script.append("\"");
           script.append(", winProps");
           script.append(");");
           // Set focus to the window opened.
           script.append("hWin.focus();");

           extendedRenderKitService.addScript(context, script.toString());
       }

       public static void executeClientSideScript(String script) {
           FacesContext context = FacesContext.getCurrentInstance();
           ExtendedRenderKitService extendedRenderKitService =
               Service.getService(context.getRenderKit(),
                                  ExtendedRenderKitService.class);

           extendedRenderKitService.addScript(context, script);
       }


       /**
        * Get the id of the RichShowDetailItem which is currently disclosed within the
        * RichPanelTabbed or null if no children disclosed.
        *
        * @param panelTabbed
        * @return
        */
       public static String getDisclosedDetailItemId(RichPanelTabbed panelTabbed) {
           RichShowDetailItem item = getDisclosedDetailItem(panelTabbed);
           if (item != null) {
               return item.getId();
           }
           return null;
       }

       /**
        * Get the RichShowDetailItem which is currently disclosed within the
        * RichPanelTabbed or null if no children disclosed.
        *
        * @param panelTabbed
        * @return
        */
       public static RichShowDetailItem getDisclosedDetailItem(RichPanelTabbed panelTabbed) {
           if (panelTabbed != null) {
               Iterator iter = panelTabbed.getChildren().iterator();
               // Loop through all the child components
               while (iter.hasNext()) {
                   UIComponent component = (UIComponent)iter.next();
                   // Make sure we only check components that are detailItems
                   if (component instanceof RichShowDetailItem) {
                       RichShowDetailItem detailItem =
                           (RichShowDetailItem)component;
                       if (detailItem.isDisclosed()) {
                           return detailItem;
                       }
                   }
               }
           }
           return null;
       }

       /**
        * Helper method to check if a UI component value
        * is null or empty.
        * @param component UIComponent
        * @return true / false
        */
       public static boolean isEmpty(UIComponent component) {
           boolean isEmpty = false;
           if (component == null) {
               isEmpty = true;
           } else {
               // for a text field, check the value as a String
               if (component instanceof RichInputText) {
                   RichInputText textField = (RichInputText)component;
                   if (textField.getValue() == null ||
                       ((String)textField.getValue()).length() <= 0) {
                       isEmpty = true;
                   }
               }

           }
           return isEmpty;
       }

       /**
        * Get the list containging the selected rows for the given table <br/>
        * Make sure the ADF table definition does not have the selection listener
        * and the make current set.
        * @param table
        * @return
        */
       public static List<Row> getSelectedRows(RichTable table) {
           List<Row> rows = new ArrayList<Row>();

           // get the selected row keys (iterator)
           Iterator keyIter = table.getSelectedRowKeys().iterator();
           // remember selected row keys
           Object oldKey = table.getRowKey();
           // loop for each selection
           while (keyIter.hasNext()) {
               
           }
           // restore originally selected rows
           table.setRowKey(oldKey);
           return rows;
       }

       public static void printRow(Row row) {
           System.out.println("\nSTART " + row.getKey() +
                              " *********************");
           for (int i = 0; i < row.getAttributeCount(); i++) {
               System.out.println("row[" + row.getAttributeNames()[i] + "]:[" +
                                  row.getAttribute(i) + "]");

           }
           System.out.println("END   " + row.getKey() +
                              "*********************\n");
       }


       /**
        * Get a List of attributes as a Map (of name, value) for an iterator.
        * @param iter iterator binding
        * @param keyAttrName attribut name for the key of the map
        * @param valueAttrName attribut name for the value
        * @return Map of attribute values
        */
       public static Map<Object, Object> attributesMapForIterator(DCIteratorBinding iter,
                                                                  String keyAttrName,
                                                                  String valueAttrName) {
           Map<Object, Object> amap = new HashMap<Object, Object>();
           for (Row r : iter.getAllRowsInRange()) {
               amap.put(r.getAttribute(keyAttrName),
                        r.getAttribute(valueAttrName));
           }
           return amap;
       }

       /**
        * Get a List of attributes as a Map (of name, value) for an iterator.
        * @param iteratorName ADF iterator binding name
        * @param keyAttrName attribut name for the key of the map
        * @param valueAttrName attribut name for the value
        * @return Map of attribute values
        */
       public static Map<Object, Object> attributeMapForIterator(String iteratorName,
                                                                 String keyAttrName,
                                                                 String valueAttrName) {
           return attributesMapForIterator(findIterator(iteratorName),
                                           keyAttrName, valueAttrName);
       }

       public static Object invokeMethodExpression(String expr, Class returnType,
                                                   Class[] argTypes,
                                                   Object[] args) {
           FacesContext fc = FacesContext.getCurrentInstance();
           ELContext elctx = fc.getELContext();
           ExpressionFactory elFactory =
               fc.getApplication().getExpressionFactory();
           MethodExpression methodExpr =
               elFactory.createMethodExpression(elctx, expr, returnType,
                                                argTypes);
           return methodExpr.invoke(elctx, args);
       }

       public static Object invokeMethodExpression(String expr, Class returnType,
                                                   Class argType,
                                                   Object argument) {
           return invokeMethodExpression(expr, returnType,
                                         new Class[] { argType },
                                         new Object[] { argument });
       }
       /**
       * Programmatic evaluation of EL.
       *
       * @param el EL to evaluate
       * @return Result of the evaluation
       */
       public static Object evaluateEL(String el) {
       FacesContext facesContext = FacesContext.getCurrentInstance();
       ELContext elContext = facesContext.getELContext();
       ExpressionFactory expressionFactory =
       facesContext.getApplication().getExpressionFactory();
       ValueExpression exp =
       expressionFactory.createValueExpression(elContext, el,
       Object.class);

       return exp.getValue(elContext);
       }

       /**
       * Programmatic invocation of a method that an EL evaluates to.
       * The method must not take any parameters.
       *
       * @param el EL of the method to invoke
       * @return Object that the method returns
       */
       public static Object invokeEL(String el) {
       return invokeEL(el, new Class[0], new Object[0]);
       }

       /**
       * Programmatic invocation of a method that an EL evaluates to.
       *
       * @param el EL of the method to invoke
       * @param paramTypes Array of Class defining the types of the parameters
       * @param params Array of Object defining the values of the parametrs
       * @return Object that the method returns
       */
       public static Object invokeEL(String el, Class[] paramTypes,
       Object[] params) {
       FacesContext facesContext = FacesContext.getCurrentInstance();
       ELContext elContext = facesContext.getELContext();
       ExpressionFactory expressionFactory =
       facesContext.getApplication().getExpressionFactory();
       MethodExpression exp =
       expressionFactory.createMethodExpression(elContext, el,
       Object.class, paramTypes);

       return exp.invoke(elContext, params);
       }
    public static FacesContext getFacesContext()
    {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        return facesContext;
    }
    public static void showInfoMessage(String messageToShow)
    {
        FacesMessage message = new FacesMessage(messageToShow);
        message.setSeverity(FacesMessage.SEVERITY_INFO);
        getFacesContext().addMessage(null, message);
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
}
