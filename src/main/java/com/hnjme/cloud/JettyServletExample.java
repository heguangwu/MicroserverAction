package com.hnjme.cloud;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author: HeGuangwu (heguangwu@163.com)
 * Description:
 * Date: Create in 2018/01/26
 * Modified By:
 */

public class JettyServletExample {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/demo");
        server.setHandler(context);

        //设置Servlet及path
        context.addServlet(new ServletHolder(new HelloServlet("John")), "/name");
        context.addServlet(new ServletHolder(new HelloServlet("33")), "/age");

        server.start();
        server.join();
    }

    public static class HelloServlet extends HttpServlet {
        String target = "world";

        public HelloServlet(String target){
            this.target = target;
        }
        @Override
        protected void doGet( HttpServletRequest request,
                              HttpServletResponse response ) throws IOException {
            response.setContentType("text/html");
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().println("<h1>Hello " + target + "</h1>");
        }
    }
}
