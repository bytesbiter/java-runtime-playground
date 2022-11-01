package io.bytesbiter.servlet.servletsampleone;

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
public class OneHttpServer {

    /** WEB_ROOT is the directory where our HTML and other files reside.
     * For this package, WEB_ROOT is the "webroot" directory under the
     * working directory.
     * The working directory is the location in the file system
     * from where the java command was invoked (where the JVM is running - which is the root directory of this project 'java-runtime-playgoround' ).
     */
    public static final String WEB_ROOT = System.getProperty("user.dir") + File.separator + "servlet-sample/src/main/resources";
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
                OneRequest request = new OneRequest(input);
                request.parse();
                // create Response object
                OneResponse response = new OneResponse(output);
                response.setRequest(request);
                response.sendStaticResource();
                // check if this is a request for a servlet or
                // a static resource
                // a request for a servlet begins with "/servlet/"
                if (request.getUri().startsWith("/servlet/")) {
                    OneServletProcessor processor = new OneServletProcessor();
                    processor.process(request, response);
                }else {
                    OneStaticResoureProcessor processor =
                            new OneStaticResoureProcessor();
                    processor.process(request, response);
                }
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
