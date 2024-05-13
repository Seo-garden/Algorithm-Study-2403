package Baekjoon.실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class num15787_기차가어둠을헤치고은하수를 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N+1];             // 원소들번호를 1번부터 시작
        int I;
        int X = -1;             //11111111111111111111111111111111
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int caseNum =Integer.parseInt(st.nextToken());
            I = Integer.parseInt(st.nextToken());
            switch (caseNum) {
                case 1:
                    X = Integer.parseInt(st.nextToken());
                    A[I] = A[I] | (1<<X);           //원소 삽입 (1번부터)
                    break;
                case 2:

                    X = Integer.parseInt(st.nextToken());
                    A[I] = A[I] & ~(1<<X);          //원소 제거 (1번부터)
                    break;
                case 3:
                    A[I] = A[I]<<1;                 // 현재 원소들을 좌로 1칸씩 이동
                    A[I] = A[I] & ~(1<<21);         // 22두번째칸 제거      
                    break;
                case 4:
                    A[I] = A[I]>>1;          //현재 원소들을 우로 1칸씩 이동
                    A[I] = A[I] & ~(1);     // 0...01       0번째 원소 제거 
                    break;
            }
        }
        HashSet<Integer> S = new HashSet<>();
        for (int i = 1; i < N + 1; i++) {               //중복 제거 (순서 상관없음)
            S.add(A[i]);
        }
        System.out.println(S.size());                   //기차 개수 출력
//        Integer.toBinaryString() 하면 10진수 -> 2진수
        
    }
}
