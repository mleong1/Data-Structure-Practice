package RecursionProblems;


import java.util.ArrayList;

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

    public static boolean isValidConcat(String[] passwords, String loginAttempt){
        //base case?
        for (String p: passwords) {
            if(loginAttempt.equals(p)){
                return true;
            }
        }

        for (String p: passwords){
            System.out.println(p);
            System.out.println(loginAttempt.substring(0, p.length()));
            if(loginAttempt.substring(0, p.length()).equals(p)){
                return isValidConcat(passwords, loginAttempt.substring(p.length()));
            }
        }
        return false;
    }

    public static int makeChangeRec(int total){
        int[] coinArr = {25, 10, 5, 1};
        //start at coin index 0 for quarter
        return makeChangeRec(total, 0, coinArr);
    }

    public static int makeChangeRec(int total, int coinInd, int[] coinArr){
        //this means you've hit pennies and there is only one way to make change with pennies.
        //pennies is at the last index
        if(coinInd >= coinArr.length - 1){
            return 1;
        }
        int currCoin = coinArr[coinInd];
        int ways = 0;
        for(int i = 0; i * currCoin <= total; i ++){
            //go into the next layer of coin
            ways += makeChangeRec((total - (i*currCoin)), coinInd + 1, coinArr);
        }
        return ways;
    }

    public static int makeChange(int total){
        //count all the ways to make the total using quarters, dimes, nickels and pennies
        //dynamic programming solution
        int[] moneyArr = {1, 5, 10, 25};
        if(total == 0){
            return 0;
        }
        //make an int array of length total
        int[] memo = new int[total + 1];
        memo[0] = 1;
        for (int m: moneyArr) {
            for (int i = 1; i < memo.length; i++) {
                //if the current amount is greater than or equal to the current coin
                if(i >= m) {
                    memo[i] += memo[i - m];
                    //System.out.println(memo[i]);
                }
            }
        }
        return memo[total];
    }

    public static ArrayList<String> permsNoDupes(String str){
        ArrayList<String> perms = new ArrayList<>();
        //add empty string
        String initString = new String("");
        perms.add(initString);
        int addLetterIndex = 0;
        return permsNoDupes(str, addLetterIndex, perms);
    }

    public static ArrayList<String> permsNoDupes(String str, int addLetterIndex, ArrayList<String> perms){
        if(addLetterIndex == str.length() ) {
            return perms;
        }

        char addLetter = str.charAt(addLetterIndex);
        ArrayList<String> newPerms = new ArrayList<>();
        System.out.println(perms.size());
        for (String s: perms) {
            for(int i = 0; i <= s.length(); i ++){
                String newS = s.substring(0, i) + addLetter + s.substring(i);
                System.out.println(newS);
                newPerms.add(i, newS);
            }
        }

        addLetterIndex++;
        return permsNoDupes(str, addLetterIndex, newPerms);
    }

    public String parenBit(String str) {
        if(str.startsWith("(") && str.endsWith(")")){
            return str;
        }

        if(!str.startsWith("(") && !str.endsWith(")")){
            return parenBit(str.substring(1, str.length() - 1));
        }

        if(!str.startsWith("(") && str.endsWith(")")){
            return parenBit(str.substring(1, str.length()));
        }

        if(str.startsWith("(") && !str.endsWith(")")){
            return parenBit(str.substring(0, str.length() - 1));
        }

        return str;
    }

    public String allStar(String str) {
        if(str.length() == 0 || str.length() == 1){
            return str;
        }

        return allStar(str.substring(0, str.length() - 1)) + "*"
                + str.charAt(str.length() - 1);
    }

    public String stringClean(String str) {
        if(str.length() <= 1){
            return str;
        }
        if(str.substring(0, 1).equals(str.substring(1, 2))){
            return stringClean(str.substring(1));
        } else {
            return str.substring(0, 1) + stringClean(str.substring(1));
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
        String password = "password";
        String[] words = {"pass", "word", "yeh"};
        System.out.println(isValidConcat(words, password));
        System.out.println(makeChange(25));
        System.out.println(makeChangeRec(25));

        String str = "abcd";
        ArrayList<String> perms = permsNoDupes(str);
        System.out.println(perms.size());
        System.out.println(perms.get(1));
        System.out.println(perms.get(0));
        System.out.println(str.substring(0, str.length() - 1));
        System.out.println(str + str.charAt(str.length() - 1));
    }
}
