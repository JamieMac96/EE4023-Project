/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import control.ConnectionInstance;
import ttt.james.server.TTTWebService;

/**
 *
 * @author rory
 */
public class GameThread extends Thread {
    
    private Thread thread;
    private final Game game;
    private final TTTWebService connection;
    
    public GameThread(Game game) {
        this.game = game;
        connection = ConnectionInstance.getInstance();
    }
    
    @Override
    public void run() {
        synchronized(connection) {
            
            String boardState1 = game.getBoardState();
            String boardState2 = connection.getBoard(game.getGameId());
            
            if(!game.playable){
                if(!boardState1.equals(boardState2)){ 
                    game.setPlayable(true);
                    game.setBoardState(boardState2);
               
                }
                else if(boardState1.equals(boardState2)){
                    game.setPlayable(false);   
                }  
            }
            else if(game.getPlayable()){
                if(!boardState1.equals(boardState2)){ 
                    game.setPlayable(false);
                    game.setBoardState(boardState2);
                }
            }
        }
    }
    
    @Override
    public void start () {
      if (thread == null) {
         thread = new Thread (this);
         thread.start();
      }
   }
}
