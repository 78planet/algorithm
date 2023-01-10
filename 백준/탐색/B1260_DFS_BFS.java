package 백준.탐색;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class B1260_DFS_BFS {
    static boolean[] visitedArr;
    static ArrayList<Integer>[] arrayLists;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int vertexNum = scanner.nextInt();
        int edgeNum = scanner.nextInt();
        int startNum = scanner.nextInt();

        arrayLists = new ArrayList[vertexNum + 1];
        for (int i = 1; i <= vertexNum; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < edgeNum; i++) {
            int s = scanner.nextInt();
            int e = scanner.nextInt();
            arrayLists[s].add(e);
            arrayLists[e].add(s);
        }

        for (int i = 1; i <= vertexNum; i++) {
            Collections.sort(arrayLists[i]);
        }

        visitedArr = new boolean[vertexNum + 1];
        DFS(startNum);
        System.out.println();

        visitedArr = new boolean[vertexNum + 1];
        BFS(startNum);
        System.out.println();
    }

    private static void BFS(int node) {
        Queue<Integer> myQueue = new LinkedList<>();
        myQueue.add(node);
        visitedArr[node] = true;

        while (!myQueue.isEmpty()) {
            int now = myQueue.poll();
            System.out.print(now + " ");

            for (int i : arrayLists[now]) {
                if (!visitedArr[i]) {
                    visitedArr[i] = true;
                    myQueue.add(i);
                }
            }
        }
    }

    private static void DFS(int node) {
        System.out.print(node + " ");
        visitedArr[node] = true;
        for (int i : arrayLists[node]) {
            if (!visitedArr[i]) {
                DFS(i);
            }
        }
    }
}
