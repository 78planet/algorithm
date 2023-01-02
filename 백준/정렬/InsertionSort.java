package 백준.정렬;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {9, 7, 3, 1, 6, 3, 2, 6, 8, 9, 2, 0, 1, 3};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];

            int j = i - 1;
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];
                j--;
            }
            array[j+1] = current;
        }
    }
}
