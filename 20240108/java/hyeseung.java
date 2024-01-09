import java.util.HashMap;
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int enrollLength = enroll.length; // 조직 구성원 수
        int[] answer = new int[enrollLength]; // 모든 조직 구성원의 이익
        HashMap<String, String> pyramid = new HashMap<String, String>(); // 피라미드 조직
        HashMap<String, Integer> ans = new HashMap<String, Integer>(); // 모든 조직 구성원의 이익 임시 저장
        // 피라미드 조직 입력
        for (int i = 0; i < enrollLength; i++) {
            pyramid.put(enroll[i], referral[i]);
            ans.put(enroll[i], 0);
        }
        int sellerLength = seller.length; // 판매원 수
        for(int i = 0; i < sellerLength; i++) {
            String s = seller[i]; // 판매원
            int a = amount[i] * 100; // 판매액
            while(!s.equals("-")) { // center 전까지
                int temp = (int) (a * 0.1); // 10% 계산하여 원 단위 절사
                if(temp < 1) { // 1원 미만인 경우에는 이득 분배 X 자신이 모두 가짐
                    ans.put(s, ans.get(s) + a);
                    break;
                }
                ans.put(s, ans.get(s) + a - temp); // 10%의 나머지 자신이 모두 가짐
                s = pyramid.get(s); // 추천인
                a = temp; // 10% 추천인 전달
            }
        }
        // 정답 입력
        for(int i = 0; i < enrollLength; i++) {
            answer[i] = ans.get(enroll[i]);
        }
        return answer;
    }
}
/*
구현
-> 해시맵 이용해서 이름으로 조직도 구성 및 이익금 갱신
*/