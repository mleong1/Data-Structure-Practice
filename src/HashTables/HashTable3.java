package HashTables;
import java.util.ArrayList;

public class HashTable3 {
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

    private ArrayList<HashNode> list;
    private int bucketAmount;
    //size is different from bucketAmount because size is actually if there is anything in the list instead of null
    private int size;

    public HashTable3(int bucketAmount){
        this.bucketAmount = bucketAmount;
        list = new ArrayList<HashNode>();
        size = 0;

        for(int i = 0; i < bucketAmount; i ++){
            list.add(null);
        }
    }

    

}
