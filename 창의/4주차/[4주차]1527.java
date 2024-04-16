import java.util.*;
import java.io.*;

public class Main {
    static String[] value = {"4" , "7"};
    static int min;
    static int max;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        min = Integer.parseInt(st.nextToken());
        max = Integer.parseInt(st.nextToken());

        DFS("0");
        System.out.println(answer);
    }

    public static void DFS(String now){
        if(Long.parseLong(now) > max) return;

        for(int i=0; i<2; i++){
            long target = Long.parseLong(now + value[i]);
            if(target >= min && target <= max){
                answer++;
            }
            DFS(now + value[i]);
        }

    }

}