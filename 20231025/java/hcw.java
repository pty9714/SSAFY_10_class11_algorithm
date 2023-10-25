import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int answer = 0;
		int answerCount = 0;

		if (n == 1) {
			System.out.println("A");
		}else {
			label: for (int a = 0; a <= 100; a++) {
				int b = arr[1] - arr[0] * a;
				boolean flag = true;
				for (int r = 1; r < n - 1; r++) {
					if (arr[r] * a + b != arr[r + 1]) {
						flag = false;
						break;
					}
				}
				if (flag) {
					if(answer != arr[n - 1] * a + b) {
						answerCount++;
						answer = arr[n - 1] * a + b;
					}
					if (answerCount == 2) {
						System.out.println("A");
						break label;
					}
					

				}
			}

			label:for(int a = -1; a >= -100; a--) {
				int b = arr[1] - arr[0] * a;
				boolean flag = true;
				for (int r = 1; r < n - 1; r++) {
					if (arr[r] * a + b != arr[r + 1]) {
						flag = false;
						break;
					}
				}
				if (flag) {
					if(answer != arr[n - 1] * a + b) {
						answerCount++;
						answer = arr[n - 1] * a + b;
					}
					if (answerCount == 2) {
						System.out.println("A");
						break label;
					}
				}
			}

			if (answerCount == 0) {
				System.out.println("B");
			} else if (answerCount == 1) {
				System.out.println(answer);
			}
		}

	}

}
