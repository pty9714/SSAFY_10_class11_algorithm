import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1446 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[d+1];

        ArrayList<Point>[] road = new ArrayList[d+1];
        for(int i = 0; i <= d; i++){
            road[i] = new ArrayList<>();
        }

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a <= d && b <= d && b-a >= c) road[b].add(new Point(a, c));
        }

        PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> o1.y-o2.y);

        pq.offer(new Point(d, 0));

        Point curr;
        while (!pq.isEmpty()){
            curr = pq.poll();
            if(visited[curr.x]) continue;
            visited[curr.x] = true;
            if(curr.x == 0){
                System.out.println(curr.y);
                break;
            }
            pq.offer(new Point(curr.x-1, curr.y+1));
            for(Point p : road[curr.x]){
                pq.offer(new Point(p.x, curr.y+p.y));
            }
        }
    }
}
