import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B13334 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d;
        Point[] s = new Point[n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a < b) s[i] = new Point(a, b);
            else s[i] = new Point(b, a);
        }

        d = Integer.parseInt(br.readLine());

        Arrays.sort(s, Comparator.comparingInt(p -> p.y));

        int max = 0;
        int start;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++) {
            pq.add(s[i].x);
            start = s[i].y - d;
            while (!pq.isEmpty() && pq.peek() < start) {
                pq.poll();
            }
            if (max < pq.size()) max = pq.size();
        }
        System.out.println(max);
    }
}
/*
    54680KB	876ms
 */
