/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author jamie
 */
public final class DialogCreator {
    
    private DialogCreator(){
        
    }
    
    public static void showErrorDialog(String errorMessage){
        JOptionPane optionPane = new JOptionPane(errorMessage, JOptionPane.ERROR_MESSAGE);    
        JDialog dialog = optionPane.createDialog("Failure");
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
    }
}
