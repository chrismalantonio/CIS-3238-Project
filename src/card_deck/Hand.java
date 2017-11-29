/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package card_deck;

import java.util.ArrayList;

/**
 *
 * @author Chris
 */
public class Hand {

    public ArrayList<Card> cards;
    public int count;
    public int aces;

    public Hand() {
        cards = new ArrayList<Card>();
    }

}