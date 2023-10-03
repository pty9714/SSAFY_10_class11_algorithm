import java.util.*;

class Solution {
    public ArrayList<String> solution(String[] record) {
        ArrayList<String> answer = new ArrayList<>();
        String[] temp;
        
        HashMap<String, String> hm = new HashMap<>();
        
        for(int i = 0; i< record.length; i++){
            temp = record[i].split(" ");
            if(temp[0].equals("Enter")){
                hm.put(temp[1], temp[2]);
            }else if(temp[0].equals("Change")){
                hm.put(temp[1], temp[2]);
            }
        }
        
        for(int i = 0; i< record.length; i++){
            temp = record[i].split(" ");
            if(temp[0].equals("Enter")){
                answer.add(hm.get(temp[1]) + "님이 들어왔습니다.");
            }else if(temp[0].equals("Leave")){
                answer.add(hm.get(temp[1]) + "님이 나갔습니다.");
            }
        }
        return answer;
    }
}

테스트 1 〉	통과 (2.69ms, 66.7MB)
테스트 2 〉	통과 (2.08ms, 82MB)
테스트 3 〉	통과 (3.90ms, 72.3MB)
테스트 4 〉	통과 (2.97ms, 73.5MB)
테스트 5 〉	통과 (7.46ms, 78.7MB)
테스트 6 〉	통과 (9.01ms, 77.7MB)
테스트 7 〉	통과 (5.15ms, 77.8MB)
테스트 8 〉	통과 (5.23ms, 76.7MB)
테스트 9 〉	통과 (11.22ms, 83.7MB)
테스트 10 〉	통과 (7.06ms, 75.5MB)
테스트 11 〉	통과 (6.96ms, 81.9MB)
테스트 12 〉	통과 (6.11ms, 69.7MB)
테스트 13 〉	통과 (6.53ms, 87MB)
테스트 14 〉	통과 (5.64ms, 76.4MB)
테스트 15 〉	통과 (3.14ms, 75.8MB)
테스트 16 〉	통과 (2.84ms, 72.2MB)
테스트 17 〉	통과 (2.83ms, 73.2MB)
테스트 18 〉	통과 (2.65ms, 68.7MB)
테스트 19 〉	통과 (7.91ms, 78.7MB)
테스트 20 〉	통과 (8.14ms, 86.1MB)
테스트 21 〉	통과 (5.29ms, 79.7MB)
테스트 22 〉	통과 (5.34ms, 81.9MB)
테스트 23 〉	통과 (5.46ms, 79.5MB)
테스트 24 〉	통과 (5.55ms, 82.6MB)
테스트 25 〉	통과 (116.90ms, 166MB)
테스트 26 〉	통과 (126.90ms, 178MB)
테스트 27 〉	통과 (118.48ms, 172MB)
테스트 28 〉	통과 (131.04ms, 158MB)
테스트 29 〉	통과 (121.52ms, 173MB)
테스트 30 〉	통과 (107.32ms, 162MB)
테스트 31 〉	통과 (102.37ms, 197MB)
테스트 32 〉	통과 (88.26ms, 149MB)
