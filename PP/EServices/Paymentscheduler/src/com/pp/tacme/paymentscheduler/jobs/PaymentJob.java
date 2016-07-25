package com.pp.tacme.paymentscheduler.jobs;

import com.app.model.services.PPAppServicesImpl;

import com.pp.tacme.proxies.PaymentServices.IPaymentServiceSoap;
import com.pp.tacme.proxies.PaymentServices.PaymentService;
import com.pp.tacme.proxies.PaymentServices.types.PaymentGetStatusResponse;

import commonj.timers.CancelTimerListener;
import commonj.timers.Timer;
import commonj.timers.TimerListener;

import java.io.Serializable;

import java.util.Calendar;

import oracle.adf.share.ADFContext;
import oracle.adf.share.config.ConfigUtils;
import oracle.adf.share.logging.ADFLogger;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.client.Configuration;
import oracle.jbo.domain.Date;

import view.utils.ADFUtils;

public class PaymentJob implements Serializable, TimerListener,
                                   CancelTimerListener {
    public PaymentJob() {
        super();
    }
    oracle.jbo.ViewObject paymentsToBeChecked;
    private static ADFLogger logger =
        ADFLogger.createADFLogger(PaymentJob.class);
    private static PaymentService paymentService;

    public void timerExpired(Timer timer) {
        String amDef = "com.app.model.services.PPAppServices";
        ApplicationModule am=null;
        PPAppServicesImpl appMod =null;
        int size = 0;
        try {
            logger.info("Entring execute Alert Job");


            ADFContext currentADFContext = null;
            if (ADFContext.getCurrent() == null)
                currentADFContext =
                        ADFContext.initADFContext(null, null, null, null);

            am =
 Configuration.createRootApplicationModule(amDef, "PPscheduler");
             appMod = (PPAppServicesImpl)am;


            System.out.println("====Starting scheduler====");


            paymentsToBeChecked = am.findViewObject("PaymentsToBeChecked1");
            if (paymentsToBeChecked == null)
                System.out.println("el vo null");
            paymentsToBeChecked.executeQuery();
            RowSetIterator rsIterator =
                paymentsToBeChecked.createRowSetIterator(null);
            rsIterator.reset();
            while (rsIterator.hasNext()) {
                 size++;
                try {
                    Row row = rsIterator.next();
                  
                    paymentService = new PaymentService();
                    IPaymentServiceSoap iPaymentServiceSoap =
                        paymentService.getSOAPEndPoint();
                    PaymentGetStatusResponse res =
                        iPaymentServiceSoap.getPaymentStatusSoap((String)row.getAttribute("InvoiceId"),
                                                                 "");
                    String pmrstatus = res.getStatus().getValue();
                    String pmrmsg = res.getStatusMessage().getValue();
                    //    String pmrstatus= "0000" ;
                    //   String pmrmsg="Eshta";
                    System.out.println("PMR Status is ----> "+pmrstatus);
                    if (pmrstatus.equalsIgnoreCase("0000") ||
                        pmrstatus.equalsIgnoreCase("6514")) {
                        // success
                        row.setAttribute("Status", "Payment Done");
                        row.setAttribute("TransactionStatus", pmrstatus);
                        row.setAttribute("StatusDetails", pmrmsg);
                        row.setAttribute("StatusDetails1", "Payment Done");
                    } else {
                        // failed
                        if (pmrstatus.equalsIgnoreCase("2012") ||
                            pmrstatus.equalsIgnoreCase("6509")) {
                            row.setAttribute("Status", "Pending Payment");
                            row.setAttribute("TransactionStatus", pmrstatus);
                            row.setAttribute("StatusDetails", pmrmsg);
                            row.setAttribute("StatusDetails1",
                                             "Payment not completed successfully  Try To pay again");

                        } else {
                            row.setAttribute("Status", "Payment Failed");
                            row.setAttribute("TransactionStatus", pmrstatus);
                            row.setAttribute("StatusDetails", pmrmsg);
                            row.setAttribute("StatusDetails1",
                                             "Payment Failed Submit a new Request");
                        }

                    }
                } catch (Exception e) {
                    // TODO: Add catch code
                    e.printStackTrace();
                }
            }
           

            rsIterator.closeRowSetIterator();
            am.getTransaction().commit();


            logger.info(PaymentJob.class.toString(), "PaymentJob",
                        "--> Calling executeCurrentjob ");

          
            logger.info(PaymentJob.class.toString(), "PaymentJob",
                        "Exiting execute payment Scheduler Job");
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.severe(ex);
        } finally {
            System.out.println("Number Of Requests: " + size);
            if(appMod !=null)
                Configuration.releaseRootApplicationModule(appMod, true);
        }
    }

    public void timerCancel(Timer timer) {
    }
}
