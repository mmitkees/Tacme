package com.tacme.pmr.beans;

import java.io.Serializable;

import java.util.Date;

import javax.swing.JPanel;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementRef;

public class PaymentStatusResponse implements Serializable {


    public PaymentStatusResponse() {
    }
    private String status;
    private String statusMsg;
    private int amount;
    private int collectionCenterFees;

    private String eServiceData;
    private String invoiceID;
    private String pun;
    private String secureHash;
    private Date transactionResponseDate;
    private int edirhamFees;

    public PaymentStatusResponse(String status, String statusMsg, int amount,
                                 int collectionCenterFees, int eDirhamFees,
                                 String eServiceData, String invoiceID,
                                 String pun, String secureHash,
                                 Date transactionResponseDate) {
        super();
        this.status = status;
        this.statusMsg = statusMsg;
        this.amount = amount;
        this.collectionCenterFees = collectionCenterFees;
        this.edirhamFees = eDirhamFees;
        this.eServiceData = eServiceData;
        this.invoiceID = invoiceID;
        this.pun = pun;
        this.secureHash = secureHash;
        this.transactionResponseDate = transactionResponseDate;
    }


    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setCollectionCenterFees(int collectionCenterFees) {
        this.collectionCenterFees = collectionCenterFees;
    }

    public int getCollectionCenterFees() {
        return collectionCenterFees;
    }

    public void setEServiceData(String eServiceData) {
        this.eServiceData = eServiceData;
    }

    public String getEServiceData() {
        return eServiceData;
    }

    public void setInvoiceID(String invoiceID) {
        this.invoiceID = invoiceID;
    }

    public String getInvoiceID() {
        return invoiceID;
    }

    public void setPun(String pun) {
        this.pun = pun;
    }

    public String getPun() {
        return pun;
    }

    public void setSecureHash(String secureHash) {
        this.secureHash = secureHash;
    }

    public String getSecureHash() {
        return secureHash;
    }

    public void setTransactionResponseDate(Date transactionResponseDate) {
        this.transactionResponseDate = transactionResponseDate;
    }

    public Date getTransactionResponseDate() {
        return transactionResponseDate;
    }



    public void setEdirhamFees(int edirhamFees) {
        this.edirhamFees = edirhamFees;
    }

    public int getEdirhamFees() {
        return edirhamFees;
    }
}
