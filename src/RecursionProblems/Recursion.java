package RecursionProblems;

public class Recursion {

    public static int recursiveAdd(int[] nums, int length){
        if(length == 0){
            return 0;
        }

        System.out.println(nums[length - 1]);
        return nums[length-1] + recursiveAdd(nums, length - 1);
    }

    public static void main(String[] args) {

        int[] nums = {1, 5, 8, 11};
        System.out.println(recursiveAdd(nums, nums.length));
        //the starting tower of hanoi with discs of size 1, 5, 5, 10, 15, and 20.
        int[] startTow = {1, 5, 5, 10, 15, 20};
    }
}
