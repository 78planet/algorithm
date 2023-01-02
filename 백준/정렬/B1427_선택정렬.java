package 백준.정렬;

import java.util.Scanner;

public class B1427_선택정렬 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int[] arr = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            arr[i] = Integer.parseInt(s.substring(i, i+1));
        }

        for (int i = 0; i < s.length(); i++) {
            int max = i;
            for (int j = i+1; j < s.length(); j++) {
                if (arr[j] > arr[max]) {
                    max = j;
                }
            }

            if (arr[i] < arr[max]) {
                int tmp = arr[i];
                arr[i] = arr[max];
                arr[max] = tmp;
            }
        }

        for (int x : arr) {
            System.out.print(x);
        }
    }
}
