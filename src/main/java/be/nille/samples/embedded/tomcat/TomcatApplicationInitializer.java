/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.samples.embedded.tomcat;

import java.util.Set;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.apache.catalina.servlets.DefaultServlet;

/**
 *
 * @author nholvoet
 */
public class TomcatApplicationInitializer implements ServletContainerInitializer {

    @Override
    public void onStartup(Set<Class<?>> set, ServletContext context) throws ServletException {

        System.out.println("configuring default servlet");
        ServletRegistration.Dynamic defaultServlet = context.addServlet(
                "default", new DefaultServlet());
        defaultServlet.setLoadOnStartup(1);
        defaultServlet.addMapping("/");
        defaultServlet.setInitParameter("debug", "1");
        defaultServlet.setInitParameter("listings", "true");

    }

}
