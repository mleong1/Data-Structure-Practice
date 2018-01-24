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
    /*Method: mediumHashFunction()
      Summary: this is the same function as easyHashFunction except we use the mod function on each parsed
      int. That is the entry's index in our hashtable now.
      Params: String[] arrToAdd, String[] hashTable, the array of elements to add and the hashtable
      to add them to.
     */
    public void mediumHashFunction(String[] arrToAdd, String[] hashTable){
        for(int i = 0; i < arrToAdd.length; i ++){
            String addElem = arrToAdd[i];
            //parse the string element to an int. then modulo that int and thats the hashtable index
            int addElemInd = Integer.parseInt(addElem) % (this.arraySize - 1);
            //what if we have the entries 30 and 60? no remainder means same index which means a collision
            //we have to handle
            while(!hashTable[addElemInd].equals("-1")){
                //something is in this hashTable index
                //just go to the next index until you get -1 or an empty element
                addElemInd ++;
                addElemInd %= (arraySize - 1);

            }
            hashTable[addElemInd] = addElem;
        }
    }

    /*Method: findKey()
      Summary: given a string key, search the hashTable for the key and return the value.  simply
      do the hashfunction calculation on the key to find the index in the table.
      Param: String key, the key we are searching for.
     */
    public String findKey(String key){
        int hashTableInd = Integer.parseInt(key) % 29;
        //its simply not enough to return the element inside the hashTableInd we calculated, because we haven't
        //accounted for collisions.
        return this.hashArray[hashTableInd];
    }

    public static void main(String[] args) {
        //create a hashtable, or essentially an array, of length 30 with -1 in each index
        HashTable hT = new HashTable(30);
        String[] ind = {"1", "5", "10", "25"};
        String[] ind2 = {"100", "234", "476", "201", "356", "425",
                         "21", "436", "721", "30"};
        //hT.easyHashFunction(ind, hT.hashArray);
        hT.mediumHashFunction(ind2, hT.hashArray);
        System.out.println(hT.hashArray[0]);
        System.out.println(hT.hashArray[1]);
        System.out.println(hT.hashArray[2]);
        System.out.println(hT.hashArray[3]);
        System.out.println(hT.hashArray[4]);
        System.out.println(hT.hashArray[5]);
        System.out.println(hT.hashArray[6]);
        System.out.println(hT.hashArray[7]);
        System.out.println(hT.hashArray[8]);
        System.out.println(hT.hashArray[9]);
        System.out.println(hT.hashArray[10]);
        System.out.println(hT.hashArray[11]);
        System.out.println(hT.hashArray[12]);
        System.out.println(hT.hashArray[13]);
        System.out.println(hT.hashArray[14]);
        System.out.println(hT.hashArray[15]);
        System.out.println(hT.hashArray[16]);
        System.out.println(hT.hashArray[17]);
        System.out.println(hT.hashArray[18]);
        System.out.println(hT.hashArray[19]);
        System.out.println(hT.hashArray[20]);
        System.out.println(hT.hashArray[21]);
        System.out.println(hT.hashArray[22]);
        System.out.println(hT.hashArray[23]);
        System.out.println(hT.hashArray[24]);
        System.out.println(hT.hashArray[25]);
        System.out.println(hT.hashArray[26]);
        System.out.println(hT.hashArray[27]);
        System.out.println(hT.hashArray[28]);
        System.out.println(hT.hashArray[29]);
        System.out.println(100 % 29);
        System.out.println(234 % 29);
        System.out.println(436 % 29);
        System.out.println(30 % 29);
        System.out.println(hT.findKey("30"));

    }
}
