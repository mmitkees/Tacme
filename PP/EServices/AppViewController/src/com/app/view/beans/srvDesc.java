package com.app.view.beans;

import com.tacme.pp.common.utils.ADFUtils;

import com.tacme.pp.common.utils.JSFUtils;

import java.io.Serializable;

import javax.faces.event.ActionEvent;

import oracle.jbo.ApplicationModule;
import oracle.jbo.ViewObject;

public class srvDesc implements Serializable{
    @SuppressWarnings("compatibility:-257579888836272406")
    private static final long serialVersionUID = 1L;

    public srvDesc() {
    }

   

    public String gotoDesc() {
        ApplicationModule am=ADFUtils.getApplicationModuleForDataControl("PPAppServicesDataControl");
        ViewObject vo=am.findViewObject("ReqSerDescVO1");
        vo.setWhereClause(null);
        vo.setWhereClause("SERVICE_ID=" + JSFUtils.resolveExpression("#{row.bindings.ServiceId.inputValue}"));
        System.out.println("query is...." + vo.getQuery());
        vo.executeQuery();
        return "gotocurrentrow";
    }
}
