import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class giryun {

    static int n, c, X[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        X = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            X[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(X);
        bw.write(String.valueOf(binarySearch(1, X[n-1] - X[0])));
        bw.flush();
        bw.close();
        br.close();
    }

    private static int binarySearch(int s, int e) {
        while (s < e) {
            int m = (s + e) / 2;
            int x = X[0];
            int cnt = 1;
            for (int i = 1; i < n; i++) {
                if (x + m < X[i]) {
                    x = X[i];
                    cnt++;
                }
            }
            if (cnt >= c) {
                s = m + 1;
            }
            else e = m;
        }
        return e;
    }
}
