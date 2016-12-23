/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.samples.embedded.tomcat;

import be.nille.samples.embedded.webapp.WebApplicationInitializer;
import java.io.File;
import java.util.HashSet;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

/**
 *
 * @author Niels Holvoet
 */
public class TomcatServer implements EmbeddedServer {

    @Override
    public void start(ServerContext context) {

        try {
            //String docBase = "src/main/webapp/";

            Tomcat tomcat = new Tomcat();
            tomcat.setPort(context.getPort());

            //static files?
            //tomcat.addWebapp("/", new File(docBase).getAbsolutePath());
            Context ctx = tomcat.addContext("/app", new File(".").getAbsolutePath());

            ctx.addServletContainerInitializer(new TomcatApplicationInitializer(), new HashSet<Class<?>>());

            ctx.addServletContainerInitializer(new WebApplicationInitializer(), new HashSet<Class<?>>());

            tomcat.start();
            tomcat.getServer().await();
        } catch (LifecycleException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }

    }

}
