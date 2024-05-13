package Baekjoon.실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class num2961_도영이가만든맛있는음식 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new
        InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] sb = new int[N][2];     //0 : 신 맛 1 : 쓴 맛
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            sb[i][0] = Integer.parseInt(st.nextToken());
            sb[i][1] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;

        int length = 1<<N;              //부분집합의 개수 2^N

        for (int i = 1; i < length; i++) {      // 부분집합의 개수만큼 반복 단, 공집합 제외 (1부터 시작)
            int S = 1, B = 0;       // 신맛은 곱하기위해 1부터 시작, 쓴맛은 더하기위해 0부터 시작 
            for (int j = 0; j < N; j++) { //i 가 1일때 01 즉 1번만 선택되는 경우 그리고 j가 0 일때만 가능 )
                // 추가)예를 들어 i가 3 이면 011 이니까 1번, 2번 둘다 선택되는 경우 즉, j가 0, 1 둘다 가능 그래서 S*= 2번 B+= 2번
                if ((i & 1<<j) != 0){      
                    S *= sb[j][0];
                    B += sb[j][1];
                }
            }
            int diff = Math.abs(S - B); //구한 S와 B의 차를 구한후 절대값 취함.
            min = Math.min(min, diff);  //현재 최소값과 비교해서 더작은 값 저장 
        }
        
        System.out.println(min);    //최소값 출력

    }

}
