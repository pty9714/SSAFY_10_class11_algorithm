import java.util.*;
class Solution {
    static class Point implements Comparable<Point> {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Point p) {
            if(this.x == p.x) return this.y - p.y;
            return this.x - p.x;
        }
    }
    public static int N;
    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = {0, 0, -1, 1};
    public int solution(int[][] game_board, int[][] table) {
        ArrayList<PriorityQueue<Point>> boardMatrix = new ArrayList<PriorityQueue<Point>>();
        ArrayList<PriorityQueue<Point>> tableMatrix = new ArrayList<PriorityQueue<Point>>();
        int answer = -1;
        N = table.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 테이블 위에 놓인 퍼즐 조각 좌표 넣기
                if(table[i][j] == 1) {
                    tableMatrix.add(new PriorityQueue<Point>());
                    getPieces(0, i, j, table, tableMatrix);
                }
                // 게임보드의 빈 공간 좌표 넣기
                if(game_board[i][j] == 0) {
                    boardMatrix.add(new PriorityQueue<Point>());
                    getPieces(1, i, j, game_board, boardMatrix);
                }
            }
        }
        for (int i = 0; i < boardMatrix.size(); i++) {
            while(!boardMatrix.get(i).isEmpty()) {
                Point temp = boardMatrix.get(i).poll();
                System.out.print(temp.x + " " + temp.y + "/");
            }
            System.out.println();
        }
        
        return answer;
    }
    public void getPieces(int pass, int x, int y, int[][] table, ArrayList<PriorityQueue<Point>> matrix) {
        int idx = matrix.size() - 1;
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        matrix.get(idx).offer(new Point(x, y));
        table[x][y] = pass;
        while(!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int tempx = p.x + dx[i];
                int tempy = p.y + dy[i];
                if(tempx < 0 || tempx >= N || tempy < 0 || tempy >= N || table[tempx][tempy] == pass) continue;
                matrix.get(idx).offer(new Point(tempx, tempy));
                q.offer(new Point(tempx, tempy));
                table[tempx][tempy] = pass;
            }
        }
    }
}
