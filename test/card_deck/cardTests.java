package card_deck;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.HashMap;
import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Neel Patel
 */
public class cardTests {
    
    Deck d;
//    Card c;
    
    @Before
    public void setUp() {
        d = new Deck();
        
    }
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void deckIsShuffled(){
//        int[] suitCount = new int[4];
//        for(int i = 0; i < 100000; i++){
//            d = new Deck();
//            Card c;
//            Iterator<Card> cardIterator = d.getIterator();
            
//        }
    }
    
    @Test
    public void specifiedCardIsReturnedCorrectly(){
        String clubSuit = "clubs";
        String heartSuit = "hearts";
        String value = "3";
        Card cA, cB, cC, cD;
        cA = d.getCard(clubSuit, value);
        cD = d.getCard(heartSuit, value);
        cB = new Card("clubs", "3");
        cC = new Card("hearts", "3");
        
        assertEquals("Wrong card obtained.", cA, cB);
        assertNotEquals("Wrong card obtained.", cA, cD);
        assertEquals("Wrong card obtained.", cC, cD);
    }
    
    
    @Test
    public void deckIsAValidStandardDeck(){
        Card c;
        int suitCount = 0;
        int valueCount = 0;
        Iterator<Card> cardIterator = d.getIterator();
        while(cardIterator.hasNext()){
            c = cardIterator.next();
            if(c.getSuit().equals("spades") || 
               c.getSuit().equals("clubs") ||
               c.getSuit().equals("hearts") ||
               c.getSuit().equals("diamonds")){
                suitCount++;
            }
            if(c.getValue().equals("ace") || 
               c.getValue().equals("2") || c.getValue().equals("3") ||
               c.getValue().equals("4") || c.getValue().equals("5") || 
               c.getValue().equals("6") || c.getValue().equals("7") || 
               c.getValue().equals("8") || c.getValue().equals("9") || 
               c.getValue().equals("10") || c.getValue().equals("jack") || 
               c.getValue().equals("queen") || c.getValue().equals("king")){
                valueCount++;
            }
        }
        
        assertEquals("Value count of cards unequal to number of cards in standard deck.", 
                valueCount, Deck.CARD_SIZE);
        assertEquals("Suit count of cards unequal to number of cards in standard deck.", 
                suitCount, Deck.CARD_SIZE);
        
    }
    
}
