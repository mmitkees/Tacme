package com.tacme.pp.common.beans.backing.login;

import com.tacme.pp.common.beans.ServiceBean;
import java.util.Date;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.output.RichOutputText;

public class LoginFragment
  extends ServiceBean
{
  private RichPanelGroupLayout pgl1;
  private RichPanelGroupLayout pgl2;
  private RichPanelGroupLayout pgl3;
  private RichPanelGroupLayout pgl4;
  private RichOutputText ot1;
  private RichOutputText ot2;
  private RichOutputText ot3;
  private RichInputText it1;
  private RichInputText it2;
  private RichInputDate id1;
  
  public void setPgl1(RichPanelGroupLayout pgl1)
  {
    this.pgl1 = pgl1;
  }
  
  public RichPanelGroupLayout getPgl1()
  {
    return this.pgl1;
  }
  
  public void setPgl2(RichPanelGroupLayout pgl2)
  {
    this.pgl2 = pgl2;
  }
  
  public RichPanelGroupLayout getPgl2()
  {
    return this.pgl2;
  }
  
  public void setPgl3(RichPanelGroupLayout pgl3)
  {
    this.pgl3 = pgl3;
  }
  
  public RichPanelGroupLayout getPgl3()
  {
    return this.pgl3;
  }
  
  public void setPgl4(RichPanelGroupLayout pgl4)
  {
    this.pgl4 = pgl4;
  }
  
  public RichPanelGroupLayout getPgl4()
  {
    return this.pgl4;
  }
  
  public void setOt1(RichOutputText ot1)
  {
    this.ot1 = ot1;
  }
  
  public RichOutputText getOt1()
  {
    return this.ot1;
  }
  
  public void setOt2(RichOutputText ot2)
  {
    this.ot2 = ot2;
  }
  
  public RichOutputText getOt2()
  {
    return this.ot2;
  }
  
  public void setOt3(RichOutputText ot3)
  {
    this.ot3 = ot3;
  }
  
  public RichOutputText getOt3()
  {
    return this.ot3;
  }
  
  public void setIt1(RichInputText it1)
  {
    this.it1 = it1;
  }
  
  public RichInputText getIt1()
  {
    return this.it1;
  }
  
  public void setIt2(RichInputText it2)
  {
    this.it2 = it2;
  }
  
  public RichInputText getIt2()
  {
    return this.it2;
  }
  
  public void setId1(RichInputDate id1)
  {
    this.id1 = id1;
  }
  
  public RichInputDate getId1()
  {
    return this.id1;
  }
  
  public String loginAction()
  {
    Date dob = (Date)this.id1.getValue();
    String dobString = formatDateString(dob);
    
    return doLogin(this.it1.getValue().toString(), this.it2.getValue().toString(), dobString);
  }
}
