package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class num2667_단지번호붙이기 {

    static int[][] A;
    static boolean[][] visited;
    static int N;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();

        A = new int[N + 1][N + 1];  //1 부터 시작
        visited = new boolean[N + 1][N + 1];


        for (int i = 1; i < N + 1; i++) {
            String st = br.readLine();
            for (int j = 1; j < N + 1; j++) {
                A[i][j] = Integer.parseInt(st.substring(j - 1, j));
            }
        }

        int home = 0;
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (!visited[i][j] && A[i][j] > 0) {
                    count = 1;
                    DFS(i, j);
                    arr.add(count);
                    home++;
                }

            }
        }
        Collections.sort(arr);
        System.out.println(home);
        for (int i : arr) {
            System.out.println(i);
        }
    }


    private static void DFS(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int now_x = x + dx[i];
            int now_y = y + dy[i];

            if (now_x > 0 && now_y > 0 && now_x <= N && now_y <= N) {
                if (!visited[now_x][now_y] && A[now_x][now_y] > 0) {
                    count++;
                    DFS(now_x, now_y);
                }
            }


        }

    }


}
