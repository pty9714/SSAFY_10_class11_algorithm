import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int A, B;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] board;
    static Map<Integer, Robot> robots = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        board = new int[A][B];

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int d = -1;
            switch (st.nextToken()) {
                case "N" : d = 0; break;
                case "E" : d = 1; break;
                case "S" : d = 2; break;
                case "W" : d = 3; break;
            }
            board[x][y] = i;
            robots.put(i, new Robot(x, y, d));
        }

        String ans = "OK";
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            String order = st.nextToken();
            int repeat = Integer.parseInt(st.nextToken());
            String res = Order(idx, order, repeat);
            if (!res.equals("pass")) {
                ans = res;
                break;
            }
        }
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
    public static String Order(int idx, String order, int repeat ) {
        String res = "pass";
        Robot robot = robots.get(idx);
        switch (order) {
            case "L":
                for (int i = 0; i < repeat; i++) {
                    robot.d = robot.d == 0 ? 3 : robot.d - 1;
                }
                break;
            case "R":
                for (int i = 0; i < repeat; i++) {
                    robot.d = (robot.d + 1) % 4;
                }
                break;
            case "F":
                for (int i = 0; i < repeat; i++) {
                    int nx = robot.x + dx[robot.d];
                    int ny = robot.y + dy[robot.d];
                    if (nx < 0 || nx >= A || ny < 0 || ny >= B) {
                        res = "Robot " + idx + " crashes into the wall";
                        break;
                    }
                    else if (board[nx][ny] > 0) {
                        res = "Robot " + idx + " crashes into robot " + board[nx][ny];
                        break;
                    }
                    else {
                        board[robot.x][robot.y] = 0;
                        board[nx][ny] = idx;
                        robot.x = nx;
                        robot.y = ny;
                    }
                }
                break;
        }
        return res;
    }

    static class Robot {
        int x;
        int y;
        int d;
        Robot(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}
// 6시간만에 고침;; 그런데 이전 코드에서 리팩토링한 차이밖에 없는데 왜 되는 지 잘 모르겠음;; 혜승이의 switch 코드가 깔끔한 것 같아 리팩토링할때 참고했음
