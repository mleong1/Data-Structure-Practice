package ObjectOrientedProblems;

import java.util.ArrayList;

public class BlackJackAutomator {
    private Deck<BlackJackCard> deck;
    //private BlackJackHand[] hands;
    private Player[] players;
    private BlackJackDealer dealer;

    public BlackJackAutomator(int numPlayers){
        players = new Player[numPlayers];
        for(int i = 0; i < numPlayers; i++){
            players[i] = new Player();
            players[i].hand = new BlackJackHand();
        }
        dealer = BlackJackDealer.getInstance();
        dealer.hand = new BlackJackHand();
    }

    /*public BlackJackAutomator(int numHands){
        hands = new BlackJackHand[numHands];
        for(int i = 0; i < numHands; i++){
            hands[i] = new BlackJackHand();
        }
    }*/

    public void startGame(){
        initDeck();
        dealInitHands();
        dealDealerHand();
        if(dealer.hand.isBlackJack()){
            System.out.println("Dealer wins.");
            return;
        }
        ArrayList<Player> initWinners = getBlackJacks();
        dealer.showCard();

        for (Player p : players) {
            if (!p.hasWon()) {
                System.out.println("Player's Score: " + p.hand.score());
                p.hand.print();
                //while player is asking for a hit

                boolean input = p.getInput();
                while (input) {
                    BlackJackCard card = deck.dealCard();
                    if (card == null) {
                        System.out.println("Deck is out of cards.");
                        return;
                    }
                    p.hand.addCard(card);
                    System.out.println("Player's Score: " + p.hand.score());
                    p.hand.print();
                    input = p.getInput();
                }
            }
        }

        boolean dInput = dealer.getInput();
        while(dInput){
            BlackJackCard card = deck.dealCard();
            if(card == null){
                System.out.println("Deck is out of cards.");
                return;
            }
            dealer.hand.addCard(card);
            dInput = dealer.getInput();
        }

        ArrayList<Player> winners = getWinners();
        System.out.println(dealer.hand.score());
        System.out.println(winners.size());

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
        for (Player p: this.players) {
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

    public boolean dealDealerHand(){
        BlackJackCard card1 = this.deck.dealCard();
        BlackJackCard card2 = this.deck.dealCard();
        if(card1 == null || card2 == null){
            return false;
        }
        this.dealer.hand.addCard(card1);
        this.dealer.hand.addCard(card2);
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

    /*public boolean playerPlay(int playerNum){
        Player p = this.players[playerNum];
        return playerPlay(p);

    }*/

    //this method is possibly unnecessary
    public boolean playerPlay(Player p){
        System.out.println("Player this is your hand.");
        p.hand.print();
        boolean choice = p.getInput();
        if(choice == true){
            BlackJackCard card = deck.dealCard();
            if(card == null){
                return false;
            }
            p.hand.addCard(card);
            System.out.println(p.hand.score());
            return true;
        } else {
            //todo not sure about returning false for deck being empty and staying is a good idea.
            System.out.println(p.hand.score());
            return true;
        }
    }

    public ArrayList<Player> getWinners(){
        ArrayList<Player> winners = new ArrayList<Player>();
        int winningScore;
        if(!dealer.hand.isBusted()) {
            winningScore = dealer.hand.score();
        } else {
            winningScore = 0;
        }
        for (Player p : this.players) {
            if(!p.hand.isBusted()){
                if(p.hand.score() > winningScore){
                    winners.add(p);
                } else if(p.hand.score() == winningScore){
                    winners.add(p);
                }
            }
        }
        return winners;
    }

    public void printHandsAndScore(){
        System.out.println("--Dealer's UpCard--");
        this.dealer.showCard();
        for (Player p : this.players) {
            System.out.println("--Player's Hand--  Score: " + p.hand.score());
            p.hand.print();
        }
    }

    public static void main(String[] args) {
        BlackJackAutomator auto = new BlackJackAutomator(2);
        //auto.initDeck();
        //auto.deck.print();
        /*BlackJackHand hand = new BlackJackHand();
        hand.addCard(auto.deck.dealCard());
        hand.addCard(auto.deck.dealCard());
        hand.addCard(auto.deck.dealCard());
        auto.deck.print();
        hand.print();
        hand.score();*/
        //auto.dealInitHands();
        //ArrayList<Player> winners = auto.getBlackJacks();
        /*for (Player p: auto.players) {
            p.hand.print();
            System.out.println("Hand Score: " + p.hand.score());
        }*/
        //auto.playerPlay(0);
        //auto.playerPlay(1);
        auto.startGame();
    }
}
