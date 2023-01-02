package 백준.정렬;

import java.util.Arrays;

public class RadixSort {
    public static void sort(int[] array, int maxDigits) {
        // Create an array to store the counts of each digit value
        int[] counts = new int[10];

        // Create an array to store the output of each pass
        int[] output = new int[array.length];

        // Iterate over each digit
        for (int i = 0; i < maxDigits; i++) {
            // Reset the counts array
            Arrays.fill(counts, 0);

            // Count the number of occurrences of each digit value
            for (int value : array) {
                int digit = getDigit(value, i);
                counts[digit]++;
            }

            // Set the position of each digit value in the output array
            for (int j = 1; j < counts.length; j++) {
                counts[j] += counts[j - 1];
            }

            // Place the values in the output array in the correct position
            for (int j = array.length - 1; j >= 0; j--) {
                int digit = getDigit(array[j], i);
                output[--counts[digit]] = array[j];
            }

            // Copy the output array back to the input array for the next pass
            System.arraycopy(output, 0, array, 0, array.length);
        }
    }

    // Returns the digit at the specified position for the given value
    public static int getDigit(int value, int position) {
        return (int)(value / Math.pow(10, position)) % 10;
    }

    public static void main(String[] args) {
        int[] array = {329, 457, 657, 839, 436, 720, 355};

        // Sort the array using radix sort
        sort(array, 3);

        // Print the sorted array
        System.out.println(Arrays.toString(array));
    }
}
