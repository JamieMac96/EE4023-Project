/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;
import parse.GameParser;
import parse.IParser;
import ttt.james.server.TTTWebService;
import model.IItem;

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
    
    public String joinGame(int uId, int gId){
        String result = connection.joinGame(uId, gId);
        
        return getJoinGameMessage(result);
    }
    
    public IItem[] getAvailableGames(){
        String result = connection.showOpenGames();
        
        IParser parser = new GameParser();
        List<IItem> itemList = parser.parseItems(result);
        
        IItem[] itemArray = new IItem[itemList.size()];
        itemArray = itemList.toArray(itemArray);
        
        return itemArray;
    }  
    
    private String getJoinGameMessage(String result){
        switch (result) {
            case "ERROR-DB":
                return "Error: Could not access dataase!";
            case "0":
                return "Error! Could not joing the game";
            default:
                return result;
                        }
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
}
