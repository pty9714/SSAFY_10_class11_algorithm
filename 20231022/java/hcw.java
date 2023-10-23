class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        int N = n;
        
        for(int i =0; i < N; i++){
            if(s/n == 0){
                answer = new int[]{-1};
                break;
            }
            answer[i] = s/n;
            s = s - answer[i];
            n--;
        }
        
        return answer;
    }
}

테스트 1 〉	통과 (0.15ms, 82MB)
테스트 2 〉	통과 (0.17ms, 77.7MB)
테스트 3 〉	통과 (0.14ms, 74.3MB)
테스트 4 〉	통과 (0.21ms, 79.7MB)
테스트 5 〉	통과 (0.05ms, 91.8MB)
테스트 6 〉	통과 (0.13ms, 66.3MB)
테스트 7 〉	통과 (0.06ms, 76.3MB)
테스트 8 〉	통과 (0.03ms, 79.1MB)
테스트 9 〉	통과 (0.15ms, 79.7MB)
테스트 10 〉	통과 (0.14ms, 82MB)
테스트 11 〉	통과 (0.14ms, 80.3MB)
테스트 12 〉	통과 (0.10ms, 76.9MB)
테스트 13 〉	통과 (0.15ms, 74MB)
테스트 14 〉	통과 (0.04ms, 73.7MB)
효율성  테스트
테스트 1 〉	통과 (0.29ms, 69.2MB)
테스트 2 〉	통과 (0.24ms, 53.4MB)
테스트 3 〉	통과 (0.26ms, 53MB)
테스트 4 〉	통과 (0.30ms, 53.1MB)
테스트 5 〉	통과 (0.45ms, 53.2MB)
테스트 6 〉	통과 (0.04ms, 52.8MB)
