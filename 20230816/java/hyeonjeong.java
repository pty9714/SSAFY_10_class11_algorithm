import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S1868 {

    static int N;
    static char[][] board;
    static int[] dirX = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dirY = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int cnt;
    static boolean zero;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            N = Integer.parseInt(br.readLine());

            board = new char[N][N];
            for(int i=0; i<N; i++) {
                board[i] = br.readLine().toCharArray();
            }

            cnt = 0;
            // 1. 근처에 지뢰 없는 칸 다 누르기 -> 0으로 표시, cnt+1
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if (board[i][j] == '.') {  // 지뢰 없는 칸이면 주변 8칸 탐색
                        zero = false;
                        check(i, j);
                        if (zero) cnt++;  // 통과했으면 cnt+1
                    }
                }
            }
            // 2. 남은 지뢰 없는 칸 누르기 -> 1으로 표시, cnt+1
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if (board[i][j] == '.') {
                        board[i][j] = '1';
                        cnt++;
                    }
                }
            }

            System.out.printf("#%d %d%n", tc, cnt);
        }
    }

    private static void check(int i, int j) {
        int x, y;
        for(int k=0; k<8; k++) {
            x = i + dirX[k];
            y = j + dirY[k];
            if (x<0 || x>=N || y<0 || y>=N) continue;
            if (board[x][y] == '*') {  // 주변에 지뢰 있으면 실패
                return;
            }
        }
        zero = true;  // 주변에 지뢰 없는 칸 있으면 true로 설정
        board[i][j] = '0';
        for(int k=0; k<8; k++) {  // 주변 칸 0으로 표시, 그 칸을 중심으로 다시 탐색
            x = i + dirX[k];
            y = j + dirY[k];
            if (x<0 || x>=N || y<0 || y>=N) continue;
            if (board[x][y] == '.') {
                board[x][y] = '0';
                check(x, y);
            }
        }
    }
}

// 29,420 kb    165 ms
