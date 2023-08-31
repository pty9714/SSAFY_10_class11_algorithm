import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B16236 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[][] board = new int[N][N];

        int posX = -1;
        int posY = -1;

        int[] dirX = { -1, 0, 1, 0 };
        int[] dirY = { 0, -1, 0, 1 };

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 9) {
                    posX = i;
                    posY = j;
                }
            }
        }

        int size = 2;
        int cnt = 0;
        int time = 0;
        boolean[][] visited = new boolean[N][N];

        Queue<int[]> q = new LinkedList<int[]>();
        q.offer(new int[] { posX, posY });
        board[posX][posY] = 0;
        visited[posX][posY] = true;

        while (!q.isEmpty()) {

            int[] cur = q.poll();

            if (board[cur[0]][cur[1]] < size) {
                while (!q.isEmpty()) {
                    int[] next = q.poll();
                    if (board[next[0]][next[1]] >= size)
                        continue;
                    if (next[0] < cur[0] || (next[0] == cur[0] && next[1] < cur[1])) {
                        cur[0] = next[0];
                        cur[1] = next[1];
                    }
                }
                board[cur[0]][cur[1]] = 0;
                visited = new boolean[N][N];
                visited[cur[0]][cur[1]] = true;
                cnt++;

                if (cnt == size) {
                    cnt = 0;
                    size++;
                }
            }

            for (int k = 0; k < 4; k++) {
                int ni = cur[0] + dirX[k];
                int nj = cur[1] + dirY[k];

                if (ni < 0 || ni >= N || nj < 0 || nj >= N || visited[ni][nj] || board[ni][nj] > size)
                    continue;
                q.offer(new int[] { ni, nj });
                visited[cur[0]][cur[1]] = true;
            }
        }
    }
}
