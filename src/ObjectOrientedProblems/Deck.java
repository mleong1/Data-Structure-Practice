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

    public T[] dealHand(int num){
        if(this.remainingCards() < num){
            //can't deal a hand with cards you don't have
            return null;
        }

        //initialize a generic array
        T[] hand = (T[]) new Card[num];
        int i = 0;
        while(i < num){
            T handCard = this.dealCard();
            if(handCard != null){
                hand[i] = handCard;
                i ++;
            }
        }
        return hand;
    }

    public T dealCard(){
        if(this.remainingCards() == 0){
            return null;
        }

        T card = this.cards.get(dealtInd);
        card.markUnavailable();
        dealtInd ++;

        return card;
    }
}
