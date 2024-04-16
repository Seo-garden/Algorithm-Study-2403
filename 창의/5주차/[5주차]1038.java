import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Main {
    static int N;
    static List<Long> A = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        if(N <= 10){
            System.out.println(N);
            return ;
        }

        for(int i=1; i<10; i++){
            search(i, 1);
        }
        if(A.size() < N){
            System.out.println("-1");
            return;
        }

        Collections.sort(A);
        System.out.println(A.get(N-1));


    }

    public static void search(long value, int th){
        if(th > 10) return ;

        A.add(value);
        for(int i=0; i<value%10; i++){
            search(value*10 + i, th+1);
        }


    }

}