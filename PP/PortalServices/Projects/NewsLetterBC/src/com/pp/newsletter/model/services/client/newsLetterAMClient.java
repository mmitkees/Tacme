package com.pp.newsletter.model.services.client;

import com.pp.newsletter.model.services.common.newsLetterAM;

import java.util.List;

import oracle.jbo.client.remote.ApplicationModuleImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Jan 23 10:30:13 IST 2016
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class newsLetterAMClient extends ApplicationModuleImpl implements newsLetterAM {
    /**
     * This is the default constructor (do not remove).
     */
    public newsLetterAMClient() {
    }


    public String newssubscribe(String m_name, String m_email, List m_s) {
        Object _ret =
            this.riInvokeExportedMethod(this,"newssubscribe",new String [] {"java.lang.String","java.lang.String","java.util.List"},new Object[] {m_name, m_email, m_s});
        return (String)_ret;
    }

    public void executeCategories(String email) {
        Object _ret =
            this.riInvokeExportedMethod(this,"executeCategories",new String [] {"java.lang.String"},new Object[] {email});
        return;
    }

    public String checkCateg() {
        Object _ret = this.riInvokeExportedMethod(this,"checkCateg",null,null);
        return (String)_ret;
    }
}
