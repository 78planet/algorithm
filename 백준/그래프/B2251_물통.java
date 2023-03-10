package 백준.그래프;

// 8 9 10

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

class B2251_물통 {
    static int[] senderIdx = {0, 0, 1, 1, 2, 2};
    static int[] receiverIdx = {1, 2, 0, 2, 0, 1};
    static boolean[][] visited;
    static boolean[] answer;
    static int[] initVal;
    static final int MAX = 200;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        initVal = new int[3];
        initVal[0] = sc.nextInt();
        initVal[1] = sc.nextInt();
        initVal[2] = sc.nextInt();

        visited = new boolean[MAX + 1][MAX + 1];
        answer = new boolean[MAX + 1];

        BFS();

        IntStream.range(0, answer.length)
            .filter(idx -> answer[idx])
            .forEach(idx -> System.out.print(idx + " "));
    }

    private static void BFS() {
        Queue<AB> queue = new LinkedList<>();
        queue.add(new AB(0, 0));
        visited[0][0] = true;
        answer[initVal[2]] = true;

        while (!queue.isEmpty()) {
            AB poll = queue.poll();
            int A_curVal = poll.a;
            int B_curVal = poll.b;
            int C_curVal = initVal[2] - A_curVal - B_curVal;

            for (int k = 0; k < 6; k++) {
                int[] curValArr = {A_curVal, B_curVal, C_curVal};
                curValArr[receiverIdx[k]] += curValArr[senderIdx[k]];
                curValArr[senderIdx[k]] = 0;

                if (curValArr[receiverIdx[k]] > initVal[receiverIdx[k]]) {
                    curValArr[senderIdx[k]] = curValArr[receiverIdx[k]] - initVal[receiverIdx[k]];
                    curValArr[receiverIdx[k]] = initVal[receiverIdx[k]];
                }

                if (!visited[curValArr[0]][curValArr[1]]) {
                    visited[curValArr[0]][curValArr[1]] = true;
                    queue.add(new AB(curValArr[0], curValArr[1]));
                    if (curValArr[0] == 0) {
                        answer[curValArr[2]] = true;
                    }
                }
            }
        }
    }
}

class AB {
    int a;
    int b;

    public AB(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
