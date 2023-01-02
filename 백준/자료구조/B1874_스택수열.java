package 백준.자료구조;

import java.util.Scanner;
import java.util.Stack;

public class B1874_스택수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Stack<Integer> myStack = new Stack<>();
        StringBuffer bf = new StringBuffer();
        int num = 1;

        for (int i = 0; i < n; i++) {
            int now = arr[i];
            if (now >= num) {
                while (now >= num) {
                    myStack.push(num++);
                    bf.append("+\n");
                }
                myStack.pop();
                bf.append("-\n");

            } else {
                int pn = myStack.pop();
                if (pn > now) {
                    System.out.println("NO");
                    return;
                }
                bf.append("-\n");
            }
        }

        System.out.println(bf.toString());
    }
}
