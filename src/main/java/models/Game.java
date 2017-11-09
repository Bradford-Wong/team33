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

    public java.util.List<java.util.List<Card>> cols = new ArrayList<>();


    public Game(){
        cols.add(new ArrayList<Card>());
        cols.add(new ArrayList<Card>());
        cols.add(new ArrayList<Card>());
        cols.add(new ArrayList<Card>());
    }

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
            cols.get(i).add(deck.get(deck.size()-1));
            deck.remove(deck.size()-1);
        }
    }

    //customDeal to setup game for testing purposes
    public void customDeal(int c1, int c2, int c3, int c4) {
        cols.get(0).add(deck.get(c1));
        deck.remove(c1);
        cols.get(1).add(deck.get(c2));
        deck.remove(c2);
        cols.get(2).add(deck.get(c3));
        deck.remove(c3);
        cols.get(3).add(deck.get(c4));
        deck.remove(c4);
    }

    public void remove(int columnNumber) {
        if(columnHasCards(columnNumber)) {
            Card c = getTopCard(columnNumber);
            Error e = new Error();
            boolean removeCard = false;
            for (int i = 0; i < 4; i++) {
                if (i != columnNumber) {
                    if (columnHasCards(i)) {
                        Card compare = getTopCard(i);
                        if (compare.getSuit() == c.getSuit()) {
                            if (compare.getValue() > c.getValue()) {
                                removeCard = true;
                            }
                        }
                    }
                }
            }
            if (removeCard) {
                this.cols.get(columnNumber).remove(this.cols.get(columnNumber).size() - 1);
            }
        }
    }

    private boolean columnHasCards(int columnNumber) {
        if(this.cols.get(columnNumber).size()>0){
            return true;
        }
        return false;

    }

    private Card getTopCard(int columnNumber) {
        return this.cols.get(columnNumber).get(this.cols.get(columnNumber).size()-1);
    }


    public void move(int columnFrom, int columnTo) {
        //
        if(columnHasCards(columnFrom)){
            Card cardToMove = getTopCard(columnFrom);
            if(!columnHasCards(columnTo) && cardToMove.getValue() == 14 && columnHasCards(columnFrom)){ //check that moving to empty column. Will need to change this line a bit when refactor
                this.removeCardFromCol(columnFrom);
                this.addCardToCol(columnTo,cardToMove);
            }else { //When make an invalid move when there is a card in the column that moving from
                Error e = new Error();
                if(columnFrom == columnTo){
                    e.infoBox("Can't move to the same column!", "Moving Error");
                }
                if(columnHasCards(columnTo)){
                    e.infoBox("This spot isn't empty to move the card to!", "Moving Error");

                }
                if(!columnHasCards(columnTo) && cardToMove.getValue() != 14 && columnHasCards(columnFrom)){
                    e.infoBox("Can't move non-Ace Cards!", "Moving Error");
                }
            }
        }else{ //when the column moving from is empty
            if(columnHasCards(columnFrom) == false){
                Error e = new Error();
                e.infoBox("This spot doesn't have any cards to move from!","Moving Error");

            }

        }



    }

    private void addCardToCol(int columnTo, Card cardToMove) {
        cols.get(columnTo).add(cardToMove);
    }

    private void removeCardFromCol(int colFrom) {
        this.cols.get(colFrom).remove(this.cols.get(colFrom).size()-1);
    }



}

