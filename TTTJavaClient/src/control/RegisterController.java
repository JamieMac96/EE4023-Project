/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import ttt.james.server.TTTWebService;
import model.UserCredential;

/**
 *
 * @author jamie
 */
public class RegisterController {
    
    private final TTTWebService connection;
    
    public RegisterController(){
        this.connection = ConnectionInstance.getInstance();
    }
    
    public String registerUser(UserCredential credential){
        System.out.println("PASSWORD ON REGISTER: |" + credential.getPassword()  + "|");
        
        String result = connection.register(
                credential.getSurname(),
                credential.getPassword(),
                credential.getForename(),
                credential.getSurname());
        
        return getRegisterResultMessage(result);
    }
    
    private String getRegisterResultMessage(String result){
        switch (result) {
            case "ERROR-REPEAT":
                return "Error: This user already exists!";
            case "ERROR-INSERT":
                return "Error: Could not insert the new user!";
            case "ERROR-RETRIEVE":
                return "Error: Could not retrieve your userId";
            case "ERROR-DB":
                return "Error: Could not find database.";
            default:
                return result;
                        }
    }
}
