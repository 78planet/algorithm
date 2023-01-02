package 백준.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1253_좋은수 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int result = 0;
        long arr[] = new long[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            long find = arr[i];
            int lt = 0;
            int rt = n-1;

            while (lt < rt) {
                if (arr[lt] + arr[rt] == find) {
                    if (lt != i && rt != i) {
                        result++;
                        break;
                    } else if (i == lt) {
                        lt++;
                    } else if (i == rt) {
                        rt--;
                    }

                } else if (arr[lt] + arr[rt] < find) {
                    lt++;
                } else {
                    rt--;
                }
            }
        }
        System.out.println(result);
        bf.close();
    }
}
