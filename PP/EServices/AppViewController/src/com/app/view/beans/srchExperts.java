package com.app.view.beans;

import com.app.view.utils.ADFUtils;

import java.io.Serializable;

import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.ApplicationModule;
import oracle.jbo.ViewObject;

public class srchExperts implements Serializable{
    @SuppressWarnings("compatibility:8163797437159825347")
    private static final long serialVersionUID = 1L;
    private RichInputText it1;
    private RichInputText it2;
    private RichInputText it3;
    private Object name;
    private Object address;
    private Object expertType;
    private RichTable t1;

    public srchExperts() {
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

    public void setName(Object name) {
        this.name = name;
    }

    public Object getName() {
        return name;
    }

    public void setAddress(Object address) {
        this.address = address;
    }

    public Object getAddress() {
        return address;
    }

    public void setExpertType(Object expertType) {
        this.expertType = expertType;
    }

    public Object getExpertType() {
        return expertType;
    }

    public String onSrchExperts() {
        StringBuilder whereClause=new StringBuilder();
        
        if (null != getName())
        {
            if (whereClause.length() != 0)
            whereClause=whereClause.append(" and");
            whereClause=whereClause.append(" Name='" + getName() + "'"); 
        }
        if (null != getAddress())
        {
            if (whereClause.length() != 0)
                whereClause=whereClause.append(" and");
           
            whereClause=whereClause.append(" Address='" + getAddress() +"'" );
        }
        if (null != getExpertType())
        {
            if (whereClause.length() != 0)
                whereClause=whereClause.append(" and");
          
            whereClause=whereClause.append(" Expert_type='" + getExpertType() +"'");
        }
        ApplicationModule am=ADFUtils.getApplicationModuleForDataControl("PPAppServicesDataControl");
        ViewObject vo=am.findViewObject("SrchExpertsResultROVO1");
        vo.setWhereClause(null);
        vo.setWhereClause(whereClause.toString());
        System.out.println("Query is......." + vo.getQuery());
        AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
       
        vo.executeQuery();
        adfFacesContext.getCurrentInstance().addPartialTarget(t1);
        return null;
    }

    public String onSrchExpertClr() {
        setName(null);
        setAddress(null);
        setExpertType(null);
        AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
        adfFacesContext.getCurrentInstance().addPartialTarget(it1);
        adfFacesContext.getCurrentInstance().addPartialTarget(it2);
        adfFacesContext.getCurrentInstance().addPartialTarget(it3);
        ADFUtils.findOperation("initSearchExperts").execute();
//        adfFacesContext.getCurrentInstance().addPartialTarget(t1);
        // Add event code here...
        return null;
    }

    public void setT1(RichTable t1) {
        this.t1 = t1;
    }

    public RichTable getT1() {
        return t1;
    }
}
