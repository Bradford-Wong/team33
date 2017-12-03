package models;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

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

    @Test
    public void testSpanishDeckSize(){
        Deck d = new SpanishDeck();
        d.setupDeck();
        assertEquals(50,d.size());
    }


    @Test
    public void testSpanishDeckShuffled() {
        Deck deck1 = new SpanishDeck();
        deck1.setupDeck();
        deck1.shuffle();
        Deck deck2 = new Deck();
        deck2.setupDeck();
        for (int i = 2; i < 15; i++) {
            assertFalse(Arrays.equals(deck1.deck_arr.toArray(), deck2.deck_arr.toArray()));
        }
    }
    @Test
    public void testSpanishDeckNotJoker(){
        Game g = new Game();
        //Use spanish game
        g.setupGame("spanish");
        //There are 50 cards in a spanish deck. Jokers are put in last, so 48-49 should be jokers.
        g.customDeal(2, 1, 9, 10);
        //Make sure it's not a joker.

        assertNotEquals(g.getcol1().get(0).getValue() , 0);
        assertNotEquals(g.getcol1().get(0).getSuit() , Suit.Joker);
        //Remove a card with the joker.
        g.remove(3);
        //Assert that you shouldnt be able to remove since there are no jokers.
        assertNotEquals(0,g.getcol4().size());
        assertNotEquals(0,g.getcol1().size());
        assertNotEquals(0,g.getcol2().size());
        assertNotEquals(0,g.getcol3().size());
    }
}
