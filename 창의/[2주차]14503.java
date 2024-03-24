import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static int[][] A;
    static int count = 0;
    // 0 북쪽, 1 동쪽, 2 남쪽, 3 서쪽
    static int[] xValue = {-1, 0, 1, 0};
    static int[] yValue = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        A = new int[N][M];

        st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        // 0 북쪽, 1 동쪽, 2 남쪽, 3 서쪽
        int d = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        BFS(new Coordinate(a, b, d));
        System.out.println(count);


    }

    public static void BFS(Coordinate start){
        if(A[start.x][start.y] == 1) return;
        Queue<Coordinate> q = new LinkedList<>();

        count++;
        A[start.x][start.y] = 2;
        q.add(start);
        while (!q.isEmpty()){
            Coordinate now = q.poll();
            int c = 0;
            for(int i=0; i<4; i++){
                int a = now.x + xValue[i];
                int b = now.y + yValue[i];
                if(A[a][b] == 0){
                    c++;
                    now.rotateDirection();
                    break;
                }
            }
            // 주변에 청소할 곳이 없는 경우
            if(c == 0){
                int back = A[now.x + xValue[now.backDirection()]][now.y + yValue[now.backDirection()]];
                // 뒤가 벽이 아니라면 (2 또는 0)
                if(back % 2 == 0){
                    // 뒤로 이동
                    q.add(new Coordinate(now.x + xValue[now.backDirection()],now.y+ yValue[now.backDirection()], now.d));
                    continue;
                    // 뒤가 벽이라면 (1)
                }else{
                    return;
                }
            }
            // 주변에 청소할 곳이 있는 경우 (청소기가 바라보는 방향 앞의 구역이 청소 가능한 구역인 경우)
            if(A[now.x + xValue[now.d]][now.y + yValue[now.d]] == 0){
                A[now.x + xValue[now.d]][now.y + yValue[now.d]] = 2;
                count++;
                q.add(new Coordinate(now.x + xValue[now.d], now.y + yValue[now.d], now.d));
                continue;
            }
            // 주변에 청소할 곳이 있지만 청소기가 바라보는 방향이 아닌 경우
            q.add(now);
        }

    }

    static class Coordinate{
        int x;
        int y;
        int d;
        public Coordinate(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }

        public void rotateDirection(){
            this.d = (this.d + 3) % 4;
        }

        public int backDirection(){
            return (this.d +2) % 4;
        }
    }
}