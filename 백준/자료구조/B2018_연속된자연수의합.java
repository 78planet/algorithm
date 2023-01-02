package 백준.자료구조;

import java.util.Scanner;

public class B2018_연속된자연수의합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 1;

        int startIdx = 1;
        int endIdx = 1;
        int sum = 1;

        while (endIdx != n) {
            if (sum == n) {
                cnt++;
                endIdx++;
                sum += endIdx;

            } else if (sum > n) {
                sum -= startIdx;
                startIdx++;

            } else {
                endIdx++;
                sum += endIdx;
            }
        }

        System.out.println(cnt);
    }
}
