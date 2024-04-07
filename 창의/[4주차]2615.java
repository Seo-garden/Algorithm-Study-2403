import java.io.*;
import java.util.StringTokenizer;

class Main {
    static int[][] A;
    static int answer = 0;
    static int locX = 0;
    static int locY = 0;
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       A = new int[21][21];

       StringTokenizer st;
       for(int i=1; i<A.length-1; i++){
           st = new StringTokenizer(br.readLine(), " ");
           for(int j= 1; j<A.length-1; j++){
               A[i][j] = Integer.parseInt(st.nextToken());
           }
       }

       for(int i=A.length-2; i>=1 && answer == 0; i--){
           for(int j=A.length-2; j>= 1 && answer == 0; j--){
               if(A[i][j] != 0){
                    check(i, j, A[i][j]);
               }
           }
       }
       System.out.println(answer);
       if(answer != 0){
           System.out.println((locX) + " " +( locY));
       }

    }

    public static void check(int i, int j, int current){
        int count = 1;
        // 좌측
        for(int k=j-1; k>= 0 && k >=j-5; k--){
            if(current == A[i][k]){
                count++;
                locX = i;
                locY = k;
            }else {
                break;
            }
        }
        if(count == 5 && A[i][j+1] != current && A[locX][locY-1] != current) {
            answer = current;
            return;
        }
        // 상단
        count = 1;
        for(int k=i-1; k>= 0 && k >= i-5; k--){
            if(current == A[k][j]){
                count++;
                locX = k;
                locY = j;
            }else {
                break;
            }
        }
        if(count == 5 && A[i+1][j] != current && A[locX-1][locY] != current) {

            answer = current;
            return;
        }
        
        // 좌측 상단 대각선
        count = 1;
        int x = i-1; int y = j-1;
        while (x >= 0 && y >= 0 && x >=j-5 && y >=i-5){
            if(current == A[x][y]){
                count++;
                locX = x--;
                locY = y--;
            }else {
                break;
            }
        }
        if(count == 5 && A[i+1][j+1] != current && A[locX-1][locY-1] != current){
            answer = current;
            return;
        }count = 1;

        // 우측 상단 대각선
        x = i-1; y = j+1;
        while (x >= 0 && y < A.length-1 && x >= i-5 && y <= j+5){
            if(A[x][y] == current){
                count++;
                locX = x--;
                locY = y++;
            }else{
                break;
            }
        }
        // 우측 상단의 경우 가장 좌측 돌의 좌표는 시작점이 된다.
        if(count == 5 && A[i+1][j-1] != current && A[locX-1][locY+1] != current){
            locX = i;
            locY = j;
            answer = current;
        }

    }

}