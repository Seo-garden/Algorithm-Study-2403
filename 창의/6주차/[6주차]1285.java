import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[] coin;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        coin = new int[N];
        for(int i=0; i<N; i++){
            char[] value = br.readLine().toCharArray();
            for(int j=0; j<value.length; j++){
                if(value[j] == 'T')
                    coin[i] |= (1 << j);
            }
        }

        for(int i=0; i< (1 << N); i++){
            int value = 0;
            for(int y=0; y<N; y++){
                int count = 0;
                for(int x=0; x<N; x++){
                    int now = (coin[x] & (1 << y)) == (1 << y) ? 1 : 0;
                    if(((i & ( 1 << x) )!= ( 1 << x))) now ^= 1;
                    count += now;
                }
                value += Math.min(count, N-count);
            }
            min = Math.min(min, value);
        }
        System.out.println(min);
    }

}