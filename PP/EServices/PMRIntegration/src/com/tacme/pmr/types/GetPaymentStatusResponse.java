
package com.tacme.pmr.types;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetPaymentStatusResult" type="{http://schemas.datacontract.org/2004/07/PMRWeb.PaymentRouter}PaymentGetStatusResponse" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getPaymentStatusResult"
})
@XmlRootElement(name = "GetPaymentStatusResponse")
public class GetPaymentStatusResponse {

    @XmlElementRef(name = "GetPaymentStatusResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<PaymentGetStatusResponse> getPaymentStatusResult;

    /**
     * Gets the value of the getPaymentStatusResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PaymentGetStatusResponse }{@code >}
     *     
     */
    public JAXBElement<PaymentGetStatusResponse> getGetPaymentStatusResult() {
        return getPaymentStatusResult;
    }

    /**
     * Sets the value of the getPaymentStatusResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PaymentGetStatusResponse }{@code >}
     *     
     */
    public void setGetPaymentStatusResult(JAXBElement<PaymentGetStatusResponse> value) {
        this.getPaymentStatusResult = value;
    }

}
