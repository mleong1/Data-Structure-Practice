package RecursionProblems;

import Stacks.Stack;

public class Tower {

    //public variables
    Stack<Integer> diskStack;

    //constuctor

    public Tower() {
        diskStack = new Stack<Integer>();
    }

    /*method: moveDisk()
      summary: moves a disc (integer) from one stack into another.
    */
    public void moveDisk(Tower dest){
        Integer disk = this.diskStack.pop();
        dest.diskStack.push(disk);
    }

    public void addDisk(Integer val){
        if(!this.diskStack.isEmpty() && val > this.diskStack.peek()){
            System.out.println("Disk is bigger than preceding disk. Cannot Place");
        } else {
            this.diskStack.push(val);
        }
    }

    public static void towerOfHanoi(int n, Tower source, Tower dest, Tower temp){
        /*objective is to move disks from startTow to finTow with these rules-
         1)One disk can be moved at a time
         2)A disk is slid off the top of one tower to another
         3)A disc cannot be placed on top of a smaller disk
         towers are simulated by an array of sorted ints representing discs
         */
        if(n == 0){
            source.moveDisk(dest);
        }
        towerOfHanoi(n-1, source, temp, dest);
        source.moveDisk(dest);
        towerOfHanoi(n - 1, source, dest, temp);
    }

    public static void main(String[] args) {
        Tower a = new Tower();
        Tower b = new Tower();
        Tower c = new Tower();
        a.addDisk(5);
        a.addDisk(10);
        a.moveDisk(b);
        System.out.println(b.diskStack.peek());
        towerOfHanoi(1, a, b, c);
    }
}
