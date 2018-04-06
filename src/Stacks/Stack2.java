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

    public boolean isEmpty(){
        return top == null;
    }
}
