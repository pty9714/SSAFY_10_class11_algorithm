import java.util.*;
class Solution {
    public class Node{
        int distance;
        int num;
        public Node(int distance, int num){
            this.distance = distance;
            this.num = num;
        }
    }
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        int[] visited = new int[n+1];
        int[] result = new int[n+1];
        ArrayList<Integer>[] al = new ArrayList[n+1];
        for(int i = 1; i < n+1; i++){
            al[i] = new ArrayList<>();
        }
        for(int i = 0; i < roads.length; i++){
            al[roads[i][0]].add(roads[i][1]);
            al[roads[i][1]].add(roads[i][0]);
        }
        
        Queue<Node> q = new LinkedList<>();
        
        visited[destination] = 1;
        q.add(new Node(0, destination));
        
        while(!q.isEmpty()){
            Node temp = q.poll();
            int tempDistance = temp.distance;
            int tempNum = temp.num;
            result[tempNum] = tempDistance;
            
            for(int i = 0; i < al[tempNum].size(); i++){
                if(visited[al[tempNum].get(i)] == 0){
                    visited[al[tempNum].get(i)] = 1;
                    q.add(new Node(tempDistance+1, al[tempNum].get(i)));
                }
            }
        }
        
        
        for(int i = 0; i< sources.length; i++){
            if(result[sources[i]] == 0 && sources[i] != destination){
                answer[i] = -1;
                continue;
            }
            answer[i] = result[sources[i]];
        }
        return answer;
    }
}

테스트 1 〉	통과 (3.42ms, 72.9MB)
테스트 2 〉	통과 (0.58ms, 74.6MB)
테스트 3 〉	통과 (0.44ms, 73.9MB)
테스트 4 〉	통과 (0.40ms, 72.1MB)
테스트 5 〉	통과 (0.59ms, 73.7MB)
테스트 6 〉	통과 (19.08ms, 101MB)
테스트 7 〉	통과 (19.34ms, 105MB)
테스트 8 〉	통과 (24.59ms, 107MB)
테스트 9 〉	통과 (17.84ms, 99.3MB)
테스트 10 〉	통과 (17.93ms, 93.8MB)
테스트 11 〉	통과 (133.32ms, 188MB)
테스트 12 〉	통과 (200.46ms, 186MB)
테스트 13 〉	통과 (167.41ms, 175MB)
테스트 14 〉	통과 (157.04ms, 174MB)
테스트 15 〉	통과 (133.70ms, 186MB)
테스트 16 〉	통과 (48.37ms, 131MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
