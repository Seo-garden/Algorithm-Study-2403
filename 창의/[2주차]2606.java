import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {

    static ArrayList<Integer>[] A;
    static boolean[] V;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine())+1;
        int M = Integer.parseInt(br.readLine());

        A = new ArrayList[N];
        V = new boolean[N];
        for(int i=1; i<N; i++){
            A[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A[a].add(b);
            A[b].add(a);
        }
        DFS(1);
        System.out.println(answer);

    }

    public static void DFS(int a){
        V[a] = true;
        for(int x : A[a]){
            if(!V[x]){
                DFS(x);
                answer++;
            }
        }
    }

}