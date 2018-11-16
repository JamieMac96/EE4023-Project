/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.MainPanelController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author jamie
 */
public class MainPanel extends javax.swing.JPanel implements ActionListener{

    /**
     * Creates new form MainScreen
     */
    private MainPanelController controller;
    
    public MainPanel() {
        controller = new MainPanelController();
        initComponents();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        
        if(o == createGameButton){
            controller.createGame();
        }
        else if(o == joinGameButton){
            controller.joinGame();
        }
        else if(o == leaderboardButton){
            //Go to leaderboard page
        }
        else if(o == userScoresButton){
            //Go to user scores page
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        userScoresButton = new javax.swing.JButton();
        leaderboardButton = new javax.swing.JButton();
        createGameButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        joinGameButton = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        userScoresButton.setText("User Scores");
        userScoresButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userScoresButtonActionPerformed(evt);
            }
        });

        leaderboardButton.setText("Leaderboard");

        createGameButton.setText("Create Game");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Available Games"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        joinGameButton.setText("Join Game");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userScoresButton)
                    .addComponent(leaderboardButton)
                    .addComponent(createGameButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(joinGameButton)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(userScoresButton)
                        .addGap(18, 18, 18)
                        .addComponent(leaderboardButton)
                        .addGap(18, 18, 18)
                        .addComponent(createGameButton)))
                .addGap(18, 18, 18)
                .addComponent(joinGameButton)
                .addContainerGap(61, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void userScoresButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userScoresButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userScoresButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createGameButton;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton joinGameButton;
    private javax.swing.JButton leaderboardButton;
    private javax.swing.JButton userScoresButton;
    // End of variables declaration//GEN-END:variables

}
