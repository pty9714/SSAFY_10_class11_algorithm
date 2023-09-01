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

        int posX = -1;  // 현재 위치
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

        int size = 2;  // 상어 크기
        int cnt = 0;  // 먹은 물고기 개수 (크기 업데이트용)
        int time = 0;  // 이동 시간
        int result = 0;  // 전체 시간
        boolean[][] visited = new boolean[N][N];

        Queue<int[]> q = new LinkedList<int[]>();
        q.offer(new int[] { posX, posY, time });
        board[posX][posY] = 0;
        visited[posX][posY] = true;

        while (!q.isEmpty()) {

            int[] cur = q.poll();
            posX = cur[0];
            posY = cur[1];
            time = cur[2];

            if (board[posX][posY] != 0 && board[posX][posY] < size) {  // 먹을 수 있는 물고기 만나면
                while (!q.isEmpty()) {
                    int[] next = q.poll();
                    if (next[2] > time) {  // 더 멀리 있는 칸 만나면 stop
                        q.clear();
                        break;
                    }
                    if (board[next[0]][next[1]] == 0 || board[next[0]][next[1]] >= size)  // 예외처리
                        continue;
                    if (next[0] < posX || (next[0] == posX && next[1] < posY)) {  // 비교
                        posX = next[0];
                        posY = next[1];
                    }
                }

                board[posX][posY] = 0;
                visited = new boolean[N][N];  // 리셋
                visited[posX][posY] = true;
                cnt++;
                result += time;
                time = 0;

                if (cnt == size) {  // 상어 크기 만큼의 물고기 개수 먹으면 사이즈업 
                    cnt = 0;
                    size++;
                }
            }

            for (int k = 0; k < 4; k++) {
                int ni = posX + dirX[k];
                int nj = posY + dirY[k];

                if (ni < 0 || ni >= N || nj < 0 || nj >= N || visited[ni][nj] || board[ni][nj] > size)
                    continue;
                q.offer(new int[] { ni, nj, time + 1 });
                visited[ni][nj] = true;
            }
        }
        System.out.println(result);
    }
}

// 14648 KB	128 ms
