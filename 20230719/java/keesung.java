import java.lang.Math;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int buildingNum;
        int dis;
        int result;
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= 10; test_case++)
		{
		    buildingNum=sc.nextInt();
            int[] arr = new int[buildingNum+4];
            int[] dp = new int[buildingNum+4];
            Arrays.fill(dp, 2147000000);
            
            
            for(int i = 2; i < buildingNum + 2; i++)
            {
                arr[i] = sc.nextInt();
            }

            
            for(int j = 2; j < buildingNum + 2; j++)
            {
                if (arr[j] < arr[j+1]) {
                    dis = arr[j+1] - arr[j];
                    dp[j] = 0;
                    dp[j+1] = Math.min(dp[j+1], dis);
                } else {
                    dis = arr[j] - arr[j+1];
                    dp[j+1] = 0;
                    dp[j] = Math.min(dp[j], dis);
                }

                if (arr[j] < arr[j+2]) {
                    dis = arr[j+2] - arr[j];
                    dp[j] = 0;
                    dp[j+2] = Math.min(dp[j+2], dis);
                } else {
                    dis = arr[j] - arr[j+2];
                    dp[j+2] = 0;
                    dp[j] = Math.min(dp[j], dis);
                }
            }

            result = 0;
            for(int k = 2; k < buildingNum + 2; k++)
            {
                result += dp[k];
            }
            System.out.println("#" + test_case + " " + result);
			/////////////////////////////////////////////////////////////////////////////////////////////
			/*
				 이 부분에 여러분의 알고리즘 구현이 들어갑니다.
			 */
			/////////////////////////////////////////////////////////////////////////////////////////////

		}
	}
}