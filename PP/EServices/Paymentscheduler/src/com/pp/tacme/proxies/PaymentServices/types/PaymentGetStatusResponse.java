
package com.pp.tacme.proxies.PaymentServices.types;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PaymentGetStatusResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentGetStatusResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/PMRWeb.PaymentRouter}PaymentServiceResponse">
 *       &lt;sequence>
 *         &lt;element name="Amount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CollectionCenterFees" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EDirhamFees" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EServiceData" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InvoiceID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PUN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SecureHash" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TransactionResponseDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentGetStatusResponse", namespace = "http://schemas.datacontract.org/2004/07/PMRWeb.PaymentRouter", propOrder = {
    "amount",
    "collectionCenterFees",
    "eDirhamFees",
    "eServiceData",
    "invoiceID",
    "pun",
    "secureHash",
    "transactionResponseDate"
})
public class PaymentGetStatusResponse
    extends PaymentServiceResponse
{

    @XmlElementRef(name = "Amount", namespace = "http://schemas.datacontract.org/2004/07/PMRWeb.PaymentRouter", type = JAXBElement.class)
    protected JAXBElement<String> amount;
    @XmlElementRef(name = "CollectionCenterFees", namespace = "http://schemas.datacontract.org/2004/07/PMRWeb.PaymentRouter", type = JAXBElement.class)
    protected JAXBElement<String> collectionCenterFees;
    @XmlElementRef(name = "EDirhamFees", namespace = "http://schemas.datacontract.org/2004/07/PMRWeb.PaymentRouter", type = JAXBElement.class)
    protected JAXBElement<String> eDirhamFees;
    @XmlElementRef(name = "EServiceData", namespace = "http://schemas.datacontract.org/2004/07/PMRWeb.PaymentRouter", type = JAXBElement.class)
    protected JAXBElement<String> eServiceData;
    @XmlElementRef(name = "InvoiceID", namespace = "http://schemas.datacontract.org/2004/07/PMRWeb.PaymentRouter", type = JAXBElement.class)
    protected JAXBElement<String> invoiceID;
    @XmlElementRef(name = "PUN", namespace = "http://schemas.datacontract.org/2004/07/PMRWeb.PaymentRouter", type = JAXBElement.class)
    protected JAXBElement<String> pun;
    @XmlElementRef(name = "SecureHash", namespace = "http://schemas.datacontract.org/2004/07/PMRWeb.PaymentRouter", type = JAXBElement.class)
    protected JAXBElement<String> secureHash;
    @XmlElementRef(name = "TransactionResponseDate", namespace = "http://schemas.datacontract.org/2004/07/PMRWeb.PaymentRouter", type = JAXBElement.class)
    protected JAXBElement<String> transactionResponseDate;

    /**
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAmount(JAXBElement<String> value) {
        this.amount = value;
    }

    /**
     * Gets the value of the collectionCenterFees property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCollectionCenterFees() {
        return collectionCenterFees;
    }

    /**
     * Sets the value of the collectionCenterFees property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCollectionCenterFees(JAXBElement<String> value) {
        this.collectionCenterFees = value;
    }

    /**
     * Gets the value of the eDirhamFees property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEDirhamFees() {
        return eDirhamFees;
    }

    /**
     * Sets the value of the eDirhamFees property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEDirhamFees(JAXBElement<String> value) {
        this.eDirhamFees = value;
    }

    /**
     * Gets the value of the eServiceData property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEServiceData() {
        return eServiceData;
    }

    /**
     * Sets the value of the eServiceData property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEServiceData(JAXBElement<String> value) {
        this.eServiceData = value;
    }

    /**
     * Gets the value of the invoiceID property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInvoiceID() {
        return invoiceID;
    }

    /**
     * Sets the value of the invoiceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInvoiceID(JAXBElement<String> value) {
        this.invoiceID = value;
    }

    /**
     * Gets the value of the pun property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPUN() {
        return pun;
    }

    /**
     * Sets the value of the pun property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPUN(JAXBElement<String> value) {
        this.pun = value;
    }

    /**
     * Gets the value of the secureHash property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSecureHash() {
        return secureHash;
    }

    /**
     * Sets the value of the secureHash property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSecureHash(JAXBElement<String> value) {
        this.secureHash = value;
    }

    /**
     * Gets the value of the transactionResponseDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTransactionResponseDate() {
        return transactionResponseDate;
    }

    /**
     * Sets the value of the transactionResponseDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTransactionResponseDate(JAXBElement<String> value) {
        this.transactionResponseDate = value;
    }

}
