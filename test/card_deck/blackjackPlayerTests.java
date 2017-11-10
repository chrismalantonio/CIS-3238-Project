/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package card_deck;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Chris
 */
public class blackjackPlayerTests {

    Deck d;
    BlackjackPlayer p;

    @Before
    public void setUp() {
        d = new Deck();
        p = new BlackjackPlayer(d);
    }

    @Test
    public void drawCardFromTopOfDeck() {
        for (int i = 0; i < 2; i++) {
            p.draw(d);
        }
        assertEquals(p.hand.size(), 2);

    }

    @Test
    public void cardValueGreaterThanZero() {
        p.draw(d);
        boolean check = false;
        if (p.getHandCount() > 0) {
            check = true;
        }
        assertTrue(check);

    }
}
