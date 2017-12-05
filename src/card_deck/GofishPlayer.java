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
    public int ID;
    
    public GofishPlayer(){
        super();
        books = new ArrayList<Card>();
    }
    
    public boolean checkForBooks(Card c){
        int bookCounter = 0;
        handIterator = hand.iterator();
        Card d;
        while(handIterator.hasNext() && bookCounter < BOOK_SIZE){
            d = handIterator.next();
            if(c.value.equals(d.value)){
                return true;
            }
        }
        return false;
    }
    
    public void setID(int ID){
        this.ID = ID;
    }
    

    
    public void addBook(Card c){
        handIterator = hand.iterator();
        Card d = null;
        while(handIterator.hasNext()){
            d = handIterator.next();
            if(c.value.equals(d.value)){
                books.add(c);
                books.add(d);
                break;
            }
        }
        if(d != null){
            this.hand.remove(d);
        }
    }
}
