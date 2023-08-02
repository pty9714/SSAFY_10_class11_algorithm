import java.util.*;

class Solution {
    static final int max_ = (int) 1e9;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
     
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int[][] B = new int[n][n];
            for (int i = 0; i < n; i++) {
                String inputRow = sc.next();
                for (int j = 0; j < n; j++) {
                    B[i][j] = Integer.parseInt(inputRow.substring(j, j + 1));
                }
            }
 
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{0, 0});
            int[][] visited = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(visited[i], max_);
            }
            visited[0][0] = B[0][0];
 
            while (!q.isEmpty()) {
                int[] curr = q.poll();
                int x = curr[0];
                int y = curr[1];
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                        if (visited[nx][ny] > visited[x][y] + B[nx][ny]) {
                            q.add(new int[]{nx, ny});
                            visited[nx][ny] = visited[x][y] + B[nx][ny];
                        }
                    }
                }
            }
            System.out.println("#" + test_case + " " + visited[n - 1][n - 1]);
        }
    }
}