import java.util.List;

import java.util.ArrayList;

import java.util.Locale;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;

import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;

import oracle.adf.model.BindingContext;

import oracle.adf.view.rich.component.rich.nav.RichCommandButton;

import oracle.binding.BindingContainer;

import oracle.binding.OperationBinding;

import oracle.jbo.uicli.binding.JUCtrlListBinding;

public class newsSubscribeBean {
    private String b_name;
    private String b_email;
    private List l = new ArrayList();
    private String s[];
    private String show = "N";
    private RichCommandButton showCategBind;
    private RichCommandButton subscBind;

    public newsSubscribeBean() {
    }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public String subscribe_action() {        
        JUCtrlListBinding listBindings =
            (JUCtrlListBinding)getBindings().get("CategoriesView1");
        Object str[] = listBindings.getSelectedValues();
        for (int i = 0; i < str.length; i++) {
            l.add(str[i]);            
//            s[i] = (String)str[i];
        }        
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding =
            bindings.getOperationBinding("newssubscribe");
        String res = (String)operationBinding.execute();
        
        if (res != null) {
            if (res.equals("Y")) {                
                commit_action("You have been susbscribed to the above categories");
            }
            if (res.equals("M")) {
                FacesMessage Message =
                    new FacesMessage("Kindly enter all the mandatory fields");
                Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, Message);
            }
            if (res.equals("N")) {
                FacesMessage Message =
                    new FacesMessage("Subscription failed. Contact administrator");
                Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, Message);
            }
            if (res.equals("exist")) {
                FacesMessage Message =
                    new FacesMessage("Categories already exist");
                Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, Message);
            }
        }
        return null;
    }

    public void setB_name(String b_name) {
        this.b_name = b_name;
    }

    public String getB_name() {
        return b_name;
    }

    public void setB_email(String b_email) {
        this.b_email = b_email;
    }

    public String getB_email() {
        return b_email;
    }

    public void setL(List l) {
        this.l = l;
    }

    public List getL() {
        return l;
    }

    public String commit_action(String msg) {
        String ca = "N";
        BindingContainer bindings = getBindings();
        OperationBinding checkCategOb =
            bindings.getOperationBinding("checkCateg");
        String checkCateg = (String)checkCategOb.execute();
        System.err.println("<---------Return value-------->"+checkCateg);
        if (checkCateg.equals("Y")){
        OperationBinding operationBinding =
            bindings.getOperationBinding("Commit");
        operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }else{
//            FacesMessage Message =
//                new FacesMessage(msg);
//            Message.setSeverity(FacesMessage.SEVERITY_INFO);
//            FacesContext fc = FacesContext.getCurrentInstance();
//            fc.addMessage(null, Message);
            ca = "Y";
        }
        }else if (checkCateg.equals("N")){
            FacesMessage Message =
                new FacesMessage("Please select the categories");
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
        System.err.println("<---------Return value-------->"+ca);
        return ca;
    }
    
    public String newSubscribeAction(){
        commit_action("Subscription has been send");        
        return null;
    }

    public void setS(String[] s) {
        this.s = s;
    }

    public String[] getS() {
        return s;
    }

    public String add_action() {
        this.setB_email("");
        this.setB_name("");
        l = null;        
        return null;
    }

    public String showCategories() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding =
            bindings.getOperationBinding("executeCategories");
        operationBinding.execute();
        this.subscBind.setVisible(true);
        this.showCategBind.setVisible(false);
        show = "Y";
        return null;
    }

    public void setShow(String show) {
        this.show = show;
    }

    public String getShow() {
        return show;
    }

    public void setShowCategBind(RichCommandButton showCategBind) {
        this.showCategBind = showCategBind;
    }

    public RichCommandButton getShowCategBind() {
        return showCategBind;
    }

    public void setSubscBind(RichCommandButton subscBind) {
        this.subscBind = subscBind;
    }

    public RichCommandButton getSubscBind() {
        return subscBind;
    }

    public String commitAction() {
        String ca = null;
//        Locale localel = (Locale)evaluateEL("#{pageFlowScope.locale}");
//        String locale = localel.toString();
        String locale = "en";
        if (locale.equals("en")){
            ca = commit_action("Subscribed to the selected categories");
        }else if (locale.equals("ar")){
            ca = commit_action("Subscribed to the selected categories");
        }
        return ca;
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
}
