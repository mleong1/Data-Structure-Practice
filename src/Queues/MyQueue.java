package Queues;

import Stacks.Stack;
import Stacks.StackNode;

import java.util.NoSuchElementException;

public class MyQueue<T> {

    private Stack<T> queue;
    private Stack<T> temp;

    public MyQueue(){
        queue = new Stack<>();
        temp = new Stack<>();
    }

    //This is good but not as good as Gayle
    //if the queue is empty but the temp isn't we automatically move everything back into queue
    //Gayle has is set up so that you always push to Queue. if the temp has elements always remove from there
    //until it is empty. then refill it will elements from the queue.

    //old push method
    public void pus(T data){
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

    public void push(T data){
        queue.push(data);
    }
    public T remove(){
        if(queue.isEmpty()){
            if(temp.isEmpty()){
                throw new NoSuchElementException();
            } else {
                T popData = temp.pop();
                return popData;
            }
        } else {
            if (!temp.isEmpty()) {
                T popData = temp.pop();
                return popData;
            } else {
                //if the queue has elements transfer everything to temp to get the oldest item
                while (!queue.isEmpty()) {
                    T popData = queue.pop();
                    temp.push(popData);
                }
                return temp.pop();
            }
        }
    }

    public T peek(){
        return queue.peek();
    }

    public boolean isEmpty(){
        return queue.isEmpty() && temp.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue<Integer> q = new MyQueue<>();
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        System.out.println(q.remove());
    }
}
