import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.view.rich.component.rich.output.RichOutputText;

import oracle.binding.BindingContainer;

import oracle.binding.OperationBinding;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;

public class carrersListBean {
    private String clb_posid;
    private String clb_jobtitle;
    private String clb_jobreq;
    private RichOutputText cdate;
    private String b_search;

    public carrersListBean() {
    }

    public void closecb_vcl(ValueChangeEvent vce) {
        if (vce.getNewValue() != null){            
            if (vce.getNewValue().equals(true)){
                java.sql.Timestamp datetime = new java.sql.Timestamp(System.currentTimeMillis());
                oracle.jbo.domain.Date daTime = new  oracle.jbo.domain.Date(datetime);
                ViewObject vo = getAm().findViewObject("PpCarrersView1");
                Row vr = vo.getCurrentRow();
                vr.setAttribute("CloseDate", daTime);
            }
        }
    }

    public void setCdate(RichOutputText cdate) {
        this.cdate = cdate;
    }

    public RichOutputText getCdate() {
        return cdate;
    }
    
    private ApplicationModule getAm() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Application app = fc.getApplication();
        ExpressionFactory elFactory = app.getExpressionFactory();
        ELContext elContext = fc.getELContext();
        ValueExpression valueExp =
            elFactory.createValueExpression(elContext, "#{data.ppCarrersServiceDataControl.dataProvider}",
                                            Object.class);
        return (ApplicationModule)valueExp.getValue(elContext);
    }

    public void setClb_posid(String clb_posid) {
        this.clb_posid = clb_posid;
    }

    public String getClb_posid() {
        return clb_posid;
    }

    public void setClb_jobtitle(String clb_jobtitle) {
        this.clb_jobtitle = clb_jobtitle;
    }

    public String getClb_jobtitle() {
        return clb_jobtitle;
    }

    public void setClb_jobreq(String clb_jobreq) {
        this.clb_jobreq = clb_jobreq;
    }

    public String getClb_jobreq() {
        return clb_jobreq;
    }

    public String search_action() {
        BindingContainer bindings = BindingContext.getCurrent().getCurrentBindingsEntry(); 
        OperationBinding method = bindings.getOperationBinding("carrersSearch");  
        method.execute();  
        return null;
    }

    public void setB_search(String b_search) {
        this.b_search = b_search;
    }

    public String getB_search() {
        return b_search;
    }
}
