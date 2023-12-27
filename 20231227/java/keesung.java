class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {

        // 한바퀴가 360도가 아니라 86400 도라고 가정
        // 시침은 한시간에 3600도 돌아감, 1분에 60도 돌아감, 1초에 1도 돌아감
        // 분침은 1분에 1440도 돌아감, 1초에 24도 돌아감
        // 초침은 1초에 1440도 돌아감

        int answer = 0;
        if (h1 < 12 && h2 >= 12) {
            Clock clock = new Clock(h1, m1, s1);
            Clock clock2 = new Clock(11, 59, 59);
            while (!clock.equals(clock2)) {
                clock.afterSecond();
            }
            answer = clock.count;

            clock = new Clock(12, 0, 0);
            clock2 = new Clock(h2, m2, s2);
            while (!clock.equals(clock2)) {
                clock.afterSecond();
            }
            answer += clock.count;
        } else {
            Clock clock = new Clock(h1, m1, s1);
            Clock clock2 = new Clock(h2, m2, s2);
            while (!clock.equals(clock2)) {
                clock.afterSecond();
            }
            answer = clock.count;
        }
        return answer;
    }

    public static class Clock {
        public int hour;
        public int minute;
        public int second;

        public int count = 0;

        public Clock(int hour, int minute, int second) {
            this.hour = (hour * 7200 + minute * 120 + second * 2) % 86400;
            this.minute = minute * 1440 + second * 24;
            this.second = second * 1440;
            if (this.hour == this.second || this.minute == this.second) {
                this.count++;
            }
        }

        public void afterSecond() {
            int afterSecond = this.second + 1440;
            int afterMinute = this.minute + 24;
            int afterHour = this.hour + 2;
            if (this.second < this.minute && afterSecond >= afterMinute) {
                this.count++;
            }
            if (this.second < this.hour && afterSecond >= afterHour) {
                if (afterHour != 86400 || afterMinute != 86400) {
                    this.count++;
                }
            }
            // System.out.println(this.hour + " " + this.minute + " " + this.second);
            // System.out.println(afterHour + " " + afterMinute + " " + afterSecond);
            this.second = afterSecond % 86400;
            this.minute = afterMinute % 86400;
            this.hour = afterHour % 86400;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Clock) {
                Clock clock = (Clock) obj;
                return this.hour == clock.hour && this.minute == clock.minute && this.second == clock.second;
            }
            return false;
        }
    }
}

// 한바퀴를 86400으로 가정함
// 시간은 12시간마다 1회전 => 1시간에 7200도 1분에 120도 1초에 2도 돌아감
// 분은 60분마다 1회전 => 1분에 1440도 1초에 24도 돌아감
// 초는 60초마다 1회전 => 1초에 1440도 돌아감
// 1초마다 움직임 관찰하면서 시계 count 더해줌
// 12시간 마다 구분해야 하므로 h1이랑 h2 조건을 비교해서 h1 < 12 && h2 >= 12 이면 Clock을 나눠서 설계함