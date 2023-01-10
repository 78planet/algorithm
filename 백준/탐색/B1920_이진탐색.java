package 백준.탐색;

import java.util.Arrays;
import java.util.Scanner;

class B1920_이진탐색 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = sc.nextInt();
        }

        Arrays.sort(ints);

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            boolean find = false;
            int targetVal = sc.nextInt();

            int start = 0;
            int end = ints.length - 1;

            while (start <= end) {
                int midIdx = (start + end) / 2;
                int midVal = ints[midIdx];

                if (targetVal < midVal) {
                    end = midIdx - 1;

                } else if (midVal < targetVal) {
                    start = midIdx + 1;

                } else {
                    find = true;
                    break;
                }
            }

            if (find) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}

