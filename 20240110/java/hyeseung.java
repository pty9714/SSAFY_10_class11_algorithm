import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

// 53076KB, 332ms
public class B2638 {
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
        while (true) {
            checkOutsideAir(); // 외부 공기 체크
            ArrayList<int[]> cells = bfs(); // 녹을 수 있는 치즈 체크
            if(cells.isEmpty()) break; // 더이상 녹을 치즈가 없다면
            meltCheese(cells); // 녹을 수 있는 치즈 녹이기
            ans++; // 시간 증가
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }

    // 치즈 만날 경우 큐에 안넣음
    private static void checkOutsideAir() {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        q.offer(new int[] {0, 0});
        visited[0][0] = true;
        while(!q.isEmpty()) {
            int[] cell = q.poll();
            cheese[cell[0]][cell[1]] = -1;
            for (int i = 0; i < 4; i++) {
                int tempX = cell[0] + dx[i];
                int tempY = cell[1] + dy[i];
                if(tempX < 0 || tempX >= N || tempY < 0 || tempY >= M || visited[tempX][tempY]) continue;
                visited[tempX][tempY] = true;
                if(cheese[tempX][tempY] != 1) {
                    q.offer(new int[] {tempX, tempY});
                }
            }
        }
    }

    // 녹일 수 있는 치즈인지 완전 탐색으로 확인한 후 배열에 삽입
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

    // 좌표 배열에 담긴 녹일 수 있는 치즈들 녹이는 함수(바로 외부 공기로 전환)
    private static void meltCheese(ArrayList<int[]> cells) {
        for (int[] cell : cells) {
            cheese[cell[0]][cell[1]] = -1;
        }
    }

    // 각 치즈 격자의 4변 중 적어도 2변 이상 외부 공기와 접촉 여부 반환하는 함수
    private static boolean isMelt(int x, int y) {
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            if (x + dx[i] < 0 || x + dx[i] >= N || y + dy[i] < 0 || y + dy[i] >= M) continue;
            if (cheese[x + dx[i]][y + dy[i]] == -1) cnt++;
        }
        return cnt >= 2;
    }
}
/*
bfs
-> 외부 공기 말고 내부 공기를 찾는 방식으로 했는데 잘 못 찾는 문제가 있었음 bfs로 외부 공기 체크 하는 방식으로 바꿈
-> 1. 외부 공기 bfs로 탐색 2. 격자 중 녹일 수 있는 치즈 찾기 3. 녹일 수 있는 치즈 없는 경우 반복문 종료 4. 있으면 치즈 녹이고 1부터 반복
 */