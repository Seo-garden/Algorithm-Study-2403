import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine(), " ");

       int N = Integer.parseInt(st.nextToken());
       int M = Integer.parseInt(st.nextToken());

			
       long[] A = new long[N+1];
       st = new StringTokenizer(br.readLine(), " ");
       // 합배열 (0 ~ N % M)
       for(int i=1; i<N+1; i++){
           A[i] = A[i-1] + (Integer.parseInt(st.nextToken()) % M) ;
       }

       long answer = 0;
       long[] D = new long[M];
       for(int i=1; i<N+1; i++){
           int x = (int) (A[i] % M);
           D[x]++;
       }

       for(int i=0; i<M; i++){
           answer = answer + (D[i] * (D[i]-1)) / 2;
       }
       System.out.println(answer + D[0]);
    }
}