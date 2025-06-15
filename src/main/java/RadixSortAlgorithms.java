/**
 * A utility class that provides an implementation of the Radix Sort algorithm
 * for sorting integer arrays. Radix Sort is a non-comparative sorting algorithm
 * that sorts integers by processing individual digits.
 *
 * <p>This implementation assumes all integers in the input array are non-negative.</p>
 */
public class RadixSortAlgorithms {

    /**
     * Sorts the given array of integers using the Radix Sort algorithm.
     *
     * @param array the array of non-negative integers to be sorted
     * @throws IllegalArgumentException if the input array is null or empty
     */
    public static void radixSort(int[] array) {
        int max = findMaxNum(array);
        for (int place = 1; max / place > 0; place *= 10) {
            sortByDigit(array, place);
        }
    }

    /**
     * Finds and returns the maximum number in the given array.
     *
     * @param array the array of integers
     * @return the maximum integer in the array
     */
    private static int findMaxNum(int[] array) {
        int max = array[0];
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    /**
     * Performs a stable counting sort on the array based on the digit at the specified place value.
     *
     * @param arr   the array to be sorted
     * @param place the digit place to sort by (1 for units, 10 for tens, and so on)
     */
    private static void sortByDigit(int[] arr, int place) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / place) % 10;
            count[digit]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / place) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }
}
