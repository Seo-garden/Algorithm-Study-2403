package Baekjoon.실버;

import java.io.*;
import java.util.*;
public class num15649_N과M {

    static ArrayList<Integer> A;
    static StringBuilder sb;
    static boolean[] visited;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   //숫자 N개
        M = Integer.parseInt(st.nextToken());   //중 M개를 뽑아서

        visited = new boolean[N+1];
        A = new ArrayList<>(M);
        sb = new StringBuilder();



        DFS(0);
        System.out.println(sb);


    }

    static void DFS(int depth) {
        if (depth==M){

            for (int i : A) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]){
                visited[i] =true;
                A.add(i+1);
                DFS(depth+1);
                visited[i] = false;
                A.remove(depth);
            }
        }
    }
}

