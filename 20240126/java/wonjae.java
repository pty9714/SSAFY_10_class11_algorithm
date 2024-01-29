import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];

        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }

        PriorityQueue<Road> pq = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            pq.add(new Road(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int answer = 0;
        int cnt = 0;


        while (!pq.isEmpty() && cnt < n-2){
            Road r = pq.poll();
            if(find(r.a) != find(r.b)){
                union(r.a, r.b);
                answer += r.dist;
                cnt++;
            }
        }

        System.out.println(answer);

    }

    static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x != y) parent[y] = x;
    }

    static class Road{
        int a;
        int b;
        int dist;

        public Road(int a, int b, int dist){
            this.a = a;
            this.b = b;
            this.dist = dist;
        }
    }
}
