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
    }
}
