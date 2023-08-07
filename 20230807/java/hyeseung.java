import java.util.*;

class Solution {
    public static int miro[][];
    public static int dir[][] = {{1, 0, 'd'}, {0, -1, 'l'}, {0, 1, 'r'}, {-1, 0, 'u'}};
    public static String answer;
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        answer = "impossible";
        
        if(!canEscape(x, y, r, c, k)) return answer;
        
        dfs(n, m, x, y, r, c, k - 1, "", false);
        
        return answer;
    }
    
    // k가 S와 E 사이 거리보다 작거나, 둘 차이가 홀수라면 탈출 불가
    public boolean canEscape(int x, int y, int r, int c, int k) {
        int distance = Math.abs(x - r) + Math.abs(y - c);
        if(k < distance || (k - distance) % 2 != 0) return false;
        return true;
    }
    
    public void dfs(int n, int m, int x, int y, int r, int c, int k, String path, boolean stop){
        if(stop || k == 0) return;
        for(int i = 0; i < 4; i++) {
            if(stop) return;
            int tmpx = x + dir[i][0];
            int tmpy = y + dir[i][1];
            if(tmpx <= 0 || tmpx > n || tmpy <= 0 || tmpy > n || !canEscape(x, y, r, c, k)) continue;
            if(k > 0) dfs(n, m, tmpx, tmpy, r, c, k - 1, path + String.valueOf((char)dir[i][2]), stop);
            else if(k == 0 && tmpx == r && tmpy == c) {
                answer = path + String.valueOf((char)dir[i][2]);
                stop = true;
                return;
            }
        }
    }
}