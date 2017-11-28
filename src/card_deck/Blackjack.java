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
        if (p.handCount > cpu.handCount && p.handCount <= 21) {
            wins++;
        } else {
            losses++;
        }
    }

    public void decideWinner(BlackjackPlayer player, BlackjackPlayer cpu, Deck deck) {
        /* Dealer draws until it beats one hand or busts */
        if (!player.hand2.cards.isEmpty()) {
            while (cpu.hand.handCount < player.hand.handCount
                    && cpu.hand.handCount < player.hand2.handCount
                    && (player.hand.handCount <= 21 || player.hand2.handCount <= 21)
                    && cpu.hand.handCount < 17) {
                cpu.hit(cpu.hand, deck);
            }
            checkHands(player.hand, cpu.hand);
            checkHands(player.hand2, cpu.hand);
        } else {
            while (cpu.hand.handCount < player.hand.handCount && player.hand.handCount <= 21) {
                cpu.hit(cpu.hand, deck);
            }
            checkHands(player.hand, cpu.hand);
        }
    }

}
