
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Solution {

    public static boolean[] visited;
    public static int result = -1;
    public static int end;
    public static ArrayList<ArrayList<int[]>> neighbors;
    public static int K;
    public static ArrayList<ArrayList<int[]>> memorize;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken()); // 두께
        int N = Integer.parseInt(st.nextToken()); // 섬 갯수
        int M = Integer.parseInt(st.nextToken()); // 길 갯수

        // memorize = new int[N+1][2]; // 0은 length, 1은 cost
        memorize = new ArrayList<>(N + 1);
        visited = new boolean[N + 1];
        neighbors = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++) {
            memorize.add(new ArrayList<>());
            neighbors.add(new ArrayList<>());
            visited[i] = false;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int roadA = Integer.parseInt(st.nextToken());
            int roadB = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            neighbors.get(roadA).add(new int[] { roadB, length, cost });
            neighbors.get(roadB).add(new int[] { roadA, length, cost });
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        visited[start] = true;
        dfs(start, 0, 0);

        System.out.println(result);
    }

    public static void dfs(int node, int length, int cost) {
        if (node == end) {
            if (result == -1) {
                result = length;
            } else {
                result = Math.min(result, length);
            }
            return;
        }
        for (int[] info : neighbors.get(node)) {
            int newNode = info[0];
            if (visited[newNode]) {
                continue;
            }
            int newLength = info[1] + length;
            int newCost = info[2] + cost;

            boolean signal = true;
            for (int[] tmp : memorize.get(newNode)) {
                if (tmp[1] <= newCost && tmp[0] <= newLength) {
                    signal = false;
                    break;
                }
            }
            if (!signal) {
                continue;
            }

            memorize.get(newNode).add(new int[] { newLength, newCost });
            if (newCost < K) {
                visited[newNode] = true;
                dfs(newNode, newLength, newCost);
                visited[newNode] = false;
            }

        }
    }

}