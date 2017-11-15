/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package card_deck;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Neel Patel
 */
public class Gofish extends Game{
    
    
    public GofishPlayer[] AI;
    public final int DEFAULT_DECK_SIZE = 7;
    private boolean GAME_COMPLETE = false;
    
    
    public Gofish(Deck d) {
        super(d);
        AI = new GofishPlayer[3];
        for(int i = 0; i < AI.length; i++){
            AI[i] = new GofishPlayer();
        }        

        
    }
    
    public void trackBooks(){
        
    }
    
    public Iterator<Card> getBooks(GofishPlayer p){
        return p.books.iterator();
    }
    
    public boolean checkIfAiHasCard(Card c, Player AI){
        for(Card card: AI.hand){
            if(card.equals(c)){
                return true;
            }
        }
        return false;
    }
    
    
    
    public boolean giveCardToPlayer(Card c, GofishPlayer to, GofishPlayer from){
        if(!from.hand.contains(c)){
            return false;
        }
        from.hand.remove(c);
        to.hand.add(c);
        if(to.checkForBooks(c)){
            to.addBook(c);
        }
        return true;
    }
    
    public boolean addCard(){
        return false;
    }
    
    public int playGofish(){
        for(GofishPlayer ai:AI){
            for(int i = 0; i < 7; i++){
                ai.draw(d);
            }
        }
//        
//        while(!GAME_COMPLETE){
//            
//            
//        }
        return 0;
    }
}
