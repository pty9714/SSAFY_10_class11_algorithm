
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Solution {

    public static int[] memorize;
    public static boolean[] calc;
    public static int[] costs;
    public static ArrayList<ArrayList<Integer>> buildingArray;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int test_case = 0; test_case < T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            memorize = new int[N + 1];
            calc = new boolean[N + 1];
            buildingArray = new ArrayList<>(N + 1);

            costs = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            buildingArray.add(new ArrayList<>());
            for (int i = 1; i <= N; i++) {
                costs[i] = Integer.parseInt(st.nextToken());
                buildingArray.add(new ArrayList<>());
            }
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                buildingArray.get(b).add(a);
            }
            int W = Integer.parseInt(br.readLine());

            int result = dfs(W);
            sb.append(result);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static int dfs(int index) {
        if (calc[index]) {
            return memorize[index];
        }
        for (int parent : buildingArray.get(index)) {
            int tmp = dfs(parent);
            if (memorize[index] < tmp) {
                memorize[index] = tmp;
            }
        }
        memorize[index] += costs[index];
        calc[index] = true;
        return memorize[index];
    }

}

// 메모리 242996kb 시간 684ms
// 메모이제이션, dp, 계산값 0이 될 경우 주의