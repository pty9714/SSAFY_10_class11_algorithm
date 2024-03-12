import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Integer M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            isPalindrome(numbers, start - 1, end - 1);
        }
    }

    private static void isPalindrome(int[] numbers, int i, int j) {
        int start = i;
        int end = j;
        while (start < end) {
            if (numbers[start] != numbers[end]) {
                System.out.println(0);
                return;
            }
            start++;
            end--;
        }
        System.out.println(1);
    }

}
