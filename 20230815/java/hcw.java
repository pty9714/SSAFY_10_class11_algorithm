import java.util.*;

class Solution {
    static int[] parent;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        Arrays.sort(costs, (int[] c1, int[] c2) -> c1[2] - c2[2]);
        
        parent = new int[n];
        
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        
        int total = 0;
        
        for(int[] edge: costs){
            System.out.println(Arrays.toString(parent));
            System.out.println(Arrays.toString(edge));
            int from = edge[0]; //출발
            int to = edge[1]; //도착
            int cost = edge[2]; //비용
            
            int fromParent = findParent(from);
            int toParent = findParent(to);
            
            if(fromParent == toParent) continue;
            
            total += cost;
            parent[toParent] = fromParent;
        }
        
        return total;
    }
    
    
    private int findParent(int node){
        if(parent[node] == node) return node;
        parent[node] = findParent(parent[node]);
        return parent[node];
    }
}
