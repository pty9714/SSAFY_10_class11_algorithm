import java.util.*;

// 테스트 1 〉	통과 (0.76ms, 83.9MB)
// 테스트 2 〉	통과 (2.40ms, 83.5MB)
// 테스트 3 〉	통과 (2.61ms, 77.4MB)
// 테스트 4 〉	통과 (1.57ms, 75.2MB)
// 테스트 5 〉	통과 (3.79ms, 87.8MB)
// 테스트 6 〉	통과 (4.55ms, 78.7MB)
// 테스트 7 〉	통과 (3.90ms, 77.6MB)
// 테스트 8 〉	통과 (857.30ms, 646MB)
// 테스트 9 〉	통과 (3373.61ms, 529MB)
// 테스트 10 〉	통과 (2059.61ms, 649MB)
// 테스트 11 〉	통과 (777.30ms, 616MB)
// 테스트 12 〉	통과 (696.39ms, 604MB)
// 테스트 13 〉	통과 (1401.59ms, 584MB)
// 테스트 14 〉	통과 (3426.86ms, 1.1GB)
// 테스트 15 〉	통과 (593.33ms, 316MB)
// 테스트 16 〉	통과 (466.03ms, 304MB)
// 테스트 17 〉	통과 (603.92ms, 423MB)
// 테스트 18 〉	통과 (572.69ms, 322MB)
// 테스트 19 〉	통과 (535.54ms, 300MB)
// 테스트 20 〉	통과 (735.08ms, 322MB)
// 테스트 21 〉	통과 (1019.30ms, 547MB)
// 테스트 22 〉	통과 (703.42ms, 428MB)
// 테스트 23 〉	통과 (745.91ms, 469MB)
// 테스트 24 〉	통과 (774.97ms, 485MB)
// 테스트 25 〉	통과 (640.64ms, 484MB)
// 테스트 26 〉	통과 (613.81ms, 507MB)

class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        
        HashMap<Integer, List<Integer>> to = new HashMap<>();
        HashMap<Integer, List<Integer>> from = new HashMap<>();
        
        List<Integer> list;
        int max_node = 0;
        for(int i=0; i<edges.length; i++){
            list = new ArrayList<>();
            list = to.getOrDefault(edges[i][0], list);
            list.add(edges[i][1]);
            to.put(edges[i][0], list);
            
            list = new ArrayList<>();
            list = from.getOrDefault(edges[i][1], list);
            list.add(edges[i][0]);
            from.put(edges[i][1], list);
            
            max_node = Math.max(edges[i][0] , max_node);
            max_node = Math.max(edges[i][1] , max_node);
        }
        
        int cnt = 0;
        for(int i : to.keySet()){
            
            if(!from.containsKey(i) && to.get(i).size() > cnt){
                answer[0] = i;
                cnt = to.get(i).size();
            }
        }
        
        List<Integer> start = to.get(answer[0]);
        boolean[] visited;
        for(int s : start){
            visited = new boolean[max_node+1];
            Stack<Integer> stack = new Stack<>();
            stack.add(s);
            visited[s] = true;
            boolean circle = false;
            int max_cnt = 0;
            int time = 0;
            while(!stack.isEmpty()){
                int temp = stack.pop();

                cnt = 0;
                if(to.containsKey(temp)){
                    for(int t : to.get(temp))
                        if(t!=answer[0])
                            cnt++;
                }
                if(from.containsKey(temp)){
                    for(int t : from.get(temp))
                        if(t!=answer[0])
                            cnt++;
                }
                max_cnt = Math.max(max_cnt, cnt);
                
                if(to.containsKey(temp)){
                    List<Integer> to_list = to.get(temp);
                    for(int t : to_list){
                        if(t == s){
                            circle = true;
                            continue;
                        }
                        else if (visited[t])
                            continue;
                        stack.add(t);
                        visited[t] = true;
                    }
                }
                time++;
            }
            
            if(max_cnt == 4)
                answer[3]++;
            else{
                if(circle)
                    answer[1]++;
                else
                    answer[2]++;
            }
                
            
        }
        
        return answer;
    }
}
