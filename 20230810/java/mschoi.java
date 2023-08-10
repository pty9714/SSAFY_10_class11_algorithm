import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class S1491 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testcase = 1; testcase <= T; testcase++) {
            String[] split = br.readLine().split(" ");
            long N = Integer.parseInt(split[0]);
            long A = Integer.parseInt(split[1]);
            long B = Integer.parseInt(split[2]);
            long r = N;
            long c = 1;
            long result = A * Math.abs(r - c) + B * (N - r * c);

            // 가장 가까운 N이하 제곱수 <= k <= N
            // 모든 가능한 경우 탐색
            for (long k = N; k >= Math.floor(Math.sqrt(N)) * Math.floor(Math.sqrt(N)); k--) {
                for (long i = 1; i <= Math.floor(Math.sqrt(k)); i++) {
                    if (k % i == 0) {
                        r = i;
                        c = k / i;
                        result = Math.min(result, A * Math.abs(r - c) + B * (N - r * c));
                    }
                }
            }
            System.out.println("#" + testcase + " " + result);
        }
    }
}

---
28,872 kb
269 ms
