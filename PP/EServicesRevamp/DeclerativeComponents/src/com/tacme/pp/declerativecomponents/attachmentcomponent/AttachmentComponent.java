package com.tacme.pp.declerativecomponents.attachmentcomponent;

import org.apache.myfaces.trinidad.context.RequestContext;

import java.util.ArrayList;

import javax.el.MethodExpression;

import javax.faces.context.FacesContext;

import oracle.adf.view.rich.component.rich.fragment.RichDeclarativeComponent;


public class AttachmentComponent
  extends RichDeclarativeComponent
{
  public Boolean getMandatory()
  {
    return (Boolean)getAttributes().get("mandatory");
  }
  
  public ArrayList getAttachmentListValue()
  {
    return (ArrayList)getAttributes().get("attachmentListValue");
  }
  
  public MethodExpression getClearAttachments()
  {
    return (MethodExpression)getAttributes().get("clearAttachments");
  }
  
  public void setClearAttachments(MethodExpression me)
  {
    getAttributes().put("clearAttachments", me);
  }
  
  public String handleClearAttachments()
  {
    RequestContext.getCurrentInstance().partialUpdateNotify(this);
    MethodExpression me = getClearAttachments();
    if (me != null) {
      return (String)me.invoke(FacesContext.getCurrentInstance().getELContext(), new Object[0]);
    }
    return null;
  }
}
