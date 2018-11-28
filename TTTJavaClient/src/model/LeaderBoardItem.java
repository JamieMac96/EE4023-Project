/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.IItem;

/**
 *
 * @author jamie
 */
public class LeaderBoardItem implements IItem{
    
    private final int autoKey;
    private final String userOne;
    private final String userTwo;
    private final String gameState;
    private final String started;
    
    public LeaderBoardItem(int autoKey, String userOne, String userTwo, String gameState, String started){
        this.autoKey = autoKey;
        this.userOne = userOne;
        this.userTwo = userTwo;
        this.gameState = gameState;
        this.started = started;
    }

    public String getUserOne() {
        return userOne;
    }
    
    public String getUserTwo() {
        return userTwo;
    }
    
    public String getGameState() {
        return gameState;
    }

    public String getStarted(){
        return started;
    }

    @Override
    public int getAutoKey() {
        return autoKey;
    }
    
    @Override
    public String toString() {
        return autoKey + ", " + userOne + ", " + userTwo + ", " + gameState + ", " + started;
    }

    @Override
    public String getData() {
        return userOne + ", " + userTwo + ", " + gameState + ", " + started;
    }
}
