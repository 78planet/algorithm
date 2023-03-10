package 백준.그래프;

/*
2
3 2
1 3
2 3
4 4
1 2
2 3
3 4
4 2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class B1707_이분그래프 {
    static ArrayList<Integer>[] arrayLists;
    static boolean[] visited;
    static int[] check;
    static boolean isEven; // true 이면 인접한 노드가 같은 집합이므로 이분 그래프가 아님.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        for (int k = 0; k < n; k++) {
            st = new StringTokenizer(br.readLine());
            int nodeNum = Integer.parseInt(st.nextToken());
            int edgeNum = Integer.parseInt(st.nextToken());

            arrayLists = new ArrayList[nodeNum + 1];
            for (int i = 1; i <= nodeNum; i++) {
                arrayLists[i] = new ArrayList<>();
            }

            visited = new boolean[nodeNum + 1];
            check = new int[nodeNum + 1];
            isEven = false;

            for (int i = 0; i < edgeNum; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                arrayLists[start].add(end);
                arrayLists[end].add(start);
            }

            for (int i = 1; i <= nodeNum; i++) {
                if (isEven) {
                    break;
                } else {
                    DFS(i);
                }
            }

            if (isEven) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }

    private static void DFS(int node) {
        visited[node] = true;
        for (int childNode : arrayLists[node]) {
            if (!visited[childNode]) {
                check[childNode] = (check[node] + 1) % 2;
                DFS(childNode);
            } else if (check[childNode] == check[node]) {
                isEven = true;
                return;
            }
        }
    }
}
