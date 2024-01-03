class Solution {
    public int solution(String[] board) {
        int answer = 1;
        int o_count = 0;
        int x_count = 0;
        char winner =' ';
        int[] line = new int[]{0,0};
        
        for(int i = 0; i < 3; i++){
            char curr = ' ';
            for(int j = 0; j < 3; j++){
                if(j == 0) curr = board[i].charAt(j);
                else if (j == 2 && curr != '.' && curr == board[i].charAt(1) && curr == board[i].charAt(2)){
                    if(line[0] == 1) answer = 0;
                    winner = curr;
                    line[0] = 1;
                }
                if(board[i].charAt(j) == 'O') o_count++;
                else if(board[i].charAt(j) == 'X') x_count++;
            }
        }

        for(int i = 0; i < 3; i++){
            char curr = ' ';
            for(int j = 0; j < 3; j++){
                if(j == 0) curr = board[j].charAt(i);
                else if (j == 2 && curr != '.' && curr == board[1].charAt(i) && curr == board[2].charAt(i)){
                    if(line[0] == 2) answer = 0;
                    winner = curr;
                    line[0] = 2;
                }
            }
        }
        
        if(winner == ' '){
            if(board[0].charAt(0) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(2)) winner = board[0].charAt(0);
            if(board[0].charAt(2) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(0)) winner = board[0].charAt(2);
        }
        
        if(o_count == x_count){
         if(winner == 'O') answer = 0;
        }
        else if(o_count == x_count + 1){
            if(winner == 'X') answer = 0;
        }
        else answer = 0;
        return answer;
    }
}
/*
테스트 1 〉	통과 (0.02ms, 71.6MB)
테스트 2 〉	통과 (0.02ms, 72.4MB)
테스트 3 〉	통과 (0.03ms, 74.6MB)
테스트 4 〉	통과 (0.04ms, 70.4MB)
테스트 5 〉	통과 (0.04ms, 69.9MB)
테스트 6 〉	통과 (0.03ms, 72.2MB)
테스트 7 〉	통과 (0.02ms, 78.4MB)
테스트 8 〉	통과 (0.04ms, 75.9MB)
테스트 9 〉	통과 (0.03ms, 78.7MB)
테스트 10 〉	통과 (0.03ms, 74.2MB)
테스트 11 〉	통과 (0.03ms, 78.5MB)
테스트 12 〉	통과 (0.02ms, 69.7MB)
테스트 13 〉	통과 (0.03ms, 76.6MB)
테스트 14 〉	통과 (0.02ms, 72.8MB)
테스트 15 〉	통과 (0.03ms, 77.4MB)
테스트 16 〉	통과 (0.02ms, 76.4MB)
테스트 17 〉	통과 (0.02ms, 78MB)
테스트 18 〉	통과 (0.03ms, 76.2MB)
테스트 19 〉	통과 (0.03ms, 78MB)
테스트 20 〉	통과 (0.03ms, 73.6MB)
테스트 21 〉	통과 (0.03ms, 76.4MB)
테스트 22 〉	통과 (0.03ms, 74MB)
테스트 23 〉	통과 (0.03ms, 74.9MB)
테스트 24 〉	통과 (0.02ms, 70.9MB)
테스트 25 〉	통과 (0.02ms, 73.3MB)
테스트 26 〉	통과 (0.03ms, 72MB)
테스트 27 〉	통과 (0.03ms, 73.6MB)
테스트 28 〉	통과 (0.04ms, 77.1MB)
테스트 29 〉	통과 (0.03ms, 71.8MB)
테스트 30 〉	통과 (0.03ms, 74.1MB)
테스트 31 〉	통과 (0.03ms, 73MB)
테스트 32 〉	통과 (0.03ms, 73.2MB)
테스트 33 〉	통과 (0.02ms, 73.2MB)
테스트 34 〉	통과 (0.03ms, 74.8MB)
테스트 35 〉	통과 (0.04ms, 71.9MB)
테스트 36 〉	통과 (0.03ms, 76.3MB)
테스트 37 〉	통과 (0.03ms, 70.3MB)
테스트 38 〉	통과 (0.02ms, 72.6MB)
테스트 39 〉	통과 (0.03ms, 70.8MB)
테스트 40 〉	통과 (0.03ms, 78.9MB)
테스트 41 〉	통과 (0.03ms, 74.6MB)
테스트 42 〉	통과 (0.03ms, 79.7MB)
테스트 43 〉	통과 (0.03ms, 74.5MB)
테스트 44 〉	통과 (0.02ms, 74.3MB)
테스트 45 〉	통과 (0.03ms, 75.9MB)
테스트 46 〉	통과 (0.02ms, 68.6MB)
테스트 47 〉	통과 (0.03ms, 79.3MB)
테스트 48 〉	통과 (0.03ms, 70.7MB)
테스트 49 〉	통과 (0.03ms, 75.7MB)
테스트 50 〉	통과 (0.03ms, 76.4MB)
테스트 51 〉	통과 (0.03ms, 74.3MB)
테스트 52 〉	통과 (0.02ms, 88.6MB)
테스트 53 〉	통과 (0.03ms, 67.8MB)
테스트 54 〉	통과 (0.02ms, 77.1MB)

*/
