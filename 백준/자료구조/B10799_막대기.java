package 백준.자료구조;

import java.util.Scanner;
import java.util.Stack;

public class B10799_막대기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        char[] charArray = next.toCharArray();
        Stack<Character> myStack = new Stack<>();
        int answer = 0;

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '(') myStack.push('(');
            else {
                myStack.pop();
                if (charArray[i-1] == '(') answer+=myStack.size();
                else answer++;
            }
        }

        System.out.println(answer);
    }
}
