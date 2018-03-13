package HuffmanCoding;

import java.util.ArrayList;

public class HuffTreeNode {
    /*this class is for huffman coding tree nodes which will need to hold the char value and the frequency
      it appears within a text file, parameter, etc.
      instructional website : https://www2.cs.duke.edu/csed/poop/huff/info/
     */

    int freq;
    char name;
    HuffTreeNode leftChild;
    HuffTreeNode rightChild;

    public HuffTreeNode(int freq, char name){
        this.freq = freq;
        this.name = name;
    }

    public String toString(){
        return this.name + "has a frequency of" + this.freq;
    }

    public static ArrayList<HuffTreeNode> getFrequency(String phrase){
        char[] letters = phrase.toCharArray();
        ArrayList<HuffTreeNode> forest= new ArrayList<HuffTreeNode>();

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

    public static void main(String[] args) {
        ArrayList<HuffTreeNode> forest = getFrequency("go go gophers");
        System.out.println(forest.get(0).name);
        System.out.println(forest.get(0).freq);
    }
}
