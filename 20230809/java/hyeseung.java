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
        answer = pq.size();
        return answer;
    }
}
/*
테스트 1 〉	통과 (0.86ms, 77.9MB)
테스트 2 〉	통과 (2.79ms, 78.2MB)
테스트 3 〉	통과 (5.67ms, 65.9MB)
테스트 4 〉	통과 (4.38ms, 82.8MB)
테스트 5 〉	통과 (0.66ms, 79.4MB)
테스트 6 〉	통과 (3.89ms, 78.4MB)
테스트 7 〉	통과 (5.05ms, 77.3MB)
테스트 8 〉	통과 (3.47ms, 73.2MB)
테스트 9 〉	통과 (2.45ms, 73.2MB)
테스트 10 〉	통과 (3.97ms, 76.6MB)
테스트 11 〉	통과 (6.53ms, 79.6MB)
테스트 12 〉	통과 (5.83ms, 79MB)
테스트 13 〉	통과 (2.41ms, 72.2MB)
테스트 14 〉	통과 (4.91ms, 91.3MB)
테스트 15 〉	통과 (4.37ms, 75.6MB)
테스트 16 〉	통과 (3.61ms, 86.4MB)
테스트 17 〉	통과 (7.45ms, 85MB)
테스트 18 〉	통과 (4.16ms, 79.3MB)
테스트 19 〉	통과 (6.43ms, 81.5MB)
*/