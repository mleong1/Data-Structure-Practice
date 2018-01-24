package HashTables;
import java.util.Arrays;

public class HashTable {

    /*HashTable and hashfunctions are useful for saving space and memory.
     */
    //Private variables in a hashtable
    String[] hashArray;
    int arraySize;

    //constructor for HashTable
    public HashTable(int arraySize){
        this.arraySize = arraySize;
        this.hashArray = new String[arraySize];
        //fill the hashArray with -1s for illustrative purposes
        Arrays.fill(hashArray, "-1");
    }

    /*Method: easyHashFunction()
      Summary: simply takes an array of strings (which are numbers) and adds them to our hashtable
      through a simple hashfunction.  for each element in the array to add, whatever its number is
      is the index that element will be placed in our hashtable. cannot handle dupes.
      Params: String[] arrToAdd, String[] hashTable, the array of elements to add and the hashtable
      to add them to.
     */
    public void easyHashFunction(String[] arrToAdd, String[] hashTable){
        for(int i = 0; i < arrToAdd.length; i ++){
            String addElem = arrToAdd[i];
            //parse the string element to a int to get its place in our hashtable. this is the hash
            //function
            hashTable[Integer.parseInt(addElem)] = addElem;
        }
    }

    public static void main(String[] args) {
        //create a hashtable, or essentially an array, of length 30 with -1 in each index
        HashTable hT = new HashTable(30);
        String[] ind = {"1", "5", "10", "25"};
        hT.easyHashFunction(ind, hT.hashArray);
        System.out.println(hT.hashArray[0]);
        System.out.println(hT.hashArray[5]);
        System.out.println(hT.hashArray[10]);
        System.out.println(hT.hashArray[25]);
        System.out.println(hT.hashArray[4]);
    }
}
