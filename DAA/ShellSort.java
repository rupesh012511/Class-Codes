import java.util.Arrays;

public class ShellSort {

    public static void sort(int[] arr) {
        int n = arr.length;

        // Start with a large gap, then reduce the gap by half each time
        for (int gap = n / 2; gap > 0; gap /= 2) {

            // Do a gapped insertion sort for this gap size.
            // The first gap elements a[0..gap-1] are already in gapped order
            // keep adding one more element until the entire array is gap sorted
            for (int i = gap; i < n; i++) {

                // Store the current element to be positioned
                int temp = arr[i];
                int j;

                // Shift earlier gap-sorted elements up until the correct location for a[i] is found
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }

                // Put temp (the original a[i]) in its correct location
                arr[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] data = { 23, 12, 1, 8, 34, 54, 2, 3 };

        System.out.println("Original Array: " + Arrays.toString(data));
        sort(data);
        System.out.println("Sorted Array:   " + Arrays.toString(data));
    }
}