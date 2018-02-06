package Heaps;

public class HeapNode {
    /*this class represents a node to be used in a heap data structure. only recreated for clarity
    in the package.
     */

    //public variables
    int key;
    String name;

    //children can have null values because a node in a binary tree has AT MOST 2 children
    HeapNode leftChild;
    HeapNode rightChild;

    public HeapNode(int key, String name) {
        this.key = key;
        this.name = name;
    }

    public String toString(){
        return this.name + " has a key of " + this.key;
    }
}
