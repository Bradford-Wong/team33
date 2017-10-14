package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
//THIS IS A TESTTTTT
/**
 * Assignment 1: Each of the blank methods below require implementation to get AcesUp to build/run
 */
public class Game {

    public java.util.List<Card> deck = new ArrayList<>();

    public java.util.List<java.util.List<Card>> cols = new ArrayList<>(4);





    public Game(){
        // initialize a new game such that each column can store cards

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
        Random random = new Random();
        for(int i = 0; i < 999999; i++){
                int a = random.nextInt(52);
                int b = random.nextInt(52);
            Card temp = deck.get(a);
            deck.set(a, deck.get(b));
            deck.set(b,temp);
        }
        //just to check if the shuffle works by printing it on the terminal screen(uncomment if you want to test)*/
        for(int i = 0; i<52; i++) {
            System.out.println(deck.get(i).suit + "\t" + deck.get(i).value);
        }

        // shuffles the deck so that it is

    }
//deals four cards when user clicks deal or at beginning of game, will stop dealing when no more cards left in deck
    public void dealFour() { //deck.add(new Card(i,Suit.Clubs));
        for(int i = 0; i < 4; i++){
            if(deck.isEmpty() != true){
                Card temp = deck.get(0);
                cols.add(new ArrayList<Card>());
                deck.remove(0);
                cols.get(i).add(temp);
            }
        }
        // remove the top card from the deck and add it to a column; repeat for each of the four columns
    }

    public void remove(int columnNumber) {
        // remove the top card from the indicated column
        this.cols.get(columnNumber).remove(0);
    }

    private boolean columnHasCards(int columnNumber) {
        // check indicated column for number of cards; if no cards return false, otherwise return true
        if(this.cols.get(columnNumber).size() > 0){
            return true;
        } else {
            return false;
        }
    }

    private Card getTopCard(int columnNumber) {
        return this.cols.get(columnNumber).get(this.cols.get(columnNumber).size()-1);
    }


    public void move(int columnFrom, int columnTo) {
        // remove the top card from the columnFrom column, add it to the columnTo column
    }

    private void addCardToCol(int columnTo, Card cardToMove) {
        cols.get(columnTo).add(cardToMove);
    }

    private void removeCardFromCol(int colFrom) {
        this.cols.get(colFrom).remove(this.cols.get(colFrom).size()-1);
    }
}
