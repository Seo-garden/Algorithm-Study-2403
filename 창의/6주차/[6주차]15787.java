import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] value = br.readLine().split(" ");

        int N = Integer.parseInt(value[0]);
        int M = Integer.parseInt(value[1]);

        int[] V = new int[N];

        for(int i=0; i<M; i++){
            value = br.readLine().split(" ");

            int operation = Integer.parseInt(value[0]);
            int th = Integer.parseInt(value[1])-1;
            int seat = operation < 3 ? Integer.parseInt(value[2])-1 : 0;

            if(operation == 1){
                V[th] |= (1 << (seat));
            }else if(operation == 2){
                V[th] &= ~(1 << (seat));
            }else if (operation == 3){
                V[th] = (V[th] << 1) & ~(1 << 20);
            }else{
                V[th] = (V[th] >> 1);
            }
        }
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<V.length; i++){
            if(set.contains(V[i])) continue;
            set.add(V[i]);
            count++;
        }

        System.out.println(count);
    }

}