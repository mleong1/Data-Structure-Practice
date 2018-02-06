package Heaps;

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
        return (childIndex - 2) / 2;
    }

    /*method: insert()
      summary: inserts a node into the heap structure. inserts node into the complete tree and bubbles the node
      upwards if it is less than its parent.
     */
    public void insert(int key, String name){
        HeapNode insNode = new HeapNode(key, name);
        if(root == null){
            root = insNode;
        }
    }
}
