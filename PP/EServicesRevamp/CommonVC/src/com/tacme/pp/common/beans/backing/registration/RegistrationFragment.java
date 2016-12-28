package com.tacme.pp.common.beans.backing.registration;

import com.tacme.pp.common.utils.ADFUtils;
import com.tacme.pp.common.utils.JSFUtils;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import oracle.adf.model.BindingContext;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

public class RegistrationFragment
{
  private RichInputText passwordRetypeIt;
  private RichInputText globalMsgIt;
  private RichInputText passwordIt;
  
  public void setPasswordRetypeIt(RichInputText passwordRetypeIt)
  {
    this.passwordRetypeIt = passwordRetypeIt;
  }
  
  public RichInputText getPasswordRetypeIt()
  {
    return this.passwordRetypeIt;
  }
  
  public void setGlobalMsgIt(RichInputText globalMsgIt)
  {
    this.globalMsgIt = globalMsgIt;
  }
  
  public RichInputText getGlobalMsgIt()
  {
    return this.globalMsgIt;
  }
  
  public void setPasswordIt(RichInputText passwordIt)
  {
    this.passwordIt = passwordIt;
  }
  
  public RichInputText getPasswordIt()
  {
    return this.passwordIt;
  }
  
  public void validatePasswordRetype(FacesContext facesContext, UIComponent uIComponent, Object object)
  {
    String password = this.passwordIt.getValue().toString();
    String retype = (String)object;
    String errorMsg = (String)ADFUtils.evaluateEL("#{CommonBundle.REGESTRATION_ERROR_PASSWORD_RETYPE}");
    if (!password.equals(retype)) {
      JSFUtils.showFacesErrorMessageForComponent(uIComponent, errorMsg);
    }
  }
  
  public BindingContainer getBindings()
  {
    return BindingContext.getCurrent().getCurrentBindingsEntry();
  }
  
  public String createUser_action()
  {
    BindingContainer bindings = getBindings();
    OperationBinding operationBinding = bindings.getOperationBinding("Commit");
    Object result = operationBinding.execute();
    if (!operationBinding.getErrors().isEmpty()) {
      return null;
    }
    String msg = operationBinding.getErrors().get(0).toString();
    JSFUtils.showFacesErrorMessage(msg);
    
    return null;
  }
}
