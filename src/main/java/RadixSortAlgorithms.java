public class RadixSortAlgorithms {

    // O(n log n))
    public static void radixSort(int[] array) {
        int max = findMaxNum(array); // Find the biggest number

        // Sort the array for each digit place (1s, 10s, 100s, etc.)
        for (int place = 1; max / place > 0; place *= 10) {
            sortByDigit(array, place);
        }
    }

    // o(n)
    private static int findMaxNum(int[] array) {
        int max = array[0];
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    // Sort the array by a specific digit (like ones, tens, hundreds)
    private static void sortByDigit(int[] arr, int place) {
        int n = arr.length;
        int[] output = new int[n];     // Array to hold sorted values
        int[] count = new int[10];     // There are 10 possible digits (0 to 9)

        // Count how many times each digit appears at the current place
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / place) % 10;
            count[digit]++;
        }

        // Change count[i] so it shows the position of this digit in output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the sorted output array from the end (to keep sorting stable)
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / place) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Copy the sorted numbers back into the original array
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }
}
