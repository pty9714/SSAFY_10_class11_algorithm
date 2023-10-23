class Solution {
    public int[] solution(int n, int s) {
        if (n > s) {
            return new int[] {-1};
        }
        int[] answer = new int[n];
        int number = s / n;
        int remain = s % n;
        for (int i = 0; i < n; i++) {
            answer[i] = number;
        }
        for (int i = n-1; i > n-1-remain; i--) {
            answer[i] += 1;
        }

        return answer;
    }
}

//    정확성  테스트
//테스트 1 〉	통과 (0.06ms, 76MB)
//    테스트 2 〉	통과 (0.25ms, 86MB)
//    테스트 3 〉	통과 (0.07ms, 78.9MB)
//    테스트 4 〉	통과 (0.11ms, 71.2MB)
//    테스트 5 〉	통과 (0.03ms, 73.9MB)
//    테스트 6 〉	통과 (0.04ms, 82.8MB)
//    테스트 7 〉	통과 (0.02ms, 71.2MB)
//    테스트 8 〉	통과 (0.03ms, 72.1MB)
//    테스트 9 〉	통과 (0.10ms, 75MB)
//    테스트 10 〉	통과 (0.15ms, 78.1MB)
//    테스트 11 〉	통과 (0.20ms, 80.3MB)
//    테스트 12 〉	통과 (0.11ms, 67.3MB)
//    테스트 13 〉	통과 (0.15ms, 78.3MB)
//    테스트 14 〉	통과 (0.04ms, 74.1MB)
//    효율성  테스트
//    테스트 1 〉	통과 (0.16ms, 53.3MB)
//    테스트 2 〉	통과 (0.22ms, 53.2MB)
//    테스트 3 〉	통과 (0.29ms, 53.1MB)
//    테스트 4 〉	통과 (0.23ms, 53.7MB)
//    테스트 5 〉	통과 (0.36ms, 53.1MB)
//    테스트 6 〉	통과 (0.02ms, 52MB)