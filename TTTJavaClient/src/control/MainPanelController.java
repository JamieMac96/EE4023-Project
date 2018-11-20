/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import ttt.james.server.TTTWebService;

/**
 *
 * @author jamie
 */
public class MainPanelController {
    private final TTTWebService connection;
    
    public MainPanelController(){
        connection = ConnectionInstance.getInstance();
    }
    
    public String createGame(int userId){
        String result = connection.newGame(userId);
        
        return getCreateGameMessage(result);
    } 
    
    public boolean joinGame(){
        return false;
    }
    
    private String getCreateGameMessage(String result){
        switch (result) {
            case "ERROR-NOTFOUND":
                return "Error: Could not find game ID!";
            case "ERROR-RETRIEVE":
                return "Error: Could not acces database record!";
            case "ERROR-INSERT":
                return "Error: Could not add game to database!";
            case "ERROR-DB":
                return "Error: Problem connecting to database!";
            default:
                return null;
        }
    }
    
    private String getJoinGameMessage(String result){
        
    }
}
