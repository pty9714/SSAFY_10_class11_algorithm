import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        int camera = 30000;
        Arrays.sort(routes, (i1, i2) -> {
            if(i1[0] == i2[1]) return i1[1] - i2[1]; 
            return i1[0] - i2[0];
        });
        for (int i = 0; i < routes.length; i++) {
            if(camera < routes[i][0]) {
                answer++;
                camera = routes[i][1];
            }
            camera = Math.min(camera, routes[i][1]);
        }
        
        return answer;
    }
}
// 테스트 1 〉	통과 (0.73ms, 72.1MB)
// 테스트 2 〉	통과 (0.84ms, 80.3MB)
// 테스트 3 〉	통과 (0.83ms, 87.2MB)
// 테스트 4 〉	통과 (1.04ms, 77.8MB)
// 테스트 5 〉	통과 (0.69ms, 74.5MB)
// 효율성  테스트
// 테스트 1 〉	통과 (4.05ms, 53.1MB)
// 테스트 2 〉	통과 (3.12ms, 52.2MB)
// 테스트 3 〉	통과 (8.18ms, 58MB)
// 테스트 4 〉	통과 (0.89ms, 52.3MB)
// 테스트 5 〉	통과 (12.00ms, 57.2MB)