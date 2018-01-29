package HashTables;
import java.util.Scanner;

public class HashTable2 {
    //this hashtable is separate because it will be dealing with strings. words and definitions go into the
    //hash table.  the word is the key and the definition is the value.
    //this hashtable also implement chaining as an anti collision option.

    //public variables
    WordList[] hashArray;
    int arraySize;
    public String[][] elementsToAdd = {
            {"ace", "Very good"},
            {"act", "Take action"},
            {"add", "Join something to something else"},
            {"age", "Grow old"}};
    
    //public constructor
    public HashTable2(int size){
        arraySize = size;
        hashArray = new WordList[size];

        for(int i = 0; i < arraySize; i++){
            hashArray[i] = new WordList();
        }
        addTheArray(elementsToAdd);
    }

    public void insert(Word newWord){
        //store the string of the actual word
        String wordToHash = newWord.theWord;
        int hashKey = stringHashFunction(wordToHash);
        //insert into the hashArray at the hashKey the newWord
        hashArray[hashKey].addToList(newWord, hashKey);

    }

    public void addTheArray(String [][] elementsToAdd){
        for(int i = 0; i < elementsToAdd.length; i ++){
            String word = elementsToAdd[i][0]; //whatever index the first dimension is the word
            String definition = elementsToAdd[i][1]; //2nd dimension is the definition

            //construct a word object with this
            Word newWord = new Word(word, definition);
            insert(newWord);
        }
    }
    //hash function cycles through the letters in the word and creates a hash key based on equation. then you mod
    //the hash value by the array size giving you the index for the table.

    /*method: stringHashFunction()
      summary: takes a word and returns an int index for the word to be inserted into the hashtable. we run an equation
      on each letter in the word to eventually create the index for the word in the hashtable.
      params: String wordToHash, the word we are running through the algorithm to get an index for in the table.
     */
    public int stringHashFunction(String wordToHash){
        int hashKeyVal = 0;
        //loop through the characters in the word
        for (int i = 0; i < wordToHash.length(); i ++){
            //the letter a (first character) has a character code of 97. not sure how this accounts for
            //capital letters which should have different character codes
            int charCode = wordToHash.charAt(i) - 96;

            hashKeyVal = (hashKeyVal * 27 + charCode) % arraySize;
        }
        return hashKeyVal;
    }

    public void displayTheArray(){
        for(int i = 0; i < arraySize; i ++){
            hashArray[i].displayWordList();
        }
    }
}

class Word{
    //leaving this public to not deal with getters and setters. not standard.

    //THIS is essentially just the node class from linkedlist
    //public variables
    public String theWord;
    public String definition;
    public int key;
    //each word stores the next word. basically a linked list. this is how we implement chaining
    public Word next;

    //public constructor
    public Word(String theWord, String definition){
        this.theWord = theWord;
        this.definition = definition;
    }

    //Simple toString method to return the word with a separator and its definition
    public String toString(){
        return theWord + " : " + definition;
    }

}
class WordList{
    //THIS is essentially the linkedlist class from linkedlist.
    //we are storing linked lists in each index of the hashtable. I thought we would generate a linked list when
    //a collision happens but i think we're being preemptive and just making linkedlists.

    //public variable
    public Word firstWord = null;

    public void addToList(Word newWord, int hashKey){

        Word previous = null;
        Word current = firstWord;

        newWord.key = hashKey;

        //this will add words to the list in order
        while(current != null && newWord.key > current.key){
            //cycle through words in the list
            previous = current;
            current = current.next;
        }
        //if the hashkey of the firstWord is less than the hashkey of the newWord
        if(previous == null){
            firstWord = newWord;
        //else newWord belongs in the space after previous but before current
        } else {
            previous.next = newWord;
        }
        //newWord should be placed correctly now in the list. need to set its next.
        newWord.next = current;
    }

    public void displayWordList(){
        Word current = firstWord;
        while(current != null){
            System.out.println(current.toString());
            current = current.next;
        }
    }

    /*public Word find(int hashKey){
        //dont forget words are in order
        Word current = firstWord;
        while(current != null && current.key <= hashKey){
            if(current.key)
        }
    }*/


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        HashTable2 wordHashTable = new HashTable2(11);
        wordHashTable.displayTheArray();
    }
}
