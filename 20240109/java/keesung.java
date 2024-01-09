import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int index = 0;
        int maxVal = 0;
        while (st.hasMoreTokens()) {
            arr[index++] = Integer.parseInt(st.nextToken());
            maxVal = Math.max(maxVal, arr[index - 1]);
        }

        int[] dp = new int[maxVal + 1];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                if (sum > maxVal) {
                    continue;
                }
                dp[sum]++;
            }
        }

        int result = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] != 0)
                result++;
        }
        System.out.println(result);
    }

}