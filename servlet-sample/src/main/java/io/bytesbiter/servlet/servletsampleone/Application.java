package io.bytesbiter.servlet.servletsampleone;

public class Application {

    public static void main(String[] args) {
        OneHttpServer webServer = new OneHttpServer();
        webServer.await();
    }
}
