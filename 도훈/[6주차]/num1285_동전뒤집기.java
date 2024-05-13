package Baekjoon.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num1285_동전뒤집기 {

    static int N, MIN;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        MIN = Integer.MAX_VALUE;

        //T : 뒷면 , H : 앞면
        for (int i = 0; i < N; i++) {
            char[] str = br.readLine().toCharArray();
            A[i] = 0;
            
            for (int j = 0; j < str.length; j++) {
                if (str[j] == 'T') {
                    A[i] |= (1 << j); // 해당 위치 동전 뒤집기
                }
            }
        }

        // 답지 봤는데 아무리 봐도 모르겠어 ...
        for (int i = 0; i < (1 << N); i++) { // 가능한 모든 열을 뒤집어가며 최솟값 찾기
            int sum = 0;
            for (int j = 0; j < N; j++) {
                int count = Integer.bitCount(A[j] ^ i); // 열 뒤집기 후 뒷면의 개수
                sum += Math.min(count, N - count); // 최솟값 갱신
            }
            MIN = Math.min(MIN, sum);
        }
        System.out.println(MIN);
    }
}
