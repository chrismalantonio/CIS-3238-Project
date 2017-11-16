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

    BlackjackPlayer p, cpu;
    
    //int current

    public Blackjack(BlackjackPlayer p) {
        super(); 
        this.p = p;
        cpu = new BlackjackPlayer();
    }

    public boolean playerWin(){
        if (cpu.hand.handCount < p.hand.handCount && p.hand.handCount<= 21){
            wins++; 
            return true;
        } else {
            losses++; 
            return false; 
        }
    }
}
