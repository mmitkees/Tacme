package com.pp.newsletter.model.services;


import com.pp.newsletter.model.services.common.newsLetterAM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ApplicationModuleImpl;
import oracle.jbo.server.ViewLinkImpl;
import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Jan 22 10:56:47 IST 2016
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class newsLetterAMImpl extends ApplicationModuleImpl implements newsLetterAM {
    /**
     * This is the default constructor (do not remove).
     */
    public newsLetterAMImpl() {
    }

    /**
     * Container's getter for CategoriesView1.
     * @return CategoriesView1
     */
    public ViewObjectImpl getCategoriesView1() {
        return (ViewObjectImpl)findViewObject("CategoriesView1");
    }

    /**
     * Container's getter for NewsletterSubscriptionView1.
     * @return NewsletterSubscriptionView1
     */
    public ViewObjectImpl getNewsletterSubscriptionView1() {
        return (ViewObjectImpl)findViewObject("NewsletterSubscriptionView1");
    }

    /**
     *  news subscribe
     */
    public String newssubscribe(String m_name, String m_email, List m_s) {
        String ret = "N";
        if (m_name != null && m_email != null && m_s != null) {
            ViewObject newsSubscribeview =
                this.getNewsletterSubscriptionView1();
            for (int i = 0; i < m_s.size(); i++) {
                if (newsSubscribeview != null) {
                    String content =
                        checkCategory(m_email, (String)m_s.get(i));
                    if (content.equals("new")) {
                        ret = "Y";
                    } else {
                        ret = content;
                    }
                }
            }
            if (ret.equals("Y")) {
                for (int j = 0; j < m_s.size(); j++) {
                    Row newsSubscriberow = newsSubscribeview.createRow();
                    newsSubscriberow.setAttribute("NsName", m_name);
                    newsSubscriberow.setAttribute("NsEmail", m_email);
                    newsSubscriberow.setAttribute("NsCategories", m_s.get(j));
                }
            }
        } else {
            ret = "M";
        }
        return ret;
    }

    public String checkCategory(String email, String categList) {
        String ret = "new";
        ViewObject newsSubscribeview = this.getNewsletterSubCheckView1();
        try {
            newsSubscribeview.setNamedWhereClauseParam("p_email", email);
            newsSubscribeview.setNamedWhereClauseParam("p_categories",
                                                       categList);
            newsSubscribeview.executeQuery();            
            if (newsSubscribeview.getEstimatedRowCount() != 0) {
                ret = "exist";
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            newsSubscribeview.reset();
        }
        return ret;
    }

    /**
     * Container's getter for NewsletterSubCheckView1.
     * @return NewsletterSubCheckView1
     */
    public ViewObjectImpl getNewsletterSubCheckView1() {
        return (ViewObjectImpl)findViewObject("NewsletterSubCheckView1");
    }

    /**
     * Container's getter for NewsletterEmailView1.
     * @return NewsletterEmailView1
     */
    public ViewObjectImpl getNewsletterEmailView1() {
        return (ViewObjectImpl)findViewObject("NewsletterEmailView1");
    }

    /**
     * Container's getter for EmailConfigView1.
     * @return EmailConfigView1
     */
    public ViewObjectImpl getEmailConfigView1() {
        return (ViewObjectImpl)findViewObject("EmailConfigView1");
    }

    /**
     * Container's getter for NewsletterSubscategoriesView1.
     * @return NewsletterSubscategoriesView1
     */
    public ViewObjectImpl getNewsletterSubscategoriesView1() {
        return (ViewObjectImpl)findViewObject("NewsletterSubscategoriesView1");
    }

    /**
     * Container's getter for NewsletterSubscategoriesView2.
     * @return NewsletterSubscategoriesView2
     */
    public ViewObjectImpl getNewsletterSubscategoriesView2() {
        return (ViewObjectImpl)findViewObject("NewsletterSubscategoriesView2");
    }

    /**
     * Container's getter for subscriptionsToSubCategories1.
     * @return subscriptionsToSubCategories1
     */
    public ViewLinkImpl getsubscriptionsToSubCategories1() {
        return (ViewLinkImpl)findViewLink("subscriptionsToSubCategories1");
    }
    
    /**
     *  Initialise method to subscribe the categories
     */
    public void executeCategories(String email){
        try{
        ViewObject subscriptionView = this.getNewsletterSubscriptionView1();        
        ViewObject newsSubscView = this.getNewsletterSubscategoriesView2();
        ViewObject categoriesView = this.getCategoriesView1();        
        subscriptionView.setNamedWhereClauseParam("nemail", email);
        subscriptionView.executeQuery();
        if (subscriptionView.getEstimatedRowCount() != 0){
            newsSubscView.executeQuery();
        }else{
            Row subscriptionRow = subscriptionView.createRow();
            subscriptionRow.setAttribute("NsEmail", email);
            subscriptionView.insertRow(subscriptionRow);                        
            for (int i = 0;i < categoriesView.getEstimatedRowCount();i++){                               
                Row categoriesRow = categoriesView.next();
                if (categoriesRow != null){
                    Row newsSubscrow = newsSubscView.createRow();
                newsSubscrow.setAttribute("NsCategories", categoriesRow.getAttribute("CategoriesName"));
                newsSubscrow.setAttribute("NsSelect", "N");                
                }
            }
        }        
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public String checkCateg(){
        String categ = "N";
        String select;
        ViewObject newsSubCategView = this.getNewsletterSubscategoriesView2();
        if (newsSubCategView.getEstimatedRowCount() != 0){
            for (int i= 0; i<newsSubCategView.getEstimatedRowCount();i++){
                Row newsSubCategRow = newsSubCategView.next();
                if (newsSubCategRow != null){
                select = (String)newsSubCategRow.getAttribute("NsSelect");
                if (select.equals("true")){
                    categ = "Y";
                }
                }
            }
        }
        return categ;
    }

    /**
     * Container's getter for newsLetterCheckCategories1.
     * @return newsLetterCheckCategories1
     */
    public ViewObjectImpl getnewsLetterCheckCategories1() {
        return (ViewObjectImpl)findViewObject("newsLetterCheckCategories1");
    }

    /**
     * Container's getter for newsSubCateg1.
     * @return newsSubCateg1
     */
    public ViewObjectImpl getnewsSubCateg1() {
        return (ViewObjectImpl)findViewObject("newsSubCateg1");
    }
}
