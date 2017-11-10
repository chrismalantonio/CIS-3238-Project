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
 * @author Chris Malantonio
 */
public class gameTests {
    Deck d; 
    Game g;
    
        @Before
    public void setUp() {
        d = new Deck();
        g = new Game();
    }
    
    @Test
    public void checkStartingRecord(){
        int[]  record = new int[2];
        record[0] = 0;
        record[1] = 0;
        
        assertArrayEquals(record, g.record); 
        
    }
    
    @Test
    public void testUpdateRecord(){
        int[]  record = new int[2];
        g.wins = 5; 
        g.losses = 2; 
        record[0] = 5;
        record[1] = 2; 
        g.updateRecord(); 
        assertArrayEquals(record, g.record);
    }
}
