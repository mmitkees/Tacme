package com.tacme.pp.common.beans;

import java.io.InputStream;

public class UCMDocument
{
  private String dID;
  private String dDocname;
  private String docURI;
  private String fileName;
  private String fileFormat;
  private String documentTypeCode;
  private InputStream inputStream;
  private String parentFolderName;
  
  public UCMDocument(String dID, String docURI)
  {
    this.dID = dID;
    this.docURI = docURI;
  }
  
  public UCMDocument() {}
  
  public void setDID(String dID)
  {
    this.dID = dID;
  }
  
  public String getDID()
  {
    return this.dID;
  }
  
  public void setDocURI(String docURI)
  {
    this.docURI = docURI;
  }
  
  public String getDocURI()
  {
    return this.docURI;
  }
  
  public void setFileName(String fileName)
  {
    this.fileName = fileName;
  }
  
  public String getFileName()
  {
    return this.fileName;
  }
  
  public void setFileFormat(String fileFormat)
  {
    this.fileFormat = fileFormat;
  }
  
  public String getFileFormat()
  {
    return this.fileFormat;
  }
  
  public void setDocumentTypeCode(String documentTypeCode)
  {
    this.documentTypeCode = documentTypeCode;
  }
  
  public String getDocumentTypeCode()
  {
    return this.documentTypeCode;
  }
  
  public void setInputStream(InputStream inputStream)
  {
    this.inputStream = inputStream;
  }
  
  public InputStream getInputStream()
  {
    return this.inputStream;
  }
  
  public void setParentFolderName(String folderName)
  {
    this.parentFolderName = folderName;
  }
  
  public String getParentFolderName()
  {
    return this.parentFolderName;
  }
  
  public void setDDocname(String dDocname)
  {
    this.dDocname = dDocname;
  }
  
  public String getDDocname()
  {
    return this.dDocname;
  }
}
