import java.util.*;
class Solution {
    
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    
    public int solution(int n, int[][] lighthouse) {
        int answer = 0;
        
        list = new ArrayList[n+1];
        visited = new boolean[n+1];
        
        for(int i=0; i<=n; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i=0; i<lighthouse.length; i++){
            int s = lighthouse[i][0];
            int e = lighthouse[i][1];
            
            list[s].add(e);
            list[e].add(s);
        }
        // 1. 간선이 1개인거 제외
        // 2. 1부터 바로 옆에 있는거 제외
        // 3. 남은거 순차적으로 2번 계속 진행
        
        for(int i=1; i<=n; i++){
           if(list[i].size() == 1){
               visited[i] = true;
           }
        }
        
        for(int i=1; i<=n; i++){
           if(!visited[i]){
               answer++;
               // System.out.println(i);
               bfs(i);
           }
        }
        
        return answer;
    }
    
    static void bfs(int idx){
        for(int i=0; i<list[idx].size(); i++){
            int a = list[idx].get(i);
            // System.out.println("bfs " + list[idx].get(i));
            if(!visited[a]){
                visited[a] = true;
            }
        }
    }
}