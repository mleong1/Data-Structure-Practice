package BinarySearchTrees;

public class RedBlackTreeNode extends TreeNode{
    public Color color;

    public RedBlackTreeNode(int key, String name, int colorCode){
        super(key, name);
        this.color = Color.getColorFromVal(colorCode);

    }



    public enum Color{
        BLACK(0),
        RED(1);
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
        RedBlackTreeNode node = new RedBlackTreeNode(10, "HI", 0);
        System.out.println(node.color);
        System.out.println(node.key);

    }
}
