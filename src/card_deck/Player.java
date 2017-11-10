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
    Deck d;
    
    public Player() {
        this.hand = new ArrayList<Card>(); 
}

    public void draw(Deck d) {
        int topOfDeck = d.cards.size() - 1;
        hand.add((d.cards.remove(topOfDeck)));
    }

}
