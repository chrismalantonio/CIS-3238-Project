/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package card_deck;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Neel Patel
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({card_deck.gameTests.class, card_deck.visualManagerTests.class, card_deck.GofishTests.class, card_deck.playerTests.class, card_deck.GofishPlayerTests.class, card_deck.blackjackPlayerTests.class, card_deck.cardTests.class})
public class NewTestSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
}
