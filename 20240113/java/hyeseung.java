import java.util.HashMap;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int friendsLength = friends.length;
        HashMap<String, Integer> friendsIndex = new HashMap<>();
        int[] giftsIndex = new int[friendsLength]; // 선물 지수
        int[][] giftsRecord = new int[friendsLength][friendsLength]; // 선물 주고 받은 기록

        // 친구이름을 인덱스화
        for ( int i = 0; i < friendsLength; i++ ) {
            friendsIndex.put(friends[i], i);
        }

        for (String gift : gifts) {
            String[] name = gift.split(" ");
            giftsIndex[friendsIndex.get(name[0])]++; // 선물 지수 증가
            giftsIndex[friendsIndex.get(name[1])]--; // 선물 지수 감소
            giftsRecord[friendsIndex.get(name[0])][friendsIndex.get(name[1])]++; // 준 선물 개수 증가
        }

        for (int i =0; i< friendsLength; i++) {
            int count = 0;
            for (int j = 0; j< friendsLength; j++) {
                if (i == j) {
                    continue;
                }
                // 두 사람 사이에 더 많은 선물 준 사람 & 선물지수가 더 작은 사람
                if (giftsRecord[i][j] > giftsRecord[j][i] ||
                        (giftsRecord[i][j] == giftsRecord[j][i] && giftsIndex[i] > giftsIndex[j])) {
                    count++;
                }
            }
            answer = Math.max(answer, count);
        }
        return answer;
    }
}