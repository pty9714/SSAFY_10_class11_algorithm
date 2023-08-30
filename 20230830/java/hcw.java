import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        int[] arr = new int[sticker.length];
        int[] arr1 = new int[sticker.length];
        int[] arr2 = new int[sticker.length];
      
        int max = 0;
        if(sticker.length == 1){
            max = sticker[0];
        }else{
                arr[0] = sticker[0];
                arr[1] = sticker[1];
                arr1[1] = sticker[1];
            }
        
        int a = 0;
        int b = 0;
        int a1 = 0;
        int b1 = 0;
        int a2 = 0;
        int b2 = 0;
        
        for(int i = 2; i < sticker.length; i++){
            a = 0;
            b = 0;
            a1 = 0;
            b1 = 0;
            a2 = 0;
            b2= 0;
            
            if(i == 2){
                a = arr[i-2] + sticker[i];
                arr[i] = Math.max(a, sticker[i]);
                
                a1 = arr1[i-2] + sticker[i];
                arr1[i] = Math.max(a1, sticker[i]);
                
                a2 = arr2[i-2] + sticker[i];
                arr2[i] = Math.max(a2, sticker[i]);
            }else{
                a = arr[i-2] + sticker[i];
                b = arr[i-3] + sticker[i];
                arr[i] = Math.max(b, Math.max(a, sticker[i]));
                
                a1 = arr1[i-2] + sticker[i];
                b1 = arr1[i-3] + sticker[i];
                arr1[i] = Math.max(b1, Math.max(a1, sticker[i]));
                
                
                a2 = arr2[i-2] + sticker[i];
                b2 = arr2[i-3] + sticker[i];
                arr2[i] = Math.max(b2, Math.max(a2, sticker[i]));
            }
        }
        
        for(int i =0; i < sticker.length - 1; i++){
            max = Math.max(max, Math.max(arr[i], arr1[i]));
        }
        
        max = Math.max(arr2[arr2.length-1] , Math.max(max, arr1[arr1.length-1]));
        
        return max;
    }
}

정확성  테스트
테스트 1 〉	통과 (0.07ms, 77.3MB)
테스트 2 〉	통과 (0.06ms, 67.9MB)
테스트 3 〉	통과 (0.03ms, 70.4MB)
테스트 4 〉	통과 (0.04ms, 72.4MB)
테스트 5 〉	통과 (0.06ms, 72.6MB)
테스트 6 〉	통과 (0.04ms, 77.5MB)
테스트 7 〉	통과 (0.43ms, 70.9MB)
테스트 8 〉	통과 (0.38ms, 83.9MB)
테스트 9 〉	통과 (0.31ms, 97.7MB)
테스트 10 〉	통과 (0.41ms, 73.7MB)
테스트 11 〉	통과 (0.29ms, 72.6MB)
테스트 12 〉	통과 (0.46ms, 74.4MB)
테스트 13 〉	통과 (0.44ms, 73.6MB)
테스트 14 〉	통과 (0.46ms, 75.3MB)
테스트 15 〉	통과 (0.30ms, 74.7MB)
테스트 16 〉	통과 (0.33ms, 74.3MB)
테스트 17 〉	통과 (0.43ms, 76.9MB)
테스트 18 〉	통과 (0.31ms, 76.6MB)
테스트 19 〉	통과 (0.44ms, 90.1MB)
테스트 20 〉	통과 (0.28ms, 73MB)
테스트 21 〉	통과 (0.33ms, 70.5MB)
테스트 22 〉	통과 (0.36ms, 67.2MB)
테스트 23 〉	통과 (0.38ms, 72.8MB)
테스트 24 〉	통과 (0.46ms, 77.1MB)
테스트 25 〉	통과 (0.43ms, 81.6MB)
테스트 26 〉	통과 (0.32ms, 76.4MB)
테스트 27 〉	통과 (0.28ms, 73.3MB)
테스트 28 〉	통과 (0.27ms, 68MB)
테스트 29 〉	통과 (0.27ms, 76.3MB)
테스트 30 〉	통과 (0.45ms, 77.3MB)
테스트 31 〉	통과 (0.28ms, 75.7MB)
테스트 32 〉	통과 (0.27ms, 75.3MB)
테스트 33 〉	통과 (0.04ms, 82.2MB)
효율성  테스트
테스트 1 〉	통과 (17.44ms, 57.4MB)
테스트 2 〉	통과 (19.01ms, 56.8MB)
테스트 3 〉	통과 (18.42ms, 56.5MB)
테스트 4 〉	통과 (17.69ms, 56MB)
