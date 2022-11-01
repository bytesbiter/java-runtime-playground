package io.bytesbiter.servlet.servletsampleone;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.ServletResponse;

import java.io.*;
import java.util.Locale;

public class OneResponse implements ServletResponse {

    private static final int BUFFER_SIZE = 1024;
    OneRequest request;
    OutputStream output;

    public OneResponse(OutputStream output) {
        this.output = output;
    }

    public void setRequest(OneRequest request) {
        this.request = request;
    }

    public void sendStaticResource() {

        try {
            File file = new File(OneHttpServer.WEB_ROOT + request.getUri());
            PrintWriter printWriter = new PrintWriter(output);
            BufferedReader reader = new BufferedReader(new FileReader(file));

            // print HTTP headers
            printWriter.println("HTTP/1.1 200 OK");
            printWriter.println("Content-Type: text/html");
            printWriter.println("Content-Length: " + file.length());
            printWriter.println("\r\n");

            // line to go line by line from file
            String line = reader.readLine();
            // repeat till the file is read
            while (line != null) {
                // print current line
                printWriter.println(line);
                // read next line
                line = reader.readLine();
            }
            reader.close();
            printWriter.close();

        } catch (Exception e) {
            // thrown if cannot instantiate a File object
            System.out.println(e);
        }
    }

    @Override
    public String getCharacterEncoding() {
        return null;
    }

    @Override
    public String getContentType() {
        return null;
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        return null;
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return null;
    }

    @Override
    public void setCharacterEncoding(String s) {

    }

    @Override
    public void setContentLength(int i) {

    }

    @Override
    public void setContentLengthLong(long l) {

    }

    @Override
    public void setContentType(String s) {

    }

    @Override
    public void setBufferSize(int i) {

    }

    @Override
    public int getBufferSize() {
        return 0;
    }

    @Override
    public void flushBuffer() throws IOException {

    }

    @Override
    public void resetBuffer() {

    }

    @Override
    public boolean isCommitted() {
        return false;
    }

    @Override
    public void reset() {

    }

    @Override
    public void setLocale(Locale locale) {

    }

    @Override
    public Locale getLocale() {
        return null;
    }
}
