package 백준.그래프;

/*
3
3
0 1 0
1 0 1
0 1 0
1 2 3
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class B1976_여행계획 {

    static int[] valArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        int[][] cities = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                cities[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int[] route = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            route[i] = Integer.parseInt(st.nextToken());
        }

        valArr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            valArr[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (cities[i][j] != 0) {
                    union(i, j);
                }
            }
        }

        int firstCity = find(route[1]);
        for (int i = 2; i < route.length; i++) {
            if (firstCity != find(route[i])) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }


    private static void union(int start, int end) {
        start = find(start);
        end = find(end);
        if (start != end) {
            valArr[end] = start;
        }
    }

    private static int find(int start) {
        if (start == valArr[start]) {
            return start;
        }
        return valArr[start] = find(valArr[start]);
    }
}
