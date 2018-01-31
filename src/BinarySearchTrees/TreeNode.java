package BinarySearchTrees;

public class TreeNode {
    /*This class is for each node, specifically in a binary search tree.  This means each node holds information
      on its lesser left child and greater right child.  May need to modify this class when making different kind of
      trees.  All values are made public to not deal with getters and setters although private variables are
      better.
     */

    //public variables
    int key;
    String name;

    //children can have null values because a node in a binary search tree has AT MOST 2 children
    TreeNode leftChild;
    TreeNode rightChild;

    public TreeNode(int key, String name) {
        this.key = key;
        this.name = name;
    }

    public String toString(){
        return this.name + " has a key of " + this.key;
    }
}
