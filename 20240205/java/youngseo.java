import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1790 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int cnt = 0;
        int index = 0;
        int current = 1;
        int next = 10;
        while(k > cnt){
            index++;
            cnt += (next - current) * index;
            current *= 10;
            next *= 10;
        }
        
        current /= 10;
        next /= 10;
        cnt -= (next - current) * index;

        int target = 0;
        for(int i=current; i<n; i++){
            cnt += index;
            if(cnt >= k) {
                target = i;
                break;
            }
        }

        for(int i=0; i<cnt-k; i++){
            target = target/10;
        }

        System.out.println(target % 10);

    }
}

// 1 ~ 9      9-1+1 개 * 1  9
// 10 ~ 99    99-10+1 * 2 180자리
// 100 ~ 999  999 - 100 + 1 * 3 900자리
//
