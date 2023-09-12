import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        
        LinkedList<Integer> list = new LinkedList<>();

        
        
       for(int i =0 ;i< timetable.length; i++){
           int transfer = Integer.parseInt(timetable[i].substring(0, 2)) * 60 + Integer.parseInt(timetable[i].substring(3, 5));
           if(transfer <= (540 + t * n) && transfer > 0){ // 버스 범위 안에 있어야함 그 외에는 다 집가기
               list.add(transfer);
           }
       }
        
        
        Collections.sort(list);
        
        int current_time = 540; //셔틀 출발 시간
        int index = 0;
        boolean flag = true;
        
        for(int i = 0; i < n; i++){ //다음 버스 옴
            int count = 0; //탈수 있는 인원 count
            for(int j = index; j < list.size(); j++){
                if(list.get(j) <= current_time){// 출발시간 전에 온사람이라면 탐
                    count++;
                    index++; //탈사람을 위한 index start - 마지막 탄 사람 + 1
                }
                if(count == m || list.get(j) > current_time) break; //count가 만석이거나 다음 줄 선사람이 출발시간 뒤에 온사람이면
            }
           
            if(i == n-1 && count != m){ //만약 마지막차에 자리가 있다면 마지막차 시간에 와서 타면 됨
                answer = String.format("%02d", current_time/60)  + ":" + String.format("%02d", current_time%60);
                flag = false;
            }
            current_time += t; //셔틀 시간 추가!
        }

        //다 타고 간뒤 탈 차가 없으면 안되니까 마지막 사람 타기 바로 전시간에 타야함
        if(flag){
            if((list.get(index-1)%60) == 0){
                answer = String.format("%02d", list.get(index-1)/60 - 1)  + ":59";
            }else{
                answer = String.format("%02d", list.get(index-1)/60)  + ":" + String.format("%02d", (list.get(index-1)%60) - 1);
            }
            
        }

        return answer;
    }
}

테스트 1 〉	통과 (10.83ms, 73.6MB)
테스트 2 〉	통과 (14.26ms, 75.8MB)
테스트 3 〉	통과 (5.07ms, 77.7MB)
테스트 4 〉	통과 (11.88ms, 80.6MB)
테스트 5 〉	통과 (11.94ms, 75.6MB)
테스트 6 〉	통과 (12.76ms, 83.7MB)
테스트 7 〉	통과 (14.63ms, 70.6MB)
테스트 8 〉	통과 (3.34ms, 75.9MB)
테스트 9 〉	통과 (18.02ms, 78.4MB)
테스트 10 〉	통과 (14.06ms, 77.3MB)
테스트 11 〉	통과 (11.76ms, 79.6MB)
테스트 12 〉	통과 (21.90ms, 81.3MB)
테스트 13 〉	통과 (17.51ms, 72MB)
테스트 14 〉	통과 (4.26ms, 73.9MB)
테스트 15 〉	통과 (3.43ms, 77.5MB)
테스트 16 〉	통과 (6.80ms, 83.2MB)
테스트 17 〉	통과 (8.26ms, 77.5MB)
테스트 18 〉	통과 (15.01ms, 73.7MB)
테스트 19 〉	통과 (6.77ms, 75MB)
테스트 20 〉	통과 (14.30ms, 69.9MB)
테스트 21 〉	통과 (26.00ms, 77.5MB)
테스트 22 〉	통과 (17.61ms, 80.6MB)
테스트 23 〉	통과 (16.80ms, 86.4MB)
테스트 24 〉	통과 (13.30ms, 82.1MB)
