import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> hm = new HashMap();
        ArrayList<String[]> inAndOut = new ArrayList();
        for (String tmp : record) {
            String[] newObj = tmp.split(" ");
            if (newObj[0].equals("Enter")) {
                hm.put(newObj[1], newObj[2]);
                inAndOut.add(new String[] { newObj[1], "님이 들어왔습니다." });
            } else if (newObj[0].equals("Leave")) {
                inAndOut.add(new String[] { newObj[1], "님이 나갔습니다." });
            } else {
                hm.put(newObj[1], newObj[2]);
            }
        }
        System.out.println(inAndOut.size());
        String[] answer = new String[inAndOut.size()];
        for (int i = 0; i < inAndOut.size(); i++) {
            answer[i] = hm.get(inAndOut.get(i)[0]) + inAndOut.get(i)[1];
        }
        // String[] answer = new String[0];
        return answer;
    }
}

// HashMap 이용, 이름 식별
// 테스트 1 〉 통과 (1.60ms, 71.4MB)
// 테스트 2 〉 통과 (2.00ms, 77.3MB)
// 테스트 3 〉 통과 (2.30ms, 74.2MB)
// 테스트 4 〉 통과 (2.34ms, 79.6MB)
// 테스트 5 〉 통과 (4.27ms, 104MB)
// 테스트 6 〉 통과 (4.17ms, 80.4MB)
// 테스트 7 〉 통과 (5.54ms, 91.9MB)
// 테스트 8 〉 통과 (4.32ms, 83MB)
// 테스트 9 〉 통과 (4.46ms, 82.5MB)
// 테스트 10 〉 통과 (4.56ms, 77MB)
// 테스트 11 〉 통과 (3.89ms, 77.9MB)
// 테스트 12 〉 통과 (3.65ms, 80.6MB)
// 테스트 13 〉 통과 (6.34ms, 85.4MB)
// 테스트 14 〉 통과 (4.51ms, 83.4MB)
// 테스트 15 〉 통과 (1.31ms, 75.7MB)
// 테스트 16 〉 통과 (1.33ms, 72.3MB)
// 테스트 17 〉 통과 (2.23ms, 82.1MB)
// 테스트 18 〉 통과 (2.61ms, 77.4MB)
// 테스트 19 〉 통과 (4.35ms, 81.1MB)
// 테스트 20 〉 통과 (4.63ms, 88.5MB)
// 테스트 21 〉 통과 (5.92ms, 74.2MB)
// 테스트 22 〉 통과 (4.45ms, 80.4MB)
// 테스트 23 〉 통과 (6.48ms, 84.1MB)
// 테스트 24 〉 통과 (6.40ms, 85MB)
// 테스트 25 〉 통과 (76.55ms, 143MB)
// 테스트 26 〉 통과 (88.90ms, 152MB)
// 테스트 27 〉 통과 (114.29ms, 160MB)
// 테스트 28 〉 통과 (130.18ms, 166MB)
// 테스트 29 〉 통과 (104.31ms, 177MB)
// 테스트 30 〉 통과 (82.09ms, 163MB)
// 테스트 31 〉 통과 (108.93ms, 157MB)
// 테스트 32 〉 통과 (97.46ms, 148MB)