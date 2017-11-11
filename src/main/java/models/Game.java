


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

    private java.util.List<Column> cols = new ArrayList<>();


    public Game(){
        cols.add(new Column());
        cols.add(new Column());
        cols.add(new Column());
        cols.add(new Column());
    }

    public void buildDeck() {
        for(int i = 2; i < 15; i++){
            deck.add(new Card(i,Suit.Clubs));
            deck.add(new Card(i,Suit.Hearts));
            deck.add(new Card(i,Suit.Diamonds));
            deck.add(new Card(i,Suit.Spades));
        }
    }

    public java.util.List<Card> getcol1() {    //This is because apparantly the routing backend has trouble converting the columns to json
        return cols.get(0).col;
    }

    public java.util.List<Card> getcol2() {    //This is because apparantly the routing backend has trouble converting the columns to json
        return cols.get(1).col;
    }

    public java.util.List<Card> getcol3() {    //This is because apparantly the routing backend has trouble converting the columns to json
        return cols.get(2).col;
    }

    public java.util.List<Card> getcol4() {    //This is because apparantly the routing backend has trouble converting the columns to json
        return cols.get(3).col;
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
        if(cols.get(columnNumber).columnHasCards()) {
            Card c = cols.get(columnNumber).getTopCard();
            boolean removeCard = false;
            // Error e = new Error();
            for (int i = 0; i < 4; i++) {
                if (i != columnNumber) {
                    if (cols.get(i).columnHasCards()) {
                        Card compare = cols.get(i).getTopCard();
                        //System.out.println(compare);
                        if (compare.getSuit() == c.getSuit()) {
                            if (compare.getValue() > c.getValue()) {
                                removeCard = true;
                            }
                        }
                    }
                }
            }
            if (removeCard) {
                this.cols.get(columnNumber).removeCard();
            }
            else {
                Error e = new Error();
                e.infoBox("A card can only be removed when another card is showing at the top of another pile with the same suit and higher value!", "Remove Error");
            }
        }
    }


    public void move(int columnFrom, int columnTo) {
        System.out.println("GASP1");
        if(cols.get(columnFrom).columnHasCards()){
            System.out.println("GASP2");
            Card cardToMove = cols.get(columnFrom).getTopCard();
            System.out.println(!cols.get(columnTo).columnHasCards());
            System.out.println(cardToMove.getValue() == 14);
            System.out.println(cols.get(columnFrom).columnHasCards());

            if(!cols.get(columnTo).columnHasCards() && cardToMove.getValue() == 14 && cols.get(columnFrom).columnHasCards()){ //check that moving to empty column. Will need to change this line a bit when refactor
                //System.out.println(compare);
                System.out.println("GASP2.5");
                cols.get(columnFrom).removeCard();
                System.out.println("GASP3");
                cols.get(columnTo).addCardToCol(cardToMove);
                System.out.println("SUCCESS");
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
}

