package ObjectOrientedProblems;

public class BlackJackCard extends Card {
    //extending Card gives blackjackcard all the same fields (available, facevalue, suit)
    //now we can focus on specifying a blackjack card, namely in terms of defining the value of a card
    //need to implement abstract method value() from abstract class Card

    public BlackJackCard(int fV, Suit s){
        super(fV, s);
    }
    public int value(){
        if(this.isAce()){
            return 1;
        } else if (this.isFaceCard()){
            return 10;
        } else {
            return this.faceValue;
        }
    }

    public int minValue(){
        if(this.isAce()){
            return 1;
        } else {
            return this.faceValue;
        }
    }

    public int maxValue(){
        if(this.isAce()){
            return 11;
        } else {
            return this.faceValue;
        }
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
