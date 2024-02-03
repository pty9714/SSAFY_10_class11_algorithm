class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 4;
        int[] result = solution.solution(n);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public int[] solution(int n) {
        int[][] triangle = new int[n][n];

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max += i;
        }
        int[] answer = new int[max];

        int[] dx = { 1, 0, -1 };
        int[] dy = { 0, 1, -1 };
        int index = 0;
        int x = 0;
        int y = 0;
        int dir = 0;

        while (index < max) {
            triangle[x][y] = index + 1;
            index++;
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || triangle[nx][ny] != 0) {
                dir = (dir + 1) % 3;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }
            x = nx;
            y = ny;
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (triangle[i][j] != 0) {
                    answer[count] = triangle[i][j];
                    count++;
                }
            }
        }

        return answer;
    }
}

// 구현 + 그래프 탐색
// 삼각형을 왼쪽으로 쭉 땡겨서 생각하기