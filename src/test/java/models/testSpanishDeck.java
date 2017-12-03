package models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testSpanishDeck {
    @Test
    public void testJoker(){
        Game g = new Game();
        //Use spanish game
        g.setupGame("spanish");
        //There are 50 cards in a spanish deck. Jokers are put in last, so 48-49 should be jokers.
        g.customDeal(48, 1, 9, 10);
        //Make sure it's a joker. If it fails here that means that we are not using a joker.
        assertEquals(g.getcol1().get(0).getValue() , 0);
        assertEquals(g.getcol1().get(0).getSuit() , Suit.Joker);
        //Remove a card with the joker.
        g.remove(3);
        //Assert that both the joker and card are gone while the other ones are in place.
        assertEquals(0,g.getcol4().size());
        assertEquals(0,g.getcol1().size());
        assertEquals(1,g.getcol2().size());
        assertEquals(1,g.getcol3().size());
    }
}
