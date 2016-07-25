package com.app.model.services.client;

import com.app.model.services.common.PPAppServices;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Locale;
import java.util.Map;

import model.services.common.SMSPrjService;

import oracle.jbo.client.remote.ApplicationModuleImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Sep 21 12:38:42 IST 2015
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class PPAppServicesClient extends ApplicationModuleImpl implements PPAppServices,Serializable {
    @SuppressWarnings("compatibility:489847993750437703")
    private static final long serialVersionUID = 1L;

    /**
     * This is the default constructor (do not remove).
     */
    public PPAppServicesClient() {
    }


    public Map getResourceBundle(String locale) {
        Object _ret =
            this.riInvokeExportedMethod(this,"getResourceBundle",new String [] {"java.lang.String"},new Object[] {locale});
        return (Map)_ret;
    }


    //    public Map getResourceBundle(String locale) {
//        Object _ret =
//            this.riInvokeExportedMethod(this,"getResourceBundle",new String [] {"java.lang.String"},new Object[] {locale});
//        return (Map)_ret;
//    }


    //    public Map getResourceBundle(String locale) {
//        Object _ret =
//            this.riInvokeExportedMethod(this,"getResourceBundle",new String [] {"java.lang.String"},new Object[] {locale});
//        return (Map)_ret;
//    }


    //    public Map getResourceBundle(String locale) {
//        Object _ret =
//            this.riInvokeExportedMethod(this,"getResourceBundle",new String [] {"java.lang.String"},new Object[] {locale});
//        return (Map)_ret;
//    }


    //    public Map getResourceBundle(String locale) {
//        Object _ret =
//            this.riInvokeExportedMethod(this,"getResourceBundle",new String [] {"java.lang.String"},new Object[] {locale});
//        return (Map)_ret;
//    }


    //    public Map getResourceBundle(String locale) {
//        Object _ret =
//            this.riInvokeExportedMethod(this,"getResourceBundle",new String [] {"java.lang.String"},new Object[] {locale});
//        return (Map)_ret;
//    }


    //    public Map getResourceBundle(String locale) {
//        Object _ret =
//            this.riInvokeExportedMethod(this,"getResourceBundle",new String [] {"java.lang.String"},new Object[] {locale});
//        return (Map)_ret;
//    }


    public SMSPrjService getSMSPrjService() {
        return (SMSPrjService)findApplicationModule("SMSPrjService1");
    }


    //    public Map getResourceBundle(String locale) {
//        Object _ret =
//            this.riInvokeExportedMethod(this,"getResourceBundle",new String [] {"java.lang.String"},new Object[] {locale});
//        return (Map)_ret;
//    }


    //    public Map getResourceBundle(String locale) {
//        Object _ret =
//            this.riInvokeExportedMethod(this,"getResourceBundle",new String [] {"java.lang.String"},new Object[] {locale});
//        return (Map)_ret;
//    }


//    public Map getResourceBundle(String locale) {
//        Object _ret =
//            this.riInvokeExportedMethod(this,"getResourceBundle",new String [] {"java.lang.String"},new Object[] {locale});
//        return (Map)_ret;
//    }


    //    public Map getResourceBundle(String locale) {
//        Object _ret =
//            this.riInvokeExportedMethod(this,"getResourceBundle",new String [] {"java.lang.String"},new Object[] {locale});
//        return (Map)_ret;
//    }


    //    public Map getResourceBundle(String locale) {
//        Object _ret =
//            this.riInvokeExportedMethod(this,"getResourceBundle",new String [] {"java.lang.String"},new Object[] {locale});
//        return (Map)_ret;
//    }


    public void srchCases(BigDecimal amcaseno, BigDecimal amcaseyear,
                          String amprosname) {
        Object _ret =
            this.riInvokeExportedMethod(this,"srchCases",new String [] {"java.math.BigDecimal","java.math.BigDecimal","java.lang.String"},new Object[] {amcaseno, amcaseyear, amprosname});
        return;
    }


    //    public Map getResourceBundle(String locale) {
//        Object _ret =
//            this.riInvokeExportedMethod(this,"getResourceBundle",new String [] {"java.lang.String"},new Object[] {locale});
//        return (Map)_ret;
//    }


   


    public String login_db(String un, String pwrd) {
        Object _ret =
            this.riInvokeExportedMethod(this,"login_db",new String [] {"java.lang.String","java.lang.String"},new Object[] {un, pwrd});
        return (String)_ret;
    }

    public String change_pwrd(String c_pwrd, String n_pwrd, String co_pwrd) {
        Object _ret =
            this.riInvokeExportedMethod(this,"change_pwrd",new String [] {"java.lang.String","java.lang.String","java.lang.String"},new Object[] {c_pwrd, n_pwrd, co_pwrd});
        return (String)_ret;
    }

    public void initSearchCase() {
        Object _ret = this.riInvokeExportedMethod(this,"initSearchCase",null,null);
        return;
    }

  

    public void initSearchExperts() {
        Object _ret =
            this.riInvokeExportedMethod(this,"initSearchExperts",null,null);
        return;
    }

    public void initSearchLawyers() {
        Object _ret =
            this.riInvokeExportedMethod(this,"initSearchLawyers",null,null);
        return;
    }

    public void initSrchLaw() {
        Object _ret = this.riInvokeExportedMethod(this,"initSrchLaw",null,null);
        return;
    }

    public void initSrchLawROVO() {
        Object _ret =
            this.riInvokeExportedMethod(this,"initSrchLawROVO",null,null);
        return;
    }

    public void initSrchLawROVOAR() {
        Object _ret =
            this.riInvokeExportedMethod(this,"initSrchLawROVOAR",null,null);
        return;
    }

    public void srchLawyers(String name, String city, String address) {
        Object _ret =
            this.riInvokeExportedMethod(this,"srchLawyers",new String [] {"java.lang.String","java.lang.String","java.lang.String"},new Object[] {name, city, address});
        return;
    }

    public void srchExperts(String name, String exprttype, String address) {
        Object _ret =
            this.riInvokeExportedMethod(this,"srchExperts",new String [] {"java.lang.String","java.lang.String","java.lang.String"},new Object[] {name, exprttype, address});
        return;
    }

    public void srchLaw(String langcat, String srchwithin, String article) {
        Object _ret =
            this.riInvokeExportedMethod(this,"srchLaw",new String [] {"java.lang.String","java.lang.String","java.lang.String"},new Object[] {langcat, srchwithin, article});
        return;
    }

    public String generateCaptchaString() {
        Object _ret =
            this.riInvokeExportedMethod(this,"generateCaptchaString",null,null);
        return (String)_ret;
    }

    public String setCurrentsrchDescAR(String sid) {
        Object _ret =
            this.riInvokeExportedMethod(this,"setCurrentsrchDescAR",new String [] {"java.lang.String"},new Object[] {sid});
        return (String)_ret;
    }

    public String setCurrentsrchDescEN(String sid) {
        Object _ret =
            this.riInvokeExportedMethod(this,"setCurrentsrchDescEN",new String [] {"java.lang.String"},new Object[] {sid});
        return (String)_ret;
    }

    public String setPassword(String email) {
        Object _ret =
            this.riInvokeExportedMethod(this,"setPassword",new String [] {"java.lang.String"},new Object[] {email});
        return (String)_ret;
    }

    public String addContact(String am_name, String am_address,
                             String am_email, String am_phno, String am_subj,
                             String am_desc) {
        Object _ret =
            this.riInvokeExportedMethod(this,"addContact",new String [] {"java.lang.String","java.lang.String","java.lang.String","java.lang.String","java.lang.String","java.lang.String"},new Object[] {am_name, am_address, am_email, am_phno, am_subj, am_desc});
        return (String)_ret;
    }

    public void initTranslators() {
        Object _ret =
            this.riInvokeExportedMethod(this,"initTranslators",null,null);
        return;
    }

    public void srchtranslators(String name, String city, String address) {
        Object _ret =
            this.riInvokeExportedMethod(this,"srchtranslators",new String [] {"java.lang.String","java.lang.String","java.lang.String"},new Object[] {name, city, address});
        return;
    }

    public String execSearchLaw(String txt) {
        Object _ret =
            this.riInvokeExportedMethod(this,"execSearchLaw",new String [] {"java.lang.String"},new Object[] {txt});
        return (String)_ret;
    }

    public String setServices(Locale lang, String sid) {
        Object _ret =
            this.riInvokeExportedMethod(this,"setServices",new String [] {"java.util.Locale","java.lang.String"},new Object[] {lang, sid});
        return (String)_ret;
    }

    public String saveResponseStatus(String invoiceNo, String transMessage) {
        Object _ret =
            this.riInvokeExportedMethod(this,"saveResponseStatus",new String [] {"java.lang.String","java.lang.String"},new Object[] {invoiceNo, transMessage});
        return (String)_ret;
    }

    public void getRowDelete(int rindex) {
        Object _ret =
            this.riInvokeExportedMethod(this,"getRowDelete",new String [] {"int"},new Object[] {new Integer(rindex)});
        return;
    }

    public void clearsrchCases() {
        Object _ret = this.riInvokeExportedMethod(this,"clearsrchCases",null,null);
        return;
    }

    public String emailExist(String email) {
        Object _ret =
            this.riInvokeExportedMethod(this,"emailExist",new String [] {"java.lang.String"},new Object[] {email});
        return (String)_ret;
    }

    public void srchCases(Integer amcaseno, Integer amcaseyear,
                          BigDecimal amprosname) {
        Object _ret =
            this.riInvokeExportedMethod(this,"srchCases",new String [] {"java.lang.Integer","java.lang.Integer","java.math.BigDecimal"},new Object[] {amcaseno, amcaseyear, amprosname});
        return;
    }
}
