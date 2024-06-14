import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class B2668 {
    private static int[] numbers;
    private static int N;
    private static boolean[] visited;
    private static List<Integer> set = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        numbers = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }
        bw.write(set.size() + "\n");
        for (int i = 0; i < set.size(); i++) {
            bw.write(set.get(i) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    private static void dfs(int index, int start) {
        if(!visited[numbers[index]]) {
            visited[numbers[index]] = true;
            dfs(numbers[index], start);
            visited[numbers[index]] = false;
        }
        if(numbers[index] == start) {
            set.add(numbers[index]);
        }
    }
}
