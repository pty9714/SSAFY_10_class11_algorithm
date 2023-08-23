class Solution {
    public static int answer, N;
    public static boolean[] visited;
    public int solution(int alp, int cop, int[][] problems) {
        answer = Integer.MAX_VALUE;
        N = problems.length();
        visited = new boolean[N];
        
        
        
        return answer;
    }
    
    public static void dfs(int cnt, int hour, int alp, int cop) {
        if(cnt == N) {
            ans = Math.min(ans, hour)
            return;
        }
        
        for(int i = 0; i < N; i++) {
            if(alp < problems[i][0])
            hour += problems[i][0] problems[i][1] - alp - cop;
            
        }
    }
}