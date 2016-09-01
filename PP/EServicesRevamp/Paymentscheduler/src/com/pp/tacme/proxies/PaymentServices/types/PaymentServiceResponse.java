
package com.pp.tacme.proxies.PaymentServices.types;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PaymentServiceResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentServiceResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ConfirmationID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StatusMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentServiceResponse", namespace = "http://schemas.datacontract.org/2004/07/PMRWeb.PaymentRouter", propOrder = {
    "confirmationID",
    "status",
    "statusMessage"
})
@XmlSeeAlso({
    PaymentGetStatusResponse.class
})
public class PaymentServiceResponse {

    @XmlElementRef(name = "ConfirmationID", namespace = "http://schemas.datacontract.org/2004/07/PMRWeb.PaymentRouter", type = JAXBElement.class)
    protected JAXBElement<String> confirmationID;
    @XmlElementRef(name = "Status", namespace = "http://schemas.datacontract.org/2004/07/PMRWeb.PaymentRouter", type = JAXBElement.class)
    protected JAXBElement<String> status;
    @XmlElementRef(name = "StatusMessage", namespace = "http://schemas.datacontract.org/2004/07/PMRWeb.PaymentRouter", type = JAXBElement.class)
    protected JAXBElement<String> statusMessage;

    /**
     * Gets the value of the confirmationID property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getConfirmationID() {
        return confirmationID;
    }

    /**
     * Sets the value of the confirmationID property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setConfirmationID(JAXBElement<String> value) {
        this.confirmationID = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStatus(JAXBElement<String> value) {
        this.status = value;
    }

    /**
     * Gets the value of the statusMessage property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStatusMessage() {
        return statusMessage;
    }

    /**
     * Sets the value of the statusMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStatusMessage(JAXBElement<String> value) {
        this.statusMessage = value;
    }

}
