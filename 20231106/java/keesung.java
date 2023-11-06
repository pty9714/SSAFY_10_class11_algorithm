import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main2 {

    public static boolean[] visited;
    public static ArrayList<Node> nodeList = new ArrayList<>();
    public static int maxNode = 0;

    public static int result = 0;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
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

        visited = new boolean[V + 1];
        visited[1] = true;
        dfs(1, 0);

        visited = new boolean[V + 1];
        visited[maxNode] = true;
        dfs(maxNode, 0);
        System.out.println(result);

    }

    private static void dfs(int i, int cost) {
        if (result < cost) {
            result = cost;
            maxNode = i;
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

// 103792kb 804ms
// 처음에 제일 먼거리로 가서, 두번째에 다시 제일 먼거리로 가면 항상 제일 먼곳이 나온다는 알고리즘 생각해야 함