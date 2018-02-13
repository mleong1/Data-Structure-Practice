package Searches;

public class Main {

    /*method: binarySearch()
      summary: finds an element from a SORTED array.
      params: int[] array, int value, the sorted array we are searching through and the value we are searching
      for. method is static so we don't need an instance of a class to use the method.
     */
    public static int binarySearch(int[] array, int value){
        int beg = 0;
        //get index of last int in array
        int end = array.length - 1;
        int mid;

        while(beg <= end){
            mid = (beg + end) / 2;
            if(array[mid] == value){
                return mid;
                //if the middle value is less than search value, search value is in the right sub array
            } else if(array[mid] < value){
                beg = mid + 1;
            } else if(array[mid] > value){
                end = mid - 1;
            }
        }
        return -1;
    }

    public static int recBinarySearch(int[] array, int value, int beg, int end){

        //base case
        if(beg > end) {
            return -1;
        }
        int mid = (beg + end) / 2;

        if (array[mid] < value){
            return recBinarySearch(array, value, mid + 1, end);
        } else if (array[mid] > value){
            return recBinarySearch(array, value, beg, mid -1);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6};
        System.out.println(binarySearch(a, 5));
        System.out.println(recBinarySearch(a, 17, 0, a.length-1));
    }
}
