import com.sun.net.httpserver.HttpServer;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class CustomHttpServer {

    /** WEB_ROOT is the directory where our HTML and other files reside.
     * For this package, WEB_ROOT is the "webroot" directory under the
     * working directory.
     * The working directory is the location in the file system
     * from where the java command was invoked.
     */
    public static final String WEB_ROOT = System.getProperty("user.dir") + File.separator + "webroot";
    private static final String SHUTDOWN_COMMAND = "/shutdown";
    private boolean shutdown = false;

    public void await() {
        ServerSocket serverSocket = null; int port = 8080;
        try {
            serverSocket = new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));
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
                CustomRequest request = new CustomRequest(input);
                request.parse();
                // create Response object
                CustomResponse response = new CustomResponse(output);
                response.setRequest(request);
                response.sendStaticResource();
                // Close the socket socket.close();
                //check if the previous URI is a shutdown command
                shutdown = request.getUri().equals(SHUTDOWN_COMMAND); }
            catch (Exception e) {
                e.printStackTrace ();
            }
        }
    }
}
