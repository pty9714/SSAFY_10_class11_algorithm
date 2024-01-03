import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static int result = 0;
    public static int[][] map;
    public static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        visited[0][0] = true;
        dfs(0,0, map[0][0]);


        System.out.println(result);
    }

    public static void dfs(int x, int y, int value) {
        if(x == map.length-1 && y == map[0].length-1) {
            result++;
            return;
        }
        if (x + 1 < map.length && !visited[x + 1][y] && map[x + 1][y] < value) {
            visited[x + 1][y] = true;
            dfs(x + 1, y, map[x + 1][y]);
            visited[x + 1][y] = false;
        }
        if (y + 1 < map[0].length && !visited[x][y + 1] && map[x][y + 1] < value) {
            visited[x][y + 1] = true;
            dfs(x, y + 1, map[x][y + 1]);
            visited[x][y + 1] = false;
        }
        if (x - 1 >= 0 && !visited[x - 1][y] && map[x - 1][y] < value) {
            visited[x - 1][y] = true;
            dfs(x - 1, y, map[x - 1][y]);
            visited[x - 1][y] = false;
        }
        if (y - 1 >= 0 && !visited[x][y - 1] && map[x][y - 1] <  value) {
            visited[x][y - 1] = true;
            dfs(x, y - 1, map[x][y - 1]);
            visited[x][y - 1] = false;
        }
    }


}

