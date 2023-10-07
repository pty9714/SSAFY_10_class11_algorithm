import java.io.*;
import java.util.*;

class Solution {
    static int fx, fy, sx, sy, tmp, min;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] B = new int[rows][columns];
        for (int i=0; i<rows; i++) {
            for (int j=0; j<columns; j++) {
                B[i][j] = columns * i + j + 1;
            }
        }
        int idx = 0;
        for (int[] query : queries) {
            fx = query[0];
            fy = query[1];
            sx = query[2];
            sy = query[3];
            
            tmp = B[fx-1][fy-1];
            min = tmp;
            
            //왼쪽 회전
            for (int x=fx-1; x<sx-1; x++) {
                B[x][fy-1] = B[x+1][fy-1];
                min = Math.min(min, B[x][fy-1]);
            }
            
            //아래쪽 회전
            for (int y=fy-1; y<sy-1; y++) {
                B[sx-1][y] = B[sx-1][y+1];
                min = Math.min(min, B[sx-1][y]);
            }
            
            //오른쪽 회전
            for (int x=sx-1; x>fx-1; x--) {
                B[x][sy-1] = B[x-1][sy-1];
                min = Math.min(min, B[x][sy-1]);
            }
            
            //위쪽 회전
            for (int y=sy-1; y>fy-1; y--) {
                B[fx-1][y] = B[fx-1][y-1];
                min = Math.min(min, B[fx-1][y]);
            }
            
            B[fx-1][fy] = tmp;
            answer[idx++] = min;
        }
        return answer;
    }
}
/*
테스트 1 〉	통과 (0.04ms, 72.4MB)
테스트 2 〉	통과 (0.05ms, 84MB)
테스트 3 〉	통과 (34.22ms, 80.8MB)
테스트 4 〉	통과 (23.58ms, 90MB)
테스트 5 〉	통과 (39.78ms, 85.2MB)
테스트 6 〉	통과 (44.48ms, 103MB)
테스트 7 〉	통과 (33.81ms, 82MB)
테스트 8 〉	통과 (20.04ms, 82.2MB)
테스트 9 〉	통과 (23.76ms, 92.3MB)
테스트 10 〉	통과 (20.80ms, 78.8MB)
테스트 11 〉	통과 (17.59ms, 83.4MB)
*/
