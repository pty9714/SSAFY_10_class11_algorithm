import java.io.*;
import java.util.*;
class Solution {
    public int[] solution(int n, long k) {
        int N = n;
        int[] answer = new int[N];
	    ArrayList<Integer> arr = new ArrayList<>();
        long fac = 1;
		for(int i = 0; i < n; i ++) {
			arr.add(i+1);
            fac *= (i+1);
		}
			 long temp = 0;
			 long index = 0;
			 k -= 1;
			 for(int i = 0; i < N; i++) {
				 temp = fac / n;
				 index = (int)(k / temp);
				 k = k % temp;
				 answer[i] = arr.remove((int)index);
				 fac /= n;
				 n -=1;
             }    
        
        return answer;
    }
}