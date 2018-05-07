package Stacks;

import java.util.EmptyStackException;

public class Stack2<E> {
    private static class StackNode2<E>{
        private E data;
        private StackNode2<E> next;

        public StackNode2 (E d){
            this.data = d;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public StackNode2<E> getNext() {
            return next;
        }

        public void setNext(StackNode2<E> next) {
            this.next = next;
        }
    }

    private StackNode2<E> top;
    private int counter;

    public int size(){
        return counter;
    }

    public boolean push(E elem){
        StackNode2<E> node = new StackNode2<E>(elem);
        if(top == null){
            top = node;
            counter++;
            return true;
        }else{
            node.next = top;
            top = node;
            counter++;
            return true;
        }
    }

    public StackNode2<E> pop(){
        if(top == null){
            throw new EmptyStackException();
        } else {
            StackNode2<E> node = top;
            top = top.getNext();
            counter --;
            return node;
        }
    }

    public E peek(){
        if(top == null){
            throw new EmptyStackException();
        } else {
            return top.getData();
        }
    }

    public static void sortWithStack(Stack2<Integer> original){
        Stack2<Integer> temp = new Stack2<Integer>();
        while(!original.isEmpty()){
            StackNode2<Integer> pop = original.pop();
            while(!temp.isEmpty() && temp.peek() > pop.getData()){
                StackNode2<Integer> tempPop = temp.pop();
                original.push(tempPop.getData());
            }
            temp.push(pop.getData());
        }
        System.out.println(temp.peek());
        temp.pop();
        System.out.println(temp.peek());
        temp.pop();
        System.out.println(temp.peek());
        temp.pop();
        System.out.println(temp.peek());
        temp.pop();

    }
    public boolean isEmpty(){
        return top == null;
    }

    public static void main(String[] args) {
        Stack2<Integer> s = new Stack2<>();
        s.push(3);
        s.push(5);
        s.push(15);
        s.push(1);
        sortWithStack(s);
    }
}
