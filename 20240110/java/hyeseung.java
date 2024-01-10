import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int[][] cheese;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cheese = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                cheese[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        while (checkContinue()) {
            checkBlank();
            ArrayList<int[]> cells = bfs();
            removeCheese(cells);
            ans++;
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void checkBlank() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(cheese[i][j] == -1) cheese[i][j] = 0;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(cheese[i][j] == 0) {
                    boolean flag = true;
                    for (int k = 0; k < 4; k++) {
                        int tempX = i, tempY = j;
                        do {
                            tempX += dx[k];
                            tempY += dy[k];
                            if (tempX < 0 || tempX >= N || tempY < 0 || tempY >= M) {
                                flag = false;
                                break;
                            }
                        } while(cheese[tempX][tempY] == 0);
                    }
                    if(flag) cheese[i][j] = -1;
                }
            }
        }
    }

    private static ArrayList<int[]> bfs() {
        ArrayList<int[]> cells = new ArrayList<>();
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        q.offer(new int[] {0, 0});
        visited[0][0] = true;
        while(!q.isEmpty()) {
            int[] cell = q.poll();
            if(cheese[cell[0]][cell[1]] == 1 && isMelt(cell[0], cell[1])) cells.add(new int[] {cell[0], cell[1]});
            for (int i = 0; i < 4; i++) {
                int tempX = cell[0] + dx[i];
                int tempY = cell[1] + dy[i];
                if(tempX < 0 || tempX >= N || tempY < 0 || tempY >= M || visited[tempX][tempY]) continue;
                visited[tempX][tempY] = true;
                q.offer(new int[] {tempX, tempY});
            }
        }
        return cells;
    }

    private static void removeCheese(ArrayList<int[]> cells) {
        for (int[] cell : cells) {
            cheese[cell[0]][cell[1]] = 0;
        }
    }

    private static boolean isMelt(int x, int y) {
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            if(cheese[x+dx[i]][y+dy[i]] == 0) cnt++;
        }
        return cnt >= 2;
    }

    private static boolean checkContinue() {
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(cheese[i][j] == 1) {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }
}