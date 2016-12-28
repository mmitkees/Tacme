package com.tacme.pp.common.beans;

//import attachmentComponent.AttachmentComponentComponent;
import com.tacme.pp.common.utils.ADFUtils;
import com.tacme.pp.common.utils.JSFUtils;
import com.tacme.pp.model.common.beans.UserBean;
import com.tacme.pp.model.common.service.PPAppModuleImpl;
import java.io.PrintStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.ADFContext;
import oracle.adf.share.security.SecurityContext;
import oracle.binding.OperationBinding;
import oracle.jbo.Row;
import oracle.jbo.domain.Number;
import org.apache.myfaces.trinidad.model.UploadedFile;

public abstract class ServiceBean
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  //private AttachmentComponentComponent ac1;
  protected List<UploadedFile> uploadedfiles;
  
//  public void setAc1(AttachmentComponentComponent ac1)
//  {
//    this.ac1 = ac1;
//  }
  
//  public AttachmentComponentComponent getAc1()
//  {
//    return this.ac1;
//  }
  
  private static List<String> allowedFiles = new ArrayList();
  
  static
  {
    allowedFiles.add("gif");
    allowedFiles.add("png");
    allowedFiles.add("jpeg");
    allowedFiles.add("pdf");
    allowedFiles.add("txt");
    allowedFiles.add("doc");
    allowedFiles.add("docx");
    allowedFiles.add("xlsx");
    allowedFiles.add("xls");
    allowedFiles.add("tiff");
    allowedFiles.add("tif");
    allowedFiles.add("jpg");
  }
  
  public String resetUploadedfile()
  {
    if (!this.uploadedfiles.isEmpty()) {
      this.uploadedfiles = null;
    }
    return null;
  }
  
  public ArrayList<String> validateUploadedFiles(List<UploadedFile> files)
  {
    ArrayList<String> msgs = new ArrayList();
    if (files != null) {
      for (UploadedFile file : files)
      {
        String msg = "";
        if (!allowedFiles.contains(getExtension(file.getFilename())))
        {
          msg = ADFUtils.evaluateEL("#{ErrorMsgBundle.ATTACHMENTS_WORNG_EXTENSION_FILE_NAME}") + file.getFilename();
          
          msgs.add(msg);
        }
        if (!checkFileSize(file))
        {
          msg = ADFUtils.evaluateEL("#{ErrorMsgBundle.ATTACHMENTS_REQUIREDATTACHMENTS_EXEEDED_FILE_SIZE}") + file.getFilename();
          
          msgs.add(msg);
        }
      }
    }
    return msgs;
  }
  
  private boolean checkFileSize(UploadedFile file)
  {
    if ((file != null) || (file.getLength() != 0L))
    {
      double bytes = file.getLength();
      double kilobytes = bytes / 1024.0D;
      double megabytes = kilobytes / 1024.0D;
      if (megabytes > 5.0D) {
        return false;
      }
    }
    else
    {
      System.out.println("File does not exists!");
      return false;
    }
    return true;
  }
  
  public String getUserNameFromSession()
  {
    SecurityContext context = ADFContext.getCurrent().getSecurityContext();
    return context.getUserName();
  }
  
  public String submit_form()
  {
    ArrayList<String> errors = validateUploadedFiles(this.uploadedfiles);
    errors.addAll(validateCaseValues());
    if (!errors.isEmpty()) {
//      JSFUtils.showFacesErrorMessages(this.ac1.getClientId(JSFUtils.getFacesContext()), errors);
    } else {
      try
      {
        checkInDocuments();
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    return null;
  }
  
  private String getExtension(String fileName)
  {
    int index = fileName.lastIndexOf(".");
    if (index > -1) {
      return fileName.substring(index + 1).toLowerCase();
    }
    return "";
  }
  
  public void sendSMS(String uMobNo, Number reqId, String subject)
  {
    PPAppModuleImpl ppam = (PPAppModuleImpl)ADFUtils.getApplicationModuleForDataControl("PPAppModule");
    
    ppam.sendSMSProcedureCall(uMobNo, reqId, subject);
  }
  
  public ArrayList<String> validateCaseValues()
  {
    ArrayList<String> msgs = new ArrayList();
    Row enteredValues = ADFUtils.findIterator("ValidateServiceEligibilityRO1Iterator").getCurrentRow();
    
    OperationBinding valdiateOp = ADFUtils.findOperation("validateServiceEligibility");
    
    Number serviceId = (Number)ADFUtils.evaluateEL("#{pageFlowScope.serviceId}");
    
    Number caseNo = (Number)enteredValues.getAttribute("Caseno");
    Number caseYear = (Number)enteredValues.getAttribute("Caseyear");
    Number Idcardno = (Number)ADFUtils.evaluateEL("#{user.emiratesId}");
    if (serviceId == null) {
      serviceId = new Number(0);
    }
    if (caseNo == null) {
      serviceId = new Number(0);
    }
    if (caseYear == null) {
      serviceId = new Number(0);
    }
    if (Idcardno == null) {
      serviceId = new Number(0);
    }
    valdiateOp.getParamsMap().put("serviceId", serviceId);
    valdiateOp.getParamsMap().put("caseNo", caseNo);
    valdiateOp.getParamsMap().put("caseYear", caseYear);
    valdiateOp.getParamsMap().put("emiratesId", Idcardno);
    
    valdiateOp.execute();
    if (valdiateOp.getResult() != null)
    {
      int result = ((Integer)valdiateOp.getResult()).intValue();
      if (result == 0) {
        return msgs;
      }
      switch (result)
      {
      case 1178: 
        msgs.add((String)ADFUtils.evaluateEL("#{ErrorMsgBundle.REQUEST_NOT_ELIGIBIBLE_CASE_JUDGED}"));
        break;
      case 1180: 
        msgs.add((String)ADFUtils.evaluateEL("#{ErrorMsgBundle.REQUEST_NOT_ELIGIBIBLE_CASE_SAVED}"));
        break;
      case 1: 
        msgs.add((String)ADFUtils.evaluateEL("#{ErrorMsgBundle.REQUEST_NOT_ELIGIBIBLE}"));
        break;
      default: 
        msgs.add((String)ADFUtils.evaluateEL("#{ErrorMsgBundle.REQUEST_NOT_ELIGIBIBLE}"));
      }
    }
    msgs.add((String)ADFUtils.evaluateEL("#{ErrorMsgBundle.REQUEST_NOT_ELIGIBIBLE}"));
    return msgs;
  }
  
  public String doLogin(String email, String password, String dob)
  {
    OperationBinding loginOp = ADFUtils.findOperation("valdiateLoginData");
    
    loginOp.getParamsMap().put("email", email);
    loginOp.getParamsMap().put("password", password);
    loginOp.getParamsMap().put("dateOfBirth", dob);
    loginOp.execute();
    if (loginOp.getResult() != null)
    {
      UserBean user = (UserBean)loginOp.getResult();
      FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("isLoggedIn", "true");
      ADFContext.getCurrent().getSessionScope().put("userData", user);
      
      return "loginSuccess";
    }
    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("isLoggedIn", "false");
    JSFUtils.showFacesErrorMessage((String)ADFUtils.evaluateEL("#{ErrorMsgBundle.LOGIN_FAILED}"));
    
    return null;
  }
  
  public String formatDateString(String date)
  {
    SimpleDateFormat formatter = new SimpleDateFormat((String)ADFUtils.evaluateEL("#{Patterns.datePattern}"));
    try
    {
      Date dateOfBirthAsDate = formatter.parse(date);
      return dateOfBirthAsDate.toString();
    }
    catch (ParseException e)
    {
      e.printStackTrace();
    }
    return null;
  }
  
  public String formatDateString(Date date)
  {
    SimpleDateFormat formatter = new SimpleDateFormat((String)ADFUtils.evaluateEL("#{Patterns.datePattern}"));
    try
    {
      String dateOfBirthAsDate = formatter.format(date);
      return dateOfBirthAsDate.toString();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return null;
  }
  
  public String doLogout()
  {
    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("isLoggedIn", "false");
    ADFUtils.setEL("#{sessionScopeBean.userData}", null);
    return "logoutSuccess";
  }
  
  public static long getSerialVersionUID()
  {
    return 1L;
  }
  
  public void setUploadedfiles(List<UploadedFile> uploadedfile)
  {
    this.uploadedfiles = uploadedfile;
  }
  
  public List<UploadedFile> getUploadedfiles()
  {
    return this.uploadedfiles;
  }
  
  protected void checkInDocuments()
    throws Exception
  {}
}
