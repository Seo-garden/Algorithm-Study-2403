import java.io.*;

class Main {
    static int[][] A;
    static int N;
    static int min = Integer.MAX_VALUE;
    static boolean[] V;
    static int INF = 1_000_001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine())+1;
        V = new boolean[N];
        A = new int[N][N];

        for(int i=1; i<N; i++){
            String[] value = br.readLine().split(" ");
            for(int j=1; j<N; j++) {
                A[i][j] = Integer.parseInt(value[j-1].equals("0") ? INF+"" : value[j-1]);
            }
        }
        for(int i=1; i<N; i++){
            V[i] = true;
            DFS(1, 0, i, i);
            V[i] = false;
        }
        System.out.println(min);

    }

    public static void DFS(int depth, int value,int start, int now){
        if(value > min) return;
        if(depth == N-1){
            DFS(depth+1, value + A[now][start], start, start);
        }

        if(depth == N && start == now){
            min = value;
        }else{
            for(int i=1; i<N; i++){
                if(!V[i]){
                    V[i] = true;
                    DFS(depth+1, value+A[now][i], start, i);
                    V[i] = false;
                }
            }
        }


    }

}