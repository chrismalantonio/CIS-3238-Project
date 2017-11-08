/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package card_deck;

/**
 *
 * @author Neel Patel
 */
public class Card {
    public String value;
    public String suit;
    
    public Card(String suit, String value){
        this.suit = suit;
        this.value = value;
    }
    
    @Override
    public String toString(){
        return this.suit + " of " + this.value;
    }
    
    public String getValue(){return this.value;}
    public String getSuit(){return this.suit;}
    
}
