import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            coin[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[k + 1];
        for (int i = 1; i <= k; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j : coin) {
                if (i >= j && dp[i - j] != -1) {
                    temp.add(dp[i - j]);
                }
            }
            if (temp.size() == 0) {
                dp[i] = -1;
            } else {
                int min = Integer.MAX_VALUE;
                for (int value : temp) {
                    if (value < min) {
                        min = value;
                    }
                }
                dp[i] = min + 1;
            }
        }

        bw.write(String.valueOf(dp[k]));
        bw.flush();
        br.close();
        bw.close();
    }
}
