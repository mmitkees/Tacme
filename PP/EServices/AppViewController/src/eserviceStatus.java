import com.tacme.pp.common.utils.ADFUtils; 

import com.tacme.pmr.beans.PaymentStatusResponse;

import com.tacme.pmr.wrapper.PaymentWrapper;

import java.io.Serializable;

import javax.faces.event.ActionEvent;

import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.event.QueryEvent;
import oracle.adf.view.rich.model.FilterableQueryDescriptor;

import oracle.jbo.Row;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;

public class eserviceStatus implements Serializable{
    @SuppressWarnings("compatibility:-1929938287447544952")
    private static final long serialVersionUID = 1L;
    private RichTable empTable;
    private ADFUtils adfUtils = new ADFUtils();
    private RichPopup downloadUrlPopup;
   private PaymentStatusResponse paymentDetails;
    private RichPopup paymentPopup;
    

    public eserviceStatus() {
    }

    public String filter_action() {
        FilterableQueryDescriptor queryDescriptor =
                    (FilterableQueryDescriptor) getEmpTable().getFilterModel();
                if (queryDescriptor != null && queryDescriptor.getFilterCriteria() != null)
                {
                    queryDescriptor.getFilterCriteria().clear();
                    getEmpTable().queueEvent(new QueryEvent(getEmpTable(), queryDescriptor));
                }
        return null;
    }

    public void setEmpTable(RichTable empTable) {
        this.empTable = empTable;
    }

    public RichTable getEmpTable() {
        return empTable;
    }

    public void setDownloadUrl() {
        // Add event code here...
    }

    public void downloadAttachment(ActionEvent actionEvent) {
        ViewObject reqStatusView = adfUtils.getApplicationModuleForDataControl("PPAppServicesDataControl").findViewObject("ReqRequestsStatusView1");
        ViewObjectImpl downloadUrlView = (ViewObjectImpl)adfUtils.getApplicationModuleForDataControl("PPAppServicesDataControl").findViewObject("downloadUrl1");
        Row reqStatusRow = reqStatusView.getCurrentRow();
        if (reqStatusRow != null){
            String reqid = reqStatusRow.getAttribute("ReqId").toString();
            ViewCriteria downloadUrlVc = downloadUrlView.getViewCriteria("downloadUrlCriteria");
            downloadUrlView.applyViewCriteria(downloadUrlVc);
            downloadUrlView.setNamedWhereClauseParam("p_rid", reqid);
            downloadUrlView.executeQuery();
            RichPopup.PopupHints hints = new RichPopup.PopupHints();
            getDownloadUrlPopup().show(hints);
        }
    }

    public void setDownloadUrlPopup(RichPopup downloadUrlPopup) {
        this.downloadUrlPopup = downloadUrlPopup;
    }

    public RichPopup getDownloadUrlPopup() {
        return downloadUrlPopup;
    }

    public void showPaymentInfoActionListner(ActionEvent actionEvent) {
        // Add event code here...
        paymentDetails=null;
        String CurrentInvoice = (String)ADFUtils.evaluateEL("#{pageFlowScope.CurrentInvoice}");
        PaymentWrapper payment= new PaymentWrapper();
        paymentDetails= payment.getAndUpdatePaymentStatus(CurrentInvoice);
      //  System.out.println(paymentDetails.getTransactionResponseDate());
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
            getPaymentPopup().show(hints);
    }

    public void setPaymentDetails(PaymentStatusResponse res) {
        this.paymentDetails = res;
    }

    public PaymentStatusResponse getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentPopup(RichPopup paymentPopup) {
        this.paymentPopup = paymentPopup;
    }

    public RichPopup getPaymentPopup() {
        return paymentPopup;
    }

    public void logout(ActionEvent actionEvent) {
        // Add event code here...
        ADFContext.getCurrent().getSessionScope().put("login", "");
    }
}
