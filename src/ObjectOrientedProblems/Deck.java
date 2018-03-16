package ObjectOrientedProblems;

import java.util.ArrayList;
import java.util.Collections;

public class Deck <T extends Card> {
    //<T extends Card> means we are using generics in the deck but they must be a subclass of card
    private ArrayList<T> cards; //the array of all the cards
    private int dealtInd = 0; //the starting index for the rest of the undealt cards, init at 0 for an undealt deck

    public void setDeck(ArrayList<T> deckOfCards){
        this.cards = deckOfCards;
    }

    public void shuffle(){
        Collections.shuffle(this.cards);
    }

    public int remainingCards(){
        return cards.size() - dealtInd;
    }

    /*public T[] dealHand(int num){

    }*/
}
