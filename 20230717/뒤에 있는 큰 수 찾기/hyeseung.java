import java.util.*;

class Solution {
    
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        // 배열 마지막 원소는 항상 -1
        int last = numbers.length;
        answer[last - 1] = -1;
        
        for(int i = last - 2; i >= 0; i--) {
            for(int j = i + 1; j < last; j++){
                // 뒷 수가 자신보다 크면 뒷 수
                if(numbers[i] < numbers[j]) {
                    answer[i] = numbers[j];
                    break;
                }
                // 뒷 수가 자신과 같으면 뒷 수의 정답
                else if(numbers[i] == numbers[j]) {
                    answer[i] = answer[j];
                    break;
                }
                // 뒷 수가 자신보다 작고 큰 뒷 수가 없으면 -1
                else if(answer[j] == -1){
                    answer[i] = -1;
                    break;
                }
            }
        }
        
        return answer;
    }
}