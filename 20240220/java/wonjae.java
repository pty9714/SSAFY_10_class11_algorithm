import java.util.*;

class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
        Arrays.sort(money);
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int coin : money){
            for(int i = coin; i <= n; i++){
                dp[i] += dp[i-coin];
                dp[i]%=1000000007;
            }
        }
        return dp[n];
    }
}
/*
정확성  테스트
테스트 1 〉	통과 (2.58ms, 86.4MB)
테스트 2 〉	통과 (1.83ms, 65.1MB)
테스트 3 〉	통과 (1.24ms, 71.7MB)
테스트 4 〉	통과 (1.55ms, 74.7MB)
테스트 5 〉	통과 (0.87ms, 77.1MB)
테스트 6 〉	통과 (0.59ms, 73.4MB)
테스트 7 〉	통과 (2.27ms, 75.7MB)
테스트 8 〉	통과 (2.52ms, 76.1MB)
테스트 9 〉	통과 (2.10ms, 72.1MB)
테스트 10 〉	통과 (0.74ms, 74.6MB)
테스트 11 〉	통과 (1.20ms, 78.6MB)
테스트 12 〉	통과 (1.63ms, 76.6MB)
테스트 13 〉	통과 (0.93ms, 79.3MB)
테스트 14 〉	통과 (1.51ms, 73MB)
효율성  테스트
테스트 1 〉	통과 (16.49ms, 52.4MB)
테스트 2 〉	통과 (10.84ms, 52.9MB)
테스트 3 〉	통과 (10.16ms, 52.8MB)
테스트 4 〉	통과 (17.60ms, 52.4MB)
테스트 5 〉	통과 (25.04ms, 52.6MB)
테스트 6 〉	통과 (11.67ms, 52.4MB)
*/
