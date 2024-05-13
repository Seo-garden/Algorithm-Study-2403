package Baekjoon.실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num11723_집합 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int S = 0;
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            String caseStr = st.nextToken();
            int X;
            switch (caseStr){
                case "add":
                    X = Integer.parseInt(st.nextToken());
                    S |=(1<<X);
                    break;
                case "remove":
                    X = Integer.parseInt(st.nextToken());
                    S &= ~(1<<X);
                    break;
                case "check":
                    X = Integer.parseInt(st.nextToken());
                    if ((S & (1<<X)) != 0){
                        sb.append(1).append('\n');
                    }else{
                        sb.append(0).append('\n');
                    }
                    break;
                case "toggle":
                    X = Integer.parseInt(st.nextToken());
                    S ^= (1<<X);
                    break;
                case "all":
                    S = 0;
                    S = (1<<21) -1;
                    break;
                case "empty":
                    S = 0;
                    break;
            }
        }
        System.out.println(sb);
    }
    
}
