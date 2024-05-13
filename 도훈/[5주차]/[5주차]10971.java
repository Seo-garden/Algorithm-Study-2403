package Baekjoon.실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class num10971_외판원순회2 {

    static int N;
    static long MIN;
    static int[][] W;
    static ArrayList<Integer> A;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        A = new ArrayList<>();

        MIN = Long.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }

        }
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            visited[i] = true;
            DFS(i,i,0,0);
            visited[i] = false;
        }
        System.out.println(MIN);
    }

    static void DFS(int start, int now, long cost,int depth) {
        if (depth == N-1 ){
            if(W[now][start] != 0 ){
                MIN = Math.min(MIN,cost+W[now][start]);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i] && W[now][i] != 0){
                visited[i] = true;
                DFS(start, i, cost+W[now][i], depth+1);
                visited[i]= false;
            }
        }
    }

}
