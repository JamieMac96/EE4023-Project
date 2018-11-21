/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Map;

/**
 *
 * @author jamie
 */
public class SessionState {
    
    private static Integer userId;
    private static Integer gameId;
    
    public static int getUserId(){
        return userId;
    }
    
    public static int getGameId(){
        return gameId;
    }
    
    public static void setUserId(Integer uId){
        userId = uId;
    }
    
    public static void setGameId(Integer gId){
        gameId = gId;
    }
    
    public static void reset(){
        userId = null;
        gameId = null;
    }
}