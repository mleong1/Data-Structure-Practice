package BinarySearchTrees;

public class BinarySearchTree<T> {
    private class BSTnode<T>{
        private int key;
        private T data;
        private BSTnode leftChild;
        private BSTnode rightChild;

        public BSTnode (int key, T data){
            this.key = key;
            this.data = data;
        }

        public BSTnode(){

        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public BSTnode getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(BSTnode leftChild) {
            this.leftChild = leftChild;
        }

        public BSTnode getRightChild() {
            return rightChild;
        }

        public void setRightChild(BSTnode rightChild) {
            this.rightChild = rightChild;
        }
    }

    private BSTnode root;
    private int counter;

    public BinarySearchTree(){

    }
    //methods for the BST
    public int size(){
        return counter;
    }

    public boolean addNode(int key, T data){
        BSTnode node = new BSTnode(key, data);
        if(root == null){
            root = node;
            counter ++;
            return true;
        }
        BSTnode relRoot = root;

        while(true) {
            //if node key is less than root key go left
            if (node.getKey() < relRoot.getKey()){
                if(relRoot.getLeftChild() == null){
                    relRoot.setLeftChild(node);
                    counter ++;
                    return true;
                } else {
                    relRoot = relRoot.getLeftChild();
                }
            } else {
                if(relRoot.getRightChild() == null){
                    relRoot.setRightChild(node);
                    counter ++;
                    return true;
                } else {
                    relRoot = relRoot.getRightChild();
                }
            }
        }
    }

    public BSTnode findNode(int key){
        BSTnode relRoot = root;

        while(true) {
            if(key == relRoot.getKey()){
                return relRoot;
            } else if (key < relRoot.getKey()){
                relRoot = relRoot.getLeftChild();
                if(relRoot == null){
                    return null;
                }
            } else if (key > relRoot.getKey()){
                relRoot = relRoot.getRightChild();
                if(relRoot == null){
                    return null;
                }
            }
        }
    }

    public boolean delNode(int key) {
        BSTnode delNode = root;
        BSTnode parent = null;

        while(key != delNode.getKey()){
            parent = delNode;
            if(key < delNode.getKey()){
                delNode = delNode.getLeftChild();
            } else {
                delNode = delNode.getRightChild();
            }

            if(delNode == null){
                return false;
            }
        }

        boolean delNodeIsLeft;
        if(parent == null){
            delNodeIsLeft = false;
        } else if(delNode.getKey() < parent.getKey()){
            delNodeIsLeft = true;
        } else {
            delNodeIsLeft = false;
        }

        //case 1: delNode has no children
        if(delNode.getLeftChild() == null && delNode.getRightChild() == null){
            if(parent == null){
                root = null;
            } else if(delNodeIsLeft){
                parent.setLeftChild(null);
            } else {
                parent.setRightChild(null);
            }
        }
        //case2: delNode has 1 child
        else if(delNode.getLeftChild() != null && delNode.getRightChild() == null){
            if(parent == null){
                root = delNode.getLeftChild();
            } else if(delNodeIsLeft){
                parent.setLeftChild(delNode.getLeftChild());
            } else {
                parent.setRightChild(delNode.getLeftChild());
            }
        } else if(delNode.getLeftChild() == null && delNode.getRightChild() != null){
            if(parent == null){
                root = delNode.getRightChild();
            } else if(delNodeIsLeft){
                parent.setLeftChild(delNode.getRightChild());
            } else {
                parent.setRightChild(delNode.getRightChild());
            }
        }
        //case 3: delNode has 2 children
        else if(delNode.getLeftChild() != null && delNode.getRightChild() != null){
            //get the minimum item in the right subtree
            //now i remember the recursion in this deletion. to delete the min item after we use it as a replacement
            BSTnode minRSTNode = delNode.getRightChild();
            BSTnode parentRST = delNode;
            while(minRSTNode.getLeftChild() != null){
                parentRST = minRSTNode;
                minRSTNode = minRSTNode.getLeftChild();
            }

            BSTnode replacement = new BSTnode(minRSTNode.getKey(), minRSTNode.getData());

            if(minRSTNode.getKey() < parentRST.getKey()){
                parentRST.setLeftChild(null);
            } else {
                parentRST.setRightChild(null);
            }

            if(parent == null){
                root = replacement;
                replacement.setLeftChild(delNode.getLeftChild());
                replacement.setRightChild(delNode.getRightChild());
            } else if(delNodeIsLeft){
                parent.setLeftChild(replacement);
                replacement.setLeftChild(delNode.getLeftChild());
                replacement.setRightChild(delNode.getRightChild());
            } else {
                parent.setRightChild(replacement);
                replacement.setLeftChild(delNode.getLeftChild());
                replacement.setRightChild(delNode.getRightChild());
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.addNode(5, "hi");
        bst.addNode(1, 5);
        bst.addNode(10, 'c');
        bst.addNode(15, "YAHHH");
        bst.addNode(7, "asdf");
        System.out.println(bst.findNode(10).getData());
        System.out.println(bst.findNode(5).getData());
        System.out.println(bst.findNode(15).getData());

        bst.delNode(10);
        System.out.println(bst.root.getRightChild().getKey());

    }
}