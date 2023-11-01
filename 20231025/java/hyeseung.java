import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 11668KB, 76ms	
public class B1111 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		String ans = String.valueOf(num[N - 1]);
		if(N > 2) {
			// 1번째 숫자 & 2번째 숫자 같은 경우 뒤에 다르면 B
			if(num[0] == num[1]) {
				for (int i = 2; i < num.length; i++) {
					if(num[i] != num[i - 1]) {
						ans = "B";
						break;
					}
				}
			}
			// 1번째 숫자 & 2번째 숫자 다른 경우
			else {
				// 2번째 숫자 & 3번째 숫자 같은 경우 뒤에 다르면 B 
				if(num[1] == num[2]) {
					for (int i = 3; i < N; i++) {
						if(num[i] != num[i - 1]) {
							ans = "B";
							break;
						}
					}
				}
				// 2번째 숫자 & 3번째 숫자 다른 경우
				else {
					double check = ((double) (num[1] - num[2])) / (num[0] - num[1]);
					// A가 정수인 경우
					if(Math.floor(check) == check) {
						int A = (int) check;
						int B = num[2] - num[1] * A;
						// 구한 A, B로 수를 구할 수 없는 경우 B
						for (int i = 3; i < N; i++) {
							if(A * num[i - 1] + B != num[i]) {
								ans = "B";
								break;
							}
						}
						// 모두다 구할 수 있으면 A * 이전 수 + B
						if(!ans.equals("B")) ans = String.valueOf(A * num[N - 1] + B);
					}
					// A가 정수가 아닌 경우 B
					else ans = "B";
				}
			}
		}
		// N이 1인 경우 & N이 2일 때 1번째 숫자와 2번째 숫자가 다른 경우 A
		else if(N == 1 || (N == 2 && num[0] != num[1])) {
			ans = "A";
		}
		// 결과 출력
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();		
	}
}
