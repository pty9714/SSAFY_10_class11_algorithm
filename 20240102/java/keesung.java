public class Solution {
    public int solution(String[] board) {
        // 선공까지 한 경우 O가 X보다 1개 더 많아야 한다.
        // 선공까지 한 경우에는 XXX 가 나오면 안된다.

        // 후공까지 한 경우 두개가 같아야 한다.
        // 후공까지 한 경우에는 OOO 가 나오면 안된다.

        char[][] boardChar = new char[3][3];
        for (int i = 0; i < board.length; i++) {
            boardChar[i] = board[i].toCharArray();
        }

        int xCount = 0;
        int oCount = 0;
        for (int i = 0; i < boardChar.length; i++) {
            for (int j = 0; j < boardChar[i].length; j++) {
                if (boardChar[i][j] == 'X') {
                    xCount++;
                } else if (boardChar[i][j] == 'O') {
                    oCount++;
                }
            }
        }

        int[][][] check = {
                { { 0, 0 }, { 0, 1 }, { 0, 2 } },
                { { 1, 0 }, { 1, 1 }, { 1, 2 } },
                { { 2, 0 }, { 2, 1 }, { 2, 2 } },
                { { 0, 0 }, { 1, 0 }, { 2, 0 } },
                { { 0, 1 }, { 1, 1 }, { 2, 1 } },
                { { 0, 2 }, { 1, 2 }, { 2, 2 } },
                { { 0, 0 }, { 1, 1 }, { 2, 2 } },
                { { 0, 2 }, { 1, 1 }, { 2, 0 } }
        };

        int xWinCount = 0;
        int oWinCount = 0;
        for (int i = 0; i < check.length; i++) {
            int xTempCount = 0;
            int oTempCount = 0;
            for (int j = 0; j < check[i].length; j++) {
                if (boardChar[check[i][j][0]][check[i][j][1]] == 'X') {
                    xTempCount++;
                } else if (boardChar[check[i][j][0]][check[i][j][1]] == 'O') {
                    oTempCount++;
                }
            }
            if (xTempCount == 3) {
                xWinCount++;
            }
            if (oTempCount == 3) {
                oWinCount++;
            }
        }

        int answer = 0;
        if (oCount == xCount + 1) { // 선공까지 한 경우
            if (xWinCount == 0) {
                answer = 1;
            }
        }
        if (oCount == xCount) { // 후공까지 한 경우
            if (oWinCount == 0) {
                answer = 1;
            }
        }
        return answer;
    }

}

// 처음에 2번 이상 이기는 경우도 카운팅 해서 몇개 틀렸었음
// 2번 이상 이기는 경우는 5개로 만들어지면 무조건 겹쳐서 아무 상관이 없었음
// 6개로 만들어지는 경우는 애초에 고려대상이 아니었음