import java.io.*;
import java.util.*;

public class Main {

    private static class Pair {
        String x;
        int c;

        public Pair(String x, int c) {
            this.x = x;
            this.c = c;
        }
    }

    private static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        String arrStr = "";
        for (int i = 0; i < n; i++) {
            arrStr += arr[i];
        }

        Arrays.sort(arr);

        String sortedArrStr = "";
        for (int i = 0; i < n; i++) {
            sortedArrStr += arr[i];
        }

        bw.write(k > n ? "-1" : String.valueOf(bfs(arrStr, sortedArrStr)));

        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs(String str, String sortedStr) {
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(str, 0));
        HashSet<String> vst = new HashSet<>();
        vst.add(str);
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            if (cur.x.equals(sortedStr)) return cur.c;
            for (int i = 0; i <= n - k; i++) {
                String nx = cur.x.substring(0, i) + new StringBuilder(cur.x.substring(i, i + k)).reverse() + cur.x.substring(i + k);
                if (!vst.contains(nx)) {
                    q.offer(new Pair(nx, cur.c + 1));
                    vst.add(nx);
                }
            }
        }
        return -1;
    }

}
