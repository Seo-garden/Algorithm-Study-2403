import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.stream.Collectors;

class Main {
    static boolean[] V;
    static int N;
    static char[] value;
    static StringBuilder sb = new StringBuilder();
    static LinkedList<String> disctinct = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());

        for(int i=0; i<M; i++){
            value = br.readLine().toCharArray();

            Arrays.sort(value);
            N = value.length;
            V = new boolean[N];
            disctinct.clear();
            DFS(0, "");
            for(String answer : disctinct.stream().distinct().collect(Collectors.toList())){
                sb.append(answer).append("\n");
            }
        }
        System.out.println(sb);


    }

    public static void DFS(int depth, String anagram){
        if(depth == N){
            disctinct.add(anagram);
            return ;
        }

        for(int i=0; i<N; i++){

            if(!V[i]){
                V[i] = true;
                DFS(depth+1, anagram + value[i]+" ");
                V[i] = false;
            }
        }




    }

}