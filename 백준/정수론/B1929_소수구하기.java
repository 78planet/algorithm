package 백준.정수론;

import java.util.Scanner;

public class B1929_소수구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] ints = new int[m + 1];
        for (int i = 2; i <= m; i++) {
            ints[i] = i;
        }

        int sqrtNum = (int)Math.sqrt(m);
        for (int i = 2; i <= sqrtNum; i++) {
            if (ints[i] == 0) continue;
            for (int j = i + i; j <= m; j = j + i) {
                ints[j] = 0;
            }
        }

        for (int i = n; i <= m; i++) {
            if (ints[i] != 0) {
                System.out.println(i);
            }
        }
    }
}
