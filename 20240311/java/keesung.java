public class Solution {

    public int solution(String s) {
        int answer = 1;

        int len = s.length();

        for (int i = len; i > 0; i--) {
            for (int start = 0; start <= len - i; start++) {
                if (isPalindrome(s.substring(start, start + i))) {
                    return i;
                }
            }
        }

        return answer;
    }

    public boolean isPalindrome(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

}

// 1개가 계속 시간초과 나는데 왜인지 모르겠음..