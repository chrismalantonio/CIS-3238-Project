/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameWindow;

import card_deck.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Chris
 */
public class blackjackWindowTests {

    BlackjackWindow window;

    @Before
    public void setUp() {
        window = new BlackjackWindow();
    }

    /* returns true if player can split */
    private boolean canSplit() {
        return window.player.hand.cards.get(0).value.equals(window.player.hand.cards.get(1).value);
    }

    @Test
    public void testHitButton() {
        window.hitButton();
        assertEquals(window.player.hand.cards.size(), 3);
    }

    @Test
    public void testSplitButton() {
        while (!canSplit()) {
            window.createNewGame();
        }
        window.splitButton();
        assertEquals(window.player.hand.cards.size(), window.player.hand2.cards.size());
    }

    @Test
    public void bustSplitHand() {
        while (!canSplit()) {
            window.createNewGame();
        }
        for (int i=0; i < 40; i++){
            window.hit2Button();
        }
        
        assertTrue(window.player.bust(window.player.hand2));
        
    }

}
