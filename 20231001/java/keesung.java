import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];

        ArrayList<Node> nodes = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            nodes.add(new Node(i));
        }

        for (int[] road : roads) {
            Node a = nodes.get(road[0]);
            Node b = nodes.get(road[1]);
            a.neighbors.add(b);
            b.neighbors.add(a);
        }

        boolean[] visited = new boolean[n + 1];

        Queue<Node> queue = new LinkedList<>();
        queue.offer(nodes.get(destination));
        nodes.get(destination).cost = 0;
        visited[destination] = true;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            // System.out.println("Node : " + node.index + " cost : " + node.cost);
            for (Node neighbor : node.neighbors) {
                if (visited[neighbor.index]) {
                    continue;
                }
                queue.offer(neighbor);
                neighbor.cost = node.cost + 1;
                visited[neighbor.index] = true;
            }
        }

        for (int i = 0; i < sources.length; i++) {
            answer[i] = nodes.get(sources[i]).cost;
        }

        return answer;
    }

    public static class Node {
        int index;
        int cost = -1;
        ArrayList<Node> neighbors = new ArrayList();

        public Node(int index) {
            this.index = index;
        }
    }
}

// 방문 처리를 거꾸로 생각하기, n이 10만개이고 소스가 500개 있으므로 500개 * n개의 지역을 방문처리하면서 체크하면 시간이 터짐