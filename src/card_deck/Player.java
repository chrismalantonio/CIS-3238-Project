/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package card_deck;

import java.util.ArrayList;

/**
 *
 * @author Chris Malantonio
 */
public class Player {

    public ArrayList<Card> hand;
    
    public Player() {
        this.hand = new ArrayList<Card>(); 
}

    public void draw(Card c, int topOfDeck) {
        hand.add(c);
    }

}
