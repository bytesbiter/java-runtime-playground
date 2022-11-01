package io.bytesbiter.servlet.webserversample;

import java.io.*;

public class WebserverSampleResponse {

    private static final int BUFFER_SIZE = 1024;
    WebserverSampleRequest request;
    OutputStream output;

    public WebserverSampleResponse(OutputStream output) {
        this.output = output;
    }
    public void setRequest(WebserverSampleRequest request) {
        this.request = request;
    }
    public void sendStaticResource() {

        try {
            File file = new File(WebserverSampleHttpServer.WEB_ROOT + request.getUri());
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
}
