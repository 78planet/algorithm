package 백준.정수론;

import java.util.Scanner;

public class B1456_거의소수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();
        long[] arr = new long[10000001];
        // 10^7 이상의 값을 제곱할 경우 주어진 최대 범위 10^14를 넘어서므로 10^7 까지의 소수를 구함.
        for (int i = 2; i < arr.length; i++) {
            arr[i] = i;
        }
        for (int i = 2; i <= Math.sqrt(arr.length) ; i++) {
            if (arr[i] == 0) continue;
            for (int j = i + i; j < arr.length; j = j + i) {
                arr[j] = 0;
            }
        }

        int cnt = 0;
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] != 0 && arr[i] < max) {
                long temp = arr[i];
                // 7^8 < 1000
                // == 7^8 % 7^7 < 1000 % 7^7
                // == 7 < 1000 % 7^7
                // == N < max / N^k-1
                // ex) 2 <= max/2 수식은 2^2 가 max 범위 안에 있다는 의미임.
                while ((double)arr[i] <= (double)max / (double)temp) {
                    if ((double)arr[i] >= (double)min / (double)temp) {
                        System.out.printf("%d : %d\n", temp, max);
                        cnt++;
                    }
                    temp = temp * arr[i];
                }
                System.out.println("----------------------");
            }
        }

        System.out.println(cnt);
    }
}
