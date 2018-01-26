package com.hnjme.cloud;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.jboss.resteasy.plugins.server.servlet.HttpServlet30Dispatcher;
/**
 * Author: HeGuangwu (heguangwu@163.com)
 * Description:
 * Date: Create in 2018/01/26
 * Modified By:
 */
public class RestServlet {
    public static void main(String[] args) throws Exception {
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);

        ServletHolder holder = new ServletHolder(new HttpServlet30Dispatcher());
        holder.setInitParameter("javax.ws.rs.Application", "com.hnjme.cloud.ResourceApp");
        holder.setName("rest servlet");
        context.addServlet(holder, "/*");

        Server server = new Server(8080);
        server.setHandler(context);
        server.start();
        server.join();
    }
}
