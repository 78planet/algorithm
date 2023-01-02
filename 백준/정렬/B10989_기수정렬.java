package 백준.정렬;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B10989_기수정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        radixSort(arr);

        for (int i = 0; i < n; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void radixSort(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) max = arr[i];
        }
        for (int exp = 1; max/exp > 0; exp*=10) {
            countingSort(arr, exp);
        }
    }

    private static void countingSort(int[] arr, int exp) {
        // 1. arr를 exp 로 나누고, count배열의 인덱스의 값에 count++
        // 2. count를 합배열로 저장.
        // 3. arr[i]의 나머지의 값으로 count 배열의 인덱스 값을 지정해 값을 가져온다. 이 값에 -1 한 값을 output 배열 인덱스에다가 arr[i] 의 값을 삽입한다.
        // 4. count 배열에 특정 값을 output 배열에 복사했다면 count 배열 특정 값을 감소한다.

        int[] count = new int[10];
        int[] output = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            count[(arr[i]/exp)%10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] = count[i-1] + count[i];
        }

        for (int i = arr.length-1; i >= 0; i--) {
            output[count[(arr[i]/exp)%10]-1] = arr[i];
            count[(arr[i]/exp)%10]--;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }
}
