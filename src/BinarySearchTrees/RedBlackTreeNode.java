package BinarySearchTrees;

import sun.reflect.generics.tree.Tree;

public class RedBlackTreeNode extends TreeNode{
    //using enums I feel like leads to problems
    //new inserted nodes should always be red so set color to red in constructor,
    //watch out for root node which has to be black though
    public Color color;

    public RedBlackTreeNode(){
    }

    public RedBlackTreeNode(int key, String name){
        super(key, name);
        this.color = Color.getColorFromVal(1);
        this.leftChild = new NullDummyNode();
        this.rightChild = new NullDummyNode();
    }

    //for use in creation of nulldummynodes
    public RedBlackTreeNode(int key, String name, int color){
        super(key, name);
        this.color = Color.getColorFromVal(color);
    }

    public Color getColor(){
        return this.color;
    }

    public void switchColorToRed(){
        this.color = Color.RED;
    }

    public void switchColorToBlack(){
        this.color = Color.BLACK;
    }




    public enum Color{
        BLACK(0),
        RED(1);

        //i dont think we actually need this val nonsense since we auto assign a new RBnode to Red anyway
        private int val;

        private Color(int val){
            this.val = val;
        }

        public static Color getColorFromVal(int val){
            switch(val){
                case 0:
                    return BLACK;
                case 1:
                    return RED;
                default:
                    return null;
            }
        }
    }
    public static void main(String[] args) {
        RedBlackTreeNode node = new RedBlackTreeNode(10, "HI");
        System.out.println(node.color);
        System.out.println(node.key);
        node.switchColorToBlack();
        System.out.println(node.color);
        //polymorphism, whats happening here is the treenode is using as much data from redblack treenode as possible
        //so color is lost.
        TreeNode tN = node;
        System.out.println(tN.key);
    }
}
