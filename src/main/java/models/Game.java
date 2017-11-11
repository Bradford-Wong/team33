package models;
import  models.Error;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
        import javax.swing.JButton;
        import javax.swing.JFrame;
        import javax.swing.JOptionPane;
/**
 * Assignment 1: Students must implement dealFour(), remove(), move(), and columnHasCards() methods
 *
 * The customDeal() method is not present in the Assignment1_Student version since tests (and the test dir) are removed
 * to prevent confusion regarding testing and the use of unit tests; testing is covered more thoroughly in CS362.
 */

public class Game {

    public java.util.List<Card> deck = new ArrayList<>();

    public java.util.List<Column> cols = new ArrayList<>();

    public void buildDeck() {
        for(int i = 2; i < 15; i++){
            deck.add(new Card(i,Suit.Clubs));
            deck.add(new Card(i,Suit.Hearts));
            deck.add(new Card(i,Suit.Diamonds));
            deck.add(new Card(i,Suit.Spades));
        }
    }

    public void shuffle() {
        long seed = System.nanoTime();
        Collections.shuffle(deck, new Random(seed));
    }

    public void dealFour() {
        for(int i = 0; i < 4; i++){
            cols.get(i).addCardToCol(deck.get(deck.size()-1));
            deck.remove(deck.size()-1);
        }
    }

    //customDeal to setup game for testing purposes
    public void customDeal(int c1, int c2, int c3, int c4) {
        cols.get(0).addCardToCol(deck.get(c1));
        deck.remove(c1);
        cols.get(1).addCardToCol(deck.get(c2));
        deck.remove(c2);
        cols.get(2).addCardToCol(deck.get(c3));
        deck.remove(c3);
        cols.get(3).addCardToCol(deck.get(c4));
        deck.remove(c4);
    }

    public void remove(int columnNumber) {
        for (int i = 0; i < 4; i++) {
            if (i != columnNumber) {
                cols.get(i).remove();
            }
        }
    }


    public void move(int columnFrom, int columnTo) {
        //
        if(cols.get(columnFrom).columnHasCards()){
            Card cardToMove = cols.get(columnFrom).getTopCard();
            if(!cols.get(columnTo).columnHasCards() && cardToMove.getValue() == 14 && cols.get(columnFrom).columnHasCards()){ //check that moving to empty column. Will need to change this line a bit when refactor
                this.removeCardFromCol(columnFrom);
                this.addCardToCol(columnTo,cardToMove);
            }else { //When make an invalid move when there is a card in the column that moving from
                Error e = new Error();
                if(columnFrom == columnTo){
                    e.infoBox("Can't move to the same column!", "Moving Error");
                }
                if(cols.get(columnTo).columnHasCards()){
                    e.infoBox("This spot isn't empty to move the card to!", "Moving Error");

                }
                if(!cols.get(columnTo).columnHasCards() && cardToMove.getValue() != 14 && cols.get(columnFrom).columnHasCards()){
                    e.infoBox("Can't move non-Ace Cards!", "Moving Error");
                }
            }
        }else{ //when the column moving from is empty
            if(cols.get(columnFrom).columnHasCards() == false){
                Error e = new Error();
                e.infoBox("This spot doesn't have any cards to move from!","Moving Error");

            }

        }



    }

    private void addCardToCol(int columnTo, Card cardToMove) {
        cols.get(columnTo).addCardToCol(cardToMove);
    }

    private void removeCardFromCol(int colFrom) {
        this.cols.get(colFrom).remove();
    }



}

