import java.util.*;

class Solution {
    
    ArrayList<Integer>[] al;
    boolean[] visited;
    int[][] dp;
    
    public int solution(int n, int[][] lighthouse) {
        int answer = 0;
        al = new ArrayList[n+1];
        dp = new int[n+1][2];
        visited = new boolean[n+1];
        for(int i = 1; i <= n; i++){
            al[i] = new ArrayList<>();
        }
        for(int[] lh : lighthouse){
            int a = lh[0];
            int b = lh[1];
            al[a].add(b);
            al[b].add(a);
        }
        
        dfs(1);
        
        answer = Math.min(dp[1][0],dp[1][1]);
        
        return answer;
    }
    
    void dfs(int curr){
        visited[curr] = true;
        
        dp[curr][0] = 0;
        dp[curr][1] = 1;
        
        for(int next : al[curr]){
            if(visited[next]) continue;
            
            dfs(next);
            dp[curr][0] += dp[next][1];
            dp[curr][1] += Math.min(dp[next][0], dp[next][1]);
        }
    }
}
