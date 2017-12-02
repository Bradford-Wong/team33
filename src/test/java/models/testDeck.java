package models;
import org.junit.Test;


import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;



public class testDeck {
    @Test
    public void testDeckCreate(){
        Deck d = new Deck();
        assertNotNull(d);
    }

    @Test
    public void testDeckFilled(){

            Deck d = new Deck();
            assertEquals(52,d.deck_arr.size());
        }
    @Test
    public void testDeckShuffled(){
        Deck deck1 = new Deck();
        deck1.shuffle();
        Deck deck2 = new Deck();
        deck2.shuffle();
        for(int i = 2; i < 15; i++){
        assertFalse( Arrays.equals(deck1.deck_arr.toArray(),deck2.deck_arr.toArray()));
    }
}
}
