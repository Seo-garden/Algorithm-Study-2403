package Baekjoon.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


import java.util.Comparator;
import java.util.StringTokenizer;

public class num2170_선긋기  {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        ArrayList<xy> arr = new ArrayList<>();

        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr.add(new xy(st));
        }
        
        arr.sort(Comparator.comparing(xy::getX));       //X를 기준으로 정렬 (오름차순) 메소드 참조 사용

        long max = arr.get(0).getY();
        long min = arr.get(0).getX();
        long length = max - min;

        for (int i = 1; i < N; i++) {

            if (arr.get(i).getX() >= min && arr.get(i).getY() <=max ){  //현재 선이 이전 선에 포함된다면
                
                continue;

            }else if (arr.get(i).getX() < max){     //현재 선의 시작점이 이전 선에 곂친다면

                length += arr.get(i).getY() - max;

            }else{      //안 곂친다면

                length += arr.get(i).getY() - arr.get(i).getX();

            }
            max = arr.get(i).getY();
            min = arr.get(i).getX();
        }
        System.out.println(length);

    }




    static class xy{
        private int x;
        private int y;

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
        

        public xy(StringTokenizer st) {         //입력 받은 StringTokenizer 로 인스턴스생성
            this.x = Integer.parseInt(st.nextToken());
            this.y = Integer.parseInt(st.nextToken());
        }

//        @Override
//        public String toString() {
//            return "xy{" +
//                    "x=" + x +
//                    ", y=" + y +
//                    '}';
//        }
    }
}
