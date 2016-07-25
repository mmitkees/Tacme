package com.app.view.beans;

import com.app.view.utils.ADFUtils;

import java.io.Serializable;

import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.ApplicationModule;
import oracle.jbo.ViewObject;

public class srchLawyers implements Serializable{
    @SuppressWarnings("compatibility:8577776776096348665")
    private static final long serialVersionUID = 1L;
    private RichInputText it1;
    private RichInputText soc1;
    private RichInputText it3;
    private Number name;
    private Object city;
    private Object address;
    private RichTable t1;


    public srchLawyers() {
    }

    public void setIt1(RichInputText it1) {
        this.it1 = it1;
    }

    public RichInputText getIt1() {
        return it1;
    }

    public void setSoc1(RichInputText soc1) {
        this.soc1 = soc1;
    }

    public RichInputText getSoc1() {
        return soc1;
    }

    public void setIt3(RichInputText it3) {
        this.it3 = it3;
    }

    public RichInputText getIt3() {
        return it3;
    }
    

    public void setCity(Object city) {
        this.city = city;
    }

    public Object getCity() {
        return city;
    }

    public void setAddress(Object address) {
        this.address = address;
    }

    public Object getAddress() {
        return address;
    }

    public String onSrchLawyers() {
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
        if (null != getCity())
        {
            if (whereClause.length() != 0)
                whereClause=whereClause.append(" and");
          
            whereClause=whereClause.append(" City='" + getCity() +"'");
        }
        ApplicationModule am=ADFUtils.getApplicationModuleForDataControl("PPAppServicesDataControl");
        ViewObject vo=am.findViewObject("SrchLawyersResultROVO1");
        vo.setWhereClause(null);
        vo.setWhereClause(whereClause.toString());
        System.out.println("Query is......." + vo.getQuery());
        AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
        
        vo.executeQuery();
        adfFacesContext.getCurrentInstance().addPartialTarget(t1);
        return null;
    }

    public String onSrchLawyersClear() {
        setName(null);
        setAddress(null);
        setCity(null);
        AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
        adfFacesContext.getCurrentInstance().addPartialTarget(it1);
        adfFacesContext.getCurrentInstance().addPartialTarget(soc1);
        adfFacesContext.getCurrentInstance().addPartialTarget(it3);
        ADFUtils.findOperation("initSearchLawyers").execute();
//        adfFacesContext.getCurrentInstance().addPartialTarget(t1);
        return null;
    }

    public void setT1(RichTable t1) {
        this.t1 = t1;
    }

    public RichTable getT1() {
        return t1;
    }

    public void setName(Number name) {
        this.name = name;
    }

    public Number getName() {
        return name;
    }
}
