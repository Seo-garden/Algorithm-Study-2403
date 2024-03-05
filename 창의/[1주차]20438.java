import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static int[] A;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken())+3;
        int K = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        A = new int[N];
        for(int i=3; i<N; i++){
            A[i] = 0;
        }

        // 졸고 있는 사람 -1로 체크
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<K; i++){
            A[Integer.parseInt(st.nextToken())] = -1;
        }

        // 출석 요청을 받은 사람
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<Q; i++){
            check(Integer.parseInt(st.nextToken()));
        }

        // 구간합 계산
        int[] value = new int[N];
        for(int i=3; i<N; i++){
            // 이전까지의 구간합  + A[i]가 -1이거나 0이라면 출석이 안된 것이므로 1을 더한다.
            value[i] = value[i-1] + (A[i] != 1 ? 1 : 0);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            // 구간합  3 ~ 10까지의 구간 합은 value[10] - value[2]
            sb.append(value[end] - value[start-1]).append("\n");
        }
        // 출력
        System.out.println(sb);

    }

    public static void check(int a){
        // 졸고 있는 사람이 출석 요청을 받으면 다른 사람에 전달 X
        if(A[a] == -1 ) return;

        int count = 2;
        for(int i=a; i<N; i = a * count++){
            // 출석을 받은 사람은 자신의 배수만큼 다른 사람에게 출석 요청
            if(A[i] == 0) {
                A[i] = 1;
                check(i);
            }
        }
    }



}