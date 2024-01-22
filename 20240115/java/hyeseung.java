import java.util.*;

class Solution {
    static class Point {
        int x;
        int y;
        int cost;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        Point(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    HashMap<Integer, Point[]> card; // 숫자 카드 별 좌표
    int answer, N, R, C, map[][];
    Point[] order;
    boolean visitedCard[];
    public int solution(int[][] board, int r, int c) {
        card = new HashMap<Integer, Point[]>();
        R = r; // 시작 좌표
        C = c;
        map = board;
        answer = Integer.MAX_VALUE;
        N = 0;

        // 각 카드별로 2개의 좌표 저장
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(board[i][j] != 0) {
                    if(card.containsKey(board[i][j])) {
                        card.get(board[i][j])[1] = new Point(i, j);
                    }
                    else {
                        card.put(board[i][j], new Point[2]);
                        card.get(board[i][j])[0] = new Point(i, j);
                        N++;
                    }
                }
            }
        }

        order = new Point[2 * N];
        visitedCard = new boolean[N + 1];
        dfs(0);

        return answer;
    }

    // 카드 뒤집을 순열 생성
    void dfs(int cnt) {
        if(cnt == N) {
            answer = Math.min(answer, findCard());
            return;
        }
        for (int i = 1; i <= N; i++) {
            if(!visitedCard[i]) {
                visitedCard[i] = true;
                // 첫 번째 -> 두 번째 카드 순서
                order[cnt * 2] = card.get(i)[0];
                order[cnt * 2 + 1] = card.get(i)[1];
                dfs(cnt + 1);

                // 두 번째 -> 첫 번째 카드 순서
                order[cnt * 2] = card.get(i)[1];
                order[cnt * 2 + 1] = card.get(i)[0];
                dfs(cnt + 1);

                visitedCard[i] = false;
            }
        }
    }

    // 순서 대로 카드를 뒤집으며 bfs를 사용하여 비용 계산
    int findCard() {
        // map 깊은 복사
        int[][] copy = copyArr(map);
        Point start = new Point(R, C, 0);
        int cost = 0;

        // order 순열에서 다음 좌표 탐색
        for (Point next : order) {
            Queue<Point> q = new ArrayDeque<>();
            boolean[][] visited = new boolean[4][4];
            q.offer(start);
            visited[start.x][start.y] = true;
            while(!q.isEmpty()) {
                Point cur = q.poll();
                // 목표 좌표 도달 시 비용 + 1 후 cost에 누적
                if(cur.x == next.x && cur.y == next.y) {
                    cost += cur.cost + 1;
                    copy[next.x][next.y] = 0;
                    break;
                }
                // 일반 커서 옮기기
                for (int i = 0; i < 4; i++) {
                    int tempx = cur.x + dx[i];
                    int tempy = cur.y + dy[i];
                    if(tempx < 0 || tempx >= 4 || tempy < 0 || tempy >= 4) continue;
                    if(!visited[tempx][tempy]) {
                        visited[tempx][tempy] = true;
                        q.offer(new Point(tempx, tempy, cur.cost + 1));
                    }
                }
                // Ctrl 커서 옮기기
                for (int i = 0; i < 4; i++) {
                    int tempx = cur.x;
                    int tempy = cur.y;
                    while (true) {
                        // 경계 벗어나면 이전 값 넣기
                        if(tempx + dx[i] < 0 || tempx + dx[i] >= 4 || tempy + dy[i] < 0 || tempy + dy[i] >= 4) {
                            if(!visited[tempx][tempy]) {
                                visited[tempx][tempy] = true;
                                q.offer(new Point(tempx, tempy, cur.cost + 1));
                            }
                            break;
                        }
                        tempx += dx[i];
                        tempy += dy[i];

                        // 제일 가까운 카드 만나면 해당 좌표 넣기
                        if(copy[tempx][tempy] != 0) {
                            if(!visited[tempx][tempy]) {
                                visited[tempx][tempy] = true;
                                q.offer(new Point(tempx, tempy, cur.cost + 1));
                            }
                            break;
                        }
                    }
                }
            }
            // 목표로 했던 좌표를 시작점으로 세팅
            start = next;
            start.cost = 0;
        }
        return cost;
    }

    // 깊은 복사
    int[][] copyArr(int[][] arr) {
        int[][] copyArr = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                copyArr[i][j] = arr[i][j];
            }
        }
        return copyArr;
    }
}