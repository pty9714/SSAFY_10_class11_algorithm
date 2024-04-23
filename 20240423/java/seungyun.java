class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] arr = new int[s.length()];
        int[] alpha = new int[26];
        
        for(int i=0; i<26; i++){
            alpha[i] = -1;
        }
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            int idx = c - 'a';
            if(alpha[idx] == -1){
                answer[i] = -1;
                alpha[idx] = i;
            } else{
                answer[i] = i-alpha[idx]; // 자신위치 - 전에 있던위치
                alpha[idx] = i;
            }
        }
        
        
        return answer;
    }
}
/*
테스트 1 〉	통과 (0.02ms, 71.5MB)
테스트 2 〉	통과 (0.03ms, 70.7MB)
테스트 3 〉	통과 (0.04ms, 79.4MB)
테스트 4 〉	통과 (0.10ms, 75.2MB)
테스트 5 〉	통과 (1.13ms, 83.1MB)
테스트 6 〉	통과 (0.30ms, 76.8MB)
테스트 7 〉	통과 (0.72ms, 80.6MB)
테스트 8 〉	통과 (0.37ms, 78.4MB)
테스트 9 〉	통과 (0.66ms, 83MB)
테스트 10 〉	통과 (0.23ms, 73.2MB)
테스트 11 〉	통과 (0.75ms, 86MB)
테스트 12 〉	통과 (0.01ms, 72.6MB)
테스트 13 〉	통과 (0.01ms, 70.6MB)
테스트 14 〉	통과 (0.08ms, 72.5MB)
테스트 15 〉	통과 (0.02ms, 75.4MB)
테스트 16 〉	통과 (0.02ms, 76MB)
테스트 17 〉	통과 (0.02ms, 73MB)
테스트 18 〉	통과 (0.14ms, 73MB)
테스트 19 〉	통과 (0.17ms, 73.3MB)
테스트 20 〉	통과 (0.06ms, 80.6MB)
테스트 21 〉	통과 (0.03ms, 71.5MB)
테스트 22 〉	통과 (0.37ms, 81.1MB)
테스트 23 〉	통과 (0.04ms, 73MB)
테스트 24 〉	통과 (0.07ms, 80.5MB)
테스트 25 〉	통과 (0.10ms, 78.4MB)
테스트 26 〉	통과 (0.03ms, 77.4MB)
테스트 27 〉	통과 (0.11ms, 72.6MB)
테스트 28 〉	통과 (0.09ms, 71.4MB)
테스트 29 〉	통과 (0.02ms, 76.3MB)
테스트 30 〉	통과 (0.71ms, 79.7MB)
*/