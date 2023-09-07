import java.util.*;
class Solution {
    public int solution(int[][] board, int[][] skill) {
        
        
        int[][] arr = new int[board.length+1][board[0].length+1];
        
        for(int i  = 0; i < skill.length; i++){
                if(skill[i][0] == 1){ //공격
                    arr[skill[i][1]][skill[i][2]] -= skill[i][5];
                    arr[skill[i][3]+1][skill[i][4]+1] -= skill[i][5];
                    arr[skill[i][3]+1][skill[i][2]] += skill[i][5];
                    arr[skill[i][1]][skill[i][4]+1] += skill[i][5];
                }else if(skill[i][0] == 2){ //회복
                    arr[skill[i][1]][skill[i][2]] += skill[i][5];
                    arr[skill[i][3]+1][skill[i][4]+1] += skill[i][5];
                    arr[skill[i][3]+1][skill[i][2]] -= skill[i][5];
                    arr[skill[i][1]][skill[i][4]+1] -= skill[i][5];
                }
        }
        
        for(int i =0 ; i < arr.length; i++){
            for(int j =0; j< arr[0].length - 1; j++){
                arr[i][j+1] += arr[i][j];
            }
        }
        
         for(int i =0 ; i < arr[0].length; i++){
            for(int j =0; j< arr.length - 1; j++){
                arr[j+1][i] += arr[j][i];
            }
        }
        int answer = 0;
        
        for(int i =0; i< board.length; i++){
            for(int j =0; j< board[i].length; j++){
                if(board[i][j] + arr[i][j] > 0){
                    answer++;
                }
            }
        }
        
        
        return answer;
    }
}


테스트 1 〉	통과 (0.04ms, 75.9MB)
테스트 2 〉	통과 (0.04ms, 72MB)
테스트 3 〉	통과 (0.09ms, 72.5MB)
테스트 4 〉	통과 (0.11ms, 73.3MB)
테스트 5 〉	통과 (0.26ms, 82.7MB)
테스트 6 〉	통과 (0.29ms, 73.6MB)
테스트 7 〉	통과 (0.58ms, 75.1MB)
테스트 8 〉	통과 (0.45ms, 81.4MB)
테스트 9 〉	통과 (0.93ms, 74MB)
테스트 10 〉	통과 (1.41ms, 74.9MB)
효율성  테스트
테스트 1 〉	통과 (59.27ms, 215MB)
테스트 2 〉	통과 (67.44ms, 212MB)
테스트 3 〉	통과 (65.20ms, 216MB)
테스트 4 〉	통과 (59.54ms, 211MB)
테스트 5 〉	통과 (48.54ms, 218MB)
테스트 6 〉	통과 (78.14ms, 217MB)
테스트 7 〉	통과 (54.75ms, 219MB)
