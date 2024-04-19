import java.io.*;
import java.util.*;

// 18020KB, 132ms
public class B1194 {
    private static int N, M;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static char[][] miro;
    private static boolean[][][] visited;
    static class Point {
        int x;
        int y;
        int cnt;
        int key;
        Point(int x, int y, int cnt, int key) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.key = key;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        miro = new char[N][M];
        visited = new boolean[N][M][64];
        int startX = 0, startY = 0;
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                miro[i][j] = temp.charAt(j);
                if(miro[i][j] == '0') {
                    startX = i; startY = j;
                }
            }
        }
        bw.write(bfs(startX, startY) + "");
        bw.flush();
        bw.close();
        br.close();
    }
    private static int bfs(int x, int y) {
        int ans = Integer.MAX_VALUE;
        Queue<Point> q = new LinkedList<>();
        visited[x][y][0] = true;
        q.add(new Point(x, y, 0, 0));
        while(!q.isEmpty()) {
            Point cur = q.poll();
            if(miro[cur.x][cur.y] == '1') {
                ans = Math.min(ans, cur.cnt);
            }
            for (int i = 0; i < 4; i++) {
                int tempX = cur.x + dx[i];
                int tempY = cur.y + dy[i];
                if(tempX < 0 || tempX >= N || tempY < 0 || tempY >= M
                    || visited[tempX][tempY][cur.key] || miro[tempX][tempY] == '#') continue;
                if(miro[tempX][tempY] >= 'a' && miro[tempX][tempY] <= 'f') {
                    int tempKey = (1 << (miro[tempX][tempY] - 'a')) | cur.key;
                    if(!visited[tempX][tempY][tempKey]) {
                        visited[tempX][tempY][tempKey] = true;
                        q.add(new Point(tempX, tempY, cur.cnt + 1, tempKey));
                    }
                }
                else if(miro[tempX][tempY] >= 'A' && miro[tempX][tempY] <= 'F') {
                    int tempKey = 1 << (miro[tempX][tempY] - 'A');
                    if((cur.key & tempKey) == tempKey) {
                        visited[tempX][tempY][cur.key] = true;
                        q.add(new Point(tempX, tempY, cur.cnt + 1, cur.key));
                    }
                }
                else {
                    visited[tempX][tempY][cur.key] = true;
                    q.add(new Point(tempX, tempY, cur.cnt + 1, cur.key));
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
