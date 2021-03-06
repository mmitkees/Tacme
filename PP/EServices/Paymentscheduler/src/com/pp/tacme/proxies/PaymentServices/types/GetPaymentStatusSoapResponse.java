
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
 *         &lt;element name="GetPaymentStatusSoapResult" type="{http://schemas.datacontract.org/2004/07/PMRWeb.PaymentRouter}PaymentGetStatusResponse" minOccurs="0"/>
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
    "getPaymentStatusSoapResult"
})
@XmlRootElement(name = "GetPaymentStatusSoapResponse")
public class GetPaymentStatusSoapResponse {

    @XmlElementRef(name = "GetPaymentStatusSoapResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<PaymentGetStatusResponse> getPaymentStatusSoapResult;

    /**
     * Gets the value of the getPaymentStatusSoapResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PaymentGetStatusResponse }{@code >}
     *     
     */
    public JAXBElement<PaymentGetStatusResponse> getGetPaymentStatusSoapResult() {
        return getPaymentStatusSoapResult;
    }

    /**
     * Sets the value of the getPaymentStatusSoapResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PaymentGetStatusResponse }{@code >}
     *     
     */
    public void setGetPaymentStatusSoapResult(JAXBElement<PaymentGetStatusResponse> value) {
        this.getPaymentStatusSoapResult = value;
    }

}
