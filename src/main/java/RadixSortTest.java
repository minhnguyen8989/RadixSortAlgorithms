import java.util.Arrays;

public class RadixSortTest {
    public static void main(String[] args) {
        int[] fixedArray = {783, 99, 472, 182, 264, 543, 356, 295, 692, 491, 94};

        System.out.println("Original array:");
        System.out.println(Arrays.toString(fixedArray));

        RadixSortAlgorithms.radixSort(fixedArray);

        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(fixedArray));

        System.out.println("Find max");
        RadixSortAlgorithms.findMax(fixedArray);
        System.out.println(Arrays.toString(fixedArray));
    }
}
