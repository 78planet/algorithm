package 백준.그래프;

/*
5 10 2
1 2 2
1 3 7
1 4 5
1 5 6
2 4 2
2 3 4
3 4 6
3 5 8
5 2 4
5 4 1
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

class B1854_K최단경로 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cityCnt = Integer.parseInt(st.nextToken());
        int roadCnt = Integer.parseInt(st.nextToken());
        int targetNum = Integer.parseInt(st.nextToken());

        ArrayList<Edge3>[] arrayLists = new ArrayList[cityCnt + 1];
        PriorityQueue<Integer>[] distanceQ = new PriorityQueue[cityCnt + 1];
        for (int i = 0; i <= cityCnt; i++) {
            arrayLists[i] = new ArrayList<>();
            distanceQ[i] = new PriorityQueue<>(targetNum, Comparator.reverseOrder());
        }

        for (int i = 0; i < roadCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int targetNode = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            arrayLists[node].add(new Edge3(targetNode, weight));
        }

        PriorityQueue<Edge3> queue = new PriorityQueue<>();
        queue.add(new Edge3(1, 0));
        distanceQ[1].add(0);

        while (!queue.isEmpty()) {
            Edge3 now = queue.poll();
            int nowNode = now.node;

            for (Edge3 e : arrayLists[nowNode]) {
                int nextNode = e.node;
                int nextWeight = e.weight;
                int thisWeight = now.weight + nextWeight;

                if (distanceQ[nextNode].size() < targetNum) {
                    distanceQ[nextNode].add(thisWeight);
                    queue.add(new Edge3(nextNode, thisWeight));
                } else if (distanceQ[nextNode].peek() > thisWeight) {
                    distanceQ[nextNode].poll();
                    distanceQ[nextNode].add(thisWeight);
                    queue.add(new Edge3(nextNode, thisWeight));
                }
            }
        }

        IntStream.range(1, distanceQ.length)
            .forEach(idx -> {
                if (distanceQ[idx].size() == targetNum) {
                    System.out.println(distanceQ[idx].peek());
                } else {
                    System.out.println("-1");
                }
            });
    }
}

class Edge3 implements Comparable<Edge3> {
    int node, weight;

    public Edge3(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge3 o) {
        return this.weight - o.weight;
    }
}
