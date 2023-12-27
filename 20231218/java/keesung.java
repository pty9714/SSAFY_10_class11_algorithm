import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        int M = Integer.valueOf(br.readLine());
        List<Node> nodes = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++) {
            nodes.add(new Node(i));
        }
        for (int i = 0; i < M; i++) {
            String[] split = br.readLine().split(" ");
            int parent = Integer.valueOf(split[0]);
            int child = Integer.valueOf(split[1]);
            nodes.get(parent).children.add(nodes.get(child));
            nodes.get(child).parents.add(nodes.get(parent));
        }

        for (int i = 1; i <= N; i++) {
            int result = N - 1;
            Node node = nodes.get(i);
            Set<Node> visited = new HashSet<>();
            Queue<Node> queue = new LinkedList<>();
            queue.add(node);
            while (!queue.isEmpty()) {
                Node poll = queue.poll();
                for (Node child : poll.children) {
                    if (!visited.contains(child)) {
                        queue.add(child);
                        visited.add(child);
                        result--;
                    }
                }
            }

            queue = new LinkedList<>();
            queue.add(node);
            while (!queue.isEmpty()) {
                Node poll = queue.poll();
                for (Node parent : poll.parents) {
                    if (!visited.contains(parent)) {
                        visited.add(parent);
                        queue.add(parent);
                        result--;
                    }
                }
            }
            System.out.println(result);
        }
    }

    public static class Node {
        List<Node> parents = new ArrayList<>();
        List<Node> children = new ArrayList<>();

        int index;

        public Node(int index) {
            this.index = index;
        }

    }

}

// 트리 개념 활용, 위로만 가고 아래로만 가게 해서 전체 탐색