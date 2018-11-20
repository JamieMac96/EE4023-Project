/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.LoginController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import navigation.NavigationHandler;
import util.DialogCreator;
import util.PanelNames;
import util.UserCredential;

/**
 *
 * @author jamie
 */
public class LoginPanel extends javax.swing.JPanel implements ActionListener{

    private final LoginController controller;
    
    public LoginPanel() {
        controller = new LoginController();
        initComponents();
        setActionListeners();
    }
    
    public String getUsername(){
        return username.getText();
    }
    
    public String getPassword(){
        return new String(passwordField.getPassword());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object actionObj = e.getSource();
        
        if(actionObj == gotToRegisterButton){
            NavigationHandler.setCurrentCard(PanelNames.REGISTER_PANEL);
        }
        if(actionObj == loginButton){
            String result = controller.login(getLoginCredential());
            handleLoginResult(result);
        }
    }
    
    private void setActionListeners(){
        gotToRegisterButton.addActionListener(this);
        loginButton.addActionListener(this);
    }
    
    private void handleLoginResult(String result){
        if(result == null){
            NavigationHandler.setCurrentCard(PanelNames.MAIN_PANEL);
        }
        else{
            DialogCreator.showErrorDialog(result);
        }
    }
    
    private UserCredential getLoginCredential(){
        return new UserCredential.Builder()
                .setUsername(getUsername())
                .setPassword(getPassword())
                .build();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        username = new javax.swing.JTextField();
        loginButton = new javax.swing.JButton();
        usernameLabel = new java.awt.Label();
        passwordLabel = new java.awt.Label();
        gotToRegisterButton = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();

        loginButton.setText("login");

        usernameLabel.setForeground(new java.awt.Color(0, 0, 0));
        usernameLabel.setName("username"); // NOI18N
        usernameLabel.setText("username");

        passwordLabel.setForeground(new java.awt.Color(0, 0, 0));
        passwordLabel.setText("password");

        gotToRegisterButton.setText("Not a Member?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(username)
                    .addComponent(gotToRegisterButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loginButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordField))
                .addGap(134, 134, 134))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
                .addComponent(loginButton)
                .addGap(18, 18, 18)
                .addComponent(gotToRegisterButton)
                .addGap(67, 67, 67))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton gotToRegisterButton;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passwordField;
    private java.awt.Label passwordLabel;
    private javax.swing.JTextField username;
    private java.awt.Label usernameLabel;
    // End of variables declaration//GEN-END:variables

}
