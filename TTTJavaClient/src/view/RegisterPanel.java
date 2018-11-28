/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import util.UserCredential;
import control.RegisterController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import navigation.NavigationHandler;
import util.PanelNames;
import util.SessionState;

/**
 *
 * @author jamie
 */
public class RegisterPanel extends javax.swing.JPanel implements ActionListener{
    
    private final RegisterController controller;
    
    /**
     * Creates new form RegisterPanel
     */
    public RegisterPanel() {
        initComponents();
        controller = new RegisterController();
        addActionListeners();
    }

    public String getUsername(){
        return usernameField.getText();
    }
    
    public String getForename(){
        return forenameField.getText();
    }
    
    public String getSurname(){
        return surnameField.getText();
    }
    
    public String getPassword(){
        return new String(passwordField.getPassword());
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        Object o = e.getSource();
        if(o == registerButton){
            String result = controller.registerUser(getRegisterCredential());
            handleRegisterResult(result);
        }
        if(o == goToLoginButton){
            NavigationHandler.setCurrentCard(PanelNames.LOGIN_PANEL);
        }
        if(o == backButton){
            NavigationHandler.back();
        }
    }
    
    private void handleRegisterResult(String result){
        System.out.println("REGISTER RESULT: " + result);
        
        try{
            int userId = Integer.parseInt(result);
            SessionState.setUserId(userId);
            SessionState.setUserName(this.getUsername());
            NavigationHandler.setCurrentCard(PanelNames.MAIN_PANEL);
        }
        catch(NumberFormatException e){
            showErrorMessage(result);
        }
    }
    
    private void showErrorMessage(String message){
        JOptionPane optionPane = new JOptionPane(message, JOptionPane.ERROR_MESSAGE);    
        JDialog dialog = optionPane.createDialog("Failure");
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
    }
    
    private void addActionListeners(){
        registerButton.addActionListener(this);
        goToLoginButton.addActionListener(this);
        backButton.addActionListener(this);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        passwordField = new javax.swing.JPasswordField();
        registerButton = new javax.swing.JButton();
        surnameField = new javax.swing.JTextField();
        forenameField = new javax.swing.JTextField();
        usernameField = new javax.swing.JTextField();
        usernameLabel = new java.awt.Label();
        forenameLabel = new java.awt.Label();
        surnameLabel = new java.awt.Label();
        passwordLabel = new java.awt.Label();
        goToLoginButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });

        registerButton.setText("Register");

        forenameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forenameFieldActionPerformed(evt);
            }
        });

        usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });

        usernameLabel.setText("username");

        forenameLabel.setText("forename");

        surnameLabel.setText("surname");

        passwordLabel.setText("password");

        goToLoginButton.setText("Already a Member?");

        backButton.setText("back");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(forenameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(surnameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(goToLoginButton)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(registerButton)
                        .addComponent(surnameField)
                        .addComponent(forenameField)
                        .addComponent(usernameField)
                        .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(80, 80, 80))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(usernameField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(usernameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(forenameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(forenameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(surnameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(surnameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(passwordLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(registerButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(goToLoginButton)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameFieldActionPerformed

    private void forenameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forenameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_forenameFieldActionPerformed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed

    private UserCredential getRegisterCredential(){
        return new UserCredential.Builder()
                .setUsername(getUsername())
                .setForename(getForename())
                .setSurname(getSurname())
                .setPassword(getPassword())
                .build();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JTextField forenameField;
    private java.awt.Label forenameLabel;
    private javax.swing.JButton goToLoginButton;
    private javax.swing.JPasswordField passwordField;
    private java.awt.Label passwordLabel;
    private javax.swing.JButton registerButton;
    private javax.swing.JTextField surnameField;
    private java.awt.Label surnameLabel;
    private javax.swing.JTextField usernameField;
    private java.awt.Label usernameLabel;
    // End of variables declaration//GEN-END:variables

}
