class Solution {
    
    public int solution(int sticker[]) {
        int answer = 0;
        int n = sticker.length;
        int maxSticker[][] = new int[n-1][2];
        if(n==1) return answer = sticker[0];
        maxSticker[0][0] = sticker[0];
        maxSticker[0][1] = sticker[1];
        
        for(int i = 1; i < n - 1; i++) {
            if(i == 1) {
                maxSticker[i][0] = Math.max(maxSticker[i-1][0], sticker[i]);
                maxSticker[i][1] = Math.max(maxSticker[i-1][1], sticker[i+1]);
            }
            else {
                maxSticker[i][0] = Math.max(maxSticker[i-1][0], maxSticker[i-2][0] + sticker[i]);
                maxSticker[i][1] = Math.max(maxSticker[i-1][1], maxSticker[i-2][1] + sticker[i+1]);
            }
        }
        
        answer = Math.max(maxSticker[n-2][0], maxSticker[n-2][1]);
        return answer;
    }
}
/*
테스트 1 〉	통과 (0.03ms, 72.1MB)
테스트 2 〉	통과 (0.03ms, 74.8MB)
테스트 3 〉	통과 (0.03ms, 82.8MB)
테스트 4 〉	통과 (0.04ms, 74.3MB)
테스트 5 〉	통과 (0.04ms, 78.3MB)
테스트 6 〉	통과 (0.03ms, 73.6MB)
테스트 7 〉	통과 (0.17ms, 75.6MB)
테스트 8 〉	통과 (0.17ms, 73.8MB)
테스트 9 〉	통과 (0.17ms, 74.6MB)
테스트 10 〉	통과 (0.17ms, 73MB)
테스트 11 〉	통과 (0.28ms, 78.4MB)
테스트 12 〉	통과 (0.17ms, 75.6MB)
테스트 13 〉	통과 (0.16ms, 72MB)
테스트 14 〉	통과 (0.16ms, 71.2MB)
테스트 15 〉	통과 (0.17ms, 78.1MB)
테스트 16 〉	통과 (0.18ms, 71.6MB)
테스트 17 〉	통과 (0.28ms, 78.2MB)
테스트 18 〉	통과 (0.29ms, 79.1MB)
테스트 19 〉	통과 (0.16ms, 76.8MB)
테스트 20 〉	통과 (0.18ms, 77.8MB)
테스트 21 〉	통과 (0.18ms, 75.7MB)
테스트 22 〉	통과 (0.17ms, 84.5MB)
테스트 23 〉	통과 (0.19ms, 72MB)
테스트 24 〉	통과 (0.16ms, 73.8MB)
테스트 25 〉	통과 (0.20ms, 75.2MB)
테스트 26 〉	통과 (0.17ms, 76.7MB)
테스트 27 〉	통과 (0.17ms, 71.3MB)
테스트 28 〉	통과 (0.19ms, 75.1MB)
테스트 29 〉	통과 (0.19ms, 73.3MB)
테스트 30 〉	통과 (0.17ms, 74.5MB)
테스트 31 〉	통과 (0.28ms, 73.9MB)
테스트 32 〉	통과 (0.16ms, 75.9MB)
테스트 33 〉	통과 (0.02ms, 75MB)
효율성  테스트
테스트 1 〉	통과 (18.51ms, 60.3MB)
테스트 2 〉	통과 (16.35ms, 58.1MB)
테스트 3 〉	통과 (12.01ms, 58.4MB)
테스트 4 〉	통과 (13.36ms, 57.9MB)
*/