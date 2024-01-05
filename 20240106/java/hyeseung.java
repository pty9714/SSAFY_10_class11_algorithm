import java.io.*;
import java.util.*;

// 293904KB, 504ms
public class B16234 {
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
        // 한 번 반복문 돌 때마다 하루 지남
        while(true) {
            boolean flag = false; // 인구 이동이 없는지 체크
            boolean[][] visited = new boolean[N][N];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if(!visited[r][c]) {
                        // 연합 찾기
                        ArrayList<int[]> union = findUnion(r, c, visited);
                        // 연합 있으면 인구 이동
                        if(!union.isEmpty()) {
                            flag = true;
                            movePopulation(union);
                        }
                    }
                }
            }
            if(!flag) break; // 연합 없으면 반복문 중단
            ans++; // 하루 증가
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }

    // 연합 찾기
    private static ArrayList<int[]> findUnion(int r, int c, boolean[][] visited) {
        ArrayList<int[]> union = new ArrayList<>(); // 연합에 속한 나라의 좌표 배열
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

    // 연합 찾으면 인구 이동
    private static void movePopulation(ArrayList<int[]> union) {
        int sum = 0; // 연합 인구수
        int cnt = union.size(); // 연합을 이루고 있는 칸의 개수
        // 연합 인구수 합 구하기
        for (int[] point : union) {
            sum += country[point[0]][point[1]];
        }
        // 인구 이동 UPDATE
        for (int[] point : union) {
            country[point[0]][point[1]] = sum / cnt;
        }
    }
}
/*
bfs
-> bfs로 연합 찾아서 배열에 넣은 후 인구 이동
 */