package view.beans;

import java.sql.CallableStatement;
import java.sql.SQLException;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;

import model.services.SMSPrjServiceImpl;

import oracle.jbo.JboException;
import oracle.jbo.server.DBTransactionImpl;

public class SmsBean {
    public SmsBean() {
        super();
    }
    
    public void executeSMSproc(String p_mobno, String p_subj) {
//            try{
//            DBTransactionImpl dbti = (DBTransactionImpl)getDBTransaction();
//            CallableStatement statement =
//                dbti.createCallableStatement(("BEGIN " + "PROC_SENDSMS(?,?);" +
//                                              "END;"), 0);
//            try {
//                statement.setString(1, p_mobno);
//                statement.setString(2, p_subj);                
//                statement.execute();
//            } catch (SQLException sqlerr) {
//                throw new JboException(sqlerr);
//            } finally {
//                try {
//                    if (statement != null) {
//                        statement.close();
//                    }
//                } catch (SQLException closeerr) {
//                    throw new JboException(closeerr);
//                }
//            }
//            }catch (Exception e){
//                e.printStackTrace();
//            }
        }
    
    public SMSPrjServiceImpl getAm() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Application app = fc.getApplication();
        ExpressionFactory elFactory = app.getExpressionFactory();
        ELContext elContext = fc.getELContext();
        ValueExpression valueExp =
            elFactory.createValueExpression(elContext, "#{data.PPAppServicesDataControl.dataProvider}",
                                            Object.class);
        return (SMSPrjServiceImpl)valueExp.getValue(elContext);
    }

}
