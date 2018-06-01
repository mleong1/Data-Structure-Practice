package BinarySearchTrees;

public class NullDummyNode extends RedBlackTreeNode {
    public NullDummyNode(){
        super(0, null, 0);
    }

    public static void main(String[] args) {
        NullDummyNode n = new NullDummyNode();
        System.out.println(n.color);
    }
}
