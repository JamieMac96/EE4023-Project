/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.ConnectionInstance;
import control.GamePanelController;
import control.MainPanelController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import navigation.NavigationHandler;
import ttt.james.server.TTTWebService;
import util.DialogCreator;
import util.Game;
import util.IItem;
import util.PanelNames;
import util.SessionState;

/**
 *
 * @author jamie
 */
public class MainPanel extends javax.swing.JPanel implements ActionListener{

    /**
     * Creates new form MainScreen
     */
    private final MainPanelController controller;
    private TTTWebService connection;
    
    public MainPanel() {
        controller = new MainPanelController();
        initComponents();
        addActionListeners();
        populateGamesTable();
        connection = ConnectionInstance.getInstance();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        
        if(o == createGameButton){
            String result = controller.createGame(SessionState.getUserId());
            handleCreateGameResult(result);
        }
        else if(o == joinGameButton){
            int gId = getSelectedGameId();
            String result = controller.joinGame(SessionState.getUserId(), gId);
            handleJoinGameResult(result, gId);
        }
        else if(o == leaderboardButton){
            NavigationHandler.setCurrentCard(PanelNames.LEADERBOARD_PANEL);
        }
        else if(o == userScoresButton){
           NavigationHandler.setCurrentCard(PanelNames.USER_SCORE_PANEL);
        }
        else if(o == backButton){
            NavigationHandler.back();
        }
    }
    
    private void addActionListeners() {
        backButton.addActionListener(this);
        joinGameButton.addActionListener(this);
        leaderboardButton.addActionListener(this);
        userScoresButton.addActionListener(this);
        createGameButton.addActionListener(this);
    }
    
    private void handleCreateGameResult(String result){
        //try{
            int gameId = Integer.parseInt(result);
            SessionState.setGameId(gameId);
            Game createdGame = new Game(gameId, 1);
            createdGame.setPlayable(true);
            createdGame.setUserOne(SessionState.getUserName());
            createdGame.setUserToPlay(SessionState.getUserName());
            createdGame.setGameState(-1);
            createdGame.setBoardState(connection.getBoard(gameId));
            SessionState.setGame(createdGame);
            NavigationHandler.setCurrentCard(PanelNames.GAME_PANEL);
//        }
//        catch(NumberFormatException e){
//            DialogCreator.showErrorDialog(result);
//        }
    }
    
    private void handleJoinGameResult(String result, int gId){
        if(!result.equals("1")){
            DialogCreator.showErrorDialog(result);
        }
        else{
            SessionState.setGameId(gId);
            Game joinedGame = new Game(gId, 2);
            joinedGame.setPlayable(false);
            joinedGame.setUserTwo(SessionState.getUserName());
            joinedGame.setGameState(0);
            joinedGame.setBoardState(connection.getBoard(gId));
            SessionState.setGame(joinedGame);
            NavigationHandler.setCurrentCard(PanelNames.GAME_PANEL);
        }
    }
    
    private void populateGamesTable(){
        ((DefaultTableModel)availableGamesTable.getModel()).setRowCount(0);
        DefaultTableModel model = (DefaultTableModel)availableGamesTable.getModel();
        for(IItem item: controller.getAvailableGames()){
            model.addRow(new IItem[]{item});
        }
    }
    
    private int getSelectedGameId(){
        int selectedColumn = availableGamesTable.getSelectedColumn();
        int selectedRow = availableGamesTable.getSelectedRow();
        
        IItem selectedItem = (IItem)availableGamesTable.getValueAt(selectedRow, selectedColumn);
        
        return selectedItem.getAutoKey();
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
        availableGamesTable = new javax.swing.JTable();
        joinGameButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

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

        availableGamesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Available Games"
            }
        ));
        jScrollPane1.setViewportView(availableGamesTable);

        joinGameButton.setText("Join Game");

        backButton.setText("back");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userScoresButton)
                    .addComponent(leaderboardButton)
                    .addComponent(createGameButton)
                    .addComponent(backButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(joinGameButton)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    private javax.swing.JTable availableGamesTable;
    private javax.swing.JButton backButton;
    private javax.swing.JButton createGameButton;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton joinGameButton;
    private javax.swing.JButton leaderboardButton;
    private javax.swing.JButton userScoresButton;
    // End of variables declaration//GEN-END:variables


}
