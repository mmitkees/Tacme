package com.pp.tacme.proxies.PaymentServices;

import java.io.File;

import java.net.MalformedURLException;
import java.net.URL;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
// !DO NOT EDIT THIS FILE!
// This source file is generated by Oracle tools
// Contents may be subject to change
// For reporting problems, use the following
// Version = Oracle WebServices (11.1.1.0.0, build 150302.2135.55683)

@WebServiceClient(wsdlLocation="http://172.25.1.202/PMRWeb/PaymentRouter/PaymentService.svc?wsdl",
  targetNamespace="http://tempuri.org/", name="PaymentService")
public class PaymentService
  extends Service
{
  private static URL wsdlLocationURL;

  private static Logger logger;
  static
  {
    try
    {
      logger = Logger.getLogger("com.pp.tacme.proxies.PaymentServices.PaymentService");
      URL baseUrl = PaymentService.class.getResource(".");
      if (baseUrl == null)
      {
        wsdlLocationURL =
            PaymentService.class.getResource("http://172.25.1.202/PMRWeb/PaymentRouter/PaymentService.svc?wsdl");
        if (wsdlLocationURL == null)
        {
          baseUrl = new File(".").toURL();
          wsdlLocationURL =
              new URL(baseUrl, "http://172.25.1.202/PMRWeb/PaymentRouter/PaymentService.svc?wsdl");
        }
      }
      else
      {
                if (!baseUrl.getPath().endsWith("/")) {
         baseUrl = new URL(baseUrl, baseUrl.getPath() + "/");
}
                wsdlLocationURL =
            new URL(baseUrl, "http://172.25.1.202/PMRWeb/PaymentRouter/PaymentService.svc?wsdl");
      }
    }
    catch (MalformedURLException e)
    {
      logger.log(Level.ALL,
          "Failed to create wsdlLocationURL using http://172.25.1.202/PMRWeb/PaymentRouter/PaymentService.svc?wsdl",
          e);
    }
  }

  public PaymentService()
  {
    super(wsdlLocationURL,
          new QName("http://tempuri.org/", "PaymentService"));
  }

  public PaymentService(URL wsdlLocation, QName serviceName)
  {
    super(wsdlLocation, serviceName);
  }

  @WebEndpoint(name="SOAPEndPoint")
  public IPaymentServiceSoap getSOAPEndPoint()
  {
    return (IPaymentServiceSoap) super.getPort(new QName("http://tempuri.org/",
                                                         "SOAPEndPoint"),
                                               IPaymentServiceSoap.class);
  }

  @WebEndpoint(name="SOAPEndPoint")
  public IPaymentServiceSoap getSOAPEndPoint(WebServiceFeature... features)
  {
    return (IPaymentServiceSoap) super.getPort(new QName("http://tempuri.org/",
                                                         "SOAPEndPoint"),
                                               IPaymentServiceSoap.class,
                                               features);
  }
}
