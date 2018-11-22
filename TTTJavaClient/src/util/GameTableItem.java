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
public class GameTableItem implements IItem{
    
    private final int autoKey;
    private final String username;
    private final String started;
    
    public GameTableItem(int autoKey, String username, String started){
        this.autoKey = autoKey;
        this.username = username;
        this.started = started;
    }

    public String getUsername() {
        return username;
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
        return autoKey + ", " + username + ", " + started;
    }

    @Override
    public String getData() {
        return username + ", " + started;
    }
}
