package io.bytesbiter.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CustomResponse {

    private static final int BUFFER_SIZE = 1024;
    CustomRequest request;
    OutputStream output;

    public CustomResponse(OutputStream output) {
        this.output = output;
    }
    public void setRequest(CustomRequest request) {
        this.request = request;
    }
    public void sendStaticResource() throws IOException {
        byte[] bytes = new byte[BUFFER_SIZE];
        FileInputStream fis = null;
        try {
            File file = new File(CustomHttpServer.WEB_ROOT);
            if (file.exists()) {
                fis = new FileInputStream(file);
                int ch = fis.read(bytes, 0, BUFFER_SIZE);
                while (ch!=-1) {
                    output.write(bytes, 0, ch);
                    ch = fis.read(bytes, 0, BUFFER_SIZE);
                }
            } else {
                // file not found
                String errorMessage = "HTTP/1.1 404 File Not Found\r\n" + "Content-Type: text/html\r\n" + "Content-Length: 23\r\n" +"\r\n" +"<h1>File Not Found</h1>";
                output.write(errorMessage.getBytes());
            } }catch (Exception e) {
            // thrown if cannot instantiate a File object
            System.out.println(e);
        } finally {
            if (fis!=null) fis.close();
        }
    }
}
