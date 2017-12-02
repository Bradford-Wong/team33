


package models;
import  models.Error;
import models.Deck;
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
    
    public Deck deck = new Deck();
    private java.util.List<Column> cols = new ArrayList<>();
    public Error e = new Error();

    public Game(){

        cols.add(new Column());
        cols.add(new Column());
        cols.add(new Column());
        cols.add(new Column());
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



    public void dealFour() {
        for(int i = 0; i < 4; i++){
            cols.get(i).addCardToCol(deck.get(deck.size()-1));
            deck.remove(deck.size()-1);
        }
    }

    //customDeal to setup game for testing purposes
    public void customDeal(int c1, int c2, int c3, int c4) {
        for(int columnNumber = 0; columnNumber < 4; columnNumber++){
            remove(columnNumber);
        }

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
            for (int i = 0; i < 4; i++) {
                if (i != columnNumber) {
                    if (cols.get(i).columnHasCards()) {
                        Card compare = cols.get(i).getTopCard();
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
                e.infoBox("A card can only be removed when another card is showing at the top of another pile with the same suit and higher value!", "Remove Error");
            }
        }
    }


    public void move(int columnFrom, int columnTo) {
        if(cols.get(columnFrom).columnHasCards()){
            Card cardToMove = cols.get(columnFrom).getTopCard();
            if(!cols.get(columnTo).columnHasCards() && cardToMove.getValue() == 14 && cols.get(columnFrom).columnHasCards()){ //check that moving to empty column. Will need to change this line a bit when refactor

                cols.get(columnFrom).removeCard();
                cols.get(columnTo).addCardToCol(cardToMove);
            }else { //When make an invalid move when there is a card in the column that moving from
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
                e.infoBox("This spot doesn't have any cards to move from!","Moving Error");

            }

        }



    }
}

