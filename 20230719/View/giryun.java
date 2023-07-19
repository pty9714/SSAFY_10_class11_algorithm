import java.util.Scanner;
import static java.lang.Math.max;

class Solution {

	static int n;
	static int[] arr;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc < 11; tc++) {
			n = sc.nextInt();
	        arr = new int[n];
	        for (int i = 0; i < n; i++) {
	            arr[i] = sc.nextInt();
	        }
	        int cnt = 0;
            for (int i = 2; i < n-2; i++) {
                int max = max(max(arr[i-2], arr[i-1]), max(arr[i+1], arr[i+2]));
                if (arr[i] > max)
                    cnt += arr[i] - max; 
            }
            System.out.println("#" + tc + " " + cnt);
        }

	}

}