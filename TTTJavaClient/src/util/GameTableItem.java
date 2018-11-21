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
public class GameTableItem {
    
    private int autoKey;
    private String username;
    private boolean started;
    
    
    @Override
    public String toString(){
        return 1 + ", " + username + ", " + started;
    }

    public int getAutoKey() {
        return autoKey;
    }

    public String getUsername() {
        return username;
    }

    public boolean getStarted(){
        return started;
    }
    
    public void setAutoKey(int autoKey) {
        this.autoKey = autoKey;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }
}
