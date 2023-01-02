package 백준.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1377_버블소트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        data[] arr = new data[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new data(i, Integer.parseInt(br.readLine()));
        }

        Arrays.sort(arr);

        int max = 0;
        for (int i = 0; i < n; i++) {
            if (max < arr[i].index - i) {
                max = arr[i].index - i;
            }
        }

        System.out.println(max+1);
    }
}

class data implements Comparable<data> {
    public int index;
    public int value;

    public data(int index, int value) {
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(data o) {
        return this.value - o.value;
    }
}
