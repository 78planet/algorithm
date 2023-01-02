package 백준.정렬;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {9, 7, 3, 1, 6, 3, 2, 6, 8, 9, 2, 0, 1, 3};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIdx = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[minIdx]) minIdx = j;
            }
            int tmp = array[i];
            array[i] = array[minIdx];
            array[minIdx] = tmp;
        }
    }
}
