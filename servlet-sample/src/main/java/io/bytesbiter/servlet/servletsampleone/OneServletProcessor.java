package io.bytesbiter.servlet.servletsampleone;

import jakarta.servlet.Servlet;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;
import java.util.Objects;

public class OneServletProcessor {

    public void process(OneRequest request, OneResponse response) {
        String uri = request.getUri();
        String servletName = uri.substring(uri.lastIndexOf("/") + 1);
        URLClassLoader loader = null;

        try {
            // create a URLClassLoader
            URL[] urls = new URL[1];
            URLStreamHandler streamHandler = null;
            File classPath = new File(OneHttpServer.WEB_ROOT + File.separator);
            // the forming of repository is taken from the createClassLoader method in org.apache.catalina.startup.ClassLoaderFactory
            String repository = (new URL("file", null, classPath.getCanonicalPath() + File.separator)).toString() ;
            // the code for forming the URL is taken from the addRepository method in org.apache.catalina.loader.StandardClassLoader.
            urls[0] = new URL(null, repository, streamHandler);
            loader = new URLClassLoader(urls);
        } catch (IOException e) {
            System.out.println(e);
        }

        Class<OneServlet> servletClass = null;
        try {
            servletClass = (Class<OneServlet>) Objects.requireNonNull(loader).loadClass("io.bytesbiter.servlet.servletsampleone.OneServlet");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        Servlet servlet;

        try {
            servlet = Objects.requireNonNull(servletClass)
                    .getDeclaredConstructor()
                    .newInstance();
            servlet.service(request, response);
        } catch (Throwable e) {
            System.out.println(e);
        }
    }

}
