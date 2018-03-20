package ObjectOrientedProblems;
import java.util.Scanner;

public class Player {
    //the class for the Player probably will use scanners for input
    //dealer would extend player with his actions automated based on rules of blackjack
    //could have a field for money for betting
    protected BlackJackHand hand;
    private boolean winner;


    //Todo fix the scanner NoSuchElementException problem
    //why did i do 0 and 1? why not just true and false
    public boolean getInput(){
        //maybe this input method should go in main
        //add some way to see the dealer's face card
        while(true) {
            System.out.println("Would you like to hit or stay?");
            Scanner reader = new Scanner(System.in);
            String n = reader.next();
            if (n.toUpperCase().equals("HIT")) {
                //these readers.close cause a NoSuchElementException
                //reader.close();
                return true;
            } else if (n.toUpperCase().equals("STAY")) {
                //reader.close();
                return false;
            } else {
                System.out.println("Option not available");
            }
        }
    }

    public void isWinner(){
        this.winner = true;
    }

    public boolean hasWon(){
        return this.winner;
    }



    //Other player methods would go here like betting but that may be outside of what is necessary
    public static void main(String[] args) {
        Player p = new Player();
        System.out.println(p.getInput());

    }
}
