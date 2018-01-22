package Stacks;

public class StackNode<T> {
    //Separated this node from a regular linked list node for clarity.  LinkLists.Node concept is still
    //the same, its just that the methods need to follow LIFO (Last In, First Out) structure.
    T data;
    StackNode<T> next;

    public StackNode(T data){
        this.data = data;
    }
}
