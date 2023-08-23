import java.util.*;

class Solution {
    class m{
        String num;
        int cost;
        public m(String num, int cost){
            this.num = num;
            this.cost = cost;
        }
    }
    public int[] solution(int[] fees, String[] records) {
        HashMap<String, Integer> hm = new HashMap<>();
        LinkedList<Integer> li_time = new LinkedList<>();
        LinkedList<String>  li_num = new LinkedList<>();
        
        for(int i =0; i < records.length; i++){
            String[] s = records[i].split(" ");
            int cur = Integer.parseInt(s[0].substring(0,2)) * 60 + Integer.parseInt(s[0].substring(3, 5));
            if(s[2].equals("IN") == true){ //입차
                li_time.add(cur);
                li_num.add(s[1]);
            }else{ //출차
                int index = li_num.indexOf(s[1]); //출차 index찾기
                int time = cur - li_time.get(index); //출차 시간 - 입차 시간 = 주차 시간
                li_num.remove(index);
                li_time.remove(index);
                if(hm.get(s[1]) == null){ //map에 없다면
                    hm.put(s[1], time);
                }else{ // map에 있다면
                    hm.put(s[1], hm.get(s[1]) + time);
                }
            }
        }
        for(int i =0; i< li_num.size(); i++){ //list 에 남아있는거 출차처리
            int time = 1439 - li_time.get(i); // 11시 59분 출차 처리
            if(hm.get(li_num.get(i)) == null){ //map에 없다면
                    hm.put(li_num.get(i), time);
                }else{ // map에 있다면
                    hm.put(li_num.get(i), hm.get(li_num.get(i)) + time);
                }
        }
        LinkedList<m> l = new LinkedList<>();
        
        for (String key : hm.keySet()) {
            int cost = fees[1];
            double temp = (double)(hm.get(key) - fees[0])/fees[2];
            cost += Math.ceil(temp) * fees[3];
            l.add(new m(key, cost));
        }
        
        Collections.sort(l, (el1, el2) -> {
            return el1.num.compareTo(el2.num);
        });
        int[] answer = new int[l.size()];
        for(int i =0;i < l.size(); i++){
            if(l.get(i).cost <= fees[1]){
                answer[i] = fees[1];
                continue;
            }
            answer[i] = l.get(i).cost;
        }
        
        
        
        return answer;
    }
}
테스트 1 〉	통과 (1.57ms, 72.3MB)
테스트 2 〉	통과 (1.69ms, 71.6MB)
테스트 3 〉	통과 (1.86ms, 76.4MB)
테스트 4 〉	통과 (2.31ms, 75.4MB)
테스트 5 〉	통과 (3.84ms, 85MB)
테스트 6 〉	통과 (3.17ms, 69MB)
테스트 7 〉	통과 (9.88ms, 77.4MB)
테스트 8 〉	통과 (7.60ms, 73.8MB)
테스트 9 〉	통과 (3.21ms, 73.2MB)
테스트 10 〉	통과 (8.73ms, 69.7MB)
테스트 11 〉	통과 (12.43ms, 83.3MB)
테스트 12 〉	통과 (11.99ms, 76.3MB)
테스트 13 〉	통과 (1.27ms, 76MB)
테스트 14 〉	통과 (1.21ms, 74.5MB)
테스트 15 〉	통과 (1.67ms, 75.5MB)
테스트 16 〉	통과 (1.27ms, 72.4MB)
