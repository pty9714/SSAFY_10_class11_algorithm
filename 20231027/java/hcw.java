import java.util.*;
class Solution {
    
    
    static int hole_count;
    static boolean flag;
    
    static int[][] rotate(int[][] arr) {
    int n = arr.length;
    int[][] rotate = new int[n][n];

    for (int i = 0; i < rotate.length; i++) {
        for (int j = 0; j < rotate[i].length; j++) {
            rotate[i][j] = arr[n-1-j][i];
        }
    }
    return rotate;
}
    
    
    public void move(int[][] key, int[][] exLock){ //이동
        int temp_n = exLock.length - key.length + 1;
        label:for(int r = 0; r < temp_n; r++){//아래로 움직임
            for(int c = 0; c < temp_n; c++){ //오른쪽으로 움직임
                int count = 0;
                boolean notMatch = false;
                for(int i =0; i < key.length; i++){
                    for(int j = 0; j < key.length; j++){
                        
                        if(key[i][j] == 1 && exLock[r + i][c + j] == 1){
                            count++;
                        }else if(key[i][j] == 1 && exLock[r + i][c + j] == 2){
                            notMatch = true;
                        }
                    }
                }
                
                if(count == hole_count && !notMatch){
                    System.out.println("true");
                    flag = true;
                    break label;
                }
                
            }
        }
        
    }
    
    public boolean solution(int[][] key, int[][] lock) {
        int[][] exLock = new int[lock.length + (key.length-1) * 2][lock.length + (key.length-1) * 2];
        hole_count = 0;
        flag = false;
        for(int i =0; i< lock.length; i++){
            for(int j =0; j< lock.length; j++){
                if(lock[i][j] == 0){
                    hole_count++;
                    exLock[i + key.length-1][j + key.length-1] = 1;
                }else if(lock[i][j] == 1){
                    exLock[i + key.length-1][j + key.length-1] = 2;
                }
            }
        }
        
        for(int i =0; i < 4; i++){
            key = rotate(key);
            move(key, exLock);
            if(flag == true) break;
        }
        
        return flag;

    }
}

정확성  테스트
테스트 1 〉	통과 (0.12ms, 74.5MB)
테스트 2 〉	통과 (0.16ms, 77MB)
테스트 3 〉	통과 (2.13ms, 73.9MB)
테스트 4 〉	통과 (0.22ms, 72.6MB)
테스트 5 〉	통과 (4.87ms, 87MB)
테스트 6 〉	통과 (1.94ms, 73MB)
테스트 7 〉	통과 (6.60ms, 89.1MB)
테스트 8 〉	통과 (5.25ms, 73.6MB)
테스트 9 〉	통과 (9.71ms, 66.4MB)
테스트 10 〉	통과 (12.18ms, 80.4MB)
테스트 11 〉	통과 (21.77ms, 89.7MB)
테스트 12 〉	통과 (0.16ms, 71.3MB)
테스트 13 〉	통과 (0.93ms, 81.4MB)
테스트 14 〉	통과 (0.20ms, 74.5MB)
테스트 15 〉	통과 (0.75ms, 77.7MB)
테스트 16 〉	통과 (5.95ms, 76.8MB)
테스트 17 〉	통과 (10.01ms, 77MB)
테스트 18 〉	통과 (2.57ms, 80.5MB)
테스트 19 〉	통과 (0.32ms, 68.8MB)
테스트 20 〉	통과 (6.43ms, 74.6MB)
테스트 21 〉	통과 (13.53ms, 76.9MB)
테스트 22 〉	통과 (6.49ms, 85.3MB)
테스트 23 〉	통과 (0.63ms, 71.5MB)
테스트 24 〉	통과 (0.47ms, 71.9MB)
테스트 25 〉	통과 (19.29ms, 65.3MB)
테스트 26 〉	통과 (12.09ms, 78.6MB)
테스트 27 〉	통과 (17.34ms, 79.8MB)
테스트 28 〉	통과 (5.37ms, 74MB)
테스트 29 〉	통과 (1.46ms, 76.7MB)
테스트 30 〉	통과 (6.07ms, 79.7MB)
테스트 31 〉	통과 (5.81ms, 79.1MB)
테스트 32 〉	통과 (14.03ms, 81.5MB)
테스트 33 〉	통과 (5.15ms, 74.4MB)
테스트 34 〉	통과 (0.67ms, 80.3MB)
테스트 35 〉	통과 (0.66ms, 74.2MB)
테스트 36 〉	통과 (0.98ms, 79.1MB)
테스트 37 〉	통과 (0.42ms, 82.2MB)
테스트 38 〉	통과 (0.20ms, 70MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
