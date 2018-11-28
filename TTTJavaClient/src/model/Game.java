/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import util.SessionState;

/**
 *
 * @author rory
 */
public class Game {
    
    public int gameId;
    public String userOne;
    public String userTwo;
    public String userToPlay;
    public String boardState;
    public int gameState;
    public boolean playable;
    public String playerSymbol;
    public String opponentSymbol;
    
    
    public Game(int gameId) {
        this.gameId = gameId;
    }
    
    public void setGameId(int gameId) {
        this.gameId = gameId;
    }
    
    public int getGameId() {
        return this.gameId;
    }
    
    public void setUserOne(String userOne) {
        this.userOne = userOne;
    }
    
    public String getUserOne() {
        return this.userOne;
    }
    
    public void setUserTwo(String userTwo) {
        this.userTwo = userTwo;
    }
    
    public String getUserTwo() {
        return this.userTwo;
    }
    
    public void setGameState(int gameState) {
        this.gameState = gameState;
    }
    
    public int getGameState() {
        return this.gameState;
    }
    
    public void setUserToPlay(String userToPlay) {
        this.userToPlay = userToPlay;
    }
    
    public String getUserToPlay() {
        return this.userToPlay;
    }
    
    public void setBoardState(String boardState) {
        this.boardState = boardState;
    }
    
    public String getBoardState() {
        return this.boardState;
    }
    
    public void setPlayable(boolean playable) {
        this.playable = playable;
    }
    
    public boolean getPlayable() {
        return this.playable;
    }
    
    public String getPlayerSymbol() {
        if(userOne == null) {
            playerSymbol = "O";
            opponentSymbol = "X";
        }
        else if(SessionState.getUserName().equals(userOne.trim())) {
            playerSymbol = "X";
            opponentSymbol = "O";
        }
        else {
            playerSymbol = "O";
            opponentSymbol = "X";
        }
        return this.playerSymbol;
    }
    
     public String getOpponentSymbol() {
        if(SessionState.getUserName().equals(userOne)) {
            playerSymbol = "X";
            opponentSymbol = "O";
        }
        else {
            playerSymbol = "O";
            opponentSymbol = "X";
        }
        return this.opponentSymbol;
    }
}
