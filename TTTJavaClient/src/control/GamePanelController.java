/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.Timer;
import java.util.TimerTask;
import ttt.james.server.TTTWebService;
import util.Game;
import util.GameThread;
import util.Move;
import util.SessionState;
import view.GamePanel;

/**
 *
 * @author jamie
 */
public class GamePanelController {
    
    private final TTTWebService connection;
    private Game game;
    private boolean gameSet;
    GamePanel panel;
    
    public GamePanelController(GamePanel panel){
        connection = ConnectionInstance.getInstance();
        this.panel = panel;
        gameSet = false;
    }
    
    public void startWatching() {
        
            int delay = 1000; // delay for 1 sec. 
            int period = 2000; // repeat every 2 sec. 
            Timer timer = new Timer(); 
            timer.scheduleAtFixedRate(new TimerTask() { 
                @Override
                public void run() { 
                    updateBoardView();
                    waitToPlay();
                } 
            }, delay, period);  
    }
    
    public String addMove(Move move) {
        String resultToReturn = "2";
        if(!gameSet) {
            game = SessionState.getGame();
            startWatching();
            gameSet = true;
        }
        //try {
        game.setGameState(Integer.parseInt(connection.getGameState(SessionState.getGameId())));
            if(game.getGameState() == 0) {
                if(connection.checkSquare(move.getxCoordinate(),
                    move.getyCoordinate(), 
                    move.getGameId()).equals("0")) {
                    if(game.getPlayable()) {
                        String result = connection.takeSquare(
                        move.getxCoordinate(),
                        move.getyCoordinate(), 
                        move.getGameId(), 
                        move.getPlayerId());
                        if(result.equals("1")) {
                            resultToReturn = null;
                            checkGame();
                        }
                    }else {
                        resultToReturn = "0";
                    }
                } else {
                    resultToReturn = "1";
                }
            }
                
        return resultToReturn;
    }
    
    private String getAddMoveMessage(String result){
        switch (result) {
            case "ERROR-TAKEN":
                return "Error: The selected square has already been taken!";
            case "ERROR-DB":
                return "Error: Could not access database!";
            case "ERROR":
                return "Error: Could not make move, error occured!";
            default:
                return null;
        }
    }
    
    public void checkGame(){  
       String result = connection.checkWin(game.getGameId());
       
        switch (result) {
            case "1":
                game.setGameState(1);
                connection.setGameState(game.getGameId(), 1);
                panel.updateBoard();
                break;
            case "2":
                game.setGameState(2);
                connection.setGameState(game.getGameId(), 2);
                panel.updateBoard();
                break;
            case "3":
                game.setGameState(3);
                connection.setGameState(game.getGameId(), 3);
                panel.updateBoard();
                break;
            default:
                panel.updateBoard();
                break;
        }
       
       waitToPlay();
          
    }
    
    public void waitToPlay(){             
       GameThread gameThread = new GameThread(game);
       gameThread.start();
       if(!connection.getGameState(SessionState.getGameId()).equals("0")){
           game.setPlayable(false);
       }
       
        try{                 
            gameThread.join();

        }catch (InterruptedException e) {
            System.out.println("Error, Interrupted.");
        }
   }
    
    public void updateBoardView(){
        if(connection.getGameState(SessionState.getGameId()).equals("0")){
            panel.updateBoard();
        }
    }
    
}
