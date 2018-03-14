package HuffmanCoding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
    //this is the Huffman Code for the char
    String code = "";
    HuffTreeNode leftChild;
    HuffTreeNode rightChild;

    public HuffTreeNode (){

    }

    public HuffTreeNode(int freq, char name){
        this.freq = freq;
        this.name = name;
        //this.code = "";
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

    public static HashMap<Character, Integer> lookupTable(PriorityQueue<HuffTreeNode> forest){
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (HuffTreeNode node: forest){
            map.put(node.name, node.freq);
        }
        return map;
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

    public static void inOrderTraversal(HuffTreeNode root){
        if(root != null) {
            inOrderTraversal(root.leftChild);
            System.out.println(root.toString());
            inOrderTraversal(root.rightChild);
        }
    }

    public static HashMap<Character, String> lookupTable2(HuffTreeNode root, HashMap<Character, String> map) {
        if(root != null){
            lookupTable2(root.leftChild, map);
            if(root.name != 0){
                map.put(root.name, root.code);
            }
            lookupTable2(root.rightChild, map);
        }
        return map;
    }

    public static void preOrderTraversal(HuffTreeNode root){
        if(root != null) {
            System.out.println(root.toString());
            preOrderTraversal(root.leftChild);
            preOrderTraversal(root.rightChild);
        }
    }

    public static void encode(HuffTreeNode root){
        if(root == null){
            return;
        }
        if(root.leftChild != null){
            root.leftChild.code = root.code.concat("0");
            encode(root.leftChild);
        }
        if(root.rightChild != null){
            root.rightChild.code = root.code.concat("1");
            encode(root.rightChild);
        }
    }
    /*
    public String findNode(HuffTreeNode root, HashMap<Character, Integer> map, char tarName){
        //Concat coding to the end of this string and return
        String encoding = "";
        int tarFreq = map.get(tarName);
        //here we need a table to associate names with their frequencies
        while(root.name != name){
            if((root.freq - tarFreq) > tarFreq){
                //it isn't enough to just say that if root freq is bigger than tarfreq go to left child
                //consider a middle node with freq of 6 which is the combined frequencies of left and right children
                //with frequencies of 3 each
                root = root.leftChild;
                encoding.concat("0");
            } else if((root.freq - tarFreq) == tarFreq){
                //has to be either the left child or the right child
                if(root.leftChild.name == tarName){
                    encoding.concat("0");
                } else {
                    encoding.concat("1");
                }
                //else if (root.freq - tarFreq) > tarFreq
                //ahhhhh I see the problem here
                //may abandon this method
                //method may not be needed. maybe the huff encoding could be made on the fly and stored in a hashmap
            } else {

            }
        }
        return encoding;
    }*/

    public static void main(String[] args) {
        PriorityQueue<HuffTreeNode> forest = getFrequency("go go gophers");
        printHisto(forest);
        HashMap<Character, Integer> map = lookupTable(forest);
        HuffTreeNode root = huffman(forest);
        printHisto(forest);
        encode(root);
        //preOrderTraversal(root);
        //System.out.println(forest.get(2).compareTo(forest.get(2)));
        //System.out.println(root.leftChild.leftChild.code);
        //System.out.println(root.leftChild.leftChild.name);
        HashMap<Character, String> map2 = new HashMap<Character, String>();
        lookupTable2(root, map2);
        System.out.println(map2.get('g'));
        System.out.println(map2.get('o'));
        System.out.println(map2.get('p'));
        System.out.println(map2.get('h'));
        System.out.println(map2.get('e'));
        System.out.println(map2.get('r'));
        System.out.println(map2.get(' '));
    }
}
