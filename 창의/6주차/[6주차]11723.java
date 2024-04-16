import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int set = 0;
        for(int i=0; i<N; i++){
            String[] value = br.readLine().split(" ");

            String operation = value[0];

            switch (operation){
                case "add":
                    int num = Integer.parseInt(value[1]);
                    set |= (1 << num);
                    break;
                case "remove":
                    num = Integer.parseInt(value[1]);
                    set &= ~(1 << num);
                    break;
                case "check":
                    num = Integer.parseInt(value[1]);
                    sb.append( ((set & (1 << num) )== (1 << num)) ? 1 : 0).append("\n");
                    break;
                case "toggle":
                    num = Integer.parseInt(value[1]);
                    set ^= (1 << num);
                    break;
                case "all":
                    set = (1 << 21) - 1;
                    break;
                case "empty":
                    set = 0;
                    break;
            }
        }
        System.out.println(sb);
    }

}