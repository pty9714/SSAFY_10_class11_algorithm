    import java.io.*;
    import java.util.*;

    public class Main {

        static class People {
            int start;
            int end;
            public People(int start, int end) {
                this.start = start;
                this.end = end;
            }
        }

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int n = Integer.parseInt(br.readLine());

            StringTokenizer st;
            List<People> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int h = Integer.parseInt(st.nextToken());
                int o = Integer.parseInt(st.nextToken());
                if (h > o) {
                    int tmp = h;
                    h = o;
                    o = tmp;
                }
                list.add(new People(h, o));
            }

            int d = Integer.parseInt(br.readLine());

            list.sort(Comparator.comparingInt(o -> o.end));
            PriorityQueue<Integer> q = new PriorityQueue<>();

            int ans = 0;
            for (People p : list) {
                while (!q.isEmpty() && (q.peek() < p.end - d)) {
                    q.poll();
                }
                if (p.start >= p.end - d) {
                    q.add(p.start);
                }
                ans = Math.max(ans, q.size());
            }

            bw.write(ans + "");
            bw.flush();
            bw.close();
            br.close();
        }

    }
