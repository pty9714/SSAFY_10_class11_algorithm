
import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B5549 {
    public static char[][] map;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        map = new char[M][N];
        for (int i = 0; i < M; i++) {
            String temp = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = temp.charAt(j);
            }
        }
        int[][] region = new int[K][4];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                region[i][j] = Integer.parseInt(st.nextToken()) - 1;
            }
        }
        for (int i = 0; i < K; i++) {
            int[] answer = bfs(region[i][0], region[i][1], region[i][2], region[i][3]);
            bw.write(answer[0] + " " + answer[1] + " " + answer[2] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static int[] bfs(int a, int b, int c, int d) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {a, b});
        boolean[][] visited = new boolean[c-a+1][d-b+1];
        int[] answer = new int[3];
        while(!q.isEmpty()) {
            int cur[] = q.poll();
            visited[cur[0]][cur[1]] = true;
            switch(map[cur[0]+a][cur[1]+b]) {
                case 'J' : answer[0]++; break;
                case 'O' : answer[1]++; break;
                case 'I' : answer[2]++; break;
            }
            for (int i = 0; i < 4; i++) {
                int tempx = cur[0] + dx[i];
                int tempy = cur[1] + dy[i];
                if(tempx < 0 || tempx >= c-a+1 || tempy < 0 || tempy >= d-a+1 || visited[tempx][tempy]) continue;
                q.offer(new int[] {tempx, tempy});
            }
        }
        return answer;
    }
}
