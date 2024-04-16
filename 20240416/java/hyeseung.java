import java.util.*;
class Solution {
    class Work {
        String name;
        int playtime;
        Work(String name, int playtime) {
            this.name = name;
            this.playtime = playtime;
        }
    }
    public String[] solution(String[][] plans) {
        int n = plans.length;
        String[] answer = new String[n];
        Arrays.sort(plans, new Comparator<String[]>() {
            @Override
            public int compare(String[] i1, String[] i2) {
                return i1[1].compareTo(i2[1]);
            }
        });
        int index = 0;
        int timeIndex = 0;
        Stack<Work> works = new Stack<Work>();
        for (int i = 0; i <= 23; i++) {
            for (int j = 0; j <= 59; j++) {
                String time = ((i < 10) ? "0" : "") + i + ((j < 10) ? ":0" : ":") + j;
                if(time.equals(plans[timeIndex][1])) {
                    works.push(new Work(plans[timeIndex][0], Integer.parseInt(plans[timeIndex][2])));
                    timeIndex = timeIndex == n - 1 ? timeIndex : timeIndex + 1;
                }
                if(!works.isEmpty()) {
                    Work work = works.peek();
                    work.playtime--;
                    if(work.playtime == 0) {
                        works.pop();
                        answer[index++] = work.name;
                    }
                }
            }
        }
        while(!works.isEmpty()) {
            Work work = works.pop();
            answer[index++] = work.name;
        }
        return answer;
    }
}
/*
테스트 1 〉	통과 (29.09ms, 73.9MB)
테스트 2 〉	통과 (37.11ms, 82MB)
테스트 3 〉	통과 (28.08ms, 83.8MB)
테스트 4 〉	통과 (18.93ms, 85MB)
테스트 5 〉	통과 (30.00ms, 82.3MB)
테스트 6 〉	통과 (24.25ms, 78MB)
테스트 7 〉	통과 (19.02ms, 79.2MB)
테스트 8 〉	통과 (22.01ms, 75.5MB)
테스트 9 〉	통과 (27.79ms, 86.8MB)
테스트 10 〉	통과 (21.15ms, 75.6MB)
테스트 11 〉	통과 (20.38ms, 78.3MB)
테스트 12 〉	통과 (20.24ms, 98.7MB)
테스트 13 〉	통과 (22.15ms, 76.8MB)
테스트 14 〉	통과 (20.93ms, 90.3MB)
테스트 15 〉	통과 (27.61ms, 77.4MB)
테스트 16 〉	통과 (28.64ms, 81.1MB)
테스트 17 〉	통과 (21.65ms, 88.5MB)
테스트 18 〉	통과 (20.16ms, 82.9MB)
테스트 19 〉	통과 (21.42ms, 84.1MB)
테스트 20 〉	통과 (18.77ms, 80.8MB)
테스트 21 〉	통과 (21.70ms, 77MB)
테스트 22 〉	통과 (20.24ms, 97.7MB)
테스트 23 〉	통과 (19.10ms, 81.3MB)
테스트 24 〉	통과 (20.91ms, 81.1MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
 */