import java.util.*;
class Solution {
    static ArrayList<Road>[] al;
    static ArrayList<Road>[] al1;
    static int answer = Integer.MAX_VALUE;
    static ArrayList<Integer> trapBoy;
    class Road{
        int to;
        int distance;
        
        public Road( int to , int distance){
            this.to = to;
            this.distance = distance;
        }
    }
    
    private void dfs(int currentNode, int targetNode, int[] visited){
        if(currentNode == targetNode){
            
        }else{
            for(int i =0; i < al[currentNode].size(); i++){
                if(visited[al[currentNode].get(i).to] == 0){
                    visited[al[currentNode].get(i).to] = 1;
                    if(trapBoy.contains(al[currentNode].get(i).to)){ //트랩이라면
                    for(int j = 0; j < al[currentNode].size(); j++){ //현재에 트랩에서 나가는 방향 반대로 바꿔줌
                        al[al[currentNode].get(i).to].add(new Road(currentNode, al[currentNode].get(i).distance));
                    }
                    al[currentNode].clear();
                        for(int j = 0; j < al1[currentNode].size(); j++){
                            al[currentNode].add(al1[currentNode].get(j));
                        }
                    }
                    dfs(al[currentNode].get(i).to, targetNode, visited);
                    visited[al[currentNode].get(i).to] = 0;
                }
                
            }
        }
    }
    
    
    
    
    public int solution(int n, int start, int end, int[][] roads, int[] traps) {
        int answer = 0;
        int[] visited = new int[n+1];
        for(int i =0 ; i < traps.length; i++){
            trapBoy.add(traps[i]);
        }
        al = new ArrayList[n+1];
        for(int i =0 ; i < n; i++){
            al[i] = new ArrayList<>();
        }
        for(int i =0 ; i < roads.length; i++){
            al[roads[i][0]].add(new Road(roads[i][1], roads[i][2]));
            al[roads[i][1]].add(new Road(roads[i][0], roads[i][2]));
        }
        visited[start] = 1;
        dfs(start, end, visited);
        

        return answer;
    }
}
