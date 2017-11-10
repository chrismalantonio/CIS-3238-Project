/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package card_deck;

/**
 *
 * @author Chris Malantonio
 */
public class Game {

    Deck d; 
    public int[] record = new int[2];
    public int wins, losses;

    public Game(Deck d) {
       this.d = d; 
        record[0] = wins;
        record[1] = losses;
    }

    public void updateRecord() {
        record[0] = wins;
        record[1] = losses;
    }

}
