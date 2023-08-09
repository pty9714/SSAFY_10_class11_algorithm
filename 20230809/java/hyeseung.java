import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int len = book_time.length;
        ArrayList<int[]> time = new ArrayList<>();
        
        for(int i = 0; i < len; i++) {
            int start = Integer.parseInt(book_time[i][0].replace(":", "")); 
            int end = Integer.parseInt(book_time[i][1].replace(":", "")) + 10; 
            time.add(new int[] {start, end % 100 >= 60 ? end + 40 : end});
        }
        Collections.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] i1, int[] i2) {
                return i1[0] - i2[0];
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int[] t : time){
            if(pq.size() == 0){
                pq.add(t[1]);
                continue;
            }
            if((pq.peek()) <= t[0]){
                pq.poll();
                pq.add(t[1]);
            }else{
            
                pq.add(t[1]);
            }
        }
        
        return pq.size();
    }
}
/*
테스트 1 〉	통과 (1.14ms, 74.8MB)
테스트 2 〉	통과 (8.15ms, 75.9MB)
테스트 3 〉	통과 (6.45ms, 77MB)
테스트 4 〉	통과 (4.04ms, 72.7MB)
테스트 5 〉	통과 (2.57ms, 77.7MB)
테스트 6 〉	통과 (5.53ms, 82.4MB)
테스트 7 〉	통과 (6.17ms, 76.8MB)
테스트 8 〉	통과 (3.40ms, 77.4MB)
테스트 9 〉	통과 (2.36ms, 78.1MB)
테스트 10 〉	통과 (3.92ms, 76.5MB)
테스트 11 〉	통과 (6.83ms, 73.3MB)
테스트 12 〉	통과 (5.49ms, 79MB)
테스트 13 〉	통과 (3.76ms, 77.3MB)
테스트 14 〉	통과 (4.07ms, 77.6MB)
테스트 15 〉	통과 (7.59ms, 75.9MB)
테스트 16 〉	통과 (2.97ms, 76.8MB)
테스트 17 〉	통과 (6.42ms, 73.1MB)
테스트 18 〉	통과 (3.54ms, 76.2MB)
테스트 19 〉	통과 (5.19ms, 79.1MB)
*/