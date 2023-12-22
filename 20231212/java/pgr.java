import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] list;
    static boolean[] visited;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            Map<Integer, Integer> map = new HashMap<>();
            PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minQ = new PriorityQueue<>();
            int k = Integer.parseInt(br.readLine());
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                String order = st.nextToken();
                int n = Integer.parseInt(st.nextToken());
                switch (order) {
                    case "I" : {
                        map.put(n, map.getOrDefault(n, 0) + 1);
                        maxQ.add(n);
                        minQ.add(n);
                    }
                    break;
                    case "D" : {
                        if (map.isEmpty()) continue;
                        PriorityQueue q = n == 1 ? maxQ : minQ;
                        removeMap(q, map);
                    }
                    break;
                }
            }
            if (map.isEmpty()) bw.write("EMPTY\n");
            else {
                int n = removeMap(maxQ, map);
                bw.write(n + " " + (!map.isEmpty() ? removeMap(minQ, map) : n) + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int removeMap(PriorityQueue<Integer> q, Map<Integer, Integer> map) {
        int num;
        while (true) {
            num = q.poll();
            int cnt = map.getOrDefault(num, 0);
            if (cnt == 0) continue;
            else if (cnt == 1) map.remove(num);
            else map.put(num, cnt - 1);
            break;
        }
        return num;
    }
}
