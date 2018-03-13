package HuffmanCoding;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class HuffTreeNode implements Comparable {
    /*this class is for huffman coding tree nodes which will need to hold the char value and the frequency
      it appears within a text file, parameter, etc.
      instructional website : https://www2.cs.duke.edu/csed/poop/huff/info/
     */

    //Priority Queue is an abstract data type meaning it can be implemented with a variety of data structs
    //think heaps which can be implemented via binary search trees or just arrays
    int freq;
    char name;
    //this int is used as a handle to keep track of the object in the priority queue
    int heapIndex;
    HuffTreeNode leftChild;
    HuffTreeNode rightChild;

    public HuffTreeNode (){

    }

    public HuffTreeNode(int freq, char name){
        this.freq = freq;
        this.name = name;
    }

    public String toString(){
        return this.name + " has a frequency of " + this.freq;
    }



    public static PriorityQueue<HuffTreeNode> getFrequency(String phrase){
        char[] letters = phrase.toCharArray();
        //right now we store all of the character nodes into an arraylist but we want them in a priority queue
        //for when we merge min frequency trees
        PriorityQueue<HuffTreeNode> forest = new PriorityQueue<HuffTreeNode>();
        //ArrayList<HuffTreeNode> forest= new ArrayList<HuffTreeNode>();

        for (char l : letters) {
            boolean nodeExists = false;
            for (HuffTreeNode node: forest) {
                if(l == node.name){
                    node.freq += 1;
                    nodeExists = true;
                }
            }
            //if the node doesn't exist yet create it in the forest
            if(!nodeExists){
                HuffTreeNode newNode = new HuffTreeNode(1, l);
                forest.add(newNode);
            }
        }
        return forest;
    }

    public static void printHisto(PriorityQueue<HuffTreeNode> forest){
        for (HuffTreeNode node: forest) {
            System.out.println(node.toString());
        }
        System.out.println(forest.size());
    }

    public static HuffTreeNode huffman(PriorityQueue<HuffTreeNode> forest){
        while(forest.size() != 1) {
            HuffTreeNode node = new HuffTreeNode();
            node.leftChild = forest.poll();
            node.rightChild = forest.poll();
            node.freq = node.leftChild.freq + node.rightChild.freq;
            forest.add(node);
        }
        return forest.peek();
    }

    public int compareTo(Object arg0){
        HuffTreeNode node = (HuffTreeNode) arg0;
        if(this.freq == node.freq){
            return 0;
        } else if (this.freq > node.freq){
            return 1;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<HuffTreeNode> forest = getFrequency("go go gophers");
        printHisto(forest);
        huffman(forest);
        printHisto(forest);
        //System.out.println(forest.get(2).compareTo(forest.get(2)));
    }
}
