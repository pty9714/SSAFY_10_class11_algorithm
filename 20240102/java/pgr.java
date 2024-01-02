class Solution {
    public int solution(String[] board) {
        int cntO = 0;
        int cntX = 0;
        //O와 X의 개수를 센다.
        for (String row : board) {
            for (int i = 0; i < 3; i++) {
                switch (row.charAt(i)) {
                    case 'O' : cntO++; break;
                    case 'X' : cntX++; break;
                }
            }
        }

        //'X'가 'O'보다 많으면 규칙 위반
        if (cntX > cntO) {
            return 0;
        }

        //'O'가 'X'보다 2개이상 많으면 규칙 위반
        if (cntO > cntX + 1) {
            return 0;
        }

        //O가 완성 되었을 때 X가 O의 개수와 같으면 규칙 위반
        if (isWin(board, 'O') && cntO == cntX) {
            return 0;
        }
        
        //X가 완성 되었을 때 O가 X보다 1개 많으면 규칙 위반
        if (isWin(board, 'X') && cntO == cntX + 1) {
            return 0;
        }
        
        return 1;
    }

    private static boolean isWin(String[] board, char ch) {
        //가로 검사
        for (String row : board) {
            int cnt = 0;
            for (int i = 0; i < 3; i++) {
                if (row.charAt(i) == ch) {
                    cnt++;
                }
            }
            if (cnt == 3) {
                return true;
            }
        }
        //세로 검사
        for (int i = 0; i < 3; i++) {
            int cnt = 0;
            for (String row : board) {
                if (row.charAt(i) == ch) {
                    cnt++;
                }
            }
            if (cnt == 3) {
                return true;
            }
        }
        //대각선 검사
        int cnt1 = 0, cnt2 = 0, idx = 0;
        for (String row : board) {
            if (row.charAt(idx) == ch) {
                cnt1++;
            }
            if (row.charAt(2 - idx) == ch) {
                cnt2++;
            }
            idx++;
        }
        if (cnt1 == 3 || cnt2 == 3) {
            return true;
        }
        return false;
    }
}
