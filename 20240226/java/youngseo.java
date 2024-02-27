/*
  테스트 1 〉	통과 (0.15ms, 53.6MB)
  테스트 2 〉	통과 (0.20ms, 52.5MB)
  테스트 3 〉	통과 (0.27ms, 52.8MB)
  테스트 4 〉	통과 (0.22ms, 53.4MB)
  테스트 5 〉	통과 (0.35ms, 53.4MB)
  테스트 6 〉	통과 (0.04ms, 52.4MB)
*/

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        int a = s/n;
        if(a<1){
            answer = new int[1];
            answer[0] = -1;
        }
        else{
            for(int i=0; i<n; i++){
                answer[i] = a;
            }
            
            int cnt = 1;
            for(int i=a*n; i<s; i++){
                answer[n-cnt]++;
                cnt++;
            }
            
        }
        
        
        return answer;
    }
    
    
}
