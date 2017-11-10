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
    
    @Override
    public boolean equals(Object c){
        if(c == this){return true;}
        
        if(!(c instanceof Card)){
            return false;
        }
        
        Card cN = (Card) c;
        
        return (this.value.equals(cN.value) && this.suit.equals(cN.suit));
    }
    
    public boolean isCard(String suit, String value){
        if(this.suit.equals(suit) && this.value.equals(value)){
            return true;
        }
        return false;
    }
    
    public String getValue(){return this.value;}
    public String getSuit(){return this.suit;}
    
}
