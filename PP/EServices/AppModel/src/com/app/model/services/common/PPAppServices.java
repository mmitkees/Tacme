package com.app.model.services.common;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Locale;
import java.util.Map;

import oracle.jbo.ApplicationModule;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Sep 21 12:38:41 IST 2015
// ---------------------------------------------------------------------
public interface PPAppServices extends ApplicationModule {
    String login_db(String un, String pwrd);

    String change_pwrd(String c_pwrd, String n_pwrd, String co_pwrd);


    void initSearchCase();

    Map<String, String> getResourceBundle(String locale);

    void initSearchExperts();

    void initSearchLawyers();

    void initSrchLaw();

    void initSrchLawROVO();

    void initSrchLawROVOAR();

    void srchLawyers(String name, String city, String address);

    void srchExperts(String name, String exprttype, String address);

    void srchLaw(String langcat, String srchwithin, String article);

    String generateCaptchaString();

    String setCurrentsrchDescAR(String sid);

    String setCurrentsrchDescEN(String sid);

    String setPassword(String email);

    String addContact(String am_name, String am_address, String am_email,
                      String am_phno, String am_subj, String am_desc);

    void initTranslators();

    void srchtranslators(String name, String city, String address);

    String execSearchLaw(String txt);

    String setServices(Locale lang, String sid);

    String saveResponseStatus(String invoiceNo, String transMessage);

    void getRowDelete(int rindex);


    void clearsrchCases();

    String emailExist(String email);

    void srchCases(Integer amcaseno, Integer amcaseyear,
                   BigDecimal amprosname);
}
