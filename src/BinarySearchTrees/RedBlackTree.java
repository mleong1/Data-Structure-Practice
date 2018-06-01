package BinarySearchTrees;

public class RedBlackTree {
    private RedBlackTreeNode root;
    private int size;

    public RedBlackTree(){
        //init root as a black, null, dummynode
        root = new NullDummyNode();
        size = 0;
    }

    public int size(){
        return this.size;
    }



    public boolean addNode(int key, String value){
        RedBlackTreeNode insNode = new RedBlackTreeNode(key, value);

        //is the root a null node/ is the red black tree empty?
        if(this.root instanceof NullDummyNode){
            root = insNode;
            root.switchColorToBlack();
        }

        //todo obviously this shouldnt just return true
        return true;
    }



    //if size == 0 then replace root with new node when inserting
    public static void main(String[] args) {
        RedBlackTree rbt = new RedBlackTree();
        rbt.addNode(10, "e");
        System.out.println(rbt.root.color);
    }
}
