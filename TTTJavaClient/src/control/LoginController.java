/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import ttt.james.server.TTTWebService;
import util.UserCredential;

/**
 *
 * @author jamie
 */
public class LoginController {
    
    private final TTTWebService connection;
    
    public LoginController(){
        connection = ConnectionInstance.getInstance();
    }
    
    public int login(UserCredential uCred){
     return connection.login(
                uCred.getUsername(), 
                uCred.getPassword());
    }
}
