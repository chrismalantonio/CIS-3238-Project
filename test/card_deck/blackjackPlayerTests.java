/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package card_deck;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
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
        p = new BlackjackPlayer();
    }

    @Test
    public void drawCardFromTopOfDeck() {
        for (int i = 0; i < 2; i++) {
            p.draw(p.hand, d);
        }
        assertEquals(p.hand.cards.size(), 2);

    }

    @Test
    public void cardValueGreaterThanZero() {
        p.draw(p.hand, d);
        boolean check = false;
        if (p.hand.handCount > 0) {
            check = true;
        }
        assertTrue(check);

    }

    @Test
    public void testBust() {
        for (int i = 0; i < 50; i++) {
            p.draw(p.hand, d);
        }
        assertTrue(p.bust(p.hand));
    }

    @Test
    public void changeAceValueTest() {

        Card c = new Card("diamonds", "ace");
        Card c5 = new Card("clubs", "5");
        Card c7 = new Card("spades", "7");

        p.hand.cards.add(c);
        p.hand.cards.add(c5);
        p.hand.cards.add(c7);

        assertTrue(p.hand.handCount < 21);
    }

    @Test
    public void splitIntoTwoHands() {
        Card cc5 = new Card("clubs", "5");
        Card cs5 = new Card("spades", "5");

        p.hand.cards.add(cc5);
        p.hand.cards.add(cs5);

        p.split();
        assertEquals(p.hand.handCount, p.hand2.handCount);
    }

    @Test
    public void handCountNotSame() {
        Card cc5 = new Card("clubs", "5");
        Card cs5 = new Card("spades", "5");

        p.hand.cards.add(cc5);
        p.hand.cards.add(cs5);

        p.split();
        p.draw(p.hand2, d);

        assertNotEquals(p.hand.handCount, p.hand2.handCount);
    }

    @Test
    public void bustSecondHand() {
        Card cc5 = new Card("clubs", "5");
        Card cs5 = new Card("spades", "5");

        p.hand.cards.add(cc5);
        p.hand.cards.add(cs5);

        p.split();
        for (int i = 0; i < 50; i++) {
            p.draw(p.hand2, d);
        }
        
        assertTrue(p.bust(p.hand2)); 
    }
}
