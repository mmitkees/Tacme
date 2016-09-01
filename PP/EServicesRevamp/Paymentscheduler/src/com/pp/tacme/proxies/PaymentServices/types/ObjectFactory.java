
package com.pp.tacme.proxies.PaymentServices.types;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.pp.tacme.proxies.PaymentServices.types package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AnyURI_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "anyURI");
    private final static QName _PaymentServiceResponse_QNAME = new QName("http://schemas.datacontract.org/2004/07/PMRWeb.PaymentRouter", "PaymentServiceResponse");
    private final static QName _Char_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "char");
    private final static QName _UnsignedByte_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedByte");
    private final static QName _DateTime_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "dateTime");
    private final static QName _AnyType_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "anyType");
    private final static QName _UnsignedInt_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedInt");
    private final static QName _Int_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "int");
    private final static QName _QName_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "QName");
    private final static QName _UnsignedShort_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedShort");
    private final static QName _Float_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "float");
    private final static QName _Decimal_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "decimal");
    private final static QName _Double_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "double");
    private final static QName _Long_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "long");
    private final static QName _PaymentGetStatusResponse_QNAME = new QName("http://schemas.datacontract.org/2004/07/PMRWeb.PaymentRouter", "PaymentGetStatusResponse");
    private final static QName _Short_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "short");
    private final static QName _Guid_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "guid");
    private final static QName _Base64Binary_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "base64Binary");
    private final static QName _Duration_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "duration");
    private final static QName _Byte_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "byte");
    private final static QName _String_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "string");
    private final static QName _UnsignedLong_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedLong");
    private final static QName _Boolean_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "boolean");
    private final static QName _RefundPaymentSoapPurchaseId_QNAME = new QName("http://tempuri.org/", "PurchaseId");
    private final static QName _RefundPaymentSoapSecureHash_QNAME = new QName("http://tempuri.org/", "SecureHash");
    private final static QName _CancelPaymentSoapResponseCancelPaymentSoapResult_QNAME = new QName("http://tempuri.org/", "CancelPaymentSoapResult");
    private final static QName _PaymentGetStatusResponseEDirhamFees_QNAME = new QName("http://schemas.datacontract.org/2004/07/PMRWeb.PaymentRouter", "EDirhamFees");
    private final static QName _PaymentGetStatusResponseCollectionCenterFees_QNAME = new QName("http://schemas.datacontract.org/2004/07/PMRWeb.PaymentRouter", "CollectionCenterFees");
    private final static QName _PaymentGetStatusResponseSecureHash_QNAME = new QName("http://schemas.datacontract.org/2004/07/PMRWeb.PaymentRouter", "SecureHash");
    private final static QName _PaymentGetStatusResponsePUN_QNAME = new QName("http://schemas.datacontract.org/2004/07/PMRWeb.PaymentRouter", "PUN");
    private final static QName _PaymentGetStatusResponseTransactionResponseDate_QNAME = new QName("http://schemas.datacontract.org/2004/07/PMRWeb.PaymentRouter", "TransactionResponseDate");
    private final static QName _PaymentGetStatusResponseAmount_QNAME = new QName("http://schemas.datacontract.org/2004/07/PMRWeb.PaymentRouter", "Amount");
    private final static QName _PaymentGetStatusResponseEServiceData_QNAME = new QName("http://schemas.datacontract.org/2004/07/PMRWeb.PaymentRouter", "EServiceData");
    private final static QName _PaymentGetStatusResponseInvoiceID_QNAME = new QName("http://schemas.datacontract.org/2004/07/PMRWeb.PaymentRouter", "InvoiceID");
    private final static QName _RefundPaymentResponseRefundPaymentResult_QNAME = new QName("http://tempuri.org/", "RefundPaymentResult");
    private final static QName _CancelPaymentResponseCancelPaymentResult_QNAME = new QName("http://tempuri.org/", "CancelPaymentResult");
    private final static QName _CompletePaymentSoapResponseCompletePaymentSoapResult_QNAME = new QName("http://tempuri.org/", "CompletePaymentSoapResult");
    private final static QName _VoidPaymentSoapResponseVoidPaymentSoapResult_QNAME = new QName("http://tempuri.org/", "VoidPaymentSoapResult");
    private final static QName _CompletePaymentResponseCompletePaymentResult_QNAME = new QName("http://tempuri.org/", "CompletePaymentResult");
    private final static QName _VoidPaymentResponseVoidPaymentResult_QNAME = new QName("http://tempuri.org/", "VoidPaymentResult");
    private final static QName _GetPaymentStatusSoapResponseGetPaymentStatusSoapResult_QNAME = new QName("http://tempuri.org/", "GetPaymentStatusSoapResult");
    private final static QName _GetPaymentStatusResponseGetPaymentStatusResult_QNAME = new QName("http://tempuri.org/", "GetPaymentStatusResult");
    private final static QName _PaymentServiceResponseStatusMessage_QNAME = new QName("http://schemas.datacontract.org/2004/07/PMRWeb.PaymentRouter", "StatusMessage");
    private final static QName _PaymentServiceResponseConfirmationID_QNAME = new QName("http://schemas.datacontract.org/2004/07/PMRWeb.PaymentRouter", "ConfirmationID");
    private final static QName _PaymentServiceResponseStatus_QNAME = new QName("http://schemas.datacontract.org/2004/07/PMRWeb.PaymentRouter", "Status");
    private final static QName _RefundPaymentSoapResponseRefundPaymentSoapResult_QNAME = new QName("http://tempuri.org/", "RefundPaymentSoapResult");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.pp.tacme.proxies.PaymentServices.types
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CompletePaymentSoapResponse }
     * 
     */
    public CompletePaymentSoapResponse createCompletePaymentSoapResponse() {
        return new CompletePaymentSoapResponse();
    }

    /**
     * Create an instance of {@link PaymentServiceResponse }
     * 
     */
    public PaymentServiceResponse createPaymentServiceResponse() {
        return new PaymentServiceResponse();
    }

    /**
     * Create an instance of {@link RefundPaymentResponse }
     * 
     */
    public RefundPaymentResponse createRefundPaymentResponse() {
        return new RefundPaymentResponse();
    }

    /**
     * Create an instance of {@link RefundPayment }
     * 
     */
    public RefundPayment createRefundPayment() {
        return new RefundPayment();
    }

    /**
     * Create an instance of {@link CancelPaymentSoap }
     * 
     */
    public CancelPaymentSoap createCancelPaymentSoap() {
        return new CancelPaymentSoap();
    }

    /**
     * Create an instance of {@link RefundPaymentSoapResponse }
     * 
     */
    public RefundPaymentSoapResponse createRefundPaymentSoapResponse() {
        return new RefundPaymentSoapResponse();
    }

    /**
     * Create an instance of {@link VoidPaymentSoapResponse }
     * 
     */
    public VoidPaymentSoapResponse createVoidPaymentSoapResponse() {
        return new VoidPaymentSoapResponse();
    }

    /**
     * Create an instance of {@link CancelPaymentSoapResponse }
     * 
     */
    public CancelPaymentSoapResponse createCancelPaymentSoapResponse() {
        return new CancelPaymentSoapResponse();
    }

    /**
     * Create an instance of {@link GetPaymentStatusSoap }
     * 
     */
    public GetPaymentStatusSoap createGetPaymentStatusSoap() {
        return new GetPaymentStatusSoap();
    }

    /**
     * Create an instance of {@link GetPaymentStatusResponse }
     * 
     */
    public GetPaymentStatusResponse createGetPaymentStatusResponse() {
        return new GetPaymentStatusResponse();
    }

    /**
     * Create an instance of {@link PaymentGetStatusResponse }
     * 
     */
    public PaymentGetStatusResponse createPaymentGetStatusResponse() {
        return new PaymentGetStatusResponse();
    }

    /**
     * Create an instance of {@link CompletePaymentResponse }
     * 
     */
    public CompletePaymentResponse createCompletePaymentResponse() {
        return new CompletePaymentResponse();
    }

    /**
     * Create an instance of {@link GetPaymentStatusSoapResponse }
     * 
     */
    public GetPaymentStatusSoapResponse createGetPaymentStatusSoapResponse() {
        return new GetPaymentStatusSoapResponse();
    }

    /**
     * Create an instance of {@link CancelPaymentResponse }
     * 
     */
    public CancelPaymentResponse createCancelPaymentResponse() {
        return new CancelPaymentResponse();
    }

    /**
     * Create an instance of {@link CompletePaymentSoap }
     * 
     */
    public CompletePaymentSoap createCompletePaymentSoap() {
        return new CompletePaymentSoap();
    }

    /**
     * Create an instance of {@link RefundPaymentSoap }
     * 
     */
    public RefundPaymentSoap createRefundPaymentSoap() {
        return new RefundPaymentSoap();
    }

    /**
     * Create an instance of {@link CancelPayment }
     * 
     */
    public CancelPayment createCancelPayment() {
        return new CancelPayment();
    }

    /**
     * Create an instance of {@link GetPaymentStatus }
     * 
     */
    public GetPaymentStatus createGetPaymentStatus() {
        return new GetPaymentStatus();
    }

    /**
     * Create an instance of {@link CompletePayment }
     * 
     */
    public CompletePayment createCompletePayment() {
        return new CompletePayment();
    }

    /**
     * Create an instance of {@link VoidPayment }
     * 
     */
    public VoidPayment createVoidPayment() {
        return new VoidPayment();
    }

    /**
     * Create an instance of {@link VoidPaymentResponse }
     * 
     */
    public VoidPaymentResponse createVoidPaymentResponse() {
        return new VoidPaymentResponse();
    }

    /**
     * Create an instance of {@link VoidPaymentSoap }
     * 
     */
    public VoidPaymentSoap createVoidPaymentSoap() {
        return new VoidPaymentSoap();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "anyURI")
    public JAXBElement<String> createAnyURI(String value) {
        return new JAXBElement<String>(_AnyURI_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaymentServiceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/PMRWeb.PaymentRouter", name = "PaymentServiceResponse")
    public JAXBElement<PaymentServiceResponse> createPaymentServiceResponse(PaymentServiceResponse value) {
        return new JAXBElement<PaymentServiceResponse>(_PaymentServiceResponse_QNAME, PaymentServiceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "char")
    public JAXBElement<Integer> createChar(Integer value) {
        return new JAXBElement<Integer>(_Char_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedByte")
    public JAXBElement<Short> createUnsignedByte(Short value) {
        return new JAXBElement<Short>(_UnsignedByte_QNAME, Short.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "dateTime")
    public JAXBElement<XMLGregorianCalendar> createDateTime(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_DateTime_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "anyType")
    public JAXBElement<Object> createAnyType(Object value) {
        return new JAXBElement<Object>(_AnyType_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedInt")
    public JAXBElement<Long> createUnsignedInt(Long value) {
        return new JAXBElement<Long>(_UnsignedInt_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "int")
    public JAXBElement<Integer> createInt(Integer value) {
        return new JAXBElement<Integer>(_Int_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "QName")
    public JAXBElement<QName> createQName(QName value) {
        return new JAXBElement<QName>(_QName_QNAME, QName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedShort")
    public JAXBElement<Integer> createUnsignedShort(Integer value) {
        return new JAXBElement<Integer>(_UnsignedShort_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Float }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "float")
    public JAXBElement<Float> createFloat(Float value) {
        return new JAXBElement<Float>(_Float_QNAME, Float.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "decimal")
    public JAXBElement<BigDecimal> createDecimal(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_Decimal_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "double")
    public JAXBElement<Double> createDouble(Double value) {
        return new JAXBElement<Double>(_Double_QNAME, Double.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "long")
    public JAXBElement<Long> createLong(Long value) {
        return new JAXBElement<Long>(_Long_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaymentGetStatusResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/PMRWeb.PaymentRouter", name = "PaymentGetStatusResponse")
    public JAXBElement<PaymentGetStatusResponse> createPaymentGetStatusResponse(PaymentGetStatusResponse value) {
        return new JAXBElement<PaymentGetStatusResponse>(_PaymentGetStatusResponse_QNAME, PaymentGetStatusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "short")
    public JAXBElement<Short> createShort(Short value) {
        return new JAXBElement<Short>(_Short_QNAME, Short.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "guid")
    public JAXBElement<String> createGuid(String value) {
        return new JAXBElement<String>(_Guid_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "base64Binary")
    public JAXBElement<byte[]> createBase64Binary(byte[] value) {
        return new JAXBElement<byte[]>(_Base64Binary_QNAME, byte[].class, null, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Duration }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "duration")
    public JAXBElement<Duration> createDuration(Duration value) {
        return new JAXBElement<Duration>(_Duration_QNAME, Duration.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Byte }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "byte")
    public JAXBElement<Byte> createByte(Byte value) {
        return new JAXBElement<Byte>(_Byte_QNAME, Byte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "string")
    public JAXBElement<String> createString(String value) {
        return new JAXBElement<String>(_String_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedLong")
    public JAXBElement<BigInteger> createUnsignedLong(BigInteger value) {
        return new JAXBElement<BigInteger>(_UnsignedLong_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "boolean")
    public JAXBElement<Boolean> createBoolean(Boolean value) {
        return new JAXBElement<Boolean>(_Boolean_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "PurchaseId", scope = RefundPaymentSoap.class)
    public JAXBElement<String> createRefundPaymentSoapPurchaseId(String value) {
        return new JAXBElement<String>(_RefundPaymentSoapPurchaseId_QNAME, String.class, RefundPaymentSoap.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "SecureHash", scope = RefundPaymentSoap.class)
    public JAXBElement<String> createRefundPaymentSoapSecureHash(String value) {
        return new JAXBElement<String>(_RefundPaymentSoapSecureHash_QNAME, String.class, RefundPaymentSoap.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaymentServiceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "CancelPaymentSoapResult", scope = CancelPaymentSoapResponse.class)
    public JAXBElement<PaymentServiceResponse> createCancelPaymentSoapResponseCancelPaymentSoapResult(PaymentServiceResponse value) {
        return new JAXBElement<PaymentServiceResponse>(_CancelPaymentSoapResponseCancelPaymentSoapResult_QNAME, PaymentServiceResponse.class, CancelPaymentSoapResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "PurchaseId", scope = RefundPayment.class)
    public JAXBElement<String> createRefundPaymentPurchaseId(String value) {
        return new JAXBElement<String>(_RefundPaymentSoapPurchaseId_QNAME, String.class, RefundPayment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "SecureHash", scope = RefundPayment.class)
    public JAXBElement<String> createRefundPaymentSecureHash(String value) {
        return new JAXBElement<String>(_RefundPaymentSoapSecureHash_QNAME, String.class, RefundPayment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "PurchaseId", scope = CompletePaymentSoap.class)
    public JAXBElement<String> createCompletePaymentSoapPurchaseId(String value) {
        return new JAXBElement<String>(_RefundPaymentSoapPurchaseId_QNAME, String.class, CompletePaymentSoap.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "SecureHash", scope = CompletePaymentSoap.class)
    public JAXBElement<String> createCompletePaymentSoapSecureHash(String value) {
        return new JAXBElement<String>(_RefundPaymentSoapSecureHash_QNAME, String.class, CompletePaymentSoap.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/PMRWeb.PaymentRouter", name = "EDirhamFees", scope = PaymentGetStatusResponse.class)
    public JAXBElement<String> createPaymentGetStatusResponseEDirhamFees(String value) {
        return new JAXBElement<String>(_PaymentGetStatusResponseEDirhamFees_QNAME, String.class, PaymentGetStatusResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/PMRWeb.PaymentRouter", name = "CollectionCenterFees", scope = PaymentGetStatusResponse.class)
    public JAXBElement<String> createPaymentGetStatusResponseCollectionCenterFees(String value) {
        return new JAXBElement<String>(_PaymentGetStatusResponseCollectionCenterFees_QNAME, String.class, PaymentGetStatusResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/PMRWeb.PaymentRouter", name = "SecureHash", scope = PaymentGetStatusResponse.class)
    public JAXBElement<String> createPaymentGetStatusResponseSecureHash(String value) {
        return new JAXBElement<String>(_PaymentGetStatusResponseSecureHash_QNAME, String.class, PaymentGetStatusResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/PMRWeb.PaymentRouter", name = "PUN", scope = PaymentGetStatusResponse.class)
    public JAXBElement<String> createPaymentGetStatusResponsePUN(String value) {
        return new JAXBElement<String>(_PaymentGetStatusResponsePUN_QNAME, String.class, PaymentGetStatusResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/PMRWeb.PaymentRouter", name = "TransactionResponseDate", scope = PaymentGetStatusResponse.class)
    public JAXBElement<String> createPaymentGetStatusResponseTransactionResponseDate(String value) {
        return new JAXBElement<String>(_PaymentGetStatusResponseTransactionResponseDate_QNAME, String.class, PaymentGetStatusResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/PMRWeb.PaymentRouter", name = "Amount", scope = PaymentGetStatusResponse.class)
    public JAXBElement<String> createPaymentGetStatusResponseAmount(String value) {
        return new JAXBElement<String>(_PaymentGetStatusResponseAmount_QNAME, String.class, PaymentGetStatusResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/PMRWeb.PaymentRouter", name = "EServiceData", scope = PaymentGetStatusResponse.class)
    public JAXBElement<String> createPaymentGetStatusResponseEServiceData(String value) {
        return new JAXBElement<String>(_PaymentGetStatusResponseEServiceData_QNAME, String.class, PaymentGetStatusResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/PMRWeb.PaymentRouter", name = "InvoiceID", scope = PaymentGetStatusResponse.class)
    public JAXBElement<String> createPaymentGetStatusResponseInvoiceID(String value) {
        return new JAXBElement<String>(_PaymentGetStatusResponseInvoiceID_QNAME, String.class, PaymentGetStatusResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "PurchaseId", scope = CompletePayment.class)
    public JAXBElement<String> createCompletePaymentPurchaseId(String value) {
        return new JAXBElement<String>(_RefundPaymentSoapPurchaseId_QNAME, String.class, CompletePayment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "SecureHash", scope = CompletePayment.class)
    public JAXBElement<String> createCompletePaymentSecureHash(String value) {
        return new JAXBElement<String>(_RefundPaymentSoapSecureHash_QNAME, String.class, CompletePayment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaymentServiceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "RefundPaymentResult", scope = RefundPaymentResponse.class)
    public JAXBElement<PaymentServiceResponse> createRefundPaymentResponseRefundPaymentResult(PaymentServiceResponse value) {
        return new JAXBElement<PaymentServiceResponse>(_RefundPaymentResponseRefundPaymentResult_QNAME, PaymentServiceResponse.class, RefundPaymentResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaymentServiceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "CancelPaymentResult", scope = CancelPaymentResponse.class)
    public JAXBElement<PaymentServiceResponse> createCancelPaymentResponseCancelPaymentResult(PaymentServiceResponse value) {
        return new JAXBElement<PaymentServiceResponse>(_CancelPaymentResponseCancelPaymentResult_QNAME, PaymentServiceResponse.class, CancelPaymentResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaymentServiceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "CompletePaymentSoapResult", scope = CompletePaymentSoapResponse.class)
    public JAXBElement<PaymentServiceResponse> createCompletePaymentSoapResponseCompletePaymentSoapResult(PaymentServiceResponse value) {
        return new JAXBElement<PaymentServiceResponse>(_CompletePaymentSoapResponseCompletePaymentSoapResult_QNAME, PaymentServiceResponse.class, CompletePaymentSoapResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "PurchaseId", scope = CancelPaymentSoap.class)
    public JAXBElement<String> createCancelPaymentSoapPurchaseId(String value) {
        return new JAXBElement<String>(_RefundPaymentSoapPurchaseId_QNAME, String.class, CancelPaymentSoap.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "SecureHash", scope = CancelPaymentSoap.class)
    public JAXBElement<String> createCancelPaymentSoapSecureHash(String value) {
        return new JAXBElement<String>(_RefundPaymentSoapSecureHash_QNAME, String.class, CancelPaymentSoap.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaymentServiceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "VoidPaymentSoapResult", scope = VoidPaymentSoapResponse.class)
    public JAXBElement<PaymentServiceResponse> createVoidPaymentSoapResponseVoidPaymentSoapResult(PaymentServiceResponse value) {
        return new JAXBElement<PaymentServiceResponse>(_VoidPaymentSoapResponseVoidPaymentSoapResult_QNAME, PaymentServiceResponse.class, VoidPaymentSoapResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaymentServiceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "CompletePaymentResult", scope = CompletePaymentResponse.class)
    public JAXBElement<PaymentServiceResponse> createCompletePaymentResponseCompletePaymentResult(PaymentServiceResponse value) {
        return new JAXBElement<PaymentServiceResponse>(_CompletePaymentResponseCompletePaymentResult_QNAME, PaymentServiceResponse.class, CompletePaymentResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "PurchaseId", scope = VoidPaymentSoap.class)
    public JAXBElement<String> createVoidPaymentSoapPurchaseId(String value) {
        return new JAXBElement<String>(_RefundPaymentSoapPurchaseId_QNAME, String.class, VoidPaymentSoap.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "SecureHash", scope = VoidPaymentSoap.class)
    public JAXBElement<String> createVoidPaymentSoapSecureHash(String value) {
        return new JAXBElement<String>(_RefundPaymentSoapSecureHash_QNAME, String.class, VoidPaymentSoap.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaymentServiceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "VoidPaymentResult", scope = VoidPaymentResponse.class)
    public JAXBElement<PaymentServiceResponse> createVoidPaymentResponseVoidPaymentResult(PaymentServiceResponse value) {
        return new JAXBElement<PaymentServiceResponse>(_VoidPaymentResponseVoidPaymentResult_QNAME, PaymentServiceResponse.class, VoidPaymentResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "PurchaseId", scope = VoidPayment.class)
    public JAXBElement<String> createVoidPaymentPurchaseId(String value) {
        return new JAXBElement<String>(_RefundPaymentSoapPurchaseId_QNAME, String.class, VoidPayment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "SecureHash", scope = VoidPayment.class)
    public JAXBElement<String> createVoidPaymentSecureHash(String value) {
        return new JAXBElement<String>(_RefundPaymentSoapSecureHash_QNAME, String.class, VoidPayment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaymentGetStatusResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetPaymentStatusSoapResult", scope = GetPaymentStatusSoapResponse.class)
    public JAXBElement<PaymentGetStatusResponse> createGetPaymentStatusSoapResponseGetPaymentStatusSoapResult(PaymentGetStatusResponse value) {
        return new JAXBElement<PaymentGetStatusResponse>(_GetPaymentStatusSoapResponseGetPaymentStatusSoapResult_QNAME, PaymentGetStatusResponse.class, GetPaymentStatusSoapResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "PurchaseId", scope = GetPaymentStatusSoap.class)
    public JAXBElement<String> createGetPaymentStatusSoapPurchaseId(String value) {
        return new JAXBElement<String>(_RefundPaymentSoapPurchaseId_QNAME, String.class, GetPaymentStatusSoap.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "SecureHash", scope = GetPaymentStatusSoap.class)
    public JAXBElement<String> createGetPaymentStatusSoapSecureHash(String value) {
        return new JAXBElement<String>(_RefundPaymentSoapSecureHash_QNAME, String.class, GetPaymentStatusSoap.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaymentGetStatusResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetPaymentStatusResult", scope = GetPaymentStatusResponse.class)
    public JAXBElement<PaymentGetStatusResponse> createGetPaymentStatusResponseGetPaymentStatusResult(PaymentGetStatusResponse value) {
        return new JAXBElement<PaymentGetStatusResponse>(_GetPaymentStatusResponseGetPaymentStatusResult_QNAME, PaymentGetStatusResponse.class, GetPaymentStatusResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/PMRWeb.PaymentRouter", name = "StatusMessage", scope = PaymentServiceResponse.class)
    public JAXBElement<String> createPaymentServiceResponseStatusMessage(String value) {
        return new JAXBElement<String>(_PaymentServiceResponseStatusMessage_QNAME, String.class, PaymentServiceResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/PMRWeb.PaymentRouter", name = "ConfirmationID", scope = PaymentServiceResponse.class)
    public JAXBElement<String> createPaymentServiceResponseConfirmationID(String value) {
        return new JAXBElement<String>(_PaymentServiceResponseConfirmationID_QNAME, String.class, PaymentServiceResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/PMRWeb.PaymentRouter", name = "Status", scope = PaymentServiceResponse.class)
    public JAXBElement<String> createPaymentServiceResponseStatus(String value) {
        return new JAXBElement<String>(_PaymentServiceResponseStatus_QNAME, String.class, PaymentServiceResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaymentServiceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "RefundPaymentSoapResult", scope = RefundPaymentSoapResponse.class)
    public JAXBElement<PaymentServiceResponse> createRefundPaymentSoapResponseRefundPaymentSoapResult(PaymentServiceResponse value) {
        return new JAXBElement<PaymentServiceResponse>(_RefundPaymentSoapResponseRefundPaymentSoapResult_QNAME, PaymentServiceResponse.class, RefundPaymentSoapResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "PurchaseId", scope = CancelPayment.class)
    public JAXBElement<String> createCancelPaymentPurchaseId(String value) {
        return new JAXBElement<String>(_RefundPaymentSoapPurchaseId_QNAME, String.class, CancelPayment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "SecureHash", scope = CancelPayment.class)
    public JAXBElement<String> createCancelPaymentSecureHash(String value) {
        return new JAXBElement<String>(_RefundPaymentSoapSecureHash_QNAME, String.class, CancelPayment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "PurchaseId", scope = GetPaymentStatus.class)
    public JAXBElement<String> createGetPaymentStatusPurchaseId(String value) {
        return new JAXBElement<String>(_RefundPaymentSoapPurchaseId_QNAME, String.class, GetPaymentStatus.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "SecureHash", scope = GetPaymentStatus.class)
    public JAXBElement<String> createGetPaymentStatusSecureHash(String value) {
        return new JAXBElement<String>(_RefundPaymentSoapSecureHash_QNAME, String.class, GetPaymentStatus.class, value);
    }

}
