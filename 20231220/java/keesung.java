import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class keesung {

    public static ArrayList<Node> nodes = new ArrayList<>();
    public static boolean[] visited;

    public static int max = 0;
    public static int maxIndex = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            nodes.add(new Node(i));
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            Node nodeA = nodes.get(A);
            Node nodeB = nodes.get(B);
            nodeA.addAdjacentNode(nodeB, length);
            nodeB.addAdjacentNode(nodeA, length);
        }

        Node startNode = nodes.get(1);
        visited[1] = true;

        dfs(startNode, 0);
        visited = new boolean[N + 1];
        Node newStartNode = nodes.get(maxIndex);
        visited[maxIndex] = true;
        dfs(newStartNode, 0);

        System.out.println(max);
    }

    private static void dfs(Node startNode, int length) {
        if (length > max) {
            max = length;
            maxIndex = startNode.getIndex();
        }
        Set<Node> adjacentNodes = startNode.getAdjacentNodes();
        for (Node node : adjacentNodes) {
            if (!visited[node.getIndex()]) {
                visited[node.getIndex()] = true;
                dfs(node, length + startNode.getDistance(node));
            }
        }

    }

    public static class Node {
        private Map<Node, Integer> adjacentNodes = new HashMap<>();
        private final int index;

        public Node(int index) {
            this.index = index;
        }

        public void addAdjacentNode(Node node, int length) {
            adjacentNodes.put(node, length);
        }

        public void addAdjacentNode(int index, int length) {
            addAdjacentNode(nodes.get(index), length);
        }

        public int getIndex() {
            return index;
        }

        public Set<Node> getAdjacentNodes() {
            return adjacentNodes.keySet();
        }

        public int getDistance(Node node) {
            return adjacentNodes.get(node);
        }

    }

}

// 메모리 21684KB, 시간 228ms
// 객체지향 적으로 풀기위해 노력
