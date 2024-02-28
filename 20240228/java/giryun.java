import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] parent = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    union(parent, i + 1, j + 1);
                }
            }
        }

        int[] path = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            path[i] = Integer.parseInt(st.nextToken());
        }
        int start = find(parent, path[0]);
        String answer = "YES";
        for (int i = 1; i < m; i++) {
            if (find(parent, path[i]) != start) {
                answer = "NO";
                break;
            }
        }

        bw.write(answer);
        bw.flush();
        br.close();
        bw.close();
    }

    static int find(int[] parent, int x) {
        if (parent[x] != x) {
            return find(parent, parent[x]);
        }
        return parent[x];
    }

    static void union(int[] parent, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }
}
