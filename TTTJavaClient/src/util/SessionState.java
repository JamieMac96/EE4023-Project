/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import view.GamePanel;

/**
 *
 * @author jamie
 */
public class SessionState {
    
    private static Integer userId;
    private static Integer gameId;
    private static String username;
    private static Game game;
    
    public static int getUserId(){
        return userId;
    }
    
    public static String getUserName(){
        return username;
    }
    
    public static int getGameId(){
        return gameId;
    }
    
    public static Game getGame() {
        return game;
    }
    
    public static void setUserId(Integer uId){
        userId = uId;
    }
    
    public static void setUserName(String user){
        username = user;
    }
    
    public static void setGameId(Integer gId){
        gameId = gId;
    }
    
    public static void setGame(Game g) {
        game = g;
    }
    
    public static void reset(){
        userId = null;
        gameId = null;
        username = null;
        game = null;
    }
}
