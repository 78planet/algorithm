package 백준.그리디;

import java.util.Scanner;

public class B11047_동전 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int count = 0;
        for (int i = n-1; i >= 0; i--) {
            if (m == 0) break;
            if (arr[i] <= m) {
                count += m/arr[i];
                m = m % arr[i];
            }
        }
        System.out.println(count);
    }
}
