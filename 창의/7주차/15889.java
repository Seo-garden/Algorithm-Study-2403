import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] coordinate = new int[N];
        StringTokenizer st =new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            coordinate[i] = Integer.parseInt(st.nextToken());
        }

        int[] range = new int[N];
        st = N > 1 ? new StringTokenizer(br.readLine()) : null;
        int line = 0;
        for(int i=0; i<N-1; i++){
            range[i] = Integer.parseInt(st.nextToken());
            if(line >= coordinate[i] && line < coordinate[i] + range[i])
                line = coordinate[i] + range[i];
        }

        if(coordinate[N-1] <= line){
            System.out.println("권병장님, 중대장님이 찾으십니다");
        }else{
            System.out.println("엄마 나 전역 늦어질 것 같아");
        }


    }

}

