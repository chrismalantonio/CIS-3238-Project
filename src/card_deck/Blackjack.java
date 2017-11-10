/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package card_deck;

/**
 *
 * @author Chris
 */
public class Blackjack extends Game {

    BlackjackPlayer cpu;
    
    //int current

    public Blackjack(Deck d) {
        super(d); 
        cpu = new BlackjackPlayer(d);
    }

}
