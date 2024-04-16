import java.io.*;
import java.util.StringTokenizer;

class Main {
    static StringBuilder sb =new StringBuilder();
    static boolean[] V;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");

        N = Integer.parseInt(st.nextToken())+1;
        M = Integer.parseInt(st.nextToken());

        V = new boolean[N];

        DFS(0, "");
        System.out.println(sb);
    }

    public static void DFS(int depth, String value){
        if(depth == M){
            sb.append(value.substring(1)).append("\n");
            return;
        }

        for(int i=1; i<N; i++){
            if(!V[i]) {
                V[i] = true;
                DFS(depth + 1, value + " " + i);
                V[i] = false;
            }
        }

    }

}