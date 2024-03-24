import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static int[][] A;
    static boolean[][] V;
    static LinkedList<Integer> l;
    static int[] xValue = {0, 1, -1, 0};
    static int[] yValue = {1, 0, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine())+2;
        A = new int[N][N];
        V = new boolean[N][N];
        l = new LinkedList<>();
        N -= 1;
        for(int i=1; i<N; i++){
            String value = br.readLine();
            for(int j=1; j<N; j++){
                A[i][j] = Integer.parseInt(value.charAt(j-1)+"");
            }
        }
        for(int i=1; i<N; i++){
            for(int j=1; j<N; j++){
                BFS(new Node(i, j));
            }
        }

        StringBuilder sb = new StringBuilder();
        Collections.sort(l);
        sb.append(l.size()).append("\n");
        for(int i=0; i<l.size(); i++){
            sb.append(l.get(i)).append("\n");
        }
        System.out.println(sb);

    }

    public static void BFS(Node x){
        if(A[x.x][x.y] == 0 || V[x.x][x.y]) return ;
        Queue<Node> q = new LinkedList<>();

        int count = 1;
        q.add(x);
        V[x.x][x.y] = true;
        while (!q.isEmpty()){
            Node now = q.poll();
            for(int i=0; i<4; i++){
                int a = now.x + xValue[i];
                int b = now.y + yValue[i];
                if(A[a][b] == 1 && !V[a][b]){
                    count++;
                    V[a][b] = true;
                    q.add(new Node(a, b));
                }
            }
        }
        l.add(count);
    }

    static class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}