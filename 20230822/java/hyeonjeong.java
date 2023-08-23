import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class S2819 {

    static int[] dirX = {0, 1, 0, -1};
    static int[] dirY = {1, 0, -1, 0};
    static HashSet<String> set;
    static int[] num;
    static int[][] board;
    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());

        for(int tc=1; tc<=T; tc++) {

            board = new int[4][4];
            set = new HashSet<>();
            num = new int[7];

            StringTokenizer st;
            for(int i=0; i<4; i++) {
                st = new StringTokenizer(in.readLine());
                for(int j=0; j<4; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<4; i++) {
                for(int j=0; j<4; j++) {
                    dfs(i, j, 1);
                }
            }

            System.out.printf("#%d %d\n", tc, set.size());

        }
        
    }

    static void dfs(int x, int y, int cnt) {
        num[cnt-1] = board[x][y];

        if(cnt==7) {
            String temp = "";
            for (int n : num) temp += n;
            set.add(temp);
            return;
        }

        int nx, ny;
        for(int k=0; k<4; k++) {
            nx = x + dirX[k];
            ny = y + dirY[k];
            if(nx<0 || nx>=4 || ny<0 || ny>=4) continue;
            dfs(nx, ny, cnt+1);
        }
    }
}

// 91,292 kb 268 ms
