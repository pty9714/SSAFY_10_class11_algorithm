import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 11748KB, 84ms
public class B1461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer> negative = new ArrayList<>();
        List<Integer> positive = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        int max = 0, far = 0, ans = 0;
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if(max < Math.abs(temp)) {
                max = Math.abs(temp);
                far = temp;
            }
            if(temp > 0) positive.add(temp);
            else negative.add(temp);
        }
        Collections.sort(negative);
        Collections.sort(positive, Collections.reverseOrder());
        while(!negative.isEmpty()) {
            int temp = negative.remove(0);
            for (int i = 1; i < M; i++) {
                if(!negative.isEmpty()) negative.remove(0);
            }
            if(far == temp) ans -= temp;
            else ans -= (temp) * 2;
        }
        while(!positive.isEmpty()) {
            int temp = positive.remove(0);
            for (int i = 1; i < M; i++) {
                if(!positive.isEmpty()) positive.remove(0);
            }
            if(far == temp) ans += temp;
            else ans += temp * 2;
        }
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
