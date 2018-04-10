package Heaps;

public class Heap2 <V>{
    private class HeapNode2<V>{
        private int key;
        private V value;
        private HeapNode2 parent;
        private HeapNode2 leftChild;
        private HeapNode2 rightChild;

        public HeapNode2(int k, V v){
            this.key = k;
            this.value = v;
        }

        public String toString(){
            return this.value + " has a key of " + this.key;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public HeapNode2 getParent() {
            return parent;
        }

        public void setParent(HeapNode2 parent) {
            this.parent = parent;
        }

        public HeapNode2 getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(HeapNode2 leftChild) {
            this.leftChild = leftChild;
        }

        public HeapNode2 getRightChild() {
            return rightChild;
        }

        public void setRightChild(HeapNode2 rightChild) {
            this.rightChild = rightChild;
        }
    }
    private HeapNode2 top;
    private int size;

    public Heap2(){
    }

    public boolean addNode(int key, V value){
        //i guess boolean isn't necessary as a return type because why would add fail?
        HeapNode2 insNode = new HeapNode2(key, value);
        if (top == null){
            top = insNode;
            size ++;
            //can return true here because no need to heapify
            return true;
        }

        HeapNode2 relRoot = top;
        String path = Integer.toBinaryString(size + 1);
        for(int i = 1; i < path.length() - 1; i ++){
            if(path.charAt(i) == '0'){
                //take a left
                relRoot = relRoot.getLeftChild();
            } else if(path.charAt(i) == '1'){
                relRoot = relRoot.getRightChild();
            }
        }

        //System.out.println(relRoot.getKey());

        if(path.charAt(path.length()-1) == '0'){
            relRoot.setLeftChild(insNode);
            insNode.setParent(relRoot);
        } else if (path.charAt(path.length()-1) == '1'){
            relRoot.setRightChild(insNode);
            insNode.setParent(relRoot);
        }

        heapifyUp(insNode);
        size ++;
        //todo add heapify up method
        return true;
    }

    public void heapifyUp(HeapNode2 lastNode){
        //heapifyUp and Down are probably much easier to handle in the array form of heaps
        //while the last node has a parent and its key is less than its parent key...
        while(lastNode.getParent() != null && lastNode.getKey() < lastNode.getParent().getKey()){
            //...swap them
            HeapNode2 temp = new HeapNode2(lastNode.getParent().getKey(), lastNode.getParent().getValue());
            lastNode.getParent().setKey(lastNode.getKey());
            lastNode.getParent().setValue(lastNode.getValue());
            lastNode.setKey(temp.getKey());
            lastNode.setValue(temp.getValue());
            /*
            HeapNode2 parent = lastNode.getParent();
            HeapNode2 temp = parent;
            temp.setLeftChild(null);
            temp.setRightChild(null);
            boolean lastNodeIsLeft;

            if(parent.getLeftChild() == lastNode){
                lastNodeIsLeft = true;
            } else {
                lastNodeIsLeft = false;
            }
            if(parent.getParent().getLeftChild() == parent){
                parent.getParent().setLeftChild(lastNode);
                lastNode.setParent(parent.getParent());
                parent.setParent(null);
                if(lastNodeIsLeft){
                    lastNode.setLeftChild(temp);
                    lastNode.setRightChild(parent.getRightChild());
                    temp.setParent(lastNode);
                    parent.getRightChild().setParent(lastNode);
                    parent = null;
                } else {
                    lastNode.setLeftChild(parent.getLeftChild());
                    lastNode.setRightChild(temp);
                    temp.setParent(lastNode);
                    parent.getLeftChild().setParent(lastNode);
                    parent = null;
                }
            } else if(parent.getParent().getRightChild() == parent){
                parent.getParent().setRightChild(lastNode);
                lastNode.setParent(parent.getParent());
                parent.setParent(null);
                if(lastNodeIsLeft){
                    lastNode.setLeftChild(temp);
                    lastNode.setRightChild(parent.getRightChild());
                    temp.setParent(lastNode);
                    parent.getRightChild().setParent(lastNode);
                    parent = null;
                } else {
                    lastNode.setLeftChild(parent.getLeftChild());
                    lastNode.setRightChild(temp);
                    temp.setParent(lastNode);
                    parent.getLeftChild().setParent(lastNode);
                    parent = null;
                }
            }*/
        }
    }

    public static void main(String[] args) {
        Heap2 h = new Heap2();
        h.addNode(5, "WADSD");
        h.addNode(10, "was");
        h.addNode(1, "asdf");
        h.addNode(15, "sdfasfd");
        h.addNode(2, "blah bah");
        h.addNode(3, "hahaha");
        System.out.println(h.top.toString());
        System.out.println(h.top.getLeftChild().getLeftChild().toString());

    }
}
