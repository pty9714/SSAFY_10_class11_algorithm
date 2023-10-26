import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static class Node implements Comparable<Node>{
        private int no, s, e;

        public Node(int no, int s, int e) {
            this.no = no;
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Node n) {
            return this.s - n.s;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int no = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.add(new Node(no, s, e));
        }
        Collections.sort(list);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            Node now = list.get(i);
            while (!pq.isEmpty() && pq.peek() <= now.s) {
                pq.poll();
            }
            pq.add(now.e);
            ans = Math.max(ans, pq.size());
        }
        bw.write(ans+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
//	57948	728
