package models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testError {

    @Test
    public void testNotEmptyMoveFunction(){
        Game g = new Game();
        g.setupGame("normal");
        g.customDeal(51, 3, 6, 9);
        g.move(0, 1);
        assertEquals("This spot isn't empty to move the card to!",g.e.getMessage());
    }

    @Test
    public void testCorrectMove(){
        Game g = new Game();
        g.setupGame("normal");
        g.customDeal(51, 3, 6, 9);
        g.remove(1);
        g.move(0, 1);
        assertEquals("",g.e.getMessage());
    }

    @Test
    public void testNotEmptyMove(){
        Game g = new Game();
        g.setupGame("normal");
        g.customDeal(51, 3, 6, 9);
        g.move(0, 2);
        assertEquals("This spot isn't empty to move the card to!",g.e.getMessage());
    }

    @Test
    public void testNoCards(){
        Game g = new Game();
        g.setupGame("normal");
        g.customDeal(51, 3, 6, 9);
        g.remove(1);
        g.move(1, 2);
        assertEquals("This spot doesn't have any cards to move from!",g.e.getMessage());
    }

    @Test
    public void cantRemoveCard(){
        Game g = new Game();
        g.setupGame("normal");
        g.customDeal(0,3,6,9);
        g.remove(3);
        assertEquals("A card can only be removed when another card is showing at the top of another pile with the same suit and higher value!",g.e.getMessage());
    }

    @Test
    public void testMoveNonAce(){
        Game g = new Game();
        g.setupGame("normal");
        g.customDeal(29, 3, 6, 9);
        g.remove(1);
        g.move(0, 1);
        assertEquals("Can't move non-Ace Cards!",g.e.getMessage());
    }


}
