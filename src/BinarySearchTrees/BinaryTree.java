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

    /*method: findNode()
      summary: method searches for a node in the tree using a key. if there is a tree, compare
      the key to the root. if the root is bigger, search the left side of the tree, if lesser the
      right. if you search the tree until the relRoot is null, the key value isn't in the tree.
      params: int key, the key value you're searching for in the tree.
     */
    public TreeNode findNode(int key){
        TreeNode relRoot = root;
        while(relRoot.key != key){
            if(relRoot.key > key){
                relRoot = relRoot.leftChild;
            } else {
                relRoot = relRoot.rightChild;
            }
            //we searched the tree but couldn't find the value
            if(relRoot == null){
                return null;
            }
        }
        return relRoot;
    }

    /*method: delNode()
      summary: deletes a node from the binary tree.
       params: TreeNode root, int key, root is needed for later recursion and the key is the
               value you're searching for in the tree.
     */
    public boolean delNode(TreeNode root, int key){
        //Todo can't delete the root node of the entire btree
        //could have retooled findNode to return the parent of the node being searched for so as to not repeat
        //while loop code
        TreeNode delNode = root;
        TreeNode parent = null;
        //can't delete a null node
        if(root == null){
            return false;
        }
        while(delNode.key != key){
            parent = delNode; //let parent hold the last node
            if(delNode.key > key){
                delNode = delNode.leftChild;
            } else {
                delNode = delNode.rightChild;
            }

            if(delNode == null){
                return false; //its not in the tree
            }
        }
        //at this point we should have a parent to the node being deleted and the node itself
        //here we need to manage 3 cases

        //Not happy with the design here patching in a way to delete the root of the entire btree
        if(parent == null){
            //we are deleting root node here
            //case 1 no children
            if(delNode.leftChild == null && delNode.rightChild == null){
                delNode = null;
            } //case 2 1 child
            else if (delNode.leftChild != null && delNode.rightChild == null){
                delNode.leftChild = this.root;
            } else if (delNode.leftChild == null && delNode.rightChild != null){
                delNode.rightChild = this.root;
            }
        }
        //what side is the delNode relative to the parent
        boolean delNodIsLeft = true;
        System.out.println(parent.key);
        System.out.println(delNode.key);
        //what about the root? we need a separate part fo deleting the root

        if(parent.key > delNode.key){

        } else {
            delNodIsLeft = false;
        }

        //case 1: no children, works
        if(delNode.leftChild == null && delNode.rightChild == null){
            if(delNodIsLeft){
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
            //case 2: 1 child
        } else if(delNode.leftChild != null && delNode.rightChild == null){
            if(delNodIsLeft){
                parent.leftChild = delNode.leftChild;
            } else {
                parent.rightChild = delNode.leftChild;
            }

        } else if (delNode.leftChild == null && delNode.rightChild != null){
            if(delNodIsLeft){
                parent.leftChild = delNode.rightChild;
            } else {
                parent.rightChild = delNode.rightChild;
            }
            //case 3: 2 children, needs work
        } else if (delNode.leftChild != null && delNode.rightChild != null){
            //minimum right subtree node
            TreeNode minRSTNode = delNode.rightChild;
            //find minimum in right subtree
            while(minRSTNode.leftChild != null){
                minRSTNode = minRSTNode.leftChild;
            }
            System.out.println(minRSTNode.key);
            delNode = minRSTNode;

            //remove duplicate value
            this.delNode(delNode.rightChild, minRSTNode.key);


        }



        return true;
    }


    public static void main(String[] args) {
        BinaryTree bT = new BinaryTree();
        bT.addNode(15, "whatver");
        bT.addNode(10, "whatver");
        bT.addNode(50, "whatver");
        bT.addNode(40, "bingo");
        bT.addNode(1, "whatver");
        bT.addNode(5, "whatver");
        bT.addNode(45, "whatever");
        bT.addNode(75, "whatever");

        bT.inOrderTraversal(bT.root);
        System.out.println(" ");
        bT.preOrderTraversal(bT.root);
        System.out.println(" ");
        bT.postOrderTraversal(bT.root);
        System.out.println(bT.findNode(40).name);
        System.out.println(bT.findNode(1).name);
        System.out.println("new Line");
        bT.delNode(bT.root, 50);
        System.out.println("new btree");
        bT.inOrderTraversal(bT.root);

    }
}
