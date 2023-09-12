import java.util.Arrays;
class Solution {
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        
        int answer = Integer.MAX_VALUE;
        
        int length = onboard.length; // 시간
        
        temperature += 10; t1 += 10; t2 += 10; // -10~40 도를 0~50도로 전환
        int dp[][] = new int[length][51]; // dp[r][c] = r분에 실내 온도 c도일 때의 소비 전력 최소값 
        for(int i = 0; i < length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        
        dp[0][temperature] = 0; // 초기 온도
        
        for(int i = 0; i < length - 1; i++) {
            for(int j = 0; j < 51; j++) {
                if(onboard[i] == 1 && (j < t1  || j > t2)) continue; // 승객이 탑승 중일 때, t1~t2 온도 아닌 경우는 pass
                // 희망온도 == 실내 온도 (실내 온도 유지, 전력 b)
                if(dp[i][j] != Integer.MAX_VALUE)
                    dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j] + b);  

                // 희망 온도 < 실내 온도 (실내 온도 1 하강함, 전력 a)
                if(j > 0 && dp[i][j] != Integer.MAX_VALUE)
                    dp[i+1][j-1] = Math.min(dp[i+1][j-1], dp[i][j] + a);

                // 희망 온도 > 실내 온도 (실내 온도 1 상승함, 전력 a)
                if(j < 50 && dp[i][j] != Integer.MAX_VALUE)
                    dp[i+1][j+1] = Math.min(dp[i+1][j+1], dp[i][j] + a);

                // off (실내 온도 유지, 전력 X)
                if(temperature == j) { // 실외 온도 == 실내 온도 (실내 온도 유지)
                    dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]); 
                }
                else if(j > 0 && temperature < j) { // 실외 온도 < 실내 온도 ( 실내 온도 1 하강함)
                    dp[i+1][j-1] = Math.min(dp[i+1][j-1], dp[i][j]);
                }
                else if(j < 50 && temperature > j) { // 실외 온도 > 실내 온도 ( 실내 온도 1 상승함)
                    dp[i+1][j+1] = Math.min(dp[i+1][j+1], dp[i][j]);
                }
            }
        }
        
        for(int i = 0; i < 51; i++) {
            if(onboard[length-1] == 1 && (i < t1  || i > t2)) continue; // 승객이 탑승 중일 때, t1~t2 온도 아닌 경우는 pass
            answer = Math.min(answer, dp[length-1][i]);   
        }
        
        return answer;
    }
}
/*
테스트 1 〉	통과 (0.08ms, 75.7MB)
테스트 2 〉	통과 (13.95ms, 78.7MB)
테스트 3 〉	통과 (6.60ms, 76.1MB)
테스트 4 〉	통과 (0.07ms, 75.6MB)
테스트 5 〉	통과 (0.07ms, 76.4MB)
테스트 6 〉	통과 (0.15ms, 72.2MB)
테스트 7 〉	통과 (0.14ms, 69.4MB)
테스트 8 〉	통과 (0.18ms, 72MB)
테스트 9 〉	통과 (0.16ms, 78.2MB)
테스트 10 〉	통과 (2.28ms, 78.6MB)
테스트 11 〉	통과 (1.89ms, 73.5MB)
테스트 12 〉	통과 (2.42ms, 79.2MB)
테스트 13 〉	통과 (10.93ms, 72.4MB)
테스트 14 〉	통과 (8.41ms, 78MB)
테스트 15 〉	통과 (9.09ms, 76.6MB)
테스트 16 〉	통과 (14.60ms, 79.2MB)
테스트 17 〉	통과 (5.77ms, 75MB)
테스트 18 〉	통과 (6.48ms, 86MB)
테스트 19 〉	통과 (6.10ms, 77.4MB)
테스트 20 〉	통과 (9.02ms, 82.4MB)
테스트 21 〉	통과 (9.62ms, 78.5MB)
테스트 22 〉	통과 (12.28ms, 81.9MB)
테스트 23 〉	통과 (15.04ms, 80.9MB)
테스트 24 〉	통과 (12.41ms, 81.4MB)
테스트 25 〉	통과 (13.57ms, 70.9MB)
*/