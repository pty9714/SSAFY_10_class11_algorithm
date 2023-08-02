import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
            if (n%2==0) {
				System.out.printf("#%d Alice%n", test_case);
			} else {
                System.out.printf("#%d Bob%n", test_case);
            }
        }
	}
}
