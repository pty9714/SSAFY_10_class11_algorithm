import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static int n;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int cnt) {
        if (cnt == 5) {
            getMax();
            return;
        }

        int[][] tempBoard = new int[n][n];
        for (int i = 0; i < n; i++) {
            tempBoard[i] = board[i].clone();
        }

        for (int d = 0; d < 4; d++) {
            move(d);
            dfs(cnt + 1);
            for (int i = 0; i < n; i++) {
                board[i] = tempBoard[i].clone();
            }
        }
    }

    private static void getMax() {
        for (int[] row : board) {
            for (int col : row) {
                ans = Math.max(ans, col);
            }
        }
    }

    static void move(int d) {
        int idx, temp;
        switch (d) {
            case 0:
                for (int j = 0; j < n; j++) {
                    idx = 0;
                    for (int i = 1; i < n; i++) {
                        if (board[i][j] != 0) {
                            temp = board[i][j];
                            board[i][j] = 0;
                            if (board[idx][j] == 0) {
                                board[idx][j] = temp;
                            } else if (board[idx][j] == temp) {
                                board[idx][j] = temp * 2;
                                idx++;
                            } else {
                                idx++;
                                board[idx][j] = temp;
                            }
                        }
                    }
                }
                break;
            case 1:
                for (int j = 0; j < n; j++) {
                    idx = n - 1;
                    for (int i = n - 2; i >= 0; i--) {
                        if (board[i][j] != 0) {
                            temp = board[i][j];
                            board[i][j] = 0;
                            if (board[idx][j] == 0) {
                                board[idx][j] = temp;
                            } else if (board[idx][j] == temp) {
                                board[idx][j] = temp * 2;
                                idx--;
                            } else {
                                idx--;
                                board[idx][j] = temp;
                            }
                        }
                    }
                }
                break;
            case 2:
                for (int i = 0; i < n; i++) {
                    idx = 0;
                    for (int j = 1; j < n; j++) {
                        if (board[i][j] != 0) {
                            temp = board[i][j];
                            board[i][j] = 0;
                            if (board[i][idx] == 0) {
                                board[i][idx] = temp;
                            } else if (board[i][idx] == temp) {
                                board[i][idx] = temp * 2;
                                idx++;
                            } else {
                                idx++;
                                board[i][idx] = temp;
                            }
                        }
                    }
                }
                break;
            case 3:
                for (int i = 0; i < n; i++) {
                    idx = n - 1;
                    for (int j = n - 2; j >= 0; j--) {
                        if (board[i][j] != 0) {
                            temp = board[i][j];
                            board[i][j] = 0;
                            if (board[i][idx] == 0) {
                                board[i][idx] = temp;
                            } else if (board[i][idx] == temp) {
                                board[i][idx] = temp * 2;
                                idx--;
                            } else {
                                idx--;
                                board[i][idx] = temp;
                            }
                        }
                    }
                }
                break;
        }
    }
}
