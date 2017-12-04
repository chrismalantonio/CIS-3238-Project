/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package card_deck;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

/**
 *
 * @author Neel Patel
 */
public class Gofish extends Game {

    public GofishPlayer[] AI;
    public final int DEFAULT_DECK_SIZE = 7;
    private boolean GAME_COMPLETE = false;
    private final int PLAYER_VAL = 4;
    private int difficulty = 5;
    public GofishPlayer HUMAN;
    private HashMap<GofishPlayer, Card[]> memories;

    public Gofish(Deck d) {
        /*
         Initializes the game, creates AI players and their memory buffers.
         Sets the size of the memory buffer to the difficulty value, higher
         difficulty = more previous cards remembered.
         */
        super(d);
        memories = new HashMap<GofishPlayer, Card[]>();
        AI = new GofishPlayer[3];
        for (int i = 0; i < AI.length; i++) {
            AI[i] = new GofishPlayer();
            AI[i].setID(i);
            memories.put(AI[i], new Card[difficulty]);
        }
        HUMAN = new GofishPlayer();
        HUMAN.setID(4);
        memories.put(HUMAN, new Card[difficulty]);
        this.initializeAIMemories();
    }

    public void trackBooks() {

    }

    public Iterator<Card> getBooks(GofishPlayer p) {
        /*
         Returns an iterator of all the obtained books of an AI player.
         */
        return p.books.iterator();
    }

    public boolean checkIfAiHasCard(Card c, Player AI) {
        /*
         Checks if an AI player has a card.
         */
        for (Card card : AI.hand) {
            if (card.value.equals(c.value)) {
                return true;
            }
        }
        return false;
    }

    public boolean askPlayerForCard(Card c, GofishPlayer p) {
        /*
         Request a card from a player, returns true if they have it.
         */
        if (p == HUMAN) {
            //AI wants a card from the player
        } else {
            return this.checkIfAiHasCard(c, p);
        }
        return false;
    }

    public boolean giveCardToPlayer(Card c, GofishPlayer to, GofishPlayer from) {
        /*
         Transfer a card from one player to another player.
         */
        if (!from.hand.contains(c)) {
            return false;
        }
        from.hand.remove(c);
        to.hand.add(c);
        if (to.checkForBooks(c)) {
            to.addBook(c);
        }
        return true;
    }

    public Card chooseCardToAskFor(GofishPlayer AI, GofishPlayer askTo) {
        /*
         AI looks through memory and picks a player and card to ask for.
         */
        return this.memories.get(askTo)[(int) Math.floor(Math.random()
                * this.difficulty)];
    }

    public GofishPlayer getRandomPlayer(GofishPlayer requester) {
        int player;
        do {
            player = (int) Math.floor(Math.random() * 4.0);
        } while (player < 3 && this.AI[player].equals(requester));

        if (player == 3) {
            return HUMAN;
        }
        return this.AI[player];
    }

    private void initializeAIMemories() {
        Deck temp = new Deck();
        for (GofishPlayer p : this.AI) {
            for (int i = 0; i < this.difficulty; i++) {
                this.memories.get(p)[i] = temp.cards.get((int) Math.floor(
                        Math.random() * 52));
            }
        }

        for (int i = 0; i < this.difficulty; i++) {
            this.memories.get(this.HUMAN)[i] = temp.cards.get((int) Math.floor(
                    Math.random() * 52));
        }
    }

    public void AITurn(GofishPlayer P) {
        /*
         Choose a player, and look through their memory to see if they have
         a card value that current player has, ask for that card from that player.
         If the other player has the card, they give it to the current player, or
         the current player draws a new card and ends the turn.
         */
        GofishPlayer otherP = this.getRandomPlayer(P);
        Card request = this.chooseCardToAskFor(P, otherP);
        System.out.println(P.ID + " Asking for card " + request.toString()
                + " from " + otherP.ID);
        if (this.askPlayerForCard(request, otherP)) {
            System.out.println(otherP.ID + " Has " + request.toString());
            this.giveCardToPlayer(request, P, otherP);
        } else {
            System.out.println(P.ID + " has to gofish.");
            P.draw(this.d);
        }
    }

    public boolean addCard() {
        return false;
    }

    public int updateAIMemory(Card c, GofishPlayer p) {
        /*
         Updates the AI's memory by adding the most recent card requested by any
         player.
         */
        this.shiftDown(memories.get(p));
        memories.get(p)[0] = c;
        return 0;
    }

    public void shiftDown(Card[] cards) {
        /*
         Moves all the cards in the buffer down.
         */
        for (int i = cards.length - 1; i > 0; i--) {
            cards[i] = cards[i - 1];
        }
    }

    public Card[] getMemories(GofishPlayer AI) {
        /*
         Returns an array containing all the cards the AI has seen most recently.
         */
        return memories.get(AI);
    }

    public Card mostRecentCard(GofishPlayer AI) {
        /*
         Returns the most recent card the AI saw.
         */
        return memories.get(AI)[0];
    }

    public int updatePlayerMemory(GofishPlayer P, Card c) {
        this.shiftDown(memories.get(HUMAN));
        memories.get(HUMAN)[0] = c;
        return 0;
    }

    public void dealCards() {
        for (GofishPlayer ai : AI) {
            for (int i = 0; i < 7; i++) {
                ai.draw(d);
            }
        }
    }

    public int playGofish() {
        /**
         * Create a while loop that cycles through each player. The AI players
         * will all have the same behavior, so nothing special with them. We can
         * just script their actions, something like: Create a buffer that holds
         * the memory of the last N turns for all players. We can tweak N and
         * make it bigger to increase the AI's difficulty.
         *
         * Examine each buffer and see if any card value from the buffer is the
         * same as a value in the AI's hand. If that is the case, ask that
         * player for the card, and get it if they still have it, or draw a card
         * from the pool if the other player doesn't have the card. Once that is
         * done, see if any books can be formed, and if so, remove those cards
         * from the AI's hand and place them in the book list. That ends the AI
         * player's turn.
         *
         * The player's case requires entering another while loop that will wait
         * for the player to make a move. When it is the player's turn, they
         * might want to see what books each AI has completed, as well as decide
         * which AI to ask a card from. The while loop will wait for the player
         * to choose an AI player and request a card. It will then give the
         * player the card if the AI has it or make the player draw a card from
         * the pool if the AI doesn't have the card. Once the transfer is
         * complete, the game will attempt to create a book from the player's
         * hand and remove the cards from the player's hand, placing them into
         * the player's book list. After that, the player's turn will end and we
         * cycle through all the AI players again
         */
        this.dealCards();
        int currentPlayer = 0;
        while (!GAME_COMPLETE) {
            System.out.println("------------------------------------");
            if(currentPlayer == 3){
            }
            System.out.println("It is " + currentPlayer + "'s turn.");
            this.AITurn(this.AI[currentPlayer]);
            currentPlayer = currentPlayer+1 % this.PLAYER_VAL;
        }

        return 0;
    }
}
