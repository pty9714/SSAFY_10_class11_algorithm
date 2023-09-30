class Solution {
    public int dx[] = {-1, 1, 0, 0};
    public int dy[] = {0, 0, -1, 1};
    public int N, M;
    
    static class Result {
        boolean isWin;
        int cnt;
        
        Result(boolean isWin, int cnt) {
            this.isWin = isWin;
            this.cnt = cnt;
        }
    }
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        N = board.length;
        M = board[0].length;
        return dfs(board, aloc, bloc, 0).cnt;
    }
    
    public Result dfs(int[][] board, int[] aloc, int[] bloc, int cnt) {
	    if (board[aloc[0]][aloc[1]] == 0)
		    return new Result(false, cnt);
        boolean isEnd = true;
        int win = Integer.MAX_VALUE;
        int lose = 0;
        board[aloc[0]][aloc[1]] = 0;
        for(int i = 0; i < 4; i++) {
            int tempX = aloc[0] + dx[i];
            int tempY = aloc[1] + dy[i];
            if(tempX < 0 || tempX >= N || tempY < 0 || tempY >= M || board[tempX][tempY] == 0) continue;
            isEnd = false;
            Result result = dfs(board, bloc, new int[] {tempX, tempY}, cnt + 1);
            if(result.isWin) {
                lose = Math.max(lose, result.cnt);
            }
            else {
                win = Math.min(win, result.cnt);
            }
        }
        board[aloc[0]][aloc[1]] = 1;
        if(isEnd) {
            return new Result(false, cnt);
        }
        else if(win != Integer.MAX_VALUE) {
            return new Result(true, win);
        }
        else {
            return new Result(false, lose);
        }
    }
}
