class Solution {
    public int solution(String[] board) {
        int answer = 1;
        int countO = 0;
        int countX = 0;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(board[i].charAt(j) == 'O')
                    countO++;
                else if(board[i].charAt(j) == 'X')
                    countX++;
            }
        }
        
        if(countO < countX)
            answer = 0;
        else if(countO > countX+1)
            answer = 0;
        else {
            boolean scoredO = false;
            boolean scoredX = false;
            
            for(int i=0; i<3; i++){
                if(board[i].equals("OOO"))
                    scoredO = true;
                else if (board[i].equals("XXX"))
                    scoredX = true;
                
                if(board[0].charAt(i) == 'O' && board[1].charAt(i) == 'O' && board[2].charAt(i) == 'O'){
                    scoredO = true;
                }
                else if(board[0].charAt(i) == 'X' && board[1].charAt(i) == 'X' && board[2].charAt(i) == 'X'){
                    scoredX = true;
                }   
            }
            
            if(board[0].charAt(0) == 'O' && board[1].charAt(1) == 'O' && board[2].charAt(2) == 'O'){
                scoredO = true;
            }
            else if(board[2].charAt(0) == 'O' && board[1].charAt(1) == 'O' && board[0].charAt(2) == 'O'){
                scoredO = true;
            }
            
            if(board[0].charAt(0) == 'X' && board[1].charAt(1) == 'X' && board[2].charAt(2) == 'X'){
                scoredX = true;
            }
            else if(board[2].charAt(0) == 'X' && board[1].charAt(1) == 'X' && board[0].charAt(2) == 'X'){
                scoredX = true;
            }
            
            System.out.println(scoredO + "" + scoredX);
            
            if(scoredO && scoredX)
                answer = 0;
            
            if (scoredO && countO == countX)
                answer = 0;
            
            if (scoredX && countO != countX)
                answer = 0;
            
        }
        
        
        return answer;
    }
}

/*
테스트 1 〉	통과 (8.51ms, 74.6MB)
테스트 2 〉	통과 (0.02ms, 74.6MB)
테스트 3 〉	통과 (8.01ms, 77.4MB)
테스트 4 〉	통과 (9.10ms, 78MB)
테스트 5 〉	통과 (0.03ms, 78.8MB)
테스트 6 〉	통과 (10.12ms, 73.6MB)
테스트 7 〉	통과 (12.21ms, 79.7MB)
테스트 8 〉	통과 (7.91ms, 74.8MB)
테스트 9 〉	통과 (0.02ms, 75MB)
테스트 10 〉	통과 (0.03ms, 79.2MB)
테스트 11 〉	통과 (9.57ms, 67.1MB)
테스트 12 〉	통과 (10.73ms, 78.2MB)
테스트 13 〉	통과 (13.33ms, 88.8MB)
테스트 14 〉	통과 (11.63ms, 66.7MB)
테스트 15 〉	통과 (10.24ms, 76.4MB)
테스트 16 〉	통과 (0.04ms, 71.4MB)
테스트 17 〉	통과 (12.13ms, 88.2MB)
테스트 18 〉	통과 (0.03ms, 73MB)
테스트 19 〉	통과 (10.69ms, 73.7MB)
테스트 20 〉	통과 (10.86ms, 72.9MB)
테스트 21 〉	통과 (10.56ms, 80.7MB)
테스트 22 〉	통과 (10.64ms, 80MB)
테스트 23 〉	통과 (7.57ms, 72.9MB)
테스트 24 〉	통과 (10.87ms, 77MB)
테스트 25 〉	통과 (9.03ms, 80.2MB)
테스트 26 〉	통과 (9.05ms, 75.9MB)
테스트 27 〉	통과 (0.03ms, 85.4MB)
테스트 28 〉	통과 (7.90ms, 79.5MB)
테스트 29 〉	통과 (7.41ms, 76MB)
테스트 30 〉	통과 (12.05ms, 89.2MB)
테스트 31 〉	통과 (9.67ms, 64.7MB)
테스트 32 〉	통과 (11.15ms, 76.4MB)
테스트 33 〉	통과 (10.86ms, 72.9MB)
테스트 34 〉	통과 (10.10ms, 79.1MB)
테스트 35 〉	통과 (25.03ms, 78.2MB)
테스트 36 〉	통과 (22.21ms, 81.9MB)
테스트 37 〉	통과 (0.03ms, 66.3MB)
테스트 38 〉	통과 (7.51ms, 75.1MB)
테스트 39 〉	통과 (7.80ms, 81.6MB)
테스트 40 〉	통과 (0.04ms, 76.5MB)
테스트 41 〉	통과 (9.71ms, 73.9MB)
테스트 42 〉	통과 (7.41ms, 73.5MB)
테스트 43 〉	통과 (11.09ms, 73.3MB)
테스트 44 〉	통과 (0.02ms, 81.9MB)
테스트 45 〉	통과 (8.67ms, 74.6MB)
테스트 46 〉	통과 (10.94ms, 79MB)
테스트 47 〉	통과 (9.36ms, 74.3MB)
테스트 48 〉	통과 (14.07ms, 76.7MB)
테스트 49 〉	통과 (11.84ms, 86.7MB)
테스트 50 〉	통과 (0.02ms, 71MB)
테스트 51 〉	통과 (11.17ms, 80.1MB)
테스트 52 〉	통과 (10.75ms, 74.3MB)
테스트 53 〉	통과 (9.18ms, 83MB)
테스트 54 〉	통과 (10.86ms, 77.9MB)
*/
