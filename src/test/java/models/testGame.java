package models;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by michaelhilton on 1/25/16.
 */
public class testGame {

    @Test
    public void testGameCreation(){
        Game g = new Game();
        assertNotNull(g);
    }


    @Test
    public void testGameStart(){
        Game g = new Game();

        g.deck.shuffle();
        g.dealFour();
        assertEquals(48, g.deck.size());
        assertEquals(1,g.getcol1().size());
        assertEquals(1,g.getcol2().size());
        assertEquals(1,g.getcol3().size());
        assertEquals(1,g.getcol4().size());

     //   assertEquals(true, g.cols.get(1).columnHasCards()); can't do since private access
    }

    @Test
    public void testCustomDeal(){
        Game g = new Game();
        g.customDeal(0,3,6,9);
        assertEquals("2Clubs", g.getcol1().get(0).toString());
        assertEquals("3Clubs",g.getcol2().get(0).toString());
        assertEquals("4Clubs",g.getcol3().get(0).toString());
        assertEquals("5Clubs",g.getcol4().get(0).toString());
    }

    @Test
    public void testRemoveFunction(){
        Game g = new Game();
        //g.buildDeck();
        g.customDeal(0,3,6,9);
        g.remove(2);
        assertEquals(0,g.getcol3().size());
    }

    @Test
    public void testMoveFunction(){
        Game g = new Game();
        g.customDeal(51, 3, 6, 9);
        g.remove(1);
        g.move(0, 1);
        assertEquals("14Spades",g.getcol2().get(0).toString());
    }

    @Test
    public void testWrongMoveFunction(){
        Game g = new Game();
        g.customDeal(51, 3, 6, 9);
        g.move(0, 1);
        assertEquals("This spot isn't empty to move the card to!",g.e.getMessage());
    }
}
