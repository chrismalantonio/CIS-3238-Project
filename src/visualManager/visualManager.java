/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package visualManager;
import card_deck.*;
import gameWindow.*;
/**
 *
 * @author Neel Patel
 */
public class visualManager {
    public static void main(String[] args) {        
    }
    
    public int connect(Gofish game){
        GoFishWindow window = new GoFishWindow();
        window.setVisible(true);
//        if(window.activateButton()){
//            game.playGofish();
//            return game.getCurrentTurn();
//        }
        return Integer.MIN_VALUE;
    }
}
