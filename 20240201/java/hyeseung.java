import java.io.*;
import java.util.*;

// 	47760KB, 796ms
public class B21278 {

    static class Node {
        int A;
        int B;
        int hour = 0;
        Node(int A, int B, int hour) {
            this.A = A;
            this.B = B;
            this.hour = hour;
        }
    }
    public static int N, M, index1 = 0, index2 = 0, ans = Integer.MAX_VALUE;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Node>());
        }
        visited = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(A).add(new Node(A, B, 0));
            graph.get(B).add(new Node(B, A, 0));
        }

        dfs(1, 0);
        bw.write(index1 + " " + index2 + " " + ans);
        bw.flush();
        bw.close();
        br.close();
    }
    public static void dfs(int index, int cnt) {
        if(cnt == 2) {
            boolean[] notChicken = new boolean[N+1];
            Queue<Node> q = new ArrayDeque<>();
            int sum = 0;
            for (int i = 1; i <= N; i++) {
                if(visited[i]) {
                    q.offer(new Node(i, 0, 0));
                    notChicken[i] = true;
                }
            }

            while(!q.isEmpty()) {
                Node cur = q.poll();
                for (Node next : graph.get(cur.A)) {
                    if(!notChicken[next.B]) {
                        q.offer(new Node(next.B, 0, next.hour + 1));
                        notChicken[next.B] = true;
                        sum += (next.hour + 1) * 2;
                    }
                }
            }

            if(ans > sum) {
                ans = sum;
                index1 = 0;
                index2 = 0;
                for (int i = 1; i <= N; i++) {
                    if(visited[i]) {
                        if(index1 == 0) index1 = i;
                        else index2 = i;
                    }
                }
            }

            return;
        }

        for(int i = index; i <= N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(i + 1, cnt + 1);
                visited[i] = false;
            }
        }
    }
}
