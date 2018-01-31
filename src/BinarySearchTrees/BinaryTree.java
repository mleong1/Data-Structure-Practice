package BinarySearchTrees;

public class BinaryTree {
    /*This is the class that organizes the treenodes into the binary tree data structure through means
      of addNode and deleteNode methods to enforce the shape.
     */

    //public variables
    TreeNode root;
    //the one node we keep track of is the root node

    /*method: addNode()
      summary: adds a node to the binary tree. it compares the key value of the add node to the root node. if
      the new key is less than the root node, check the left child and redo the process as if the left child was
      the root. if the new key is greater than the root node, check the right child and redo the process as if
      the right child was the root. continue until a child node is null. new node belongs there.
      param: int key, String name, the key and name to create a new node for the tree.
     */
    public void addNode(int key, String name){
        TreeNode newNode = new TreeNode(key, name);
        if(root == null){
            root = newNode;
        } else {
            //make a holder of the relative root to find the place for the newNode
            TreeNode relRoot = root;
            TreeNode parent;
            while(true) {
                //parent is used to hold relRoot
                parent = relRoot;
                //left tree if statements. when left node is null thats the place if newNode < relRoot
                if (newNode.key < relRoot.key) {
                    relRoot = relRoot.leftChild;
                    if (relRoot == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                    //if newNode key is equal to relRoot key you go to else
                } else {
                    relRoot = relRoot.rightChild;
                    if (relRoot == null){
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    /*method: inOrderTraversal();
      summary: take the root then keep going down the tree by the leftChild.  once you hit a null when you've
      gone one leftChild too far, execute the print statement of the last leftChild. then go to the last leftChild's
      rightChild. then do the whole process all over again going down the tree by leftChild. Rinse and repeat.
      param: TreeNode root, needs a root to start at and to continue the recursive process.
     */
    public void inOrderTraversal(TreeNode root){
        if (root != null) {
            inOrderTraversal(root.leftChild);
            System.out.println(root.key);
            inOrderTraversal(root.rightChild);
        }
    }

    /*method: preOrderTraversal()
      summary: visits the parent node before the children. first prints out the root.
      param: TreeNode root, needs a root to start at and to continue the recursive process.
     */
    public void preOrderTraversal(TreeNode root){
        if(root != null){
            System.out.println(root.key);
            preOrderTraversal(root.leftChild);
            preOrderTraversal(root.rightChild);
        }
    }

    /*method: postOrderTraversal()
      summary: visits the children node(s) before the parent.
      TreeNode root, needs a root to start at and to continue the recursive process.
     */
    public void postOrderTraversal(TreeNode root){
        if(root != null){
            postOrderTraversal(root.leftChild);
            postOrderTraversal(root.rightChild);
            System.out.println(root.key);
        }
    }
    public static void main(String[] args) {
        BinaryTree bT = new BinaryTree();
        bT.addNode(15, "whatver");
        bT.addNode(10, "whatver");
        bT.addNode(50, "whatver");
        bT.addNode(40, "whatver");
        bT.addNode(1, "whatver");
        bT.addNode(5, "whatver");

        bT.inOrderTraversal(bT.root);
        System.out.println(" ");
        bT.preOrderTraversal(bT.root);
        System.out.println(" ");
        bT.postOrderTraversal(bT.root);
    }
}
