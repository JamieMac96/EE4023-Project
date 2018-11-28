/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navigation;

import java.awt.CardLayout;
import java.util.Stack;
import javax.swing.JPanel;
import util.PanelNames;

/**
 *
 * @author jamie
 */
public class NavigationHandler {
    private static Stack<String> backStack;
    private static CardLayout cl;
    private static String currentCard;
    
    private static JPanel cards;
    
    public static void init(){
        cards = new JPanel(new CardLayout());
        //backStack = new Stack<>();
        cl = (CardLayout)cards.getLayout();
    }
    
    public static void addCard(JPanel card, String name){
        cards.add(card, name);
    }
    
    public static void setCurrentCard(String cardName){
//        if(currentCard != null){
//            backStack.push(currentCard);
//        }
        
        cl.show(cards, cardName);
        currentCard = cardName;
    }
    
    public static void back(){
//        if(!backStack.isEmpty()){
//            System.out.println("changing card");
//            cl.show(cards, backStack.pop());
//        }
//        else{
//            System.out.println("backstack EMPTY");
//        }

        if(currentCard != null) {
            if(!currentCard.equals(PanelNames.MAIN_PANEL) && !currentCard.equals(PanelNames.REGISTER_PANEL) && !currentCard.equals(PanelNames.LOGIN_PANEL)) {
                currentCard = PanelNames.MAIN_PANEL;
                cl.show(cards, PanelNames.MAIN_PANEL);
            }
            else {
                currentCard = PanelNames.REGISTER_PANEL;
                cl.show(cards, PanelNames.REGISTER_PANEL);
            }
        }
    }
    
    public static JPanel getCards(){
        return cards;
    }
}
