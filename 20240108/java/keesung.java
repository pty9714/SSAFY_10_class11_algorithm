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
        people.put("-", new Person(0));
        for (int i = 0; i < enroll.length; i++) {
            people.put(enroll[i], new Person(0));
        }

        // 사람 연결
        for (int i = 0; i < referral.length; i++) {
            Person parent = people.get(referral[i]);
            Person child = people.get(enroll[i]);
            parent.children.add(child);
        }

        // 판매 수익 입력
        for (int i = 0; i < seller.length; i++) {
            Person person = people.get(seller[i]);
            person.money += amount[i] * 100;
        }

        // dfs

        people.get("-").go();

        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = people.get(enroll[i]).money;
            System.out.println(answer[i]);
        }

        return answer;
    }

    public static class Person {

        private int money;
        private ArrayList<Person> children;

        public Person(int money) {
            this.money = money;
            this.children = new ArrayList<>();
        }

        public int go() {
            if (children.size() == 0) {
                return 0;
            }
            int sumChild = 0;
            for (Person child : children) {
                sumChild += child.go();
            }
            this.money += sumChild;
            int give = this.money / 10;
            this.money -= give;
            return give;
        }

    }

}

// 실패 코드. go가 안됨