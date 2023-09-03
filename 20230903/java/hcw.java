import java.util.*;
class Solution {
    static int count = 0;
    static Set<String> s = new HashSet<>();
    
    public void dfs(int count, String[] user_id, String[] banned_id, int[] visited, int[] temp){
        
        if(count == banned_id.length){
            int[] t = temp.clone();
            Arrays.sort(t);
            s.add(Arrays.toString(t));
            
        }else{
            for(int i =0 ; i< user_id.length; i++){
                //방문하지 않았고 길이가 같다면
                if(visited[i] == 0 && banned_id[count].length() == user_id[i].length()){
                    //전부다 같다면
                    boolean flag = true;
 
                    for(int j = 0; j < banned_id[count].length(); j++){
                        if(banned_id[count].charAt(j) == '*') continue;
                        if(banned_id[count].charAt(j) == user_id[i].charAt(j))continue;
                        else{
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        temp[count] = i;
                        visited[i] = 1;
                        dfs(count + 1, user_id, banned_id, visited, temp);
                        visited[i] = 0;
                    }
            }
        }
    }
    }
    
    
    public int solution(String[] user_id, String[] banned_id) {
        
        int[] visited = new int[user_id.length];
        
        int[] temp = new int[banned_id.length];
        dfs(0, user_id, banned_id, visited, temp);
        
        
        return s.size();
    }
}


테스트 1 〉	통과 (0.50ms, 90.2MB)
테스트 2 〉	통과 (0.64ms, 72.1MB)
테스트 3 〉	통과 (0.44ms, 66.6MB)
테스트 4 〉	통과 (0.60ms, 76.1MB)
테스트 5 〉	통과 (84.18ms, 93.9MB)
테스트 6 〉	통과 (2.23ms, 74.9MB)
테스트 7 〉	통과 (0.38ms, 73.3MB)
테스트 8 〉	통과 (0.61ms, 73.6MB)
테스트 9 〉	통과 (0.55ms, 77.2MB)
테스트 10 〉	통과 (0.45ms, 77MB)
테스트 11 〉	통과 (0.48ms, 74.2MB)
