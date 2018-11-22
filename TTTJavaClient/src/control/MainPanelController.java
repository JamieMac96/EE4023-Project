/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;
import parse.AvailableGameParser;
import parse.IParser;
import ttt.james.server.TTTWebService;
import util.IItem;

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
    
    public IItem[] getAvailableGames(){
        String result = connection.showOpenGames();
        
        IParser parser = new AvailableGameParser();
        List<IItem> itemList = parser.parseItems(result);
        
        IItem[] itemArray = new IItem[itemList.size()];
        itemArray = itemList.toArray(itemArray);
        
        return itemArray;
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
