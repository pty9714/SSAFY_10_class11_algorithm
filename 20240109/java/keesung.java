import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        int maxVal = 0;
        while (st.hasMoreTokens()) {
            arr[index++] = Integer.parseInt(st.nextToken());
            int number = arr[index - 1];
            maxVal = Math.max(maxVal, number);
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == 0 && map.get(arr[j]) < 2) {
                    continue;
                }
                if (arr[j] == 0 && map.get(arr[i]) < 2) {
                    continue;
                }
                if (arr[i] == 0 && arr[j] == 0 && map.get(0) == 2) {
                    continue;
                }
                int sum = arr[i] + arr[j];
                if (sum > maxVal) {
                    continue;
                }
                visited.add(sum);
            }
        }

        int result = 0;
        for (Integer number : visited) {
            result += map.getOrDefault(number, 0);
        }
        System.out.println(result);
    }

}

// 0이 여러개일 때를 주의해야 한다.
// 0이 1개 있을 때 0과 다른 숫자를 더할 때 다른 숫자의 갯수가 1개이면 안된다.
// 0이 2개 일때는 0 + 0 을 제외해야한다.