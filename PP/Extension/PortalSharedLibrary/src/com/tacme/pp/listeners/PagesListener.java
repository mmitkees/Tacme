package com.tacme.pp.listeners;


import java.util.ArrayList;
import java.util.Locale;

import javax.el.ELContext;
import javax.el.ExpressionFactory;

import javax.el.ValueExpression;

import javax.faces.application.Application;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;


import oracle.adf.controller.v2.lifecycle.Lifecycle;
import oracle.adf.controller.v2.lifecycle.PagePhaseEvent;
import oracle.adf.controller.v2.lifecycle.PagePhaseListener;

import oracle.adf.share.ADFContext;

import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.webcenter.portalframework.sitestructure.ResourceNotFoundException;
import oracle.webcenter.portalframework.sitestructure.SiteStructureContext;

public class PagesListener implements PagePhaseListener {

    public PagesListener() {

    }


    public void afterPhase(PagePhaseEvent pagePhaseEvent) {


        String locale = (String)resolveExpression("#{sessionScope.myLocale}");
//        System.out.println("----------------------------------------------------");
//        System.out.println("locale:" + locale);
//        System.out.println("----------------------------------------------------");
        if (locale != null) {
  //          System.out.println("inside local condition" );

            FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(locale));

        } else {
           FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("ar"));
        }
//        SiteStructureContext ctx = SiteStructureContext.getInstance();
//
////        try {
////        ctx.getDefaultNavigationModel().invalidateCache();
////        } catch (ResourceNotFoundException e) {e.printStackTrace();
////        }
//
    }

//    public void beforePhase(PagePhaseEvent pagePhaseEvent) {
//
//        if (pagePhaseEvent.getPhaseId() == Lifecycle.PREPARE_MODEL_ID &&
//            !AdfFacesContext.getCurrentInstance().isPartialRequest(FacesContext.getCurrentInstance())) {
//
//            ExternalContext external =
//                FacesContext.getCurrentInstance().getExternalContext();
//            ArrayList<String> adfParams = new ArrayList<String>();
//            adfParams.add("_afrWindowId");
//            adfParams.add("_afrLoop");
//            adfParams.add("_afrWindowMode");
//            StringBuilder urlParams = new StringBuilder("");
//            for (String key : external.getRequestParameterMap().keySet()) {
//                if (!adfParams.contains(key)) {
//                    //System.out.println(key+"="+external.getRequestParameterMap().get(key));
//                    String value = external.getRequestParameterMap().get(key);
//                    urlParams.append(key);
//                    urlParams.append("=");
//                    urlParams.append(value);
//                    urlParams.append("&");
//
//                    AdfFacesContext.getCurrentInstance().getViewScope().put(key,
//                                                                            value);
//                }
//            }
//            String params = urlParams.toString();
//            if (params.endsWith("&"))
//                params = params.substring(0, params.length() - 1);
//            // System.out.println(urlParams.toString());
//            AdfFacesContext.getCurrentInstance().getViewScope().put("urlParams",
//                                                                    params);
//
//        }
//    }

    public static Object resolveExpression(String expression) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Application app = facesContext.getApplication();
        ExpressionFactory elFactory = app.getExpressionFactory();
        ELContext elContext = facesContext.getELContext();
        ValueExpression valueExp =
            elFactory.createValueExpression(elContext, expression,
                                            Object.class);
        return valueExp.getValue(elContext);
    }
    //
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

    public void beforePhase(PagePhaseEvent pagePhaseEvent) {
    }

//    public void afterPhase(PagePhaseEvent pagePhaseEvent) {
//    }
}

