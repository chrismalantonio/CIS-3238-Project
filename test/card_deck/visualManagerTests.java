/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package card_deck;

import gameWindow.GoFishWindow;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import visualManager.visualManager;

/**
 *
 * @author Neel Patel
 */
public class visualManagerTests {
    
    Deck d;
    Gofish gofish;
    visualManager v; 
    GoFishWindow gWindow;
    
    public visualManagerTests() {
        d = new Deck();
        gofish = new Gofish(d);
        v = new visualManager(); 
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void visualManagerCanRelayInfoFromWindowToGame() {
        gWindow = new GoFishWindow();
        visualManager vm = new visualManager();
//        assertEquals("Game and window not connected.", vm.connect(gofish), 41);
    }

    @Test
    public void checkImagePath(){
        String king = "/images/13.png";
        Card card = new Card("clubs", "king");    
        assertEquals(v.getCardLocation(card), king);
    }
    
}
