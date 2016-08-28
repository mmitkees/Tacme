package com.app.view.beans;

import com.tacme.pp.common.utils.ADFUtils; 

import java.io.Serializable;

import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.context.AdfFacesContext;

public class searchTranslator implements Serializable{
    @SuppressWarnings("compatibility:-7177345773280001485")
    private static final long serialVersionUID = 1L;
    private RichInputText it1;
    private RichInputText it2;
    private RichInputText it3;
    private Object name;
    private Object city;
    private Object address;
    private RichTable t1;

    public searchTranslator() {
        super();
    }

    public void setName(Object name) {
        this.name = name;
    }

    public Object getName() {
        return name;
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
    
    public String onSrchLawyersClear() {
           setName(null);
           setAddress(null);
           setCity(null);
           AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
           adfFacesContext.getCurrentInstance().addPartialTarget(it1);
           adfFacesContext.getCurrentInstance().addPartialTarget(it2);
           adfFacesContext.getCurrentInstance().addPartialTarget(it3);
           ADFUtils.findOperation("initTranslators").execute();
//           adfFacesContext.getCurrentInstance().addPartialTarget(t1);
           return null;
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

    public void setT1(RichTable t1) {
        this.t1 = t1;
    }

    public RichTable getT1() {
        return t1;
    }
}
