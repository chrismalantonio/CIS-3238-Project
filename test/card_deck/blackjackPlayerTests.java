/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package card_deck;

import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotEquals;
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
        if (p.hand.count > 0) {
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

        Card ace = new Card("diamonds", "ace");
        Card five = new Card("clubs", "5");
        Card seven = new Card("spades", "7");

        p.hand.cards.add(ace);
        p.hand.cards.add(five);
        p.hand.cards.add(seven);

        assertTrue(p.hand.count < 21);
    }

    @Test
    public void splitIntoTwoHands() {
        Card cFive = new Card("clubs", "5");
        Card sFive = new Card("spades", "5");

        p.hand.cards.add(cFive);
        p.hand.cards.add(sFive);

        p.split();
        assertEquals(p.hand.count, p.hand2.count);
    }

    @Test
    public void handCountNotSame() {
        Card cFive = new Card("clubs", "5");
        Card sFive = new Card("spades", "5");

        p.hand.cards.add(cFive);
        p.hand.cards.add(sFive);

        p.split();
        p.draw(p.hand2, d);

//        assertNotEquals(p.hand.count, p.hand2.count);
    }

    @Test
    public void bustSecondHand() {
        Card cFive = new Card("clubs", "5");
        Card sFive = new Card("spades", "5");

        p.hand.cards.add(cFive);
        p.hand.cards.add(sFive);

        p.split();
        for (int i = 0; i < 50; i++) {
            p.draw(p.hand2, d);
        }

        assertTrue(p.bust(p.hand2));
    }

    @Test
    public void testGetValueOfCard() {
        int cardVal, cardVal2;

        Card queen = new Card("clubs", "queen");
        Card king = new Card("spades", "king");

        p.hand.cards.add(queen);
        p.hand.cards.add(king);
        
        cardVal = p.getCardValue(p.hand, 0);
        cardVal2 = p.getCardValue(p.hand, 1);

        assertEquals(cardVal, cardVal2); 
    
    }
}
