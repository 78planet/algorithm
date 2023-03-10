package 백준.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

class B1325_효율적인해킹 {
    static ArrayList<Integer>[] arrayLists;
    static int[] answers;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int vertex = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());

        arrayLists = new ArrayList[vertex + 1];
        answers = new int[vertex + 1];

        for (int i = 1; i <= vertex; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arrayLists[start].add(end);
        }

        for (int i = 1; i <= vertex; i++) {
            visited = new boolean[vertex + 1];
            BFS(i);
        }

        int maxNumInAnswers = Arrays.stream(answers).max().getAsInt();
        IntStream.range(0, answers.length)
            .filter(idx -> answers[idx] == maxNumInAnswers)
            .forEach(idx -> System.out.print(idx + " "));
    }

    private static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int temp : arrayLists[now]) {
                if (!visited[temp]) {
                    visited[temp] = true;
                    answers[temp]++;
                    queue.add(temp);
                }
            }
        }
    }
}
