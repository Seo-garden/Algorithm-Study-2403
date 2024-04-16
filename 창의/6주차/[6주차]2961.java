import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Main {
    static int visit;
    static int[][] A;
    static int N;
    static int min = 1_000_000_001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N][2];

        for(int i=0; i<N; i++){
            String[] value = br.readLine().split(" ");

            A[i][0] = Integer.parseInt(value[0]);
            A[i][1] = Integer.parseInt(value[1]);
        }
        DFS(0, 0, 1, 0);
        System.out.println(min);

    }

    public static void DFS(int depth, int now, int value1, int value2){
        if(depth > 0) min = Math.min(min, Math.abs(value1 - value2));

        for(int i=now; i<N; i++){
            if(!((visit & (1 << i)) == (1 << i))){
                visit |= (1 << i);
                DFS(depth+1, i, value1 * A[i][0], value2 + A[i][1]);
                visit &= ~(1 << i);
            }
        }


    }

}