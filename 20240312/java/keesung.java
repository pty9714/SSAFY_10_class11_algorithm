import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        dp = new boolean[n + 1][n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        solve(arr, n);
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if (dp[start][end])
                sb.append("1\n");
            else
                sb.append("0\n");
        }

        System.out.println(sb);
    }

    public static void solve(int[] arr, int n) {
        for (int i = 1; i <= n; i++)
            dp[i][i] = true;

        for (int i = 1; i <= n - 1; i++)
            if (arr[i] == arr[i + 1])
                dp[i][i + 1] = true;

        for (int i = 2; i < n; i++) {
            for (int j = 1; j <= n - i; j++) {
                if (arr[j] == arr[j + i] && dp[j + 1][j + i - 1])
                    dp[j][j + i] = true;
            }
        }
    }

}

// 길이가 1일떄, 2일때, 3일때를 나누어서 생각한다.
// 1이면 무조건 펠린드롬이다.
// 2이면 두개의 숫자가 같으면 펠린드롬이다.
// 3이면 분할정복을 통해 맨 앞뒤를 확인하고, 가운데는 dp를 통해 펠린드롬인지 확인하면 된다.