import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        long[] ip = new long[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), ".");
            long value = 0;
            for(int j=0; j<4; j++){
                value <<= 8;
                value = (value) | Integer.parseInt(st.nextToken());
            }
            ip[i] = value;
        }


        long total = ip[0];
        for(int i=1; i<ip.length; i++){
            total &= ip[i];
        }

        long max = 0;
        for(int i=0; i<ip.length; i++){
            max = Math.max(max, ip[i] - total);
        }

        boolean flag = true;
        int count = 0;
        while (max > 1){
            max >>= 1;
            count++;
        }
        if(max == 0) flag = false;
        long subnetMask = (1 << 31) + ((1 << 31) -1);
        for(int i=count; i>= 0 && flag; i--){
            subnetMask &= ~(1 << i);
        }
        StringBuilder ipAddress = new StringBuilder();
        StringBuilder subnet = new StringBuilder();
        long min = ip[0] & subnetMask;

        long t = (1 << 9) - 1;
        for(int i=0; i<4; i++){
            ipAddress.insert(0, "."+(min & t >> 1));
            min >>= 8;

        }
        for(int i=0; i<4; i++){
            subnet.insert(0, "."+ (subnetMask & t >> 1));
            subnetMask >>= 8;
        }

        System.out.println(ipAddress.substring(1, ipAddress.length()));
        System.out.println(subnet.substring(1, subnet.length()));




    }

    static void printBinary(long num) {
        System.out.println();
        for (int i = 31; i >= 0; i--) {
            if( (31- i) % 8 == 0 && i != 31) System.out.print(".");
            System.out.print((num & (1 << i)) != 0 ? "1" : "0");
        }
    }
}