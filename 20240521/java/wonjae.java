import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B2660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        Node[] club = new Node[n+1];
        for(int i = 0; i <= n ; i++){
            club[i] = new Node(i);
        }

        while(true){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a == -1 && b == -1) break;
            club[a].al.add(b);
            club[b].al.add(a);
        }

        int best = 51;
        ArrayList<Integer> best_list = new ArrayList<>();

        for(int i = 1; i <= n; i++){
            int cnt = 0;
            boolean[] visited = new boolean[n+1];
            PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> o1.y-o2.y);

            pq.offer(new Point(i, 0));
            visited[i] = true;

            Point curr = null;
            while (!pq.isEmpty()){
                curr = pq.poll();
                cnt = curr.y;

                for(int friend : club[curr.x].al){
                    if(!visited[friend]){
                        visited[friend] = true;
                        pq.offer(new Point(friend, curr.y+1));
                    }
                }
            }

            if(cnt == best){
                best_list.add(i);
            }
            else if(cnt < best){
                best = cnt;
                best_list.clear();
                best_list.add(i);
            }
        }
        sb.append(best).append(" ").append(best_list.size()).append('\n');
        best_list.sort((o1, o2) -> o1-o2);
        for(int bl : best_list){
            sb.append(bl).append(" ");
        }
        System.out.println(sb);
    }

    static class Node{
        int n;
        ArrayList<Integer> al = new ArrayList<>();

        Node(int n){
            this.n = n;
            this.al = new ArrayList<>();
        }
    }
}
