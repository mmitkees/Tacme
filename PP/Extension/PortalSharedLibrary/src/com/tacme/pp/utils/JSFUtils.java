package com.tacme.pp.utils;

import java.io.IOException;

import java.text.MessageFormat;

import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.el.ELContext;
import javax.el.ExpressionFactory;

import javax.el.MethodExpression;
import javax.el.ValueExpression;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.adf.view.rich.context.AdfFacesContext;


/**
 * General useful static utilies for working with JSF.
 * NOTE: Updated to use JSF 1.2 ExpressionFactory.
 *
 * @author Duncan Mills
 * @author Steve Muench
 * @author Ric Smith
 *
 * $Id: JSFUtils.java 1885 2007-06-26 00:47:41Z ralsmith $
 */
public class JSFUtils {

    private static final String NO_RESOURCE_FOUND = "Missing resource: ";

    /**
     * Method for taking a reference to a JSF binding expression and returning
     * the matching object (or creating it).
     * @param expression EL expression
     * @return Managed object
     */


    /**
     * Sucsess message .
     */
    public static void ConfirmedSucsess() {
        FacesContext facesCntx = FacesContext.getCurrentInstance();
        FacesMessage msg =
            new FacesMessage(FacesMessage.SEVERITY_INFO, "Executed Successfully",
                             "Executed Successfully");
        facesCntx.addMessage(null, msg);
    }

    /**
     * Sucsess message delete .
     */
    public static void ConfirmedDelete() {
        FacesContext facesCntx = FacesContext.getCurrentInstance();
        FacesMessage msg =
            new FacesMessage(FacesMessage.SEVERITY_INFO, "Delete Successfully",
                             "Executed Successfully");
        facesCntx.addMessage(null, msg);
    }

    /**
     * Sucsess message edite .
     */
    public static void ConfirmedEdite() {
        FacesContext facesCntx = FacesContext.getCurrentInstance();
        FacesMessage msg =
            new FacesMessage(FacesMessage.SEVERITY_INFO, "Edite Successfully",
                             "Executed Successfully");
        facesCntx.addMessage(null, msg);
    }

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

    public static String resolveRemoteUser() {
        FacesContext facesContext = getFacesContext();
        ExternalContext ectx = facesContext.getExternalContext();
        return ectx.getRemoteUser();
    }

    public static String resolveUserPrincipal() {
        FacesContext facesContext = getFacesContext();
        ExternalContext ectx = facesContext.getExternalContext();
        HttpServletRequest request = (HttpServletRequest)ectx.getRequest();
        return request.getUserPrincipal().getName();
    }

    public static Object resolveMethodExpression(String expression,
                                                 Class returnType,
                                                 Class[] argTypes,
                                                 Object[] argValues) {
        FacesContext facesContext = getFacesContext();
        Application app = facesContext.getApplication();
        ExpressionFactory elFactory = app.getExpressionFactory();
        ELContext elContext = facesContext.getELContext();
        MethodExpression methodExpression =
            elFactory.createMethodExpression(elContext, expression, returnType,
                                             argTypes);
        return methodExpression.invoke(elContext, argValues);
    }

    /**
     * Method for taking a reference to a JSF binding expression and returning
     * the matching Boolean.
     * @param expression EL expression
     * @return Managed object
     */
    public static Boolean resolveExpressionAsBoolean(String expression) {
        return (Boolean)resolveExpression(expression);
    }

    /**
     * Method for taking a reference to a JSF binding expression and returning
     * the matching String (or creating it).
     * @param expression EL expression
     * @return Managed object
     */
    public static String resolveExpressionAsString(String expression) {
        return (String)resolveExpression(expression);
    }

    /**
     * Convenience method for resolving a reference to a managed bean by name
     * rather than by expression.
     * @param beanName name of managed bean
     * @return Managed object
     */
    public static Object getManagedBeanValue(String beanName) {
        StringBuffer buff = new StringBuffer("#{");
        buff.append(beanName);
        buff.append("}");
        return resolveExpression(buff.toString());
    }

    /**
     * Method for setting a new object into a JSF managed bean
     * Note: will fail silently if the supplied object does
     * not match the type of the managed bean.
     * @param expression EL expression
     * @param newValue new value to set
     */
    public static void setExpressionValue(String expression, Object newValue) {
        FacesContext facesContext = getFacesContext();
        Application app = facesContext.getApplication();
        ExpressionFactory elFactory = app.getExpressionFactory();
        ELContext elContext = facesContext.getELContext();
        ValueExpression valueExp =
            elFactory.createValueExpression(elContext, expression,
                                            Object.class);

        //Check that the input newValue can be cast to the property type
        //expected by the managed bean.
        //If the managed Bean expects a primitive we rely on Auto-Unboxing
        //I could do a more comprehensive check and conversion from the object
        //to the equivilent primitive but life is too short
        Class bindClass = valueExp.getType(elContext);
        if (bindClass.isPrimitive() || bindClass.isInstance(newValue)) {
            valueExp.setValue(elContext, newValue);
        }
    }

    /**
     * Convenience method for setting the value of a managed bean by name
     * rather than by expression.
     * @param beanName name of managed bean
     * @param newValue new value to set
     */
    public static void setManagedBeanValue(String beanName, Object newValue) {
        StringBuffer buff = new StringBuffer("#{");
        buff.append(beanName);
        buff.append("}");
        setExpressionValue(buff.toString(), newValue);
    }


    /**
     * Convenience method for setting Session variables.
     * @param key object key
     * @param object value to store
     */

    public static void storeOnSession(String key, Object object) {
        FacesContext ctx = getFacesContext();
        Map sessionState = ctx.getExternalContext().getSessionMap();
        sessionState.put(key, object);
    }

    /**
     * Convenience method for getting Session variables.
     * @param key object key
     * @return session object for key
     */
    public static Object getFromSession(String key) {
        FacesContext ctx = getFacesContext();
        Map sessionState = ctx.getExternalContext().getSessionMap();
        return sessionState.get(key);
    }

    public static String getFromHeader(String key) {
        FacesContext ctx = getFacesContext();
        ExternalContext ectx = ctx.getExternalContext();
        return ectx.getRequestHeaderMap().get(key);
    }

    /**
     * Convenience method for getting Request variables.
     * @param key object key
     * @return session object for key
     */
    public static Object getFromRequest(String key) {
        FacesContext ctx = getFacesContext();
        Map sessionState = ctx.getExternalContext().getRequestMap();
        return sessionState.get(key);
    }

    /**
     * Pulls a String resource from the property bundle that
     * is defined under the application &lt;message-bundle&gt; element in
     * the faces config. Respects Locale
     * @param key string message key
     * @return Resource value or placeholder error String
     */
    public static String getStringFromBundle(String key) {
        ResourceBundle bundle = getBundle();
        return getStringSafely(bundle, key, null);
    }


    /**
     * Convenience method to construct a <code>FacesMesssage</code>
     * from a defined error key and severity
     * This assumes that the error keys follow the convention of
     * using <b>_detail</b> for the detailed part of the
     * message, otherwise the main message is returned for the
     * detail as well.
     * @param key for the error message in the resource bundle
     * @param severity severity of message
     * @return Faces Message object
     */
    public static FacesMessage getMessageFromBundle(String key,
                                                    FacesMessage.Severity severity) {
        ResourceBundle bundle = getBundle();
        String summary = getStringSafely(bundle, key, null);
        String detail = getStringSafely(bundle, key + "_detail", summary);
        FacesMessage message = new FacesMessage(summary, detail);
        message.setSeverity(severity);
        return message;
    }

    /**
     * Add JSF info message.
     * @param msg info message string
     */
    public static void addFacesInformationMessage(String msg) {
        FacesContext ctx = getFacesContext();
        FacesMessage fm =
            new FacesMessage(FacesMessage.SEVERITY_INFO, msg, "");
        ctx.addMessage(getRootViewComponentId(), fm);
    }

    /**
     * Add JSF error message.
     * @param msg error message string
     */
    public static void addFacesErrorMessage(String msg) {
        FacesContext ctx = getFacesContext();
        FacesMessage fm =
            new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, "");
        ctx.addMessage(getRootViewComponentId(), fm);
    }

    /**
     * Add JSF error message for a specific attribute.
     * @param attrName name of attribute
     * @param msg error message string
     */
    public static void addFacesErrorMessage(String attrName, String msg) {
        FacesContext ctx = getFacesContext();
        FacesMessage fm =
            new FacesMessage(FacesMessage.SEVERITY_ERROR, attrName, msg);
        ctx.addMessage(getRootViewComponentId(), fm);
    }

    public static void addComponentErrorMessage(String componentId,
                                                String msg) {
        getFacesContext().addMessage(componentId,
                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                      msg, msg));
      //  ADFUtils.focusOnComponent(componentId);
    }

    public static void addComponentInfoMessage(String componentId,
                                               String msg) {
        getFacesContext().addMessage(componentId,
                                     new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                      msg, msg));
       /// ADFUtils.focusOnComponent(componentId);
    }

    // Informational getters

    /**
     * Get view id of the view root.
     * @return view id of the view root
     */
    public static String getRootViewId() {
        return getFacesContext().getViewRoot().getViewId();
    }

    /**
     * Get component id of the view root.
     * @return component id of the view root
     */
    public static String getRootViewComponentId() {
        return getFacesContext().getViewRoot().getId();
    }

    /**
     * Get FacesContext.
     * @return FacesContext
     */
    public static FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }
    /*
   * Internal method to pull out the correct local
   * message bundle
   */

    private static ResourceBundle getBundle() {
        FacesContext ctx = getFacesContext();
        UIViewRoot uiRoot = ctx.getViewRoot();
        Locale locale = uiRoot.getLocale();
        ClassLoader ldr = Thread.currentThread().getContextClassLoader();
        return ResourceBundle.getBundle(ctx.getApplication().getMessageBundle(),
                                        locale, ldr);
    }
    /*
    * Internal method to pull out the correct local
    * message bundle
    */

    private static ResourceBundle getBundle(String bundle) {
        FacesContext ctx = getFacesContext();
        UIViewRoot uiRoot = ctx.getViewRoot();
        Locale locale = uiRoot.getLocale();
        ClassLoader ldr = Thread.currentThread().getContextClassLoader();
        return ResourceBundle.getBundle(bundle, locale, ldr);
    }


    /**
     * Get an HTTP Request attribute.
     * @param name attribute name
     * @return attribute value
     */
    public static Object getRequestAttribute(String name) {
        return getFacesContext().getExternalContext().getRequestMap().get(name);
    }

    /**
     * Set an HTTP Request attribute.
     * @param name attribute name
     * @param value attribute value
     */
    public static void setRequestAttribute(String name, Object value) {
        getFacesContext().getExternalContext().getRequestMap().put(name,
                                                                   value);
    }

    /*
   * Internal method to proxy for resource keys that don't exist
   */

    private static String getStringSafely(ResourceBundle bundle, String key,
                                          String defaultValue) {
        String resource = null;
        try {
            resource = bundle.getString(key);
        } catch (MissingResourceException mrex) {
            if (defaultValue != null) {
                resource = defaultValue;
            } else {
                resource = NO_RESOURCE_FOUND + key;
            }
        }
        return resource;
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

    /**
     * Method to create a redirect URL. The assumption is that the JSF servlet mapping is
     * "faces", which is the default
     *
     * @param view the JSP or JSPX page to redirect to
     * @return a URL to redirect to
     */
    public static String getPageURL(String view) {
        FacesContext facesContext = getFacesContext();
        ExternalContext externalContext = facesContext.getExternalContext();
        String url =
            ((HttpServletRequest)externalContext.getRequest()).getRequestURL().toString();
        StringBuffer newUrlBuffer = new StringBuffer();
        newUrlBuffer.append(url.substring(0, url.lastIndexOf("faces/")));
        newUrlBuffer.append("faces");
        String targetPageUrl = view.startsWith("/") ? view : "/" + view;
        newUrlBuffer.append(targetPageUrl);
        return newUrlBuffer.toString();
    }

    public static Object invokeExpression(String el, Class[] paramTypes,
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

    public static HttpServletRequest getRequest() {
        return (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
    }

    public static HttpServletResponse getResponse() {
        return (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
    }

    public static MethodExpression getMethodExpression(String name) {
        Class[] argtypes = new Class[1];
        argtypes[0] = ActionEvent.class;
        FacesContext facesCtx = FacesContext.getCurrentInstance();
        Application app = facesCtx.getApplication();
        ExpressionFactory elFactory = app.getExpressionFactory();
        ELContext elContext = facesCtx.getELContext();
        return elFactory.createMethodExpression(elContext, name, null,
                                                argtypes);
    }

    
    
    public static String getMessageFromBundle(String expression, String[] params) {
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
        UIViewRoot root = context.getViewRoot();
        String _returnViewId = root.getViewId();
        if (_returnViewId == null)
            return;
        redirectPage(_returnViewId);
     }
    
    public static void redirectPage(String pageURL) {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext external = context.getExternalContext();
        try {
            String contextPath = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
            String endUrl = contextPath+"/faces"+pageURL;
           external.redirect(endUrl);
        } catch (IOException e) {
        }
    }

 

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
}
