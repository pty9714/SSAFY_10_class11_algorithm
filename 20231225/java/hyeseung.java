import java.util.*;

class Solution {
    List<List<Integer>> orders = new ArrayList<>(); // 분배가능한 모든 경우의 수
    
    public int solution(int k, int n, int[][] reqs) {
        int answer = 999999999;
        Integer[] area = new Integer[k+1];
        Arrays.fill(area,1);
        backtracking(n-k,1,new ArrayList<Integer>(Arrays.asList(area)));
        
        for(List<Integer> order : orders){
            answer = Math.min(answer,simulation(k,order,reqs));
        }
        return answer;
    }
    // 모든 경우의 수를 구하는 함수(남은 인원, 유형, 컨테이너)
    void backtracking(int remain, int idx, List<Integer> area){
     	// 모든 인원을 담았으면 orders에 추가
        if(remain <= 0){
            orders.add(area);
            return;
        }
        
        for(int i = idx; i < area.size(); i++){
            area.set(i,area.get(i)+1);
            backtracking(remain-1,i,new ArrayList<Integer>(area));
            area.set(i,area.get(i)-1);
        }
    }
    
    // 각 경우의 수에 맞춰 시뮬레이션을 돌림(순서,요청들)
    int simulation(int k, List<Integer> order, int[][] reqs){
    
    	// 오름차순으로 뽑히는 우선순위큐를 유형의 수만큼 만듦
        PriorityQueue<Integer>[] pq = new PriorityQueue[k+1];
        int result = 0; // 대기 시간의 합 
        
        for(int i = 1; i <= k; i++) {
        	// 각 경우의 수에 맞춰 각 우선순위큐에 담음
            pq[i] = new PriorityQueue<Integer>();
            for(int j = 0; j < order.get(i); j++) pq[i].add(0);
        }
        
        for(int[] req : reqs){
            int arrive = req[0]; // 요청 시각
            int time = req[1]; // 상담 시각
            int idx = req[2]; // 상담 유형
            
            // 해당 유형의 우선순위 큐에서 하나 뽑는다.
            int picked = pq[idx].poll();
            
            
            // 멘토의 시간 > 요청 시각
            if(picked > arrive) {
                result += picked-arrive;
                pq[idx].add(picked+time);
            }
            
            // 멘토의 시간 < 요청 시각
            else if(picked < arrive){
                pq[idx].add(arrive+time);
            }
            
            // 멘토의 시간 == 요청 시각
            else{
                pq[idx].add(picked+time);
            }
        }
        
        return result;
    }
}