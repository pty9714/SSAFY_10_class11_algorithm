import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] trees = new int[N];
        int maxLength = 0;
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(br.readLine());
            maxLength = Math.max(maxLength, trees[i]);
        }
        int result = 0;
        for (int i = 1; i <= maxLength; i++) {
            int sum = 0;
            int value = W * i;
            for (int tree : trees) {
                int parts = tree / i;
                int remain = tree % i;
                sum += parts * value;
                if (parts >= 1) {
                    if (remain == 0) {
                        sum -= (parts - 1) * C;
                    } else {
                        sum -= parts * C;
                    }
                }
            }
            result = Math.max(result, sum);
        }
        System.out.println(result);

    }
}