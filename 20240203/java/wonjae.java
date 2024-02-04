import java.awt.Point;

class Solution {
    static int[] dx = {1, 0, -1};
    static int[] dy = {0, 1, -1};
    public int[] solution(int n) {
        int[] answer = {};
        int[][] snail = new int[n][n];
        int dir = 0, cnt = n;
        Point p = new Point(0, 0);
        int num = 1;
        while(cnt > 0){
            for(int i = 0; i < cnt; i++){
                snail[p.x][p.y] = num++;
                p.x+=dx[dir];
                p.y+=dy[dir];
            }
            p.x-=dx[dir];
            p.y-=dy[dir];
            dir=(dir+1)%3;
            p.x+=dx[dir];
            p.y+=dy[dir];
            cnt--;
        }
        
        answer = new int[num-1];
        cnt = 0;
        
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                answer[cnt++] = snail[i][j];
            }
        }
        
        return answer;
    }
}
