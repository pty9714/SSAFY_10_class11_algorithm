class Solution
{
    public int solution(String s)
    {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            answer = Math.max(answer, getPalindromeLength(i, i, s));
            if(i != s.length() - 1 && s.charAt(i) == s.charAt(i + 1))
                answer = Math.max(answer, getPalindromeLength(i, i + 1, s));
        }

        return answer;
    }
    private int getPalindromeLength(int leftIndex, int rightIndex, String s) {
        int length = leftIndex == rightIndex ? 1 : 2;
        while(--leftIndex >= 0 && ++rightIndex < s.length()) {
            if(s.charAt(leftIndex) == s.charAt(rightIndex)) {
                length += 2;
            }
            else break;
        }
        return length;
    }
}
/*
정확성  테스트
테스트 1 〉	통과 (0.04ms, 69.8MB)
테스트 2 〉	통과 (0.05ms, 78.7MB)
테스트 3 〉	통과 (0.06ms, 76MB)
테스트 4 〉	통과 (0.08ms, 72.2MB)
테스트 5 〉	통과 (0.07ms, 72.1MB)
테스트 6 〉	통과 (0.09ms, 74.6MB)
테스트 7 〉	통과 (0.05ms, 76MB)
테스트 8 〉	통과 (0.09ms, 77.3MB)
테스트 9 〉	통과 (0.11ms, 75.1MB)
테스트 10 〉	통과 (0.13ms, 72.4MB)
테스트 11 〉	통과 (0.28ms, 72.3MB)
테스트 12 〉	통과 (0.50ms, 72.8MB)
테스트 13 〉	통과 (0.08ms, 78.4MB)
테스트 14 〉	통과 (0.13ms, 80.9MB)
테스트 15 〉	통과 (0.14ms, 74.5MB)
테스트 16 〉	통과 (0.10ms, 76.9MB)
테스트 17 〉	통과 (0.06ms, 75.1MB)
테스트 18 〉	통과 (0.05ms, 73.9MB)
테스트 19 〉	통과 (0.09ms, 74.6MB)
테스트 20 〉	통과 (0.16ms, 71MB)
테스트 21 〉	통과 (0.10ms, 72.3MB)
테스트 22 〉	통과 (0.04ms, 71.9MB)
테스트 23 〉	통과 (0.04ms, 64.7MB)
테스트 24 〉	통과 (0.04ms, 76.3MB)
효율성  테스트
테스트 1 〉	통과 (1.44ms, 52MB)
테스트 2 〉	통과 (20.54ms, 51.8MB)
채점 결과
정확성: 72.1
효율성: 27.9
합계: 100.0 / 100.0
 */