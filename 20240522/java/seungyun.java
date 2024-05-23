import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class B2660 {

    static int[] dp;
    // 지름길 key : 도착점, value : 시작점,이동거리
    static HashMap<Integer, List<int[]>> shortCut;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        shortCut = new HashMap<>();

        int[][] endLen = new int[n][2];
        int total = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int sLen = Integer.parseInt(st.nextToken());

            if (!shortCut.containsKey(end)) {
                shortCut.put(end, new ArrayList<>());
            }
            shortCut.get(end).add(new int[]{start, sLen});
        }

        // i까지의 최소 거리
        dp = new int[d + 1];

        for (int i = 1; i <= d; i++) {
            int dist = dp[i-1]+1;

            // 지름길이 있다면
            if(shortCut.containsKey(i)){
                for(int[] startLen : shortCut.get(i)){
                    dist = Math.min(dist, dp[startLen[0]] + startLen[1]);
                }
            }
            dp[i] = dist;
        }

        System.out.println(dp[d]);

    }
}
