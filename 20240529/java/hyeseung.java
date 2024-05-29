import java.util.*;
import java.awt.*;
class Solution {
    String[] Maps;
    int dx[] = {-1, 1, 0, 0};
    int dy[] = {0, 0, -1, 1};
    int N, M;
    HashMap<Character, Point> key = new HashMap<>();
    public int solution(String[] maps) {
        Maps = maps;
        N = maps.length;
        M = maps[0].length();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(maps[i].charAt(j) == 'S'
                        || maps[i].charAt(j) == 'L'
                        || maps[i].charAt(j) == 'E') {
                    key.put(maps[i].charAt(j), new Point(i, j));
                }
            }
        }
        int answer = bfs(key.get('S').x, key.get('S').y, key.get('L').x, key.get('L').y);
        if(answer != -1) {
            int temp = bfs(key.get('L').x, key.get('L').y, key.get('E').x, key.get('E').y);
            if(temp == -1) answer = -1;
            else answer += temp;
        }
        return answer;
    }
    private int bfs(int startX, int startY, int endX, int endY) {
        boolean visited[][] = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {startX, startY, 0});
        int time = Integer.MAX_VALUE;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if(cur[0] == endX && cur[1] == endY) {
                time = Math.min(cur[2], time);
                break;
            }
            for (int i = 0; i < 4; i++) {
                int tempX = cur[0] + dx[i];
                int tempY = cur[1] + dy[i];
                if(tempX < 0 || tempX >= N || tempY < 0 || tempY >= M || visited[tempX][tempY] || Maps[tempX].charAt(tempY) == 'X') continue;
                visited[tempX][tempY] = true;
                q.offer(new int[] {tempX, tempY, cur[2] + 1});
            }
        }
        return time == Integer.MAX_VALUE ? -1 : time;
    }
}