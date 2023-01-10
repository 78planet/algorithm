package 백준.탐색;

import java.util.*;
public class B13023_친구관계파악하기 {
    static boolean visitedArr[];
    static ArrayList<Integer>[] arrayLists;
    static boolean arrive;

    public static void main(String[] args) {
        arrive = false;
        Scanner in = new Scanner(System.in);

        int verticesNum = in.nextInt();
        int edgeNum = in.nextInt();

        arrayLists = new ArrayList[verticesNum];
        visitedArr = new boolean[verticesNum];

        for (int i = 0; i < verticesNum; i++) {
            arrayLists[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < edgeNum; i++) {
            int s = in.nextInt();
            int e = in.nextInt();
            arrayLists[s].add(e);
            arrayLists[e].add(s);
        }

        for (int i = 0; i < verticesNum; i++) {
            DFS(i, 1);
            if (arrive) {
                break;
            }
        }

        if (arrive) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }

    private static void DFS(int now, int depth) {
        if (depth == 5 || arrive) {
            arrive = true;
            return;
        }
        visitedArr[now] = true;
        for (int i : arrayLists[now]) {
            if (!visitedArr[i]) {
                DFS(i, depth+1);
            }
        }
        visitedArr[now] = false;
    }
}
