package io.bytesbiter.servlet.webserversample;

public class Application {

    public static void main(String[] args) {
        WebserverSampleHttpServer webServer = new WebserverSampleHttpServer();
        webServer.await();
    }
}
