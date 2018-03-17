package ObjectOrientedProblems;

public class BlackJackDealer extends Player {
    //only one dealer so lets use a singleton
    //also has to hit until he reaches 17 (soft?)
    //needs to show the table his top card
    private static BlackJackDealer bjd = new BlackJackDealer();
    private static final int HIT_UNTIL = 17;

    //private constructor prevents any other class from instantiating
    private BlackJackDealer(){
    }

    public static BlackJackDealer getInstance(){
        return bjd;
    }

    //overriding method in player except dealer has no choice in hits, automate
    public int getInput(){
        if(this.hand.score() < HIT_UNTIL){
            //0 means hit
            return 0;
        } else{
            return 1;
        }
    }

    public void showCard(){
        System.out.println(hand.cards.get(0));
    }
}
