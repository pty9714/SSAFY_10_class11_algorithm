import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B3190 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[][] field = new int[n+2][n+2];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        for(int i = 0; i < n+2; i++){
            field[i][0] = field[i][n+1] = -1;
            field[0][i] = field[n+1][i] = -1;
        }

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());

        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            field[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }

        st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());

        int[] time = new int[10001];

        for(int i = 0; i < l; i++){
            st = new StringTokenizer(br.readLine());
            time[Integer.parseInt(st.nextToken())] = st.nextToken().charAt(0);
        }

        int x = 1, y = 1, dir = 0, t = 0;
        // 뱀길이
        int[][] snake = new int[n*n][2];
        int head = 0, tail = 0;
        snake[head][0] = x;
        snake[head][1] = y;
        field[x][y] = -1;

        while(true){
            t++;
            x += dx[dir];
            y += dy[dir];

            if(field[x][y] == -1){
                break;
            }

            if(field[x][y] == 0){
                field[snake[tail][0]][snake[tail][1]] = 0;
                tail++;
            }

            head++;
            snake[head][0] = x;
            snake[head][1] = y;
            field[x][y] = -1;

            if(time[t] == 'L'){
                dir = (dir + 3) % 4;
            } else if(time[t] == 'D'){
                dir = (dir + 1) % 4;
            }
        }

        System.out.println(t);

    }
}
