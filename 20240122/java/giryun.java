import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(br.readLine());

        Map<Character, Integer> map = Map.of('J', 0, 'O', 1, 'I', 2); //Java8에선 안됨

        char[][] board = new char[m][n];
        for (int i = 0; i < m; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int[][][] prefixSum = new int[m + 1][n + 1][3];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int l = 0; l < 3; l++) {
                    prefixSum[i][j][l] = prefixSum[i][j - 1][l] + prefixSum[i - 1][j][l] - prefixSum[i - 1][j - 1][l];
                }
                prefixSum[i][j][map.get(board[i - 1][j - 1])]++;
            }
        }

        int a, b, c, d, answer;
        for (int x = 0; x < k; x++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            for (int l = 0; l < 3; l++) {
                answer = prefixSum[c][d][l] - prefixSum[a - 1][d][l] - prefixSum[c][b - 1][l] + prefixSum[a - 1][b - 1][l];
                bw.write(answer + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
// 똑같은 코드지만 Python3, PyPy3 다 시간 초과 발생.
