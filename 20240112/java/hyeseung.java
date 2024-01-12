import java.io.*;
import java.util.StringTokenizer;

// 16340KB, 144ms
public class B12100 {
    private static int N, ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(board, 0);
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }

    // 최대 5번 이동할 때까지 dfs
    private static void dfs(int[][] board, int cnt) {
        if(cnt == 5) { // 최대 5번 이동하면 가장 큰 블록의 값 구하고 종료
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    ans = Math.max(ans, board[i][j]);
                }
            }
            return;
        }
        // 상, 하, 좌, 우로 이동하기
        for (int i = 0; i < 4; i++) {
            dfs(move(copyArray(board), i), cnt + 1);
        }
    }

    // 배열 깊은 복사
    private static int[][] copyArray(int[][] array) {
        int[][] copyArray = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                copyArray[i][j] = array[i][j];
            }
        }
        return copyArray;
    }

    // 상, 하, 좌, 우 이동 함수
    private static int[][] move(int[][] board, int dir) {
        switch (dir) {
            case 0: // 상
                moveUp(board);
                break;
            case 1: // 하
                moveDown(board);
                break;
            case 2: // 좌
                moveLeft(board);
                break;
            case 3: // 우
                moveRight(board);
                break;
        }
        return board;
    }

    private static void moveUp(int[][] board) {
        for (int j = 0; j < N; j++) {
            int notCombineBlockIndex = 0; // 아직 합쳐지지 않은 인덱스
            int notCombineBlockNum = 0; // 아직 합쳐지지 않은 인덱스의 숫자
            for (int i = 0; i < N; i++) {
                if(board[i][j] != 0) {
                    if(board[i][j] == notCombineBlockNum) { // 합쳐지는 경우
                        board[notCombineBlockIndex-1][j] += notCombineBlockNum;
                        board[i][j] = 0;
                        notCombineBlockNum = 0;
                    }
                    else if(board[i][j] != notCombineBlockNum) { // 합쳐지지 않는 경우
                        notCombineBlockNum = board[i][j];
                        board[i][j] = 0;
                        board[notCombineBlockIndex][j] = notCombineBlockNum;
                        notCombineBlockIndex++;
                    }
                }
            }
        }
    }

    private static void moveDown(int[][] board) {
        for (int j = 0; j < N; j++) {
            int notCombineBlockIndex = N-1; // 아직 합쳐지지 않은 인덱스
            int notCombineBlockNum = 0; // 아직 합쳐지지 않은 인덱스의 숫자
            for (int i = N-1; i >= 0; i--) {
                if(board[i][j] != 0) {
                    if(board[i][j] == notCombineBlockNum) { // 합쳐지는 경우
                        board[notCombineBlockIndex+1][j] += notCombineBlockNum;
                        board[i][j] = 0;
                        notCombineBlockNum = 0;
                    }
                    else if(board[i][j] != notCombineBlockNum) { // 합쳐지지 않는 경우
                        notCombineBlockNum = board[i][j];
                        board[i][j] = 0;
                        board[notCombineBlockIndex][j] = notCombineBlockNum;
                        notCombineBlockIndex--;
                    }
                }
            }
        }
    }

    private static void moveLeft(int[][] board) {
        for (int i = 0; i < N; i++) {
            int notCombineBlockIndex = 0; // 아직 합쳐지지 않은 인덱스
            int notCombineBlockNum = 0; // 아직 합쳐지지 않은 인덱스의 숫자
            for (int j = 0; j < N; j++) {
                if(board[i][j] != 0) {
                    if(board[i][j] == notCombineBlockNum) { // 합쳐지는 경우
                        board[i][notCombineBlockIndex-1] += notCombineBlockNum;
                        board[i][j] = 0;
                        notCombineBlockNum = 0;
                    }
                    else if(board[i][j] != notCombineBlockNum) { // 합쳐지지 않는 경우
                        notCombineBlockNum = board[i][j];
                        board[i][j] = 0;
                        board[i][notCombineBlockIndex] = notCombineBlockNum;
                        notCombineBlockIndex++;
                    }
                }
            }
        }
    }

    private static void moveRight(int[][] board) {
        for (int i = 0; i < N; i++) {
            int notCombineBlockIndex = N-1; // 아직 합쳐지지 않은 인덱스
            int notCombineBlockNum = 0; // 아직 합쳐지지 않은 인덱스의 숫자
            for (int j = N-1; j >= 0; j--) {
                if(board[i][j] != 0) {
                    if(board[i][j] == notCombineBlockNum) { // 합쳐지는 경우
                        board[i][notCombineBlockIndex+1] += notCombineBlockNum;
                        board[i][j] = 0;
                        notCombineBlockNum = 0;
                    }
                    else if(board[i][j] != notCombineBlockNum) { // 합쳐지지 않는 경우
                        notCombineBlockNum = board[i][j];
                        board[i][j] = 0;
                        board[i][notCombineBlockIndex] = notCombineBlockNum;
                        notCombineBlockIndex--;
                    }
                }
            }
        }
    }
}
/*
구현 + dfs
-> 구현에서 쌓는 과정에서 0으로 초기화하는 위치를 잘못해서 계속 틀렸다. 합쳐지지 않는 경우 초기화를 주의해야 한다.
그래서 구현한 방식은 움직인 방향쪽에서부터 인덱스를 옮기면서 쌓인 경우 해당 숫자를 한번 더하고 아직 쌓이지 않는 인덱스의 숫자 값을 0으로 초기화 한다. 쌓이지 않는 경우 해당 숫자를 쌓이도록 옮기고 아직 쌓이지 않는 인덱스를 다음으로 바꾸고
 */