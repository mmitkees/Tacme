package com.pp.newsletter.model.services.common;

import java.util.List;

import oracle.jbo.ApplicationModule;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Jan 23 10:30:13 IST 2016
// ---------------------------------------------------------------------
public interface newsLetterAM extends ApplicationModule {
    String newssubscribe(String m_name, String m_email, List m_s);

    void executeCategories(String email);

    String checkCateg();
}
