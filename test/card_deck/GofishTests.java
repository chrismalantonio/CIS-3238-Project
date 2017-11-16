/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package card_deck;

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
public class GofishTests {
    
    Deck d;
    Gofish gofish;
    GofishPlayer p, AI;
    
    public GofishTests() {
        d = new Deck();
        gofish = new Gofish(d);
        p = new GofishPlayer();
        AI = new GofishPlayer();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {

        
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void AiShouldHaveCardSpecified(){

        Deck d = new Deck();
        Gofish gofish = new Gofish();
        Player AI = new Player();
        AI.draw(d);
        Card c = AI.hand.get(0);
        assertEquals("AI does not have card specified.",
                gofish.checkIfAiHasCard(new Card(c.suit, c.value), AI), true);
    }
    
    @Test
    public void AiShouldNotHaveCardSpecified(){


        Deck d = new Deck();
        Gofish gofish = new Gofish();
        Player aAI = new Player();
        Player bAI = new Player();
        aAI.draw(d); bAI.draw(d);
        Card aC = aAI.hand.get(0);
        Card bC = bAI.hand.get(0);
//        assertNotEquals("Two players have the same card.", 
//                aC,bC);
    }
    
    @Test
    public void cardRemovedShouldNotBeInHand(){
        AI.hand.add(new Card("hearts", "ace"));
        gofish.giveCardToPlayer(new Card("hearts", "ace"), p, AI);
        assertEquals("Removed card still exists in hand.",
                    d.cards.contains(new Card("hearts", "ace")), true);
        
    }
    
    @Test
    public void playerShouldNotReturnCardTheyDontHave(){
        AI.hand.add(new Card("hearts", "ace"));
        assertEquals("Player returned a card they did not have.",
                gofish.giveCardToPlayer(new Card("hearts", "ace"), p, AI), true);
        
    }
    
    @Test
    public void gofishGameGeneratesFairPlayers(){
        gofish.playGofish();
        int aCount, bCount, cCount;
        aCount = gofish.AI[0].hand.size();
        bCount = gofish.AI[1].hand.size();
        cCount = gofish.AI[2].hand.size();
        assertEquals("Players have uneven cards in deck.", 
                     aCount, gofish.DEFAULT_DECK_SIZE);
        assertEquals("Players have uneven cards in deck.", 
                     bCount, gofish.DEFAULT_DECK_SIZE);
        assertEquals("Players have uneven cards in deck.", 
                     cCount, gofish.DEFAULT_DECK_SIZE);
        
    }
    
}
