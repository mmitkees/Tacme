package com.tacme.pmr;

import com.tacme.pmr.beans.PaymentStatusResponse;
import com.tacme.pmr.wrapper.PaymentWrapper;

public class TestPayment {
    public TestPayment() {
        super();
    }
    
    
    public static void main (String args []){
        PaymentStatusResponse res= null;
        PaymentWrapper payment= new PaymentWrapper();
       res= payment.getAndUpdatePaymentStatus("235695");
       System.out.println(res.getTransactionResponseDate());
    }
}
