/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import model.Game;
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
            
            String boardStateOne = game.getBoardState();
            String boardStateTwo = connection.getBoard(game.getGameId());
            
            if(!game.playable){
                if(!boardStateOne.equals(boardStateTwo)){ 
                    game.setPlayable(true);
                    game.setBoardState(boardStateTwo);
               
                }
            }
            else if(game.getPlayable()){
                if(!boardStateOne.equals(boardStateTwo)){ 
                    game.setPlayable(false);
                    game.setBoardState(boardStateTwo);
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
