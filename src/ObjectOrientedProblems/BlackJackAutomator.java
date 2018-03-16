package ObjectOrientedProblems;

import java.util.ArrayList;

public class BlackJackAutomator {
    private Deck<BlackJackCard> deck;

    public void initDeck(){
        ArrayList<BlackJackCard> deckOfCards = new ArrayList<>();
        for(int i = 1; i < 14; i ++){
            for(int j = 0; j < 4; j ++) {
                Suit s = Suit.getSuitFromValue(j);
                BlackJackCard card = new BlackJackCard(i, s);
                deckOfCards.add(card);
            }
        }
        deck = new Deck();
        deck.setDeck(deckOfCards);
        deck.shuffle();
    }

    public static void main(String[] args) {
        BlackJackAutomator auto = new BlackJackAutomator();
        auto.initDeck();
        //auto.deck.print();
        BlackJackHand hand = new BlackJackHand();
        hand.addCard(auto.deck.dealCard());
        hand.addCard(auto.deck.dealCard());
        hand.addCard(auto.deck.dealCard());
        auto.deck.print();
        System.out.println("HAND CARDS");
        hand.print();
        hand.score();
    }
}
