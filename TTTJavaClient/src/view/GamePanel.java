/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.ConnectionInstance;
import control.GamePanelController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JTextField;
import navigation.NavigationHandler;
import ttt.james.server.TTTWebService;
import util.DialogCreator;
import util.Game;
import util.Move;
import util.SessionState;

/**
 *
 * @author jamie
 */
public class GamePanel extends javax.swing.JPanel implements ActionListener{
    
    private final GamePanelController controller;
    private Map<Integer, JTextField> textFieldMappings;
    private TTTWebService connection;
    
    /**
     * Creates new form GamePanel
     */
    public GamePanel() {
        initComponents();
        addActionListeners();
        configureBoard();
        controller = new GamePanelController(this);
        connection = ConnectionInstance.getInstance();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object actionObj = e.getSource();
        
        if(actionObj == backButton){
            NavigationHandler.back();
        }
        if(actionObj == addMoveButton){
            Move move = getMove();
            System.out.println(move);
            String result = controller.addMove(move);
            handleAddMove(result, move);
        }
    }
    
    private void configureBoard(){
        board00.setEditable(false);
        board01.setEditable(false);
        board02.setEditable(false);
        board10.setEditable(false);
        board11.setEditable(false);
        board12.setEditable(false);
        board20.setEditable(false);
        board21.setEditable(false);
        board22.setEditable(false);
        
        textFieldMappings = new HashMap<>();
        textFieldMappings.put(0, board00);
        textFieldMappings.put(1, board01);
        textFieldMappings.put(2, board02);
        textFieldMappings.put(3, board10);
        textFieldMappings.put(4, board11);
        textFieldMappings.put(5, board12);
        textFieldMappings.put(6, board20);
        textFieldMappings.put(7, board21);
        textFieldMappings.put(8, board22);
    } 
    
    private void addActionListeners() {
        backButton.addActionListener(this);
        addMoveButton.addActionListener(this);
    }
    
    private void handleAddMove(String result, Move move){
        Game game = SessionState.getGame();
        System.out.println("Result: " + result);
        if(null == result){
            int x = move.getxCoordinate();
            int y = move.getyCoordinate();
            textFieldMappings.get(x*3 + y).setText(game.getPlayerSymbol());
        }
        else switch (result) {
            case "0":
                DialogCreator.showErrorDialog("Not your turn!");
                break;
            case "1":
                DialogCreator.showErrorDialog("Square already taken!");
                break;
            case "2":
                DialogCreator.showErrorDialog("Waiting for an opponent!");
                break;
            default:
                break;
        }
        System.out.println("Game user one:" + SessionState.getGame().getUserOne());
        System.out.println("Game user two:" + SessionState.getGame().getUserTwo());
        
    }
    
    public void updateBoard() {
        String data = connection.getBoard(SessionState.getGameId());
        if(!data.equals("ERROR-NOMOVES")) {
            String [] rows = data.split("\n");
                 for(String row : rows){
                        String[] rowItems = row.split(",");
                        String id = rowItems[0];
                        int x = Integer.parseInt(rowItems[1]);
                        int y = Integer.parseInt(rowItems[2]);
                        if(id.trim().equals(Integer.toString(SessionState.getUserId()))) {
                            textFieldMappings.get(x*3 + y).setText(SessionState.getGame().getPlayerSymbol());
                        }
                        else {
                            textFieldMappings.get(x*3 + y).setText(SessionState.getGame().getOpponentSymbol());
                        }
                       
                }
        }
    }
    
    private Move getMove(){
        int x;
        int y;
        
        try{
            x = Integer.parseInt(xCoordinate.getText());
            y = Integer.parseInt(yCoordinate.getText());
        }
        catch(NumberFormatException e){
            // Allow backend to catch error, and produce error message
            x = -1;
            y = -1;
        }
        
        return new Move.Builder()
                .setX(x)
                .setY(y)
                .setGameId(SessionState.getGameId())
                .setPlayerId(SessionState.getUserId())
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

        backButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        addMoveButton = new javax.swing.JButton();
        xCoordinate = new javax.swing.JTextField();
        yCoordinate = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        board00 = new javax.swing.JTextField();
        board10 = new javax.swing.JTextField();
        board20 = new javax.swing.JTextField();
        board01 = new javax.swing.JTextField();
        board11 = new javax.swing.JTextField();
        board21 = new javax.swing.JTextField();
        board12 = new javax.swing.JTextField();
        board02 = new javax.swing.JTextField();
        board22 = new javax.swing.JTextField();

        backButton.setText("back");

        jLabel1.setText("x");

        addMoveButton.setText("Add Move");
        addMoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMoveButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("y");

        board00.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        board10.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        board20.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        board01.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        board11.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        board21.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        board12.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        board02.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        board22.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(board00)
                            .addComponent(xCoordinate)
                            .addComponent(board10, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                            .addComponent(board20, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)))
                    .addComponent(backButton))
                .addGap(40, 40, 40)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(yCoordinate, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(addMoveButton)
                        .addGap(97, 97, 97))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(board01)
                            .addComponent(board11, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                            .addComponent(board21, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(board12, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                            .addComponent(board02)
                            .addComponent(board22, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(backButton)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(board00, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(board10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(board20, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(board02, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(board12, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(board22, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(board01, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(board11, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(board21, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(xCoordinate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addMoveButton)
                    .addComponent(yCoordinate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(19, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addMoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMoveButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addMoveButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addMoveButton;
    private javax.swing.JButton backButton;
    private javax.swing.JTextField board00;
    private javax.swing.JTextField board01;
    private javax.swing.JTextField board02;
    private javax.swing.JTextField board10;
    private javax.swing.JTextField board11;
    private javax.swing.JTextField board12;
    private javax.swing.JTextField board20;
    private javax.swing.JTextField board21;
    private javax.swing.JTextField board22;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField xCoordinate;
    private javax.swing.JTextField yCoordinate;
    // End of variables declaration//GEN-END:variables

}
