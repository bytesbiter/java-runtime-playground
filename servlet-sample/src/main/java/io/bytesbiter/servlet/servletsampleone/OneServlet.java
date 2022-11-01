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
        out.println("Hello. Roses are red.");
        out.print("Violets are blue.");
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
