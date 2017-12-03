package models;

import java.util.ArrayList;

public class SpanishDeck extends Deck {

    public SpanishDeck() {
        //The real initializer is setupDeck below.
    }

    public void setupDeck() {
        for (int i = 1; i < 13; i++) {
            deck_arr.add(new Card(i, Suit.Bastos));
            deck_arr.add(new Card(i, Suit.Oros));
            deck_arr.add(new Card(i, Suit.Copas));
            deck_arr.add(new Card(i, Suit.Espadas));
        }
        deck_arr.add(new Card(0, Suit.Joker));
        deck_arr.add(new Card(0, Suit.Joker));
    }
}
