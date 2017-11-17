/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameWindow;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Neel Patel
 */
public class GoFishWindowTest {
    GoFishWindow window;
    public GoFishWindowTest() {
        GoFishWindow window = new GoFishWindow();
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
    public void pressingInteractButtonBringsUpMenu(){
        
    }

    @Test
    public void interactButtonShowsMenu(){
        boolean[] buttonPressStatus = {false};
        for(int i = 0; i < 3; i++){
            assertEquals("Menu did not show up when clicked.", true,
                    window.pressButton(i));
        }
        
    }
}
