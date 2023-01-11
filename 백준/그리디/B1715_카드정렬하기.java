package 백준.그리디;

import java.util.PriorityQueue;
import java.util.Scanner;

public class B1715_카드정렬하기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            queue.add(scanner.nextInt());
        }

        int sum = 0;
        while (queue.size() != 1) {
            int data1 = queue.poll();
            int data2 = queue.poll();
            sum += data1 + data2;
            queue.add(data1 + data2);
        }
        System.out.println(sum);
    }
}
