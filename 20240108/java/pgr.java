import java.util.HashMap;

//내 코드
class Solution {
    static int[] answer, parents;
    
    public static void find(int number, int money) {
        // 민호까지 돈이 들어오거나 줄 돈이 없으면 종료
        if (parents[number] == number || money / 10 == 0) {
            answer[number] += money;
            return;
        }
        int send = money / 10;
        int mine = money - send;
        answer[number] += mine;
        find(parents[number], send);
    }
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int n = enroll.length;
        answer = new int[n + 1];
        parents = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parents[i] = i;
        }
        Map<String, Integer> map = new HashMap<>();
        
        //판매원 입력
        for (int i = 0; i < n; i++) {
            map.put(enroll[i], i + 1);
        }

        //추천인 입력
        for (int i = 0; i < n; i++) {
            if (referral[i].equals("-")) {
                parents[i + 1] = 0;
            } else {
                parents[i + 1] = map.get(referral[i]);
            }
        }

        //정산
        for (int i = 0; i < seller.length; i++) {
            find(map.get(seller[i]), amount[i] * 100);
        }

        return Arrays.copyOfRange(answer, 1, n + 1);
    }
}

//자바스러운 코드, 최악 7698ms
class Person {
    String name;
    Person parent;
    int money;

    public Person(String name, Person parent, int money) {
        this.name = name;
        this.parent = parent;
        this.money = money;
    }

    void getReward(int i) {
        int moneyToParent = (int) (i * 0.1);
        this.money += i - moneyToParent;
        if (this.parent != null)
            this.parent.getReward(moneyToParent);
    }
}

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, Person> personHashMap = new HashMap<>();
        for (String name : enroll)
            personHashMap.put(name, new Person(name, null, 0));

        for (int i = 0; i < enroll.length; i++) {
            if (referral[i].equals("-"))
                continue;
            personHashMap.get(enroll[i]).parent = personHashMap.get(referral[i]);
        }

        for (int i = 0; i < seller.length; i++)
            personHashMap.get(seller[i]).getReward(amount[i] * 100);

        int[] result = new int[enroll.length];

        for (int i = 0; i < result.length; i++)
            result[i] = personHashMap.get(enroll[i]).money;

        return result;
    }
}
