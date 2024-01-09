
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {

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
                int give = this.money / 10;
                this.money -= give;
                return give;
            }
            for (Person child : children) {
                int give = child.go();
                this.money += give;
            }
            int give = this.money / 10;
            this.money -= give;
            return give;
        }

    }

}

// 처음에 int를 go에 전달해줬더니 값이 바뀌지 않았다. 그래서 IntWrapper를 만들어서 전달해주니 값이 바뀌었다.
// 코드가 좀 복잡해서 별로인 것 같다.
// bfs 코드이다 결국 한 지점에서 주변 지점 모두 방문하고 한번에 더해주는 방식을 채택하고 있다.
// 모든 점을 다 확인해서 비효율 적일 수 있다.