import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int[] fees, String[] records) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        Map<String, Integer> times = new TreeMap<String, Integer>(); // key : 차량 번호, value : 누적 시간 (차량 번호 작은 순서대로 넣기 위해 treemap 사용)
        HashMap<String, String> recordList = new HashMap<String, String>(); // key : 차량 번호, value : 출발 시간
        
        for (String record : records) {
            String s[] = record.split(" "); 
            if(s[2].equals("IN")) { // IN (입차)일 경우 Map(RecordList)에 넣기
                recordList.put(s[1], s[0]);
            }
            else { // OUT (출차)일 경우
                String start[] = recordList.get(s[1]).split(":"); // 입차 시간
                String end[] = s[0].split(":"); // 출차 시간
                // 주차 시간 계산
                int totalTime = (Integer.parseInt(end[0]) - Integer.parseInt(start[0])) * 60 + Integer.parseInt(end[1]) - Integer.parseInt(start[1]);
                // 입출차 시간이 계산된 차량은 삭제
                recordList.remove(s[1]);
                // 누적 주차 시간
                if(times.containsKey(s[1])) { // 기존에 입출차한 차량일 경우 누적
                    int t = times.get(s[1]);
                    times.put(s[1], t + totalTime);
                }
                else {
                    times.put(s[1], totalTime);
                }
            }
        }
        
        // 출차 내역 없는 차량은 23:59에 출차된 것으로 간주
        if(!recordList.isEmpty()) {
            for(String left : recordList.keySet()) { 
                String start[] = recordList.get(left).split(":"); // 입차 시간
                // 주차 시간 계산
                int totalTime = (23 - Integer.parseInt(start[0])) * 60 + 59 - Integer.parseInt(start[1]);
                // 누적 주차 시간
                if(times.containsKey(left)) { // 기존에 입출차한 차량일 경우 누적
                    int t = times.get(left);
                    times.put(left, t + totalTime);
                }
                else {
                    times.put(left, totalTime);
                }
            }
        }
        // 누적 주차 시간 이용해 정산
        for(String number : times.keySet()) { 
            int time = times.get(number); // 누적 주차 시간
            int price = fees[1]; // 정산 금액
            if(time > fees[0]) { // 기본 요금 이상의 시간일 경우
                int min = (int) Math.ceil((double) (time - fees[0]) / fees[2]); // 올림
                price += min * fees[3];
            }
            answer.add(price);
        }
        
        return answer;
    }
}