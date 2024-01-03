class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        int size = sequence.length;
        int[] a = new int[size];
        int[] b = new int[size];
        int k = 1;
        for(int i = 0; i < size; i++){
            a[i] = k;
            k*=-1;
            b[i] = k;
        }
        long x = 0, y = 0;
        for(int i = 0; i < size; i++){
            x += sequence[i] * a[i];
            y += sequence[i] * b[i];
            if(x < 0) x = 0;
            if(y < 0) y = 0;
            if(x > answer) answer = x;
            if(y > answer) answer = y;
        }
        return answer;
    }
}
/*
  테스트 1 〉	통과 (0.09ms, 94.7MB)
  테스트 2 〉	통과 (0.07ms, 72.7MB)
  테스트 3 〉	통과 (0.09ms, 66.3MB)
  테스트 4 〉	통과 (0.10ms, 77.4MB)
  테스트 5 〉	통과 (0.07ms, 74.4MB)
  테스트 6 〉	통과 (0.10ms, 76.4MB)
  테스트 7 〉	통과 (0.10ms, 73.7MB)
  테스트 8 〉	통과 (0.12ms, 73.5MB)
  테스트 9 〉	통과 (0.11ms, 75.5MB)
  테스트 10 〉	통과 (0.70ms, 74.9MB)
  테스트 11 〉	통과 (0.77ms, 82.6MB)
  테스트 12 〉	통과 (2.83ms, 81.1MB)
  테스트 13 〉	통과 (2.83ms, 78.2MB)
  테스트 14 〉	통과 (3.14ms, 80.5MB)
  테스트 15 〉	통과 (6.12ms, 80.3MB)
  테스트 16 〉	통과 (2.82ms, 93.9MB)
  테스트 17 〉	통과 (14.45ms, 124MB)
  테스트 18 〉	통과 (10.78ms, 136MB)
  테스트 19 〉	통과 (17.06ms, 134MB)
  테스트 20 〉	통과 (11.96ms, 124MB)
*/
