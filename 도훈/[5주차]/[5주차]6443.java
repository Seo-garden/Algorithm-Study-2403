package Baekjoon.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class num6443_애너그램{
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            char[] chars = word.toCharArray();
            Arrays.sort(chars); // 문자열을 정렬하여 애너그램을 만듦
            word = new String(chars); // 정렬된 문자열로 갱신
            boolean[] visited = new boolean[word.length()]; // 방문 여부를 나타내는 배열
            DFS(word, new StringBuilder(), visited);
        }

        System.out.print(sb);
    }

    static void DFS(String word, StringBuilder current, boolean[] visited) {
        if (current.length() == word.length()) { // 현재 문자열의 길이가 원래 문자열의 길이와 같다면
            sb.append(current).append('\n'); // 결과에 추가
            return;
        }

        for (int i = 0; i < word.length(); i++) {
            if (!visited[i]) {
                visited[i] = true; // 해당 문자를 방문했다고 표시
                current.append(word.charAt(i)); // 현재 문자열에 추가
                DFS(word, current, visited); // 다음 문자열로 재귀 호출
                visited[i] = false; // 이전 상태로 돌아왔으므로 다시 방문하지 않은 상태로 변경
                current.deleteCharAt(current.length() - 1); // 추가한 문자 제거

                // 중복된 문자를 건너뛰기 위한 코드
                while (i < word.length() - 1 && word.charAt(i) == word.charAt(i + 1)) {
                    i++;
                }
            }
        }
    }
}
