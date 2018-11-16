
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import view.LoginPanel;
import view.RegisterPanel;

/**
 *
 * @author jamie
 */
public class ClientFrame extends JFrame implements ItemListener{
    
    // This panel contains all the other possible panels.
    private JPanel cards;
    private final String LOGIN_PANEL = "Login";
    private final String REGISTER_PANEL = "Register";
    
    
    public ClientFrame(){
        cards = new JPanel(new CardLayout());
        
        JPanel lPanel = new LoginPanel();
        JPanel rPanel = new RegisterPanel();
        
        cards.add(lPanel, LOGIN_PANEL);
        cards.add(rPanel, REGISTER_PANEL);
        configureUi();
    }
    
    private void configureUi(){
        JPanel comboBoxPane = new JPanel(); //use FlowLayout
        String comboBoxItems[] = { LOGIN_PANEL, REGISTER_PANEL };
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);
        
        add(comboBoxPane, BorderLayout.PAGE_START);
        add(cards, BorderLayout.CENTER);
    }
    
    public static void main(String [] args){
        ClientFrame frame = new ClientFrame();
        
        frame.pack();
        frame.setVisible(true);
        frame.setSize(300, 300);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)e.getItem());
    }
}
