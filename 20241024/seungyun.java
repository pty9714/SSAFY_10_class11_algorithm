import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B3020 {

    static int N,H;
    static int[] down;
    static int[] up;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        down = new int[N/2];
        up = new int[N/2];

        for(int i = 0; i < N/2; i++){
            int n1 = Integer.parseInt(br.readLine());
            int n2 = Integer.parseInt(br.readLine());
            down[i] = n1;
            up[i] = n2;
        }

        Arrays.sort(down);
        Arrays.sort(up);

        int min = N;
        int start = 0;
        int end = N/2;
        int cnt = 0;

        for(int i = 1; i <= H; i++){
            int sum = 0;
            int d = 0;
            int u = 0;
            // 석순
            while(start < end){
                int mid = (start + end) / 2;

                if(down[mid] >= H){
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }
            d = down.length - end;

            start = 0;
            end = N/2;
            // 종유석
            while(start < end){
                int mid = (start + end) / 2;

                if(up[mid] >= H){
                    end = mid;
                } else{
                    start = mid + 1;
                }
            }
            u = up.length - end;
            sum = d + u;

            if(min == sum){
                cnt++;
                continue;
            }
            if(min > sum){
                min = sum;
                cnt = 1;
            }
        }
        System.out.println(min + " " + cnt);

    }


}
