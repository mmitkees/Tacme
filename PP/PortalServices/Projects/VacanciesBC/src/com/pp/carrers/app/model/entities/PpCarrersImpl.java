package com.pp.carrers.app.model.entities;

import oracle.jbo.AttributeList;
import oracle.jbo.Key;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.SequenceImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Jan 04 11:58:55 IST 2016
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class PpCarrersImpl extends EntityImpl {
    private static EntityDefImpl mDefinitionObject;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        PositionId {
            public Object get(PpCarrersImpl obj) {
                return obj.getPositionId();
            }

            public void put(PpCarrersImpl obj, Object value) {
                obj.setPositionId((String)value);
            }
        }
        ,
        Status {
            public Object get(PpCarrersImpl obj) {
                return obj.getStatus();
            }

            public void put(PpCarrersImpl obj, Object value) {
                obj.setStatus((String)value);
            }
        }
        ,
        CreateDate {
            public Object get(PpCarrersImpl obj) {
                return obj.getCreateDate();
            }

            public void put(PpCarrersImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        CloseDate {
            public Object get(PpCarrersImpl obj) {
                return obj.getCloseDate();
            }

            public void put(PpCarrersImpl obj, Object value) {
                obj.setCloseDate((Date)value);
            }
        }
        ,
        JobTitle {
            public Object get(PpCarrersImpl obj) {
                return obj.getJobTitle();
            }

            public void put(PpCarrersImpl obj, Object value) {
                obj.setJobTitle((String)value);
            }
        }
        ,
        JobResp {
            public Object get(PpCarrersImpl obj) {
                return obj.getJobResp();
            }

            public void put(PpCarrersImpl obj, Object value) {
                obj.setJobResp((String)value);
            }
        }
        ,
        JobReq {
            public Object get(PpCarrersImpl obj) {
                return obj.getJobReq();
            }

            public void put(PpCarrersImpl obj, Object value) {
                obj.setJobReq((String)value);
            }
        }
        ,
        CarrersUcmId {
            public Object get(PpCarrersImpl obj) {
                return obj.getCarrersUcmId();
            }

            public void put(PpCarrersImpl obj, Object value) {
                obj.setCarrersUcmId((String)value);
            }
        }
        ,
        Lang {
            public Object get(PpCarrersImpl obj) {
                return obj.getLang();
            }

            public void put(PpCarrersImpl obj, Object value) {
                obj.setLang((String)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(PpCarrersImpl object);

        public abstract void put(PpCarrersImpl object, Object value);

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


    public static final int POSITIONID = AttributesEnum.PositionId.index();
    public static final int STATUS = AttributesEnum.Status.index();
    public static final int CREATEDATE = AttributesEnum.CreateDate.index();
    public static final int CLOSEDATE = AttributesEnum.CloseDate.index();
    public static final int JOBTITLE = AttributesEnum.JobTitle.index();
    public static final int JOBRESP = AttributesEnum.JobResp.index();
    public static final int JOBREQ = AttributesEnum.JobReq.index();
    public static final int CARRERSUCMID = AttributesEnum.CarrersUcmId.index();
    public static final int LANG = AttributesEnum.Lang.index();

    /**
     * This is the default constructor (do not remove).
     */
    public PpCarrersImpl() {
    }


    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = EntityDefImpl.findDefObject("com.pp.carrers.app.model.entities.PpCarrers");
        }
        return mDefinitionObject;
    }

    /**
     * Gets the attribute value for PositionId, using the alias name PositionId.
     * @return the PositionId
     */
    public String getPositionId() {
        return (String)getAttributeInternal(POSITIONID);
    }

    /**
     * Sets <code>value</code> as the attribute value for PositionId.
     * @param value value to set the PositionId
     */
    public void setPositionId(String value) {
        setAttributeInternal(POSITIONID, value);
    }

    /**
     * Gets the attribute value for Status, using the alias name Status.
     * @return the Status
     */
    public String getStatus() {
        return (String)getAttributeInternal(STATUS);
    }

    /**
     * Sets <code>value</code> as the attribute value for Status.
     * @param value value to set the Status
     */
    public void setStatus(String value) {
        setAttributeInternal(STATUS, value);
    }

    /**
     * Gets the attribute value for CreateDate, using the alias name CreateDate.
     * @return the CreateDate
     */
    public Date getCreateDate() {
        return (Date)getAttributeInternal(CREATEDATE);
    }

    /**
     * Gets the attribute value for CloseDate, using the alias name CloseDate.
     * @return the CloseDate
     */
    public Date getCloseDate() {
        return (Date)getAttributeInternal(CLOSEDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for CloseDate.
     * @param value value to set the CloseDate
     */
    public void setCloseDate(Date value) {
        setAttributeInternal(CLOSEDATE, value);
    }

    /**
     * Gets the attribute value for JobTitle, using the alias name JobTitle.
     * @return the JobTitle
     */
    public String getJobTitle() {
        return (String)getAttributeInternal(JOBTITLE);
    }

    /**
     * Sets <code>value</code> as the attribute value for JobTitle.
     * @param value value to set the JobTitle
     */
    public void setJobTitle(String value) {
        setAttributeInternal(JOBTITLE, value);
    }

    /**
     * Gets the attribute value for JobResp, using the alias name JobResp.
     * @return the JobResp
     */
    public String getJobResp() {
        return (String)getAttributeInternal(JOBRESP);
    }

    /**
     * Sets <code>value</code> as the attribute value for JobResp.
     * @param value value to set the JobResp
     */
    public void setJobResp(String value) {
        setAttributeInternal(JOBRESP, value);
    }

    /**
     * Gets the attribute value for JobReq, using the alias name JobReq.
     * @return the JobReq
     */
    public String getJobReq() {
        return (String)getAttributeInternal(JOBREQ);
    }

    /**
     * Sets <code>value</code> as the attribute value for JobReq.
     * @param value value to set the JobReq
     */
    public void setJobReq(String value) {
        setAttributeInternal(JOBREQ, value);
    }

    /**
     * Gets the attribute value for CarrersUcmId, using the alias name CarrersUcmId.
     * @return the CarrersUcmId
     */
    public String getCarrersUcmId() {
        return (String)getAttributeInternal(CARRERSUCMID);
    }

    /**
     * Sets <code>value</code> as the attribute value for CarrersUcmId.
     * @param value value to set the CarrersUcmId
     */
    public void setCarrersUcmId(String value) {
        setAttributeInternal(CARRERSUCMID, value);
    }

//    /**
//     * Gets the attribute value for Seq_value, using the alias name Seq_value.
//     * @return the Seq_value
//     */
//    public String getSeq_value() {
//        return (String)getAttributeInternal(SEQ_VALUE);
//    }
//
//    /**
//     * Sets <code>value</code> as the attribute value for Seq_value.
//     * @param value value to set the Seq_value
//     */
//    public void setSeq_value(String value) {
//        setAttributeInternal(SEQ_VALUE, value);
//    }

    /**
     * Gets the attribute value for Lang, using the alias name Lang.
     * @return the Lang
     */
    public String getLang() {
        return (String)getAttributeInternal(LANG);
    }

    /**
     * Sets <code>value</code> as the attribute value for Lang.
     * @param value value to set the Lang
     */
    public void setLang(String value) {
        setAttributeInternal(LANG, value);
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
     * @param positionId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(String positionId) {
        return new Key(new Object[]{positionId});
    }

    /**
     *  Generate the sequence number
     */
    public Number getSequenceNumber(String seqname){
        Number seqval = new Number(0);
        if (seqname != null && !seqname.equals("")){
            SequenceImpl seqimpl = new SequenceImpl (seqname,getDBTransaction());
            seqval = seqimpl.getSequenceNumber();
        }
        return seqval;
    }

    /**
     * Add attribute defaulting logic in this method.
     * @param attributeList list of attribute names/values to initialize the row
     */
    protected void create(AttributeList attributeList) {        
        super.create(attributeList);
        Number val = getSequenceNumber("CARRERS_SEQ");
        String pos = "PPJOB";
        String fin = pos+val;
        this.setPositionId(fin);
    }
}