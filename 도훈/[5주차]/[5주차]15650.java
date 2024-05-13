package Baekjoon.실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num15650_N과M_2 {
    //순서가 달라도 중복으로
    static int[] A;
    static StringBuilder sb;

    static int N,M;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   //숫자 N개
        M = Integer.parseInt(st.nextToken());   //중 M개를 뽑아서


        A = new int[M];
        sb = new StringBuilder();


        DFS(0, 1);
        System.out.println(sb);


    }

    static void DFS(int depth, int now) {
        if (depth == M) {
            for (int i : A) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }
        for (int i = now; i <= N; i++) {
            A[depth] = i;
            DFS(depth+1, i+1);
        }
        //4 2

        //1 2
        //1 3
        //1 4
        //2 3
        //2 4
        //3 4



    }
}

