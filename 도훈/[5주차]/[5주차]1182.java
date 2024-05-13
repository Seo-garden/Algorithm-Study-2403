package Baekjoon.실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num1182_부분수열의합 {
    static int N,S,count;
    static int[] A,arr;
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        A = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }


        count = 0;
        for (int i = 1; i <= N; i++) {
            arr = new int[i];
            DFS(0,1,i);
        }
        System.out.println(count);


    }

    static void DFS(int depth,int now, int afew) {    //afew : 몇 개씩?depth
        if (depth == afew){
            int sum = 0;
            for (int i : arr){
                sum+=i;
            }
            if (sum == S){
                count++;
            }
            return;
        }
        for (int i = now; i <= N; i++) {
            arr[depth] = A[i];
            DFS(depth+1,i+1,afew);

        }



    }


}
