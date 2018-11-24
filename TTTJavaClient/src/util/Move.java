/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author jamie
 */
public class Move {
    private int xCoordinate;
    private int yCoordinate;
    private int gameId;
    private int playerId;
    
    private Move(){
        
    }
    
    public static class Builder{
        
        private int x;
        private int y;
        private int gId;
        private int pId;

        public Builder setX(int x){
            this.x = x;
            
            return this;
        }
        
        public Builder setY(int y){
            this.y = y;
            
            return this;
        }
        
        public Builder setGameId(int gId){
            this.gId = gId;
            
            return this;
        }
        
        public Builder setPlayerId(int pId){
            this.pId = pId;
            
            return this;
        }
        
        public Move build(){
            Move move = new Move();
            
            move.xCoordinate = this.x;
            move.yCoordinate = this.y;
            move.gameId = this.gId;
            move.playerId = this.pId;
            
            return move;
        }
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public int getGameId() {
        return gameId;
    }

    public int getPlayerId() {
        return playerId;
    }
    
    @Override
    public String toString(){
        return "xCoordinate: " + xCoordinate
                + "yCoordinate: " + yCoordinate
                + "gameId: " + gameId
                + "playerId: " + playerId;
    }
}
