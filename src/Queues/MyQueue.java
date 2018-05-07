package Queues;

import Stacks.Stack;
import Stacks.StackNode;

public class MyQueue<T> {

    private Stack<T> queue;
    private Stack<T> temp;

    public void push(T data){
        //need to account for when temp is holding everything
        if(queue.isEmpty()){
            if(temp.isEmpty()){
                queue.push(data);
            } else {
                //push everything back into queue
                while(!temp.isEmpty()){
                    T popData = temp.pop();
                    queue.push(popData);
                }
                //then push the new data into queue
                queue.push(data);
            }
        } else {
            //if the queue isn't empty just put the new data in
            queue.push(data);
        }
    }
}
