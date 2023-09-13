import java.util.PriorityQueue;

class Solution {
    static class Time implements Comparable<Time> {
        int hour;
        int min;
        public Time(int hour, int min) {
            this.hour = hour;
            this.min = min;
        }
        @Override
        public int compareTo(Time o) {
            if(this.hour == o.hour) {
                return this.min - o.min;
            }
            return this.hour - o.hour;
        }
    }
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        
        PriorityQueue<Time> timeList = new PriorityQueue<>();
        
        // 마지막 셔틀 운행 시간 구하기
        Time lastTime = new Time(9, 0);
        lastTime.hour += (n - 1) * t / 60;
        lastTime.min += (n - 1) * t % 60;
        
        // 마지막 셔틀 운행 시간 이후에 도착한 크루 빼고 배열에 넣기
        for(String time : timetable) {
            String[] splitTime = time.split(":");
            int hour = Integer.parseInt(splitTime[0]);
            int min = Integer.parseInt(splitTime[1]);
            if(hour < lastTime.hour || (hour == lastTime.hour && min <= lastTime.min)) { // 셔틀 운행 시간 이후인 경우
                timeList.offer(new Time(hour, min));
            }    
        }
        
        int boardTime = 9 * 60; // 셔틀 운행 시간
        Time lastBoardTime = null; // 마지막 셔틀 운행 시간에 마지막으로 탑승한 크루 찾기
        boolean flag = false; 
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(timeList.isEmpty()) { // 마지막 셔틀 운행 시간에 콘이 셔틀을 탈 수 있는 경우 -> 마지막 셔틀 운행 시간
                    flag = true;
                    break;
                }
                Time time = timeList.peek();
                if(time.hour > boardTime / 60 || (time.hour == boardTime / 60 && time.min > boardTime % 60)) { // 셔틀 운행 시간 이후인 경우 여기부터 다음 셔틀 탑승
                    break;
                }
                lastBoardTime = timeList.poll(); // 셔틀 운행 시간 이전인 경우 크루 탑승
            }
            boardTime += t; // 다음 셔틀 운행 시간
        }
        
        // 결과 출력
        int hour = lastTime.hour, min = lastTime.min;
        if(!flag) { // 마지막 셔틀 운행 시간에 콘이 셔틀을 못 탈 경우 -> 마지막 셔틀 운행 시간에 마지막으로 탑승한 크루 도착 시간 - 1
            int temp = lastBoardTime.hour * 60 + lastBoardTime.min - 1;
            hour = temp / 60;
            min = temp % 60;
        }
        answer = (hour < 10? "0" : "") + hour + ":" + (min < 10? "0" : "") + min;
        
        return answer;
    }
}
/*
테스트 1 〉	통과 (17.44ms, 76.4MB)
테스트 2 〉	통과 (17.55ms, 79.1MB)
테스트 3 〉	통과 (23.12ms, 83.3MB)
테스트 4 〉	통과 (18.80ms, 82.8MB)
테스트 5 〉	통과 (22.72ms, 70.6MB)
테스트 6 〉	통과 (20.13ms, 85.8MB)
테스트 7 〉	통과 (20.32ms, 85.6MB)
테스트 8 〉	통과 (14.35ms, 87.8MB)
테스트 9 〉	통과 (14.73ms, 79.9MB)
테스트 10 〉	통과 (17.30ms, 79.4MB)
테스트 11 〉	통과 (21.58ms, 84.8MB)
테스트 12 〉	통과 (23.99ms, 86.5MB)
테스트 13 〉	통과 (23.77ms, 82.7MB)
테스트 14 〉	통과 (18.65ms, 82.4MB)
테스트 15 〉	통과 (16.23ms, 86.9MB)
테스트 16 〉	통과 (33.61ms, 80.8MB)
테스트 17 〉	통과 (28.56ms, 84.1MB)
테스트 18 〉	통과 (24.05ms, 78.3MB)
테스트 19 〉	통과 (23.39ms, 89.9MB)
테스트 20 〉	통과 (23.91ms, 85.9MB)
테스트 21 〉	통과 (56.58ms, 82.1MB)
테스트 22 〉	통과 (21.89ms, 86MB)
테스트 23 〉	통과 (26.40ms, 73.7MB)
테스트 24 〉	통과 (23.16ms, 79.4MB)
*/