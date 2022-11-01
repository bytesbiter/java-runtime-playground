package io.bytesbiter.servlet.servletsampleone;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;

public class OneServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) {
        System.out.println("init");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException {
        System.out.println("from service");
        PrintWriter out = servletResponse.getWriter();
        out.println("HTTP/1.1 200 OK \r\n" + "Content-Type: text/html \r\n\r\n" + "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "    <head>\n" +
                "        <title>Servlet Title!</title>\n" +
                "    </head>\n" +
                "    <body>\n" +
                "        <h1>My First Servlet Heading</h1>\n" +
                "    </body>\n" +
                "</html>\n");
        out.flush();
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
