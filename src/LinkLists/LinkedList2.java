package LinkLists;

public class LinkedList2<E> {

    private Node2<E> head = null;
    private Node2<E> tail = null;
    private Node2<E> temp = null;
    private int counter = 0;

    //always create your own constructor even if you don't use it
    public LinkedList2(){

    }

    public int size(){
        return this.counter;
    }

    public void add(E elem){
        Node2 node = new Node2(elem);
        if(head == null){
            head = tail = node;
            head.setNext(tail);
            tail.setPrev(head);

        } else {
            //iterate through the list and get to the end
            tail.setNext(node);
            tail.getNext().setPrev(tail);
            tail = tail.getNext();
        }
        counter ++;
    }

    public void addAtInd(E elem, int ind){
        if(ind == counter){
            this.add(elem);
            return;

        } else if (ind == 0){
            //if we are inserting to the head
            Node2 insNode = new Node2(elem);
            insNode.setNext(head);
            head.setPrev(insNode);
            head = insNode;
            counter ++;
            return;
        }

        Node2 insNode = new Node2(elem);
        temp = head;
        while(temp.hasNext() && ind > 0){
            temp = temp.getNext();
            ind --;
        }
        //temp is in the spot we want the insertnode to be at now

        insNode.setNext(temp);
        temp.getPrev().setNext(insNode);
        insNode.setPrev(temp.getPrev());
        temp.setPrev(insNode);
        counter ++;
    }

    public E getElem(int ind){
        temp = head;
        if(ind > counter - 1){
            return null;
        }
        while(temp.hasNext() && ind > 0){
            temp = temp.getNext();
            ind --;
        }
        return temp.getElem();
    }

    public int getInd(E elem){
        temp = head;
        for(int i = 0; i < counter; i++){
            if(temp.getElem().equals(elem)){
                return i;
            } else {
                temp = temp.getNext();
            }
        }
        return -1;
    }

    public boolean remove(int ind){

        //what if the index to remove is the head?
        if(ind == 0){
            head = head.getNext();
            head.setPrev(null);
            counter --;
            return true;
        }

        //what if the index to remove is the tail?
        if(ind == counter - 1){
            tail = tail.getPrev();
            tail.setNext(null);
            counter --;
            return true;
        }
        //this should get us to the target index to remove.
        //index is kind of a strange param to remove off of though, because Linked Lists aren't index based in the
        //first place.
        //the elem version wouldn't be much different to implement anyway
        temp = head;
        while(temp.hasNext() && ind > 0){
            temp = temp.getNext();
            ind --;
        }

        Node2 pred = temp.getPrev();
        Node2 succ = temp.getNext();

        pred.setNext(succ);
        succ.setPrev(pred);
        temp = null;
        counter --;
        return true;
    }

    /*Method: isPalindrome()
      Summary: check to see if the head elem is the same as the tail elem. Then set pointer at head to head.next
      and pointer at tail to tail.prev and check if those are the same. Continue until you've reached half of size?
      Also if the number of elements is 1 or 0 auto return true.
     */
    public boolean isPalindrome(){
        if(this.size() == 0 || this.size() == 1){
            return true;
        }
        //check the head against the tail counter number of times
        int counter = this.size()/2;
        Node2<E> headPointer = head;
        Node2<E> tailPointer = tail;

        while(counter > 0){

            if(headPointer.getElem() == tailPointer.getElem()){
                headPointer = headPointer.getNext();
                tailPointer = tailPointer.getPrev();
                counter --;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LinkedList2 lL2 = new LinkedList2();
        lL2.add("hello");
        lL2.add("nani");
        lL2.add("world");
        lL2.addAtInd("what", 1);
        System.out.println(lL2.head.getElem());
        System.out.println(lL2.head.getNext().getElem());
        System.out.println(lL2.tail.getElem());
        System.out.println(lL2.getElem(2));
        System.out.println(lL2.getInd("hello"));
        System.out.println(lL2.remove(3));
        System.out.println(lL2.getElem(3));
        LinkedList2<String> palindrome = new LinkedList2<>();
        palindrome.add("hello");
        palindrome.add("world");
        palindrome.add("hey");
        palindrome.add("world");
        palindrome.add("hello");
        System.out.println(palindrome.isPalindrome());
    }
}
