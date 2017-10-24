import java.util.Arrays;

class Mergesort {

    public static void main(String[] args) {
        int[] array = {2, 1, 4, 1, 3, -5, -10 };
        System.out.println(Arrays.toString(array));
        mergesort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void mergesort(int[] array) {
        // Call the private implementation.
        int left = 0;
        int right = array.length -1;
        mergesort(array, left, right);
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
        // Calculate the length of the subarrays.
        // Note that they are not guaranteed to be
        // the same length.
        int sizeLeft = middle - left + 1;
        int sizeRight = right - middle;

        // Create temporary arrays.
        // This lets us copy the subarrays into them,
        // then write the values back into the actual array
        // as needed, ignoring whatever values are currently
        // in the actual array.
        int[] leftSubArray = new int[middle-left+1];
        int[] rightSubArray = new int[right-middle];

        // Copy the values from the original array into the
        // new, temporary subarrays.
        for(int index = 0; index < sizeLeft; index++) {
            leftSubArray[index] = array[left+index];
        }
        for(int index = 0; index < sizeRight; index++) {
            rightSubArray[index] = array[middle+index+1];
        }

        // Now, perform the merge.
        //
        // Write your logic beneath this line.
        // Remember, once you hit the end of a subarray,
        // you need to copy the remaining values out of
        // the other subarray.
        // 
        // My solution was 16 lines. Don't worry about brevity,
        // but focus on readability!
    }
}








