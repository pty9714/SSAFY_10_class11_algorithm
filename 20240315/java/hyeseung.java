import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B14570 {
    private static ArrayList<ArrayList<Integer>> tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            tree.get(i).add(Integer.parseInt(st.nextToken()));
            tree.get(i).add(Integer.parseInt(st.nextToken()));
        }

        long K = Long.parseLong(br.readLine());
        bw.write(dfs(1, K));

        bw.flush();
        bw.close();
        br.close();
    }
    private static int dfs(int index, long K) {
        int left = 0, right = 0;
        for (int element : tree.get(index)) {
            left = element;
            right = element;
        }
        if(left == -1 && right == -1) {
            return index;
        }
        else if(left != -1 && right != -1) {
            if(K % 2 == 1) return dfs(left, K/2 + 1);
            else return dfs(right, K/2);
        }
        else if(left == -1) {
            return dfs(right, K);
        }
        else if(right == -1) {
            return dfs(left, K);
        }
        return 0;
    }
}
