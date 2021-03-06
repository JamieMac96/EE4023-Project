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
public class GameItem implements IItem{
    
    private final int autoKey;
    private final String userOne;
    private final String userTwo;
    private final String started;
    
    public GameItem(int autoKey, String userOne, String userTwo, String started){
        this.autoKey = autoKey;
        this.userOne = userOne;
        this.userTwo = userTwo;
        this.started = started;
    }

    public String getUserOne() {
        return userOne;
    }
    
    public String getUserTwo() {
        return userTwo;
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
        return autoKey + ", " + userOne + ", " + userTwo + ", " + started;
    }

    @Override
    public String getData() {
        return userOne + ", " + userTwo + ", " + started;
    }
}
