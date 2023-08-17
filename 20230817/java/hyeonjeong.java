import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2636 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[][] board = new int[r][c];
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] edge = new int[r*c][2];
        int idx = 0;
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(board[i][j] == 1) {
                    edge[idx] = {i, j};
                    break;
                }
            }
        }
    }
}
