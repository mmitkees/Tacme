package com.tacme.pp.common.beans.backing.casecommonfields;


import javax.faces.component.UISelectItems;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

public class CaseCommonFieldsFragment
{
  private RichSelectOneChoice soc1;
  private UISelectItems si1;
  private UISelectItems si2;
  
  public void setSoc1(RichSelectOneChoice soc1)
  {
    this.soc1 = soc1;
  }
  
  public RichSelectOneChoice getSoc1()
  {
    return this.soc1;
  }
  
  public void setSi1(UISelectItems si1)
  {
    this.si1 = si1;
  }
  
  public UISelectItems getSi1()
  {
    return this.si1;
  }
  
  public void setSi2(UISelectItems si2)
  {
    this.si2 = si2;
  }
  
  public UISelectItems getSi2()
  {
    return this.si2;
  }
}
