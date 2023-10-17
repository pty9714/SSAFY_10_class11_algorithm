
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Solution {

    public static int[] memorize;
    public static int[] costs;
    public static ArrayList<ArrayList<Integer>> buildingArray;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 0; test_case < T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            memorize = new int[N + 1];
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

            System.out.println(result);
        }
    }

    public static int dfs(int index) {
        if (memorize[index] != 0) {
            return memorize[index];
        }
        for (int parent : buildingArray.get(index)) {
            int tmp = dfs(parent);
            if (memorize[index] < tmp) {
                memorize[index] = tmp;
            }
        }
        memorize[index] += costs[index];
        return memorize[index];
    }

}