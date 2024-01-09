import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[][] cheese = new boolean[N][M];
        int count = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int j = 0;
            while (st.hasMoreTokens()) {
                boolean check = Integer.parseInt(st.nextToken()) == 1;
                cheese[i][j++] = check;
                if (check) {
                    count++;
                }
            }
        }
        int time = 0;

        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        int[][] condition = new int[N][M];
        while (count > 0) {
            time++;
            queue.add(new Point(0, 0));
            visited[0][0] = true;
            while (!queue.isEmpty()) {
                Point point = queue.poll();
                int x = point.x;
                int y = point.y;
                if (x > 0) {
                    if (cheese[x - 1][y]) {
                        condition[x - 1][y]++;
                    } else if (!visited[x - 1][y]) {
                        queue.add(new Point(x - 1, y));
                        visited[x - 1][y] = true;
                    }
                }
                if (x < N - 1) {
                    if (cheese[x + 1][y]) {
                        condition[x + 1][y]++;
                    } else if (!visited[x + 1][y]) {
                        queue.add(new Point(x + 1, y));
                        visited[x + 1][y] = true;
                    }
                }
                if (y > 0) {
                    if (cheese[x][y - 1]) {
                        condition[x][y - 1]++;
                    } else if (!visited[x][y - 1]) {
                        queue.add(new Point(x, y - 1));
                        visited[x][y - 1] = true;
                    }
                }
                if (y < M - 1) {
                    if (cheese[x][y + 1]) {
                        condition[x][y + 1]++;
                    } else if (!visited[x][y + 1]) {
                        queue.add(new Point(x, y + 1));
                        visited[x][y + 1] = true;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (condition[i][j] >= 2) {
                        cheese[i][j] = false;
                        count--;
                    }
                }
            }

            condition = new int[N][M];
            visited = new boolean[N][M];
        }

        System.out.println(time);
    }

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}

// 풀긴 했는데 좀 이상함
// 0,0부터 시작해서 치즈를 공기에 노출 되는 것만 카운트 했음.
// 그런데 0,0만 비어있고 [N-1][0], [N-2][0], [N-1][1] 3개가 비어있다면? 무한 루프를 돌게 됨.
// 그럼에도 코드는 통과가 돼서 조금 이상함
// 틀릴 줄 알았는데 문제가 조금 이상한 것 같음