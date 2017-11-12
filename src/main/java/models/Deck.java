package models;

import  models.Error;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Deck {
    public java.util.List<Card> deck_arr = new ArrayList<Card>();

    public Deck(){}

    public void shuffle() {
        long seed = System.nanoTime();
        Collections.shuffle(this.deck_arr, new Random(seed));

    }
    public void buildDeck() {
        for(int i = 2; i < 15; i++){
            deck_arr.add(new Card(i,Suit.Clubs));
            deck_arr.add(new Card(i,Suit.Hearts));
            deck_arr.add(new Card(i,Suit.Diamonds));
            deck_arr.add(new Card(i,Suit.Spades));
        }

    }
    public int size() {
        return this.deck_arr.size();
    }
    public Card get(int i) {
        return this.deck_arr.get(i);
    }
    public void remove(int i)
    {
        this.deck_arr.remove(i);
    }




}
