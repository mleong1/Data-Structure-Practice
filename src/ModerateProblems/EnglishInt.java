package ModerateProblems;

import java.util.LinkedList;

public class EnglishInt {
    String[] smalls = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
    "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    String[] bigs = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    String[] large = {"hundred", "thousand", "million", "billion"};
    String negative = "negative";

    public void writeNum(int num){
        if(num < 20){
            System.out.println(smalls[num]);
        }
    }

    public String convertNum(int num){
        LinkedList<String> parts = new LinkedList<String>();

        if(num > 100){
            //this will take care of the 100ths digit. num/100 is floored
            parts.addLast(smalls[num/100]);
            parts.addLast(large[0]);
            //this sets num equal to the remainder of the number / 100 which is the number stripped of its hundreds digit
            num %= 100;
        }

        if(num >= 10 && num <= 19){
            //this converts the 10s place
            parts.addLast(smalls[num]);
        } else if (num >= 20){
            parts.addLast(bigs[num/10]);
            num %= 10;
        }

        if(num >= 1 && num <= 9){
            parts.addLast(smalls[num]);
        }

        return listToString(parts);
    }

    public String listToString(LinkedList<String> parts){
        StringBuilder sb = new StringBuilder();
        while(parts.size() > 1){
            sb.append(parts.pop());
            sb.append(" ");
        }
        sb.append(parts.pop());
        return sb.toString();
    }

    public static void main(String[] args) {
        EnglishInt eI = new EnglishInt();
        System.out.println(eI.convertNum(231));
    }
}
