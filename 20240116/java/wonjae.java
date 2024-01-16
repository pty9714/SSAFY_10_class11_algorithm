import java.util.ArrayList;

class Solution {

        static ArrayList<Edge>[] graph;
        static int[][] inout;

        public int[] solution(int[][] edges) {
            int[] answer = {0, 0, 0, 0};
            graph = new ArrayList[1000001];
            for(int i = 0; i < graph.length; i++){
                graph[i] = new ArrayList<>();
            }
            inout = new int[1000001][2];


            for(int[] e : edges){
                graph[e[0]].add(new Edge(e[1]));
                inout[e[0]][0]++;
                inout[e[1]][1]++;
            }

            int start = 0;

            for(int i = 1; i < inout.length; i++){
                if(inout[i][0] > 1 && inout[i][1] == 0){
                    start = i;
                    answer[0] = i;
                    break;
                }
            }

            for(Edge e : graph[start]){
                int curr = e.to_node;
                int in = 0;
                int out = 0;
label:          while(true){
                    if(inout[curr][0] > out){
                        in = inout[curr][1];
                        out = inout[curr][0];
                    }
                    for(Edge next : graph[curr]){
                        if(!next.visited){
                            next.visited = true;
                            curr = next.to_node;
                            continue label;
                        }
                    }
                    if(out > 1) answer[3]++;
                    else if(inout[curr][0] == 0) answer[2]++;
                    else answer[1]++;
                    break;
                }
            }
            return answer;
        }

        static class Edge{
            int to_node;
            boolean visited;
            Edge(int to_node){
                this.to_node = to_node;
                this.visited = false;
            }
        }
    }
