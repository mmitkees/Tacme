package com.pp.tacme.paymentscheduler.servlets;

import com.pp.tacme.paymentscheduler.jobs.PaymentJob;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.InitialContext;

import javax.servlet.*;
import javax.servlet.http.*;


import oracle.adf.share.logging.ADFLogger;
import commonj.timers.TimerManager;

import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Calendar;
public class PaymentSchedulerServlet extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
    
    private static ADFLogger logger =
          ADFLogger.createADFLogger(PaymentSchedulerServlet.class);


    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        logger.entering(PaymentSchedulerServlet.class.toString(),
                              " paymentSchedulerServlet contextInitialized method");
              logger.info(PaymentSchedulerServlet.class.toString(),
                          "paymentSchedulerServlet",
                          "paymentSchedulerServlet context Initialized method ");
                       logger.info(PaymentSchedulerServlet.class.toString(),
                          "paymentSchedulerServlet",
                          "will call  AlertSchedularJob.startSchedular()");
              //                    AlertSchedularJob.startSchedular();
                           try {
                      InitialContext ic = new InitialContext();
                      TimerManager tm = (TimerManager)ic.lookup("java:comp/env/tm/TimerManager");
                      Calendar cal = Calendar.getInstance();
                                  cal.add(Calendar.SECOND, 30);
                      Long duration = 600L;// 300 second --> 5 min
           
                      
                      tm.scheduleAtFixedRate(new PaymentJob(), cal.getTime(), duration*1000);
                  } catch (Exception e) {
                      // TODO: Add catch code
                      logger.severe(e);
                  }

                 
              logger.exiting(PaymentSchedulerServlet.class.toString(), "paymentSchedulerServlet",
                              "paymentSchedulerServlet :contextInitialized method");

    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException,
                                                           IOException {
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>paymentSchedulerServlet</title></head>");
        out.println("<body>");
        out.println("<p>The servlet has received a GET. This is the reply.</p>");
        out.println("</body></html>");
        out.close();
    }
}
