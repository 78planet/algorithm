package 백준.정수론;

import java.util.Scanner;

/*
 * - n과 m 사이에 2,3,4... 의 제곱과 떨어지는 수를 제거한다.
 * 시작하는 수가 천차만별이기 때문에 실제 제곱과 떨어지는 수의 시작 인덱스를 찾아야 함.
 * 만약 2의 제곱과 떨어지는 수를 제거해야할 때. 시작 수는 100 이다.
 * 2~99 사이의 2의 제곱 값을 안구해도 된다.
 * 시작값 / 2의 제곱 = 25 가 나옴. 25 * 4 해서 26,27,28 * 4 를 해야지 최소값 100 이상 부터 구할 수 있음.ㅋ (이거 이해하느라 ㅈㄹ 오래 걸림 )
 * 그러면 25*4 = 100, 26*4 = 104, 27 * 4 = 108 ... 해서 최대값 까지 구함. 그리고 해당 실제 값의 인덱스를 구해야함.
 * (25*4) - min 의 값이 인덱스임 ㅇㅇ
 * 시작값 % n의 제곱 했는데 0이 아니면 + 1을 해준다. 왜? 곱한 값이 시작값보다 작아질 수도 있기 때문에
 * boolean 배열은 false로 초기화 되어 있기 때문에 제곱의 배수인 인덱스에 true 값을 넣어줌. 그리고 false 인 값을 counting 해줌.
 *
 * */

public class B1016_제곱이아닌수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();
        boolean[] booleans = new boolean[(int)(max - min + 1)];

        for (long i = 2; i * i <= max; i++) {
            long pow = i * i;
            long initialNum = min % pow == 0 ? min / pow : (min / pow) + 1;

            for (long j = initialNum; j * pow <= max; j++) {
                booleans[(int)((j * pow) - min)] = true;
            }
        }

        int cnt = 0;
        for (int i = 0; i < booleans.length; i++) {
            if (booleans[i] == false) cnt++;
        }

        System.out.println(cnt);
    }
}
