/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package card_deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author Neel Patel
 */
public class Deck {
    public final static int CARD_SIZE = 52;
    public final static int SUIT_SIZE = 4;
    public final static int VALUE_SIZE = 13;
    public ArrayList<Card> cards;
    public String[] suits = {"spades", "clubs", "hearts", "diamonds"};
    public String[] values = {"ace", "2", "3", "4",
                        "5", "6", "7", "8", "9", "10",
                        "jack", "queen", "king"};
    int i;
    public Deck(){ 
        this.cards = new ArrayList<Card>();
        for(int i = 0; i < SUIT_SIZE; i++){
            for(int j = 0; j < VALUE_SIZE; j++){
                cards.add(new Card(suits[i], values[j]));
            }
        }
        
        this.shuffle();
    }
    
    public Iterator<Card> getIterator(){
        return cards.iterator();
    }
    
    public void shuffle(){
        Collections.shuffle(this.cards);
    }
}
