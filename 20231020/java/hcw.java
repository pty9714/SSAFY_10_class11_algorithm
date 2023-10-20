import java.util.*;
class Solution {
    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        int[] result = new int[e+1];
        
        int[] arr = new int[e+1];

        
        int max = 0;
        int p = starts.length - 1;
        
        for(int i = e; i >= 1; i--){ 
            int N = i;
            int count = 0;
            for (int j = 1; j * j <= N; j++) { //약수구하기
	            if (j * j == N) count++;
	            else if (N % j == 0) count += 2;
            }
            arr[i] = count;
            
            if(arr[i] >= arr[max]){ //현재의 약수가 더 많거나 같은데 숫자가 더 작으면
                max = i;
                result[i] = max;
            }else{
                result[i] = max;
            }
        }

        for(int i =0; i < starts.length; i++){
            answer[i] = result[starts[i]];
        }

        return answer;
    }
}   

정확성  테스트
테스트 1 〉	통과 (0.02ms, 75.1MB)
테스트 2 〉	통과 (0.02ms, 67.5MB)
테스트 3 〉	통과 (0.05ms, 75MB)
테스트 4 〉	통과 (0.30ms, 77.9MB)
테스트 5 〉	통과 (0.56ms, 75.3MB)
테스트 6 〉	통과 (3.51ms, 89.6MB)
테스트 7 〉	통과 (9.53ms, 77.1MB)
테스트 8 〉	통과 (42.38ms, 87.2MB)
테스트 9 〉	통과 (2829.03ms, 112MB)
테스트 10 〉	실패 (시간 초과)
채점 결과
정확성: 90.0
합계: 90.0 / 100.0
