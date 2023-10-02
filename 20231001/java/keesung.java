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
// 테스트 1 〉 통과 (0.44ms, 76.9MB)
// 테스트 2 〉 통과 (0.31ms, 73MB)
// 테스트 3 〉 통과 (0.36ms, 67.8MB)
// 테스트 4 〉 통과 (0.52ms, 76MB)
// 테스트 5 〉 통과 (0.44ms, 75.9MB)
// 테스트 6 〉 통과 (16.53ms, 113MB)
// 테스트 7 〉 통과 (21.40ms, 96.6MB)
// 테스트 8 〉 통과 (19.07ms, 107MB)
// 테스트 9 〉 통과 (14.34ms, 96.1MB)
// 테스트 10 〉 통과 (12.12ms, 93.8MB)
// 테스트 11 〉 통과 (106.33ms, 172MB)
// 테스트 12 〉 통과 (187.06ms, 185MB)
// 테스트 13 〉 통과 (152.31ms, 193MB)
// 테스트 14 〉 통과 (174.49ms, 174MB)
// 테스트 15 〉 통과 (148.12ms, 184MB)
// 테스트 16 〉 통과 (43.05ms, 121MB)