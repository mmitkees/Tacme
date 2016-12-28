package com.tacme.pp.model.common.service;

import com.tacme.pp.model.common.ROVO.userprofile.ValidateUserLoginRowImpl;
import com.tacme.pp.model.common.VO.BaseVOImpl;
import com.tacme.pp.model.common.beans.UserBean;
import com.tacme.pp.model.common.service.common.PPAppModule;
import oracle.jbo.domain.Number;
import java.text.SimpleDateFormat;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import oracle.jbo.JboException;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.domain.Number;
import oracle.jbo.server.ApplicationModuleImpl;
import oracle.jbo.server.DBTransactionImpl;
import oracle.jbo.server.ViewObjectImpl;

import oracle.jbo.server.ApplicationModuleImpl;
import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Dec 19 12:09:46 GST 2016
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class PPAppModuleImpl extends ApplicationModuleImpl implements PPAppModule {
    /**
     * This is the default constructor (do not remove).
     */
    public PPAppModuleImpl() {
    }

    /**
     * Container's getter for ValidateUserLogin1.
     * @return ValidateUserLogin1
     */
    public ViewObjectImpl getValidateUserLogin1() {
        return (ViewObjectImpl)findViewObject("ValidateUserLogin1");
    }

    /**
     * Container's getter for CountryNationalityListLOV1.
     * @return CountryNationalityListLOV1
     */
    public ViewObjectImpl getCountryNationalityListLOV1() {
        return (ViewObjectImpl)findViewObject("CountryNationalityListLOV1");
    }

    /**
     * Container's getter for ValidateServiceEligibilityRO1.
     * @return ValidateServiceEligibilityRO1
     */
    public ViewObjectImpl getValidateServiceEligibilityRO1() {
        return (ViewObjectImpl)findViewObject("ValidateServiceEligibilityRO1");
    }

    /**
     * Container's getter for Base1.
     * @return Base1
     */
    public BaseVOImpl getBase1() {
        return (BaseVOImpl)findViewObject("Base1");
    }

    /**
     * Container's getter for PuPublicUser1.
     * @return PuPublicUser1
     */
    public BaseVOImpl getPuPublicUser1() {
        return (BaseVOImpl)findViewObject("PuPublicUser1");
    }

    /**
     * Container's getter for PublicSearchExpertsRO1.
     * @return PublicSearchExpertsRO1
     */
    public ViewObjectImpl getPublicSearchExpertsRO1() {
        return (ViewObjectImpl)findViewObject("PublicSearchExpertsRO1");
    }

    /**
     * Container's getter for PublicSearchLawyersRO1.
     * @return PublicSearchLawyersRO1
     */
    public ViewObjectImpl getPublicSearchLawyersRO1() {
        return (ViewObjectImpl)findViewObject("PublicSearchLawyersRO1");
    }

    /**
     * Container's getter for PublicSearchTranslatorsRO1.
     * @return PublicSearchTranslatorsRO1
     */
    public ViewObjectImpl getPublicSearchTranslatorsRO1() {
        return (ViewObjectImpl)findViewObject("PublicSearchTranslatorsRO1");
    }
    public static final int _ELIGIBLE_SERVICE_REQUEST = 0;
    public static final int _NON_ELIGIBLE_SERVICE_REQUEST = 1;
    public static final int _CASE_SAVED = 1180;
    public static final int _CASE_JUDJED = 1178;
    
    public int validateServiceEligibility(Number serviceId, Number caseNo, Number caseYear, Number caseProsecId, Number emiratesId)
    {
      ViewObjectImpl checkEligibilityVO = getValidateServiceEligibilityRO1();
      if (checkEligibilityVO.getNamedWhereClauseParam("p_cno") == null) {
        caseNo = new Number(123456);
      }
      if (checkEligibilityVO.getNamedWhereClauseParam("p_cyear") == null) {
        caseYear = new Number(2010);
      }
      if (checkEligibilityVO.getNamedWhereClauseParam("p_prosid") == null) {
        caseProsecId = new Number(943);
      }
      if (checkEligibilityVO.getNamedWhereClauseParam("p_uemid") == null) {
        emiratesId = new Number(784195874603590L);
      }
      checkEligibilityVO.setNamedWhereClauseParam("p_cno", caseNo);
      checkEligibilityVO.setNamedWhereClauseParam("p_cyear", caseYear);
      checkEligibilityVO.setNamedWhereClauseParam("p_prosid", caseProsecId);
      checkEligibilityVO.setNamedWhereClauseParam("p_uemid", emiratesId);
      checkEligibilityVO.executeQuery();
      RowSetIterator rs = checkEligibilityVO.getRowSetIterator();
      if (rs.hasNext())
      {
        Row caseInfo = rs.next();
        int caseStatusCode = ((Number)caseInfo.getAttribute("EventStatusLkp")).intValue();
        switch (serviceId.intValue())
        {
        case 1: 
          if (1178 == caseStatusCode) {
            return 0;
          }
          break;
        case 1001: 
          if (1178 == caseStatusCode) {
            return 0;
          }
          break;
        case 31: 
          if (1178 == caseStatusCode) {
            return 0;
          }
          break;
        case 26: 
          if (1178 == caseStatusCode) {
            return 0;
          }
          break;
        case 1026: 
          if (1178 == caseStatusCode) {
            return 0;
          }
          break;
        case 1031: 
          if (1178 == caseStatusCode) {
            return 0;
          }
          break;
        case 7: 
          if (1180 == caseStatusCode) {
            return 0;
          }
          break;
        case 1007: 
          if (1180 == caseStatusCode) {
            return 0;
          }
          break;
        case 8: 
          if (1180 == caseStatusCode) {
            return 0;
          }
          break;
        case 1008: 
          if (1180 == caseStatusCode) {
            return 0;
          }
          break;
        default: 
          return 0;
        }
      }
      return 1;
    }
    
    public void sendSMSProcedureCall(String uMobNo, Number reqId, String subject)
    {
      String subj = null;
      
      DBTransactionImpl dbti = (DBTransactionImpl)getDBTransaction();
      CallableStatement statement = dbti.createCallableStatement("BEGIN SENDSMS_PORTAL(?,?);END;", 0);
      try
      {
        statement.setString(1, uMobNo);
        statement.setString(2, subj);
        statement.execute(); return;
      }
      catch (SQLException sqlerr)
      {
        throw new JboException(sqlerr);
      }
      finally
      {
        try
        {
          if (statement != null) {
            statement.close();
          }
        }
        catch (SQLException closeerr)
        {
          throw new JboException(closeerr);
        }
      }
    }
    
    public UserBean valdiateLoginData(String email, String password, String dateOfBirth)
    {
      UserBean user = null;
      ViewObjectImpl userVO = getValidateUserLogin1();
      userVO.setNamedWhereClauseParam("em", email);
      userVO.setNamedWhereClauseParam("pwrd", password);
      userVO.setNamedWhereClauseParam("dob", dateOfBirth);
      userVO.executeQuery();
      RowSetIterator rs = userVO.getRowSetIterator();
      if (rs.hasNext())
      {
        Row userRow = rs.next();
        user = new UserBean();
        user.setEmail(email);
        user.setDateOfBirthAsString(dateOfBirth);
        user.setEmiratesId((String)userRow.getAttribute(ValidateUserLoginRowImpl.EMIRATESID));
        user.setFirstName((String)userRow.getAttribute(ValidateUserLoginRowImpl.FIRSTNAME));
        user.setLastName((String)userRow.getAttribute(ValidateUserLoginRowImpl.LASTNAME));
        user.setMobileNumber((String)userRow.getAttribute(ValidateUserLoginRowImpl.MOBILE));
        user.setFullName((String)userRow.getAttribute(ValidateUserLoginRowImpl.FIRSTNAME) + " " + (String)userRow.getAttribute(ValidateUserLoginRowImpl.LASTNAME));
        user.setPreferedLocale((String)userRow.getAttribute(ValidateUserLoginRowImpl.REGISTRATIONLANG));
        user.setNationality((String)userRow.getAttribute(ValidateUserLoginRowImpl.NATIONALITY));
        user.setOccupation((String)userRow.getAttribute(ValidateUserLoginRowImpl.OCCUPATION));
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date dateOfBirthAsDate = new Date();
        try
        {
          dateOfBirthAsDate = formatter.parse(dateOfBirth);
          user.setDateOfBirthAsDate(dateOfBirthAsDate);
        }
        catch (ParseException e)
        {
          e.printStackTrace();
        }
      }
      return user;
    }
}
