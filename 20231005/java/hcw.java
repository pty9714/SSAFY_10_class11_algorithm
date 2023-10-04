class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] board = new int[rows][columns];
        int num = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = num++;
            }
        }

        int k = 0;
        for (int[] query : queries) {
            int horizontal = query[3] - query[1];
            int vertical   = query[2] - query[0];

            int firstRow    = query[0] - 1;
            int firstColumn = query[1] - 1;
            int lastRow     = query[2] - 1;
            int lastColumn  = query[3] - 1;

            int start = board[firstRow][firstColumn];
            int min = start;

            for (int i = 0; i < vertical; i++) {
                board[firstRow + i][firstColumn] = board[firstRow + (i+1)][firstColumn];
                if (board[firstRow + i][firstColumn] < min)
                    min = board[firstRow + i][firstColumn];
            }

            for (int i = 0; i < horizontal; i++) {
                board[lastRow][firstColumn + i] = board[lastRow][firstColumn + (i+1)];
                if (board[lastRow][firstColumn + i] < min)
                    min = board[lastRow][firstColumn + i];
            }

            for (int i = 0; i < vertical; i++) {
                board[lastRow - i][lastColumn] = board[lastRow - (i+1)][lastColumn];
                if (board[lastRow - i][lastColumn] < min)
                    min = board[lastRow - i][lastColumn];
            }

            for (int i = 0; i < horizontal - 1; i++) {
                board[firstRow][lastColumn - i] = board[firstRow][lastColumn - (i+1)];
                if (board[firstRow][lastColumn - i] < min)
                    min = board[firstRow][lastColumn - i];
            }

            board[firstRow][firstColumn + 1] = start;

            answer[k++] = min;
        }

        return answer;
    }
}
