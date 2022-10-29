package io.bytesbiter.servlet;

public class CustomServlet {

    public static void main(String[] args) {
        CustomHttpServer webServer = new CustomHttpServer();
        webServer.await();
    }
}
