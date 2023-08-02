import java.util.*;
import java.awt.Point;
class Solution {
    
    // 지도 가로, 세로
    int N, M;
    
    // 상, 하, 좌, 우
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    
    // 방문 노드
    boolean[][] visited;
    
    // 정답
    ArrayList<Integer> answer = new ArrayList<>();
    
    public ArrayList<Integer> solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        visited = new boolean[N][M];
        
        // 탐색
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(!visited[i][j] && maps[i].charAt(j) != 'X') {
                    answer.add(bfs(maps, i, j));
                }
            }
        }
        
        // 정렬
        Collections.sort(answer);
        
        // 지낼 수 있는 무인도 없다면 -1
        if(answer.isEmpty()) answer.add(-1);
        
        return answer;
    }
    
    public int bfs(String[] maps, int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        visited[x][y] = true;
        int day = 0;
        while(!q.isEmpty()) {
            Point p = q.poll();
            day += maps[p.x].charAt(p.y) - '0';
            for(int i = 0; i < 4; i++) {
                int tmpx = p.x + dx[i];
                int tmpy = p.y + dy[i];
                if(tmpx < 0 || tmpx >= N || tmpy < 0 || tmpy >= M) continue;
                if(!visited[tmpx][tmpy] && maps[tmpx].charAt(tmpy) != 'X') {
                    q.add(new Point(tmpx, tmpy));
                    visited[tmpx][tmpy] = true;
                }
            }
        }
        return day;
    }
}