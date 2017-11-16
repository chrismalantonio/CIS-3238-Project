/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package card_deck;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author Neel Patel
 */
public class Gofish extends Game{
    
    
    public GofishPlayer[] AI;
    public final int DEFAULT_DECK_SIZE = 7;
    private boolean GAME_COMPLETE = false;
    private final int PLAYER_VAL = 4;
    private int difficulty = 5;
    private int recentMemory = 0;
    private HashMap<GofishPlayer, Card[]> memories;

    public Gofish(Deck d) {
        super(d);
        memories = new HashMap<GofishPlayer, Card[]>();
        AI = new GofishPlayer[3];
        for(int i = 0; i < AI.length; i++){
            AI[i] = new GofishPlayer();
            memories.put(AI[i], new Card[5]);
        }        
    }
    
    public void trackBooks(){
        
    }
    
    public Iterator<Card> getBooks(GofishPlayer p){
        return p.books.iterator();
    }
    
    public boolean checkIfAiHasCard(Card c, Player AI){
        for(Card card: AI.hand){
            if(card.equals(c)){
                return true;
            }
        }
        return false;
    }
    
    public boolean askPlayerForCard(Card c, Player p){
        if(p == null){
            //SIDE TRACKED
        }
        return false;
    }
    
    public boolean giveCardToPlayer(Card c, GofishPlayer to, GofishPlayer from){
        if(!from.hand.contains(c)){
            return false;
        }
        from.hand.remove(c);
        to.hand.add(c);
        if(to.checkForBooks(c)){
            to.addBook(c);
        }
        return true;
    }
    
    public boolean addCard(){
        return false;
    }
    
    public int updateAIMemory(Card c, Player p){
        this.shiftDown(memories.get(p));
        memories.get(p)[0] = c;
        return 0;
    }
    
    public void shiftDown(Card[] cards){
        for(int i = cards.length-1; i > 0; i--){
            cards[i] = cards[i-1];
        }
    }
    
    public Iterator getMemories(){
        return memories.values().iterator();
    }
    
    public Card mostRecentCard(Player AI){
        return memories.get(AI)[0];
    }
    
    public int updatePlayerMemory(Card c){
        
        return 0;
    }
    
    public int playGofish(){
        for(GofishPlayer ai:AI){
            for(int i = 0; i < 7; i++){
                ai.draw(d);
            }
        }
        /**
         * Create a while loop that cycles through each player.
         * The AI players will all have the same behavior, so nothing
         * special with them. We can just script their actions, something
         * like: Create a buffer that holds the memory of the last N turns for
         * all players. We can tweak N and make it bigger to increase the AI's 
         * difficulty.
         * 
         * Examine each buffer and see if any card value from the buffer is the
         * same as a value in the AI's hand.
         * If that is the case, ask that player for the card, and get it if they
         * still have it, or draw a card from the pool if the other player
         * doesn't have the card.
         * Once that is done, see if any books can be formed, and if so, remove
         * those cards from the AI's hand and place them in the book list. That
         * ends the AI player's turn.
         * 
         * The player's case requires entering another while loop that will wait
         * for the player to make a move. When it is the player's turn, they might
         * want to see what books each AI has completed, as well as decide which
         * AI to ask a card from.
         * The while loop will wait for the player to choose an AI player and
         * request a card. It will then give the player the card if the AI has it
         * or make the player draw a card from the pool if the AI doesn't have 
         * the card.
         * Once the transfer is complete, the game will attempt to create a book 
         * from the player's hand and remove the cards from the player's hand, 
         * placing them into the player's book list.
         * After that, the player's turn will end and we cycle through all the AI 
         * players again
         */
        
        
        return 0;
    }
}
