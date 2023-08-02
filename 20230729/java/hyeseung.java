import java.util.*;

class Position {
    int x;
    int y;
    int dis;
    
    public Position(int x, int y, int dis) {
        this.x = x;
        this.y = y;
        this.dis = dis;
    }
}
class Solution {
    static final int SIZE = 101;
    static boolean[][] matrix = new boolean[SIZE][SIZE];
    
    int[] dX = {0, 0, -1, 1};
    int[] dY = {1, -1, 0, 0};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        // 사각형 테두리
        for(int[] rect : rectangle) {
            for(int x = rect[0] * 2; x <= rect[2] * 2; x++) {
                for(int y = rect[1] * 2; y <= rect[3] * 2; y++) {
                    matrix[x][y] = true;
                }
            }
        }
        
        // 테두리 제외한 사각형 너비 영역 빈 공간
        for(int[] rect : rectangle) {
            for(int x = rect[0] * 2 + 1; x <= rect[2] * 2 - 1; x++) {
                for(int y = rect[1] * 2 + 1; y <= rect[3] * 2 - 1; y++) {
                    matrix[x][y] = false;
                }
            }
        }
        
        // BFS 실행 결과
        answer = bfs(new Position(characterX * 2, characterY * 2, 0), itemX * 2, itemY * 2);
        
        return answer;
    }
    
    public int bfs(Position pos, int itemX, int itemY) {
        Queue<Position> q = new LinkedList<>();
        q.offer(pos);
        matrix[pos.x][pos.y] = false;
        
        while(!q.isEmpty()) {
            Position p = q.poll();
            if(p.x == itemX && p.y == itemY) {
                return p.dis / 2;
            }
            
            for(int i = 0; i < 4; i++) { // 상, 하, 좌, 우 이동
                int tmpX = p.x + dX[i];
                int tmpY = p.y + dY[i];
                
                if(tmpX < 2 || tmpX > 100 || tmpY < 2 || tmpY > 100) continue;
                // 방문하지 않은 모서리 방문
                if(matrix[tmpX][tmpY]) {
                    matrix[tmpX][tmpY] = false;
                    q.offer(new Position(tmpX, tmpY, p.dis + 1));
                }
            }
        }
        
        return -1;
    }
}

// 1.72ms