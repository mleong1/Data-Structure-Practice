package Sorts;

public class Main {

    /*method: swap()
     summary: a simple swap method for the array or heap. stores the value in indexOne in a temp int and then once
     the value in indexOne is overwritten by the value in indexTwo, we overwrite the value in indexTwo with temp.
     params: int indexOne, int indexTwo, the indices in the heap we are swapping
    */
    private static void swap(int[] array, int indexOne, int indexTwo){
        //hold whats in items at indexOne
        int temp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;

    }

    public static void bubbleSort(int[] array){
        boolean swapped = true;
        while(swapped){
            swapped = false;
            for(int i = 1; i < array.length; i ++){
                if(array[i - 1] > array[i]){
                    swap(array, i - 1, i);
                    swapped = true;
                }
            }
        }

    }

    /*method: selectionSort()
      summary: an O(n^2) in place comparison sort. simple algorithm that can outperform in some scenarios in terms
      of space requirements. find the smallest element and replace it with the first element. then find the second
      smallest element in another linear scan and place it after the first element.
      params: int[] array, the array to be sorted
     */
    public static void selectionSort(int[] array){
        //going to need to keep track of where the unsorted part of the array and the sorted bit
        int partition = 0;

        while(partition < array.length) {
            int min = partition;
            for (int i = min + 1; i < array.length; i++) {
                if (array[min] > array[i]) {
                    min = i;
                }

            }
            System.out.println(min + " this is the min index");
            //swap min value to the sorted side
            swap(array, partition, min);
            //move index of partition up to separate sorted side from unsorted
            partition++;
        }
    }

    public static void main(String[] args) {

        int[] a = {8, 7, 4, 5, 2, 6, 1};
        selectionSort(a);
        System.out.println(a[0]);
        System.out.println(a[1]);
        System.out.println(a[2]);
        System.out.println(a[3]);
        System.out.println(a[4]);
        System.out.println(a[5]);
        System.out.println(a[6]);

    }
}
