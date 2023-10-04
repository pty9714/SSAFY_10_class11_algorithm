import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4112 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());

        int[] pyramid = new int[100001];
        int[] nums = new int[500];
        int step = 1, i = 1;
        a: while (true) {
            for (int j = 0; j < step; j++) {
                if (i > 100000)
                    break a;
                pyramid[i++] = step;
            }
            nums[step] = i - 1;
            step++;
        }

        for (int tc = 1; tc <= T; tc++) {

            StringTokenizer st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }

            int cost = pyramid[b] - pyramid[a];
            int right = nums[pyramid[b]] - b;
            int left = b - nums[pyramid[b] - 1] - 1;
            if (right < left) {
                if (nums[pyramid[a]] - a > right) {
                    cost += nums[pyramid[a]] - a - right;
                }
            } else {
                if (a - nums[pyramid[a] - 1] - 1 > left) {
                    cost += a - nums[pyramid[a] - 1] - 1 - left;
                }
            }

            System.out.printf("#%d %d%n", tc, cost);
        }
    }
}

// 1000개의 테스트케이스 중 904개 맞음
