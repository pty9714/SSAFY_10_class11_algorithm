import java.util.ArrayList;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> number = new ArrayList<>();
        long fact = 1;
        for(int i = 1; i <= n; i++) {
            number.add(i);
            fact *= i;
        }
        k--;
        for(int i = 0; i < answer.length; i++) {
            fact /= n--;
            int index = (int) (k / fact);
            answer[i] = number.get(index);
            number.remove(index);
            k %= fact;
        }
        return answer;
    }
}

// 0.5ms