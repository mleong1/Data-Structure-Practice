package ObjectOrientedProblems;

public class BlackJackCard extends Card {
    //extending Card gives blackjackcard all the same fields (available, facevalue, suit)
    //now we can focus on specifying a blackjack card, namely in terms of defining the value of a card
    //need to implement abstract method value() from abstract class Card

    public BlackJackCard(int fV, Suit s){
        super(fV, s);
    }
    public int value(){
        return 1;
    }

    public boolean isAce(){
        //1 represents the ace
        return faceValue == 1;
    }

    public boolean isFaceCard(){
        //11 - 13 inclusive are face cards
        return faceValue >= 11 && faceValue <= 13;
    }

}
