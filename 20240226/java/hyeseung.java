import java.util.Arrays;
class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        Arrays.fill(answer, s/n);
        int rest = s%n;
        for (int i = n-1; i >= 0; i--) {
            if(rest == 0) break;
            answer[i]++;
            rest--;
        }
        if(n > s || rest > 0) answer = new int[]{-1};
        return answer;
    }
}
/*
정확성  테스트
테스트 1 〉	통과 (0.07ms, 78.5MB)
테스트 2 〉	통과 (0.18ms, 76.4MB)
테스트 3 〉	통과 (0.13ms, 76.7MB)
테스트 4 〉	통과 (0.13ms, 75.7MB)
테스트 5 〉	통과 (0.04ms, 78.7MB)
테스트 6 〉	통과 (0.06ms, 73.5MB)
테스트 7 〉	통과 (0.03ms, 74.8MB)
테스트 8 〉	통과 (0.04ms, 74.2MB)
테스트 9 〉	통과 (0.11ms, 79.7MB)
테스트 10 〉	통과 (0.18ms, 80.2MB)
테스트 11 〉	통과 (0.13ms, 75MB)
테스트 12 〉	통과 (0.18ms, 79.4MB)
테스트 13 〉	통과 (0.25ms, 80.9MB)
테스트 14 〉	통과 (0.31ms, 81MB)
효율성  테스트
테스트 1 〉	통과 (0.14ms, 52.9MB)
테스트 2 〉	통과 (0.15ms, 52.8MB)
테스트 3 〉	통과 (0.27ms, 61.9MB)
테스트 4 〉	통과 (0.23ms, 53.8MB)
테스트 5 〉	통과 (0.34ms, 53.9MB)
테스트 6 〉	통과 (0.26ms, 52MB)
채점 결과
정확성: 70.0
효율성: 30.0
합계: 100.0 / 100.0
 */