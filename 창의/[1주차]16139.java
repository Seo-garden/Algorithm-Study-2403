import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

				// target String
       String target = br.readLine();
       int N = Integer.parseInt(br.readLine());

			 // 누적합을 [target String range][알파벳]
       int[][] A = new int[target.length()+1][26];

       for(int i=0; i<target.length(); i++){
		       // target String, 0 ~ 
           int T = target.charAt(i) - 'a';
           for(int j= 0; j<A[i].length; j++){
		           // 합배열
               A[i+1][j] = A[i][j] + (T == j ? 1 : 0);
           }
       }


       StringBuilder sb = new StringBuilder();
       StringTokenizer st;
       for(int i=0; i<N; i++){
           st = new StringTokenizer(br.readLine() , " ");
	         // 
           int T = st.nextToken().charAt(0) - 'a';
           int x = Integer.parseInt(st.nextToken())+1;
           int y = Integer.parseInt(st.nextToken())+1;
					// x ~ y 구간 합 -> A[y] - A[x-1] (x ~ y구간합)[T]
           sb.append(A[y][T] - A[x-1][T]).append("\n");
       }
        System.out.println(sb);
    }

}