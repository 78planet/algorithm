package 백준.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1940_주몽 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int exactNum = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int cnt = 0;
        int lt = 0;
        int rt = n-1;

        while (lt < rt) {
            if (arr[lt] + arr[rt] < exactNum) {
                lt++;
            } else if (arr[lt] + arr[rt] > exactNum) {
                rt--;
            } else {
                cnt++;
                rt--;
                lt++;
            }
        }
        System.out.println(cnt);
        bf.close();
    }
}
