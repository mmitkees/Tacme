package com.pp.news.ae.model.views;

import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Jan 20 10:21:20 IST 2016
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class UcmConfigViewRowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        UcId {
            public Object get(UcmConfigViewRowImpl obj) {
                return obj.getUcId();
            }

            public void put(UcmConfigViewRowImpl obj, Object value) {
                obj.setUcId((Number)value);
            }
        }
        ,
        UcType {
            public Object get(UcmConfigViewRowImpl obj) {
                return obj.getUcType();
            }

            public void put(UcmConfigViewRowImpl obj, Object value) {
                obj.setUcType((String)value);
            }
        }
        ,
        UcUsername {
            public Object get(UcmConfigViewRowImpl obj) {
                return obj.getUcUsername();
            }

            public void put(UcmConfigViewRowImpl obj, Object value) {
                obj.setUcUsername((String)value);
            }
        }
        ,
        UcPassword {
            public Object get(UcmConfigViewRowImpl obj) {
                return obj.getUcPassword();
            }

            public void put(UcmConfigViewRowImpl obj, Object value) {
                obj.setUcPassword((String)value);
            }
        }
        ,
        UcUrl {
            public Object get(UcmConfigViewRowImpl obj) {
                return obj.getUcUrl();
            }

            public void put(UcmConfigViewRowImpl obj, Object value) {
                obj.setUcUrl((String)value);
            }
        }
        ,
        UcPortno {
            public Object get(UcmConfigViewRowImpl obj) {
                return obj.getUcPortno();
            }

            public void put(UcmConfigViewRowImpl obj, Object value) {
                obj.setUcPortno((String)value);
            }
        }
        ,
        OrgUrl {
            public Object get(UcmConfigViewRowImpl obj) {
                return obj.getOrgUrl();
            }

            public void put(UcmConfigViewRowImpl obj, Object value) {
                obj.setOrgUrl((String)value);
            }
        }
        ,
        ReplaceUrl {
            public Object get(UcmConfigViewRowImpl obj) {
                return obj.getReplaceUrl();
            }

            public void put(UcmConfigViewRowImpl obj, Object value) {
                obj.setReplaceUrl((String)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(UcmConfigViewRowImpl object);

        public abstract void put(UcmConfigViewRowImpl object, Object value);

        public int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        public static final int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        public static final AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }

    public static final int UCID = AttributesEnum.UcId.index();
    public static final int UCTYPE = AttributesEnum.UcType.index();
    public static final int UCUSERNAME = AttributesEnum.UcUsername.index();
    public static final int UCPASSWORD = AttributesEnum.UcPassword.index();
    public static final int UCURL = AttributesEnum.UcUrl.index();
    public static final int UCPORTNO = AttributesEnum.UcPortno.index();
    public static final int ORGURL = AttributesEnum.OrgUrl.index();
    public static final int REPLACEURL = AttributesEnum.ReplaceUrl.index();

    /**
     * This is the default constructor (do not remove).
     */
    public UcmConfigViewRowImpl() {
    }

    /**
     * Gets UcmConfig entity object.
     * @return the UcmConfig
     */
    public EntityImpl getUcmConfig() {
        return (EntityImpl)getEntity(0);
    }

    /**
     * Gets the attribute value for UC_ID using the alias name UcId.
     * @return the UC_ID
     */
    public Number getUcId() {
        return (Number) getAttributeInternal(UCID);
    }

    /**
     * Sets <code>value</code> as attribute value for UC_ID using the alias name UcId.
     * @param value value to set the UC_ID
     */
    public void setUcId(Number value) {
        setAttributeInternal(UCID, value);
    }

    /**
     * Gets the attribute value for UC_TYPE using the alias name UcType.
     * @return the UC_TYPE
     */
    public String getUcType() {
        return (String) getAttributeInternal(UCTYPE);
    }

    /**
     * Sets <code>value</code> as attribute value for UC_TYPE using the alias name UcType.
     * @param value value to set the UC_TYPE
     */
    public void setUcType(String value) {
        setAttributeInternal(UCTYPE, value);
    }

    /**
     * Gets the attribute value for UC_USERNAME using the alias name UcUsername.
     * @return the UC_USERNAME
     */
    public String getUcUsername() {
        return (String) getAttributeInternal(UCUSERNAME);
    }

    /**
     * Sets <code>value</code> as attribute value for UC_USERNAME using the alias name UcUsername.
     * @param value value to set the UC_USERNAME
     */
    public void setUcUsername(String value) {
        setAttributeInternal(UCUSERNAME, value);
    }

    /**
     * Gets the attribute value for UC_PASSWORD using the alias name UcPassword.
     * @return the UC_PASSWORD
     */
    public String getUcPassword() {
        return (String) getAttributeInternal(UCPASSWORD);
    }

    /**
     * Sets <code>value</code> as attribute value for UC_PASSWORD using the alias name UcPassword.
     * @param value value to set the UC_PASSWORD
     */
    public void setUcPassword(String value) {
        setAttributeInternal(UCPASSWORD, value);
    }

    /**
     * Gets the attribute value for UC_URL using the alias name UcUrl.
     * @return the UC_URL
     */
    public String getUcUrl() {
        return (String) getAttributeInternal(UCURL);
    }

    /**
     * Sets <code>value</code> as attribute value for UC_URL using the alias name UcUrl.
     * @param value value to set the UC_URL
     */
    public void setUcUrl(String value) {
        setAttributeInternal(UCURL, value);
    }

    /**
     * Gets the attribute value for UC_PORTNO using the alias name UcPortno.
     * @return the UC_PORTNO
     */
    public String getUcPortno() {
        return (String) getAttributeInternal(UCPORTNO);
    }

    /**
     * Sets <code>value</code> as attribute value for UC_PORTNO using the alias name UcPortno.
     * @param value value to set the UC_PORTNO
     */
    public void setUcPortno(String value) {
        setAttributeInternal(UCPORTNO, value);
    }

    /**
     * Gets the attribute value for ORG_URL using the alias name OrgUrl.
     * @return the ORG_URL
     */
    public String getOrgUrl() {
        return (String) getAttributeInternal(ORGURL);
    }

    /**
     * Sets <code>value</code> as attribute value for ORG_URL using the alias name OrgUrl.
     * @param value value to set the ORG_URL
     */
    public void setOrgUrl(String value) {
        setAttributeInternal(ORGURL, value);
    }

    /**
     * Gets the attribute value for REPLACE_URL using the alias name ReplaceUrl.
     * @return the REPLACE_URL
     */
    public String getReplaceUrl() {
        return (String) getAttributeInternal(REPLACEURL);
    }

    /**
     * Sets <code>value</code> as attribute value for REPLACE_URL using the alias name ReplaceUrl.
     * @param value value to set the REPLACE_URL
     */
    public void setReplaceUrl(String value) {
        setAttributeInternal(REPLACEURL, value);
    }

    /**
     * getAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param attrDef the attribute

     * @return the attribute value
     * @throws Exception
     */
    protected Object getAttrInvokeAccessor(int index,
                                           AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            return AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].get(this);
        }
        return super.getAttrInvokeAccessor(index, attrDef);
    }

    /**
     * setAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param value the value to assign to the attribute
     * @param attrDef the attribute

     * @throws Exception
     */
    protected void setAttrInvokeAccessor(int index, Object value,
                                         AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].put(this, value);
            return;
        }
        super.setAttrInvokeAccessor(index, value, attrDef);
    }
}
