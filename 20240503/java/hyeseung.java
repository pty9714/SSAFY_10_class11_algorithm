import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
// 406904KB, 1996ms
public class B2533 {
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static boolean[] adaptor, visited;
    private static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        adaptor = new boolean[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 1; i <= N; i++) {
            if(!adaptor[i]) {
                dfs(i, i);
            }
        }
        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
    private static void dfs(int first, int middle) {
        for (int last : graph.get(middle)) {
            if(first == last || adaptor[middle] || visited[last]) continue;
            visited[middle] = true;
            dfs(middle, last);
            if(!adaptor[first] && !adaptor[last]) {
                adaptor[middle] = true;
                answer++;
            }
        }
    }
}
