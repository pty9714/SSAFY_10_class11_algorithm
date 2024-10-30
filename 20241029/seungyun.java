import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] cnt = new int[365 + 1];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            for(int j = s; j <= e; j++){
                cnt[j]++;
            }
        }

        int sum = 0;
        int maxH = 0;
        int width = 0;

        for(int i = 0; i <= 365; i++){
            // 끊긴날이면
            if(cnt[i] == 0){
                sum += maxH * width;
                maxH = 0;
                width = 0;
                continue;
            }
            width++;
            maxH = Math.max(maxH, cnt[i]);
        }
        sum += maxH * width;
        System.out.println(sum);

    }
}
