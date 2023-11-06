import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main2 {

    public static boolean[] visited;
    public static ArrayList<Node> nodeList = new ArrayList<>();

    public static int result = 0;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        visited = new boolean[V + 1];
        nodeList.add(new Node(0));
        for (int i = 1; i <= V; i++) {
            nodeList.add(new Node(i));
        }
        for (int i = 1; i <= V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            while (true) {
                int nextIndex = Integer.parseInt(st.nextToken());
                if (nextIndex == -1) {
                    break;
                }
                int length = Integer.parseInt(st.nextToken());
                nodeList.get(index).neighbor.add(new int[] { nextIndex, length });
            }
        }

        for (int i = 1; i <= V; i++) {
            visited[i] = true;
            dfs(i, 0);
            visited[i] = false;
        }
        System.out.println(result);

    }

    private static void dfs(int i, int cost) {
        if (result < cost) {
            result = cost;
        }
        for (int[] next : nodeList.get(i).neighbor) {
            if (!visited[next[0]]) {
                visited[next[0]] = true;
                dfs(next[0], cost + next[1]);
                visited[next[0]] = false;
            }
        }
    }

    public static class Node {
        int index;
        ArrayList<int[]> neighbor = new ArrayList<>();

        public Node(int index) {
            this.index = index;
        }
    }
}

// 시간초과