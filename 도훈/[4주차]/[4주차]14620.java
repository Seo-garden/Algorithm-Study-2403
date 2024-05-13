package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 *     (1,1) ~ (n,n) 범위에 씨앗을 3개 심고 상하좌우로 닿으면 죽음 각 좌표별로 가격이 다르다 3개의 꽃이 필때 최소 가격을 탐색
 * */
public class num14620_꽃길 {
    static int N;
    static int[][] A;
    static boolean[][] visited;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};


    static int MinCost = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        // 6 <= N <= 10 ,  0<= G <= 200
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        A = new int[N][N];
        visited = new boolean[N][N];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }



        dfs(0,0);
        System.out.println(MinCost);


    }

    private static void dfs(int depth, int sum) {
        //depth 가 3이기 전에 이미 대여한 곳의 합계가 지금까지의 최소 비용을 넘어간다면 return
        if (MinCost <= sum) return;

        if (depth == 3) {
            MinCost = Math.min(MinCost, sum);       // depth =3  이면 최소값 비교후 저장
        }else{
            for (int i = 1; i < N - 1; i++) {       // 꽃의 중심이 될수 있는 애는 (1 ~ N-1) 이니까
                for (int j = 1; j < N - 1; j++) {
                    if (!visited[i][j] && visitCheck(i, j)) {
                        int cost = visitAndGetPrice(i, j);
                        dfs(depth+1, sum+cost);
                        //백트래킹
                        visitClear(i,j);
                    }
                }
            }
        }



    }

    private static boolean visitCheck(int i, int j) {     // 방문 가능한지 체크
        for (int k = 0; k < 4; k++) {
            int now_x = i + dx[k];
            int now_y = j + dy[k];
            if (visited[now_x][now_y]) {    // 방문 헀으면
                return false;
            }
        }
        return true;    //4방향 모두다 방문 가능하면
    }
    private static int visitAndGetPrice(int i, int j) { // 방문처리와 5칸 땅값 반환 
        int result = A[i][j];
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int now_x = i + dx[k];
            int now_y = j + dy[k];
            result += A[now_x][now_y];
            visited[now_x][now_y] = true;
        }
        return result;
    }

    private static void visitClear(int i, int j) {      // 방문처리 초기화
        visited[i][j] = false;
        for (int k = 0; k < 4; k++) {
            int now_x = i + dx[k];
            int now_y = j + dy[k];
            visited[now_x][now_y] = false;
        }
    }
}
