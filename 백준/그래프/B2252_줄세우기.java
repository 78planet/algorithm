package 백준.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

class B2252_줄세우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> listArrayList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            listArrayList.add(new ArrayList<>());
        }

        int[] indegreeArr = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int big = Integer.parseInt(st.nextToken());
            int small = Integer.parseInt(st.nextToken());
            listArrayList.get(big).add(small);
            indegreeArr[small]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        IntStream.range(1, indegreeArr.length)
            .filter(idx -> indegreeArr[idx] == 0)
            .forEach(queue::add);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + " ");
            for (int temp : listArrayList.get(now)) {
                indegreeArr[temp]--;
                if (indegreeArr[temp] == 0) {
                    queue.add(temp);
                }
            }
        }
    }
}
