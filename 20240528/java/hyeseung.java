import java.io.*;
import java.util.*;

public class Main {
    public static int[][] country;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int N, L, R;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        country = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                country[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        while(true) {
            boolean flag = false;
            boolean[][] visited = new boolean[N][N];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if(!visited[r][c]) {
                        ArrayList<int[]> union = findUnion(r, c, visited);
                        if(!union.isEmpty()) {
                            flag = true;
                            movePopulation(union);
                        }
                    }
                }
            }
            if(!flag) break;
            ans++;
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
    private static ArrayList<int[]> findUnion(int r, int c, boolean[][] visited) {
        ArrayList<int[]> union = new ArrayList<>();
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {r, c});
        visited[r][c] = true;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0 ; i < 4; i++) {
                int tempX = cur[0] + dx[i];
                int tempY = cur[1] + dy[i];
                if(tempX < 0 || tempY < 0 || tempX >= N || tempY >= N || visited[tempX][tempY]) continue;
                int diff = Math.abs(country[cur[0]][cur[1]] - country[tempX][tempY]);
                if(diff >= L && diff <= R) {
                    visited[tempX][tempY] = true;
                    q.offer(new int[]{tempX, tempY});
                    union.add(new int[]{tempX, tempY});
                }
            }
        }
        if(!union.isEmpty()) union.add(new int[] {r, c});
        return union;
    }
    private static void movePopulation(ArrayList<int[]> union) {
        int sum = 0;
        int cnt = union.size();
        for (int[] point : union) {
            sum += country[point[0]][point[1]];
        }
        for (int[] point : union) {
            country[point[0]][point[1]] = sum / cnt;
        }
    }
}