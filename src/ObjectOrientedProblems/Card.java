package ObjectOrientedProblems;

public abstract class Card {
    //Card is marked abstract because a card's value is dependant on the game (BlackJack)
    //We are going to assume a card is a regular poker card and not something like an uno card

    //boolean for whether the card is available from the deck
    private boolean available = true;
    /*2-10 are the numbered cards
      11, 12, 13 are jack, queen, king
      1 is th ace
      These number representations come into play in the specified blackjackcard class
     */
    protected int faceValue;
    protected Suit suit;

    public Card(int fV, Suit s){
        this.faceValue = fV;
        this.suit = suit;
    }

    public abstract int value();

    //getters and setters for availability
    public boolean isAvailable(){
        return available;
    }
    public void markUnavailable(){
        this.available = false;
    }
    public void markAvailable(){
        this.available = true;
    }

}
