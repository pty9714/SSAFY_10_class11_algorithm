import java.util.*;

class Solution {
    
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1); // -1 로 초기화
        Stack<Integer> stack = new Stack<>();
        
        for(int i = answer.length - 1; i >= 0; i--) {
            while(!stack.isEmpty()) {
                // 뒷 수가 자신보다 크면 뒷 큰 수
                if(stack.peek() > numbers[i]) {
                    answer[i] = stack.peek();
                    break;
                }
                // 뒷 수가 자신보다 작으면 pop
                else stack.pop();
            }
            // 뒷 수 스택에 push
            stack.push(numbers[i]);
        }
        
        return answer;
    }
}