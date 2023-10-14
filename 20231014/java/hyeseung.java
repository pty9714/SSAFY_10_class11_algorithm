import java.util.*;
class Solution {
    public HashMap<String, ArrayList<Integer>> hm;
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        int idx = 0;
        // 가능한 조건 경우의 수 구하기 (조건, 점수 배열) - 부분집합
        hm = new HashMap<String, ArrayList<Integer>>();
        for (String condition : info) {
            String[] tempArr = condition.split(" ");
            subSet(tempArr, 0);
        }
        
        // 점수 정렬 (query 반복문에서 정렬하면 시간초과)
        for (ArrayList<Integer> value : hm.values()) {
            Collections.sort(value);
        }
        
        // 이진 탐색을 통해 점수 이상의 위치를 찾아 전체 점수 배열 길이에서 빼기
        for (String q : query) {
            String[] tempArr = q.split(" ");
            int cnt = 0;
            String s = tempArr[0] + tempArr[2] + tempArr[4] + tempArr[6];
            if(hm.containsKey(s)) {
                ArrayList<Integer> scores = hm.get(s);
                cnt = scores.size() - lowerBound(scores, Integer.parseInt(tempArr[7]));
            }
            answer[idx++] = cnt;
        }
        return answer;
    }
    
    public void subSet(String[] condition , int cnt) {
        if(cnt == 4) {
            String s = "";
            // [조건]
            for (int i = 0; i < 4; i++) {
                s += condition[i];
            }
            // 포함되면 점수 추가
            if(hm.containsKey(s)) {
                hm.get(s).add(Integer.parseInt(condition[4]));
            }
            // 포함되지 않으면 새롭게 조건 추가
            else {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(Integer.parseInt(condition[4]));
                hm.put(s, temp);
            }
            return;
        }
        
        // 포함하는 경우
        subSet(condition, cnt + 1);
        String s = condition[cnt];
        // '-' 인 경우
        condition[cnt] = "-";
        subSet(condition, cnt + 1);
        condition[cnt] = s;
    }
    
    public int lowerBound(ArrayList<Integer> arr, int value){
        int max = arr.size();
        int min = 0;
        while(min < max){
            int mid = (min + max) / 2;
            if(value > arr.get(mid)) {
                min = mid + 1;
            }
            else {
                max = mid;
            }
        }
        return min;
    }
}
/*
테스트 1 〉	통과 (18.51ms, 77.7MB)
테스트 2 〉	통과 (22.29ms, 76.8MB)
테스트 3 〉	통과 (28.21ms, 89.1MB)
테스트 4 〉	통과 (22.62ms, 84MB)
테스트 5 〉	통과 (28.81ms, 84.9MB)
테스트 6 〉	통과 (50.49ms, 90.5MB)
테스트 7 〉	통과 (36.67ms, 93.4MB)
테스트 8 〉	통과 (180.13ms, 110MB)
테스트 9 〉	통과 (286.31ms, 133MB)
테스트 10 〉	통과 (181.98ms, 117MB)
테스트 11 〉	통과 (27.94ms, 87.2MB)
테스트 12 〉	통과 (52.97ms, 85.4MB)
테스트 13 〉	통과 (28.60ms, 81.9MB)
테스트 14 〉	통과 (81.13ms, 99.4MB)
테스트 15 〉	통과 (107.52ms, 116MB)
테스트 16 〉	통과 (26.52ms, 71.8MB)
테스트 17 〉	통과 (45.58ms, 91.9MB)
테스트 18 〉	통과 (68.60ms, 112MB)
효율성  테스트
테스트 1 〉	통과 (1065.41ms, 280MB)
테스트 2 〉	통과 (1046.25ms, 269MB)
테스트 3 〉	통과 (1126.21ms, 257MB)
테스트 4 〉	통과 (1177.14ms, 246MB)
채점 결과
정확성: 40.0
효율성: 60.0
합계: 100.0 / 100.0
*/