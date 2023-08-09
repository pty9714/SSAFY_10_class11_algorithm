import java.util.*;

class Solution {
    public int solution(String[][] book_time) {   
        int n = book_time.length;
        int[][] bookTime = new int[n][2];
        for (int i = 0; i < n; i++) {
            bookTime[i][0] = change(book_time[i][0]);
            bookTime[i][1] = change(book_time[i][1]) + 10;
        }        
        Arrays.sort(bookTime, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<Integer> rooms = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int s = bookTime[i][0];
            int e = bookTime[i][1];
            
            if (rooms.isEmpty()) {
                rooms.add(e);
                continue;
            }
            
            boolean flag = false;
            for (int j = 0; j < rooms.size(); j++) {
                if (rooms.get(j) <= s) {
                    rooms.set(j, e);
                    flag = true;
                    break;
                }
            }
            if(!flag) rooms.add(e);
        }
        return rooms.size();
    }

    static int change(String time) {
        return Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));
    }
}

// 테스트 19 〉	통과 (18.30ms, 83.5MB)