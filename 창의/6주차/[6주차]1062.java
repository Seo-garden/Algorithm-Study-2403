import java.io.*;
import java.util.*;

class Main {
    static int visit = 0;
    static String[] value;
    static int K;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if( K < 5){
            System.out.println(0);
            return;
        }else if(K == 26){
            System.out.println(N);
            return;
        }

//        visit |= (1 << ('a' - 'a'));
//        visit |= (1 << ('n' - 'a'));
//        visit |= (1 << ('t' - 'a'));
//        visit |= (1 << ('c' - 'a'));
//        visit |= (1 << ('i' - 'a'));
        K -= 5;
        value= new String[N];
        for(int i=0; i<N; i++){
            value[i] = br.readLine().replace("a", "").replace("n","").replace("t","")
                    .replace("i","").replace("c","");
            for(int j=0; j<value[i].length(); j++){
                if((visit & (1 << value[i].charAt(j) - 'a')) != (1 << value[i].charAt(j) - 'a'))
                    visit |= (1 << (value[i].charAt(j) - 'a'));
            }
        }
        DFS(0);
        System.out.println(max);
    }

    public static void DFS(int now){
        int read = 0;
        for(int i=0; i<value.length; i++){
            if(value[i].length() == 0){
                read++;
                continue;
            }
            boolean flag = false;
            for(int j=0; j<value[i].length(); j++){
                if((visit & (1 << (value[i].charAt(j) - 'a'))) == (1 << (value[i].charAt(j) - 'a'))){
                    flag = true;
                    break;
                }
            }
            if(!flag) read++;
        }
        max = Math.max(read, max);
        if(K == 0) return;

        for(int i=now; i<26; i++){
            if((visit & (1 << i)) == (1 << i)){
                visit &= ~(1 << i);
                K--;
                DFS(i);
                K++;
                visit |= (1 << i);
            }
        }


    }

}