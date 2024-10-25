import java.util.Random;

public class MergeSort {

    public static void main(String[] args) {
        // Example usage of MergeSort
        double[] arr = generateRandomArray(10); // Generate random array of size 10
        System.out.println("Original array:");
        printArray(arr);
        
        mergeSort(arr); // Sort the array using MergeSort
        
        System.out.println("Sorted array:");
        printArray(arr);
    }

    // Method to initiate MergeSort
    public static void mergeSort(double[] arr) {
        mergeSort(arr, 0, arr.length);
    }

    // Recursive MergeSort function
    public static void mergeSort(double[] arr, int start, int end) {
        if (end - start < 2) { 
            return; // Base case: array is trivially sorted if it contains 1 or fewer elements
        }
        
        int middle = (start + end) / 2;
        mergeSort(arr, start, middle);  // Sort the first half
        mergeSort(arr, middle, end);    // Sort the second half
        merge(arr, start, middle, end); // Merge the sorted halves
    }

    // Function to merge two sorted halves
    public static void merge(double[] arr, int start, int middle, int end) {
        int i = start;      // Pointer for the first half
        int j = middle;     // Pointer for the second half
        int k = 0;          // Pointer for the temporary array
        double[] tempArr = new double[end - start]; // Temporary array to store merged results

        // Merge the two sorted halves into tempArr
        while (i < middle && j < end) {
            if (arr[i] <= arr[j]) {
                tempArr[k++] = arr[i++];
            } else {
                tempArr[k++] = arr[j++];
            }
        }

        // Copy any remaining elements from the first half
        while (i < middle) {
            tempArr[k++] = arr[i++];
        }

        // Copy any remaining elements from the second half
        while (j < end) {
            tempArr[k++] = arr[j++];
        }

        // Copy the merged array back to the original array
        System.arraycopy(tempArr, 0, arr, start, tempArr.length);
    }

    // Helper method to generate a random array of doubles
    public static double[] generateRandomArray(int size) {
        Random random = new Random();
        double[] arr = new double[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextDouble() * 100; // Random numbers between 0 and 100
        }
        return arr;
    }

    // Helper method to print an array
    public static void printArray(double[] arr) {
        for (double num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
// Merge Sort:
// Divide and Conquer: Merge Sort works by dividing the array into smaller subarrays,
// sorting those subarrays, and then merging them back together.

// Bubble Sort:
// Swapping Adjacent Elements: Bubble Sort repeatedly steps through the list, 
// compares adjacent elements, and swaps them if they are in the wrong order.