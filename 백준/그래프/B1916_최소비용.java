package 백준.그래프;

/*
5
8
1 2 2
1 3 3
1 4 1
1 5 10
2 4 2
3 4 1
3 5 1
4 5 3
1 5
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class B1916_최소비용 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cityCnt = Integer.parseInt(br.readLine());
        int busCnt = Integer.parseInt(br.readLine());
        StringTokenizer st;

        ArrayList<Edge2>[] arrayLists = new ArrayList[cityCnt + 1];
        for (int i = 0; i <= cityCnt; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        int[] distance = new int[cityCnt + 1];
        for (int i = 0; i <= cityCnt; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        boolean[] visited = new boolean[cityCnt + 1];

        for (int i = 0; i < busCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int targetNode = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            arrayLists[node].add(new Edge2(targetNode, weight));
        }
        st = new StringTokenizer(br.readLine());
        int startNode = Integer.parseInt(st.nextToken());
        int endNode = Integer.parseInt(st.nextToken());

        distance[startNode] = 0;

        PriorityQueue<Edge2> queue = new PriorityQueue<>();
        queue.add(new Edge2(startNode, 0));

        while (!queue.isEmpty()) {
            Edge2 now = queue.poll();
            int nowNode = now.node;

            if (visited[nowNode]) continue;
            visited[nowNode] = true;

            for (Edge2 e : arrayLists[nowNode]) {
                int nextNode = e.node;
                int nextWeight = e.weight;
                int thisWeight = distance[nowNode] + nextWeight;
                if (distance[nextNode] > thisWeight) {
                    distance[nextNode] = thisWeight;
                    queue.add(new Edge2(nextNode, thisWeight));
                }
            }
        }

        System.out.println(distance[endNode]);
    }
}

class Edge2 implements Comparable<Edge2> {

    int node, weight;

    public Edge2(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge2 e) {
        return this.weight > e.weight ? 1 : -1;
    }
}
