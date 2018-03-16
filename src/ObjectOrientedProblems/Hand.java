package ObjectOrientedProblems;

import java.util.ArrayList;

public class Hand <T extends Card> {
    //hand uses generic type but that type must be a subclass of Card (like blackjackcard)
    protected ArrayList<T> cards = new ArrayList<>();

    //because value for a card is an abstract method, score is defined differently for each specification of card
    public int score(){
        int score = 0;
        for (Card c: cards) {
            score += c.value();
        }
        return score;
    }

    public void addCard(T card){
        cards.add(card);
    }

    public void print(){
        for (Card c: cards){
            c.print();
        }
    }

}
