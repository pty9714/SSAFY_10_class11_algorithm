import java.util.*;

class Solution {
    public static int miro[][];
    public static int dir[][] = {{1, 0, 'd'}, {0, -1, 'l'}, {0, 1, 'r'}, {-1, 0, 'u'}};
    public static String answer = "impossible";
    public static boolean stop = false;
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        
        if(!canEscape(x, y, r, c, k)) return answer;
        
        dfs(n, m, x, y, r, c, k, "");
        
        return answer;
    }
    
    // k가 S와 E 사이 거리보다 작거나, 둘 차이가 홀수라면 탈출 불가
    public boolean canEscape(int x, int y, int r, int c, int k) {
        int distance = Math.abs(x - r) + Math.abs(y - c);
        if(k < distance || (k - distance) % 2 != 0) {
            return false;
        }
        return true;
    }
    
    public void dfs(int n, int m, int x, int y, int r, int c, int k, String path){
        if(stop || k < 1) return;
        for(int i = 0; i < 4; i++) {
            int tmpx = x + dir[i][0];
            int tmpy = y + dir[i][1];
            if(tmpx <= 0 || tmpx > n || tmpy <= 0 || tmpy > m || !canEscape(tmpx, tmpy, r, c, k - 1)) continue;
            if(k == 1) {
                if(tmpx == r && tmpy == c) {
                    answer = path + String.valueOf((char) dir[i][2]);
                    stop = true;
                    return;
                }
            }
            else dfs(n, m, tmpx, tmpy, r, c, k - 1, path + String.valueOf((char) dir[i][2]));
        }
    }
}
// 테스트 1 〉	통과 (2.14ms, 81MB)
// 테스트 2 〉	통과 (1.98ms, 74.5MB)
// 테스트 3 〉	통과 (0.03ms, 71.6MB)
// 테스트 4 〉	통과 (1.79ms, 82.7MB)
// 테스트 5 〉	통과 (2.37ms, 83.9MB)
// 테스트 6 〉	통과 (1.78ms, 73.6MB)
// 테스트 7 〉	통과 (1.72ms, 76.8MB)
// 테스트 8 〉	통과 (1.79ms, 79.1MB)
// 테스트 9 〉	통과 (12.96ms, 85.5MB)
// 테스트 10 〉	통과 (10.21ms, 97.8MB)
// 테스트 11 〉	통과 (8.55ms, 87.2MB)
// 테스트 12 〉	통과 (11.55ms, 86.2MB)
// 테스트 13 〉	통과 (8.94ms, 88.5MB)
// 테스트 14 〉	통과 (8.61ms, 95.6MB)
// 테스트 15 〉	통과 (10.36ms, 92.9MB)
// 테스트 16 〉	통과 (9.84ms, 92.6MB)
// 테스트 17 〉	통과 (9.21ms, 92.7MB)
// 테스트 18 〉	통과 (9.24ms, 83MB)
// 테스트 19 〉	통과 (11.66ms, 81.4MB)
// 테스트 20 〉	통과 (9.65ms, 85.8MB)
// 테스트 21 〉	통과 (9.08ms, 83.7MB)
// 테스트 22 〉	통과 (8.85ms, 88.3MB)
// 테스트 23 〉	통과 (8.40ms, 89.2MB)
// 테스트 24 〉	통과 (9.79ms, 82.1MB)
// 테스트 25 〉	통과 (9.13ms, 90.5MB)
// 테스트 26 〉	통과 (8.68ms, 86.5MB)
// 테스트 27 〉	통과 (9.29ms, 93.3MB)
// 테스트 28 〉	통과 (10.06ms, 89.1MB)
// 테스트 29 〉	통과 (9.78ms, 94.2MB)
// 테스트 30 〉	통과 (8.92ms, 90.1MB)
// 테스트 31 〉	통과 (0.08ms, 75MB)