package 백준.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

class B1516_게임개발 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> listArrayList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            listArrayList.add(new ArrayList<>());
        }

        int[] indegreeArr = new int[n+1];
        int[] valueArr = new int[n+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            valueArr[i] = start;

            while (true) {
                int next = Integer.parseInt(st.nextToken());
                if (next == -1) {
                    break;
                }
                listArrayList.get(next).add(i);
                indegreeArr[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        IntStream.range(1, indegreeArr.length)
            .filter(idx -> indegreeArr[idx] == 0)
            .forEach(queue::add);

        int[] results = new int[n + 1];

        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (listArrayList.get(now).isEmpty()) continue;
            // System.out.println("----------------------------------------------------");
            for (int next : listArrayList.get(now)) {
                // System.out.printf("now = %d, next = %d, results[next] = %d, indegreeArr[next] = %d, results[now] = %d, valueArr[now] = %d\n"
                //     ,now, next, results[next], indegreeArr[next], results[now], valueArr[now]);

                indegreeArr[next]--;
                results[next] = Math.max(results[next], results[now] + valueArr[now]);

                if (indegreeArr[next] == 0) {
                    queue.add(next);
                }
            }
            // System.out.println("----------------------------------------------------");
        }

        IntStream.range(1, results.length)
            .forEach(idx -> System.out.println(results[idx] + valueArr[idx]));
    }
}
