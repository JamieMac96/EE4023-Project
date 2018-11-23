/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import ttt.james.server.TTTWebService;
import util.Move;

/**
 *
 * @author jamie
 */
public class GamePanelController {
    
    private TTTWebService connection;
    
    public GamePanelController(){
        connection = ConnectionInstance.getInstance();
    }
    
    public String addMove(Move move){
        String result = connection.takeSquare(
                move.getxCoordinate(),
                move.getyCoordinate(), 
                move.getGameId(), 
                move.getPlayerId());
        
        return getAddMoveMessage(result);
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
}
