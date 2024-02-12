class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
            int[][] map = new int[n+1][n+1];
            for(int[] r : results){
                map[r[0]][r[1]] = 1;
                map[r[1]][r[0]] = -1;
            }

            for(int mid = 1; mid < n+1; mid++){
                for(int start = 1; start < n+1; start++){
                    for(int end = 1; end < n+1; end++){
                        if(map[start][mid] == 1 && map[mid][end] == 1) {
                            map[start][end] = 1;
                        }
                        if(map[start][mid] == -1 && map[mid][end] == -1){
                            map[start][end] = -1;
                        }
                    }
                }
            }

            for(int i = 1; i < n+1; i++){
                int count = 0;
                for(int j = 1; j < n+1; j++){
                    if(map[i][j] != 0) count++;
                }
                if(count == n-1) answer++;
            }

            return answer;
    }
}
