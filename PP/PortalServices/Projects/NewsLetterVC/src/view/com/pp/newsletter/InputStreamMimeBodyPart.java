package view.com.pp.newsletter;

import java.io.IOException;
import java.io.InputStream;

import java.io.OutputStream;

import java.util.Enumeration;

import javax.activation.DataHandler;

import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeMessage;

public class InputStreamMimeBodyPart extends BodyPart {
    private InputStream inputStream;

    public InputStreamMimeBodyPart(InputStream source) {
        this.inputStream = source;
        if (!inputStream.markSupported()) {
            throw new IllegalArgumentException("only streams with mark supported are ok");
        }
        inputStream.mark(Integer.MAX_VALUE); // remeber the whole stream.
    }

    


    protected InputStream getContentStream() throws MessagingException {
        throw new IllegalStateException("getContentStream is not implemented on purpose.");
    }

    @Override
    public void writeTo(OutputStream os) throws IOException,
                                                MessagingException {
        System.out.println("writing to somewhere.");
        byte[] buf = new byte[32];
        int length;
        inputStream.reset();
        while ((length = inputStream.read(buf)) > -1) {
            os.write(buf, 0, length);
        }
    }

    public int getSize() {
        return 0;
    }

    public int getLineCount() {
        return 0;
    }

    public String getContentType() {
        return null;
    }

    public boolean isMimeType(String string) {
        return false;
    }

    public String getDisposition() {
        return null;
    }

    public void setDisposition(String string) {
    }

    public String getDescription() {
        return null;
    }

    public void setDescription(String string) {
    }

    public String getFileName() {
        return null;
    }

    public void setFileName(String string) {
    }

    public InputStream getInputStream() {
        return null;
    }

    public DataHandler getDataHandler() {
        return null;
    }

    public Object getContent() {
        return null;
    }

    public void setDataHandler(DataHandler dataHandler) {
    }

    public void setContent(Object object, String string) {
    }

    public void setContent(Multipart multipart) {
    }

    public void setText(String string) {
    }

    public String[] getHeader(String string) {
        return new String[0];
    }

    public void setHeader(String string, String string1) {
    }

    public void addHeader(String string, String string1) {
    }

    public void removeHeader(String string) {
    }

    public Enumeration getAllHeaders() {
        return null;
    }

    public Enumeration getMatchingHeaders(String[] strings) {
        return null;
    }

    public Enumeration getNonMatchingHeaders(String[] strings) {
        return null;
    }
}
