package com.pp.news.ae.model.views;

import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Jan 20 10:21:21 IST 2016
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class UcmConfigViewImpl extends ViewObjectImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public UcmConfigViewImpl() {
    }

    /**
     * Returns the bind variable value for uctype.
     * @return bind variable value for uctype
     */
    public String getuctype() {
        return (String)getNamedWhereClauseParam("uctype");
    }

    /**
     * Sets <code>value</code> for bind variable uctype.
     * @param value value to bind as uctype
     */
    public void setuctype(String value) {
        setNamedWhereClauseParam("uctype", value);
    }
}
