import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int ans = 0;
        for (int i = 0; i < N; i++) {
            int now = A[i];
            int[] tmp = new int[N - 1];
            System.arraycopy(A, 0, tmp, 0, i);
            System.arraycopy(A, i + 1, tmp, i, N - i - 1);

            int s = 0, e = N - 2;

            while (s < e) {
                int t = tmp[s] + tmp[e];
                if (t == now) {
                    ans++;
                    break;
                } else if (t < now) {
                    s++;
                } else {
                    e--;
                }
            }
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
