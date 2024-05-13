package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class num11725_트리의부모찾기 {

    static ArrayList<Integer>[] A;  //인접 리스트
    static boolean[] visited;
    static int[] parent; // 부모 노드 

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        A = new ArrayList[N + 1];              //노드 번호를 인덱스 번호로 사용
        visited = new boolean[N + 1];
        parent = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }

        DFS(1);

        for (int i = 2; i < parent.length; i++) {
            System.out.println(parent[i]);
        }


    }

    private static void DFS(int idx) {

        visited[idx] = true;
        for (int i : A[idx]) {
            if (!visited[i]) {
                parent[i] = idx;   //탐색할 노드의 부모노드가 현재 노드 -> i 의 부모 노드
                DFS(i);
            }
        }
    }
}

