import java.io.*;
import java.util.*;

public class B1202 {
    static class Jewel implements Comparable<Jewel> {
        int M;
        int V;
        Jewel(int M, int V) {
            this.M = M;
            this.V = V;
        }

        @Override
        public int compareTo(Jewel o) {
            if(this.M == o.M) {
                return o.V - this.V;
            }
            return o.M - this.M;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        PriorityQueue<Jewel> jewels = new PriorityQueue<Jewel>();
        Integer[] bags = new Integer[K];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewels.offer(new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bags, Collections.reverseOrder());


        bw.flush();
        bw.close();
        br.close();
    }
}
