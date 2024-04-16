import java.io.*;
import java.util.StringTokenizer;

class Main {
    static boolean[] V;
    static int N;
    static int S;
    static int answer= 0;
    static int[] D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        N = Integer.parseInt(st.nextToken())+1;
        S = Integer.parseInt(st.nextToken());
        V = new boolean[N];

        st = new StringTokenizer(br.readLine(), " ");
        D = new int[N];
        for(int i=1; i<N; i++){
            D[i] = Integer.parseInt(st.nextToken());
        }
        DFS(0, 0, 1);
        System.out.println(answer);

    }
    public static void DFS(int depth, int num, int now){
        if(depth > N-1) return;
        if(num == S && depth > 0) answer++;

        for(int i=now; i<N; i++){
            if(!V[i]) {
                V[i] = true;
                DFS(depth + 1, num + D[i], i);
                V[i] = false;
            }
        }

    }

}