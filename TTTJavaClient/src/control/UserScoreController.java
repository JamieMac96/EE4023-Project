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
import util.IItem;
import util.SessionState;

/**
 *
 * @author jamie
 */
public class UserScoreController {
    
    private final TTTWebService connection;
    
    public UserScoreController(){
        this.connection = ConnectionInstance.getInstance();
    }
    
    public int[] getScores() {
        int[] result = new int[3];
        String username = SessionState.getUserName();
        IItem[] games = getAllGames(SessionState.getUserId());
        int wins = 0, losses = 0, draws = 0;
        String gameState, gameData;
        String[] data;
        IItem game;
        
        if(games.length != 0) {
            for (IItem game1 : games) {
                game = game1;
                gameState = connection.getGameState(game.getAutoKey());
                gameData = game.getData();
                data = gameData.split(",");
                System.out.println("Data[0]: " + data[0] + " Data[1]: " + data[1]);
                switch (gameState) {
                    case "1":
                        if(data[0].equals(username))
                            wins++;
                        else if(data[1].equals(username))
                            losses++;
                        break;
                    case "2":
                        if(data[0].equals(username))
                            losses++;
                        else if(data[1].equals(username))
                            wins++;
                        break;
                    case "3":
                        draws++;
                        break;
                    default:
                        break;
                }
            }
        }
        
        result[0] = wins;
        result[1] = losses;
        result[2] = draws;
        return result;
    }
    
    private IItem[] getAllGames(int uid){
        String result = connection.showAllMyGames(uid);
        
        IParser parser = new GameParser();
        List<IItem> itemList = parser.parseItems(result);
        
        IItem[] itemArray = new IItem[itemList.size()];
        itemArray = itemList.toArray(itemArray);
        
        return itemArray;
    }
}
