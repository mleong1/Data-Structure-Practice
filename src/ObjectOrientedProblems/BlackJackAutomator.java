package ObjectOrientedProblems;

import java.util.ArrayList;

public class BlackJackAutomator {
    private Deck<BlackJackCard> deck;
    //private BlackJackHand[] hands;
    private Player[] players;

    public BlackJackAutomator(int numPlayers){
        players = new Player[numPlayers];
        for(int i = 0; i < numPlayers; i++){
            players[i] = new Player();
            players[i].hand = new BlackJackHand();
        }
    }

    /*public BlackJackAutomator(int numHands){
        hands = new BlackJackHand[numHands];
        for(int i = 0; i < numHands; i++){
            hands[i] = new BlackJackHand();
        }
    }*/
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
        for (Player p: players) {
            BlackJackCard card1 = this.deck.dealCard();
            BlackJackCard card2 = this.deck.dealCard();
            if(card1 == null || card2 == null){
                return false;
            }
            p.hand.addCard(card1);
            p.hand.addCard(card2);

        }
        return true;
    }

    public ArrayList<Player> getBlackJacks(){
        ArrayList<Player> winners = new ArrayList<>();
        for (Player p: this.players) {
            if(p.hand.isBlackJack()){
                p.isWinner();
                winners.add(p);
            }
        }
        return winners;
    }

    public boolean playerPlay(int playerNum){
        Player p = this.players[playerNum];
        return playerPlay(p);

    }

    public boolean playerPlay(Player p){
        System.out.println("Player this is your hand.");
        p.hand.print();
        int choice = p.getInput();
        if(choice == 0){
            BlackJackCard card = deck.dealCard();
            if(card == null){
                return false;
            }
            p.hand.addCard(card);
            return true;
        } else if (choice == 1) {
            //todo not sure about returning false for deck being empty and staying is a good idea.
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        BlackJackAutomator auto = new BlackJackAutomator(2);
        auto.initDeck();
        auto.deck.print();
        /*BlackJackHand hand = new BlackJackHand();
        hand.addCard(auto.deck.dealCard());
        hand.addCard(auto.deck.dealCard());
        hand.addCard(auto.deck.dealCard());
        auto.deck.print();
        hand.print();
        hand.score();*/
        auto.dealInitHands();
        ArrayList<Player> winners = auto.getBlackJacks();
        for (Player p: auto.players) {
            p.hand.print();
            System.out.println("Hand Score: " + p.hand.score());
        }
        auto.playerPlay(0);

    }
}
