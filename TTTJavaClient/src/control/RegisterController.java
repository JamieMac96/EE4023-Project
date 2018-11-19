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
public class RegisterController {
    
    private TTTWebService connection;
    
    public RegisterController(){
        this.connection = ConnectionInstance.getInstance();
    }
    
    public String registerUser(UserCredential credential){
        return connection.register(
                credential.getSurname(),
                credential.getPassword(),
                credential.getForename(),
                credential.getSurname());
    }
}
