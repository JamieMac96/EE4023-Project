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
    
    public String joinGame(){
        return "";
    }
    
    public GameTableItem[] getAvailableGames(){
        String result = connection.showOpenGames();
        
        return parseAvailableGames(result);
    }  
    
    private GameTableItem[] parseAvailableGames(String availableGames){
        System.out.println("INPUT: " + availableGames);
        
        String [] rows = availableGames.split("\n");
        
        
        System.out.println("OUTPUT: " );
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
                return result;
        }
    }
    
    private String getJoinGameMessage(String result){
        return "";
    }
}
