import java.util.*;
class Solution {
    public int solution(int[][] board, int[][] skill) {
        
        
        int[][] arr = new int[board.length][board[0].length];
        
        for(int i  = 0; i< skill.length; i++){
            
                if(skill[i][0] == 1){ //공격
                    for(int r = skill[i][1]; r<= skill[i][3]; r++){
                        for(int c = skill[i][2]; c <= skill[i][4]; c++){
                            arr[r][c] -= skill[i][5];
                        }
                    }
                }else if(skill[i][0] == 2){ //회복
                    for(int r = skill[i][1]; r<= skill[i][3]; r++){
                        for(int c = skill[i][2]; c <= skill[i][4]; c++){
                            arr[r][c] += skill[i][5];
                        }
                    }
                } 
        }
        int answer = 0;
        // for(int i =0; i< arr.length; i++){
        //     System.out.println(Arrays.toString(arr[i]));
        // }
        
        for(int i =0; i< arr.length; i++){
            for(int j =0; j< arr[i].length; j++){
                if(board[i][j] + arr[i][j] > 0){
                    answer++;
                }
            }
        }
        
        
        return answer;
    }
}

              정확성  테스트
테스트 1 〉	통과 (0.03ms, 70.7MB)
테스트 2 〉	통과 (0.04ms, 77.3MB)
테스트 3 〉	통과 (0.07ms, 71.3MB)
테스트 4 〉	통과 (0.19ms, 75.3MB)
테스트 5 〉	통과 (0.47ms, 71MB)
테스트 6 〉	통과 (0.57ms, 77.8MB)
테스트 7 〉	통과 (1.43ms, 74.3MB)
테스트 8 〉	통과 (2.27ms, 80.1MB)
테스트 9 〉	통과 (2.59ms, 94MB)
테스트 10 〉	통과 (4.54ms, 90MB)
효율성  테스트
테스트 1 〉	실패 (시간 초과)
테스트 2 〉	실패 (시간 초과)
테스트 3 〉	실패 (시간 초과)
테스트 4 〉	실패 (시간 초과)
테스트 5 〉	실패 (시간 초과)
테스트 6 〉	실패 (시간 초과)
테스트 7 〉	실패 (시간 초과)
채점 결과
정확성: 53.8
효율성: 0.0
합계: 53.8 / 100.0
