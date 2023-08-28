import java.io.*;
import java.util.StringTokenizer;

public class giryun {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int tc = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= tc; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if (n == 1) bw.write("#" + t + " 0");
            else if (n == 2) bw.write("#" + t + " 1");
            else {
                int a = n;
                boolean isBalance = false;
                // 왼쪽이 더 깊은지 판단
                while (a > 1) {
                    if (a == 3) isBalance = true;
                    a /= 2;

                }
                int ans = 0;
                int b = v;
                boolean startRight = false;
                // 시작 정점이 왼쪽에 있는지 오른쪽에 있는지 파악
                while (b > 1) {
                    if (b == 3) isBalance = true;
                    b /= 2;
                    ans++;
                }
                // 최대 깊이까지 탐색
                while (b < n) {
                    b *= 2;
                    if (b <= n) ans ++;
                }
                if (!isBalance && !startRight && v != 1) ans--;
                bw.write("#" + t + " " + ans);
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
// 메모리 : 68,940 kb, 시간 : 345 ms