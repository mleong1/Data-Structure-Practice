package ModerateProblems;

import java.util.Random;

public class MasterMind {
    //game contains an array of size 4 for each of the balls
    private Ball[] slots;

    public MasterMind(int numSlots){
        Random rand = new Random();
        this.slots = new Ball[numSlots];
        for(int i = 0; i < numSlots; i++){
            Ball b = Ball.getBallFromValue(rand.nextInt(3));
            this.slots[i] = b;
        }
    }

    public String returnHits(String guess){
        return "Hello";
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
}
