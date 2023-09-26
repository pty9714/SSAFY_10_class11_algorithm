import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {

    public static ArrayList<Node> nodes;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        // boolean[] visitedA = new boolean[n+1];
        // boolean[] visitedB = new boolean[n+1];
        // boolean[] visitedC = new boolean[n+1]; // A와 B사이 거리, A 에서 시작
        // visitedA[s] = true;
        // visitedB[s] = true;
        // visitedC[a] = true;
        nodes = new ArrayList<>(n);
        nodes.add(new Node(0));
        for (int i = 1; i <= n; i++) {
            nodes.add(new Node(i));
        }

        for (int[] arr : fares) {
            Node nodeA = nodes.get(arr[0]);
            Node nodeB = nodes.get(arr[1]);
            int cost = arr[2];
            nodeA.friends.add(nodeB);
            nodeA.costs.add(cost);
            nodeB.friends.add(nodeA);
            nodeB.costs.add(cost);
        }
        int aCost = getMinLength(n, s, a);
        int bCost = getMinLength(n, s, b);
        int cCost = getMinLength(n, b, a);
        System.out.println(aCost + " " + bCost + " " + cCost);
        if (aCost < bCost) {
            answer += aCost;
        } else {
            answer += bCost;
        }
        answer += cCost;

        return answer;
    }

    public static class Node {
        int index;
        ArrayList<Node> friends = new ArrayList<>();
        ArrayList<Integer> costs = new ArrayList<>();

        public Node(int index) {
            this.index = index;
        }
    }

    public static class Case implements Comparable<Case> {
        int index;
        int cost;

        Case(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        public int compareTo(Case o1) {
            return this.cost - o1.cost;
        }
    }

    public static int getMinLength(int n, int start, int end) {
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<Case> queue = new PriorityQueue<>();
        queue.offer(new Case(start, 0));
        while (!queue.isEmpty()) {
            Case obj = queue.poll();
            int index = obj.index;
            visited[index] = true;
            int cost = obj.cost;
            System.out.println(index + " " + cost);
            if (index == end) {
                return cost;
            }
            Node node = nodes.get(index);
            for (int i = 0; i < node.friends.size(); i++) {
                Node friend = node.friends.get(i);
                if (visited[friend.index]) {
                    continue;
                }
                int newCost = cost + node.costs.get(i);
                queue.offer(new Case(friend.index, newCost));
            }

        }
        return 100000000;
    }

}

// 실패코드 문제 잘못 읽음