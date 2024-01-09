import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) throws IOException {

        Solution solution = new Solution();
        solution.solution(new String[] { "john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young" },
                new String[] { "-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward" },
                new String[] { "young", "john", "tod", "emily", "mary" },
                new int[] { 12, 4, 2, 5, 10 });

    }

    public static Map<String, Person> people = new HashMap<>();

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        // 사람 생성
        people.put("-", new Person());
        for (int i = 0; i < enroll.length; i++) {
            people.put(enroll[i], new Person());
        }

        // 사람 연결
        for (int i = 0; i < referral.length; i++) {
            Person parent = people.get(referral[i]);
            Person child = people.get(enroll[i]);
            child.parent = parent;
        }

        // dfs
        // 판매 수익 입력
        for (int i = 0; i < seller.length; i++) {
            Person person = people.get(seller[i]);
            person.start(amount[i] * 100);
        }

        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = people.get(enroll[i]).money;
            answer[i] += people.get(enroll[i]).childMoney;
            System.out.println(answer[i]);
        }

        return answer;
    }

    public static class Person {

        private int money = 0;
        private int childMoney = 0;

        private Person parent;

        public Person() {
        }

        public void go(int childMoney) {
            if (parent == null) {
                return;
            }
            int goMoney = childMoney / 10;
            this.childMoney += childMoney - goMoney;
            parent.go(goMoney);
        }

        public void start(int money) {
            if (parent == null) {
                return;
            }
            int goMoney = money / 10;
            this.money += money - goMoney;
            parent.go(goMoney);
        }

    }

}

// 변수 처리 개귀찮음
// 아래에서 위로 하나씩 올려야 하는 구조
// dfs로 다 더해놓고 한번에 나누는게 아님
// 문제 이해하기 좀 힘들었음