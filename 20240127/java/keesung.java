import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

class Solution {

    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2).replace("},{", "-");
        String[] arr = s.split("-");
        ArrayList<String> list = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            list.add(arr[i]);
        }
        list.sort(Comparator.comparingInt(String::length));
        int[] answer = new int[n];
        HashSet<Integer> set = new HashSet<>();
        for (String str : list) {
            String[] s1 = str.split(",");
            for (String s2 : s1) {
                int num = Integer.parseInt(s2);
                if (set.contains(num)) {
                    continue;
                }
                set.add(num);
                answer[answer.length - n] = num;
                n--;
            }
        }
        return answer;
    }
}

// 문자열 파싱
// 19년엔 나도 카카오 갔을듯