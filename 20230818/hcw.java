import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (el1, el2) -> {
            return el1[1] - el2[1];
        });
        
        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;
        for(int i =0; i < routes.length; i++){
            if(list.isEmpty()){
                list.add(routes[i][1]);
            }else{
                if(list.get(0) >= routes[i][0]){
                    list.add(routes[i][1]);
                }else{
                    list.clear();
                    list.add(routes[i][1]);
                    count++;
                }
            }
        }
        count++;
        return count;
    }
}

정확성  테스트
테스트 1 〉	통과 (0.52ms, 74.8MB)
테스트 2 〉	통과 (0.59ms, 75MB)
테스트 3 〉	통과 (0.57ms, 76.7MB)
테스트 4 〉	통과 (0.51ms, 67.9MB)
테스트 5 〉	통과 (0.89ms, 74.3MB)
효율성  테스트
테스트 1 〉	통과 (4.91ms, 52.9MB)
테스트 2 〉	통과 (3.79ms, 53.1MB)
테스트 3 〉	통과 (8.83ms, 55.8MB)
테스트 4 〉	통과 (0.90ms, 52MB)
테스트 5 〉	통과 (12.35ms, 56.1MB)
