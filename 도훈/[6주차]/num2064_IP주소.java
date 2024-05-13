package Baekjoon.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num2064_IP주소 {
    static int N, MAX;
    static int[] S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        S = new int[N];

        for (int i = 0; i < N; i++) {       //숫자 . 기준으로 짤라서 8비트씩 삽입
            st = new StringTokenizer(br.readLine(), ".");
            int ip = 0;
            for (int j = 0; j < 4; j++) {
                int part = Integer.parseInt(st.nextToken());
                ip |= part << (8 * (3 - j)); // 8비트씩 옆으로 이동
            }
            S[i] = ip;
        }

        //공통부분  구하기
        long commonPart = -1;
        for (int ip : S) {
            commonPart &= ip;
        }


        long submask = createSubnetMask(commonPart);
        String subnetmask = intToIp(submask);
        int change = (-1 << MAX);
        commonPart &= change;                   //MAX 길이 만큼 0으로 변경

        //이 과정을 하는 이유
        //2
        //0.85.160.177
        //255.85.160.177 -> 이렇게 입력했을 때 예외 발생
        if ((commonPart & submask) == commonPart) {
            String ip = intToIp(commonPart);
            System.out.println(ip);
            System.out.println(subnetmask);
        } else {
            commonPart = 0;         //MAX 가 32 이면 첫번째 부터 다름 즉, 0
            String ip = intToIp(commonPart);
            System.out.println(ip);
            System.out.println(subnetmask);
        }


    }

    // int 형식의 IP 주소를 문자열로 변환하는 메소드
    private static String intToIp(long ip) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append((ip >> (8 * (3 - i))) & 255);
            if (i < 3) {
                sb.append('.');
            }
        }
        return sb.toString();
    }

    // 공통되지 않는 부분을 0으로 만들어 서브넷 마스크 생성하는 메소드
    private static long createSubnetMask(long commonPart) {
        long mask = -1;
        MAX = 0;
        for (int j = 0; j < N; j++) {
            for (int i = 0; i <= 31; i++) {
                if (((commonPart >> i) & 1) != ((S[j] >> i) & 1)) {  //공통 부분 , 원본부분 에서 1자리씩 꺼내서 비교해서 다르면?
                    MAX = Math.max(MAX, i + 1);             //다른 부분의 위치의 2^0~ 2^31 즉, (0~31)중 최대값
                    // i+1 인 이유는 0칸을 밀수는 없으니까
                }
            }
        }
        mask <<= (MAX);
        return mask;
    }

}
