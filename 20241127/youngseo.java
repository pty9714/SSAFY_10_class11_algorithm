import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon18809 {

    static int n;
    static int m;
    static int[][] map;
    static ArrayList<int[]> land;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken()); //초록 배양액
        int r = Integer.parseInt(st.nextToken()); //빨간 배양액

        map = new int[n][m];
        land = new ArrayList<>();
        answer = 0;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()); // 0 호수, 1 배양액 못뿌림, 2 배양액 뿌림
                if(map[i][j] == 2){
                    land.add(new int[]{i, j});
                }
            }
        }

        findLand(0,g,r);

        System.out.println(answer);

    }

    static void findLand(int index, int green, int red){
        if(green == 0 && red == 0){

            int k = find();
            answer = Math.max(answer, k);

            return;
        }

        for(int i=index; i<land.size(); i++){
            int[] cur = land.get(i);

            if(green > 0) {
                map[cur[0]][cur[1]] = 3; // g
                findLand(i+1, green-1, red);
                map[cur[0]][cur[1]] = 2;
            }

            if(red > 0) {
                map[cur[0]][cur[1]] = 4;
                findLand(i+1, green, red-1);
                map[cur[0]][cur[1]] = 2;
            }

        }

    }

    static int find(){
        int count = 0;

        int[][][] visited = new int[n][m][2];
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                visited[i][j][0] = -1;
                if(map[i][j] == 3 || map[i][j] == 4){
                    queue.add(new int[] {i,j,map[i][j],0});
                    visited[i][j][0] = 0;
                    visited[i][j][1] = map[i][j];
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (visited[cur[0]][cur[1]][1] == -1) {
                count++;
                continue;
            }

            for (int d = 0; d < 4; d++) {
                int x = cur[0] + dx[d];
                int y = cur[1] + dy[d];

                if (x >= 0 && x < n && y >= 0 && y < m && map[x][y] != 0) {
                    if (visited[x][y][0] == -1) {
                        queue.add(new int[]{x, y, map[x][y], cur[3] + 1});
                        visited[x][y][0] = cur[3] + 1;
                        visited[x][y][1] = cur[2];
                    }
                    else if (visited[x][y][0] == cur[3]+1) {
                        if (visited[x][y][1] != cur[2]) {
                            visited[x][y][1] = -1;
                        }
                    }
                }
            }
        }

        return count;
    }

}
