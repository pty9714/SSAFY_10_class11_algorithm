import java.util.*;
class Solution {
    public int solution(int N, int number) {
        int answer = -1;
        if(N == number) return 1; // N과 number가 같으면 1
        ArrayList<ArrayList<Integer>> digits = new ArrayList<ArrayList<Integer>>();
        int digit = 0;
        
        // N으로만 이루어진 i 자리 숫자 만들어서 배열에 첫 원소로 넣기
        for(int i = 0; i <= 8; i++) {
            digits.add(new ArrayList<Integer>());
            digits.get(i).add(digit);
            digit = digit * 10 + N;
        }
        
        // 사칙 연산 진행
        for(int i = 2; i <= 8; i++) {
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
테스트 1 〉	통과 (9.50ms, 75MB)
테스트 2 〉	통과 (0.05ms, 72.7MB)
테스트 3 〉	통과 (0.08ms, 75.1MB)
테스트 4 〉	통과 (448.26ms, 306MB)
테스트 5 〉	통과 (416.10ms, 312MB)
테스트 6 〉	통과 (1.50ms, 76.5MB)
테스트 7 〉	통과 (1.68ms, 80.8MB)
테스트 8 〉	통과 (411.30ms, 314MB)
테스트 9 〉	통과 (0.02ms, 71.8MB)
*/