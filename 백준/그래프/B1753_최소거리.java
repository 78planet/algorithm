package 백준.그래프;
/*
5 6
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class B1753_최소거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCnt = Integer.parseInt(st.nextToken());
        int edgeCnt = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(br.readLine());

        ArrayList<Edge>[] arrayLists = new ArrayList[nodeCnt+1];
        for (int i = 0; i <= nodeCnt; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        int[] distance = new int[nodeCnt + 1];
        for (int i = 0; i <= nodeCnt; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[startNode] = 0;

        boolean[] visited = new boolean[nodeCnt + 1];

        for (int i = 0; i < edgeCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int targetNode = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            arrayLists[node].add(new Edge(targetNode, weight));
        }

        PriorityQueue<Edge> queue = new PriorityQueue<>(); // 자동으로 거리가 최소인 노드를 찾기 위함.
        queue.add(new Edge(startNode, 0));

        while (!queue.isEmpty()) {
            Edge now = queue.poll();
            int nowNode = now.node;

            if (visited[nowNode]) continue;
            visited[nowNode] = true;

            for (Edge edge : arrayLists[nowNode]) {
                int nextNode = edge.node;
                int nextWeight = edge.weight;
                int thisWeight = distance[nowNode] + nextWeight;
                if (distance[nextNode] > thisWeight) {
                    distance[nextNode] = thisWeight;
                    queue.add(new Edge(nextNode, thisWeight));
                }
            }
        }

        for (int i = 1; i < distance.length; i++) {
            if (visited[i]) {
                System.out.println(distance[i]);
            } else {
                System.out.println("INF");
            }
        }
    }
}

class Edge implements Comparable<Edge> {
    int node, weight;

    public Edge(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge e) {
        return this.weight > e.weight? 1 : -1;
    }
}
