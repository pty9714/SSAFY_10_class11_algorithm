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
        ArrayList<ArrayList<Point>> boardMatrix = new ArrayList<ArrayList<Point>>();
        ArrayList<ArrayList<Point>> tableMatrix = new ArrayList<ArrayList<Point>>();
        N = table.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 테이블 위에 놓인 퍼즐 조각 좌표 넣기
                if(table[i][j] == 1) {
                    tableMatrix.add(new ArrayList<Point>());
                    getPieces(0, i, j, table, tableMatrix);
                }
                // 게임보드의 빈 공간 좌표 넣기
                if(game_board[i][j] == 0) {
                    boardMatrix.add(new ArrayList<Point>());
                    getPieces(1, i, j, game_board, boardMatrix);
                }
            }
        }
        
        boolean[] visited = new boolean[boardMatrix.size()];
        int answer = 0;
        
        for (int i = 0; i < tableMatrix.size(); i++) {
            ArrayList<Point> tableList = tableMatrix.get(i);
            
            for (int j = 0; j < boardMatrix.size(); j++) {
                ArrayList<Point> boardList = boardMatrix.get(j);
                if (boardList.size() == tableList.size() && !visited[j]) {
                    if(check(boardList, tableList)) {
                        answer += tableList.size();
                        visited[j] = true;
                        break;
                    }
                }
            }
        }
        
        return answer;
    }
    public void getPieces(int pass, int x, int y, int[][] table, ArrayList<ArrayList<Point>> matrix) {
        int idx = matrix.size() - 1;
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        matrix.get(idx).add(new Point(0, 0));
        table[x][y] = pass;
        while(!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int tempx = p.x + dx[i];
                int tempy = p.y + dy[i];
                if(tempx < 0 || tempx >= N || tempy < 0 || tempy >= N || table[tempx][tempy] == pass) continue;
                matrix.get(idx).add(new Point(tempx - x, tempy - y));
                q.offer(new Point(tempx, tempy));
                table[tempx][tempy] = pass;
            }
        }
        Collections.sort(matrix.get(idx));
    }
    public boolean check(ArrayList<Point> boardList, ArrayList<Point> tableList) {
        for(int i = 0; i < 4; i++) {
            int x = tableList.get(0).x;
            int y = tableList.get(0).y;
            
            for (int j = 0; j < tableList.size(); j++) {
                tableList.get(j).x -= x;
                tableList.get(j).y -= y;
            }
            
            boolean isCheck = true;
            
            for (int j = 0; j < boardList.size(); j++) {
                Point boardP = boardList.get(j);
                Point tableP = tableList.get(j);
                if (boardP.x != tableP.x || boardP.y != tableP.y) {
                    isCheck = false;
                    break;
                }
            }
            
            if(isCheck) {
                return true;
            }
            else {
                for (int j = 0; j < tableList.size(); j++) {
                    int temp = tableList.get(j).x;
                    tableList.get(j).x = tableList.get(j).y;
                    tableList.get(j).y = -temp;
                }
                Collections.sort(tableList);
            }
        }
        return false;
    }
}