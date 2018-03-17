package ObjectOrientedProblems;
import java.util.Scanner;

public class Player {
    //the class for the Player probably will use scanners for input
    //dealer would extend player with his actions automated based on rules of blackjack
    //could have a field for money for betting
    private Hand hand;


    //Todo get rid of input private field and just have getInput return a string either hit or stay
    public int getInput(){
        while(true) {
            System.out.println("Would you like to hit or stay?");
            Scanner reader = new Scanner(System.in);
            String n = reader.next();
            if (n.toUpperCase().equals("HIT")) {
                reader.close();
                return 0;
            } else if (n.toUpperCase().equals("STAY")) {
                reader.close();
                return 1;
            } else {
                System.out.println("Option not available");
            }
        }
    }

    //Other player methods would go here like betting but that may be outside of what is necessary
    public static void main(String[] args) {
        Player p = new Player();
        System.out.println(p.getInput());

    }
}
