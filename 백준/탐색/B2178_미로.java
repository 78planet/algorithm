package 백준.탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class B2178_미로 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] arr;
    static boolean[][] visited;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(s.substring(j, j + 1));
            }
        }

        visited = new boolean[n][m];
        BFS(0, 0);
        System.out.println(arr[n - 1][m - 1]);
    }

    private static void BFS(int x, int y) {
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[] {x, y});
        while (!Q.isEmpty()) {
            int[] now = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (arr[nx][ny] > 0 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        arr[nx][ny] = arr[now[0]][now[1]] + 1;
                        Q.add(new int[] {nx, ny});
                    }
                }
            }
        }
    }
}

