/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;
import parse.AllGamesParser;
import parse.GameParser;
import parse.IParser;
import ttt.james.server.TTTWebService;
import util.IItem;
import util.SessionState;
import util.UserCredential;

/**
 *
 * @author jamie
 */
public class UserScoreController {
    
    private TTTWebService connection;
    
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
            for(int i = 0; i < games.length; i++) {
                game = games[i];
                gameState = connection.getGameState(game.getAutoKey());
                gameData = game.getData();
                data = gameData.split(",");
                System.out.println("Data[0]: " + data[0] + " Data[1]: " + data[1]);
                if(gameState.equals("1")) {
                   if(data[0].equals(username))
                        wins++;
                   else if(data[1].equals(username))
                        losses++;
                }
                else if(gameState.equals("2")) {
                   if(data[0].equals(username))
                        losses++;
                    else if(data[1].equals(username))
                        wins++;
                }
                else if(gameState.equals("3")) {
                    draws++;
                }
            }
        }
        
        System.out.println("Wins = " + wins);
        System.out.println("Losses = " + losses);
        System.out.println("Draws = " + draws);
        result[0] = wins;
        result[1] = losses;
        result[2] = draws;
        return result;
    }
    
    private IItem[] getAllGames(int uid){
        String result = connection.showAllMyGames(uid);
        System.out.println("Show all: " + result + " for uid: " + uid);
        
        IParser parser = new GameParser();
        List<IItem> itemList = parser.parseItems(result);
        
        IItem[] itemArray = new IItem[itemList.size()];
        itemArray = itemList.toArray(itemArray);
        
        return itemArray;
    }
}
