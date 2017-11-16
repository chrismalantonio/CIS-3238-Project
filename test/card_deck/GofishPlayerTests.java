/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package card_deck;

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
public class GofishPlayerTests {

    GofishPlayer p;
    public GofishPlayerTests() {
        p = new GofishPlayer();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        p = new GofishPlayer();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void playerHasCorrectStartingCardAmount(){
        
    }
    
    @Test
    public void checkBooksConfirmsBookStatus(){
        Deck d = new Deck();
        for(int i = 0; i < 10; i++){
            p.draw(d);
        }
        boolean bookExists = false;
        Card c = p.hand.get(0);
        for(int i = 1; i < 10; i++){
            if(c.equals(p.hand.get(i))){
                bookExists = true;
            }
        }
        if(bookExists){
            assertEquals("Book exists but checkBooks did not find it.", 
                        bookExists, p.checkForBooks(c));
        }else{
            assertEquals("Nonexistent book found in player book list", bookExists,
                        p.checkForBooks(c));
        }
    }

    @Test
    public void cardsInBookAreNotInHand(){
        Deck d = new Deck();
        for(int i = 0; i < 52; i++){
            p.draw(d);
        }
        
        Card a = p.hand.get(0);
        p.addBook(a);
        int remCards = 0;
        for(Card c: p.hand){
            if(c.value.equals(a.value)){
                remCards++;
            }
        }
        
        assertEquals("Book creation failed.", remCards, 2);
        
    }
}
