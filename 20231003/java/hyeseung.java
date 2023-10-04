import java.util.*;

class Solution {
    public ArrayList<String> solution(String[] record) {
        ArrayList<String> answer = new ArrayList<>();

        Map<String, String> chat = new HashMap<>();
        for (String r : record) {
            String s[] = r.split(" ");
            if (!s[0].equals("Leave"))
                chat.put(s[1], s[2]);
        }

        for (String r : record) {
            String s[] = r.split(" ");
            switch (s[0]) {
                case "Enter":
                    answer.add(chat.get(s[1]) + "님이 들어왔습니다.");
                    break;
                case "Leave":
                    answer.add(chat.get(s[1]) + "님이 나갔습니다.");
                    break;
            }
        }

        return answer;
    }
}

/*
 * 테스트 1 〉 통과 (2.01ms, 75.3MB)
 * 테스트 2 〉 통과 (2.00ms, 75.3MB)
 * 테스트 3 〉 통과 (3.45ms, 75.8MB)
 * 테스트 4 〉 통과 (2.46ms, 78.3MB)
 * 테스트 5 〉 통과 (6.59ms, 81MB)
 * 테스트 6 〉 통과 (7.37ms, 82.3MB)
 * 테스트 7 〉 통과 (7.18ms, 77.9MB)
 * 테스트 8 〉 통과 (8.69ms, 92.6MB)
 * 테스트 9 〉 통과 (7.01ms, 78.8MB)
 * 테스트 10 〉 통과 (5.94ms, 84.6MB)
 * 테스트 11 〉 통과 (7.03ms, 77.2MB)
 * 테스트 12 〉 통과 (4.47ms, 76.8MB)
 * 테스트 13 〉 통과 (6.83ms, 84.8MB)
 * 테스트 14 〉 통과 (6.68ms, 83.8MB)
 * 테스트 15 〉 통과 (2.38ms, 76.5MB)
 * 테스트 16 〉 통과 (2.19ms, 76.5MB)
 * 테스트 17 〉 통과 (3.88ms, 78.5MB)
 * 테스트 18 〉 통과 (3.78ms, 81.4MB)
 * 테스트 19 〉 통과 (6.47ms, 81.1MB)
 * 테스트 20 〉 통과 (7.78ms, 76.9MB)
 * 테스트 21 〉 통과 (7.84ms, 83.6MB)
 * 테스트 22 〉 통과 (6.04ms, 79MB)
 * 테스트 23 〉 통과 (7.93ms, 86.2MB)
 * 테스트 24 〉 통과 (7.80ms, 76MB)
 * 테스트 25 〉 통과 (113.77ms, 162MB)
 * 테스트 26 〉 통과 (114.79ms, 165MB)
 * 테스트 27 〉 통과 (215.93ms, 181MB)
 * 테스트 28 〉 통과 (246.78ms, 173MB)
 * 테스트 29 〉 통과 (148.07ms, 163MB)
 * 테스트 30 〉 통과 (155.07ms, 156MB)
 * 테스트 31 〉 통과 (109.26ms, 158MB)
 * 테스트 32 〉 통과 (114.07ms, 148MB)
 */