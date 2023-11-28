import java.util.*;

class Solution {
    public int n, m;
    public int dx[] = {-1, 1, 0, 0};
    public int dy[] = {0, 0, -1, 1};
    public int solution(int[][] land) {
        int answer = 0;
        int chunk = 1;
        n = land.length;
        m = land[0].length;
        ArrayList<Integer> oil = new ArrayList<Integer>(); // 덩어리 당 크기
        oil.add(0);
        // 덩어리 개수 세기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(land[i][j] == 1) {
                    oil.add(bfs(land, i, j, chunk++));
                }
            }
        }
        // 시추관 설치하기
        for (int i = 0; i < m; i++) {
            HashSet<Integer> hs = new HashSet<>();
            for(int j = 0; j < n; j++) {
                if(land[j][i] != 0) {
                    hs.add(-land[j][i]); // 획득한 덩어리 HashSet에 넣기
                }
            }
            answer = Math.max(answer, countOil(hs, oil)); // 석유량 최댓값 비교
        }
        return answer;
    }
    
    public int bfs(int[][] land, int x, int y, int num) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});
        land[x][y] = -num;
        int cnt = 1;
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            for(int i = 0; i < 4; i++) {
                int tempx = temp[0] + dx[i];
                int tempy = temp[1] + dy[i];
                if(tempx < 0 || tempx >= n || tempy < 0 || tempy >= m) continue;
                if(land[tempx][tempy] == 1) {
                    cnt++;
                    land[tempx][tempy] = -num; // 음수값으로 방문 처리 (-1, -2, ...)
                    q.offer(new int[] {tempx, tempy});
                }
            }
        }
        return cnt;
    }
    
    public int countOil(HashSet<Integer> hs, ArrayList<Integer> oil) {
        int cnt = 0;
        for(int chunk : hs) { // 획득한 덩어리의 총 석유량 구하기
            cnt += oil.get(chunk);
        }
        return cnt;
    }
}