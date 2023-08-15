import java.io.*;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int tc = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= tc; t++) {
            st = new StringTokenizer(br.readLine());
            long n = Integer.parseInt(st.nextToken());
            long a = Integer.parseInt(st.nextToken());
            long b = Integer.parseInt(st.nextToken());
            long ans = Integer.MAX_VALUE;

            for (long r = 1; r <= n; r++) {
                long c = 1;
                while (r * c <= n) {
                    ans = Math.min(ans, a * Math.abs(r - c) + b * (n - (r * c)));
                    c++;
                }
            }
            bw.write("#" + t + " " + ans + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}