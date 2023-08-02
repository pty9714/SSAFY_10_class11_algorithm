import java.io.BufferedReader;
import java.io.InputStreamReader;


class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp[];
		// Scanner sc = new Scanner(System.in);
		int T;
		T = Integer.parseInt(br.readLine());
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
            // ArrayList<Integer> list = new ArrayList<Integer>();
		    int num = Integer.parseInt(br.readLine());
            int[][] map = new int[num][num];
            int[][] dp = new int[num][num];
            for (int i = 0; i < num; i++) {
                tmp = br.readLine().split("");
                System.out.println("==================================================");
                System.out.println(tmp);
                System.out.println("==================================================");
                for (int j = 0; j < num; j++){
                    System.out.println(tmp[j]);
                    map[i][j] = Integer.parseInt(tmp[j]);
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
            System.out.println(3);
            dp[0][0] = 0;
            for (int i = 0; i < num; i++){
                for (int j = 0; j < num; j++) {
                    if (j + 1 < num) {
                        dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j] + map[i][j+1]);
                    }
                    if (i + 1 < num) {
                        dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j] + map[i+1][j]);
                    }

                    
                }
            }
            System.out.println(4);
            System.out.printf("#%d %d\n", test_case, dp[num][num]);
			/////////////////////////////////////////////////////////////////////////////////////////////
			/*
				 이 부분에 여러분의 알고리즘 구현이 들어갑니다.
			 */
			/////////////////////////////////////////////////////////////////////////////////////////////

		}
	}
}