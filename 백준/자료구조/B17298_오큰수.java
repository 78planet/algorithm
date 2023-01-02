package 백준.자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class B17298_오큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];    // 수열 배열 생성
        int[] ansArr = new int[n]; // 정답 배열 생성
        String[] strArr = bf.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }

        Stack<Integer> myStack = new Stack<>();
        myStack.push(0);

        for (int i = 1; i < n; i++) {
            while (!myStack.isEmpty() && arr[myStack.peek()] < arr[i]) {
                ansArr[myStack.pop()] = arr[i];
            }
            myStack.push(i);
        }

        while (!myStack.isEmpty()) {
            ansArr[myStack.pop()] = -1;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            bw.write(ansArr[i] + " ");
            // 출력한다
        }
        bw.write("\n");
        bw.flush();
    }
}
