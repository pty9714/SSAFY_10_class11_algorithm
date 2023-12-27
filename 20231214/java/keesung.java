import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> primeNumbers = new ArrayList<>();
        boolean[] primeNumberArray = new boolean[4000002];
        primeNumberArray[0] = true;
        for (int i = 2; i < primeNumberArray.length; i++) {
            if (!primeNumberArray[i]) {
                primeNumbers.add(i);
                for (int j = i * 2; j < primeNumberArray.length; j += i) {
                    primeNumberArray[j] = true;
                }
            }
        }

        int left = 0;
        int right = 0;
        int sum = 0;
        int count = 0;
        while (true) {
            if (sum >= N) {
                sum -= primeNumbers.get(left++);
            } else if (right == primeNumbers.size()) {
                break;
            } else {
                sum += primeNumbers.get(right++);
            }

            if (sum == N) {
                count++;
            }
        }
        System.out.println(count);
    }

}

// 에라토스테네스? 의 채
// 투포인터로 크면 왼쪽 없애고, 작으면 오른쪽 더하기