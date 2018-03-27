package ModerateProblems;

import java.util.Random;

public class MasterMind {
    //game contains an array of size 4 for each of the balls
    private Ball[] slots;

    public MasterMind(int numSlots){
        Random rand = new Random();
        this.slots = new Ball[numSlots];
        for(int i = 0; i < numSlots; i++){
            Ball b = Ball.getBallFromValue(rand.nextInt(4));
            this.slots[i] = b;
        }
    }

    public int returnHits(String guess){
        guess = guess.toUpperCase();
        char[] guesses = guess.toCharArray();
        Ball[] ballArr = new Ball[guesses.length];
        for(int i = 0; i < guesses.length; i++){
            if(guesses[i] ==  'R'){
                ballArr[i] = Ball.getBallFromValue(0);
            } else if (guesses[i] == 'Y'){
                ballArr[i] = Ball.getBallFromValue(1);
            } else if (guesses[i] == 'B'){
                ballArr[i] = Ball.getBallFromValue(2);
            } else if (guesses[i] == 'G'){
                ballArr[i] = Ball.getBallFromValue(3);
            }
        }
        for (Ball b: ballArr) {
            System.out.println(b);
        }
        return returnHits(ballArr);
    }

    public int returnHits(Ball[] guess){
        int results = 0;
        for(int i = 0; i < this.slots.length; i++){
            if(this.slots[i] == guess[i]){
                results += 10;
            } else {
                //if this.slots[i] exists in guess
                for(int j = i + 1; j < this.slots.length; j ++){
                    if(this.slots[i] == guess[j]){
                        results += 1;
                        break;
                    }
                }
            }
        }
        return results;
    }

    public void printBalls(){
        for (Ball b: this.slots) {
            System.out.println(b);
        }
    }

    public enum Ball{
        RED (0),
        YELLOW (1),
        BLUE (2),
        GREEN (3);

        private int value;

        private Ball(int v){
            this.value = v;
        }

        public int getValue(){
            return this.value;
        }

        public static Ball getBallFromValue(int value){
            switch(value){
                case 0:
                    return Ball.RED;
                case 1:
                    return Ball.YELLOW;
                case 2:
                    return Ball.BLUE;
                case 3:
                    return Ball.GREEN;
                default:
                    return null;
            }

        }
    }

    public static void main(String[] args) {
        MasterMind m = new MasterMind(4);
        m.printBalls();
        System.out.println(m.returnHits("rByg"));
    }
}
