package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class num3085_사탕게임{
    static char[][] A;       //원본 인접 행렬
    static int N;
    static int Max = Integer.MIN_VALUE;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new char[N][N];
        for (int i = 0; i < N; i++) {
            String lines = br.readLine();
            for (int j = 0; j < N; j++) {
                A[i][j] = lines.charAt(j);
            }
        }

        // 2차원 배열은 깊은복사가 안됨으로 따로 swap Method 구현
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 4; k++) {
                    int now_x = i + dx[k];
                    int now_y = j + dy[k];
                    if (now_x > -1 && now_y > -1 && now_x < N && now_y < N) {
                        Swap(i,j,now_x,now_y);
                        Search();
                        Swap(now_x,now_y,i,j);
                    }
                }
            }
        }

        System.out.println(Max);
    }

    static void Swap(int x1, int y1, int x2, int y2) {
        char temp = A[x1][y1];
        A[x1][y1] = A[x2][y2];
        A[x2][y2] = temp;

    }

    static void Search() {
        //가로 줄 전체 검사
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 0; j < N - 1; j++) {
                if (A[i][j] == A[i][j + 1]) {
                    count++;
                } else {       //만약 같이않은 곳을 만나면 초기화
                    count = 1;
                }
                Max = Math.max(Max, count);
            }
        }
        //세로
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 0; j < N - 1; j++) {
                if (A[j][i] == A[j + 1][i]) {
                    count++;
                } else {
                    count = 1;
                }
                Max = Math.max(Max, count);
            }
        }
    }


}
