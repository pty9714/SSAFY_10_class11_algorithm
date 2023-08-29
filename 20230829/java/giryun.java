import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<Integer> res = new ArrayList<>();
        while (true) {
            int now = 1;
            while (true) {
                if (now * 2 > n) break;
                now *= 2;
            }
            if (n < now) break;
            res.add(now);
            n -= now;
        }
        if (res.size() <= k) bw.write(String.valueOf(0));
        else {
            int tmp = 0;
            for (int i = k; i < res.size(); i++) tmp += res.get(i);
            bw.write(String.valueOf(res.get(k-1) - tmp));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
