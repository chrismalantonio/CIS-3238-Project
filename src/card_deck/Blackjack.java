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

    public void checkHands(Hand p, Hand cpu) {
        if (p.count > cpu.count && p.count <= 21) {
            wins++;
        } else {
            losses++;
        }
    }

    public void decideWinner(BlackjackPlayer player, BlackjackPlayer cpu, Deck deck) {
        /* Dealer draws until it has 17 or more points */
        if (!player.hand2.cards.isEmpty()) {
            while ((cpu.hand.count < player.hand.count
                    || cpu.hand.count < player.hand2.count)
                    && (player.hand.count <= 21 || player.hand2.count <= 21)
                    && cpu.hand.count < 17) {
                cpu.hit(cpu.hand, deck);
            }
            checkHands(player.hand, cpu.hand);
            checkHands(player.hand2, cpu.hand);
        } else {
            while (cpu.hand.count < player.hand.count && player.hand.count <= 21 && cpu.hand.count < 17) {
                cpu.hit(cpu.hand, deck);
            }
            checkHands(player.hand, cpu.hand);
        }
    }

}
