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
public class BlackjackPlayer extends Player {

    Deck d;
    private int handCount;
    private int lastCard;

    public BlackjackPlayer(Deck d) {
        super();
        this.d = d;
//this.hand = new ArrayList<Card>(); 
    }

    @Override
    public void draw(Deck d) {
        int topOfDeck = d.cards.size() - 1;
        hand.add((d.cards.remove(topOfDeck)));
        lastCard = getCardValue();

    }

    /*  if player's hand is less than 21, he may draw another card */
    public void hit() {
        //Check if player's hand < 21
        if (!bust()) {
            draw(d);
        }
    }

    /*  if player's hand is over 21 return true */
    public boolean bust() {
        return handCount > 21;
    }

    /* get value of the newest card in your hand 
        and update handCount */
    private int getCardValue() {
        int topOfHand = hand.size() - 1;
        Card c = hand.get(topOfHand);
        String value = c.getValue();
        int numValue;
        switch (value) {
            case "ace":
                if (handCount > 11) {
                    numValue = 1;
                } else {
                    numValue = 11;
                }
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
        handCount += numValue;
        return numValue;
    }

    public int getHandCount() {
        return handCount;
    }
}
