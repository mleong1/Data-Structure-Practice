package Queues;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class Queue<T> {
    /*Queue implements FIFO (First in, first out) ordering.  Think of people in line at the movies.
      first person in line gets into the movie.  methods needed are push an item to the end of the queue,
      remove the first item from the queue, peek at the top of the stack, and isEmpty to check if empty. */

    //we now need a first node to keep track of the first object in the queue
    //similar implementation as Stack but we need to account for this first node
    private QueueNode<T> first;
    private QueueNode<T> top;

    /*method: push()
      summary: push an item to the end of the queue. Same as stack push.
      param: T data, the data to be pushed to the end of the list
     */
    public void push(T data){
        QueueNode<T> newTop = new QueueNode<T>(data);
        if(first == null){
            top = newTop;
            //also newTop is the first node as well
            first = newTop;
        } else {
            top.next = newTop;
            top = newTop;
        }
    }

    /*method: remove()
      summary: remove the first node from the queue.  new first node must be specified.  we return the
      data just to show it worked.
     */
    public T remove(){
        if(first == null) throw new NoSuchElementException();
        T data = first.data;
        first = first.next;
        //now we need to check if the new first exists. could be a list of 1 node
        if(first == null){
            //need to reset so when we push we get the first if statement
            top = null;
        }
        return data;
    }

    /*method: peek()
      summary: return the data at the end of the list. same as stack.
     */
    public T peek(){
        if(top == null) throw new NoSuchElementException();
        return top.data;
    }

    /*method: isEmpty()
      summary: check if the queue is empty. return true or false
     */
    public boolean isEmpty(){
        return top == null;
    }

    //added a main to do some low tier testing of the queue
    public static void main(String[] args) {
        Queue<String> books = new Queue<String>();
        books.push("How Fiction Works");
        System.out.println(books.isEmpty());
        System.out.println(books.peek());
        books.push("Gone Girl");
        System.out.println(books.peek());
        System.out.println(books.remove());
        System.out.println(books.peek());

    }
}
