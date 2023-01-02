package 백준.정렬;

import java.util.Arrays;
public class MergeSort {

    public static void sort(int[] array) {
        // Create a new MergeSorter object and call the sort() method on it
        MergeSorter sorter = new MergeSorter(array);
        sorter.sort();
    }

    private static class MergeSorter {
        private int[] array;
        private int[] tempArray;

        public MergeSorter(int[] array) {
            this.array = array;
            this.tempArray = new int[array.length];
        }

        private void sort() {
            sort(0, array.length - 1);
        }

        private void sort(int low, int high) {
            if (low < high) {
                int middle = (low + high) / 2;
                sort(low, middle);
                sort(middle + 1, high);
                merge(low, middle, high);
            }
        }

        private void merge(int low, int middle, int high) {
            // Copy the array into the tempArray
            for (int i = low; i <= high; i++) {
                tempArray[i] = array[i];
            }

            int i = low;
            int j = middle + 1;
            int k = low;

            // Copy the smallest values from either the left or the right side back
            // to the original array
            while (i <= middle && j <= high) {
                if (tempArray[i] <= tempArray[j]) {
                    array[k] = tempArray[i];
                    i++;
                } else {
                    array[k] = tempArray[j];
                    j++;
                }
                k++;
            }

            // Copy the rest of the left side of the array into the target array
            while (i <= middle) {
                array[k] = tempArray[i];
                k++;
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 3, 8, 6, 2, 7, 1, 4};
        MergeSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
