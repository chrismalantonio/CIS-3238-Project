/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualManager;

import card_deck.*;
import gameWindow.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class visualManager extends Thread{
    
    public visualManager(){
        
    }

    @Override
    public void run(){
        try {
            this.connect(new Gofish(new Deck()));
        } catch (InterruptedException ex) {
            Logger.getLogger(visualManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public synchronized int connect(Gofish game) throws InterruptedException{
        GoFishWindow window = new GoFishWindow();
        window.linkWindow(game.AI);
        window.setVisible(true);
        int currentPlayerIndex = 0;
        game.dealCards();
        GofishPlayer human = game.HUMAN;
        GofishPlayer player = null;
        while(!game.isOver()){
            if(currentPlayerIndex == 3){
                if (!window.valuesFound()){
                    System.out.println("Player turn, going to wait until player "
                            + "has made a request.");
                    this.wait();
                    System.out.println("Did I wake up?");
                }
                GofishPlayer AIplayer = window.getPlayerRequest();
                Card card = window.getCardRequest();
                System.out.println("Player has made a decision. They want to "
                        + "request a " + card.value + " from " + AIplayer.ID);
                window.nullifyValues();
                game.humanTurn(AIplayer, card);
            }else{
                game.executeAITurn(currentPlayerIndex);
            }
            if((player  = game.checkForWinner()) != null){
                System.out.println(player.ID + " has an empty hand. Game is over.");
                System.out.println("Checking for winner...");
                player = game.findWinner();
                System.out.println("The winner is " + player.ID + " who has a "
                        + "total of " + player.books.size()/2 + " books.");
            }
            currentPlayerIndex = (currentPlayerIndex+1) % 4;
        }
        return 0;
    }

    public String getCardLocation(Card c) {
        String value = c.getValue();
        String suit = c.getSuit();
        int numValue, numSuit;
        numValue = numSuit = 0;
        switch (value) {
            case "ace":
                numValue = 1;
                break;
            case "jack":
                numValue = 11;
                break;
            case "queen":
                numValue = 12;
                break;
            case "king":
                numValue = 13;
                break;
            default:
                numValue = Integer.parseInt(c.getValue());
        }

        switch (suit) {
            case "clubs":
                numSuit = 1;
                break;
            case "spades":
                numSuit = 2;
                break;
            case "hearts":
                numSuit = 3;
                break;
            case "diamonds":
                numSuit = 4;
                break;
            default:
                break;
        }
        
        return "/images/" + ((13*(numSuit-1)) + numValue) + ".png" ;
    }

}
