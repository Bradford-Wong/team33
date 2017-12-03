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
        //testing if column is returning wrong card
        @Test
    public void testColumnNotTopCard(){
        Deck d = new Deck();
        Column c = new Column();


        d.setupDeck();

        c.addCardToCol(d.get(0));
        assertNotEquals("2Hearts",c.getTopCard().toString());

    }
//tests if cards arent in column
    @Test
    public void testColumnDoesntCards(){
        Deck d = new Deck();
        Column c = new Column();


        d.setupDeck();


        assertEquals(false,c.columnHasCards());
    }
    @Test
    // tests if cards are in column
    public void testColumnHasCards(){
        Deck d = new Deck();
        Column c = new Column();
        d.setupDeck();
        c.addCardToCol(d.get(0));
        assertEquals(true,c.columnHasCards());
    }
    //tests if no cards to remove
    @Test
    public void testColumnNoRemoveColumn() {
        Deck d = new Deck();
        Column c = new Column();


        d.setupDeck();
        assertEquals(false,c.removeCard());
    }
    //Test card remove column
    @Test
    public void testColumnRemoveColumn() {
        Deck d = new Deck();
        Column c = new Column();


        d.setupDeck();
        c.addCardToCol(d.get(0));
        assertEquals(true,c.removeCard());
    }
    }

