import sun.awt.image.ImageWatched;

public class LinkedList <E>{
    //private nodes that define the linkedlist. Temp will be for holding nodes
    //head is the first node and tail is the last
    private Node<E> head = null;
    private Node<E> tail = null;
    private Node<E> temp = null;
    //counter is used to make the size method O(1) instead of O(n) by iterating through a list
    private int counter = 0;

    //constructor
    public LinkedList(){

    }

    //methods
    /*Method: size()
      Summary: returns the size of a linked list by returning it's counter private variable.  Since this
      is incremented and decremented inside methods, the time for this method is O(1).
     */
    public int size(){
        return counter;
    }

    /*Good tip for writing methods for a linkedlist.  You are only looking at only 3 nodes
      when incorporating add, remove etc methods. The node, the one before it, and the one after.
      If you figure out those relations the method should be easy.*/

    /*Method: add()
      Summary: adds an element to the end of a linked list.  there are two cases. 1 that there is no node
      already in the list in which head and tail are created to reference a new node. then head's elem
      is set to the parameter. Head's next is set to tail but also tail is set to head since at the first
      node head is also the tail. 2 if there is a node already it is set to the new tail. Counter is
      incremented to reflect size change.
      Param: elem, an element
     */
    public void add(E elem){
        //if there are no elems in our linkedlist
        if(head == null){
            //Kind of instantiates the linkedlist. head and tail are made to be a new node
            head = tail = new Node<E>();
            //head's elem is set to the param
            head.elem = elem;
            head.next = tail;
            tail = head;
        } else {
            tail.next = new Node<E>();
            tail = tail.next;
            tail.elem = elem;
        }
        counter ++;
    }

    public static void main(String[] args) {
        LinkedList<String> books = new LinkedList<String>();
        books.add("Hound of the Baskervilles");
        books.add("The Girl with the Dragon Tattoo");
        //implement cycle through function this is jank
        System.out.println(books.head.elem);
        System.out.println(books.head.next.elem);
        System.out.println(books.size());
    }
}
