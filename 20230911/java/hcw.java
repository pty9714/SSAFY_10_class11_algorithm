class Solution {
    final static Solution method = new Solution();
    
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        int k = 1000 * 100;
        t1 += 10;
        t2 += 10;
        temperature += 10;
        
        int[][] DP = new int[onboard.length][51];
        for (int i = 0; i < onboard.length; i++) {
            for (int j = 0; j < 51; j++) {
                DP[i][j] = k;
            }
        }
        
        DP[0][temperature] = 0;
        
        int flag = 1;
        if (temperature > t2) { //에어컨을 가동했을때 온도가 변하는 방향
            flag = -1;
        }
        
        for (int i = 1; i < onboard.length; i++) {
            for (int j = 0; j < 51; j++) {
                int minV = k;
                if (( onboard[i] == 1 && t1 <= j && j <= t2 ) || onboard[i] == 0) {
                    //에어컨을 키지 않고 실외온도와 달라서 실내온도가 -flag 되는 경우
                    if (0 <= j+flag && j+flag <= 50) {
                        minV = Math.min(minV, DP[i-1][j+flag]);
                    }
                    //에어컨을 키지 않고 현재온도 j 가 실외온도랑 같아서 변하지 않는 경우
                    if (j == temperature) {
                        minV = Math.min(minV, DP[i-1][j]);
                    }
                    //에어컨을 키고 현재온도가 변하는 경우
                    if (0 <= j-flag && j-flag <= 50) {
                        minV = Math.min(minV, DP[i-1][j-flag] + a);
                    }
                    //에어컨을 키고 현재온도가 희망온도라서 온도가 변하지 않는경우
                    if (t1 <= j && j <= t2) {
                        minV = Math.min(minV, DP[i-1][j] + b);
                    }
                    
                    DP[i][j] = minV;
                    
                }
            }
        }
        
        int i = onboard.length-1;
        int answer = DP[i][0];
        for (int j = 1; j < 51; j++) {
            answer = Math.min(answer, DP[i][j]);
        }
        return answer;
    }

}

정확성  테스트
테스트 1 〉	통과 (0.07ms, 78.8MB)
테스트 2 〉	통과 (6.93ms, 78.1MB)
테스트 3 〉	통과 (3.08ms, 87.7MB)
테스트 4 〉	통과 (0.16ms, 73.9MB)
테스트 5 〉	통과 (0.09ms, 73.2MB)
테스트 6 〉	통과 (0.10ms, 72.9MB)
테스트 7 〉	통과 (0.15ms, 73.8MB)
테스트 8 〉	통과 (0.14ms, 77.8MB)
테스트 9 〉	통과 (0.13ms, 78.4MB)
테스트 10 〉	통과 (1.26ms, 73MB)
테스트 11 〉	통과 (1.16ms, 80.9MB)
테스트 12 〉	통과 (1.19ms, 72.5MB)
테스트 13 〉	통과 (5.39ms, 77.4MB)
테스트 14 〉	통과 (5.61ms, 82.4MB)
테스트 15 〉	통과 (5.34ms, 71.4MB)
테스트 16 〉	통과 (4.73ms, 72.4MB)
테스트 17 〉	통과 (3.47ms, 81MB)
테스트 18 〉	통과 (3.45ms, 75.4MB)
테스트 19 〉	통과 (5.41ms, 71.4MB)
테스트 20 〉	통과 (8.51ms, 77.7MB)
테스트 21 〉	통과 (4.50ms, 74.2MB)
테스트 22 〉	통과 (6.61ms, 78.4MB)
테스트 23 〉	통과 (4.55ms, 78.2MB)
테스트 24 〉	통과 (4.45ms, 89MB)
테스트 25 〉	통과 (4.34ms, 77.1MB)
