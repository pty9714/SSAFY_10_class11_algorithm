class Solution {
    int cntO = 0;
    int cntX = 0;
    public int solution(String[] board) {
        int answer = count(board);
        if(answer != 0) {
            answer = progress(board);
        }
        return answer;
    }
    // O 개수와 X 개수 비교(0 : 정상적인 틱택토가 될 가능성 없음, 1 : O가 X보다 1개 더 많음 or O랑 X랑 개수 같음)
    public int count(String[] board) {
        for (String row : board) {
            for (int i = 0; i < 3; i++) {
                switch(row.charAt(i)) {
                    case 'O' : cntO++; break;
                    case 'X' : cntX++; break;
                }
            }
        }
        if(cntX > cntO || cntO - cntX >= 2) return 0;
        else return 1;
    }
    // 이미 승패가 결정났는데 계속 진행된 경우(0 정상적인 틱택토가 될 가능성 없음, 1 정상적인 틱택토일 가능성이 있음)
    public int progress(String[] board) {
        boolean winO = alreadyWinOrLose(board, 'O');
        boolean winX = alreadyWinOrLose(board, 'X');
        if(cntO == cntX && cntO >= 3 && alreadyWinOrLose(board, 'O')) {
            return 0;
        }
        else if(cntO - cntX == 1 && cntX >= 3 && alreadyWinOrLose(board, 'X')) {
            return 0;
        }
        else return 1;
    }
    // 승패 결정난 경우
    public boolean alreadyWinOrLose(String[] board, char player) {
        // 행
        for (String row : board) {
            int temp = 0;
            for (int i = 0; i < 3; i++) {
                if(row.charAt(i) == player) temp++;
            }
            if(temp == 3) return true;
        }
        // 열
        for (int i = 0; i < 3; i++) {
            int temp = 0;
            for (String row : board) {
                if(row.charAt(i) == player) temp++;
            }
            if(temp == 3) return true;
        }
        // 대각선
        int temp1 = 0, temp2 = 0, index = 0;
        for (String row : board) {
            if(row.charAt(index) == player) temp1++;
            if(row.charAt(2 - index) == player) temp2++;
            index++;
        }
        if(temp1 == 3 || temp2 == 3) return true;
        else return false;
    } 
}
/*
구현
-> 틱택토 될 가능성 없는 조건 구해서 구현하면 됨
테스트 1 〉	통과 (0.03ms, 74.3MB)
테스트 2 〉	통과 (0.02ms, 77.2MB)
테스트 3 〉	통과 (0.03ms, 80.9MB)
테스트 4 〉	통과 (0.06ms, 76MB)
테스트 5 〉	통과 (0.02ms, 77.1MB)
테스트 6 〉	통과 (0.03ms, 74.6MB)
테스트 7 〉	통과 (0.03ms, 74.4MB)
테스트 8 〉	통과 (0.02ms, 71.4MB)
테스트 9 〉	통과 (0.02ms, 70.8MB)
테스트 10 〉	통과 (0.02ms, 82.7MB)
테스트 11 〉	통과 (0.02ms, 71.7MB)
테스트 12 〉	통과 (0.03ms, 74.8MB)
테스트 13 〉	통과 (0.04ms, 74.4MB)
테스트 14 〉	통과 (0.05ms, 77.9MB)
테스트 15 〉	통과 (0.03ms, 71.4MB)
테스트 16 〉	통과 (0.03ms, 70.5MB)
테스트 17 〉	통과 (0.02ms, 74.4MB)
테스트 18 〉	통과 (0.02ms, 72.7MB)
테스트 19 〉	통과 (0.03ms, 70.9MB)
테스트 20 〉	통과 (0.02ms, 75.7MB)
테스트 21 〉	통과 (0.03ms, 76.5MB)
테스트 22 〉	통과 (0.03ms, 79.3MB)
테스트 23 〉	통과 (0.03ms, 74.2MB)
테스트 24 〉	통과 (0.03ms, 74.6MB)
테스트 25 〉	통과 (0.03ms, 75.9MB)
테스트 26 〉	통과 (0.02ms, 72.9MB)
테스트 27 〉	통과 (0.02ms, 71.6MB)
테스트 28 〉	통과 (0.03ms, 76.6MB)
테스트 29 〉	통과 (0.03ms, 77.2MB)
테스트 30 〉	통과 (0.04ms, 73.4MB)
테스트 31 〉	통과 (0.03ms, 74.5MB)
테스트 32 〉	통과 (0.03ms, 75.3MB)
테스트 33 〉	통과 (0.04ms, 73.8MB)
테스트 34 〉	통과 (0.05ms, 76.5MB)
테스트 35 〉	통과 (0.03ms, 77.7MB)
테스트 36 〉	통과 (0.03ms, 69.3MB)
테스트 37 〉	통과 (0.01ms, 73MB)
테스트 38 〉	통과 (0.04ms, 79.4MB)
테스트 39 〉	통과 (0.04ms, 74.1MB)
테스트 40 〉	통과 (0.03ms, 78.8MB)
테스트 41 〉	통과 (0.03ms, 74.2MB)
테스트 42 〉	통과 (0.02ms, 78.1MB)
테스트 43 〉	통과 (0.04ms, 66.5MB)
테스트 44 〉	통과 (0.03ms, 71.5MB)
테스트 45 〉	통과 (0.03ms, 66.7MB)
테스트 46 〉	통과 (0.02ms, 74.6MB)
테스트 47 〉	통과 (0.03ms, 71.4MB)
테스트 48 〉	통과 (0.04ms, 73.1MB)
테스트 49 〉	통과 (0.04ms, 74.1MB)
테스트 50 〉	통과 (0.03ms, 77.4MB)
테스트 51 〉	통과 (0.03ms, 69.9MB)
테스트 52 〉	통과 (0.03ms, 74.1MB)
테스트 53 〉	통과 (0.04ms, 76.5MB)
테스트 54 〉	통과 (0.04ms, 77.5MB)
*/