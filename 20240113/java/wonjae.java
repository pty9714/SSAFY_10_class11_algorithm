import java.util.HashMap;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        HashMap<String, Integer> hashMap = new HashMap<>();
        int n = friends.length;
        int[][] table = new int[n][n];
        int[][] point = new int[n][2];
        int[] this_month = new int[n];

        for(int i = 0; i < n; i++){
            hashMap.put(friends[i], i);
        }
        for(String s : gifts){
            String[] a = s.split(" ");
            int from = hashMap.get(a[0]);
            int to = hashMap.get(a[1]);
            table[from][to]++;
            point[from][0]++;
            point[to][1]++;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                if(table[i][j] > table[j][i]) this_month[i]++;
                if(table[i][j] == table[j][i] && (point[i][0]-point[i][1]) > (point[j][0]-point[j][1])) this_month[i]++;
            }
            answer=Math.max(answer, this_month[i]);
        }


        return answer;
    }
}
/*
  테스트 1 〉	통과 (0.21ms, 71.1MB)
  테스트 2 〉	통과 (0.36ms, 72.4MB)
  테스트 3 〉	통과 (0.49ms, 73.1MB)
  테스트 4 〉	통과 (0.23ms, 74.6MB)
  테스트 5 〉	통과 (3.64ms, 78MB)
  테스트 6 〉	통과 (0.73ms, 82MB)
  테스트 7 〉	통과 (1.81ms, 76.8MB)
  테스트 8 〉	통과 (1.87ms, 74MB)
  테스트 9 〉	통과 (7.63ms, 78.6MB)
  테스트 10 〉	통과 (6.31ms, 85.2MB)
  테스트 11 〉	통과 (5.91ms, 83.4MB)
  테스트 12 〉	통과 (4.93ms, 87.1MB)
  테스트 13 〉	통과 (11.86ms, 98.4MB)
  테스트 14 〉	통과 (12.66ms, 97.3MB)
  테스트 15 〉	통과 (13.05ms, 88.4MB)
  테스트 16 〉	통과 (10.08ms, 100MB)
  테스트 17 〉	통과 (1.27ms, 77.9MB)
  테스트 18 〉	통과 (6.66ms, 91.4MB)
  테스트 19 〉	통과 (12.81ms, 86.7MB)
  테스트 20 〉	통과 (3.79ms, 75.6MB)
*/
