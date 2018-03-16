package ObjectOrientedProblems;

public enum Suit {
    /*this is an enum for suits which will be used later for cards. an enum is used here because a suit can only
      be 4 different values: clubs, diamonds, hearts, or spades.
     */
    //enum constant and their value representing that constant
    CLUB (0),
    DIAMOND (1),
    HEART (2),
    SPADE (3);

    //value needs to be created in private variables section to create association between constant and variable
    private int value;

    private Suit(int v){
        this.value = v;
    }

    public int getValue(){
        return value;
    }

    public static Suit getSuitFromValue(int value){
        switch(value){
            case 0:
                return Suit.CLUB;
            case 1:
                return Suit.DIAMOND;
            case 2:
                return Suit.HEART;
            case 3:
                return Suit.SPADE;
            default:
                return null;
        }

    }

}
