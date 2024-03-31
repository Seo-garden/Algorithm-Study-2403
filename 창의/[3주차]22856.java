import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static ArrayList<Integer>[] A;
    static boolean[] V;
    static int answer = 0;
    static boolean flag = false;
    static int N;
    static int lastInOrder = 1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine())+1;

        V = new boolean[N];
        A = new ArrayList[N];
        for(int i=1; i<N; i++){
            A[i] = new ArrayList<>();
        }
        V[0] = true;

				// 트리 
        StringTokenizer st;
        for(int i=1; i<N; i++){
            st = new StringTokenizer(br.readLine() ," ");
            int now = Integer.parseInt(st.nextToken());
            // 왼쪽
            int a = Integer.parseInt(st.nextToken());
            // 오른쪽
            int b = Integer.parseInt(st.nextToken());
						
						// 현재 값 -> a, b
            A[now].add(a == -1 ? 0 : a);
            A[now].add(b == -1 ? 0 : b);
        }

				// 중위 순회
        inOrder(1);
        // 
        similarityInOrder(1);
        System.out.println(answer);
    }

    static public void similarityInOrder(int now){
        V[now] = true;

        if(A[now].get(0) != 0 && !V[A[now].get(0)]){
            answer++;
            similarityInOrder(A[now].get(0));
        }
        if(A[now].get(1) != 0 && !V[A[now].get(1)]){
            answer++;
            similarityInOrder(A[now].get(1));
        }

        if(lastInOrder == now) flag = true;
        if(flag) return;
        answer++;
    }
    static public void inOrder(int now){


        if(A[now].get(0) != 0){
            inOrder(A[now].get(0));
        }
        lastInOrder = now;
        if(A[now].get(1) != 0){
            inOrder(A[now].get(1));
        }
    }

}