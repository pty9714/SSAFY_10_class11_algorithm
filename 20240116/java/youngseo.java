import java.util.*;

//3개 틀리는데 이유를 모르겟음... 일단 답지 내고 생각해봄 
class Solution {
    public int[] solution(int[][] edges) {
        Map<Integer, int[]> map = new HashMap<>();
        int[] answer = new int[4];
        for (int[] edge : edges) {
            int[] value = map.getOrDefault(edge[0], new int[2]);
            value[0]++;
            map.put(edge[0], value);

            value = map.getOrDefault(edge[1], new int[2]);
            value[1]++;
            map.put(edge[1], value);

        }
        for (int i = 1; i <= map.size(); i++) {
            int[] value = map.get(i);
            if (value[0] >= 2) {
                if (value[1] == 0) {
                    answer[0] = i;
                }
                if (value[1] >= 2) {
                    answer[3]++;
                }
            }
            if (value[0] == 0 && value[1] > 0) {
                answer[2]++;
            }
        }
        answer[1] = map.get(answer[0])[0] - answer[2] - answer[3];
        return answer;
    }
}
