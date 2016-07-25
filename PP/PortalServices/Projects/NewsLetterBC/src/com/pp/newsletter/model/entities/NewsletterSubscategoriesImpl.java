package com.pp.newsletter.model.entities;

import oracle.jbo.AttributeList;
import oracle.jbo.Key;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.SequenceImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Mar 31 16:30:51 IST 2016
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class NewsletterSubscategoriesImpl extends EntityImpl {
    private static EntityDefImpl mDefinitionObject;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        NsId {
            public Object get(NewsletterSubscategoriesImpl obj) {
                return obj.getNsId();
            }

            public void put(NewsletterSubscategoriesImpl obj, Object value) {
                obj.setNsId((Number)value);
            }
        }
        ,
        NsCategid {
            public Object get(NewsletterSubscategoriesImpl obj) {
                return obj.getNsCategid();
            }

            public void put(NewsletterSubscategoriesImpl obj, Object value) {
                obj.setNsCategid((Number)value);
            }
        }
        ,
        NsCategories {
            public Object get(NewsletterSubscategoriesImpl obj) {
                return obj.getNsCategories();
            }

            public void put(NewsletterSubscategoriesImpl obj, Object value) {
                obj.setNsCategories((String)value);
            }
        }
        ,
        NsSelect {
            public Object get(NewsletterSubscategoriesImpl obj) {
                return obj.getNsSelect();
            }

            public void put(NewsletterSubscategoriesImpl obj, Object value) {
                obj.setNsSelect((String)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(NewsletterSubscategoriesImpl object);

        public abstract void put(NewsletterSubscategoriesImpl object,
                                 Object value);

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
    public static final int NSID = AttributesEnum.NsId.index();
    public static final int NSCATEGID = AttributesEnum.NsCategid.index();
    public static final int NSCATEGORIES = AttributesEnum.NsCategories.index();
    public static final int NSSELECT = AttributesEnum.NsSelect.index();

    /**
     * This is the default constructor (do not remove).
     */
    public NewsletterSubscategoriesImpl() {
    }

    /**
     * Gets the attribute value for NsId, using the alias name NsId.
     * @return the NsId
     */
    public Number getNsId() {
        return (Number)getAttributeInternal(NSID);
    }

    /**
     * Sets <code>value</code> as the attribute value for NsId.
     * @param value value to set the NsId
     */
    public void setNsId(Number value) {
        setAttributeInternal(NSID, value);
    }

    /**
     * Gets the attribute value for NsCategid, using the alias name NsCategid.
     * @return the NsCategid
     */
    public Number getNsCategid() {
        return (Number)getAttributeInternal(NSCATEGID);
    }

    /**
     * Sets <code>value</code> as the attribute value for NsCategid.
     * @param value value to set the NsCategid
     */
    public void setNsCategid(Number value) {
        setAttributeInternal(NSCATEGID, value);
    }

    /**
     * Gets the attribute value for NsCategories, using the alias name NsCategories.
     * @return the NsCategories
     */
    public String getNsCategories() {
        return (String)getAttributeInternal(NSCATEGORIES);
    }

    /**
     * Sets <code>value</code> as the attribute value for NsCategories.
     * @param value value to set the NsCategories
     */
    public void setNsCategories(String value) {
        setAttributeInternal(NSCATEGORIES, value);
    }

    /**
     * Gets the attribute value for NsSelect, using the alias name NsSelect.
     * @return the NsSelect
     */
    public String getNsSelect() {
        return (String)getAttributeInternal(NSSELECT);
    }

    /**
     * Sets <code>value</code> as the attribute value for NsSelect.
     * @param value value to set the NsSelect
     */
    public void setNsSelect(String value) {
        setAttributeInternal(NSSELECT, value);
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

    /**
     * @param nsCategid key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(Number nsCategid) {
        return new Key(new Object[]{nsCategid});
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = EntityDefImpl.findDefObject("com.pp.newsletter.model.entities.NewsletterSubscategories");
        }
        return mDefinitionObject;
    }

    /**
     * Add attribute defaulting logic in this method.
     * @param attributeList list of attribute names/values to initialize the row
     */
    protected void create(AttributeList attributeList) {
        super.create(attributeList);
        SequenceImpl seq = new SequenceImpl("categSeq",getDBTransaction());        
        this.setNsCategid(seq.getSequenceNumber());
    }
}
