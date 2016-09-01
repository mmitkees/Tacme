package com.tacme.pmr.wrapper;

import com.tacme.pmr.IPaymentServiceSoap;
import com.tacme.pmr.PaymentService;
import com.tacme.pmr.beans.PaymentStatusResponse;
import com.tacme.pmr.types.GetPaymentStatusResponse;
import com.tacme.pmr.types.PaymentGetStatusResponse;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

public class PaymentWrapper {
    public PaymentWrapper() {
        super();
        getPaymentService();
    }

    private PaymentService getPaymentService() {
        if (pymentService == null) {
            pymentService = new PaymentService();
            iPaymentServiceSoap = pymentService.getSOAPEndPoint();
        }
        return pymentService;
    }

    private PaymentService pymentService;
    private IPaymentServiceSoap iPaymentServiceSoap;

    public PaymentStatusResponse getAndUpdatePaymentStatus(String purchaseId) {
        PaymentStatusResponse response = null;
        PaymentGetStatusResponse resSoap =
            iPaymentServiceSoap.getPaymentStatusSoap(purchaseId, null);
        SimpleDateFormat df = new SimpleDateFormat("ddMMyyyyHHmmss");
        Date transactionDate;
        
        try {
            transactionDate =
                    df.parse(resSoap.getTransactionResponseDate().getValue());
            response =
                    new PaymentStatusResponse(resSoap.getStatus().getValue(),
                                              resSoap.getStatusMessage().getValue(),
                                              (Integer.parseInt(resSoap.getAmount().getValue())) /100,
                                              (Integer.parseInt(resSoap.getCollectionCenterFees().getValue())) /100,
                                              (Integer.parseInt(resSoap.getEDirhamFees().getValue())) /100,
                                              resSoap.getEServiceData().getValue(),
                                              resSoap.getInvoiceID().getValue(),
                                              resSoap.getPUN().getValue(),
                                              resSoap.getSecureHash().getValue(),
                                              transactionDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return response;
    }


}
