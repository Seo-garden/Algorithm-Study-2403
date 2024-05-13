package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num14503_로봇청소기 {
    static int y,x,count;

    static int[][] A;

    static int[] dx = {0, 1, 0, -1}; //0 = 북쪽, 1 = 동쪽, 2 = 남쪽 3 = 서쪽
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {

        /* 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸 청소
         * 2. 현재 칸의 주변 4칸 중 청소 되지 않은 빈 칸이 없는 경우,
         *      1. 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
         *      2. 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
         * 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
         *      1. 반시계 방향으로 90도 회전
         *      2. 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        
        A = new int[y][x];


        st = new StringTokenizer(br.readLine());
        int robot_y = Integer.parseInt(st.nextToken());
        int robot_x = Integer.parseInt(st.nextToken()); 
        int robot_dir = Integer.parseInt(st.nextToken());

        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        count = 1;                      // 로봇 청소기가 있는 칸은 항상 빈칸임으로 +1


        DFS(robot_y, robot_x, robot_dir);
        System.out.println(count);


    }

    //0 = 북쪽, 1 = 동쪽, 2 = 남쪽 3 = 서쪽
    private static void DFS(int robot_y, int robot_x, int robot_dir) {
        // 현재 위치 청소
        A[robot_y][robot_x] = -1;    // 청소하면 -1로

        // 현재 위치에서 현재 방향을 기준으로 왼쪽 방향부터 차례대로 탐색 진행 
        for (int i = 0; i < 4; i++) {
            //이걸 생각 못함 -> 왼쪽 방향으로 변환 (북 -> 서 -> 남 -> 동)
            robot_dir = (robot_dir + 3) % 4;    // 이렇게 하면 현재 방향기준에서 왼쪽방향부터 순서대로 탐색가능
            int now_y = robot_y + dy[robot_dir];
            int now_x = robot_x + dx[robot_dir];

            // 청소가 안된 곳이 있으면 count++, DFS
            if (now_x >= 0 && now_y >= 0 && now_x < x && now_y < y && A[now_y][now_x] == 0) {//갈 수있는 곳 있다면
                count++;
                DFS(now_y, now_x, robot_dir);
                return; // 요기서 return 을 안하면 재귀함수가 풀리는 도중에 다른곳으로가서 청소할 수가 있음.
            }
            
        }
        
        //후진 할 수 있으면 뒤로 한칸 후진 방향유지
        // 위에서 실행문이 안끝나고 밑으로 왔다는 것은 네방형이 모두 청소가 되었거나 벽인 경우
        int back_dir = (robot_dir + 2) % 4; //반대 방향
        int back_y = robot_y + dy[back_dir];
        int back_x = robot_x + dx[back_dir];

        if (back_x >= 0 && back_y >= 0 && back_x < x && back_y < y && A[back_y][back_x] != 1) {
            DFS(back_y, back_x, robot_dir); // 방향을 유지한체 뒤로 한 칸
        }

        // 후진 못하면 종료
    }


}
