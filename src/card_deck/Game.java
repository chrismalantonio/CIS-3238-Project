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

    public int[] record = new int[2];
    public int wins, losses;

    Deck d;
    public Game() {
        record[0] = wins;
        record[1] = losses;
    }
    
    public Game(Deck d){
        this();
        this.d = d;
    }

    public void updateRecord() {
        record[0] = wins;
        record[1] = losses;
    }
}
