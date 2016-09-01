
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
 *         &lt;element name="VoidPaymentSoapResult" type="{http://schemas.datacontract.org/2004/07/PMRWeb.PaymentRouter}PaymentServiceResponse" minOccurs="0"/>
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
    "voidPaymentSoapResult"
})
@XmlRootElement(name = "VoidPaymentSoapResponse")
public class VoidPaymentSoapResponse {

    @XmlElementRef(name = "VoidPaymentSoapResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<PaymentServiceResponse> voidPaymentSoapResult;

    /**
     * Gets the value of the voidPaymentSoapResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PaymentServiceResponse }{@code >}
     *     
     */
    public JAXBElement<PaymentServiceResponse> getVoidPaymentSoapResult() {
        return voidPaymentSoapResult;
    }

    /**
     * Sets the value of the voidPaymentSoapResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PaymentServiceResponse }{@code >}
     *     
     */
    public void setVoidPaymentSoapResult(JAXBElement<PaymentServiceResponse> value) {
        this.voidPaymentSoapResult = value;
    }

}
