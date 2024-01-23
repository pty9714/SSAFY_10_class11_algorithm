import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B5549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(br.readLine());

        char[][] map = new char[m+1][n+1];
        int[][][] info = new int[m+1][n+1][3];

        for(int i = 1; i <= m; i++){
            String s = br.readLine();
            char curr;
            for(int j = 1; j <= n; j++){
                curr = s.charAt(j-1);
                map[i][j] = curr;
                for(int l = 0; l < 3; l++){
                    info[i][j][l] = info[i-1][j][l] + info[i][j-1][l] - info[i-1][j-1][l];
                }
                if(curr == 'J') info[i][j][0]++;
                if(curr == 'O') info[i][j][1]++;
                if(curr == 'I') info[i][j][2]++;
            }
        }

        int[] answer = new int[3];

        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            for(int j = 0; j < 3; j++){
                answer[j] = info[c][d][j] - info[c][b-1][j] - info[a-1][d][j] + info[a-1][b-1][j];
            }
            System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
        }

    }
}
