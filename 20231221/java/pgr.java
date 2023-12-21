import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Node[] arr = new Node[N+1];
        board = new int[B][A];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            String tmp = st.nextToken();
            int d;
            if (tmp.equals("N")) d = 0;
            else if (tmp.equals("E")) d = 1;
            else if (tmp.equals("S")) d = 2;
            else d = 3;
            int r = B - y;
            int c = x - 1;
            arr[i] = new Node(r, c, d);
            board[r][c] = i;
        }

        boolean flag = true;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            String b = st.nextToken();
            int c = Integer.parseInt(st.nextToken());
            if (b.equals("L") || b.equals("R")) {
                int newD = (arr[a].d + c) % 4;
                if (c % 2 == 1) {
                    if (b.equals("L")) {
                        newD = (newD + 2) % 4;
                    }
                }
                arr[a].d = newD;
            } else {
                int x = arr[a].x;
                int y = arr[a].y;
                int d = arr[a].d;
                for (int j = 0; j < c; j++) {
                    if (x + dx[d] >= 0 && x + dx[d] < B && y + dy[d] >= 0 && y + dy[d] < A) {
                        if (board[x+dx[d]][y+dy[d]] > 0) {
                            flag = false;
                            bw.write("Robot" + a + " crashes into robot " + board[x+dx[d]][y+dy[d]]);
                            break;
                        }
                        else {
                            board[x][y] = 0;
                            x = x + dx[d];
                            y = y + dy[d];
                            board[x][y] = a;
                        }
                    }
                    else {
                        flag = false;
                        bw.write("Robot " + a + " crashes into the wall");
                        break;
                    }
                }
                if (!flag) break;
            }
        }
        if (flag) bw.write("OK");
        bw.flush();
        bw.close();
        br.close();
    }

    public static class Node {
        int x;
        int y;
        int d;

        public Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}

//////////////시도한 예제

//3 3
//1 9
//2 2 W
//1 F 1
//1 L 1
//1 F 1
//1 L 1
//1 F 2
//1 L 5
//1 F 2
//1 R 3
//1 F 2
//ok
//
//5 4
//2 2
//1 1 E
//5 4 W
//1 F 7
//2 F 7
//Robot 1 crashes into the wall//
//
//5 4
//2 4
//1 1 E
//5 4 W
//1 F 3
//2 F 1
//1 L 1
//1 F 3
//Robot 1 crashes into robot 2
//
//5 4
//2 2
//1 1 E
//5 4 W
//1 L 96
//1 F 2
//OK//
//
//5 4
//2 3
//1 1 E
//5 4 W
//1 F 4
//1 L 1
//1 F 20
//Robot 1 crashes into robot 2
//
