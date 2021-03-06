package com.pp.evts.ae.model.views;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Row;
import oracle.jbo.RowIterator;
import oracle.jbo.ViewObject;
import oracle.jbo.domain.BlobDomain;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;

import oracle.stellent.ridc.IdcClient;
import oracle.stellent.ridc.IdcClientException;
import oracle.stellent.ridc.IdcClientManager;
import oracle.stellent.ridc.IdcContext;
import oracle.stellent.ridc.model.DataBinder;
import oracle.stellent.ridc.protocol.ServiceResponse;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Tue Jan 12 09:56:28 IST 2016
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class EventDetDefViewRowImpl extends ViewRowImpl {
    private String username;
    private String password;
    private String url;
    private IdcClient idcClient;
    private IdcContext userContext;
    private DataBinder binder;
    private String b_orgurl;
    private String b_replaceurl;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        EventId {
            public Object get(EventDetDefViewRowImpl obj) {
                return obj.getEventId();
            }

            public void put(EventDetDefViewRowImpl obj, Object value) {
                obj.setEventId((Number)value);
            }
        },
        EvenDate {
            public Object get(EventDetDefViewRowImpl obj) {
                return obj.getEvenDate();
            }

            public void put(EventDetDefViewRowImpl obj, Object value) {
                obj.setEvenDate((Date)value);
            }
        },
        EventTime {
            public Object get(EventDetDefViewRowImpl obj) {
                return obj.getEventTime();
            }

            public void put(EventDetDefViewRowImpl obj, Object value) {
                obj.setEventTime((String)value);
            }
        },
        EventSubj {
            public Object get(EventDetDefViewRowImpl obj) {
                return obj.getEventSubj();
            }

            public void put(EventDetDefViewRowImpl obj, Object value) {
                obj.setEventSubj((String)value);
            }
        },
        EventDesc {
            public Object get(EventDetDefViewRowImpl obj) {
                return obj.getEventDesc();
            }

            public void put(EventDetDefViewRowImpl obj, Object value) {
                obj.setEventDesc((String)value);
            }
        },
        EventDetails {
            public Object get(EventDetDefViewRowImpl obj) {
                return obj.getEventDetails();
            }

            public void put(EventDetDefViewRowImpl obj, Object value) {
                obj.setEventDetails((String)value);
            }
        },
        EventImg {
            public Object get(EventDetDefViewRowImpl obj) {
                return obj.getEventImg();
            }

            public void put(EventDetDefViewRowImpl obj, Object value) {
                obj.setEventImg((BlobDomain)value);
            }
        },
        EventPath {
            public Object get(EventDetDefViewRowImpl obj) {
                return obj.getEventPath();
            }

            public void put(EventDetDefViewRowImpl obj, Object value) {
                obj.setEventPath((String)value);
            }
        },
        EventUcmId {
            public Object get(EventDetDefViewRowImpl obj) {
                return obj.getEventUcmId();
            }

            public void put(EventDetDefViewRowImpl obj, Object value) {
                obj.setEventUcmId((String)value);
            }
        },
        EventUCMPath {
            public Object get(EventDetDefViewRowImpl obj) {
                return obj.getEventUCMPath();
            }

            public void put(EventDetDefViewRowImpl obj, Object value) {
                obj.setEventUCMPath((String)value);
            }
        },
        EventDetLineView {
            public Object get(EventDetDefViewRowImpl obj) {
                return obj.getEventDetLineView();
            }

            public void put(EventDetDefViewRowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        };
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(EventDetDefViewRowImpl object);

        public abstract void put(EventDetDefViewRowImpl object, Object value);

        public int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        public static final int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return AttributesEnum.firstIndex() +
                AttributesEnum.staticValues().length;
        }

        public static final AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }
    public static final int EVENTID = AttributesEnum.EventId.index();
    public static final int EVENDATE = AttributesEnum.EvenDate.index();
    public static final int EVENTTIME = AttributesEnum.EventTime.index();
    public static final int EVENTSUBJ = AttributesEnum.EventSubj.index();
    public static final int EVENTDESC = AttributesEnum.EventDesc.index();
    public static final int EVENTDETAILS = AttributesEnum.EventDetails.index();
    public static final int EVENTIMG = AttributesEnum.EventImg.index();
    public static final int EVENTPATH = AttributesEnum.EventPath.index();
    public static final int EVENTUCMID = AttributesEnum.EventUcmId.index();
    public static final int EVENTUCMPATH = AttributesEnum.EventUCMPath.index();
    public static final int EVENTDETLINEVIEW =
        AttributesEnum.EventDetLineView.index();

    /**
     * This is the default constructor (do not remove).
     */
    public EventDetDefViewRowImpl() {
//        intiateConnection();
    }

    /**
     * Gets EventDet entity object.
     * @return the EventDet
     */
    public EntityImpl getEventDet() {
        return (EntityImpl)getEntity(0);
    }

    /**
     * Gets the attribute value for EVENT_ID using the alias name EventId.
     * @return the EVENT_ID
     */
    public Number getEventId() {
        return (Number)getAttributeInternal(EVENTID);
    }

    /**
     * Sets <code>value</code> as attribute value for EVENT_ID using the alias name EventId.
     * @param value value to set the EVENT_ID
     */
    public void setEventId(Number value) {
        setAttributeInternal(EVENTID, value);
    }

    /**
     * Gets the attribute value for EVEN_DATE using the alias name EvenDate.
     * @return the EVEN_DATE
     */
    public Date getEvenDate() {
        return (Date)getAttributeInternal(EVENDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for EVEN_DATE using the alias name EvenDate.
     * @param value value to set the EVEN_DATE
     */
    public void setEvenDate(Date value) {
        setAttributeInternal(EVENDATE, value);
    }

    /**
     * Gets the attribute value for EVENT_TIME using the alias name EventTime.
     * @return the EVENT_TIME
     */
    public String getEventTime() {
        return (String)getAttributeInternal(EVENTTIME);
    }

    /**
     * Sets <code>value</code> as attribute value for EVENT_TIME using the alias name EventTime.
     * @param value value to set the EVENT_TIME
     */
    public void setEventTime(String value) {
        setAttributeInternal(EVENTTIME, value);
    }

    /**
     * Gets the attribute value for EVENT_SUBJ using the alias name EventSubj.
     * @return the EVENT_SUBJ
     */
    public String getEventSubj() {
        return (String)getAttributeInternal(EVENTSUBJ);
    }

    /**
     * Sets <code>value</code> as attribute value for EVENT_SUBJ using the alias name EventSubj.
     * @param value value to set the EVENT_SUBJ
     */
    public void setEventSubj(String value) {
        setAttributeInternal(EVENTSUBJ, value);
    }

    /**
     * Gets the attribute value for EVENT_DESC using the alias name EventDesc.
     * @return the EVENT_DESC
     */
    public String getEventDesc() {
        return (String)getAttributeInternal(EVENTDESC);
    }

    /**
     * Sets <code>value</code> as attribute value for EVENT_DESC using the alias name EventDesc.
     * @param value value to set the EVENT_DESC
     */
    public void setEventDesc(String value) {
        setAttributeInternal(EVENTDESC, value);
    }

    /**
     * Gets the attribute value for EVENT_DETAILS using the alias name EventDetails.
     * @return the EVENT_DETAILS
     */
    public String getEventDetails() {
        return (String)getAttributeInternal(EVENTDETAILS);
    }

    /**
     * Sets <code>value</code> as attribute value for EVENT_DETAILS using the alias name EventDetails.
     * @param value value to set the EVENT_DETAILS
     */
    public void setEventDetails(String value) {
        setAttributeInternal(EVENTDETAILS, value);
    }

    /**
     * Gets the attribute value for EVENT_IMG using the alias name EventImg.
     * @return the EVENT_IMG
     */
    public BlobDomain getEventImg() {
        return (BlobDomain)getAttributeInternal(EVENTIMG);
    }

    /**
     * Sets <code>value</code> as attribute value for EVENT_IMG using the alias name EventImg.
     * @param value value to set the EVENT_IMG
     */
    public void setEventImg(BlobDomain value) {
        setAttributeInternal(EVENTIMG, value);
    }

    /**
     * Gets the attribute value for EVENT_PATH using the alias name EventPath.
     * @return the EVENT_PATH
     */
    public String getEventPath() {
        return (String)getAttributeInternal(EVENTPATH);
    }

    /**
     * Sets <code>value</code> as attribute value for EVENT_PATH using the alias name EventPath.
     * @param value value to set the EVENT_PATH
     */
    public void setEventPath(String value) {
        setAttributeInternal(EVENTPATH, value);
    }

    /**
     * Gets the attribute value for EVENT_UCM_ID using the alias name EventUcmId.
     * @return the EVENT_UCM_ID
     */
    public String getEventUcmId() {
        return (String)getAttributeInternal(EVENTUCMID);
    }

    /**
     * Sets <code>value</code> as attribute value for EVENT_UCM_ID using the alias name EventUcmId.
     * @param value value to set the EVENT_UCM_ID
     */
    public void setEventUcmId(String value) {
        setAttributeInternal(EVENTUCMID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute EventUCMPath.
     * @return the EventUCMPath
     */
    public String getEventUCMPath() {
        //        return (String) getAttributeInternal(EVENTUCMPATH);
        intiateConnection();
        String docid = this.getEventUcmId();
        //        String value = this.getURLFromdID(docid);
        String val = this.getURLFromdID(docid);
//        String value =
//            val.replace("PP-App-rep:16200", "demoserver.tacme.net:12127");
        String value =
            val.replace(b_orgurl, b_replaceurl);
        if (value != null) {
            return value;
        } else {
            return (String)getAttributeInternal(EVENTUCMPATH);
        }
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute EventUCMPath.
     * @param value value to set the  EventUCMPath
     */
    public void setEventUCMPath(String value) {
        setAttributeInternal(EVENTUCMPATH, value);
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link EventDetLineView.
     */
    public RowIterator getEventDetLineView() {
        return (RowIterator)getAttributeInternal(EVENTDETLINEVIEW);
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
        if ((index >= AttributesEnum.firstIndex()) &&
            (index < AttributesEnum.count())) {
            return AttributesEnum.staticValues()[index -
                AttributesEnum.firstIndex()].get(this);
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
        if ((index >= AttributesEnum.firstIndex()) &&
            (index < AttributesEnum.count())) {
            AttributesEnum.staticValues()[index -
                AttributesEnum.firstIndex()].put(this, value);
            return;
        }
        super.setAttrInvokeAccessor(index, value, attrDef);
    }

    public void intiateConnection() {
        try {
            ApplicationModule am = this.getApplicationModule();
            ViewObject vo = am.findViewObject("UcmConfigView1");
            vo.setNamedWhereClauseParam("uctype", "E");
            vo.executeQuery();
            if (vo.getEstimatedRowCount() != 0) {
                Row vr = vo.first();
                String un = (String)vr.getAttribute("UcUsername");
                String pwrd = (String)vr.getAttribute("UcPassword");
                String b_url = (String)vr.getAttribute("UcUrl");
                String portno = (String)vr.getAttribute("UcPortno");
                b_orgurl = (String)vr.getAttribute("OrgUrl");
                    b_replaceurl = (String)vr.getAttribute("ReplaceUrl");
                username = un;
                password = pwrd;
                url = b_url + ":" + portno;
                //            this.username = "weblogic";
                //            this.password = "weblogic1";
                //            this.url = "idc://192.168.3.113:4444";
                IdcClientManager manager = new IdcClientManager();
                this.idcClient = manager.createClient(this.url);
                this.userContext =
                        new IdcContext(this.username, this.password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public String getURLFromdID(String dID) {
        this.binder = this.idcClient.createBinder();
        try {
            this.binder.putLocal("IdcService", "DOC_INFO");
            this.binder.putLocal("dID", dID);
            ServiceResponse response =
                idcClient.sendRequest(this.userContext, this.binder);
            DataBinder respBinder = response.getResponseAsBinder();
            if (respBinder != null)
                return respBinder.getLocal("DocUrl");
        } catch (IdcClientException ice) {
            ice.printStackTrace();
        }
        return null;
    }
}
