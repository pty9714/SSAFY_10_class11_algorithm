import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        HashSet<String> hs = new HashSet<>();
        HashMap<String, Integer> hm = new HashMap<>();
        // 보석의 종류 개수 세기
        for(String gem : gems) {
            hs.add(gem);  
        }
        int n = hs.size();
        // 투포인터
        int temp = 0, min = Integer.MAX_VALUE;
        for(int i = 0; i < gems.length; i++) { // 오른쪽 이동
            hm.put(gems[i], hm.getOrDefault(gems[i], 0) + 1); // map에 삽입
            while(hm.size() == n) { // 가장 짧은 구간 찾기 위해 n일 때까지 왼쪽 이동
                hm.put(gems[temp], hm.get(gems[temp]) - 1);
                if(hm.get(gems[tempStart]) == 0) { // 0이면 제거
                    hm.remove(gems[tempStart]);
                }
                // 진열된 모든 종류의 보석을 적어도 1개 이상 포함하는 가장 짧은 구간의 경우 update
                if(i - temp < min) { 
                    min = i - temp;
                    answer[0] = temp + 1;
                    answer[1] = i + 1;
                }
                temp++;
            }
        }
        return answer;
    }
}