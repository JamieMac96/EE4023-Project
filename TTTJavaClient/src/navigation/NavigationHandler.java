/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navigation;

import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author jamie
 */
public class NavigationHandler {
    public static JPanel cards;
    
    public static void init(){
        cards = new JPanel(new CardLayout());
    }
    
    public static void addCard(JPanel card, String name){
        cards.add(card, name);
    }
    
    public static void setCurrentCard(String cardName){
        CardLayout cl = (CardLayout)cards.getLayout();
        
        cl.show(cards, cardName);
    }
    
    public static JPanel getCards(){
        return cards;
    }
}
