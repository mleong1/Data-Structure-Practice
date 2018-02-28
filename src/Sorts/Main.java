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

    public static void mergeSort(int[] array){
        //recursive solution. sort the left half, sort the right half, merge those halves
        //this is just a helper method to get params right for the eventual recursive call
        mergeSort(array, new int[array.length], 0, array.length - 1);
    }

    public static void mergeSort(int[]array, int[] temp, int beg, int end){
        if(beg >= end){
            return;
        }
        int middle = (beg + end) / 2;
        //recursive call for the left side
        mergeSort(array, temp, beg, middle);
        //recursive call for the right side
        mergeSort(array, temp, middle + 1, end);
        mergeHalves(array, temp, beg, end);
    }

    public static void mergeHalves(int[] array, int[] temp, int beg, int end){
        //the piece that actually does the sorting work

        /* LeftSide (beg ---- endBeg)
           RightSide (begEnd ---- end)
         */
        //get the end index of the left merge sort. essentially the middle
        int endBeg = (beg + end)/2;
        //need to keep track of the beginning of the right side.
        int begEnd = endBeg + 1;
        //size of the subarray we are dealing with
        int size = (end - beg) + 1;

        //we haven't sub divided arrays at all. we are just focusing on certain sections of the original array
        int left = beg;
        int right = begEnd;
        int index = beg;

        //while both left and right subarrays are still in bounds
        while(left <= endBeg && right <= end){
            if(array[left] <= array[right]){
                temp[index] = array[left];
                left++;
            } else {
                temp[index] = array[right];
                right++;
            }
            index++;
        }
        //now when the left or right array goes out of bounds, we need to copy the remaining elements from
        //either side with remaining elements
        //use System.arraycopy
        /*copy from array, starting from the left pointer, into temp, starting from index (where we left off),
        the remaining left array items
        */
        System.arraycopy(array, left, temp, index, endBeg - left + 1);
        /*copy from array, starting from the right pointer, into temp, starting from index (where we left off),
        the remaining right array items
        */
        System.arraycopy(array, right, temp, index, end - right + 1);
        //copy everything from temp back into array
        System.arraycopy(temp, beg, array, beg, size);
    }

    public static void quickSort(int[] array){
        quickSort(array, 0, array.length-1);
    }

    public static void quickSort(int[] array, int beg, int end){
        if(beg >= end){
            return;
        }
        //this is the part where you pick a pivot NOTE pivot is the actual value in the index
        //beg + end is necessary because of when you calc pivot with smaller subarrays
        int pivot = array[(beg + end)/2];
        //partition method comes in here. should return an index that divides the initial array into subarrays (left and right)
        //partition array around this pivot
        int index = partition(array, beg, end, pivot);
        quickSort(array, beg, index - 1);
        quickSort(array, index, end);
    }

    public static int partition(int[] array, int beg, int end, int pivot){
        //while beg value pointer is less than or equal to the end value pointer
        while(beg <= end) {
            while (array[beg] < pivot) {
                beg ++;
            }
            while (array[end] > pivot){
                //minus minus because you're moving inwards to the beginning of the array
                end --;
            }
            if(beg <= end){
                swap(array, beg, end);
                beg ++;
                end --;
            }
        }
        //need to return the partition point. what is it?
        //it is where the beg pointer currently is
        return beg;
    }

    public static void main(String[] args) {

        int[] a = {8, 7, 4, 5, 2, 6, 1};
        quickSort(a);
        System.out.println(a[0]);
        System.out.println(a[1]);
        System.out.println(a[2]);
        System.out.println(a[3]);
        System.out.println(a[4]);
        System.out.println(a[5]);
        System.out.println(a[6]);

    }
}
