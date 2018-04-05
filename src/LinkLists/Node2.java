package LinkLists;

public class Node2<E>{

    private E elem;
    private Node2<E> next;
    private Node2<E> prev;


    public Node2(E e){
        this.elem = e;
    }

    public E getElem() {
        return elem;
    }

    public Node2<E> getNext() {
        return next;
    }

    public Node2<E> getPrev() {
        return prev;
    }

    public void setElem(E elem) {
        this.elem = elem;
    }

    public void setNext(Node2<E> next) {
        this.next = next;
    }

    public void setPrev(Node2<E> prev) {
        this.prev = prev;
    }

    public boolean hasNext(){
        if(this.next != null){
            return true;
        } else {
            return false;
        }
    }

}
