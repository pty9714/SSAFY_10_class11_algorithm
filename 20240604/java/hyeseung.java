import java.io.*;
import java.util.*;

// 	16148KB, 124ms
public class B14725 {
    static class Node {
        TreeMap<String, Node> tree = new TreeMap<>();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Node root = new Node();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            Node cur = root;
            for (int j = 0; j < T; j++) {
                String temp = st.nextToken();
                if(!cur.tree.containsKey(temp)) {
                    cur.tree.put(temp, new Node());
                }
                cur = cur.tree.get(temp);
            }
        }
        bw.write(dfs(root, ""));
        bw.flush();
        bw.close();
        br.close();
    }
    private static String dfs(Node cur, String depth) {
        StringBuilder temp = new StringBuilder();
        for(String key : cur.tree.keySet()) {
            temp.append(depth).append(key).append("\n");
            temp.append(dfs(cur.tree.get(key), depth + "--"));
        }
        return temp.toString();
    }
}
