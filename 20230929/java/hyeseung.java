class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        
        // 완호가 인센티브 받지 못하는 경우 -1 return
        for(int i = 1; i < scores.length; i++) {
            if(scores[0][0] < scores[i][0] && scores[0][1] < scores[i][1]) return -1;
        }
        // 완호의 두 점수 합
        int totalScore = scores[0][0] + scores[0][1];
        for(int i = 1; i < scores.length; i++) {
            if(totalScore < scores[i][0] + scores[i][1]) { // 완호 점수보다 석차 위인 사원들만 체크
                // 인센티브 받지 못하는 사원의 경우 pass
                boolean flag = true;
                for(int j = 0; j < scores.length; j++) {
                    if(scores[i][0] < scores[j][0] && scores[i][1] < scores[j][1]) {
                        flag = false;
                        break;
                    }
                }
                if(flag) answer++;
            }
        }
        
        return answer;
    }
}