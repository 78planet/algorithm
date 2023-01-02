package 백준.자료구조;

import java.io.IOException;
import java.util.Scanner;

public class B10986_나머지합 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[] mySum = new long[n];
        long[] mValArr = new long[m];
        long answer = 0;

        mySum[0] = sc.nextInt();
        for (int i = 1; i < n; i++) {
            mySum[i] = mySum[i-1] + sc.nextInt();
        }

        for (long x : mySum) {
            int reminder = (int) x % m;
            if (reminder == 0) answer++;
            mValArr[reminder]++;
        }

        for (int i = 0; i < m; i++) {
            if (mValArr[i] > 1) {
                answer = answer + (mValArr[i] * (mValArr[i] - 1) / 2);
            }
        }

        System.out.println(answer);
    }
}
