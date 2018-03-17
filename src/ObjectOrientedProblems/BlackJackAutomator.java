package ObjectOrientedProblems;

import java.util.ArrayList;

public class BlackJackAutomator {
    private Deck<BlackJackCard> deck;
    private BlackJackHand[] hands;
    private Player[] players;

    /*public BlackJackAutomator(int numPlayers){
        players = new Player[numPlayers];
        for(int i = 0; i < numPlayers; i++){
            players[i] = new Player();
            players[i].hand = new BlackJackHand();
        }
    }*/

    public BlackJackAutomator(int numHands){
        hands = new BlackJackHand[numHands];
        for(int i = 0; i < numHands; i++){
            hands[i] = new BlackJackHand();
        }
    }
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

    public boolean dealInitHands(){
        for (BlackJackHand hand: this.hands) {
            BlackJackCard card1 = this.deck.dealCard();
            BlackJackCard card2 = this.deck.dealCard();
            if(card1 == null || card2 == null){
                return false;
            }
            hand.addCard(card1);
            hand.addCard(card2);

        }
        return true;
    }

    public static void main(String[] args) {
        BlackJackAutomator auto = new BlackJackAutomator(5);
        auto.initDeck();
        //auto.deck.print();
        BlackJackHand hand = new BlackJackHand();
        hand.addCard(auto.deck.dealCard());
        hand.addCard(auto.deck.dealCard());
        hand.addCard(auto.deck.dealCard());
        auto.deck.print();
        hand.print();
        hand.score();
    }
}
