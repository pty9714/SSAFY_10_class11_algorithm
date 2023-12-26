import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1238 {

    static int INF = 1000001; // T <= 100, M <= 10,000
    static ArrayList<Point>[] villages_to, villages_from;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        // 1.각 마을로 들어가고 나가는 간선 연결

        villages_to = new ArrayList[n+1];
        villages_from = new ArrayList[n+1];
        for(int i = 1; i <= n;i++){
            villages_to[i] = new ArrayList<>();
            villages_from[i] = new ArrayList<>();
        }

        int s, e, t;
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            villages_to[s].add(new Point(t, e));
            villages_from[e].add(new Point(t, s));
        }

        // 2. x에서 각 마을까지의 최단거리와 x로의 각 마을의 최단거리를 확인

        int[] from_x = Dijkstra(x, n, villages_to);
        int[] to_x = Dijkstra(x, n, villages_from);


        // 3. 두 값이 최대인 거리를 출력
        int max = 0;
        for(int i = 1; i <= n; i++){
            if(from_x[i] + to_x[i] > max) max = from_x[i] + to_x[i];
        }
        System.out.println(max);
    }

    public static int[] Dijkstra(int x, int n,ArrayList<Point>[] al){
        int[] answer = new int[n+1];
        boolean[] visited = new boolean[n+1];
        PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> o1.x - o2.x);
        int cnt = 0;
        Point curr;
        pq.add(new Point(0, x));

        while(cnt < n){
            curr = pq.poll();
            if(visited[curr.y]) continue;
            visited[curr.y] = true;
            answer[curr.y] = curr.x;
            cnt++;

            for(Point p : al[curr.y]){
                if(visited[p.y]) continue;
                pq.add(new Point(curr.x + p.x, p.y));
            }
        }
        return answer;
    }
}
// 18972KB	212ms
