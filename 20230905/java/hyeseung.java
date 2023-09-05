import java.util.*;
class Solution {
    public int solution(int N, int number) {
        int answer = -1;
        if(N == number) return 1; // N과 number가 같으면 1
        ArrayList<ArrayList<Integer>> digits = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i <= 8; i++) {
            digits.add(new ArrayList<Integer>());
        }
        
        int digit = N;
        // 1자리 자릿수
        digits.get(1).add(digit);
        
        // 사칙 연산 진행 (+ N으로만 이루어진 i 자리 숫자 넣기)
        for(int i = 2; i <= 8; i++) {
            digit = digit * 10 + N;
            digits.get(i).add(digit);
            for(int j = 1; j < i; j++) {
                for(Integer a : digits.get(j)) {
                    for(Integer b : digits.get(i-j)) {
                        digits.get(i).add(a + b);
                        digits.get(i).add(a - b);
                        digits.get(i).add(a * b);
                        if(b != 0)
                            digits.get(i).add(a / b);
                    }
                }
            }    
            if(digits.get(i).contains(number)) return i; // i개의 자릿수에서 number 포함할 경우 값 반환
        }
        return answer; // 최솟값이 8보다 크면 -1 반환
    }
}
/*
테스트 1 〉	통과 (11.05ms, 78.4MB)
테스트 2 〉	통과 (0.05ms, 75MB)
테스트 3 〉	통과 (0.09ms, 73.8MB)
테스트 4 〉	통과 (445.30ms, 319MB)
테스트 5 〉	통과 (468.70ms, 313MB)
테스트 6 〉	통과 (1.96ms, 73.7MB)
테스트 7 〉	통과 (2.15ms, 75.6MB)
테스트 8 〉	통과 (461.77ms, 311MB)
테스트 9 〉	통과 (0.02ms, 75.7MB)
*/