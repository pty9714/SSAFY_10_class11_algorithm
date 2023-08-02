import java.util.Scanner;

import static java.lang.Math.max;

class Solution
{
    public static void main(String args[]) throws Exception
    {
		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            // 입력
            int N = sc.nextInt();
            int[] bds = new int[N];
            for (int i = 0; i < N; i++) {
                int height = sc.nextInt();
                bds[i] = height;
            }

            // 앞뒤로 2개씩 비교하여 판단
            int answer = 0;
            for (int i = 2; i < N-2; i++) {
                int cur = bds[i];
                int maxLeft = max(bds[i - 1], bds[i - 2]);
                int maxRight = max(bds[i + 1], bds[i + 2]);
                // 조망권 확보 세대
                int max = max(maxLeft, maxRight);
                if (cur > max) {
                    answer += cur - max;
                }
            }
            System.out.println("#" + test_case + " " + answer);
        }
    }
}
