package models;

import org.junit.Test;


import java.util.ArrayList;

import static org.junit.Assert.*;


public class testColumn{
        @Test
    public void testColumnCreate(){
        Column c = new Column();
        assertNotNull(c);

    }
    @Test
    //this is to test that the top 4 cards in the column are what they are
    public void testColumnTopCard(){
        Deck d = new Deck();

        Column c = new Column();

        d.setupDeck();

        c.addCardToCol(d.get(0));
        assertEquals("2Clubs",c.getTopCard().toString());


        }
        @Test
    public void testColumnNotTopCard(){
        Deck d = new Deck();
        Column c = new Column();


        d.setupDeck();

        c.addCardToCol(d.get(0));
        assertNotEquals("2Hearts",c.getTopCard().toString());

    }
    @Test
    public void testColumnHasCards(){
        Deck d = new Deck();
        Column c = new Column();


        d.setupDeck();


        assertEquals(false,c.columnHasCards());
    }
    @Test
    public void testColumnRemoveColumn() {
        Deck d = new Deck();
        Column c = new Column();


        d.setupDeck();
        assertEquals(false,c.removeCard());
    }
    }

