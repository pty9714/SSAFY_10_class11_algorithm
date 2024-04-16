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