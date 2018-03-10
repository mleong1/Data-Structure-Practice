package CodingQuestions;

public class stringPerm {
    //design an algorithm to print all permutations of a string
    public stringPerm() {

    }

    public boolean isPerms(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        char[] hold1 = str1.toCharArray();
        java.util.Arrays.sort(hold1);
        System.out.println(hold1);
        char[] hold2 = str2.toCharArray();
        java.util.Arrays.sort(hold2);
        System.out.println(hold2);
        return java.util.Arrays.equals(hold1, hold2);
    }

    public String urlify(String str, int trueLen){
        //replace all spaces with %20

        char[] hold = new char[trueLen];
        //j is the index for hold
        int j = 0;
        char[] strChar = str.toCharArray();
        //iterate through the string's chars
        for(int i = 0; i < strChar.length && j < hold.length; i++){
            //32 is the value for Space in ASCII
            if(strChar[i] != 32){
                hold[j] = strChar[i];
                //System.out.println(j);
                j ++;
            } else {
                hold[j] = '%';
                j++;
                hold[j] = '2';
                j++;
                hold[j] = '0';
                j++;
            }
        }
        String url = new String(hold);
        return url;
    }

    public boolean isPalPerm(String str){
        //works but filter the input by making all lowercase, then we only have to watch 97 - 122
        char[] hold = str.toCharArray();
        int[] letters = new int[128];
        for (char l: hold){
            letters[l] ++;
        }
        //65 - 122 = A - z
        int canBeOdd = 0;
        for(int i = 65; i < 123; i ++){
            if(letters[i]%2 != 0){
                canBeOdd ++;
            }
        }
        if(canBeOdd > 1){
            return false;
        } else {
            return true;
        }

    }

    //String builder is ideal when you'e planning on making a lot of edits to a string
    public StringBuilder stringComp(String str){
        //want an empty string builder to hold the compressed string
        StringBuilder compress = new StringBuilder();
        int startLen = str.length();
        System.out.println(startLen);
        char currChar = str.charAt(0);
        int repeatNum = 1;

        for (int i = 1; i < str.length(); i ++){

            if(currChar != str.charAt(i) || i+1 >= str.length()){
                compress.append(currChar);
                currChar = str.charAt(i);
                System.out.println(currChar);


                compress.append(repeatNum);

                repeatNum = 1;
                //repeatNum ++;
            } else {
                repeatNum ++;
            }

            /*if(i == str.length() - 1){
                compress.append(currChar);
                compress.append(repeatNum);

            }*/


        }
        return compress;
    }

}
