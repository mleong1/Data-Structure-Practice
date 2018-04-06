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


    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.addNode(5, "hi");
        bst.addNode(1, 5);
        bst.addNode(10, 'c');
        bst.addNode(15, "YAHHH");
        System.out.println(bst.findNode(10).getData());
        System.out.println(bst.findNode(5).getData());
        System.out.println(bst.findNode(15).getData());

    }
}
