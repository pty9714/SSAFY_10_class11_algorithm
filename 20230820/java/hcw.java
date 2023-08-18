import java.util.*;
class Solution {
	public int solution(int alp, int cop, int[][] problems) {
		int max_alp = 0;
		int max_cop = 0;
		for (int i = 0; i < problems.length; i++) {
			max_alp = Math.max(max_alp, problems[i][0]);
			max_cop = Math.max(max_cop, problems[i][1]);
		}
        if(alp >= max_alp && cop >= max_cop){
            return 0;
        }
        
        if(alp >= max_alp) alp = max_alp;
        if(cop >= max_cop) cop = max_cop;
        
        int[][] dp = new int[max_alp+2][max_cop+2];
        for(int i = alp;  i <= max_alp; i++){
            for(int j = cop; j <= max_cop; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[alp][cop] = 0;
        for(int i = alp; i <= max_alp; i++){
            for(int j = cop; j <= max_cop; j++){
                dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j] + 1); //현재 배열 +1과 다음 배열에 있는 값을 비교하면서 작은 값으로 update한다.
                dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j] + 1); // 다음 배열에 있는 값은 최대 값이거나 문제를 풀어서 있는 cost값이다. 문제를 풀어서 생기는 시간보다 적다면 update
                
                for(int m = 0; m < problems.length; m++){ //전체 문제 탐색
                    if(i >= problems[m][0] && j >= problems[m][1]){ //내가 지금 풀수 있는 문제라면
                        if(i + problems[m][2] > max_alp && j + problems[m][3] > max_cop){ //둘다 목표치를 초과한다면
                            dp[max_alp][max_cop] = Math.min(dp[max_alp][max_cop], dp[i][j] + problems[m][4]); //배열 인덱스 조정하고 기존의 값과 새로 생기는 시간중에 작은 것을 setting함
                        }else if(i + problems[m][2] > max_alp){//알고력만 목표치를 초과한다면
                            dp[max_alp][j + problems[m][3]] = Math.min(dp[max_alp][j + problems[m][3]], dp[i][j] + problems[m][4]);
                        }else if(j + problems[m][3] > max_cop){//코딩력만 목표치를 초과한다면
                            dp[i+problems[m][2]][max_cop] = Math.min(dp[i+problems[m][2]][max_cop], dp[i][j] + problems[m][4]);
                        }else{ //둘다 아니면
                            dp[i+problems[m][2]][j + problems[m][3]] = Math.min(dp[i+problems[m][2]][j + problems[m][3]], dp[i][j] + problems[m][4]);
                        }
                        
                    }
                }
            }
        }
        
//          for(int i =0; i< dp.length; i++) System.out.println(Arrays.toString(dp[i]));

		int answer = dp[max_alp][max_cop];
		return answer;
	}
}

//테스트 9 〉	통과 (29.62ms, 52.9MB)
