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
  
    public Blackjack() {
        super(); 
    }

    public boolean playerWin(Hand p, Hand cpu){
        if (p.handCount > cpu.handCount && p.handCount <= 21){
            wins++; 
            return true;
        } else {
            losses++; 
            return false; 
        }
    }
}
