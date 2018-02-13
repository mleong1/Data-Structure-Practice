package Searches;

public class Main {

    /*method: binarySearch()
      summary: finds an element from a SORTED array.
      params: int[] array, int value, the sorted array we are searching through and the value we are searching
      for. method is static so we don't need an instance of a class to use the method.
     */
    public static int binarySearch(int[] array, int value){
        int low = 0;
        //get index of last int in array
        int high = array.length - 1;
        int mid;

        while(low <= high) {
            mid = (low + high) / 2;
            System.out.println(mid);
            //if value is less we want to check the low to mid side of array
            if (value < array[mid]) {
                high = mid;
                //if value is greater we want to check the mid to low side of array
            } else if (value > array[mid]) {
                low = mid;
                //otherwise we found it
            } else {
                return mid;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6};
        binarySearch(a, 4);
    }
}
