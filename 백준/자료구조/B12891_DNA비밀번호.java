package 백준.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B12891_DNA비밀번호 {
    static int[] checkArr;
    static int[] myArr;
    static int checkSecret;
    static int dnaIdNum = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int strNum = Integer.parseInt(st.nextToken());
        int partialNum = Integer.parseInt(st.nextToken());
        int result = 0;
        char[] charArray = bf.readLine().toCharArray();

        checkArr = new int[dnaIdNum];
        myArr = new int[dnaIdNum];
        checkSecret = 0;

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < dnaIdNum; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if (checkArr[i] == 0) checkSecret++;
        }

        for (int i = 0; i < partialNum; i++) {
            add(charArray[i]);
        }
        if (checkSecret == 4) result++;

        for (int rt = partialNum; rt < strNum; rt++) {
            int lt = rt - partialNum;
            add(charArray[rt]);
            remove(charArray[lt]);
            if (checkSecret == 4) result++;
        }
        System.out.println(result);
        bf.close();
    }

    private static void remove(char c) {
        switch (c) {
            case 'A':
                if (myArr[0] == checkArr[0]) checkSecret--;
                myArr[0]--;
                break;
            case 'C':
                if (myArr[1] == checkArr[1]) checkSecret--;
                myArr[1]--;
                break;
            case 'G':
                if (myArr[2] == checkArr[2]) checkSecret--;
                myArr[2]--;
                break;
            case 'T':
                if (myArr[3] == checkArr[3]) checkSecret--;
                myArr[3]--;
                break;
        }
    }

    private static void add(char c) {
        switch (c) {
            case 'A':
                myArr[0]++;
                if (myArr[0] == checkArr[0]) checkSecret++;
                break;
            case 'C':
                myArr[1]++;
                if (myArr[1] == checkArr[1]) checkSecret++;
                break;
            case 'G':
                myArr[2]++;
                if (myArr[2] == checkArr[2]) checkSecret++;
                break;
            case 'T':
                myArr[3]++;
                if (myArr[3] == checkArr[3]) checkSecret++;
                break;
        }
    }
}
