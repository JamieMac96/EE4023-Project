package view;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import navigation.NavigationHandler;
import util.PanelNames;
import util.SessionState;

/**
 *
 * @author jamie
 */
public class ClientFrame extends JFrame implements ActionListener{
    
    public ClientFrame(){
        configureUi();
        initializeNavigation();
    }
    
    private void configureUi(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String [] args){
        ClientFrame frame = new ClientFrame();
        
        frame.pack();
        frame.setVisible(true);
        frame.setSize(400, 350);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    private void initializeNavigation() {
        LoginPanel loginPanel = new LoginPanel();
        RegisterPanel registerPanel = new RegisterPanel();
        LeaderboardPanel leaderboardPanel = new LeaderboardPanel();
        MainPanel mainPanel = new MainPanel();
        UserScorePanel userScorePanel = new UserScorePanel();
        GamePanel gamePanel = new GamePanel();
        
        NavigationHandler.init();
        NavigationHandler.addCard(loginPanel, PanelNames.LOGIN_PANEL);
        NavigationHandler.addCard(registerPanel, PanelNames.REGISTER_PANEL);
        NavigationHandler.addCard(leaderboardPanel, PanelNames.LEADERBOARD_PANEL);
        NavigationHandler.addCard(mainPanel, PanelNames.MAIN_PANEL);
        NavigationHandler.addCard(userScorePanel, PanelNames.USER_SCORE_PANEL);
        NavigationHandler.addCard(gamePanel, PanelNames.GAME_PANEL);
        
        NavigationHandler.setCurrentCard(PanelNames.REGISTER_PANEL);
        
        add(NavigationHandler.getCards(), BorderLayout.CENTER);
    }
}
