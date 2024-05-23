import java.io.*;
import java.util.StringTokenizer;

// 11620KB,	80ms
public class B1188 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int max = Math.max(N, M);
        int ans = 0;
        for (int i = max; i > 0; i--) {
            if (N % i == 0 && M % i == 0) {
                ans = M - i;
                break;
            }
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
