import com.app.view.utils.ADFUtils;

import com.app.view.utils.JSFUtils;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.ApplicationModule;
import oracle.jbo.ViewObject;

public class searchCase implements Serializable{
    @SuppressWarnings("compatibility:-605309331823206964")
    private static final long serialVersionUID = 1L;
    private RichInputText it1;
    private BigDecimal caseNo;
    private Object caseLocation;
    private BigDecimal caseYear;
    private RichInputText it2;
    private RichTable t1;
    private RichSelectOneChoice soc1;
    private String caseno = "N";
    private String caseyear = "N";
    private String locofcase = "N";

    public searchCase() {
    }

    public void setIt1(RichInputText it1) {
        this.it1 = it1;
    }

    public RichInputText getIt1() {
        return it1;
    }   

    public void setIt2(RichInputText it2) {
        this.it2 = it2;
    }

    public RichInputText getIt2() {
        return it2;
    }

    public void onLocationChange(ValueChangeEvent valueChangeEvent) {
        System.out.println("new value of location is ......." + valueChangeEvent.getNewValue());
            if (null != valueChangeEvent.getNewValue()) {
                setCaseLocation(valueChangeEvent.getNewValue());
            }
        // Add event code here...
    }  

    public String onSearchCase() {
//        StringBuilder whereClause=new StringBuilder();
//       
//        if (null != getCaseNo())
//        {
//            if (whereClause.length() != 0)
//            whereClause=whereClause.append(" and");
//            whereClause=whereClause.append(" Case_No=" + getCaseNo()); 
//        }
//        if (null != getCaseLocation())
//        {
//            if (whereClause.length() != 0)
//                whereClause=whereClause.append(" and");
//           
//            whereClause=whereClause.append(" Case_City_Id=" + getCaseLocation() );
//        }
//        if (null != getCaseYear())
//        {
//            if (whereClause.length() != 0)
//                whereClause=whereClause.append(" and");
//          
//            whereClause=whereClause.append(" Case_Year='" + getCaseYear() +"'");
//        }
//        ApplicationModule am=ADFUtils.getApplicationModuleForDataControl("PPAppServicesDataControl");
//        ViewObject vo=am.findViewObject("CaseSearchROVO1");
//        vo.setWhereClause(null);
//        vo.setWhereClause(whereClause.toString());
//        System.out.println("Query is......." + vo.getQuery());
//        vo.executeQuery();
//        AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
//        adfFacesContext.getCurrentInstance().addPartialTarget(t1);
        // Add event code here...
        if (it1.getValue() != null && it2.getValue() !=null && soc1.getValue() != null){
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding =
            bindings.getOperationBinding("srchCases");
        operationBinding.execute();
        }
        if (it1.getValue() == null){
            caseno = "Y";
        }
        if (it2.getValue() == null){
            caseyear = "Y";
        }
        if (soc1.getValue() == null){
            locofcase = "Y";
        }
        return null;
    }
    
    public String onClearSearchCase() {        
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding =
            bindings.getOperationBinding("clearsrchCases");
        operationBinding.execute();        
        return "reset";
    }
    
    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    

    public String onSearchCaseClear() {
        
        return null;
    }

    public void setT1(RichTable t1) {
        this.t1 = t1;
    }

    public RichTable getT1() {
        return t1;
    }

    public void setSoc1(RichSelectOneChoice soc1) {
        this.soc1 = soc1;
    }

    public RichSelectOneChoice getSoc1() {
        return soc1;
    }

    public void setCaseno(String caseno) {
        this.caseno = caseno;
    }

    public String getCaseno() {
        return caseno;
    }

    public void setCaseyear(String caseyear) {
        this.caseyear = caseyear;
    }

    public String getCaseyear() {
        return caseyear;
    }

    public void setLocofcase(String locofcase) {
        this.locofcase = locofcase;
    }

    public String getLocofcase() {
        return locofcase;
    }

    public void setCaseNo(BigDecimal caseNo) {
        this.caseNo = caseNo;
    }

    public BigDecimal getCaseNo() {
        return caseNo;
    }

    public void setCaseLocation(Object caseLocation) {
        this.caseLocation = caseLocation;
    }

    public Object getCaseLocation() {
        return caseLocation;
    }

    public void setCaseYear(BigDecimal caseYear) {
        this.caseYear = caseYear;
    }

    public BigDecimal getCaseYear() {
        return caseYear;
    }
}
