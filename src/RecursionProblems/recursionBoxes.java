package RecursionProblems;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class recursionBoxes {

    public int stackBoxes(ArrayList<Box> boxes){
        Collections.sort(boxes, new BoxComparator());
        return stackBoxes(boxes, 0);
    }

    public int stackBoxes(ArrayList<Box> boxes, int currBox){
        Box bottomBox = boxes.get(currBox);
        //int height = bottomBox.getHeight();
        int maxHeight = 0;

        for(int i = currBox + 1; i <= boxes.size() - 1; i++){
            System.out.println(i);
            if(boxes.get(i).canBeAbove(bottomBox)){
                //maxHeight = height + stackBoxes(boxes, i);
                //System.out.println(height);
                //System.out.println(maxHeight);
                int height = stackBoxes(boxes, i); //stores highest stack height for one base
                maxHeight = Math.max(maxHeight, height);

            }
        }
        maxHeight += bottomBox.getHeight();
        return maxHeight;
    }
    public int stackBoxesBroken(ArrayList<Box> boxes){
        Collections.sort(boxes, new BoxComparator());
        return stackBoxesBroken(boxes, 0);
    }

    public int stackBoxesBroken(ArrayList<Box> boxes, int currBox){

        if(currBox + 1 > boxes.size() - 1){ //if this is the last box and it can be above last box
            return boxes.get(currBox).getHeight();
        }

        System.out.println(currBox);
        Box bottomBox = boxes.get(currBox);
        int height = bottomBox.getHeight();
        System.out.println(height);
        Box nextBox = boxes.get(currBox + 1);

        if(nextBox.canBeAbove(bottomBox)){
            currBox ++;
            height += stackBoxesBroken(boxes, currBox);
        } else {
            //this doesn't work because you're just jumping two boxes ahead and assuming it can be added to the stack
            if(currBox + 2 < boxes.size() - 1) {
                currBox += 2;//skip the next box
                height += stackBoxesBroken(boxes, currBox);
            } else {
                return height;
            }
        }
        //this doesnt work if next cant be above but next after can be
        return height;
    }

    public ArrayList<Box> generateBoxes(){
        Box box1 = new Box(5, 5, 4);
        Box box2 = new Box(10, 8, 9);
        Box box3 = new Box(15, 9, 10);
        Box box4 = new Box(0, 10, 5);
        ArrayList<Box> boxes = new ArrayList();
        boxes.add(box1);
        boxes.add(box2);
        boxes.add(box3);
        boxes.add(box4);
        return boxes;
    }












    public class BoxComparator implements Comparator<Box>{
        public int compare(Box a, Box b){
            return b.getHeight() - a.getHeight();
        }
    }

    private class Box {
        private int height;
        private int width;
        private int depth;

        public Box(){

        }

        public Box(int height, int width, int depth){
            this.height = height;
            this.width = width;
            this.depth = depth;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getDepth() {
            return depth;
        }

        public void setDepth(int depth) {
            this.depth = depth;
        }

        public boolean canBeAbove(Box b){
            return this.getWidth() < b.getWidth() && this.getDepth() < b.getDepth();
        }
    }

    public static void main(String[] args) {
        recursionBoxes rB = new recursionBoxes();
        ArrayList<Box> boxes = rB.generateBoxes();
        System.out.println(rB.stackBoxes(boxes));
    }
}
