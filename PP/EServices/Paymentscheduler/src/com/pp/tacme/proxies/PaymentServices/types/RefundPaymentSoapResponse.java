
package com.pp.tacme.proxies.PaymentServices.types;

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
 *         &lt;element name="RefundPaymentSoapResult" type="{http://schemas.datacontract.org/2004/07/PMRWeb.PaymentRouter}PaymentServiceResponse" minOccurs="0"/>
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
    "refundPaymentSoapResult"
})
@XmlRootElement(name = "RefundPaymentSoapResponse")
public class RefundPaymentSoapResponse {

    @XmlElementRef(name = "RefundPaymentSoapResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<PaymentServiceResponse> refundPaymentSoapResult;

    /**
     * Gets the value of the refundPaymentSoapResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PaymentServiceResponse }{@code >}
     *     
     */
    public JAXBElement<PaymentServiceResponse> getRefundPaymentSoapResult() {
        return refundPaymentSoapResult;
    }

    /**
     * Sets the value of the refundPaymentSoapResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PaymentServiceResponse }{@code >}
     *     
     */
    public void setRefundPaymentSoapResult(JAXBElement<PaymentServiceResponse> value) {
        this.refundPaymentSoapResult = value;
    }

}
