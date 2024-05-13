package Baekjoon.실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num15889_호안에수류탄이야 {


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        
        int N= Integer.parseInt(br.readLine());     // 욱제를 포함한 전우들의 인원 수 N
        int[]A = new int[N];
        int[]length = new int[N-1];
        boolean Reach = true;               //수류탄이 닿을 수 있는지  
        st = new StringTokenizer(br.readLine());    // 1명이라도 2번째 줄까지는 입력함.

        
        if (N == 1){            //1명일때는 수류탄 안던짐 
            sb.append("권병장님, 중대장님이 찾으십니다");
        }else{

            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());        //욱제를 포함한 N명의 좌표 저장
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N-1; i++) {
                length[i] = Integer.parseInt(st.nextToken());   //마지막 전우를 제외한 전우들의 사거리저장
            }
            
            long max = 0;
            for (int i = 0; i < N-1; i++) {
                
                max = Math.max(max, A[i]+length[i]);    //각 위치에서 던질수 있는 값들중 최대값저장

                if(max < A[i+1]){                       //현재까지의 던질수 있는 최대값이 다음 사람보다 짧다면
                    Reach = false;            //안 닿음
                }
            }

            if (Reach){         
                sb.append("권병장님, 중대장님이 찾으십니다");
            }else{
                sb.append("엄마 나 전역 늦어질 것 같아");
            }
            
        }
        

        System.out.println(sb);


    }

}
