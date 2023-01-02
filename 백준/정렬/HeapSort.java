package 백준.정렬;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        Heap heap = new Heap(arr);
        heap.sort();
        System.out.println(Arrays.toString(heap.getArray()));
    }
}

class Heap {
    private int[] array;

    public Heap(int[] array) {
        this.array = array;
        buildHeap();
    }

    public void sort() {
        int n = array.length;
        for (int i = n - 1; i > 0; i--) {
            swap(0, i);
            heapify(0, i);
        }
    }

    public int[] getArray() {
        return array;
    }

    private void buildHeap() {
        int n = array.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(i, n);
        }
    }

    private void heapify(int i, int n) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && array[left] > array[largest]) {
            largest = left;
        }
        if (right < n && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(i, largest);
            heapify(largest, n);
        }
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
