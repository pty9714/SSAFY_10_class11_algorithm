import java.util.PriorityQueue;

class Solution {
        static int[][] table;

        public int solution(int k, int n, int[][] reqs) {
            int answer = 0;
            
            // 1. 각 유형별 멘토 숫자에 따른 소요시간을 확인한다.
            table = new int[k+2][n+2];
            for(int i = 1; i <= k; i++){
                for(int j = 1; j <= n-k+1;j++){
                    table[i][j] = mentoring(i,j, reqs);
                    if(table[i][j] == table[i][j-1]) break;
                }
            }

            // 2. 소요시간의 합이 최소가 되는 구성을 찾는다.
            int[] idx = new int[k+1]; // table index 배열
            for(int i = 0; i <= k; i++) idx[i] = 1;

            for(int i = 0; i < n-k; i++){
                int max = -1;
                int type = 0;
                for(int j = 1; j <= k; j++){
                    if(table[j][idx[j]] - table[j][idx[j]+1] > max){
                        max = table[j][idx[j]] - table[j][idx[j]+1];
                        type = j;
                    }
                }
                idx[type]++;
            }
            for(int i = 1; i<=k; i++) answer+=table[i][idx[i]];

            return answer;
        }

        // 타입별 멘토 수에 따른 대기 시간 계산
        public int mentoring(int type, int mento, int[][] reqs){
            int sum = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int i = 0; i < mento; i++){
                pq.add(0);
            }
            for(int[] r: reqs){
                if(r[2] != type) continue;
                int curr = pq.poll();
                if(r[0] < curr) sum+=(curr-r[0]);
                else curr = r[0];
                pq.add(curr+r[1]);
            }
            return sum;
        }
    }

// 시간
// 테스트 1 〉	통과 (0.29ms, 72.6MB)
// 테스트 2 〉	통과 (0.34ms, 74.2MB)
// 테스트 3 〉	통과 (0.32ms, 78.4MB)
// 테스트 4 〉	통과 (0.37ms, 76.9MB)
// 테스트 5 〉	통과 (0.81ms, 75.5MB)
// 테스트 6 〉	통과 (0.71ms, 78.3MB)
// 테스트 7 〉	통과 (0.74ms, 78MB)
// 테스트 8 〉	통과 (0.48ms, 75.1MB)
// 테스트 9 〉	통과 (2.69ms, 78MB)
// 테스트 10 〉	통과 (2.32ms, 76.3MB)
// 테스트 11 〉	통과 (1.87ms, 73.7MB)
// 테스트 12 〉	통과 (2.23ms, 76.9MB)
// 테스트 13 〉	통과 (2.88ms, 77.7MB)
// 테스트 14 〉	통과 (2.32ms, 77.5MB)
// 테스트 15 〉	통과 (1.97ms, 78MB)
// 테스트 16 〉	통과 (1.97ms, 76.6MB)
// 테스트 17 〉	통과 (3.10ms, 75.5MB)
// 테스트 18 〉	통과 (2.52ms, 79.7MB)
// 테스트 19 〉	통과 (1.91ms, 76MB)
// 테스트 20 〉	통과 (1.99ms, 78MB)
