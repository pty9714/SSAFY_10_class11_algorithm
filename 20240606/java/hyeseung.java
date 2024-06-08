import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
// 231048KB, 2008ms
public class B9024 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        int n, K, min, count, left, right, sum, diff;
        int[] numbers;
        for (int i = 0; i < t; i++) {
            min = Integer.MAX_VALUE;
            count = 0;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            numbers = new int[n];
            for (int j = 0; j < n; j++) {
                numbers[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(numbers);
            left = 0; right = n - 1;
            while(left < right) {
                sum = numbers[left] + numbers[right];
                diff = Math.abs(sum - K);
                if(diff < min) {
                    min = diff;
                    count = 1;
                }
                else if(diff == min) {
                    count++;
                }
                if(sum <= K) left++;
                else right--;
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}