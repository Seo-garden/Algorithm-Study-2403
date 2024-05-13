package Baekjoon.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class num1038_감소하는수 {    // 못풀어서 답지봄
    /**
     * 음이 아닌 정수 X의 자릿수가 가장 큰 자릿수부터 작은 자릿수까지 감소한다면,
     * 그 수를 감소하는 수라고 한다.
     * 예를 들어, 321과 950은 감소하는 수지만, 322와 958은 아니다.
     * N번째 감소하는 수를 출력하는 프로그램을 작성하시오.
     * 0은 0번째 감소하는 수이고, 1은 1번째 감소하는 수이다.
     * 만약 N번째 감소하는 수가 없다면 -1을 출력한다.
     * 첫째 줄에 N이 주어진다. N <= 1,000,000
     */
    static ArrayList<Long> arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        if (N <= 10) sb.append(N);    //10보다 작거나 같으면 해당 숫자가 위치 index
        else if(N > 1022) sb.append("-1");
        else{
            for (int i = 0; i < 10; i++) {  // 0~9 까지 해당 숫자에서 감소할 수 있는 수 계속 찾기 총 1022개(0포함)
                DFS(i, 1);
            }
            Collections.sort(arr);      //다 구한 감소하는 수를 정렬
            sb.append(arr.get(N));      //index 로 N번째 감소하는 수 get
        }
        System.out.println(sb);     //출력 시간복잡도 O(n)
    }
    private static void DFS(long num, int depth) {  //이렇게 돌게 되면 모든 감소하는 수를 다 구하게됨
        if (depth > 10) return;

        arr.add(num);
        for (int i = 0; i < num % 10; i++) {    // 들어온 수의 마지막 자리수 보다 항상 작은 값을 맨뒤에 붙여서 다음 depth 로 이동
            DFS((num * 10) + i, depth + 1);
        }

    }

}
