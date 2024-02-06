import java.io.*;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 	12120KB, 108ms
public class B1553 {
    static class Snake implements Comparable<Snake> {
        int x;
        int y;
        int sec;
        Snake(int x, int y, int sec) {
            this.x = x;
            this.y = y;
            this.sec = sec;
        }

        @Override
        public int compareTo(Snake o) { // 초 작은 순서대로 정렬
            return this.sec - o.sec;
        }
    }
    public static int N, x = 0, y = 0, ans = 0;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int[][] board;
    public static int dir = 1;
    public static PriorityQueue<Snake> snakes = new PriorityQueue<>(); // 뱀 좌표 (꼬리 좌표가 우선순위 제일 높음)
    public static HashMap<Integer, Character> spin = new HashMap<>(); // 뱀의 방향 변환 정보 저장
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        // 사과 놓인 곳
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            board[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 1;
        }
        // 뱀의 방향 변환 정보 (게임 시작 시간으로부터 X초가 끝난 뒤에 왼쪽(L), 오른쪽(D)로 90도 회전)
        int L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            spin.put(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0));
        }
        simulate(); // 게임 시작
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
    public static void simulate() {
        // 시작 위치
        board[0][0] = -1;
        snakes.offer(new Snake(0, 0, 0));
        while(true) {
            ans++; // 초 증가
            int tempX = x + dx[dir];
            int tempY = y + dy[dir];
            // 벽이나 자신의 몸과 부딪히면 게임 끝
            if(tempX < 0 || tempX >= N || tempY < 0 || tempY >= N || board[tempX][tempY] == -1) {
                return;
            }
            // 사과가 없을 경우 꼬리 삭제
            if(board[tempX][tempY] == 0 && !snakes.isEmpty()) {
                Snake snake = snakes.poll();
                board[snake.x][snake.y] = 0;
            }
            // 머리 이동
            board[tempX][tempY] = -1;
            snakes.offer(new Snake(tempX, tempY, ans));
            x = tempX; y = tempY;
            // X초가 끝난 뒤에 왼쪽(L), 오른쪽(D)로 90도 회전
            if(spin.containsKey(ans)) {
                spin(spin.get(ans));
            }
        }
    }
    public static void spin(char C) {
        switch(C) {
            case 'L' : // 왼쪽으로 회전
                dir = dir == 0 ? dir + 3 : dir - 1;
                break;
            case 'D' : // 오른쪽으로 회전
                dir = (dir + 1) % 4;
                break;
        }
    }
}
/*
구현
-> 꼬리 체크를 위해 PQ 사용, 방향 회전을 위해 HashMap 사용
 */