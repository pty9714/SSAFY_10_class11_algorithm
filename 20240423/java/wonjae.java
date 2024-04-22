class Solution {
    public int[] solution(String s) {
        int s_len = s.length();
        int[] alphabet = new int[26];
        int[] answer = new int[s_len];
        
        for(int i = 0; i < s_len; i++){
            answer[i] = -1;
        }
        
        for(int i = 0; i < 26; i++){
            alphabet[i] = -1;
        }
        
        for(int i = 0; i < s_len; i++){
            char c = s.charAt(i);
            if(alphabet[c-'a'] == -1) {
                alphabet[c-'a'] = i;
                continue;
            }
            answer[i] = i - alphabet[c-'a'];
            alphabet[c-'a'] = i;
        }
        
        return answer;
    }
}
/*
테스트 1 〉	통과 (0.02ms, 74.1MB)
테스트 2 〉	통과 (0.02ms, 75.9MB)
테스트 3 〉	통과 (0.03ms, 74.2MB)
테스트 4 〉	통과 (0.09ms, 74.4MB)
테스트 5 〉	통과 (1.08ms, 86.6MB)
테스트 6 〉	통과 (0.26ms, 78.2MB)
테스트 7 〉	통과 (0.65ms, 85.6MB)
테스트 8 〉	통과 (0.22ms, 78.1MB)
테스트 9 〉	통과 (0.60ms, 89.3MB)
테스트 10 〉	통과 (0.14ms, 76.8MB)
테스트 11 〉	통과 (0.59ms, 73.8MB)
테스트 12 〉	통과 (0.02ms, 72.5MB)
테스트 13 〉	통과 (0.02ms, 78.8MB)
테스트 14 〉	통과 (0.04ms, 77.4MB)
테스트 15 〉	통과 (0.01ms, 75.2MB)
테스트 16 〉	통과 (0.02ms, 76.4MB)
테스트 17 〉	통과 (0.02ms, 76.4MB)
테스트 18 〉	통과 (0.13ms, 76.2MB)
테스트 19 〉	통과 (0.16ms, 77.4MB)
테스트 20 〉	통과 (0.08ms, 76.2MB)
테스트 21 〉	통과 (0.03ms, 77.4MB)
테스트 22 〉	통과 (0.35ms, 78.6MB)
테스트 23 〉	통과 (0.05ms, 75.9MB)
테스트 24 〉	통과 (0.05ms, 65.1MB)
테스트 25 〉	통과 (0.06ms, 89.3MB)
테스트 26 〉	통과 (0.02ms, 75.8MB)
테스트 27 〉	통과 (0.07ms, 74.6MB)
테스트 28 〉	통과 (0.06ms, 90.5MB)
테스트 29 〉	통과 (0.02ms, 76.1MB)
테스트 30 〉	통과 (0.65ms, 87.8MB)
  */
