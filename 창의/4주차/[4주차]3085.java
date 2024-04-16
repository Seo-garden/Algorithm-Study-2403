import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static char[][] A;
    static int answer = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine())+1;
        A = new char[N][N];

        for(int i=1; i<N; i++){
            String value = br.readLine();
            for(int j=1;j<N; j++){
                A[i][j] = value.charAt(j-1);
            }
        }

        for(int i=1; i<N; i++){
            for(int j=1; j<N; j++){
                if(j < N-1) {
                    swap(i, j, i, j + 1);
                    checkCol(j);
                    checkCol(j+1);
                    checkRow(i);
                    swap(i, j, i, j + 1);
                }
                // 아래랑 교환
                if(i < N-1){
                    swap(i, j, i+1, j);
                    checkCol(j);
                    checkRow(i+1);
                    checkRow(i);
                    swap(i, j, i+1, j);
                }
            }
        }
        System.out.println(answer);
    }

    // 세로
    static public void checkCol(int col){
        int max = 1;
        int current = 1;
        char value = A[1][col];
        for(int i=2; i<N; i++){
            if(value != A[i][col]){
                current = 1;
                value = A[i][col];
            }else{
                current++;
                max = Math.max(max, current);
            }
        }
        answer = Math.max(answer, max);
    }
    // 가로
    static public void checkRow(int row){
        int max = 1;
        int current = 1;
        char value = A[row][1];
        for(int i=2; i<N; i++){
            if(value != A[row][i]){
                current = 1;
                value = A[row][i];
            }else{
                current++;
                max = Math.max(max, current);
            }
        }
        answer = Math.max(answer, max);
    }

    static public void swap(int x, int y, int x2, int y2){
        char temp = A[x][y];
        A[x][y] = A[x2][y2];
        A[x2][y2] = temp;
    }
}