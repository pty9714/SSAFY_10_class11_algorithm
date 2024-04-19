import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
// 63672KB, 524ms
public class B13164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] heights = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }
        int[] adj = new int[N-1];
        for (int i = 0; i < N - 1; i++) {
            adj[i] = heights[i + 1] - heights[i];
        }
        Arrays.sort(adj);
        long cost = 0;
        for (int i = 0; i < N - K; i++) {
            cost += adj[i];
        }

        bw.write(cost + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
