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
public class BlackjackPlayer {

    private int lastCard;
    public Hand hand;
    public Hand hand2;

    public BlackjackPlayer() {
        this.hand = new Hand();
        this.hand2 = new Hand();
    }

    public void draw(Hand h, Deck d) {
        int topOfDeck = d.cards.size() - 1;
        h.cards.add((d.cards.remove(topOfDeck)));
        increaseHandCount(h);
    }

    /*  if player's hand is less than 21, he may draw another card */
    public void hit(Hand h, Deck d) {
        //Check if player's hand < 21
        if (!bust(h)) {
            draw(h, d);
        }
    }

    /*  if player's hand is over 21 return true */
    public boolean bust(Hand h) {
        return h.count > 21;
    }

    /* get value of the newest card in your hand 
        and update handCount */
    private void increaseHandCount(Hand h) {
        int topOfHand = h.cards.size() - 1;
        int numValue;
        Card c = h.cards.get(topOfHand);
        String value = c.getValue();
        switch (value) {
            case "ace":
                    numValue = 11;
                h.aces++;
                break;
            case "jack":
                numValue = 10;
                break;
            case "queen":
                numValue = 10;
                break;
            case "king":
                numValue = 10;
                break;
            default:
                numValue = Integer.parseInt(c.getValue());
        }
        h.count += numValue;
        if (h.aces > 0 && h.count > 21) {
            h.count -= 10;
            h.aces--; 
        }

    }

    /*  Checks if the original 2 cards given have the same value
        If true, split into 2 hands */
    public void split() {
        if (hand.cards.size() == 2) {
            if (getCardValue(hand, 0) == getCardValue(hand, 1)) {
                hand2.cards.add((hand.cards.remove(1)));
                if (hand.aces == 1) {
                    hand.count = hand2.count = 11;
                    hand.aces = 1;
                    hand2.aces = 1;
                } else {
                    hand.count = hand.count / 2;
                    hand2.count = hand.count;
                }
            }
        }
    }

    public int getCardValue(Hand h, int index) {
        int cardValue = 0;
        Card c = h.cards.get(index);
        String card = c.getValue();

        switch (card) {
            case "ace":
                cardValue = 1;
                break;
            case "jack":
                cardValue = 10;
                break;
            case "queen":
                cardValue = 10;
                break;
            case "king":
                cardValue = 10;
                break;
            default:
                cardValue = Integer.parseInt(c.getValue());
        }

        return cardValue;
    }

}
