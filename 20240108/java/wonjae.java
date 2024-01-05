import java.util.HashMap;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
            int length = enroll.length;
            int[] answer = new int[length];
            HashMap<String, Integer> hashMap = new HashMap<>();
            People[] people = new People[length];
            for(int i = 0; i < length; i++){
                hashMap.put(enroll[i], i);
                people[i] = new People(enroll[i], referral[i]);
            }

            for(int i = 0; i < seller.length; i++){
                String s = seller[i];
                People curr = people[hashMap.get(s)];
                int money = amount[i] * 100;
                while(true){
                    curr.money += (money - (money/10));
                    money /= 10;
                    if(curr.parent.equals("-")) break;
                    if(money == 0) break;
                    curr = people[hashMap.get(curr.parent)];
                }
            }

            for(int i = 0; i < length; i++){
                answer[i] = people[i].money;
            }

            return answer;
        }

        static class People{
            String name;
            int money = 0;
            String parent;
            People(String name, String parent){
                this.name = name;
                this.parent = parent;
            }

        }
}
/*
  테스트 1 〉	통과 (0.33ms, 81.4MB)
  테스트 2 〉	통과 (0.35ms, 78.2MB)
  테스트 3 〉	통과 (0.47ms, 75.8MB)
  테스트 4 〉	통과 (0.40ms, 81.1MB)
  테스트 5 〉	통과 (0.82ms, 72.2MB)
  테스트 6 〉	통과 (2.92ms, 93.4MB)
  테스트 7 〉	통과 (3.40ms, 105MB)
  테스트 8 〉	통과 (4.06ms, 92MB)
  테스트 9 〉	통과 (11.85ms, 115MB)
  테스트 10 〉	통과 (38.34ms, 136MB)
  테스트 11 〉	통과 (29.47ms, 142MB)
  테스트 12 〉	통과 (33.51ms, 134MB)
  테스트 13 〉	통과 (20.75ms, 131MB)
*/
