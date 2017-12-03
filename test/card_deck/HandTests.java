/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package card_deck;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Chris
 */
public class HandTests {
    
    Hand hand;
    
    @Before
    public void setUp(){
        hand = new Hand();       
    }
    
    @Test
    public void countIsZero(){       
        assertEquals(hand.count, 0); 
    }
    
    @Test
    public void handIsEmpty(){
        
        assertTrue(hand.cards.isEmpty()); 
    }
    
}
