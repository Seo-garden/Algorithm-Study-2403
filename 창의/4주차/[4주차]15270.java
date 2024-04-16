import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    static ArrayList<Friend> A;
    static boolean[] V;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");

        int N =Integer.parseInt(st.nextToken())+1;
        int M = Integer.parseInt(st.nextToken());

        A = new ArrayList<>();
        V = new boolean[N];


        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine() , " " );
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            A.add(new Friend(a, b));
        }
        for(int i=0; i<A.size(); i++){
            DFS(i, 2);
        }

        System.out.println( count % 2 == 0&& count != N-1 ? count+1 : count);



    }


    public static void DFS(int i, int value){
        Friend x = A.get(i);
        if(x.isChecked()) return;
        if(value > count) count = value;

        for(int j=i; j<A.size(); j++){
            x.check();
            DFS(j, value+2);
            x.check();
        }
    }
    static class Friend{
        int x;
        int y;
        public Friend(int x, int y){
            this.x = x;
            this.y = y;
        }

        public void check(){
            V[this.x] = !V[this.x];
            V[this.y] = !V[this.y];
        }

        public boolean isChecked(){
            return V[this.x] || V[this.y];
        }
    }
}