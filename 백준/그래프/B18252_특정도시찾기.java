package 백준.그래프;
/*
4 4 2 1
1 2
1 3
2 3
2 4
* */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B18252_특정도시찾기 {
    static ArrayList<Integer>[] arrayLists;
    static int[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertex = sc.nextInt();
        int edge = sc.nextInt();
        int goalOfDistance = sc.nextInt();
        int startNum = sc.nextInt();

        ArrayList<Integer> answers = new ArrayList<>();
        visited = new int[vertex + 1];
        arrayLists = new ArrayList[vertex + 1];

        for (int i = 0; i <= vertex; i++) {
            visited[i] = -1;
        }

        for (int i = 1; i <= vertex; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            arrayLists[start].add(end);
        }

        BFS(startNum);

        for (int i = 1; i < visited.length; i++) {
            if (visited[i] == goalOfDistance) {
                answers.add(i);
            }
        }

        if (answers.isEmpty()) {
            System.out.println("-1");
        } else {
            answers.stream().sorted().forEach(System.out::println);
        }
    }

    private static void BFS(int startNum) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNum);
        visited[startNum]++;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int temp : arrayLists[now]) {
                if (visited[temp] == -1) {
                    visited[temp] = visited[now] + 1;
                    queue.add(temp);
                }
            }
        }
    }
}
