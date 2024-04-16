import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Main {
    static int N;
    static int M;
    static int[] A;
    static boolean[] V;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<String> value = new ArrayList<>();
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine() ," ");

       N = Integer.parseInt(st.nextToken())+1;
       M = Integer.parseInt(st.nextToken());
       A = new int[N];
       V = new boolean[N];

       st = new StringTokenizer(br.readLine() , " ");
       for(int i=1; i<N; i++){
           A[i] = Integer.parseInt(st.nextToken());
       }

       Arrays.sort(A);
       DFS(0, "");
       value = (ArrayList<String>) value.stream().distinct().collect(Collectors.toList());
       for(String x : value){
           sb.append(x.substring(1)).append("\n");
       }
       System.out.println(sb);
    }

    public static void DFS(int depth, String num){
        if(depth == M){
            value.add(num);
            return;
        }

        for(int i=1; i<N; i++){
            if(!V[i]){
                V[i] = true;
                DFS(depth+1, num +" "+ A[i]);
                V[i] = false;
            }
        }
    }

}