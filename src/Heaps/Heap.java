package Heaps;

import java.util.Arrays;

public class Heap {
    /*This is the class that organizes the heapnodes into a min heap structure. we are implementing a
      min heap which is a complete binary tree where the root is always the minimum of the tree. there
      are two key operations to a heap which are insert (what enforces the structure of a heap) and extract min.

      i'm starting to see this is hard to implement like a binary tree. how do i find the rightmost empty space?

      this is probably easier by using an array for this structure. can just add to the end of the array to ensure
      the rightmost spot.
     */

    //private variables
    private int capacity = 10;

    //size is later incremented like a counter as things are added to the heap
    private int size = 0;

    int[] items = new int[capacity];
    //min is at index 0

    /*These are methods to perform calculations that will save time later.
     */
    private int getLeftChildIndex(int parentIndex){
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex){
        return 2 * parentIndex + 2;
    }

    private int getParentIndex(int childIndex){
        return (childIndex - 1) / 2;
    }

    private boolean hasLeftChild(int index){
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index){
        return getRightChildIndex(index) < size;
    }

    //everything should have a parent besides the root
    //why can't we just check if the index is greater than 0 (the root)?
    private boolean hasParent(int index){
        return getParentIndex(index) >= 0;
    }

    private int leftChild(int index){
        return items[getLeftChildIndex(index)];
    }

    private int rightChild(int index){
        return items[getRightChildIndex(index)];
    }

    private int parent(int index){
        return items[getParentIndex(index)];
    }

    /*method: swap()
      summary: a simple swap method for the array or heap. stores the value in indexOne in a temp int and then once
      the value in indexOne is overwritten by the value in indexTwo, we overwrite the value in indexTwo with temp.
      params: int indexOne, int indexTwo, the indices in the heap we are swapping
     */
    private void swap(int indexOne, int indexTwo){
        //hold whats in items at indexOne
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;

    }

    /*method: extraCapacity()
      summary: method from HackerRank video on heaps. Necessary to resize array, like an arraylist, when size
      reaches capacity. copies the array into a new array with double the size. the method is a check.
     */
    private void extraCapacity(){
        if(size == capacity){
            items = Arrays.copyOf(items, capacity * 2);
            //capacity needs to be updated
            //size doesn't because it is obviously being carried over
            capacity *= 2;
        }
    }

    /*method: getMin()
      summary: only returns the value in the 0th index of the heap, which since we are implementing min heap
      is the min of the entire structure.
     */
    public int getMin(){
        if (size == 0){
            throw new IllegalStateException();
        }
        return items[0];
    }

    /*method: extractMin()
      summary: now removes the minimum from the heap which is the first element. make the 0th element the last
      element. don't forget to decrement size. i think size controls what we see in the array.
     */
    public int extractMin(){
        if(size == 0){
            throw new IllegalStateException();
        }
        int elem = items[0];
        items[0] = items[size - 1];
        //this code never actually deletes the value in items[size - 1], it just changes the size which is like a scope
        //it will get deleted on the next add but until then the original duped value stays
        size --;
        heapifyDown();
        return elem;
    }

    /*method: insert()
      summary: inserts a node into the heap structure. inserts node into the complete tree and bubbles the node
      upwards if it is less than its parent.
     */
    public void insert(int elem) {
        extraCapacity();
        items[size] = elem;
        size ++;
        heapifyUp();
    }

    public void heapifyUp() {
        //get the index of the last item in the array
        int index = size - 1;
        //so while the last added value has a parent and is less than its parent
        while(hasParent(index) && parent(index) > items[index]){
            swap(index, getParentIndex(index));
            //now shift index up after swap
            index = getParentIndex(index);
        }
    }

    public void heapifyDown(){
        //so here we have extracted min and replaced it with the rightmost element in the final row of the tree
        int index = 0;
        //while the index has children. no need to check for right because if there is no left there is no right
        while(hasLeftChild(index)){
            //this first if just finds the smaller of the two children
            int smallerChildIndex = getLeftChildIndex(index);
            if(hasRightChild(index) && rightChild(index) < leftChild(index)){
                smallerChildIndex = getRightChildIndex(index);
            }
            //this if statement sees if the index at 0 is smaller or not than the smallest child
            if(items[0] < items[smallerChildIndex]){
                break;
            } else {
                //swap when items[0] is not less than children(not the min)
                swap(index, smallerChildIndex);
            }
            //shift index down to reflect swap and continue while loop
            index = smallerChildIndex;
        }
    }
    public static void main(String[] args) {
        Heap h = new Heap();
        h.insert(20);
        h.insert(15);
        h.insert(17);
        h.insert(10);
        h.insert(9);

        System.out.println(h.getMin());
        h.extractMin();
        h.insert(6);
        System.out.println(h.items[0]);
        System.out.println(h.items[1]);
        System.out.println(h.items[2]);
        System.out.println(h.items[3]);
        System.out.println(h.items[4]);
    }

}
