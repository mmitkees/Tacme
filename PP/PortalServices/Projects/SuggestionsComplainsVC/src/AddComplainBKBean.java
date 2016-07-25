import javax.faces.application.FacesMessage;

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
  
        }
      
        return null;
    }
}
