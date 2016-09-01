package com.tacme.pmr;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
// !DO NOT EDIT THIS FILE!
// This source file is generated by Oracle tools
// Contents may be subject to change
// For reporting problems, use the following
// Version = Oracle WebServices (11.1.1.0.0, build 150302.2135.55683)

@WebService(wsdlLocation="http://172.25.1.202/PMRWeb/PaymentRouter/PaymentService.svc?wsdl",
  targetNamespace="http://tempuri.org/", name="IPaymentServiceSoap")
@XmlSeeAlso(
  { com.tacme.pmr.types.ObjectFactory.class })
public interface IPaymentServiceSoap
{
  @WebMethod(operationName="GetPaymentStatusSoap", action="http://tempuri.org/IPaymentServiceSoap/GetPaymentStatusSoap")
  @Action(input="http://tempuri.org/IPaymentServiceSoap/GetPaymentStatusSoap",
    output="http://tempuri.org/IPaymentServiceSoap/GetPaymentStatusSoapResponse")
  @ResponseWrapper(localName="GetPaymentStatusSoapResponse",
    targetNamespace="http://tempuri.org/", className="com.tacme.pmr.types.GetPaymentStatusSoapResponse")
  @RequestWrapper(localName="GetPaymentStatusSoap", targetNamespace="http://tempuri.org/",
    className="com.tacme.pmr.types.GetPaymentStatusSoap")
  @WebResult(targetNamespace="http://tempuri.org/", name="GetPaymentStatusSoapResult")
  public com.tacme.pmr.types.PaymentGetStatusResponse getPaymentStatusSoap(@WebParam(targetNamespace="http://tempuri.org/",
      name="PurchaseId")
    String purchaseId, @WebParam(targetNamespace="http://tempuri.org/",
      name="SecureHash")
    String secureHash);

  @WebMethod(operationName="CompletePaymentSoap", action="http://tempuri.org/IPaymentServiceSoap/CompletePaymentSoap")
  @Action(input="http://tempuri.org/IPaymentServiceSoap/CompletePaymentSoap",
    output="http://tempuri.org/IPaymentServiceSoap/CompletePaymentSoapResponse")
  @ResponseWrapper(localName="CompletePaymentSoapResponse",
    targetNamespace="http://tempuri.org/", className="com.tacme.pmr.types.CompletePaymentSoapResponse")
  @RequestWrapper(localName="CompletePaymentSoap", targetNamespace="http://tempuri.org/",
    className="com.tacme.pmr.types.CompletePaymentSoap")
  @WebResult(targetNamespace="http://tempuri.org/", name="CompletePaymentSoapResult")
  public com.tacme.pmr.types.PaymentServiceResponse completePaymentSoap(@WebParam(targetNamespace="http://tempuri.org/",
      name="PurchaseId")
    String purchaseId, @WebParam(targetNamespace="http://tempuri.org/",
      name="SecureHash")
    String secureHash);

  @WebMethod(operationName="CancelPaymentSoap", action="http://tempuri.org/IPaymentServiceSoap/CancelPaymentSoap")
  @Action(input="http://tempuri.org/IPaymentServiceSoap/CancelPaymentSoap",
    output="http://tempuri.org/IPaymentServiceSoap/CancelPaymentSoapResponse")
  @ResponseWrapper(localName="CancelPaymentSoapResponse", targetNamespace="http://tempuri.org/",
    className="com.tacme.pmr.types.CancelPaymentSoapResponse")
  @RequestWrapper(localName="CancelPaymentSoap", targetNamespace="http://tempuri.org/",
    className="com.tacme.pmr.types.CancelPaymentSoap")
  @WebResult(targetNamespace="http://tempuri.org/", name="CancelPaymentSoapResult")
  public com.tacme.pmr.types.PaymentServiceResponse cancelPaymentSoap(@WebParam(targetNamespace="http://tempuri.org/",
      name="PurchaseId")
    String purchaseId, @WebParam(targetNamespace="http://tempuri.org/",
      name="SecureHash")
    String secureHash);

  @WebMethod(operationName="RefundPaymentSoap", action="http://tempuri.org/IPaymentServiceSoap/RefundPaymentSoap")
  @Action(input="http://tempuri.org/IPaymentServiceSoap/RefundPaymentSoap",
    output="http://tempuri.org/IPaymentServiceSoap/RefundPaymentSoapResponse")
  @ResponseWrapper(localName="RefundPaymentSoapResponse", targetNamespace="http://tempuri.org/",
    className="com.tacme.pmr.types.RefundPaymentSoapResponse")
  @RequestWrapper(localName="RefundPaymentSoap", targetNamespace="http://tempuri.org/",
    className="com.tacme.pmr.types.RefundPaymentSoap")
  @WebResult(targetNamespace="http://tempuri.org/", name="RefundPaymentSoapResult")
  public com.tacme.pmr.types.PaymentServiceResponse refundPaymentSoap(@WebParam(targetNamespace="http://tempuri.org/",
      name="PurchaseId")
    String purchaseId, @WebParam(targetNamespace="http://tempuri.org/",
      name="SecureHash")
    String secureHash);

  @WebMethod(operationName="VoidPaymentSoap", action="http://tempuri.org/IPaymentServiceSoap/VoidPaymentSoap")
  @Action(input="http://tempuri.org/IPaymentServiceSoap/VoidPaymentSoap",
    output="http://tempuri.org/IPaymentServiceSoap/VoidPaymentSoapResponse")
  @ResponseWrapper(localName="VoidPaymentSoapResponse", targetNamespace="http://tempuri.org/",
    className="com.tacme.pmr.types.VoidPaymentSoapResponse")
  @RequestWrapper(localName="VoidPaymentSoap", targetNamespace="http://tempuri.org/",
    className="com.tacme.pmr.types.VoidPaymentSoap")
  @WebResult(targetNamespace="http://tempuri.org/", name="VoidPaymentSoapResult")
  public com.tacme.pmr.types.PaymentServiceResponse voidPaymentSoap(@WebParam(targetNamespace="http://tempuri.org/",
      name="PurchaseId")
    String purchaseId, @WebParam(targetNamespace="http://tempuri.org/",
      name="SecureHash")
    String secureHash);

  @WebMethod(operationName="GetSecureHashed", action="http://tempuri.org/IPaymentServiceSoap/GetSecureHashed")
  @Action(input="http://tempuri.org/IPaymentServiceSoap/GetSecureHashed",
    output="http://tempuri.org/IPaymentServiceSoap/GetSecureHashedResponse")
  @ResponseWrapper(localName="GetSecureHashedResponse", targetNamespace="http://tempuri.org/",
    className="com.tacme.pmr.types.GetSecureHashedResponse")
  @RequestWrapper(localName="GetSecureHashed", targetNamespace="http://tempuri.org/",
    className="com.tacme.pmr.types.GetSecureHashed")
  @WebResult(targetNamespace="http://tempuri.org/", name="GetSecureHashedResult")
  public String getSecureHashed(@WebParam(targetNamespace="http://tempuri.org/",
      name="Description")
    String description, @WebParam(targetNamespace="http://tempuri.org/",
      name="InvoiceID")
    String invoiceID, @WebParam(targetNamespace="http://tempuri.org/",
      name="Lang")
    String lang, @WebParam(targetNamespace="http://tempuri.org/", name="PaymentType")
    String paymentType, @WebParam(targetNamespace="http://tempuri.org/",
      name="Price")
    String price, @WebParam(targetNamespace="http://tempuri.org/", name="Quantity")
    String quantity, @WebParam(targetNamespace="http://tempuri.org/",
      name="ReturnUrl")
    String returnUrl, @WebParam(targetNamespace="http://tempuri.org/",
      name="ServiceCode")
    String serviceCode);
}