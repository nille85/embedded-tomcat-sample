/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.samples.embedded.tomcat;

/**
 *
 * @author Niels Holvoet
 */
public class Main {
    
    public static void main(String[] args) throws Exception {

        String webPortParameter = System.getenv("PORT");
        if(webPortParameter == null || webPortParameter.isEmpty()) {
            webPortParameter = "8080";
        }
        int webPort = Integer.valueOf(webPortParameter);
        ServerContext context = new ServerContext(webPort);
        EmbeddedServer server = new TomcatServer();
        server.start(context);
      
        
    }
    
}
