package ObjectOrientedProblems;
import java.util.Scanner;

public class Player {
    //the class for the Player probably will use scanners for input
    //dealer would extend player with his actions automated based on rules of blackjack
    private Hand hand;
    private String input;

    //Todo get rid of input private field and just have getInput return a string either hit or stay
    public void getInput(){
        System.out.println("Would you like to hit or stay?");
        Scanner reader = new Scanner(System.in);
        String n = reader.next();
        switch(n.toUpperCase()){
            case "HIT":
                this.input = "hit";
            case "STAY":
                this.input = "stay";
            default:
                System.out.println("That is not an option");
        }
        reader.close();
    }

    public static void main(String[] args) {
        Player p = new Player();
        p.getInput();
        System.out.println(p.input);
    }
}
