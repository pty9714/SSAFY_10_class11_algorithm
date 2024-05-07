import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 17932KB, 172ms
public class B1911 {
    static class Pole implements Comparable<Pole> {
        int start;
        int end;
        Pole(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Pole o) {
            return this.start - o.start;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        PriorityQueue<Pole> poles = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            poles.add(new Pole(start, end));
        }
        int ans = 0;
        int pad = 0;
        while(!poles.isEmpty()) {
            Pole cur = poles.poll();
            if(cur.start < pad) {
                cur.start += pad - cur.start;
            }
            if(cur.start >= cur.end) continue;
            int cnt = (cur.end - cur.start) / L + ((cur.end - cur.start) % L > 0 ? 1 : 0);
            ans += cnt;
            pad = cur.start + cnt * L;
        }
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
