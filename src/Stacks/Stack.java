package Stacks;

import java.util.EmptyStackException;

public class Stack<T> {
    //this is the class for the stack data structure. It employs a LIFO structure, so the last
    //object in is the first object out.  Methods include the ability to pop the top item from the stack,
    //push an item to the top of the stack, return what the first item is, and find out if the stack
    //is empty.  Similar to a linked list but different in the way things are added and removed

    //private variable is just the node on the top of the stack
    private StackNode<T> top;

    /*method: pop()
      summary: removes the node on top of the stack. Returns the data that was in that node
     */
    public T pop(){
        //need to learn these exceptions
        if(top == null) throw new EmptyStackException();
        T data = top.data;
        top = top.next;
        return data;
    }

    /*method: push()
      summary: push a node to the top of the list.
      param: T data, the data for the new node at the top of the stack
     */
    public void push(T data){
        StackNode<T> newTop = new StackNode(data);
        if(top == null) {
            top = newTop;
        } else{
            newTop.next = top;
            top = newTop;
        }
    }

    /*method: peek()
      summary: return the data inside of the top most node.
     */
    public T peek(){
        if(top == null) throw new EmptyStackException();
        return top.data;
    }

    /*method: isEmpty()
      summary: return boolean as to whether the stack is empty
     */
    public boolean isEmpty(){
        return top == null;
    }

    public static void main(String[] args) {
        Stack<String> books = new Stack<String>();
        System.out.println(books.isEmpty());
        books.push("Ubik");
        books.push("Howl's Moving Castle");
        books.push("The Man in the High Castle");
        System.out.println(books.top.data);
        books.pop();
        System.out.println(books.peek());
    }
}



