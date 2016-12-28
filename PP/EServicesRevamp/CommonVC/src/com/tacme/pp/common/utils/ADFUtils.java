package com.tacme.pp.common.utils;



import java.io.IOException;

import java.sql.SQLIntegrityConstraintViolationException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;

import javax.el.ValueExpression;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import javax.faces.validator.ValidatorException;

import javax.servlet.http.HttpServletRequest;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.model.binding.DCParameter;
import oracle.adf.share.logging.ADFLogger;


import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.QueryEvent;

import oracle.binding.AttributeBinding;
import oracle.binding.BindingContainer;
import oracle.binding.ControlBinding;
import oracle.binding.OperationBinding;

import oracle.jbo.ApplicationModule;
import oracle.jbo.DMLConstraintException;
import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.uicli.binding.JUCtrlValueBinding;

import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;


/**
 * A series of convenience functions for dealing with ADF Bindings.
 * Note: Updated for JDeveloper 11
 *
 * @author Duncan Mills
 * @author Steve Muench
 * @author Ric Smith
 *
 * $Id: ADFUtils.java 2513 2007-09-20 20:39:13Z ralsmith $.
 */
public class ADFUtils {

    public static final ADFLogger LOGGER =
        ADFLogger.createADFLogger(ADFUtils.class);

    public static void invokeMethodExpression(String expr,
                                              QueryEvent queryEvent) {
        FacesContext fctx = FacesContext.getCurrentInstance();
        ELContext elContext = fctx.getELContext();
        ExpressionFactory eFactory =
            fctx.getApplication().getExpressionFactory();
        MethodExpression mexpr =
            eFactory.createMethodExpression(elContext, expr, Object.class,
                                            new Class[] { QueryEvent.class });
        mexpr.invoke(elContext, new Object[] { queryEvent });
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
     * Sets a value into an EL object. Provides similar functionality to
     * the <af:setActionListener> tag, except the from is
     * not an EL. You can get similar behavior by using the following...

     * setEL(to, evaluateEL(from))
     *
     * @param el EL object to assign a value
     * @param val Value to assign
     */
    public static void setEL(String el, Object val) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ELContext elContext = facesContext.getELContext();
        ExpressionFactory expressionFactory =
            facesContext.getApplication().getExpressionFactory();
        ValueExpression exp =
            expressionFactory.createValueExpression(elContext, el,
                                                    Object.class);

        exp.setValue(elContext, val);
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
        return (BindingContainer)JSFUtils.resolveExpression("#{bindings}");
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
                                                          String descriptionAttrName) {
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
    public static List<Key> keyListForIterator(String iteratorName) {
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
            throw new RuntimeException("Iterator '" + name + "' not found");
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
     * Uses the rowKey of each row as the SelectItem key.
     *
     * @param iteratorName ADF iterator binding name
     * @param displayAttrName name of the attribute from iterator rows to display
     * @return ADF Faces SelectItem for an iterator binding
     */
    public static List<SelectItem> selectItemsByKeyForIterator(String iteratorName,
                                                               String displayAttrName) {
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
                                                               String descriptionAttrName) {
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

    public static void executeOperation(String name) throws Exception {
        OperationBinding op = ADFUtils.findOperation(name);
        op.execute();
        List errors = op.getErrors();
        if (!errors.isEmpty())
            throw new Exception((Throwable)errors.get(0));
    }
    
     /**
     * Add a script to the render kit
     */
     public static void addScriptOnPartialRequest(String script) {
         FacesContext context = FacesContext.getCurrentInstance();
         if (AdfFacesContext.getCurrentInstance().isPartialRequest(context)) {
             ExtendedRenderKitService erks =
             Service.getRenderKitService(context, ExtendedRenderKitService.class);
        erks.addScript(context, script);
         }
     }
     //gives a specific componenet the Focus using js call
    public static void focusOnComponent(UIComponent component) {
        String script="var compo = AdfPage.PAGE.findComponentByAbsoluteId('"+component.getClientId(FacesContext.getCurrentInstance())+"');if(compo != null){compo.focus();}";
        addScriptOnPartialRequest(script);
    }
    //gives a specific componenet the Focus using js call
    public static void focusOnComponent(String componentId) {
       String script="var compo = AdfPage.PAGE.findComponentByAbsoluteId('"+componentId+"');if(compo != null){compo.focus();}";
       addScriptOnPartialRequest(script);
    }
    
    //builds a validatorException using message
    public static ValidatorException getValidationException(String message) {
        throw new ValidatorException(new FacesMessage(message));
    }
    
    //builds a validatorException using Expression message
    public static ValidatorException getValidationExceptionFromExpression(String expression) {
        throw new ValidatorException(new FacesMessage(JSFUtils.resolveExpressionAsString(expression)));
    }
    
    
    public static void showInfoMessage(String messageToShow)
    {
        FacesMessage message = new FacesMessage(messageToShow);
        message.setSeverity(FacesMessage.SEVERITY_INFO);
        getFacesContext().addMessage(null, message);
    }
    private static FacesContext getFacesContext()
       {
           FacesContext facesContext = FacesContext.getCurrentInstance();
           return facesContext;
       }
    public static void setPageFlowScopeParamter(String key,
                                                  Object value) {
          AdfFacesContext.getCurrentInstance().getPageFlowScope().put(key, value);
      }
      
      
      public static Object getPageFlowScopeParamter(String key) {
          return AdfFacesContext.getCurrentInstance().getPageFlowScope().get(key);
      }
    /**
     *
     * @param expression
     * @param params
     * @return
     */
    public static String getMessageFromBundle(String expression,
                                              String[] params) {
        String resource = resolveExpressionAsString(expression);
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++)
                resource = resource.replace("{" + i + "}", params[i]);
        }
        return resource;
        // MessageFormat formatter = new MessageFormat(resource, bundle.getLocale());
        // return formatter.format(params);

    }

    /**
     * Reload current page.
     */
    public static void refreshPage() {
        FacesContext context = FacesContext.getCurrentInstance();
      
        String url = JSFUtils.getRequest().getRequestURI();
        System.out.println("************* " + url);
        if (url == null)
            return;
        String urlParams =
            (String)AdfFacesContext.getCurrentInstance().getViewScope().get("urlParams");
        if (urlParams != null && urlParams.length() > 0)
            url = url + "?" + urlParams;
        ExternalContext external = context.getExternalContext();
        try {
            String contextPath =
                FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
            external.redirect(contextPath + "/faces" +
                              "/jsp/redirect.jsp?end_url=" + url);
        } catch (IOException e) {e.printStackTrace();
            // to do ...
        }
    }

    /**
     *
     * @param pageURL
     */
    public static void redirectPage(String pageURL) {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext external = context.getExternalContext();
        try {
            String contextPath =
                FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
            String endUrl = contextPath + pageURL;
            external.redirect(endUrl);
        } catch (IOException e) {e.printStackTrace();
        }
    }

    /**
     *
     * @param component
     */
    public static void clearComponentMessages(UIComponent component) {
    Iterator<FacesMessage> messages = FacesContext.getCurrentInstance().getMessages(component.getClientId(FacesContext.getCurrentInstance()));

    while (messages.hasNext()) {
        messages.next();
        messages.remove();
    }
    }
    /**
     *
     */
    public static void clearAllMessages() {
        FacesContext context = FacesContext.getCurrentInstance();
        Iterator<String> clients = context.getClientIdsWithMessages();
        while (clients.hasNext()) {
            String clientId = clients.next();
            Iterator<FacesMessage> messages = context.getMessages(clientId);

            while (messages.hasNext()) {
                messages.next();
                messages.remove();
            }
        }
    }

    /**
     *
     * @param clientId
     * @return
     */
    public static Boolean hasMessageForClientId(String clientId) {
        FacesContext context = FacesContext.getCurrentInstance();
        final Iterator<String> clientIdIterator = context.getClientIdsWithMessages();
        while (clientIdIterator.hasNext()) {
            if (clientIdIterator.next().equals(clientId)) {
                return true;
            }
        }
        return false;
    }
    
    
    public static String getLanguage(){
        return FacesContext.getCurrentInstance().getViewRoot().getLocale().getLanguage();
    }


    public static void showPopup(String pId) {
            FacesContext context = FacesContext.getCurrentInstance();
            String popupId= findComponentInRoot(pId).getClientId(context);
            ExtendedRenderKitService erkService = Service.getService(context.getRenderKit(), ExtendedRenderKitService.class);
            erkService.addScript(context,"AdfPage.PAGE.findComponent('" + popupId + "').show();");
    
    }
    public static void hidePopup(String pId) {
            FacesContext context = FacesContext.getCurrentInstance();
            String popupId= findComponentInRoot(pId).getClientId(context);
            ExtendedRenderKitService erkService = Service.getService(context.getRenderKit(), ExtendedRenderKitService.class);
            erkService.addScript(context,"AdfPage.PAGE.findComponent('" + popupId + "').hide();");
    
    }
    /**
     * Locate an UIComponent in view root with its component id. Use a recursive way to achieve this.
     * Taken from http://www.jroller.com/page/mert?entry=how_to_find_a_uicomponent
     * @param id UIComponent id
     * @return UIComponent object
     */
    public static UIComponent findComponentInRoot(String id) {
        UIComponent component = null;
        FacesContext facesContext = FacesContext.getCurrentInstance();
        if (facesContext != null) {
            UIComponent root = facesContext.getViewRoot();
            component = findComponent(root, id);
        }
        return component;
    }
    /**
       * Locate an UIComponent from its root component.
       * Taken from http://www.jroller.com/page/mert?entry=how_to_find_a_uicomponent
       * @param base root Component (parent)
       * @param id UIComponent id
       * @return UIComponent object
       */
      public static UIComponent findComponent(UIComponent base, String id) {
          if (id.equals(base.getId()))
              return base;

          UIComponent children = null;
          UIComponent result = null;
          Iterator childrens = base.getFacetsAndChildren();
          while (childrens.hasNext() && (result == null)) {
              children = (UIComponent)childrens.next();
              if (id.equals(children.getId())) {
                  result = children;
                  break;
              }
              result = findComponent(children, id);
              if (result != null) {
                  break;
              }
          }
          return result;
      }
    public static String resolveExpressionAsString(String expression) {
        return (String)JSFUtils.resolveExpression(expression);
    }

    public static String getResourceBundleString(String resourceBundleName,
                                                 String resourceBundleKey) throws MissingResourceException {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ResourceBundle bundle =
            facesContext.getApplication().getResourceBundle(facesContext,
                                                            resourceBundleName);
        return bundle.getString(resourceBundleKey);
    }
}
