package com.app.view.beans;

import com.app.model.services.PPAppServicesImpl;
import com.app.view.utils.ADFUtils;

import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;

import java.math.BigDecimal;

import java.security.InvalidKeyException;

import java.security.NoSuchAlgorithmException;

import java.util.ArrayList;
import java.util.List;

import java.util.Locale;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;

import oracle.adf.model.OperationBinding;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Row;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;
import oracle.jbo.domain.Number;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

public class epay implements Serializable {
    @SuppressWarnings("compatibility:-9033566110618326317")
    private static final long serialVersionUID = 1L;
    private String lang;
    private String tbInvoiceID;
    private String returnUrl;
    private String serviceCode;
    private String secretKey;
    private String serviceKey;
    private String responseUrl =
        "http://185.54.19.181/makeen/PaymentConfirmation.aspx?InvoiceNo=2469&Response.Status=0000&Response.StatusMessage=Transaction%20was%20processed%20successfully.&Response.ConfirmationID=160000032259&Response.TransactionResponseDate=14022016131350&Response.CollectionCenterFees=000&Response.EDirhamFees=300&Response.ServiceFees=1000";
    private List transStatus = new ArrayList();
    private String invoiceNo;
    private String transMessage;
    private String pmrredurl;
    private ADFUtils adfUtils = new ADFUtils();

    public epay() {
    }

    public void setServiceKey() {
        ViewObject reqStatusView =
            getAm().findViewObject("ReqRequestsStatusView1");
        //        if (reqStatusView != null){
        Row reqStatusRow = reqStatusView.getCurrentRow();
        if (reqStatusRow != null) {
            Number servicekeyNum =
                (Number)reqStatusRow.getAttribute("ServiceId");
            serviceKey = servicekeyNum.toString();
        }
        //        }
    }

    public PPAppServicesImpl getAm() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Application app = fc.getApplication();
        ExpressionFactory elFactory = app.getExpressionFactory();
        ELContext elContext = fc.getELContext();
        ValueExpression valueExp =
            elFactory.createValueExpression(elContext, "#{data.PPAppServicesDataControl.dataProvider}",
                                            Object.class);
        return (PPAppServicesImpl)valueExp.getValue(elContext);
    }

    public String paymentURL() { //post
        String ret = "N";
        String qty = "1";
        try {
            //            Locale loc =
            //                (Locale)adfUtils.evaluateEL("#{pageFlowScope.locale}");
            //            lang = loc.toString();
            lang = "en";
            String status = "Request sent";
            returnUrl =
                    (String)adfUtils.evaluateEL("#{pageFlowScope.returnUrl}");
            //            serviceCode =
            //                    (String)adfUtils.evaluateEL("#{pageFlowScope.serviceCode}");
            secretKey =
                    (String)adfUtils.evaluateEL("#{pageFlowScope.SecetKey}");
            setServiceKey();
            System.err.println("<-----------------Service key------------->" +
                               serviceKey);
            //            Number sernum =
            //                (Number)adfUtils.evaluateEL("#{pageFlowScope.key}");
            //            serviceKey = sernum.toString();
            //            serviceKey = (String)adfUtils.evaluateEL("#{pageFlowScope.key}");
            //            serviceKey = sid;
            pmrredurl =
                    (String)adfUtils.evaluateEL("#{pageFlowScope.pmrredurl}");
            serviceCode = getCode();
            System.out.println("====================Payment======================");
            System.out.println("service code is ----->" + serviceCode);
            serviceCode = "000000-0001";
            ViewObject transStatusView =
                adfUtils.getApplicationModuleForDataControl("PPAppServicesDataControl").findViewObject("TransactionDetailsView1");
            ViewObject reqStatusView =
                adfUtils.getApplicationModuleForDataControl("PPAppServicesDataControl").findViewObject("ReqRequestsStatusView1");
            Row transStatusrow = transStatusView.createRow();
            Row reqStatusrow = reqStatusView.getCurrentRow();
            qty = getQuantity();
            System.out.println("quantity  is ----->" + qty);
            System.out.println("=================================================");
            updateStatus();
            BigDecimal reqId =
                new BigDecimal(reqStatusrow.getAttribute("ReqId").toString());
            transStatusrow.setAttribute("ServiceKey", serviceKey);
            transStatusrow.setAttribute("ReqId", reqId);
            tbInvoiceID = (String)transStatusrow.getAttribute("InvoiceId");
            StringBuilder PMRRedirectURL = new StringBuilder(pmrredurl);
            PMRRedirectURL.append("description=" + "eServices");
            PMRRedirectURL.append("&id=" + tbInvoiceID);
            PMRRedirectURL.append("&languageCode=" + lang);
            PMRRedirectURL.append("&paymentType=" + "pay-web");
            PMRRedirectURL.append("&price=" + "0");
            PMRRedirectURL.append("&quantity=" + qty);
            PMRRedirectURL.append("&returnUrl=" + returnUrl);
            PMRRedirectURL.append("&serviceCode=" + serviceCode);
            StringBuilder fields = new StringBuilder(secretKey);
            fields.append("eServices");
            fields.append(tbInvoiceID);
            fields.append(lang);
            fields.append("pay-web");
            fields.append("0");
            fields.append(qty);
            fields.append(returnUrl);
            fields.append(serviceCode);
            System.out.println("_________________________________ " +
                               Base64.class.getProtectionDomain().getCodeSource().getLocation() +
                               "______________________________");
            String SecureHash =
                hmacDigest(fields.toString(), secretKey, "HmacSHA256");
            System.out.println("Generated hash key is :: " + SecureHash);
            PMRRedirectURL.append("&secureHash=" + SecureHash);
            //                    Response.Redirect(PMRRedirectURL.toString());

            this.commit();
            FacesContext fc = FacesContext.getCurrentInstance();
            String callbackUrl = PMRRedirectURL.toString();
            System.out.println("URL for the redirect URL :: " + callbackUrl);
              fc.getExternalContext().redirect(callbackUrl);
            ret = "commit";
        }

        catch (Exception ex) {
            ex.printStackTrace();
        }
        return ret;
    }

    public String getQuantity() {
        String qty = "1";
        ViewObject reqStatusView =
            adfUtils.getApplicationModuleForDataControl("PPAppServicesDataControl").findViewObject("ReqRequestsStatusView1");
        ViewObject qtyCasecopyView =
            adfUtils.getApplicationModuleForDataControl("PPAppServicesDataControl").findViewObject("qtyCaseCopy1");
        Row reqStatusRow = reqStatusView.getCurrentRow();

        if (reqStatusRow != null) {
            Number sid = (Number)reqStatusRow.getAttribute("ServiceId");
            Number rid = (Number)reqStatusRow.getAttribute("ReqId");
            if (sid.equals("6")) {
                qtyCasecopyView.setNamedWhereClauseParam("preq_id", rid);
                qtyCasecopyView.executeQuery();
                if (qtyCasecopyView.getEstimatedRowCount() != 0) {
                    Row qtyCasecopyRow = qtyCasecopyView.first();
                    BigDecimal qtybigD =
                        (BigDecimal)qtyCasecopyRow.getAttribute("Qty");
                    if (qtybigD == null)
                        qty = "1";
                    else
                    qty = qtybigD.toString();
                }
            }

        }
        return qty;
    }

    public String getCode() {
        String code = null;
        ViewObject copyJudgmentView =
            adfUtils.getApplicationModuleForDataControl("PPAppServicesDataControl").findViewObject("ReqCopyJudgeView1");
        ViewObject reqStatusView =
            adfUtils.getApplicationModuleForDataControl("PPAppServicesDataControl").findViewObject("ReqRequestsStatusView1");
        ViewObject edhirahmView =
            adfUtils.getApplicationModuleForDataControl("PPAppServicesDataControl").findViewObject("EdhirahmCodeView1");
        Row reqStatusRow = reqStatusView.getCurrentRow();
        if (reqStatusRow != null) {
            Number rid = (Number)reqStatusRow.getAttribute("ReqId");
            Number sid = (Number)reqStatusRow.getAttribute("ServiceId");
            if (sid.equals(1)) {
                // copyJudgmentView.setNamedWhereClauseParam("ReqId", rid);

                ViewCriteria vc = copyJudgmentView.createViewCriteria();
                ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
                vcRow.setAttribute("ReqId", rid);
                vc.addRow(vcRow);
                copyJudgmentView.applyViewCriteria(vc);
                copyJudgmentView.executeQuery();

                int uniqueid = 0;
                if (copyJudgmentView.getAllRowsInRange().length != 0) {

                    if (copyJudgmentView.getAllRowsInRange().length == 1) {
                        uniqueid = 1;
                    }
                } else {
                    uniqueid = 2;
                }
                
  
              edhirahmView.setNamedWhereClauseParam("puid", uniqueid);
              edhirahmView.executeQuery();
              Row edhirahmRow = edhirahmView.next();
            code = (String)edhirahmRow.getAttribute("ServiceCode");
                
            }
        
        if (sid.equals("4")) {
            edhirahmView.setNamedWhereClauseParam("puid", 3);
            edhirahmView.executeQuery();
            Row edhirahmRow = edhirahmView.next();
            code = (String)edhirahmRow.getAttribute("ServiceCode");
        }
        if (sid.equals("6")) {
            edhirahmView.setNamedWhereClauseParam("puid", 6);
            edhirahmView.executeQuery();
            Row edhirahmRow = edhirahmView.next();
            code = (String)edhirahmRow.getAttribute("ServiceCode");
        }
        if (sid.equals("7")) {
            edhirahmView.setNamedWhereClauseParam("puid", 4);
            edhirahmView.executeQuery();
            Row edhirahmRow = edhirahmView.next();
            code = (String)edhirahmRow.getAttribute("ServiceCode");
        }
        if (sid.equals("8")) {
            edhirahmView.setNamedWhereClauseParam("puid", 5);
            edhirahmView.executeQuery();
                Row edhirahmRow = edhirahmView.next();
                code = (String)edhirahmRow.getAttribute("ServiceCode");
        }
    }
    
        return code;
    }

    /**
     *  Updating the status before redirect
     *  Created by - Prasad K T
     *  Created on - 28/05/2016
     */

    public void updateStatus() {
        ViewObject reqStatusView =
            adfUtils.getApplicationModuleForDataControl("PPAppServicesDataControl").findViewObject("ReqRequestsStatusView1");
        Row reqStatusRow = reqStatusView.getCurrentRow();
        if (reqStatusRow != null) {
            reqStatusRow.setAttribute("Status", "Under Payment Process");
        }
    }

    public String saveResponseStatus() {
        String ret = "notsave";
        ADFUtils adfutils = new ADFUtils();
        invoiceNo = (String)adfutils.evaluateEL("#{pageFlowScope.invoiceNo}");
        transMessage =
                (String)adfutils.evaluateEL("#{pageFlowScope.statusMessage}");
        ViewObject transDetailsView =
            adfutils.getApplicationModuleForDataControl("PPAppServicesDataControl").findViewObject("TransactionDetailsView1");
        String whereclause = "INVOICE_ID = " + invoiceNo;
        transDetailsView.setWhereClause(whereclause);
        transDetailsView.executeQuery();
        if (transDetailsView.getEstimatedRowCount() != 0) {
            Row transDetailsrow = transDetailsView.first();
            transDetailsrow.setAttribute("TransactionStatus", transMessage);
            ret = "navig";
        }
        return ret;
    }

    /**
     * Generating the hmac alogirthm for SHA 256
     * Created by - Prasad K T
     * Created on - 21/02/2016
     * @param msg
     * @param keyString
     * @param algo
     * @return
     */

    public static String hmacDigest(String msg, String keyString,
                                    String algo) {

        String result = "";

        try {

            String HMAC_SHA256_ALGORITHM = "HmacSHA256";
            // Get an HMAC SHA256 key from the raw key bytes
            SecretKeySpec signingKey =
                new SecretKeySpec(keyString.getBytes(), HMAC_SHA256_ALGORITHM);
            // Get an HMAC SHA256 Mac instance and initialize with the signing
            // key
            Mac mac = Mac.getInstance(HMAC_SHA256_ALGORITHM);
            mac.init(signingKey);
            // Compute the HMAC on input data bytes
            byte[] rawHmac = mac.doFinal(msg.getBytes());
            // Convert to hexadecimal
            //                                                result = Hex.encodeHexString(rawHmac);
            char[] resultc = Hex.encodeHex(rawHmac);
            result = new String(resultc);
            // Base64-encode the HMAC
            result = new String(Base64.encodeBase64(result.getBytes()));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }


        System.out.println(result);
        return result;

    }


    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getLang() {
        return lang;
    }

    public void setTbInvoiceID(String tbInvoiceID) {
        this.tbInvoiceID = tbInvoiceID;
    }

    public String getTbInvoiceID() {
        return tbInvoiceID;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setServiceKey(String serviceKey) {
        this.serviceKey = serviceKey;
    }

    public String getServiceKey() {
        return serviceKey;
    }

    public void setResponseUrl(String responseUrl) {
        this.responseUrl = responseUrl;
    }

    public String getResponseUrl() {
        return responseUrl;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setTransMessage(String transMessage) {
        this.transMessage = transMessage;
    }

    public String getTransMessage() {
        return transMessage;
    }

    public void setPmrredurl(String pmrredurl) {
        this.pmrredurl = pmrredurl;
    }

    public String getPmrredurl() {
        return pmrredurl;
    }


    public String commit() {
        ADFUtils adfUtils = new ADFUtils();
        OperationBinding commitOperation =
            (OperationBinding)adfUtils.findOperation("Commit");
        commitOperation.execute();
        return null;
    }

    public static void main(String[] args) {
        //        epay ep = new epay();
        //        ep.hmacDigest("8a27a3c7785c8071c0208b52594501c8PP gov service payment83913enpay-web01http://localhost/PMR.IA/PaymentRouter/PaymentReview.aspx?000000-001", "8a27a3c7785c8071c0208b52594501c8", "HMACSHA256");
    }
}
