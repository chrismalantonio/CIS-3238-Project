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
    public void playerIsAbleToTakeACardFromOpponent(){
        
    }
    
    @Test
    public void playerCanGiveACardToOpponent(){
        
    }
    
    @Test 
    public void sometest(){
        
    }
    
    @Test
    public void checkBooksConfirmsBookStatus(){
        Deck d = new Deck();
        p.hand.add(new Card("hearts", "two"));
        p.hand.add(new Card("clubs", "two"));
        assertEquals("Book exists but checkBooks didn't find it.", true, 
                    p.checkForBooks(p.hand.get(0)));
    }
    

}
