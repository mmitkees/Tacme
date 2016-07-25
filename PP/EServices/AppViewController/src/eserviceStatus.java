import com.app.view.utils.ADFUtils;

import java.io.Serializable;

import javax.faces.event.ActionEvent;

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
}
