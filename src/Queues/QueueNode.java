package Queues;

public class QueueNode<T> {
    //exact same thing as a StackNode. Stacks and queues aren't that different
    //we have a separate queue node for clarity
    T data;
    QueueNode<T> next;

    public QueueNode(T data)  {
        this.data = data;
    }
}
