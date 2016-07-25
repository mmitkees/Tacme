import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.faces.event.ValueChangeEvent;


import oracle.adf.model.BindingContext;

import oracle.adf.view.rich.util.ResetUtils;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import org.apache.myfaces.trinidad.model.UploadedFile;

public class publishNews {
    public publishNews() {
    }
    
    /*****Generic Method to Get BindingContainer**/
        public BindingContainer getBindingsCont() {
            return BindingContext.getCurrent().getCurrentBindingsEntry();
        }

        /**
         * Generic Method to execute operation
         * */
        public OperationBinding executeOperation(String operation) {
            OperationBinding createParam = getBindingsCont().getOperationBinding(operation);
            return createParam;

        }

    public void UploadNews(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
                    //Get File Object from VC Event
                    UploadedFile fileVal = (UploadedFile) vce.getNewValue();
                    //Upload File to path- Return actual server path
                    String path = uploadFile(fileVal);
                    System.out.println(fileVal.getContentType());
                    //Method to insert data in table to keep track of uploaded files
                    OperationBinding ob = executeOperation("setImagePath");                    
                    ob.getParamsMap().put("path", path);                    
                    ob.execute();                    
                }
    }
    
    /**Method to upload file to actual path on Server*/
        private String uploadFile(UploadedFile file) {

            UploadedFile myfile = file;
            String path = null;
            if (myfile == null) {

            } else {
                // All uploaded files will be stored in below path
                path = "C:\\PPWTMiddleware\\PPAlain_WT1\\instances\\instance1\\config\\OHS\\AlAinOhs1\\htdocs\\News\\images" + myfile.getFilename();
                InputStream inputStream = null;
                try {
                    FileOutputStream out = new FileOutputStream(path);
                    inputStream = myfile.getInputStream();
                    byte[] buffer = new byte[8192];
                    int bytesRead = 0;
                    while ((bytesRead = inputStream.read(buffer, 0, 8192)) != -1) {
                        out.write(buffer, 0, bytesRead);
                    }
                    out.flush();
                    out.close();
                } catch (Exception ex) {
                    // handle exception
                    ex.printStackTrace();
                } finally {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                    }
                }

            }
            //Returns the path where file is stored
            return path;
        }
}
