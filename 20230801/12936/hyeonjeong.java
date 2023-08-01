import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    
    int cnt;
    int[] answer;
    public int[] solution(int n, long k) {
        
        boolean[] visited = new boolean[n+1];
        int[] output = new int[n];
        answer = new int[n];
        int idx = 0;
        cnt = (int)k;
        
        permutation(idx, visited, output, n, k);
        
        return answer;
    }
    private void permutation(int idx, boolean[] visited, int[] output, int n, long k) {
		if(idx == n) {
            cnt--;
            if(cnt==0) {
                answer = output.clone();
            }
			return;
		}
		for(int i =1; i<=n; i++) {
			if(visited[i]) continue;
			output[idx] = i;
			visited[i] = true;
			permutation(idx+1, visited, output, n, k); 
			visited[i] = false;
		}
	}
}
