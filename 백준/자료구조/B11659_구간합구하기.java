package 백준.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11659_구간합구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int total = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());

        int[] mySumArr = new int[total + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= total; i++) {
            mySumArr[i] = mySumArr[i-1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            int lt = Integer.parseInt(st.nextToken());
            int rt = Integer.parseInt(st.nextToken());

            System.out.println(mySumArr[rt] - mySumArr[lt-1]);
        }
    }
}
