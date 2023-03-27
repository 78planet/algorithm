package 백준.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
7 8
0 1 3
1 1 7
0 7 6
1 7 1
0 3 7
0 4 2
0 1 1
1 1 1
*/

class B1717_집합표현 {

    static int[] valArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        valArr = new int[n+1];
        for (int i = 0; i <= n; i++) {
            valArr[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int question = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if (question == 0) {
                union(start, end);
            } else {
                if (isSame(start, end)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
    private static int find(int start) {
        if (start == valArr[start]) {
            return start;
        }
        return valArr[start] = find(valArr[start]);
    }

    private static void union(int start, int end) {
        start = find(start);
        end = find(end);
        if (start != end) {
            valArr[end] = start;
        }
    }

    private static boolean isSame(int start, int end) {
        return find(start) == find(end);
    }
}

