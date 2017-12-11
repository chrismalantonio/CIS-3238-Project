/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameWindow;

import static org.junit.Assert.*;
import org.junit.*;

/**
 *
 * @author Chris
 */
public class DealerWindowTests {

    DealerWindow window;

    @Before
    public void setUp() {
        window = new DealerWindow();

    }

    @Test
    public void testNewGameButton() {
        window.newGameButton();
        assertEquals(window.dealer.hand.cards.size(), 2);
    }
    
    @Test 
    public void testStayButton(){
        window.stayButton(); 
        
        assertFalse(window.getStay().isVisible());
    }
}
