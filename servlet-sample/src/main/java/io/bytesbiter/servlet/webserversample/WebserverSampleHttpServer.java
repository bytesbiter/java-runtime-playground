package io.bytesbiter.servlet.webserversample;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *  This class represents a webserver.
 */
public class WebserverSampleHttpServer {

    /** WEB_ROOT is the directory where our HTML and other files reside.
     * For this package, WEB_ROOT is the "webroot" directory under the
     * working directory.
     * The working directory is the location in the file system
     * from where the java command was invoked (where the JVM is running - which is the root directory of this project 'java-runtime-playgoround' ).
     */
//    public static final String WEB_ROOT = System.getProperty("user.dir") + File.separator + "servlet-sample/src/main/resources";
    public static final String WEB_ROOT = System.getProperty("user.dir") + File.separator;
    private static final String SHUTDOWN_COMMAND = "/shutdown";
    private boolean shutdown = false;

    public void await() {
        ServerSocket serverSocket = null;
        int port = 8080;
        try {
            serverSocket = new ServerSocket(port, 1, InetAddress.getLoopbackAddress());
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        // Loop waiting for a request
        while (!shutdown) {
            Socket socket;
            InputStream input;
            OutputStream output;
            try {
                socket = serverSocket.accept();
                input = socket.getInputStream();
                output = socket.getOutputStream();
                // create Request object and parse
                WebserverSampleRequest request = new WebserverSampleRequest(input);
                request.parse();
                // create Response object
                WebserverSampleResponse response = new WebserverSampleResponse(output);
                response.setRequest(request);
                response.sendStaticResource();
                // Close the socket
                socket.close();
                //check if the previous URI is a shutdown command
                shutdown = request.getUri().equals(SHUTDOWN_COMMAND);
            } catch (Exception e) {
                e.printStackTrace ();
            }
        }
    }
}
