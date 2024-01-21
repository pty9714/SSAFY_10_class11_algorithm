
import java.io.*;
import java.util.*;

// 122104KB, 1152ms
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
			if(o.M == this.M) {
                return o.V - this.V;
            }
            return this.M - o.M;
		}
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        PriorityQueue<Jewel> jewels = new PriorityQueue<Jewel>();
        int[] bags = new int[K];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewels.offer(new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bags);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long ans = 0;
        for (int i = 0; i < K; i++) {
			while(!jewels.isEmpty() && jewels.peek().M <= bags[i]) {
				pq.offer(jewels.poll().V);
			}
			if(!pq.isEmpty()) {
				ans += pq.poll();
			}
		}

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
/*
그리디 + pq
-> 보석은 pq에 담아 무게 기준 오름차순, 가격 기준 내림차순 정렬 & 가방은 오름차순 정렬(그리디)
무게 작은 순서대로 넣어야 더 무거운 무게를 넣을 수 있음
*/