import java.io.*;
import java.util.StringTokenizer;

class Main {

    static boolean[] V;
    static int M;
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");

        N = Integer.parseInt(st.nextToken())+1;
        M = Integer.parseInt(st.nextToken());

        V = new boolean[N];

        DFS(0, "", 1);
        System.out.println(sb);

    }

    static void DFS(int depth, String value, int now){
        if(depth == M){
            sb.append(value.substring(1)).append("\n");
            return;
        }

        for(int i=now; i<N; i++){
            if(!V[i]){
                V[i] = true;
                DFS(depth+1, value + " " + i, i);
                V[i] = false;
            }
        }

    }

}