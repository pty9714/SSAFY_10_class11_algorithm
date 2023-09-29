import java.util.*;
class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        int temp1 = scores[0][0];
        int temp2 = scores[0][1];
        
        Arrays.sort(scores, (el1, el2) -> {
            if(el1[0] == el2[0]){ //평가 점수로 정렬
                return el1[1] - el2[1];
            }
            //근무 태도로 정렬
            return el2[0] - el1[0];
        });

        int max = 0;
        for(int[] score : scores) {
            if(score[1] < max) { //동료 평가 점수가 작다면
                if(temp1 == score[0] && temp2 == score[1]) //원호인가
                    return -1;
            }else { //동료 평가 점수가 같거나 크다면 앞이 변해야한다는 뜻
                max = Math.max(score[1], max); //max값 갱신
                if(temp1 + temp2 < score[0] + score[1]) //점수 계산
                    answer++;
            }
        }

        return answer;
    }
}
