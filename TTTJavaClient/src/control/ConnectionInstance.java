/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import ttt.james.server.TTTWebService;
import ttt.james.server.TTTWebService_Service;

/**
 *
 * @author jamie
 */
public class ConnectionInstance {
    
    private static TTTWebService connection;
    
    
    public static TTTWebService getInstance(){
        if(connection == null){
            connection = new TTTWebService_Service().getTTTWebServicePort();
        }
        return connection;
    }
    
}
