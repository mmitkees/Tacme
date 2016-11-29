import com.pp.component.view.utils.EmailUtils;

import java.util.Locale;

import javax.faces.application.FacesMessage;

import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import oracle.adf.model.BindingContext;



import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import view.utils.ADFUtils;

import view.utils.JSFUtils;

public class AddComplainBKBean {
    public AddComplainBKBean() {
    }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public String addComplain() {
        
        BindingContainer bindings = getBindings();
        OperationBinding operationIsDuplicate=ADFUtils.findOperation("isDuplicate");
        
        operationIsDuplicate.getParamsMap().put("cid", Integer.parseInt((String)ADFUtils.getBoundAttributeValue("Id")));
 //   
        boolean isDuplicate=(Boolean)operationIsDuplicate.execute();
        if(isDuplicate){
            JSFUtils.addFacesErrorMessage(JSFUtils.resolveExpressionAsString("#{suggestionscomplainsvcBundle.Already_exist}"));

        }else{
            OperationBinding operationBindingCommit = bindings.getOperationBinding("Commit");
            Object result = operationBindingCommit.execute();
            JSFUtils.addFacesInformationMessage(JSFUtils.resolveExpressionAsString("#{suggestionscomplainsvcBundle.Confirmation}"));
            String to = (String)ADFUtils.getBoundAttributeValue("SenderEmail");
            String subj = JSFUtils.resolveExpressionAsString("#{suggestionscomplainsvcBundle.Confirmation}");
            
            
            String EmailBody="";
            Locale locale =null;
            String lo;
            try{
                FacesContext ctx = JSFUtils.getFacesContext();
                    UIViewRoot uiRoot = ctx.getViewRoot();
                     locale = uiRoot.getLocale();
                lo= locale.getLanguage();

            }catch (Exception e){
                 lo = (String)ADFUtils.evaluateEL("#{pageFlowScope.locale}");
            }
            finally {
                EmailBody += JSFUtils.resolveExpressionAsString("#{suggestionscomplainsvcBundle.EmailFormat}");
                EmailBody += JSFUtils.resolveExpressionAsString("#{suggestionscomplainsvcBundle.EmailBody}");
                EmailBody += (String)ADFUtils.getBoundAttributeValue("Id");
                EmailBody += "<br/>";
                EmailBody +=  JSFUtils.resolveExpressionAsString("#{suggestionscomplainsvcBundle.MsgBody}");
                EmailBody +=  (String)ADFUtils.getBoundAttributeValue("MessageBody");
                EmailBody +="</p>";
                EmailUtils.sendEmail(to, subj, EmailBody); 
            }
            

         
            
            
  
        }
      
        return null;
    }
}
