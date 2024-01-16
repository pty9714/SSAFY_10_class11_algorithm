import java.util.HashMap;
import java.util.Map;

public class Solution {

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

// 그래프를 세는 것이 아니라, 그래프의 특정 정점의 특징을 기준으로 그래프 갯수를 셈.
// 생성한 정점 : 2개 이상 밖으로 나가고, 들어오는게 0개
// 막대 그래프 : 들어오는게 1개 이상, 나가는게 0개인 정점
// 도넛 그래프 : 가운데서 연결 해주는게 나가는거 2개 이상, 들어오는거 2개 이상임
// 도넛 : 나머지