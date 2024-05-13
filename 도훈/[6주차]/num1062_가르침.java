package Baekjoon.골드;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num1062_가르침 {


    static int max,N;
    static int[] A;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        max = 0;
        A = new int[N+1];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                A[i] |= (1<<(str.charAt(j)-97));   //원본
            }
        }
        
        //antic
        int visit = 0;
        String origin = "antic";
        for (int i = 0; i < origin.length(); i++) {
            visit |= (1<<(origin.charAt(i)-97));
        }
        //dfs 돌면서 depth 가 K-5일때 return
        DFS(0,K-5,0,visit);
        
        System.out.println(max);

    }

    private static void DFS(int depth, int length, int start,int visit){
        if (depth == length) {
            int count =0;
            for (int i = 0; i<N; i++){
                if ((A[i] & visit) == A[i]) {    //읽을 수 있다면
                    count++;
                }
            }
            max = Math.max(max,count);
            return;
        }

        for (int i = start; i < 26; i++) {
            // 이미 가르쳤거나 , 가르칠 수 없는 알파벳은 스킵(기본 antic)
            if ((visit&(1 << i) ) != 0) {    // ->  visit 알파벳의 위치에 존재한다면
                continue;
            }

            DFS(depth + 1, length, i + 1, visit | (1 << i));
            // visit | (1<<i) -> 알파벳 하나 배움
        }

    }

}