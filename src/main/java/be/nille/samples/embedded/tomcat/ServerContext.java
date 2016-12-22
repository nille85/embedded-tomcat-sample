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
public class ServerContext {
    
    private final int port;
    
    public ServerContext(final int port){
        this.port = port;
    }

    public int getPort() {
        return port;
    }
    
    
    
}
