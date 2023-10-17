import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int answer;
    static HashMap<Integer, Integer> map;
    static boolean[] visited = new boolean[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new HashMap<>();
        int x, y;
        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            map.put(x, y);
        }
        answer = 10000;
        bfs();
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add((new Point(1, 0)));
        visited[1] = true;
        while (!q.isEmpty()) {
            Point p = q.poll();
            if (p.x == 100) {
                answer = Math.min(answer, p.y);
                continue;
            }
            for (int i = 1; i <= 6; i++) {
                int nx = p.x + i;
                if (nx <= 100 && !visited[nx]) {
                    visited[nx] = true;
                    if (map.containsKey(nx)) {
                        nx = map.get(nx);
                        visited[nx] = true;
                    }
                    q.add(new Point(nx, p.y + 1));
                }
            }
        }
    }
}
//11828KB, 84ms
