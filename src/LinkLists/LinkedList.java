package LinkLists;

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

    /*Method: addInd()
      Summary: adds an element in at a specific index of the linked list.
      param: index, the index at which the node will be added. elem, the data in the node
     */

    public void addInd(int ind, E elem){
        //if the user wants the index added at the end simply call the previous method
        //index = counter which is next index to be filled
        if(ind == counter){
            //no counter++ add does it already
            this.add(elem);
            return;
        //temp is really going to ocme in handy here and in the next case
            // holding and saving what node you're on
        }else if(ind == 0){
            Node<E> insNode = new Node<E>();
            insNode.elem = elem;
            insNode.next = head;
            head.prev = insNode;
            head = insNode;
            counter ++;
            return;
        }

        //our private temp variable for linkedlist will now hold the head so we can iterate through
        //the list
        temp = head;
        for(int i = 0; i < ind - 1; i++) {
            //we need temp to hold this place. cant just say head.next a bunch of times
            temp = temp.next;
        }
        Node<E> insNode = new Node<E>();
        insNode.elem = elem;
        insNode.next = temp.next;
        temp.next.prev = insNode;
        temp.next = insNode;
        insNode.prev = temp;
        counter++;
    }

    /*Method: getElem()
      Summary: iterate through the linked list until you've reached the index specified. Return
      that elem.
      Param: int ind, the index you're searching for.
     */

    public E getElem(int ind){
        temp = head;
        for(int i = 0; i < ind; i ++){
            temp = temp.next;
        }
        return temp.elem;
    }

    /*Method: getInd()
      Summary: iterate through the linked list and get the index of a specified elem. Return that
      index. Kind of a reverse process of getElem().
      Param: E elem, the element whose index we're looking for.
     */

    public int getInd(E elem){
        temp = head;
        int ind = 0;
        for(int i = 0; i < this.size(); i ++){
            if(temp.elem == elem){
                return ind;
            } else {
                temp = temp.next;
                ind++;
            }
        }
        return -1;
    }

    /*Method: remove()
      Summary: iterate through a linked list based on index and delete that node from the list.
      This is kind of the reverse of addInd a node. We need to make the node previous to the deleted
      node point to the node after the deleted node. Then we set the node after's previous to the node
      before the deleted node.  We return the elem of the removed node.
      Param: int ind, the index of the node we are removing
     */

    public E removeNode(int ind){

        temp = head;
        if(ind == 0){
            E elem = head.elem;
            Node<E> hold = head;
            head = null;
            head = hold.next;
            //Decrement counter to reflect change in size
            counter --;
            return elem;

        } else if (ind == this.size() - 1){
            E elem = tail.elem;
            Node<E> hold = tail;
            tail = null;
            tail = hold.prev;
            counter --;
            return elem;
        }

        //grab one before the node to be deleted
        for(int i = 0; i < ind - 1; i ++){
            temp = temp.next;
        }

        Node<E> delNode = temp.next;
        E elem = delNode.elem;
        //prevNode to delNode --> next set to one after delNode
        temp.next = delNode.next;
        delNode = null;
        temp.next.prev = temp;
        counter --;
        return elem;
    }

    /*We can implement stacks and queues if we add new methods for adding and removing for each
    * respective data structure.  For instance an addStack(), which is push(), and pop() method.
    * addStack() would add a node to the head of the list instead of the tail. pop() removes
    * the head.  In any case, stack and queue implementations look similar to linked list.*/
    public static void main(String[] args) {
        LinkedList<String> books = new LinkedList<String>();
        books.add("Hound of the Baskervilles");
        books.add("The Girl with the Dragon Tattoo");
        books.addInd(1, "Blood, Sweat, Pixels");
        //implement cycle through function this is jank
        //System.out.println(books.head.next.next.prev.elem);
        System.out.println(books.head.elem);
        System.out.println(books.head.next.elem);
        System.out.println(books.head.next.next.elem);
        System.out.println(books.size());
        System.out.println(books.getElem(2));
        System.out.println(books.getInd("Blood, Sweat, Pixels"));
        System.out.println(books.removeNode(2) + " removed");
        System.out.println(books.head.elem);
        System.out.println(books.head.next.elem);
        //System.out.println(books.head.next.next.elem);
    }
}
