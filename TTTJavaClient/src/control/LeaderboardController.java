/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.HashMap;
import java.util.List;
import parse.GameParser;
import parse.IParser;
import ttt.james.server.TTTWebService;
import model.IItem;

/**
 *
 * @author jamie
 */
public class LeaderboardController {
    
    private final TTTWebService connection;
    
    public LeaderboardController() {
        this.connection = ConnectionInstance.getInstance();
    }
    
    public HashMap getScores() {
        
        IItem[] games = getAllGames();
        String gameState, gameData;
        String[] data;
        IItem game;
        
        HashMap results = new HashMap();
        
        if(games.length != 0) {
            
            for (IItem game1 : games) {
                game = game1;
                gameData = game.getData();
                data = gameData.split(",");
                gameState = data[2].trim();
                data[0] = data[0].trim();
                data[1] = data[1].trim();
                if(!results.containsKey(data[0])) {
                    HashMap score = initUser();
                    results.put(data[0], score);
                }
                if(!results.containsKey(data[1])) {
                    HashMap score = initUser();
                    results.put(data[1], score);
                }
                switch (gameState) {
                    case "1":
                        {
                            HashMap userOneScore = (HashMap) results.get(data[0]);
                            userOneScore.put("wins", (Integer) userOneScore.get("wins") + 1);
                            HashMap userTwoScore = (HashMap) results.get(data[1]);
                            userTwoScore.put("losses", (Integer) userTwoScore.get("losses") + 1);
                            break;
                        }
                    case "2":
                        {
                            HashMap userOneScore = (HashMap) results.get(data[0]);
                            userOneScore.put("losses", (Integer) userOneScore.get("losses") + 1);
                            HashMap userTwoScore = (HashMap) results.get(data[1]);
                            userTwoScore.put("wins", (Integer) userTwoScore.get("wins") + 1);
                            break;
                        }
                    case "3":
                        {
                            HashMap userOneScore = (HashMap) results.get(data[0]);
                            userOneScore.put("draws", (Integer) userOneScore.get("draws") + 1);
                            HashMap userTwoScore = (HashMap) results.get(data[1]);
                            userTwoScore.put("draws", (Integer) userTwoScore.get("draws") + 1);
                            break;
                        }
                    default:
                        break;
                }
            }
        }
        
        return results;
    }
    
    private IItem[] getAllGames(){
        String result = connection.leagueTable();
        
        IParser parser = new GameParser();
        List<IItem> itemList = parser.parseItems(result);
        
        IItem[] itemArray = new IItem[itemList.size()];
        itemArray = itemList.toArray(itemArray);
        
        return itemArray;
    }
    
    private HashMap initUser() {
        HashMap scores = new HashMap();
        scores.put("wins", 0);
        scores.put("losses", 0);
        scores.put("draws", 0);
        return scores;
    }
}
