package RecursionProblems;


public class Recursion {

    public static int recursiveAdd(int[] nums, int length){
        if(length == 0){
            return 0;
        }

        //System.out.println(nums[length - 1]);
        return nums[length-1] + recursiveAdd(nums, length - 1);
    }

    public static int tripleStep(int numSteps){
        if(numSteps < 0){
            return 0;
        }
        if(numSteps == 0){
            return 1;
        }
        return tripleStep(numSteps - 1) + tripleStep(numSteps - 2) + tripleStep(numSteps - 3);
    }

    public static int powerSum(int X, int P){
        return powerSum(X, P, 1);
    }

    public static int powerSum(int X, int P, int N){
        int num = (int)Math.pow(N, P);
        //System.out.println(num);
        //if N to the power of P is greater than X, it's not included in the power sum
        if(num > X){
            return 0;
            //if N to the power of P is X, it is included in the power sum
        } else if (num == X){
            return 1;
        } else {
            return powerSum(X, P, N += 1) + powerSum(X - num, P, N += 1);
        }
    }

    public static int superDigit(String n){
        int sum = 0;
        if(n.length() == 1){
            sum = Character.getNumericValue(n.charAt(n.length() - 1));
            return sum;
        } else {
            for(int i = 0; i < n.length(); i ++){
                sum += Character.getNumericValue(n.charAt(i));
            }
            String newString = Integer.toString(sum);
            return superDigit(newString);
        }
    }
    public static void main(String[] args) {

        int[] nums = {1, 5, 8, 11};
        System.out.println(recursiveAdd(nums, nums.length));
        //the starting tower of hanoi with discs of size 1, 5, 5, 10, 15, and 20.
        int[] startTow = {1, 5, 5, 10, 15, 20};
        System.out.println(tripleStep(5));
        System.out.println(powerSum(10, 2));
        System.out.println(superDigit("155"));

    }
}
