import java.util.*;

//테스트 6 〉	통과 (62.94ms, 72.3MB)
class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
        int[] dp = new int[n+1];
        Arrays.sort(money);
        dp[0] = 1;
        for(int m : money){
            
            for(int i=m; i<=n; i++){
                dp[i] += dp[i-m];
                dp[i] %= 1000000007;
            }
            
        }
        
        return dp[n];
    }
}
