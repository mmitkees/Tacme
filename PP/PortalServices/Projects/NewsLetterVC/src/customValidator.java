import java.util.Iterator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import oracle.adf.view.rich.component.rich.input.RichInputText;

import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

public class customValidator {
    public customValidator() {
    }

    public void emailValidator(FacesContext facesContext,
                               UIComponent uIComponent, Object object) {
        String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        String email = object.toString();
        Boolean b = email.matches(EMAIL_REGEX);
        if (b.equals(false)){
            onSetFocus("em1");
                        throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email not valid",
                                                                      "Enter valid email address"));
        }
    }
    
    private void onSetFocus(String component) {
        RichInputText rit = (RichInputText)findComponentInRoot(component);
        if (rit != null) {
            // Use client id to ensure component is found if located in naming container
            FacesContext fctx = FacesContext.getCurrentInstance();
            String clientId = rit.getClientId(fctx);
            StringBuilder script = new StringBuilder();
            
            script.append("var textInput = ");
            script.append("AdfPage.PAGE.findComponentByAbsoluteId");
            script.append ("('" + clientId + "');");    
            script.append("if(textInput != null){");            
            script.append("textInput.focus();");
            script.append("}");
            
            ExtendedRenderKitService erks = null;
            erks = Service.getRenderKitService(fctx, ExtendedRenderKitService.class);
            erks.addScript(fctx, script.toString());
        }
    }
    
    private RichInputText findComponentInRoot(String componentId) {
        UIComponent component = null;
        FacesContext facesContext = FacesContext.getCurrentInstance();
        if (facesContext != null) {
          UIComponent root = facesContext.getViewRoot();
          component = findComponent(root, componentId);
        }
        return (RichInputText)component;
    }

    private UIComponent findComponent(UIComponent base, String id) {
        if (id.equals(base.getId()))
          return base;
        
        UIComponent kid = null;
        UIComponent result = null;
        Iterator kids = base.getFacetsAndChildren();
        while (kids.hasNext() && (result == null)) {
          kid = (UIComponent) kids.next();
          if (id.equals(kid.getId())) {
            result = kid;
            break;
          }
          result = findComponent(kid, id);
          if (result != null) {
            break;
          }
        }
        return result;
    }
}
