package com.app.view.beans;

import java.io.Serializable;

import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

public class LocaleBean implements Serializable{
    @SuppressWarnings("compatibility:5016998336466723318")
    private static final long serialVersionUID = 1L;
    private String language="ar";
    public LocaleBean() {
        super();
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }
    
    protected void refreshPage() {
          FacesContext fc = FacesContext.getCurrentInstance();
          String refreshpage = fc.getViewRoot().getViewId();
     ViewHandler ViewH =                                                                                                                   
     fc.getApplication().getViewHandler();
          UIViewRoot UIV = ViewH.createView(fc,refreshpage);
          UIV.setViewId(refreshpage);
          fc.setViewRoot(UIV);
    }

    public void SelectLang(ValueChangeEvent valueChangeEvent) {
//        System.out.println ("Set the language"+language);
//        refreshPage();
    }

    public String b_action() {
        refreshPage();
        return null;
    }
}
