import java.io.*;
import java.util.StringTokenizer;

// 229112KB, 764ms
public class B10942 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        boolean[][] dp = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(i == 0) { // S와 E 사이 숫자 개수가 1개일 때 초기화
                    dp[j][i + j] = true;
                }
                else if(i + j < N && numbers[j] == numbers[i + j]) { // S와 E번째 숫자가 같을 때
                    if(i == 1) { // S와 E 사이 숫자 개수가 2개일 때 초기화
                        dp[j][i + j] = true;
                    }
                    else { // S와 E 사이 숫자 개수가 3개 이상일 때 이전 값 가져오기
                        dp[j][i + j] = dp[j + 1][i + j - 1];
                    }
                }
            }
        }
        // 문제
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            if(dp[S-1][E-1]) {
                sb.append("1\n");
            }
            else {
                sb.append("0\n");
            }
        }
        System.out.print(sb);
        br.close();
    }
}
