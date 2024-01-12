import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {

    public static Map<String, Friend> friendMap = new HashMap<>();
    public static ArrayList<Friend> friendList = new ArrayList<>();
    public static int answer;

    public int solution(String[] friends, String[] gifts) {
        for (String friendName : friends) {
            Friend friend = new Friend(friendName);
            friendMap.put(friendName, friend);
            friendList.add(friend);
        }

        for (String gift : gifts) {
            StringTokenizer st = new StringTokenizer(gift);
            String fromName = st.nextToken();
            String toName = st.nextToken();
            Friend friend = friendMap.get(fromName);
            friend.giveGift(friendMap.get(toName));
        }

        for (int i = 0; i < friendList.size(); i++) {
            Friend friend = friendList.get(i);
            for (int j = i + 1; j < friendList.size(); j++) {
                Friend otherFriend = friendList.get(j);
                giveAndReceive(friend, otherFriend);
            }
            answer = Math.max(answer, friend.receiveCount);
        }

        return answer;
    }

    public static void giveAndReceive(Friend friend, Friend otherFriend) {
        int compare = friend.compareTo(otherFriend);
        if (compare > 0) {
            friend.receiveCount++;
        } else if (compare < 0) {
            otherFriend.receiveCount++;
        }
    }

    public static class Friend implements Comparable<Friend> {
        String name;
        int count = 0;
        int receiveCount = 0;
        Map<Friend, Integer> giftMap = new HashMap<>();

        public Friend(String name) {
            this.name = name;
        }

        public void giveGift(Friend friend) {
            giftMap.put(friend, giftMap.getOrDefault(friend, 0) + 1);
            this.count++;
            friend.count--;
        }

        @Override
        public int compareTo(Friend friend) {
            int thisReceive = friend.giftMap.getOrDefault(this, 0);
            int otherReceive = this.giftMap.getOrDefault(friend, 0);
            if (thisReceive == otherReceive) {
                return this.count - friend.count;
            }
            return otherReceive - thisReceive;
        }

    }
}

// overriding을 통해서 구현함.
// 메서드로 분할해서 구현
// compareTo 로직 잘 보기