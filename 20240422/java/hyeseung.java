import java.util.*;
class Solution {
    int answer = 0;
    ArrayList<ArrayList<Integer>> shipRoad = new ArrayList<ArrayList<Integer>>();
    boolean[] light;
    boolean[] visited;
    public int solution(int n, int[][] lighthouse) {
        for (int i = 0; i < n; i++) {
            shipRoad.add(new ArrayList<Integer>());
        }
        light = new boolean[n];
        visited = new boolean[n];
        for (int[] relation : lighthouse) {
            shipRoad.get(relation[0] - 1).add(relation[1] - 1);
            shipRoad.get(relation[1] - 1).add(relation[0] - 1);
        }
        for (int i = 0; i < n; i++) {
            if(!light[i])
                dfs(i, i);
        }
        return answer;
    }
    private void dfs(int first, int middle) {
        for (int last : shipRoad.get(middle)) {
            if(first == last || light[middle] || visited[last]) continue;
            visited[middle] = true;
            dfs(middle, last);
            if(!light[first] && !light[last]) {
                light[middle] = true;
                answer++;
            }
        }
    }
}
/*
테스트 1 〉	통과 (87.92ms, 117MB)
테스트 2 〉	통과 (64.81ms, 119MB)
테스트 3 〉	통과 (82.91ms, 111MB)
테스트 4 〉	통과 (96.39ms, 126MB)
테스트 5 〉	통과 (70.73ms, 113MB)
테스트 6 〉	통과 (72.84ms, 121MB)
테스트 7 〉	통과 (81.20ms, 126MB)
테스트 8 〉	통과 (78.31ms, 107MB)
테스트 9 〉	통과 (87.62ms, 123MB)
테스트 10 〉	통과 (75.25ms, 124MB)
테스트 11 〉	통과 (66.70ms, 117MB)
테스트 12 〉	통과 (21.56ms, 98.9MB)
테스트 13 〉	통과 (10.99ms, 97MB)
테스트 14 〉	통과 (0.03ms, 72MB)
테스트 15 〉	통과 (3.40ms, 80.3MB)
테스트 16 〉	통과 (6.60ms, 87.5MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
 */