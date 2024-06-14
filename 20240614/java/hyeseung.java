import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 12912KB, 96ms
public class B13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] weight = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }
        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < w; i++) {
            bridge.add(0);
        }
        int sumL = 0, ans = 0, index = 0;
        while(index < n) {
            sumL -= bridge.poll();
            if(sumL + weight[index] <= L) {
                sumL += weight[index];
                bridge.add(weight[index]);
                index++;
            }
            else {
                bridge.add(0);
            }
            ans++;
        }
        ans += bridge.size();
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
