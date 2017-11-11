package models;

import java.util.ArrayList;

public class Column {

    public java.util.List<Card> col = new ArrayList<Card>();

    public Column(){

    }


    public boolean removeCard() {
        if(columnHasCards()) {
            Card c = getTopCard();
            boolean removeCard = false;
            // Error e = new Error();

            if (columnHasCards()) {
                Card compare = getTopCard();
                //System.out.println(compare);
                if (compare.getSuit() == c.getSuit()) {
                    if (compare.getValue() > c.getValue()) {
                        removeCard = true;
                    }
                }
            }

            if (removeCard) {
                this.col.remove(this.col.size() - 1);
                return true;
            }
            else {
                Error e = new Error();
                e.infoBox("A card can only be removed when another card is showing at the top of another pile with the same suit and higher value!", "Remove Error");
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean columnHasCards() {
        if(this.col.size()>0){
            return true;
        } else {
            return false;
        }
    }

    public Card getTopCard() {
        return this.col.get(this.col.size()-1);
    }

    public void addCardToCol(Card cardToMove) {
        col.add(cardToMove);
    }

}
