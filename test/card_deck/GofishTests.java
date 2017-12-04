/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package card_deck;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
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

        d = new Deck();
        gofish = new Gofish(d);
        Player AI = new Player();
        AI.draw(d);
        Card c = AI.hand.get(0);
        assertEquals("AI does not have card specified.",
                gofish.checkIfAiHasCard(new Card(c.suit, c.value), AI), true);
    }
    
    @Test
    public void AiShouldNotHaveCardSpecified(){
        d = new Deck();
        gofish = new Gofish(d);
        Player aAI = new Player();
        Player bAI = new Player();
        int handSize = d.cards.size() /2;
        for(int i = 0; i < handSize; i++){
            aAI.draw(d); bAI.draw(d);
        }
        
//        for(int i = 0; i < 100000; i++){
//            gofish.d = new Deck();
//            Card aC = aAI.hand.get((int)(Math.floor(handSize * Math.random())));
//            Card bC = bAI.hand.get((int)(Math.floor(handSize * Math.random())));
////            assertNotEquals("The deck has two cards that are the same.", 
////            aC,bC);
//        }
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
    public void currentCardAddedToMemory(){
        Card c = new Card("spades", "2");
        gofish = new Gofish(new Deck());
        gofish.updateAIMemory(c, gofish.AI[0]);
        
        assertEquals("Card not in AI player's memory.", c, 
                gofish.mostRecentCard(gofish.AI[0]));
    }
    
    @Test
    public void oldCardsPushedBackInMemory(){
        Card cX = new Card("clubs", "2");
        Card[] c = new Card[6];
        c[0] = new Card("spades", "ace");
        c[1] = new Card("spades", "2");
        c[2] = new Card("spades", "3");
        c[3] = new Card("spades", "4");
        c[4] = new Card("spades", "5");
        c[5] = new Card("spades", "6");
        gofish = new Gofish(new Deck());

        Card[] memories = gofish.getMemories(gofish.AI[0]);
        
        gofish.updateAIMemory(cX, gofish.AI[0]);

        assertEquals("Card in first position is not the first card remembered.",
                     cX, memories[0]);

        for(Card n: c){
            gofish.updateAIMemory(n, gofish.AI[0]);
        }
        
        for(Card n: memories){
//            assertNotEquals("Card that was in memory but removed is still in"
//                    + "memory.", n, c[0]);
        }
    }
    
    @Test
    public void gofishGameGeneratesFairPlayers(){
        gofish = new Gofish(new Deck());
        gofish.dealCards();
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
        
    @Test
    public void AskingForACardReturnsTrueIfOtherAIHasTheCard(){
        gofish = new Gofish(new Deck());
        GofishPlayer A = gofish.AI[0];
        GofishPlayer B = gofish.AI[1];
        for(int i = 0; i < 10; i++){
            A.draw(gofish.d);
            B.draw(gofish.d);
        }
        Card ACard = A.hand.get(0);
        
        boolean hasCard = gofish.askPlayerForCard(ACard, A);
        assertEquals("askPlayerForCard returned false even though the player has"
                + "a card with matching value.", hasCard, true);
    }
    
    @Test
    public void AIMemoryHasCards(){
        gofish = new Gofish(new Deck());
        GofishPlayer A = gofish.AI[0];
        Card[] c = gofish.getMemories(A);
        for(Card C: c){
            assertNotNull("Card in memory is null.", C);
        }
    }
    
    @Test 
    public void AskForCardReturnFalseWhenPlayerDoesntHaveCard(){
        gofish = new Gofish(new Deck());
        GofishPlayer A = gofish.AI[0];
        GofishPlayer B = gofish.AI[1];
        A.hand.add(new Card("heart", "ace"));
        A.hand.add(new Card("heart", "2"));
        A.hand.add(new Card("heart", "3"));
        A.hand.add(new Card("heart", "4"));
        
        B.hand.add(new Card("spades", "5"));
        B.hand.add(new Card("spades", "6"));
        B.hand.add(new Card("spades", "7"));
        B.hand.add(new Card("spades", "8"));
        
        Card ACard = A.hand.get(0);
        boolean hasCard = gofish.askPlayerForCard(ACard, B);
        assertEquals("askPlayerForCard returns true when player does not"
                + "have the requested card.", hasCard, false);
    }
    
    @Test 
    public void AIChoosesACardToRequestFromAPlayer(){
        gofish = new Gofish(new Deck());
        GofishPlayer A = gofish.AI[0];
        GofishPlayer B = gofish.AI[1];
        gofish.updateAIMemory(new Card("heart", "ace"), A);
        Card c = gofish.chooseCardToAskFor(A, gofish.getRandomPlayer(A));
        assertNotNull("AI didn't choose a card from memory.", c);
    }
    
    @Test
    public void requestedCardGoesInPlayerMemory(){
        gofish = new Gofish(new Deck());
        GofishPlayer A = gofish.AI[0];
        GofishPlayer B = gofish.AI[1];
        A.hand.add(new Card("Hearts", "3"));
        B.hand.add(new Card("Spades", "2"));
        Card C = A.hand.get(0);
        if(!gofish.askPlayerForCard(A.hand.get(0), B)){
            gofish.updateAIMemory(C, A);
        }
        Card[] aMem = gofish.getMemories(A);
        boolean cardInMemory = false;
        for(Card c: aMem){
            if(c.equals(C)){
                cardInMemory = true;
            }
        }
        
        assertEquals("Rejected card not in AI's memory.", cardInMemory, true);
    }
    
    @Test
    public void memoryNotUpdatedWhenBookFound(){
        gofish = new Gofish(new Deck());
        GofishPlayer A = gofish.AI[0];
        GofishPlayer B = gofish.AI[1];
        A.hand.add(new Card("Hearts", "3"));
        B.hand.add(new Card("spades", "3"));
        
        if(!gofish.askPlayerForCard(A.hand.get(0), B)){
            gofish.updateAIMemory(A.hand.get(0),A);
        }
        Card[] aMem = gofish.getMemories(A);
        boolean cardInMemory = false;
        for(Card c: aMem){
            if(c.equals(A.hand.get(0))){
                cardInMemory = true;
            }
        }
        
        assertEquals("Card that formed book went to memory.",
                cardInMemory, false);
    }
    
    @Test
    public void AiTurnChangesTheStateOfTheHand(){
        gofish = new Gofish(new Deck());
        GofishPlayer A = gofish.AI[0];
        GofishPlayer B = gofish.AI[1];
        GofishPlayer C = gofish.AI[2];
        GofishPlayer D = gofish.HUMAN;
        for(int i = 0; i < 10; i++){
            A.draw(gofish.d);
            B.draw(gofish.d);
            C.draw(gofish.d);
            D.draw(gofish.d);
        }
        Card bCard = B.hand.get(0);
        Card[] bMem = gofish.getMemories(B);
        for(int i = 0; i < 5; i++){
            bMem[i] = bCard;
        }
        Card cCard = C.hand.get(0);
        Card[] cMem = gofish.getMemories(C);
        for(int i = 0; i < 5; i++){
            cMem[i] = cCard;
        }
        Card dCard = D.hand.get(0);
        Card[] dMem = gofish.getMemories(D);
        for(int i = 0; i < 5; i++){
            dMem[i] = dCard;
        }
        
        ArrayList<Card> handBeforeTurn = new ArrayList<Card>();
        for(Card c: A.hand){
            handBeforeTurn.add(c);
        }
        gofish.AITurn(A);
        ArrayList<Card> handAfterTurn = new ArrayList<Card>();
        for(Card c: A.hand){
            handAfterTurn.add(c);
        }
        assertEquals("Hands before and after turn are still the same.",
                handBeforeTurn.equals(handAfterTurn), false);
    }
    
    @Test
    public void playGame(){
        gofish = new Gofish(new Deck());
        gofish.playGofish();
    }
}
