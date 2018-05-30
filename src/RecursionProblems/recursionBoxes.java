package RecursionProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class recursionBoxes {

    public int stackBoxes(ArrayList<Box> boxes){
        Collections.sort(boxes, new BoxComparator());
        return stackBoxes(boxes, 0, 0);
    }

    public int stackBoxes(ArrayList<Box> boxes, int currBox, int h){
        //base case
        if(currBox > boxes.size()){
            return h;
        }

        Box bottomBox = boxes.get(currBox);
        boolean isBottom = true;

        for (Box box: boxes) {
            if(bottomBox.getWidth() > box.getWidth() && bottomBox.getDepth() > box.getDepth()){

            } else {
                isBottom = false;
            }
        }

        if(isBottom){
            currBox ++;
            h += bottomBox.getHeight();
            stackBoxes(boxes, currBox, h);
        }

        if(h == 0){
            return bottomBox.getHeight();
        } else {
            return h;
        }
    }

    public ArrayList<Box> generateBoxes(){
        Box box1 = new Box(5, 10, 2);
        Box box2 = new Box(10, 20, 4);
        Box box3 = new Box(12, 24, 6);
        ArrayList<Box> boxes = new ArrayList();
        boxes.add(box1);
        boxes.add(box2);
        boxes.add(box3);
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
    }

    public static void main(String[] args) {
        recursionBoxes rB = new recursionBoxes();
        ArrayList<Box> boxes = rB.generateBoxes();
        System.out.println(rB.stackBoxes(boxes));
    }
}
