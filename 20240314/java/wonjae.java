import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B12851 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int answer = 100001;
        int cnt = 0;
        int[] visited = new int[100001];
        for(int i = 0; i < 100001; i++){
            visited[i] = 100001;
        }

        PriorityQueue<Point> pq = new PriorityQueue<>(((o1, o2) -> o1.y-o2.y));
        pq.offer(new Point(n,0));
        visited[n] = 0;
        Point curr;
        while (!pq.isEmpty()){
            curr = pq.poll();
            if(curr.y > answer) break;
            if(curr.x == k && curr.y == answer) {
                cnt++;
                continue;
            }
            if(curr.x == k && answer == 100001){
                answer = curr.y;
                cnt++;
                continue;
            }
            if(curr.x-1 >= 0 && curr.y < visited[curr.x-1]) {
                visited[curr.x-1] = curr.y+1;
                pq.offer(new Point(curr.x-1, curr.y+1));
            }
            if(curr.x+1 < 100001 && curr.y < visited[curr.x+1]) {
                pq.offer(new Point(curr.x+1, curr.y+1));
                visited[curr.x+1] = curr.y+1;
            }
            if(curr.x*2 < 100001 && curr.y < visited[curr.x*2]) {
                pq.offer(new Point(curr.x*2, curr.y+1));
                visited[curr.x*2] = curr.y+1;
            }
        }
        System.out.println(answer);
        System.out.println(cnt);
    }
}
