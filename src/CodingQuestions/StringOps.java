package CodingQuestions;

public class StringOps {

    /*StringBuilder helps create a resizable array that is mutable. this way when concating strings you don't
    make multiple strings.
     */

    public static String joinWords(String[] words) {
        StringBuilder sentence = new StringBuilder();
        for (String w: words){
            sentence.append(w + " ");
        }
        return sentence.toString();
    }

    public static String overwrite(String w1, String w2, int sP){
        StringBuilder newWord = new StringBuilder();
        newWord.append(w1);
        //newWord.insert(sP, w2);
        newWord.replace(sP, w1.length(), w2);
        return newWord.toString();
    }

    public static void main(String[] args) {
        String[] words = new String[3];
        words[0] = "making";
        words[1] = "a";
        words[2] = "sentence";
        System.out.println(joinWords(words));
        String w1 = "America";
        String w2 = "Africa";
        System.out.println(overwrite(w1, w2, 5));
    }
}
