package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class num1527_금민수의개수 {

    static long a;
    static long b;
    static int[] dx = {4, 7};
    static ArrayList<Long> A;
    public static void main(String[] args) throws IOException {


        // 금민수 = 4와 7로만 이루어진 수 ->
        // a 와 b 가 주어졌을때, a<= 금민수 <=b 금민수인것의 개수

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        A = new ArrayList<>();

        DFS(4);
        DFS(7);
        Collections.sort(A);        //찾은 금민수를 정렬
        int count = 0;
        for (long kms : A) {
            if (kms>=a){            //a 보다 크거나 같을때 민수 count++
                count++;
            }
        }
        System.out.println(count);



    }

    static void DFS(long kms) {
        if (kms>b){         //민슈가 b보가 크면 return
            return;
        }
        A.add(kms);         //금민수가 될수 있음으로 추가
        for (int i = 0; i < 2; i++) {
            long kmsNext = kms*10+dx[i];    // 다음 금민수 생성하고 탐색
            DFS(kmsNext);
        }


    }









}
