package HashTables;
import java.util.ArrayList;

public class HashTable3 <K, V>{
    private class HashNode<K,V>{
        //we will use hashnodes for to handle collisions via chaining
        private K key;
        private V value;
        private HashNode next;

        public HashNode(K key, V val){
            this.key = key;
            this.value = val;
        }

        public HashNode(){
        }

        //getters and setters

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public HashNode getNext() {
            return next;
        }

        public void setNext(HashNode next) {
            this.next = next;
        }
    }

    private ArrayList<HashNode<K,V>> list;
    private int bucketAmount;
    //size is different from bucketAmount because size is actually if there is anything in the list instead of null
    private int size;

    public HashTable3(int bucketAmount){
        this.bucketAmount = bucketAmount;
        list = new ArrayList<HashNode<K,V>>();
        size = 0;

        for(int i = 0; i < bucketAmount; i ++){
            list.add(null);
        }
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    //this method gives us the index to insert for a given key from a hashnode
    public int getIndex(K key){
        //hashCode() can return a negative value if the key is too big use abs
        int hashCode = Math.abs(key.hashCode());
        int index = hashCode % bucketAmount;
        return index;
    }

    public void add(K key, V val){
        int ind = getIndex(key);
        System.out.println(ind);
        HashNode<K,V> head = list.get(ind);

        while(head != null){
            if(head.getKey() == key){
                head.setValue(val);
                return;
            }
            head = head.getNext();
        }

        head = list.get(ind);
        HashNode<K,V> node = new HashNode<K,V>(key, val);
        node.setNext(head);
        list.set(ind, node);
        size ++;

        if((1.0 * size) / bucketAmount >= 0.7){
            //double the array
            ArrayList<HashNode<K,V>> temp = list;
            list = new ArrayList<HashNode<K,V>>();
            bucketAmount = 2 * bucketAmount;
            size = 0;

            for(int i = 0; i < bucketAmount; i ++){
                list.add(null);
            }

            for (HashNode<K,V> h: temp) {
                while(h.getNext() != null){
                    add(h.getKey(), h.getValue());
                    h = h.getNext();
                }
            }

        }
    }

    public V remove(K key){
        //this is similar to delete from BST keep a parent node to sever connection
        int ind = getIndex(key);
        HashNode<K,V> head = list.get(ind);
        HashNode<K,V> parent = null;

        while(head != null){
            parent = head;
            if(head.getKey() == key){
                break;
            }
            head = head.getNext();
        }
        if(head == null){
            //couldn't find the value
            return null;
        }

        if(parent != head){
            parent.setNext(head.getNext());
        } else {
            //head is node we are deleting
            list.set(ind, head.getNext());
        }
        size --;
        return head.getValue();
    }

    public V getValue(K key){
        int ind = getIndex(key);
        HashNode<K,V> head = list.get(ind);

        while(head != null){
            if(head.getKey() != key){
                head = head.getNext();
            } else {
                return head.getValue();
            }
        }

        return null;
    }
    //todo make the chain readable
    public void print(){
        for (HashNode<K,V> node: list) {
            if (node == null) {
                System.out.println("Node is null");
            } else {
                while(node.getNext() != null) {
                    System.out.println(node.key + " " + node.getValue());
                    node = node.getNext();
                }
                System.out.println(node.key + " " + node.getValue());
            }
        }
    }

    public static void main(String[] args) {
        HashTable3<String,Integer> hT = new HashTable3<>(10);
        hT.add("Matt", 123);
        hT.add("asdfasdfsadsa", 222);
        System.out.println(hT.getValue("asdfasdfsadsa"));
        System.out.println(hT.remove("Matt"));

    }
}
