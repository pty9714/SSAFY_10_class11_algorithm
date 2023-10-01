import java.io.*;
import java.util.StringTokenizer;

public class giryun {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] T = new int[N];
        int[] P = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int[] dp = new int[N+1];
        for (int i = N-1; i >= 0; i--) {
            int day = i + T[i];
            if (day <= N) {
                dp[i] = Math.max(P[i] + dp[day], answer);
                answer = dp[i];
            } else {
                dp[i] = answer;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
// 11648	76
