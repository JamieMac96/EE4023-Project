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
    
    private TTTWebService connection;
    
    public LoginController(){
        connection = ConnectionInstance.getInstance();
    }
    
    public String login(UserCredential uCred){
        int result = connection.login(
                uCred.getUsername(), 
                uCred.getPassword());
        
        System.out.println("PASSWORD PASSED: " + uCred.getPassword());
        
        return getLoginResultMessage(result);
    }
    
    private String getLoginResultMessage(int resultCode){
        if(resultCode == -1 || resultCode == 0){
            return "Error: Login Failed!";
        }
        else{
            return null;
        }
    }
    
}
