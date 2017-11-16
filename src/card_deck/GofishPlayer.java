/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package card_deck;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Neel Patel
 */
public class GofishPlayer extends Player{
    
    
    public ArrayList<Card> books;
    private Iterator<Card> bookIterator;
    Iterator<Card> handIterator;

    private final int BOOK_SIZE = 2;
    public GofishPlayer(){
        super();
    }
    
    public boolean checkForBooks(Card c){
        int bookCounter = 0;
        handIterator = hand.iterator();
        Card d;
        while(handIterator.hasNext() && bookCounter < BOOK_SIZE){
            d = handIterator.next();
            if(c.value.equals(d.value) && !c.suit.equals(d.suit)){
                bookCounter++;
            }
        }
        return bookCounter == BOOK_SIZE;
    }
    
    public void addBook(Card c){
        handIterator = hand.iterator();
        Card d;
        boolean matchFound = false;
        for(Card handC: hand && !matchFound){
            if(c.value.equals(handC.value) && !c.suit.equals(handC.suit)){
                matchFound = true;
                d = handC;
            }
        }
        
        books.add(c);
        books.add(d);
    }
}
