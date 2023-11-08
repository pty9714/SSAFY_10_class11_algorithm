import java.util.*;
 
class Solution {
    static int answer, n;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    static int[][] B;
    static boolean [][][] visited;
    
    public int solution(int[][] board) {
        answer = Integer.MAX_VALUE;
        n = board.length;
        B = board;
        visited = new boolean[n][n][4];
        bfs(0, 0);
        return answer;
    }
    
    public void bfs(int i, int j) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(i, j, -1, 0)); // 좌표, 방향, 비용
        while(!q.isEmpty()) {
            Node now = q.poll();
            if (now.x == n-1 && now.y == n-1) answer = Math.min(answer, now.c);
            for(int nd = 0; nd < 4; nd++) {
                int nx = now.x + dx[nd];
                int ny = now.y + dy[nd];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || B[nx][ny] == 1) continue;
                int nc = now.c + 600;
                if(now.d == -1 || now.d == nd) nc -= 500;
                if(!visited[nx][ny][nd] || B[nx][ny] >= nc) {
                    q.add(new Node(nx, ny, nd, nc));
                    visited[nx][ny][nd] = true;
                    B[nx][ny] = nc;
                }
            }
        }
    }

    public class Node {
        int x, y, d, c;
        
        public Node(int x, int y, int d, int c) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.c = c;
        }
    }
}
/*
테스트 1 〉	통과 (0.53ms, 75.4MB)
테스트 2 〉	통과 (0.42ms, 77.2MB)
테스트 3 〉	통과 (0.31ms, 76.8MB)
테스트 4 〉	통과 (0.53ms, 77.7MB)
테스트 5 〉	통과 (0.35ms, 74.9MB)
테스트 6 〉	통과 (1.22ms, 77.9MB)
테스트 7 〉	통과 (1.61ms, 70.9MB)
테스트 8 〉	통과 (1.16ms, 75.9MB)
테스트 9 〉	통과 (2.34ms, 67MB)
테스트 10 〉	통과 (1.74ms, 70.5MB)
테스트 11 〉	통과 (26.74ms, 87.5MB)
테스트 12 〉	통과 (11.57ms, 78.5MB)
테스트 13 〉	통과 (0.67ms, 79.3MB)
테스트 14 〉	통과 (1.34ms, 76.8MB)
테스트 15 〉	통과 (3.35ms, 69.3MB)
테스트 16 〉	통과 (3.94ms, 73.3MB)
테스트 17 〉	통과 (11.70ms, 75.1MB)
테스트 18 〉	통과 (8.59ms, 75.6MB)
테스트 19 〉	통과 (27.07ms, 80.1MB)
테스트 20 〉	통과 (1.87ms, 74.7MB)
테스트 21 〉	통과 (3.39ms, 76.1MB)
테스트 22 〉	통과 (0.40ms, 75.5MB)
테스트 23 〉	통과 (0.38ms, 77MB)
테스트 24 〉	통과 (0.53ms, 66.4MB)
테스트 25 〉	통과 (0.34ms, 78.8MB)
*/
