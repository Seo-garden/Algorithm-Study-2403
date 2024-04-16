package Baekjoon.실버;

import java.io.*;
import java.util.*;

public class num15663_N과M_9 {
    static int N, M;
    static ArrayList<Integer> arr, A;
    static boolean[] visited;
    static StringBuilder sb;
    static LinkedHashSet<String> Set;     //중복제거부분 답지봄

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        arr = new ArrayList<>();    //N개의 수가 담긴 배열
        A = new ArrayList<>();     // 중복이 있는 탐색한 값
        visited = new boolean[N];
        Set = new LinkedHashSet<>();  //중복이 제거된 값

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(arr);    // 정렬한 상태로 탐색
        DFS(0);
        Set.forEach(System.out::print);

    }

    static void DFS(int depth) {
        if (depth == M) {
            sb = new StringBuilder();    //각각의 만족하는 depth 마다 새로운 sb
            for (int i : A) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            Set.add(sb.toString());   // 넣을때 String타입으로 삽입
            //(int형이면 이차원배열 내부에 값을 비교할 수 없음으로)
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                A.add(arr.get(i));
                DFS(depth + 1);
                visited[i] = false;
                A.remove(depth);
            }
        }

    }

}
