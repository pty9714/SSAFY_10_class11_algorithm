class Solution {
    // d, l, r, u
    static int dx[] = {1, 0, 0, -1};
    static int dy[] = {0, -1, 1, 0};
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();
    static int first = 0;
    static String result = null;
    
    public void dfs(int k, int count, int x, int y, int r, int c){
       if(count == k){
            if(x == r && y == c){
                result = sb.toString();
                first = 1;
            }
            return;
        }else{
            for(int i =0; i< 4; i++){
                int next_x = x +dx[i];
                int next_y = y + dy[i];
                if(Math.abs(r - next_x) + Math.abs(c - next_y) < (k - count) ){
                    if(next_x > 0 && next_x <= N && next_y > 0 && next_y <= M){
                            if(i == 0){
                                sb.append("d");
                            }else if(i == 1){
                                sb.append("l");
                            }else if(i == 2){
                                sb.append("r");
                            }else if(i == 3){
                                sb.append("u");
                    }
                    
                    dfs(k, count +1, next_x, next_y, r, c);
                    sb.deleteCharAt(sb.length() - 1);
                    }
                }
                if(first == 1)break;
            }
        }
    }
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        N = n;
        M = m;

        if((Math.abs(r-x) + Math.abs(c-y)) % 2 == k % 2){
            dfs(k, 0, x, y, r, c);
        }
        
        if(result == null){
            return "impossible";
        }else{
            return result;
        }
        
    }
}



// 	통과 (0.13ms, 80.3MB)
// 테스트 2 〉	통과 (0.15ms, 74MB)
// 테스트 3 〉	통과 (0.05ms, 81.5MB)
// 테스트 4 〉	통과 (0.09ms, 70.7MB)
// 테스트 5 〉	통과 (0.06ms, 77.4MB)
// 테스트 6 〉	통과 (0.05ms, 73.9MB)
// 테스트 7 〉	통과 (0.06ms, 71.9MB)
// 테스트 8 〉	통과 (0.09ms, 72MB)
// 테스트 9 〉	통과 (2.50ms, 74MB)
// 테스트 10 〉	통과 (3.04ms, 70MB)
// 테스트 11 〉	통과 (6.87ms, 76.3MB)
// 테스트 12 〉	통과 (1.63ms, 77.7MB)
// 테스트 13 〉	통과 (1.95ms, 71.8MB)
// 테스트 14 〉	통과 (1.71ms, 72.8MB)
// 테스트 15 〉	통과 (1.54ms, 78.7MB)
// 테스트 16 〉	통과 (2.09ms, 73.2MB)
// 테스트 17 〉	통과 (1.98ms, 78.7MB)
// 테스트 18 〉	통과 (2.18ms, 74.4MB)
// 테스트 19 〉	통과 (2.49ms, 78.4MB)
// 테스트 20 〉	통과 (2.29ms, 76.1MB)
// 테스트 21 〉	통과 (2.61ms, 79.7MB)
// 테스트 22 〉	통과 (2.45ms, 77MB)
// 테스트 23 〉	통과 (2.64ms, 74.8MB)
// 테스트 24 〉	통과 (2.74ms, 69.4MB)
// 테스트 25 〉	통과 (2.59ms, 76.4MB)
// 테스트 26 〉	통과 (2.39ms, 64.9MB)
// 테스트 27 〉	통과 (2.12ms, 65.6MB)
// 테스트 28 〉	통과 (2.57ms, 72.7MB)
// 테스트 29 〉	통과 (2.07ms, 75.9MB)
// 테스트 30 〉	통과 (2.21ms, 73.5MB)
// 테스트 31 〉	통과 (0.12ms, 73.7MB)
// 채점 결과
// 정확성: 100.0
// 합계: 100.0 / 100.0
