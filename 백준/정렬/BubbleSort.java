package 백준.정렬;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {9, 7, 3, 1, 6, 3, 2, 6, 8, 9, 2, 0, 1, 3};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void sort(int[] array) {
        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                    isSorted = false;
                }
            }
        }
    }
}
