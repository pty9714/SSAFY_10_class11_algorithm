import java.util.ArrayList;
class Solution {
    static class Node {
        int in;
        int out;
        Node(int in, int out) {
            this.in = in;
            this.out = out;
        }
    }
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        ArrayList<Node> graph = new ArrayList<Node>();
        for(int i = 0; i <= 1000000; i++) {
            graph.add(new Node(0, 0));
        }
        for(int[] edge : edges) {
            graph.get(edge[0]).out++;
            graph.get(edge[1]).in++;
        }
        for(int i = 1; i <= 1000000; i++) {
            if(graph.get(i).in == 0 && graph.get(i).out >= 2) {
                answer[0] = i;
            }
            else if(graph.get(i).out == 0 && graph.get(i).in >= 1) {
                answer[2]++;
            }
            else if(graph.get(i).in >= 2 && graph.get(i).out >= 2) {
                answer[3]++;
            }
        }
        answer[1] = graph.get(answer[0]).out - answer[2] - answer[3];
        return answer;
    }
}
// 146.03ms