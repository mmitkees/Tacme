
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
 *         &lt;element name="PurchaseId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SecureHash" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "purchaseId",
    "secureHash"
})
@XmlRootElement(name = "CancelPayment")
public class CancelPayment {

    @XmlElementRef(name = "PurchaseId", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<String> purchaseId;
    @XmlElementRef(name = "SecureHash", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<String> secureHash;

    /**
     * Gets the value of the purchaseId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPurchaseId() {
        return purchaseId;
    }

    /**
     * Sets the value of the purchaseId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPurchaseId(JAXBElement<String> value) {
        this.purchaseId = value;
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

}
