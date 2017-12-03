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
public class BlackjackTests {

    Deck d;
    BlackjackPlayer p, cpu;
    Blackjack g;

    @Before
    public void setUp() {
        d = new Deck();
        p = new BlackjackPlayer();
        cpu = new BlackjackPlayer();
        g = new Blackjack();
    }

    @Test
    public void playerShouldWinTwice() {
        Card ace = new Card("diamonds", "ace");
        Card ace2 = new Card("hearts", "ace");
        Card king = new Card("clubs", "king");
        Card jack = new Card("spades", "jack");
        Card two = new Card("spades", "two");
        Card three = new Card("spades", "three");

        /* simulate 21 in both player hands
            and 20 in dealer's hand         */
        p.hand.cards.add(ace);
        p.hand.cards.add(jack);
        p.hand.count = 21;

        p.hand.cards.add(king);
        p.hand2.cards.add(ace2);
        p.hand2.count = 21;

        cpu.hand.cards.add(two);
        cpu.hand.cards.add(three);
        cpu.hand.count = 20;

        g.decideWinner(p, cpu, d);

        assertEquals(g.wins, 2);

    }

    @Test
    public void dealerDrawsWhenUnder17() {
        Card king = new Card("clubs", "king");
        Card jack = new Card("spades", "jack");
        Card nine = new Card("spades", "nine");
        Card six = new Card("spades", "six");

        /*  Player hand count: 19
            Dealer hand count: 16   */
        p.hand.cards.add(king);
        p.hand.cards.add(nine);
        p.hand.count = 19;

        cpu.hand.cards.add(jack);
        cpu.hand.cards.add(six);
        cpu.hand.count = 16;

        g.decideWinner(p, cpu, d);

        assertNotSame(cpu.hand.count, 16);
    }

    @Test
    public void cpuShouldNotDraw() {
        p.hand.count = 19;
        cpu.hand.count = 17;
        g.decideWinner(p, cpu, d);

        assertEquals(cpu.hand.count, 17);
    }

    @Test
    public void gameShouldTie() {
        p.hand.count = 21;
        cpu.hand.count = 21;

        g.decideWinner(p, cpu, d);

        assertEquals(g.ties, 1);

    }

    @Test
    public void dealerShouldDrawAfterSplit() {
        Card three = new Card("hearts", "three");
        Card three2 = new Card("spades", "three");
        Card four = new Card("spades", "four");
        Card four2 = new Card("hearts", "four");
        Card eight = new Card("spades", "eight");

        p.hand.cards.add(three);
        p.hand.cards.add(four);
        p.hand.cards.add(eight);
        
        p.hand2.cards.add(three2);
        p.hand2.cards.add(four2);

        p.hand.count = 15;
        p.hand2.count = 7;
        cpu.hand.count = 13;
        
        g.decideWinner(p, cpu, d); 
        
        assertNotEquals(cpu.hand.count, 13); 
    }
}
