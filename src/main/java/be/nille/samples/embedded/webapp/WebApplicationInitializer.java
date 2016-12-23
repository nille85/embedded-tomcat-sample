/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.samples.embedded.webapp;

import be.nille.samples.embedded.webapp.spring.MvcConfig;
import java.util.Set;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 *
 * @author nholvoet
 */
public class WebApplicationInitializer implements ServletContainerInitializer {

    @Override
    public void onStartup(Set<Class<?>> set, ServletContext context) throws ServletException {

        System.out.println("starting web application ...");
        configureServlets(context);

    }

    private void configureServlets(final ServletContext context) {
        ServletRegistration.Dynamic okServlet = context.addServlet(
                "okServlet", new OkServlet());
        okServlet.setLoadOnStartup(1);
        okServlet.addMapping("/ok");

        ServletRegistration.Dynamic helloServlet = context.addServlet(
                "helloServlet", new HelloServlet());
        helloServlet.setLoadOnStartup(1);
        helloServlet.addMapping("/hello/*");

        ServletRegistration.Dynamic springServlet = context.addServlet(
                "springServlet", new DispatcherServlet());
        springServlet.setLoadOnStartup(1);
        springServlet.addMapping("/spring/*");
        springServlet.setInitParameter("contextClass", AnnotationConfigWebApplicationContext.class.getName());
        springServlet.setInitParameter("contextConfigLocation", MvcConfig.class.getName());

    }

}
