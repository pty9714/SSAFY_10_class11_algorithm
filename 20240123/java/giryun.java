import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        List<int[]> balls = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int color = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            balls.add(new int[] { size, color, i });
        }

        balls.sort(Comparator.comparingInt(x -> x[0]));

        Map<Integer, Integer> answer = new HashMap<>();
        Map<Integer, Integer> prefixSum = new HashMap<>(); // 색깔 별 공의 크기 누적합

        int idx, c, s;
        int j = 0, totalSize = 0;
        for (int i = 0; i < n; i++) {
            int[] ball = balls.get(i);
            s = ball[0];
            c = ball[1];
            idx = ball[2];

            while (balls.get(j)[0] < s) {
                totalSize += balls.get(j)[0];
                prefixSum.put(balls.get(j)[1], prefixSum.getOrDefault(balls.get(j)[1], 0) + balls.get(j)[0]);
                j++;
            }

            answer.put(idx, totalSize - prefixSum.getOrDefault(c, 0));
        }
        for (int i = 0; i < n; i++) {
            bw.write(answer.get(i) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
