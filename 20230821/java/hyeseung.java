import java.util.*;

class Solution {
    public int[] solution(int[][] edges, int[] target) {
        int N = edges.length;
        int T = 0;
        int[] pass = new int[n];
        int[] cnt = new int[n];
        boolean[] visited = new boolean[n];
        ArrayList<Integer> leaf = new ArrayList<>();

        ArrayList<ArrayList<Integer>> tree = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= N;i++) tree.add(new ArrayList<>());
        for (int i = 0; i <= N;i++) {
            tree.get(i).add(edges[i][1]);
        }
        for (int i = 0; i <= n; i++) {
            Collections.sort(tree.get(i));
        }
        for (int i = 0; i <= n; i++) if (tree.get(i).isEmpty() && target[i] > 0) T++;

        while (T > 0) {
            int node = 0;

            while (tree[node].size()>0) node = tree[node].get(pass[node]++ % tree[node].size());

            // 리프 노드에 떨어진 숫가 개수 증가
            cnt[node]++;
            // 리프 노드 저장
            Q.add(node);
            if (cnt[node] > target[node]){
                int[] answer = {-1};
                return answer;
            }
            if (!check[node] && target[node] <= 3 * cnt[node]){
                check[node] = true;
                T--;
            }
        }
    
        
        return answer;
    }
}