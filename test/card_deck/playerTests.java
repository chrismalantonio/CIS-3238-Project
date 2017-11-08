/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package card_deck;

import java.util.Iterator;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Chris
 */
public class playerTests {

    Deck d;
    Player p;

    @Before
    public void setUp() {
        d = new Deck();
        p = new Player();
    }

    @Test
    public void drawCardFromTopOfDeck() {
        int topOfDeck = d.cards.size() - 1;
        for (int i = 0; i < 2; i++) {
            p.draw(d.cards.remove(topOfDeck));
            topOfDeck--;
        }
        assertEquals(p.hand.size(), 2);

    }

    @Test
    public void countDeckAfterDraw() {
        int topOfDeck = d.cards.size() - 1;
        for (int i = 0; i < 4; i++) {
            p.draw(d.cards.remove(topOfDeck));
            topOfDeck--;
        }
        assertEquals(d.cards.size(), 48);

    }

    @Test
    public void drawAllCardsFromDeck() {
        int topOfDeck = d.cards.size() - 1;
        for (int i = 0; i < 54; i++) {
            p.draw(d.cards.remove(topOfDeck));
            topOfDeck--;
            if (d.cards.isEmpty()) {
                d = new Deck();
                topOfDeck = d.cards.size() - 1;
            }
        }
        assertEquals(d.cards.size(), 50);
    }

}
