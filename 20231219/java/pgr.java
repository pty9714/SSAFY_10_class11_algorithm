import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        boolean[][] dp = new boolean[1001][1001];
        dp[1][0] = true;
        Deque<Node> q = new ArrayDeque<>();
        q.add(new Node(1, 0, 0));

        while (!q.isEmpty()) {
            Node n = q.poll();

            if (n.x == N) {
                bw.write(n.z + "\n");
                bw.flush();
                bw.close();
                br.close();
                return;
            }

            //1.화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.
            q.add(new Node(n.x, n.x, n.z+1));

            //2.클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
            if (n.x + n.y <= N && !dp[n.x+n.y][n.y]) {
                dp[n.x+n.y][n.y] = true;
                q.add(new Node(n.x + n.y, n.y, n.z + 1));
            }

            //3.화면에 있는 이모티콘 중 하나를 삭제한다.
            if (n.x >= 1 && !dp[n.x-1][n.y]) {
                dp[n.x-1][n.y] = true;
                q.add(new Node(n.x - 1, n.y, n.z + 1));
            }
        }
    }

    public static class Node {
        int x;
        int y;
        int z;

        public Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
//14524	100
