/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package card_deck;

/**
 *
 * @author Neel Patel
 */
public class Gofish extends Game{
    
    
    
    public Gofish(Deck d) {
        super(d);
    }
    
    public void trackBooks(){
        
    }
    
    public boolean checkIfAiHasCard(Card c, Player AI){
        for(Card card: AI.hand){
            if(card.equals(c)){
                return true;
            }
        }
        return false;
    }
    
    
    
}
