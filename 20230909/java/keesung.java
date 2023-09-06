import java.awt.Point;
import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skills) {
        for (int i = 0; i < skills.length; i++) {
            int type = skills[i][0];
            int r1 = skills[i][1];
            int c1 = skills[i][2];
            int r2 = skills[i][3];
            int c2 = skills[i][4];
            int degree = skills[i][5];

            if (type == 1) {
                for (int r = r1; r <= r2; r++) {
                    for (int c = c1; c <= c2; c++) {
                        board[r][c] -= degree;
                    }
                }
            } else {
                for (int r = r1; r <= r2; r++) {
                    for (int c = c1; c <= c2; c++) {
                        board[r][c] += degree;
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] > 0)
                    answer++;
            }
        }

        return answer;
    }
}
