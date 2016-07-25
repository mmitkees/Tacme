package com.app.view.beans;

import com.app.view.utils.ADFUtils;

import java.io.Serializable;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.BindingContainer;

import oracle.binding.OperationBinding;

import oracle.jbo.ApplicationModule;
import oracle.jbo.ViewObject;

public class srchLaw implements Serializable{
    @SuppressWarnings("compatibility:5163899101274734514")
    private static final long serialVersionUID = 1L;
    private RichSelectOneChoice soc1;
    private RichTable t1;
    private Object lawCatg;
    private Object srchWithin;
    private Object law;
    private Object article;
    private RichSelectOneChoice soc2;
    private RichSelectOneChoice soc3;
    private RichSelectOneChoice soc4;
    private String res;

    public srchLaw() {
    }

    public void setSoc1(RichSelectOneChoice soc1) {
        this.soc1 = soc1;
    }

    public RichSelectOneChoice getSoc1() {
        return soc1;
    }

    public void onLawCatgChange(ValueChangeEvent valueChangeEvent) {
        if (null != valueChangeEvent.getNewValue()) {
            System.out.println("new law category value is...." +
                               valueChangeEvent.getNewValue());
            setLawCatg(valueChangeEvent.getNewValue());
        }

        // Add event code here...
    }

    public void onSrchWithinChange(ValueChangeEvent valueChangeEvent) {
        if (null != valueChangeEvent.getNewValue()) {
            System.out.println("new srch within value is...." +
                               valueChangeEvent.getNewValue());
            setSrchWithin(valueChangeEvent.getNewValue());
        }

    }

    public void onLawChange(ValueChangeEvent valueChangeEvent) {
        if (null != valueChangeEvent.getNewValue()) {
            System.out.println("new law value is...." +
                               valueChangeEvent.getNewValue());
            setLaw(valueChangeEvent.getNewValue());
        }

    }

    public void onArticleChange(ValueChangeEvent valueChangeEvent) {
        if (null != valueChangeEvent.getNewValue()) {
            System.out.println("new article value is...." +
                               valueChangeEvent.getNewValue());
            setArticle(valueChangeEvent.getNewValue());
        }

    }

    public void setT1(RichTable t1) {
        this.t1 = t1;
    }

    public RichTable getT1() {
        return t1;
    }
    
    public String getdescription(){
        BindingContainer bindings = BindingContext.getCurrent().getCurrentBindingsEntry(); 
        OperationBinding method = bindings.getOperationBinding("execSearchLaw");  
        res = (String)method.execute();
        return null;
    }

    public String onSrchLaw() {
        ApplicationModule am =
            ADFUtils.getApplicationModuleForDataControl("PPAppServicesDataControl");
        ViewObject vo = am.findViewObject("SrchLawROVO1");
        vo.setWhereClause(null);
        StringBuilder whereClause = new StringBuilder();
        System.out.println("law category value is..... " + getLawCatg());
        if (null != getLawCatg())
        {
            if (whereClause.length() != 0)
            whereClause=whereClause.append(" and");
            whereClause=whereClause.append(" CATEGORY_ID=" + getLawCatg()); 
        }
        if (null != getSrchWithin())
        {
            if (whereClause.length() != 0)
            whereClause=whereClause.append(" and");
            whereClause=whereClause.append(" SER_WITHIN_ID=" + getSrchWithin()); 
        }
        if (null != getLaw())
        {
            if (whereClause.length() != 0)
            whereClause=whereClause.append(" and");
            whereClause=whereClause.append(" EMIRATES_ID=" + getLaw()); 
        }
        if (null != getArticle())
        {
            if (whereClause.length() != 0)
            whereClause=whereClause.append(" and");
            whereClause=whereClause.append(" ARTICLE_ID=" + getArticle()); 
        }
        vo.setWhereClause(null);
        vo.setWhereClause(whereClause.toString());
        System.out.println("Query is......." + vo.getQuery());
        vo.executeQuery();
        AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
        adfFacesContext.getCurrentInstance().addPartialTarget(t1);
        return null;
    }

    public void setLawCatg(Object lawCatg) {
        this.lawCatg = lawCatg;
    }

    public Object getLawCatg() {
        return lawCatg;
    }

    public void setSrchWithin(Object srchWithin) {
        this.srchWithin = srchWithin;
    }

    public Object getSrchWithin() {
        return srchWithin;
    }

    public void setLaw(Object law) {
        this.law = law;
    }

    public Object getLaw() {
        return law;
    }

    public void setArticle(Object article) {
        this.article = article;
    }

    public Object getArticle() {
        return article;
    }

    public void setSoc2(RichSelectOneChoice soc2) {
        this.soc2 = soc2;
    }

    public RichSelectOneChoice getSoc2() {
        return soc2;
    }

    public void setSoc3(RichSelectOneChoice soc3) {
        this.soc3 = soc3;
    }

    public RichSelectOneChoice getSoc3() {
        return soc3;
    }

    public void setSoc4(RichSelectOneChoice soc4) {
        this.soc4 = soc4;
    }

    public RichSelectOneChoice getSoc4() {
        return soc4;
    }


    public void setRes(String res) {
        this.res = res;
    }

    public String getRes() {
        return res;
    }
}
