package HashTables;
import java.util.Scanner;

public class HashTable2 {
    //this hashtable is separate because it will be dealing with strings. words and definitions go into the
    //hash table.  the word is the key and the definition is the value.
    //this hashtable also implement chaining as an anti collision option.

    //public variables
    WordList[] hashArray;
    int arraySize;

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

    public addToList(Word newWord, int HashKey){

        Word previous = null;
        Word current = firstWord;
    }

}
