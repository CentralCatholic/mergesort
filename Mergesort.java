import java.util.Arrays;
public class Mergesort {
    public static void main(String[] args) {
        int[] array = {2, 1, 4, 1, 3, -5, 12};
        System.out.println(Arrays.toString(array));
        mergesort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void mergesort(int[] array) {
        int start = 0, end = array.length;
        mergesort(array, start, array.length - 1);
    }

    private static void mergesort(int[] array, int left, int right) {
        // First, we check the base case
        if(left >= right) {
            // An array of size 1 is always sorted.
            return;
        }
        // Find the middle of the subarray,
        // which is the average of left and right.
        int middle = (right + left) / 2;

        mergesort(array, left, middle);
        mergesort(array, middle+1, right);

        merge(array, left, middle, right);
    }

    private static void merge(int[] array, int left, int middle, int right) {
        int sizeLeft  = middle - left + 1;
        int sizeRight = right - middle;

        int[] leftSubArray  = new int[middle - left + 1];
        int[] rightSubArray = new int[right - middle];
       
        // Copy the values into the temp arrays
        for(int index = 0; index < sizeLeft; index++) {
            leftSubArray[index] = array[left+index];
        }

        // Copy the values into the temp arrays
        for(int index = 0; index < sizeRight; index++) {
            rightSubArray[index] = array[middle+index+1];
        }

        // Perform the merge:
        int i = 0, j = 0;
        while(i < sizeLeft && j < sizeRight) {
            if(leftSubArray[i] <= rightSubArray[j]) {
                array[left+i+j] = leftSubArray[i];
                i++;
            } else {
                array[left+i+j] = rightSubArray[j];
                j++;
            }
        }

        // Copy the remaining elements out of the array
        // These two loops are mutually exclusive because the exit condition of the 
        // above while loop requires that one of the entrant conditions of the below loops
        // be false.
        for( ; i < sizeLeft; i++) {
            array[left+i+j] = leftSubArray[i];
        }
        for( ; j < sizeRight; j++) {
            array[left+i+j] = rightSubArray[j];
        }
    }
}
