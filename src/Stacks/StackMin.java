package Stacks;

public class StackMin extends Stack<Integer> {
    //s2 is our min stack holding all the min values
    Stack<Integer> s2;

    public void push(int value){
        //has to be less than or equal to record duplicate mins. if we pop and delete only one recorded min
        //the min won't be accurate.
        if (value <= min()){
            s2.push(value);
        } else {
            super.push(value);
        }
    }

    public Integer pop(){
        int value = super.pop();
        if(value == min()){
            s2.pop();
        }
        return value;
    }

    public int min(){
        if (s2.isEmpty()){
            return Integer.MAX_VALUE;
        }else{
            return s2.peek();
        }
    }
}
